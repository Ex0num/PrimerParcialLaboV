package com.example.parcial_1_glg;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class PersonaModel implements Serializable {

    String nombre;
    String password;

    String tipo;

    public PersonaModel (String nombreRecibido, String passwordRecibida, String tipoRecibido)
    {
        this.nombre = nombreRecibido;
        this.password = passwordRecibida;
        this.tipo = tipoRecibido;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombreRecibo) {this.nombre = nombreRecibo;}

    public String getPassword() {return password;}
    public void setPassword(String passwordRecibida) {this.password = passwordRecibida;}

    public String getTipo(){ return tipo;}

    public void setTipo(String tipoRecibido) {this.tipo = tipoRecibido;}

    @NonNull
    @Override
    public String toString() { return this.nombre+" "+this.password+" "+this.tipo;}
}
