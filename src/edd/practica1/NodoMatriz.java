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
public class NodoMatriz {
    
    int posx, posy, dato;
    
    public NodoMatriz arriba;
    public NodoMatriz abajo;
    public NodoMatriz sig;
    public NodoMatriz ant;
    
    public NodoMatriz(int x, int y, int data)
    {
    posx = x;
    posy = y;
    dato = data;
    
    arriba = null;
    abajo = null;
    sig = null;
    ant = null;
    }
    
}
