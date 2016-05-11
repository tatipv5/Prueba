/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Factory.FactoryMethod;
import Modelo.BaseDatos;
import Modelo.Usuario;
import Vista.VentanaAutenticar;
import Vista.VentanaIngresar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tati
 */
public class ControladorAutenticar implements ActionListener{
    private  VentanaAutenticar myFrame;
    
    public ControladorAutenticar(VentanaAutenticar myFrame) {
        this.myFrame = myFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = myFrame.devolverText();
        String[] textV = text.split(",");
        FactoryMethod factory = new FactoryMethod();
        Usuario usuario =factory.factory(textV[0], textV[1], Integer.parseInt(textV[2]));
        BaseDatos bd = BaseDatos.getIntance();
        bd.autenticar(usuario);
    }
    
}
