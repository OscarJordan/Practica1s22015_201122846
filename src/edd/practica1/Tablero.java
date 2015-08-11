/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.practica1;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author OscarPC
 */
public class Tablero extends javax.swing.JFrame {

    /**
     * Creates new form Tablero
     */
    
    ListaMatriz lista = new ListaMatriz();
    int columna = 0;
    int fila = 0;
    String cadenamatriz1;
    String cadenamatriz2;
       
    
    public Tablero() {
        initComponents();
        InicializarMatriz();
    }
    
     public void LlenarTxtLista ()
    {
    cadenamatriz1 = ""; 
    cadenamatriz2 = "";
    try
    {
    FileWriter salida = null;
    File archivo = new File("c:\\Salida\\SalidaMatriz.txt");
    salida =  new FileWriter(archivo);
        
    salida.write("digraph G");
    salida.write("\r\n");
    salida.write("{");
    salida.write("\r\n");
    
    NodoMatriz recorrer;
    recorrer = lista.cabeza;
    //JOptionPane.showMessageDialog(null, "Ya dentro del método, la cabeza es: " + recorrer.nombre);
    while(recorrer != null)
    {
        //JOptionPane.showMessageDialog(null, "While 1");
    if(recorrer.sig == null)
    {
    cadenamatriz1 = cadenamatriz1 + "-> x" + recorrer.posx + "_" + "y" + recorrer.posy + ";";
    recorrer = recorrer.sig;
    }
    else
    {
    cadenamatriz1 = cadenamatriz1 + "x" + recorrer.posx + "_" + "y" + recorrer.posy;
    recorrer = recorrer.sig;
    }
    }
    
    NodoMatriz recorrer2;
    recorrer2 = lista.cabeza;
    
    while(recorrer2 != null)
    {
    //JOptionPane.showMessageDialog(null, "While 2");
    if (recorrer2 == lista.cabeza)
    {
    cadenamatriz1 = cadenamatriz1 + "x" + recorrer2.posx + "_" + "y" + recorrer2.posy;
    recorrer2 = recorrer2.abajo;    
    }
        
        else if(recorrer2.abajo != null)
    {
    cadenamatriz1 = cadenamatriz1 + "-> x" + recorrer2.posx + "_" + "y" + recorrer2.posy;
    recorrer2 = recorrer2.abajo;    
     
    
    }
    
    else
    {
    cadenamatriz1 = cadenamatriz1 + "-> x" + recorrer2.posx + "_" + "y" + recorrer2.posy + ";";
    recorrer2 = recorrer2.abajo;
    }
    }
    
    salida.write(cadenamatriz1);
    salida.write("\r\n");
    salida.write("\r\n");
    salida.write(cadenamatriz2);
    salida.write("\r\n");
    salida.write("}");
    salida.close();
    }
        catch(IOException e)
        {
        
        
        }
}
    
    
    public void GraficarNodosLista()
    {
    try {
      
      String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
      
      String fileInputPath = "C:\\Salida\\SalidaMatriz.txt";
      String fileOutputPath = "C:\\Salida\\ImagenMatriz.jpg";
      
      String tParam = "-Tjpg";
      String tOParam = "-o";
        
      String[] cmd = new String[5];
      cmd[0] = dotPath;
      cmd[1] = tParam;
      cmd[2] = fileInputPath;
      cmd[3] = tOParam;
      cmd[4] = fileOutputPath;
                  
      Runtime rt = Runtime.getRuntime();
      
      rt.exec(cmd);
      
      
    } catch (Exception ex) 
    {
      ex.printStackTrace();
    }
    finally 
    {
        
    }
    }
    
    

    public void InicializarMatriz()
    {
    for(int i = 0; i < 2; i++)
    {
    NodoMatriz nuevo = new NodoMatriz(fila, columna, 0);
    
    if(lista.MatrizVacia())
    {
    lista.cabeza = nuevo;
    JLabel label = new JLabel();
    label.setBounds(3 + columna*52, 3, 50, 50);
    label.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black, 1));
    PanTablero.add(label);
    fila++;
    columna++;
    }
    else
    {
    lista.cabeza.sig = nuevo;
    JLabel label = new JLabel();
    label.setBounds(3 + columna*52, 3, 50, 50);
    label.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black, 1));
    PanTablero.add(label);
    }
    }
    //fila = 0;
    for(int x = 0 ; x < 3;x++)
    {
    NodoMatriz nuevo = new NodoMatriz(fila, columna, 0);
    if(fila == 1)
    {
    lista.cabeza.abajo = nuevo;
    nuevo.arriba = lista.cabeza;
    JLabel label = new JLabel();
    label.setBounds(3 , 3+ fila*52, 50, 50);
    label.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black, 1));
    PanTablero.add(label);
    fila++;
    }
    else
    {
    NodoMatriz nuevofila = new NodoMatriz(fila, columna, 0);    
    NodoMatriz aux;
    aux = lista.cabeza;
    int h = 0;
    while(h != fila-1)
    {
    aux = aux.abajo;
    //JOptionPane.showMessageDialog(null, aux);
    h++;
    }
    aux.abajo = nuevofila;
    nuevofila.arriba = aux;
    JLabel label = new JLabel();
    label.setBounds(3 , 3+ fila*52, 50, 50);
    label.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black, 1));
    PanTablero.add(label);
    fila++;
    }
    }
    
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        PanTablero = new javax.swing.JPanel();
        PanLista = new javax.swing.JPanel();
        Btn_Graf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mario Maker");

        PanTablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout PanTableroLayout = new javax.swing.GroupLayout(PanTablero);
        PanTablero.setLayout(PanTableroLayout);
        PanTableroLayout.setHorizontalGroup(
            PanTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );
        PanTableroLayout.setVerticalGroup(
            PanTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PanLista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout PanListaLayout = new javax.swing.GroupLayout(PanLista);
        PanLista.setLayout(PanListaLayout);
        PanListaLayout.setHorizontalGroup(
            PanListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        PanListaLayout.setVerticalGroup(
            PanListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        Btn_Graf.setText("Graficar Matriz");
        Btn_Graf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GrafActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(PanTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(Btn_Graf)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(Btn_Graf)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_GrafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GrafActionPerformed
        // TODO add your handling code here:
        LlenarTxtLista();
        GraficarNodosLista();
        
        try    
            {
            Thread.sleep(1000);
            } 
        catch(InterruptedException ex) 
            {
            Thread.currentThread().interrupt();
            }
        
        File f = new File("C:\\Salida\\ImagenMatriz.jpg");
        Desktop dt = Desktop.getDesktop();
        try {
            dt.open(f);
        } catch (IOException ex) {
            Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_Btn_GrafActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Graf;
    private javax.swing.JPanel PanLista;
    private javax.swing.JPanel PanTablero;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
