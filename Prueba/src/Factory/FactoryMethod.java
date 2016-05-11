/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Modelo.Md5;
import Modelo.Plana;
import Modelo.Salt;
import Modelo.Sha1;
import Modelo.Usuario;

/**
 *
 * @author tati
 */
public class FactoryMethod {
   
    public Usuario factory(String nombre, String contrasena, int id) throws IllegalArgumentException{
         if(nombre.equals("") || contrasena.equals("")){
            throw new IllegalArgumentException("Los valores son incorrectos");
        }
        switch(id) {
            case 1:  //plana
                return new Plana(nombre, contrasena);
                case 2:  //md
                    return new Md5(nombre, contrasena);
                case 3: //sha
                    return new Sha1(nombre, contrasena);
                case 4: //salt
                    return new Salt(nombre, contrasena);
                default:
                    throw new IllegalArgumentException("Seleccion invalida");
        }
    }
}
