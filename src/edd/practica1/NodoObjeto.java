/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.practica1;

/**
 *
 * @author OscarPC
 */
public class NodoObjeto {
    
    String nombre;
    String imagen;
    String tipo;
    
    NodoObjeto sig;
    NodoObjeto ant;
    
    public NodoObjeto(String nom, String img, String type)
    {
    nombre = nom;
    imagen = img;
    tipo = type;
    
    sig = null;
    ant = null;
    }
    
}
