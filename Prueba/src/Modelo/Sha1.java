/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author tati
 */
public class Sha1 extends Usuario {

    public Sha1(String nombre, String contrasena) {
        super(nombre, contrasena);
        super.setContrasena(contrasenaCambiada(contrasena));
    }
    
    @Override
     public String contrasenaCambiada(String contrasena) {
        MessageDigest mDigest = null;
        try {
            mDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Sha1.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] result = mDigest.digest(contrasena.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
     @Override
     public void verificarContrasenaCambiada(String contrasena){
          MessageDigest mDigest = null;
        try {
            mDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Sha1.class.getName()).log(Level.SEVERE, null, ex);
        }
       byte[] result = mDigest.digest(contrasena.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        if(sb.equals(contrasena)){
            JOptionPane.showMessageDialog(null, "La cuenta ha sido verificada correctamente");
        }
     }

}
