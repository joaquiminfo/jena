/*
 * (c) Copyright 2002, Hewlett-Packard Company, all rights reserved.
 * [See end of file]
 */

/* Generated By:JJTree: Do not edit this line. Q_UnaryMinus.java */

package com.hp.hpl.jena.rdql.parser;

import com.hp.hpl.jena.rdql.* ;
import java.io.PrintWriter ;

class Q_UnaryMinus extends SimpleNode implements ExprNumeric
{
    Expr expr ;
    private String printName = "unaryminus" ;
    private String opSymbol = "-" ;

    Q_UnaryMinus(int id) { super(id); }

    Q_UnaryMinus(RDQLParser p, int id) { super(p, id); }

    public Value eval(Query q, ResultBinding env)
    {
        Value v = expr.eval(q, env) ;

        if ( ! v.isNumber() )
            throw new EvalTypeException("Q_UnaryMinus: Wanted a number: got "+expr) ;

        Settable result ;
        /* Further work needed : what is a variable name
         * bound to so that it does not get over written?
        if ( v instanceof Settable )
            result = (Settable)v ;
        else
        */
            result = new WorkingVar() ;

        if ( v.isInt() )
            result.setInt( - v.getInt() ) ;
        else
            result.setDouble( - v.getDouble() ) ;

        return result ;
    }

    public void jjtClose()
    {
        int n = jjtGetNumChildren() ;
        if ( n != 1 )
            throw new QueryException("Q_UnaryMinus: Wrong number of children: "+n) ;
        expr = (Expr)jjtGetChild(0) ;
    }

    public String asInfixString() { return QueryPrintUtils.asInfixString1(expr, printName, opSymbol) ; }

    public String asPrefixString() { return QueryPrintUtils.asPrefixString(expr, null, printName, opSymbol) ; }

    public void print(PrintWriter pw, int level) { QueryPrintUtils.print(pw, expr, null, printName, opSymbol, level) ; }

    public String toString() { return asInfixString() ; }
}

/*
 *  (c) Copyright Hewlett-Packard Company 2001
 *  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * This product includes software developed by the
 * Apache Software Foundation (http://www.apache.org/).
 *
 */
