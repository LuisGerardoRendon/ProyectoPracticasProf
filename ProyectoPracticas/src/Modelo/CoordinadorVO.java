/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ALDO
 */
public class CoordinadorVO {
    private String usuario;
    private String contraseña;

    public CoordinadorVO(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public CoordinadorVO(String contraseña) {
        this.contraseña = contraseña;
        this.usuario="null";
    }

    @Override
    public String toString() {
        return "Coordinador{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
