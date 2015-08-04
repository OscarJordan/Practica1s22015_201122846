/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.practica1;

import javax.swing.JOptionPane;

/**
 *
 * @author OscarPC
 */
public class ListaDoble {
    
    public static NodoObjeto cabeza;
    
    public ListaDoble()
    {
    cabeza = null;
    }
           
    public boolean ListaVacia()
    {
    boolean vacio = false;
        if(cabeza == null)
        {
        vacio = true;
        }
        return vacio;
    }
    
    public void IngresarNuevo(String nombre, String imagen, String tipo)
    {
    NodoObjeto nuevo = new NodoObjeto(nombre, imagen, tipo);
    if(ListaVacia())
    {
    cabeza = nuevo;
    JOptionPane.showMessageDialog(null, "Ingresando cabeza!");
    JOptionPane.showMessageDialog(null, cabeza.imagen + ", " + cabeza.nombre + ", " + cabeza.tipo);
    }
    else
    {
    NodoObjeto aux;
    aux = cabeza;
    while(aux.sig != null)
    {
    aux = aux.sig;
    }
    nuevo.ant = aux.sig;
    nuevo.sig = null;
    JOptionPane.showMessageDialog(null, "Ingresando nodo!");
    JOptionPane.showMessageDialog(null, nuevo.imagen + ", " + nuevo.nombre + ", " + nuevo.tipo);
    }    
       
        
    }
}
