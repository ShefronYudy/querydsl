/*
 * Copyright (c) 2008 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query;

import java.util.ArrayList;
import java.util.List;

import com.mysema.query.grammar.Types.ExprBoolean;
import com.mysema.query.grammar.Types.ExprEntity;
import com.mysema.query.grammar.Types.Expr;
import com.mysema.query.grammar.Types.OrderSpecifier;
/**
 * QueryBase provides a basic implementation of the Query interface
 *
 * @author tiwe
 * @version $Id$
 */
@SuppressWarnings("unchecked")
public class QueryBase<A extends QueryBase<A>> implements Query<A> {
    public enum JoinType{
        DEFAULT,IJ,LJ,J
    }
    
    public class JoinExpression{
        public final JoinType type;
        public final ExprEntity<?> target;
        JoinExpression(JoinType type, ExprEntity<?> target){
            this.type = type;
            this.target = target;
        }
        public ExprBoolean[] conditions;
    }
    
    protected List<JoinExpression> joins = new ArrayList<JoinExpression>();
    protected Expr<?>[] groupBy;
    protected ExprBoolean[] having;
    protected OrderSpecifier<?>[] orderBy;
    protected Expr<?>[] select;
    protected ExprBoolean[] where;
    
    protected void clear(){
        joins.clear();
        groupBy = null;
        having = null;
        orderBy = null;
        select = null;
        where = null;
    }
    
    public A from(ExprEntity<?>... o) {
        for (ExprEntity<?> expr : o){
            joins.add(new JoinExpression(JoinType.DEFAULT,expr));
        }
        return (A) this;
    }

    public A groupBy(Expr<?>... o) {
        groupBy = o;
        return (A) this;
    }

    public A having(ExprBoolean... o) {
        having = o;
        return (A) this;
    }


    public A orderBy(OrderSpecifier<?>... o) {
        orderBy = o;
        return (A) this;
    }

    public A select(Expr<?>... o) {
        select = o;
        return (A) this;
    }
    
    public A where(ExprBoolean... o) {
        where = o;
        return (A) this;
    }
    
}
