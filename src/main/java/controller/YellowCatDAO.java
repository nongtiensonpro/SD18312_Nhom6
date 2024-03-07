/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;

/**
 *
 * @author Nong_Tien_Son
 */
public abstract class YellowCatDAO<M, K> {

    abstract public void insert(M model);
    
    abstract public void update(M model);
    
    abstract public void delete(K ID_Key);
    
    abstract public M selectByModel(M model);
    
    abstract public K selectByID(K ID_Key);
    
    abstract public List selectAll();
    
}
