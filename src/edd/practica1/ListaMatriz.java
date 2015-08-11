package edd.practica1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OscarPC
 */
public class ListaMatriz {
    
    public NodoMatriz cabeza;
    //public NodoMatriz cabezacolumna;
    public NodoMatriz finfila;
    public NodoMatriz fincolumna;
    
    
    public ListaMatriz()
    {
    cabeza = null;
    //cabezacolumna = null;
    finfila = null;
    fincolumna = null;
    }
    
    public boolean MatrizVacia()
    {
    boolean vacia = false;
    if(cabeza == null)
    {
    vacia = true;
    }
    return vacia;
        
    }
    
    
    
    
}
