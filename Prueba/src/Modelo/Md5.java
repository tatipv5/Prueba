/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tati
 */
public class Md5 extends Usuario{
    
    public Md5(String nombre, String contrasena) {
        super(nombre, contrasena);
        super.setContrasena(contrasenaCambiada(contrasena));
    }
    
    @Override
    public String contrasenaCambiada(String contrasena){
    
       String password = contrasena;
    	
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Md5.class.getName()).log(Level.SEVERE, null, ex);
        }
        md.update(password.getBytes());
        
        byte byteData[] = md.digest();
 
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
     
       return sb.toString();
        

   }
    @Override
    public void verificarContrasenaCambiada(String contrasena){
    String password = contrasena;
    	        MessageDigest md = null;

      try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Md5.class.getName()).log(Level.SEVERE, null, ex);
        }
        md.update(password.getBytes());
        
        byte byteData[] = md.digest();
 
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
     
        if(sb.equals(password)){
        
            System.out.println("ha sido verificado");
        }
    
    }
             

}
    
