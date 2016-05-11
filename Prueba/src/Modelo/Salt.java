/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author tati
 */
public class Salt extends Usuario{
    
    private final String salt = "A1b2C3d4";
    
    public Salt(String nombre, String contrasena) {
        super(nombre, contrasena);
        super.setContrasena(contrasenaCambiada(contrasena));
    }
    
    @Override
    public String contrasenaCambiada(String contrasena){
        StringBuffer sb = new StringBuffer();
        sb.append(contrasena);
        for (int i = 0; i < 8; i++) {
            int aleatorio = (int) (Math.random()*9 +1);
            sb.setCharAt(aleatorio, sb.charAt(aleatorio));
        }
        return sb.toString();
    }
}
