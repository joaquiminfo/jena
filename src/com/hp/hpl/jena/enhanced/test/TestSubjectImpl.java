/*
  (c) Copyright 2002, Hewlett-Packard Company, all rights reserved.
  [See end of file]
  $Id: TestSubjectImpl.java,v 1.1.1.1 2002-12-19 19:13:19 bwm Exp $
*/

package com.hp.hpl.jena.enhanced.test;

import com.hp.hpl.jena.enhanced.*;
import com.hp.hpl.jena.graph.*;
/**
 * @see TestObjectImpl
 * @author  jjc
 */
public class TestSubjectImpl extends TestCommonImpl implements TestSubject {
    private static Type[] myTypes = new Type[]{
       TestSubject.type
    };
    public static final Implementation factory = new Implementation() {
    public Type[] implementedTypes() {
        return myTypes;
    }
    public EnhNode wrap(Node n,EnhGraph eg) {
        return new TestSubjectImpl(n,eg);
    }
};
    
    /** Creates a new instance of TestAllImpl */
    private TestSubjectImpl(Node n,EnhGraph eg) {
        super(n,eg,myTypes);
    }
    
    public boolean isSubject() {
        return find(S)!=null;
    }
    
    public TestProperty aProperty() {
        if (!isSubject())
            throw new IllegalStateException("Node is not the subject of a triple.");
        return (TestProperty)enhGraph.getNodeAs(find(S).getPredicate(),TestProperty.type);
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
