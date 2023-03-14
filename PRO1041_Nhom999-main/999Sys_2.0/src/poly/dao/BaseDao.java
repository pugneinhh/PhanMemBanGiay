/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poly.helper.XJDBC;
import poly.myinterface.BaseDaoInterFace;

/**
 *
 * @author NTV
 */
public abstract class BaseDao<T, K> implements BaseDaoInterFace<T, K> {

    public abstract String getQuery(String action);

    public abstract Object[] getParams(String action, T obj);

    public abstract T createEntity(final ResultSet rs)throws SQLException;

    @Override
    public boolean insert(T e) throws Exception {
        return XJDBC.update(this.getQuery("INSERT"), this.getParams("INSERT", e)) > 0;
    }

    @Override
    public boolean update(T e) throws Exception {
        return XJDBC.update(this.getQuery("UPDATE"), this.getParams("UPDATE", e)) > 0;
    }

    @Override
    public boolean delete(K key) throws Exception {
        return XJDBC.update(this.getQuery("DELETE"), key) > 0;
    }

    @Override
    public T selectById(K key) throws Exception {
        ResultSet rs= XJDBC.query(this.getQuery("SELECTBYID"), key);
        if(rs.next()){
            T e = createEntity(rs);
            return e;
        }
        rs.getStatement().getConnection().close();
        return null;
    }

    @Override
    public ArrayList<T> selectAll() throws Exception {
        ArrayList<T> list = new ArrayList<>();
        ResultSet rs = XJDBC.query(this.getQuery("SELECTALL"));
        while(rs.next()){
            T e1 = createEntity(rs);
            list.add(e1);
        }
        rs.getStatement().getConnection().close();
        return list;
        }

    @Override
    public ArrayList<T> selectByquery(String query, Object... args) throws Exception {
        ArrayList<T> list = new ArrayList<>();
        ResultSet rs = XJDBC.query(this.getQuery(query), args);
        while(rs.next()){
            T e2 = createEntity(rs);
            list.add(e2);
        }
        rs.getStatement().getConnection().close();
        return list;
    }

}
