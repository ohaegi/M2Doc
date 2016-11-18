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
package org.obeonetwork.m2doc.parser.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.junit.Test;
import org.obeonetwork.m2doc.parser.BodyGeneratedParser;
import org.obeonetwork.m2doc.parser.DocumentParserException;
import org.obeonetwork.m2doc.parser.ValidationMessageLevel;
import org.obeonetwork.m2doc.template.StaticFragment;
import org.obeonetwork.m2doc.template.Table;
import org.obeonetwork.m2doc.template.Template;
import org.obeonetwork.m2doc.template.UserDocDest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link BodyGeneratedParser} class.
 * 
 * @author ohaegi
 */
public class DocumentGeneratedParserTest {

    /**
     * AQL query environment.
     */
    private IQueryEnvironment env = org.eclipse.acceleo.query.runtime.Query.newEnvironmentWithDefaultServices(null);

    /**
     * Test parsing userDocDest tag in M2Doc generated document.
     * 
     * @throws InvalidFormatException
     *             InvalidFormatException
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     */
    @Test
    public void testUserDocDestSimple() throws InvalidFormatException, IOException, DocumentParserException {
        FileInputStream is = new FileInputStream("userDocDest/testUserDocDest1.docx");
        OPCPackage oPackage = OPCPackage.open(is);
        XWPFDocument document = new XWPFDocument(oPackage);
        BodyGeneratedParser parser = new BodyGeneratedParser(document, env);
        Template template = parser.parseTemplate();
        assertEquals(document, template.getBody());
        assertEquals(3, template.getSubConstructs().size());
        assertTrue(template.getSubConstructs().get(0) instanceof StaticFragment);
        assertTrue(template.getSubConstructs().get(1) instanceof UserDocDest);
        assertTrue(template.getSubConstructs().get(2) instanceof StaticFragment);
        UserDocDest userDocDest = (UserDocDest) template.getSubConstructs().get(1);
        assertNotNull(userDocDest.getId());
        assertTrue(userDocDest.getId() instanceof String);
        // CHECKSTYLE:OFF
        assertEquals("value1", userDocDest.getId());
        // CHECKSTYLE:ON
        assertEquals(1, userDocDest.getSubConstructs().size());
        assertTrue(userDocDest.getSubConstructs().get(0) instanceof StaticFragment);
        String contentValue1 = userDocDest.getSubConstructs().get(0).getRuns().get(0).getText(0);
        assertEquals("User document part Texte 1", contentValue1);
    }

    /**
     * Test parsing userDocDest tag in M2Doc generated document with image in tag.
     * 
     * @throws InvalidFormatException
     *             InvalidFormatException
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     */
    @Test
    public void testUserDocDestImage() throws InvalidFormatException, IOException, DocumentParserException {
        FileInputStream is = new FileInputStream("userDocDest/testUserDocDest2.docx");
        OPCPackage oPackage = OPCPackage.open(is);
        XWPFDocument document = new XWPFDocument(oPackage);
        BodyGeneratedParser parser = new BodyGeneratedParser(document, env);
        Template template = parser.parseTemplate();
        assertEquals(document, template.getBody());
        assertEquals(3, template.getSubConstructs().size());
        assertTrue(template.getSubConstructs().get(0) instanceof StaticFragment);
        assertTrue(template.getSubConstructs().get(1) instanceof UserDocDest);
        assertTrue(template.getSubConstructs().get(2) instanceof StaticFragment);
        UserDocDest userDocDest = (UserDocDest) template.getSubConstructs().get(1);
        assertNotNull(userDocDest.getId());
        assertTrue(userDocDest.getId() instanceof String);
        assertEquals("value1", userDocDest.getId());
        assertEquals(1, userDocDest.getSubConstructs().size());
        assertTrue(userDocDest.getSubConstructs().get(0) instanceof StaticFragment);
        String contentValue1 = userDocDest.getSubConstructs().get(0).getRuns().get(0).getText(0);
        assertEquals("User document part Texte 1", contentValue1);
        assertEquals(1, userDocDest.getSubConstructs().get(0).getRuns().get(2).getEmbeddedPictures().size());
        // CHECKSTYLE:OFF
        assertEquals(new Long(1829750042), userDocDest.getSubConstructs().get(0).getRuns().get(2).getEmbeddedPictures()
                .get(0).getPictureData().getChecksum());
        // CHECKSTYLE:ON
    }

