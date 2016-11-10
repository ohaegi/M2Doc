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
package org.obeonetwork.m2doc.generator;

/**
 * This class manage UserDoc Destination tag.
 * It launch destination parsing doc and keep map of UserDoc id / UserDocDestination EObject element.
 * Be careful, parsing must be done on a copy of destination document because old destination document is remove by generation.
 * 
 * @author ohaegi
 */
public class UserDocDestinationManager {
    // TODO initialize class
    // TODO copy in temporary file old destination document
    // TODO parse old destination document
    // TODO raise warning if old destination document have not just one UserDocDest by ID
    // TODO Develop method taken a is and give UserDocDest EObject element (UserDocDest EObject element contain Static element)
    // TODO Develop function to clean temporary file old destination document at the end of
}
