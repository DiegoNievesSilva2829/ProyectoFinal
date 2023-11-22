/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import Entidades.Administrador;
import Entidades.Persona;

/**
 *
 * @author harol
 */
public class Login {
    
    private static Administrador usuarionuevo= new Administrador();
    private static Administrador usuarioLogeado;
    
    public static void validarLogin(String username, String password) throws Exception{
        
        
        if(username.isEmpty()){
            throw new IllegalStateException("El usuario debe contener caracteres, no puede estar vacío");
        }
        
        if(password.isEmpty()){
            throw new IllegalStateException("La contraseña debe contener caracteres, no puede estar vacia");
        }
        
        if(!usuarionuevo.getUsername().equals(username)){
            throw new Exception("El usuario registrado es inválido");
        }
       
        if(!usuarionuevo.getPassword().equals(password)){
            throw new Exception("La contraseña registrada es inválida");
        }
        
        usuarioLogeado = usuarionuevo;
       
        
    }
    
    public static void setUsuarioLogeado(Administrador usuario){
        usuarioLogeado=usuario;
    }
    
    public static Administrador getUsuarioLogeado(){
        return usuarioLogeado;
    }
    
}


