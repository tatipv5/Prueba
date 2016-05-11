/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tati
 */
public class BaseDatos<T> {
    private ArrayList<T> array;
    private int contador = 0;
    private static BaseDatos baseDatos=new BaseDatos();
    
    private BaseDatos(){
        array=new ArrayList<>();
    }
    
    public static BaseDatos getIntance() {
        return baseDatos;
    }
    
     public void agregar(T t)throws NullPointerException{
        if(t==null){
            throw new NullPointerException();
        }
        array.add(t);
        System.out.println("se agrego " + array.get(contador));
        contador++;
         
    }
     
    public void autenticar(T t) throws NullPointerException{
        if(t==null){
            throw new NullPointerException();
        }
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i).equals(t)){
                JOptionPane.showMessageDialog(null,"La cuenta ha sido autenticada");
            }
            
        }
    } 
}
