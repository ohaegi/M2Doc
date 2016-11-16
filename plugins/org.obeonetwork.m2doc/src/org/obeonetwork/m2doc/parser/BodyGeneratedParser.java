/*******************************************************************************
 *  Copyright (c) 2016 Obeo. 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *       Obeo - initial API and implementation
 *  
 *******************************************************************************/
package org.obeonetwork.m2doc.parser;

import com.google.common.collect.Lists;

import java.util.List;

import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.m2doc.template.Compound;
import org.obeonetwork.m2doc.template.TemplatePackage;
import org.obeonetwork.m2doc.template.UserDocDest;

import static org.obeonetwork.m2doc.util.M2DocUtils.message;

/**
 * Body parser for destination document (result of M2Doc generation document).
 * This
 * 
 * @author Romain Guider
 */
public class BodyGeneratedParser extends BodyAbstractParser {

    /**
     * Creates a new {@link BodyGeneratedParser} instance.
     * 
     * @param inputDocument
     *            the input template to parser
     * @param queryEnvironment
     *            the query environment to used during parsing.
     */
    public BodyGeneratedParser(IBody inputDocument, IQueryEnvironment queryEnvironment) {
        super(inputDocument, queryEnvironment);
    }

    /**
     * Creates a new {@link BodyGeneratedParser} instance.
     * 
     * @param inputDocument
     *            the input template to parser
     * @param queryParser
     *            the query parser to use during parsing
     * @param queryEnvironment
     *            The {@link IQueryEnvironment}
     */
    BodyGeneratedParser(IBody inputDocument, IQueryBuilderEngine queryParser, IQueryEnvironment queryEnvironment) {
        super(inputDocument, queryParser, queryEnvironment);
    }

    /**
     * returns the next token type after index.
     * 
     * @param index
     *            index
     * @return the next token type.
     */
    @Override
    protected TokenType getNextTokenType(int index) {
        ParsingToken token = runIterator.lookAhead(index);
        TokenType result;
        if (token == null) {
            result = TokenType.EOF;
        } else if (token.getKind() == ParsingTokenKind.TABLE) {
            result = TokenType.WTABLE;
        } else {
            XWPFRun run = token.getRun();
            // is run a field begin run
            if (fieldUtils.isFieldBegin(run)) {
                String code = fieldUtils.lookAheadTag(index, runIterator);
                if (code.startsWith(TokenType.ENDUSERDOCDEST.getValue())) {
                    result = TokenType.ENDUSERDOCDEST;
                } else if (code.startsWith(TokenType.USERDOCDEST.getValue())) {
                    result = TokenType.USERDOCDEST;
                } else {
                    result = TokenType.STATIC;
                }
            } else {
                result = TokenType.STATIC;
            }
        }
        return result;
    }

    /**
     * Parses a compound object.
     * 
     * @param compound
     *            the compound to parse
     * @param endTypes
     *            the token types that mark the end of the parsed compound
     * @throws DocumentParserException
     *             if a problem occurs while parsing.
     */
    @Override
    protected void parseCompound(Compound compound, TokenType... endTypes) throws DocumentParserException {
        TokenType type = getNextTokenType();
        List<TokenType> endTypeList = Lists.newArrayList(endTypes);
        while (!endTypeList.contains(type)) {
            switch (type) {
                case USERDOCDEST:
                    compound.getSubConstructs().add(parseUserDocDest());
                    break;
                case ENDUSERDOCDEST:
                    // report the error and ignore the problem so that parsing
                    // continues in other parts of the document.
                    XWPFRun run = runIterator.lookAhead(1).getRun();
                    if (run == null) {
                        throw new IllegalStateException(
                                "Token of type " + type + " detected. Run shouldn't be null at this place.");
                    }
                    compound.getValidationMessages().add(new TemplateValidationMessage(ValidationMessageLevel.ERROR,
                            message(ParsingErrorMessage.UNEXPECTEDTAG, type.getValue()), run));
                    readTag(compound, compound.getRuns());
                    break;
                case EOF:
                    final XWPFParagraph lastParagraph = document.getParagraphs()
                            .get(document.getParagraphs().size() - 1);
                    final XWPFRun lastRun = lastParagraph.getRuns().get(lastParagraph.getRuns().size() - 1);
                    compound.getValidationMessages().add(new TemplateValidationMessage(ValidationMessageLevel.ERROR,
                            message(ParsingErrorMessage.UNEXPECTEDTAG, type), lastRun));
                    return;
                case STATIC:
                    compound.getSubConstructs().add(parseStaticFragment());
                    break;
                case WTABLE:
                    compound.getSubConstructs().add(parseTable(runIterator.next().getTable()));
                    break;
                default:
                    throw new UnsupportedOperationException(
                            String.format("Developer error: TokenType %s is not supported", type));
            }
            type = getNextTokenType();
        }
    }

    /**
     * Parses a user Document destination part.
     * user Document destination part are made of the following set of tags : {m:userdocdest id} ...
     * ... {m:enduserdocdest}.
     * userdocdest is generated by M2Doc and the parser extract user document part.
     * 
     * @author ohaegi
     * @return the created object
     * @throws DocumentParserException
     *             if something wrong happens during parsing.
     */
    private UserDocDest parseUserDocDest() throws DocumentParserException {
        // first read the tag that opens the link
        final UserDocDest userDocDest = (UserDocDest) EcoreUtil.create(TemplatePackage.Literals.USER_DOC_DEST);
        String tagText = readTag(userDocDest, userDocDest.getRuns()).trim();
        // remove the prefix
        tagText = tagText.substring(TokenType.USERDOCDEST.getValue().length()).trim();

        if (tagText == null || "".equals(tagText)) {
            final XWPFRun lastRun = userDocDest.getRuns().get(userDocDest.getRuns().size() - 1);
            TemplateValidationMessage templateValidationMessage = new TemplateValidationMessage(
                    ValidationMessageLevel.WARNING, ParsingErrorMessage.INVALID_USERDOCDEST_VALUE.getMessage(),
                    lastRun);
            userDocDest.getValidationMessages().add(templateValidationMessage);
        } else {
            userDocDest.setId(tagText);
        }

        // read up the tags until the "m:enduserdoc" tag is encountered.
        parseCompound(userDocDest, TokenType.ENDUSERDOCDEST);
        if (getNextTokenType() != TokenType.EOF) {
            readTag(userDocDest, userDocDest.getClosingRuns());
        }

        return userDocDest;
    }
}
