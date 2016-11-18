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

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.obeonetwork.m2doc.generator.UserDocDestManager;
import org.obeonetwork.m2doc.parser.DocumentParserException;
import org.obeonetwork.m2doc.template.UserDocDest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.obeonetwork.m2doc.generator.UserDocDestManager.TEMP_DEST_SUFFIX;

/**
 * Tests the {@link UserDocDestManager} class.
 * 
 * @author ohaegi
 */
public class UserDocDestManagerTest {

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
        UserDocDestManager userDocDestManager = new UserDocDestManager("no_exist_file_path");

        assertNull(userDocDestManager.getUserDocDest("noExistid1"));

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
        String fileName = "testUserDocDest2.docx";
        String filePath = "userDocDest/" + fileName;
        File destFile = new File(filePath);

        // Before userDocDestManager creation temp file not exist
        File tempFile = findFirstTempFile(fileName, destFile);
        assertNull(tempFile);

        UserDocDestManager userDocDestManager = new UserDocDestManager(filePath);

        // After userDocDestManager creation temp file exist
        tempFile = findFirstTempFile(fileName, destFile);
        assertNotNull(tempFile);
        assertTrue(tempFile.exists());

        userDocDestManager.deleteTempGeneratedFile();
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
        UserDocDestManager userDocDestManager = new UserDocDestManager("userDocDest/testUserDocDest2.docx");
        // CHECKSTYLE:OFF
        assertNull(userDocDestManager.getUserDocDest("noExistid2"));
        // CHECKSTYLE:ON
        userDocDestManager.deleteTempGeneratedFile();
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
        UserDocDestManager userDocDestManager = new UserDocDestManager("userDocDest/testUserDocDest1.docx");

        assertNull(userDocDestManager.getUserDocDest("noExistid2"));
        UserDocDest userDocDest = userDocDestManager.getUserDocDest("value1");
        assertNotNull(userDocDest);
        assertEquals(1, userDocDest.getSubConstructs().size());
        assertEquals("User document part Texte 1", userDocDest.getSubConstructs().get(0).getRuns().get(0).getText(0));
        userDocDestManager.deleteTempGeneratedFile();
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
        UserDocDestManager userDocDestManager = new UserDocDestManager("userDocDest/testUserDocDest4.docx");

        assertNull(userDocDestManager.getUserDocDest("noExistid2"));

        UserDocDest userDocDest = userDocDestManager.getUserDocDest("value1");
        assertNotNull(userDocDest);
        assertEquals(1, userDocDest.getSubConstructs().size());
        assertEquals("User document part Texte 1", userDocDest.getSubConstructs().get(0).getRuns().get(0).getText(0));

        userDocDest = userDocDestManager.getUserDocDest("value2");
        assertNotNull(userDocDest);
        assertEquals(1, userDocDest.getSubConstructs().size());
        assertEquals("User document part Texte 2", userDocDest.getSubConstructs().get(0).getRuns().get(0).getText(0));

        userDocDest = userDocDestManager.getUserDocDest("value3");
        assertNotNull(userDocDest);
        assertEquals(1, userDocDest.getSubConstructs().size());
        assertEquals("User document part Texte 3", userDocDest.getSubConstructs().get(0).getRuns().get(0).getText(0));

        userDocDestManager.deleteTempGeneratedFile();
    }

}
