
package principal.controladores;

import interfaces.IControladorPrincipal;
import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import usuarios.controladores.ControladorUsuarios;


/**
 *
 * @author Ana y Lucas
 */
public class ControladorVentanaPrincipal implements IControladorPrincipal {

    private VentanaPrincipal ventana;
     
    private static ControladorVentanaPrincipal controlador;

    private ControladorVentanaPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setTitle(TITULO);   
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
   
    }

    public static ControladorVentanaPrincipal instanciar() {
        if (controlador == null) {
            controlador = new ControladorVentanaPrincipal();
        }
        return controlador;
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {      
        IControladorUsuarios cu = new ControladorUsuarios(ventana);
        
    }

    @Override
    public void btnProductosClic(ActionEvent evt) { // NADA 
    }

    @Override
    public void btnPedidosClic(ActionEvent evt) {   //NADA
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {

        int respuesta = JOptionPane.showOptionDialog(null, "¿Esta seguro de salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "Sí");

        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(respuesta);
        }
    }

}
