/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.myinterface;

import java.util.ArrayList;

/**
 *
 * @author NTV
 */
public interface BaseDaoInterFace<T,K> {
    public boolean insert(T e)throws Exception;
    public boolean update(T e)throws Exception;
    public boolean delete(K key)throws Exception;
    public T selectById(K key)throws Exception;
    public ArrayList<T> selectAll()throws Exception;
    public ArrayList<T> selectByquery(String query,Object...args)throws Exception;
}
