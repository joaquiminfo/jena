/******************************************************************
 * File:        XSDLongType.java
 * Created by:  Dave Reynolds
 * Created on:  10-Dec-02
 * 
 * (c) Copyright 2002, Hewlett-Packard Company, all rights reserved.
 * [See end of file]
 * $Id: XSDLongType.java,v 1.1.1.1 2002-12-19 19:13:49 bwm Exp $
 *****************************************************************/
package com.hp.hpl.jena.graph.dt;

import com.hp.hpl.jena.graph.LiteralLabel;

/**
 * Datatype template used to define XSD long types
 * 
 * @author <a href="mailto:der@hplb.hpl.hp.com">Dave Reynolds</a>
 * @version $Revision: 1.1.1.1 $ on $Date: 2002-12-19 19:13:49 $
 */
public class XSDLongType extends XSDDatatype {
    
    /**
     * Constructor. 
     * @param typeName the name of the XSD type to be instantiated, this is 
     * used to lookup a type definition from the Xerces schema factory.
     */
    public XSDLongType(String typeName) {
        super(typeName);
    }
    
    /**
     * Constructor. 
     * @param typeName the name of the XSD type to be instantiated, this is 
     * used to lookup a type definition from the Xerces schema factory.
     * @param javaClass the java class for which this xsd type is to be
     * treated as the cannonical representation
     */
    public XSDLongType(String typeName, Class javaClass) {
        super(typeName, javaClass);
    }
    
    /**
     * Parse a lexical form of this datatype to a value
     * @throws DatatypeFormatException if the lexical form is not legal
     */
    public Object parse(String lexicalForm) throws DatatypeFormatException {        
        return new Long(super.parse(lexicalForm).toString());
    }
    
    /**
     * Compares two instances of values of the given datatype.
     * This ignores lang tags and just uses the java.lang.Number 
     * equality.
     */
    public boolean isEqual(LiteralLabel value1, LiteralLabel value2) {
       return value1.getValue().equals(value2.getValue());
    }

}

/*
    (c) Copyright Hewlett-Packard Company 2002
    All rights reserved.

    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions
    are met:

    1. Redistributions of source code must retain the above copyright
       notice, this list of conditions and the following disclaimer.

    2. Redistributions in binary form must reproduce the above copyright
       notice, this list of conditions and the following disclaimer in the
       documentation and/or other materials provided with the distribution.

    3. The name of the author may not be used to endorse or promote products
       derived from this software without specific prior written permission.

    THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
    IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
    OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
    IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
    NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
    DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
    THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
    (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
    THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
