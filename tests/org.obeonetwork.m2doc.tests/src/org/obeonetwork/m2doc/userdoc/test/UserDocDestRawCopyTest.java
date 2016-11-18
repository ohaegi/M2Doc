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
package org.obeonetwork.m2doc.userdoc.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.XmlException;
import org.junit.Test;
import org.obeonetwork.m2doc.api.POIServices;
import org.obeonetwork.m2doc.generator.UserDocDestManager;
import org.obeonetwork.m2doc.generator.UserDocDestRawCopy;
import org.obeonetwork.m2doc.parser.DocumentParserException;
import org.obeonetwork.m2doc.template.UserDocDest;

import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link UserDocDestRawCopy} class.
 * 
 * @author ohaegi
 */
public class UserDocDestRawCopyTest {

    /**
     * Test copy.
     * 
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     * @throws XmlException
     * @throws InvalidFormatException
     */
    @Test
    // CHECKSTYLE:OFF
    public void test() throws IOException, DocumentParserException, InvalidFormatException, XmlException {
        String filePath = "userDocDest/testUserDocDest2.docx";
        UserDocDestManager userDocDestManager = new UserDocDestManager(filePath);
        UserDocDest userDocDest = userDocDestManager.getUserDocDest("value1");

        // Create an empty document
        XWPFDocument document = new XWPFDocument();
        // Create an empty document
        XWPFParagraph paragraph = document.createParagraph();

        // Launch copy
        UserDocDestRawCopy userDocDestRawCopy = new UserDocDestRawCopy();
        userDocDestRawCopy.copy(userDocDest, paragraph);

        String resultFilePath = "results/generated/testUserDoc2RowCopyResultat.docx";
        POIServices.getInstance().saveFile(document, resultFilePath);
        document.close();

        userDocDestManager.deleteTempGeneratedFile();

        // Reopen document
        FileInputStream is = new FileInputStream(resultFilePath);
        OPCPackage oPackage = OPCPackage.open(is);
        @SuppressWarnings("resource")
        XWPFDocument documentResult = new XWPFDocument(oPackage);

        assertEquals("User document part Texte 1", documentResult.getParagraphs().get(1).getText());
        assertEquals("User document part Texte 2", documentResult.getParagraphs().get(5).getText());
        assertEquals(1, documentResult.getAllPictures().size());
        String picId = documentResult.getAllPictures().get(0).getPackageRelationship().getId();
        assertEquals(picId, documentResult.getParagraphs().get(3).getRuns().get(0).getEmbeddedPictures().get(0)
                .getCTPicture().getBlipFill().getBlip().getEmbed());

    }
    // CHECKSTYLE:ON

}