    /**
     * Test parsing userDocDest tag in M2Doc generated document with table in tag.
     * 
     * @throws InvalidFormatException
     *             InvalidFormatException
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     */
    @Test
    public void testUserDocDestTable() throws InvalidFormatException, IOException, DocumentParserException {
        FileInputStream is = new FileInputStream("userDocDest/testUserDocDest3.docx");
        OPCPackage oPackage = OPCPackage.open(is);
        XWPFDocument document = new XWPFDocument(oPackage);
        BodyGeneratedParser parser = new BodyGeneratedParser(document, env);
        Template template = parser.parseTemplate();
        assertEquals(document, template.getBody());
        assertEquals(3, template.getSubConstructs().size());
        assertTrue(template.getSubConstructs().get(0) instanceof StaticFragment);
        assertTrue(template.getSubConstructs().get(1) instanceof UserDocDest);
        assertTrue(template.getSubConstructs().get(2) instanceof StaticFragment);
        UserDocDest userDocDest = (UserDocDest) template.getSubConstructs().get(1);
        assertNotNull(userDocDest.getId());
        assertTrue(userDocDest.getId() instanceof String);
        assertEquals("value1", userDocDest.getId());
        assertEquals(3, userDocDest.getSubConstructs().size());
        assertTrue(userDocDest.getSubConstructs().get(0) instanceof StaticFragment);
        assertTrue(userDocDest.getSubConstructs().get(1) instanceof Table);
        assertTrue(userDocDest.getSubConstructs().get(2) instanceof StaticFragment);
        Table table = (Table) userDocDest.getSubConstructs().get(1);
        String cellContent1 = table.getRows().get(0).getCells().get(0).getTableCell().getText();
        assertEquals("Un", cellContent1);
        String cellContent2 = table.getRows().get(0).getCells().get(2).getTableCell().getText();
        assertEquals("3", cellContent2);
    }

    /**
     * Test parsing userDocDest tag with no unique id (2 times the same id).
     * 
     * @throws InvalidFormatException
     *             InvalidFormatException&
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     */
    @Test
    public void testUserDocWithNoUniqueId2() throws InvalidFormatException, IOException, DocumentParserException {
        FileInputStream is = new FileInputStream("templates/testUserDocDest4.docx");
        OPCPackage oPackage = OPCPackage.open(is);
        XWPFDocument document = new XWPFDocument(oPackage);
        BodyGeneratedParser parser = new BodyGeneratedParser(document, env);
        Template template = parser.parseTemplate();
        assertEquals(document, template.getBody());
        assertEquals(4, template.getSubConstructs().size());
        assertTrue(template.getSubConstructs().get(0) instanceof StaticFragment);
        assertTrue(template.getSubConstructs().get(1) instanceof UserDocDest);
        assertTrue(template.getSubConstructs().get(2) instanceof UserDocDest);
        assertTrue(template.getSubConstructs().get(3) instanceof StaticFragment);
        UserDocDest userDoc1 = (UserDocDest) template.getSubConstructs().get(1);
        assertEquals(0, userDoc1.getValidationMessages().size());
        UserDocDest userDoc2 = (UserDocDest) template.getSubConstructs().get(2);
        assertEquals(1, userDoc2.getValidationMessages().size());
        assertEquals(ValidationMessageLevel.WARNING, userDoc2.getValidationMessages().get(0).getLevel());
        // CHECKSTYLE:OFF
        assertEquals("userdoc tag must have unique id value. 'value1' id already exists in document",
                userDoc2.getValidationMessages().get(0).getMessage());
        // CHECKSTYLE:ON
        assertEquals(userDoc2.getRuns().get(userDoc2.getRuns().size() - 1),
                userDoc2.getValidationMessages().get(0).getLocation());

    }

