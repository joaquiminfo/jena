/*
  (c) Copyright 2002, Hewlett-Packard Company, all rights reserved.
  [See end of file]
  $Id: ClosableIteratorImpl.java,v 1.1.1.1 2002-12-19 19:21:11 bwm Exp $
*/

package com.hp.hpl.jena.util.iterator;
import java.util.Iterator;
/**
 * @author jjchplb
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 */
public class ClosableIteratorImpl extends NiceIterator implements ClosableIterator {
    final protected Iterator underlying;
    public ClosableIteratorImpl(Iterator u) {
    	underlying = u;
    }
	/**
	 * @see ClosableIterator#close()
	 */
	public void close() {
		if (underlying instanceof ClosableIterator)
		  ((ClosableIterator)underlying).close();
	}

	/**
	 * @see Iterator#hasNext()
	 */
	public boolean hasNext() {
		return underlying.hasNext();
	}

	/**
	 * @see Iterator#next()
	 */
	public Object next() {
		return underlying.next();
	}

	/**
	 * @see Iterator#remove()
	 */
	public void remove() {
		underlying.remove();
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
