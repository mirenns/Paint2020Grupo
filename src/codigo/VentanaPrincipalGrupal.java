
package codigo;

import codigo.formas.Circulo;
import codigo.formas.Estrella;
import codigo.formas.Forma;
import codigo.formas.Pentagono;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @authors @writters @directors
 * Mohamed El Boudakhani Ikatouaran
 * Miren Ordóñez de Arce
 */
public class VentanaPrincipalGrupal extends javax.swing.JFrame {

    //Vamos a tener un segundo buffer que nos ayudará a la hora de pintar la forma final. 
    BufferedImage buffer, buffer2 = null;
    //Graphics2D es una librería de java que nos va a permitir hacer los triángulos, cuadrados y demás. 
    //Vamos a declarar una para el buffer y otra para el jpanel.
    Graphics2D bufferGraphics, bufferGraphics2, jpanelGraphics = null;
    
    
    Circulo miCirculo = null;
    Forma miForma = new Forma (-1, -1, 1, Color.WHITE, false);
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipalGrupal() {
        initComponents();
        inicializaBuffers();
    }

    private void inicializaBuffers() {
        //Voy a crear una imagen del mismo ancho y alto que el jPanel1.
        buffer = (BufferedImage)jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight());
        buffer2 = (BufferedImage)jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight());
        //Creo una imagen modificable, que va a ser de tipo graphics2D. 
        bufferGraphics = buffer.createGraphics();
        bufferGraphics2 = buffer2.createGraphics();
        //Inicializo el buffer para que se pinte de blanco entero.
        bufferGraphics.setColor(Color.WHITE);
        bufferGraphics.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        
        bufferGraphics2.setColor(Color.WHITE);
        bufferGraphics2.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        
        jpanelGraphics = (Graphics2D) jPanel1.getGraphics(); //Enlace el jPanel Graphics con el jPanel normal.
    }
    
    //Vamos a enlazar el panel con la zona de memoria en la que estás dibujando. 
    @Override 
    public void paint(Graphics g) {
      super.paint(g);  //llama a la clase que estoy extendiendo que es la de jFrame, que tiene un método paint.
      //Añadimos que en el jPanel se dibuje la imagen. Pinto el buffer sobre el jPanel.
      jpanelGraphics.drawImage(buffer, 0, 0, null); //le dice que sea una imagen, en la posición (0,0), y null porque sí.
      
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelColores1 = new codigo.PanelColores();
        herramientas1 = new codigo.Herramientas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(herramientas1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelColores1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelColores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(herramientas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        bufferGraphics.drawImage(buffer2, 0, 0, null); //esto va a coger la pantalla, la borra entera y deja el buffer2 con la forma final elegida. 
        switch(herramientas1.formaElegida) {
            case 0: 
                //Esto nos va a servir para el trazo libre. El dragged es cuando pulsas el ratón y arrastras.
                bufferGraphics2.setColor(panelColores1.colorSeleccionado); //lo que está entre paréntesis, es llamar a la clase panelColores y el color que se haya seleccionado.
                bufferGraphics2.fillOval(evt.getX(), evt.getY(), 3, 3); //las coordenadas de donde ha sucedido el evento, y el grosor que es de 3x3 porque menos no se ve bien.
                
                break;
            
            case 1: miCirculo.dibujate(bufferGraphics, evt.getX());break;
            
            case 5: miForma.dibujate(bufferGraphics, evt.getX(), evt.getY()); break;
            
            case 256: miForma.dibujate(bufferGraphics, evt.getX(), evt.getY()); break;
                
        }
        repaint(0,0,1,1); //primero se pinta en la memoria y el repaint sirve para que se muestre en el jPanel1.
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        switch(herramientas1.formaElegida) {
            case 0: break;
            
            //el caso 1 crea un círculo desde donde se haga click en la pantalla
            case 1: miCirculo = new Circulo(evt.getX(), evt.getY(), 1, panelColores1.colorSeleccionado, herramientas1.relleno); 
                    miCirculo.dibujate(bufferGraphics, evt.getX());break;
                    
            case 5: miForma = new Pentagono(evt.getX(), evt.getY(), 5, panelColores1.colorSeleccionado, herramientas1.relleno);
                    miForma.dibujate(bufferGraphics, evt.getX(), evt.getY()); break;
            
            case 256:  miForma = new Estrella(evt.getX(), evt.getY(), 256, panelColores1.colorSeleccionado, herramientas1.relleno);
                       miForma.dibujate(bufferGraphics, evt.getX(), evt.getY()); break;
        }
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        //Esto va a hacer que finalmente se guarde la forma elegida, SALVO EL CÍRCULO. (SOLUCIONADO CÍRCULO) 
        miForma.dibujate(bufferGraphics2, evt.getX(), evt.getY()); 
        //Para el círculo, que se mantenga en la pantalla después de soltar el ratón. 
        if (herramientas1.formaElegida == 1) {
            miCirculo.dibujate(bufferGraphics2, evt.getX());
        }
    }//GEN-LAST:event_jPanel1MouseReleased

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
            java.util.logging.Logger.getLogger(VentanaPrincipalGrupal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalGrupal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalGrupal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalGrupal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalGrupal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private codigo.Herramientas herramientas1;
    private javax.swing.JPanel jPanel1;
    private codigo.PanelColores panelColores1;
    // End of variables declaration//GEN-END:variables
}