    /**
     * Test parsing userDocDest tag with no unique id (2 times the same id).
     * 
     * @throws InvalidFormatException
     *             InvalidFormatException&
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     */
    @Test
    public void testUserDocWithNoUniqueId3() throws InvalidFormatException, IOException, DocumentParserException {
        FileInputStream is = new FileInputStream("templates/testUserDocDest5.docx");
        OPCPackage oPackage = OPCPackage.open(is);
        XWPFDocument document = new XWPFDocument(oPackage);
        BodyGeneratedParser parser = new BodyGeneratedParser(document, env);
        Template template = parser.parseTemplate();
        assertEquals(document, template.getBody());
        assertEquals(5, template.getSubConstructs().size());
        assertTrue(template.getSubConstructs().get(0) instanceof StaticFragment);
        assertTrue(template.getSubConstructs().get(1) instanceof UserDocDest);
        assertTrue(template.getSubConstructs().get(2) instanceof UserDocDest);
        assertTrue(template.getSubConstructs().get(3) instanceof UserDocDest);
        assertTrue(template.getSubConstructs().get(4) instanceof StaticFragment);
        UserDocDest userDoc1 = (UserDocDest) template.getSubConstructs().get(1);
        assertEquals(0, userDoc1.getValidationMessages().size());
        UserDocDest userDoc2 = (UserDocDest) template.getSubConstructs().get(2);
        assertEquals(1, userDoc2.getValidationMessages().size());
        assertEquals(ValidationMessageLevel.WARNING, userDoc2.getValidationMessages().get(0).getLevel());
        assertEquals("userdoc tag must have unique id value. 'value1' id already exists in document",
                userDoc2.getValidationMessages().get(0).getMessage());
        assertEquals(userDoc2.getRuns().get(userDoc2.getRuns().size() - 1),
                userDoc2.getValidationMessages().get(0).getLocation());
        UserDocDest userDoc3 = (UserDocDest) template.getSubConstructs().get(3);
        assertEquals(1, userDoc2.getValidationMessages().size());
        assertEquals(ValidationMessageLevel.WARNING, userDoc3.getValidationMessages().get(0).getLevel());
        assertEquals("userdoc tag must have unique id value. 'value1' id already exists in document",
                userDoc3.getValidationMessages().get(0).getMessage());
        assertEquals(userDoc3.getRuns().get(userDoc2.getRuns().size() - 1),
                userDoc3.getValidationMessages().get(0).getLocation());
    }

    /**
     * Test parsing userDocDest tag without end of tag.
     * 
     * @throws InvalidFormatException
     *             InvalidFormatException&
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     */
    @Test
    public void testUserDocWithNoEndOfTag() throws InvalidFormatException, IOException, DocumentParserException {
        FileInputStream is = new FileInputStream("templates/testUserDocDest6.docx");
        OPCPackage oPackage = OPCPackage.open(is);
        XWPFDocument document = new XWPFDocument(oPackage);
        BodyGeneratedParser parser = new BodyGeneratedParser(document, env);
        Template template = parser.parseTemplate();
        assertTrue(template.getSubConstructs().get(1) instanceof UserDocDest);
        UserDocDest userDocDest = (UserDocDest) template.getSubConstructs().get(1);
        assertTrue(userDocDest.getClosingRuns().isEmpty());
        assertEquals(ValidationMessageLevel.ERROR, userDocDest.getValidationMessages().get(0).getLevel());
        assertEquals("Unexpected tag EOF at this location", userDocDest.getValidationMessages().get(0).getMessage());
        XWPFRun lastRunInContent = userDocDest.getSubConstructs().get(0).getRuns()
                .get(userDocDest.getSubConstructs().get(0).getRuns().size() - 1);
        assertEquals(lastRunInContent, userDocDest.getValidationMessages().get(0).getLocation());

    }

    /**
     * Test parsing enduserDocDest tag alone.
     * 
     * @throws InvalidFormatException
     *             InvalidFormatException&
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     */
    @Test
    public void testEndUserDocAlone() throws InvalidFormatException, IOException, DocumentParserException {
        FileInputStream is = new FileInputStream("templates/testUserDocDest7.docx");
        OPCPackage oPackage = OPCPackage.open(is);
        XWPFDocument document = new XWPFDocument(oPackage);
        BodyGeneratedParser parser = new BodyGeneratedParser(document, env);
        Template template = parser.parseTemplate();
        assertTrue(template.getSubConstructs().get(0) instanceof StaticFragment);
        assertEquals(0, template.getSubConstructs().get(0).getValidationMessages().size());
        assertTrue(template.getSubConstructs().get(1) instanceof StaticFragment);
        assertEquals(0, template.getSubConstructs().get(1).getValidationMessages().size());
    }
}
