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
    
    int posx, posy;
    
    public NodoMatriz arriba;
    public NodoMatriz abajo;
    public NodoMatriz der;
    public NodoMatriz izq;
    
    public NodoMatriz(int x, int y)
    {
    posx = x;
    posy = y;
    
    arriba = null;
    abajo = null;
    der = null;
    izq = null;
    }
    
}
