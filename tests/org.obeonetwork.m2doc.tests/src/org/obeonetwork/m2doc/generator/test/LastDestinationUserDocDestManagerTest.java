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
package org.obeonetwork.m2doc.generator.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.obeonetwork.m2doc.generator.LastDestinationUserDocDestManager;
import org.obeonetwork.m2doc.parser.DocumentParserException;
import org.obeonetwork.m2doc.template.UserDocDest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.obeonetwork.m2doc.generator.LastDestinationUserDocDestManager.TEMP_DEST_SUFFIX;

/**
 * Tests the {@link LastDestinationUserDocDestManager} class.
 * 
 * @author ohaegi
 */
public class LastDestinationUserDocDestManagerTest {

    /**
     * Test With No Exist Last Destination File.
     * 
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     */
    @Test
    public void testWithNoExistLastDestinationFile() throws IOException, DocumentParserException {
        LastDestinationUserDocDestManager lastDestinationUserDocDestManager = new LastDestinationUserDocDestManager(
                "no_exist_file_path");

        assertNull(lastDestinationUserDocDestManager.getUserDocDest("noExistid1"));

    }

    /**
     * Test With Last Destination File Contain No UserDocDest.
     * 
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     */
    @Test
    public void testDeleteTempDestinationFile() throws IOException, DocumentParserException {
        String fileName = "testVarStyleSpanning2ParagraphsResult.docx";
        String filePath = "results/" + fileName;
        File destFile = new File(filePath);

        // Before LastDestinationUserDocDestManager creation temp file not exist
        File tempFile = findFirstTempFile(fileName, destFile);
        assertNull(tempFile);

        LastDestinationUserDocDestManager lastDestinationUserDocDestManager = new LastDestinationUserDocDestManager(
                filePath);

        // After LastDestinationUserDocDestManager creation temp file exist
        tempFile = findFirstTempFile(fileName, destFile);
        assertNotNull(tempFile);
        assertTrue(tempFile.exists());

        lastDestinationUserDocDestManager.deleteTempGeneratedFile();
        // After launch deleteTempGeneratedFile method temp file no exist
        assertFalse(tempFile.exists());

    }

    /**
     * Find First Temp File.
     * 
     * @param fileName
     *            fileName
     * @param destFile
     *            destFile
     * @return file with temp pattern in destFile folder
     */
    private File findFirstTempFile(String fileName, File destFile) {
        File tempFile = null;
        // Find first temp file
        for (File file : destFile.getParentFile().listFiles()) {
            if (file.getName().startsWith(fileName) && file.getName().endsWith(TEMP_DEST_SUFFIX)) {
                tempFile = file;
            }
        }
        return tempFile;
    }

    /**
     * Test With Last Destination File Contain No UserDocDest.
     * 
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     */
    @Test
    public void testLastDestinationFileContainNoUserDocDest() throws IOException, DocumentParserException {
        LastDestinationUserDocDestManager lastDestinationUserDocDestManager = new LastDestinationUserDocDestManager(
                "results/testVarStyleSpanning2ParagraphsResult.docx");

        assertNull(lastDestinationUserDocDestManager.getUserDocDest("noExistid2"));
        lastDestinationUserDocDestManager.deleteTempGeneratedFile();
    }

    /**
     * Test With Last Destination File Contain 1 UserDocDest.
     * 
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     */
    @Test
    public void testLastDestinationFileContainOneUserDocDest() throws IOException, DocumentParserException {
        LastDestinationUserDocDestManager lastDestinationUserDocDestManager = new LastDestinationUserDocDestManager(
                "results/testUserDocDest1.docx");

        assertNull(lastDestinationUserDocDestManager.getUserDocDest("noExistid2"));
        UserDocDest userDocDest = lastDestinationUserDocDestManager.getUserDocDest("value1");
        assertNotNull(userDocDest);
        assertEquals(1, userDocDest.getSubConstructs().size());
        assertEquals("User document part Texte 1", userDocDest.getSubConstructs().get(0).getRuns().get(0).getText(0));
        lastDestinationUserDocDestManager.deleteTempGeneratedFile();
    }

    /**
     * Test With Last Destination File Contain 3 UserDocDest.
     * 
     * @throws IOException
     *             IOException
     * @throws DocumentParserException
     *             DocumentParserException
     */
    @Test
    public void testLastDestinationFileContain3UserDocDest() throws IOException, DocumentParserException {
        LastDestinationUserDocDestManager lastDestinationUserDocDestManager = new LastDestinationUserDocDestManager(
                "results/testUserDocDest4.docx");

        assertNull(lastDestinationUserDocDestManager.getUserDocDest("noExistid2"));

        UserDocDest userDocDest = lastDestinationUserDocDestManager.getUserDocDest("value1");
        assertNotNull(userDocDest);
        assertEquals(1, userDocDest.getSubConstructs().size());
        assertEquals("User document part Texte 1", userDocDest.getSubConstructs().get(0).getRuns().get(0).getText(0));

        userDocDest = lastDestinationUserDocDestManager.getUserDocDest("value2");
        assertNotNull(userDocDest);
        assertEquals(1, userDocDest.getSubConstructs().size());
        assertEquals("User document part Texte 2", userDocDest.getSubConstructs().get(0).getRuns().get(0).getText(0));

        userDocDest = lastDestinationUserDocDestManager.getUserDocDest("value3");
        assertNotNull(userDocDest);
        assertEquals(1, userDocDest.getSubConstructs().size());
        assertEquals("User document part Texte 3", userDocDest.getSubConstructs().get(0).getRuns().get(0).getText(0));

        lastDestinationUserDocDestManager.deleteTempGeneratedFile();
    }

}
