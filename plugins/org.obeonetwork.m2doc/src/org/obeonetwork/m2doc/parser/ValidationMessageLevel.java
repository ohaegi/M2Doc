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

/**
 * {@link TemplateValidationMessage} level.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public enum ValidationMessageLevel {

    /**
     * used for simple information message.
     */
    INFO,

    /**
     * used to report potential errors (error that can occur in certain cases but that do not * always occur).
     */
    WARNING,

    /**
     * used to report errors that will most probably occur.
     */
    ERROR;

}
