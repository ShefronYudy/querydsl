/*
 * Copyright (c) 2008 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.grammar;

import com.mysema.query.grammar.Types.*;

/**
 * VisitorAdapter provides a base implementation where invocations are dispatched
 * to supertypes when available and visible
 *
 * @author tiwe
 * @version $Id$
 */
public abstract class VisitorAdapter<V extends VisitorAdapter<V>> extends Visitor<V>{
    
    @Override
    protected void visit(AliasNoEntity<?> expr) {
        visit((Alias<?>)expr);        
    }
    
    @Override
    protected void visit(AliasCollection<?> expr){
        visit((Alias<?>)expr);
    }
    
    @Override
    protected void visit(AliasEntity<?> expr) {
        visit((Alias<?>)expr);        
    }
    
    @Override
    protected void visit(OperationBinaryBoolean<?,?> expr) {
        visit((OperationBinary<?,?,?,?>)expr);
    }
    
    @Override
    protected void visit(PathBoolean expr) {
        visit((Path<?>)expr);     
    }
    
    @Override
    protected void visit(PathEntityCollection<?> expr){
        visit((Path<?>)expr);
    }
    
    @Override
    protected void visit(PathEntity<?> expr) {
        visit((Path<?>)expr);        
    }
    
    @Override
    protected void visit(PathNoEntity<?> expr) {
        visit((Path<?>)expr);        
    }
    
    @Override
    protected void visit(OperationTertiaryBoolean<?,?,?> expr) {
        visit((OperationTertiary<?,?,?,?,?>)expr);
    }
    
    @Override
    protected void visit(OperationUnaryBoolean<?> expr) {
        visit((OperationUnary<?,?,?>)expr);        
    }
    
}
