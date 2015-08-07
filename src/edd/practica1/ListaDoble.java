/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.practica1;

import javax.swing.JOptionPane;
import edd.practica1.NodoObjeto;


/**
 *
 * @author OscarPC
 */
public class ListaDoble {
    
    public NodoObjeto cabeza;
    public NodoObjeto fin;
    
    public ListaDoble()
    {
    cabeza = null;
    fin = null;
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
     fin = nuevo;
     //JOptionPane.showMessageDialog(null, "Cabeza: " + ListaDoble.cabeza.nombre);
     }
     else if(cabeza.sig==null)
     {
     fin = nuevo;
     cabeza.sig = fin;
     fin.ant = cabeza;
     }
     else
     {
     nuevo.ant = fin;
     fin.sig = nuevo;
     fin = nuevo;
     //JOptionPane.showMessageDialog(null, "Cabeza sig: " + cabeza.sig.nombre);
     //JOptionPane.showMessageDialog(null, "Ant fin: " + fin.ant.nombre);
     }
     
     fin.sig = null;
     //JOptionPane.showMessageDialog(null, "Fin: " + fin.nombre);
     //JOptionPane.showMessageDialog(null, "Cabeza: " + cabeza.nombre);
     
     //JOptionPane.showMessageDialog(null, "Sig fin: " + fin.sig);
        
    }
}
