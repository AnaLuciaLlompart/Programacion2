/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import interfaces.IGestorProductos;
import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import principal.vistas.VentanaPrincipal;
import productos.modelos.GestorProductos;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;

/**
 *
 * @author lucas
 */
public class ControladorPrincipal {

    public static void main(String[] args) {
        IGestorProductos gp = GestorProductos.instanciar();
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        List<Usuario> usuarios = new ArrayList<>();

        establecerLookAndFeel("Nimbus");

        IControladorPrincipal cp = ControladorVentanaPrincipal.instanciar();
        VentanaPrincipal ventana  = new VentanaPrincipal(cp);

//        System.out.println("USUARIOS");
//        System.out.println("=====");
//        usuarios = gu.verUsuarios();
//        for (Usuario u : usuarios) {
//            u.mostrar();
//            System.out.println();
//        }
//
    }

    public static void establecerLookAndFeel(String laf) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (laf.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e2) {
            }
        }
    }
}
