package com.example.parcial_1_glg;

import android.util.Log;

public class PersonaController {
    public ClickListenerPersona clickLst;
    PersonaModel model;
    PersonaView view;

    PersonaController(PersonaModel modelRecibido)
    {
        this.model = modelRecibido;
        this.clickLst = new ClickListenerPersona(this);
    }

    public boolean validarDatos()
    {
        view.cargarModelo();

        if( this.model.getNombre() == null || "".equals(this.model.getNombre()) ||
                this.model.getPassword() == null || "".equals(this.model.getPassword()))
        //this.model.getDni() == null ||
        //this.model.getSexo() == null || "".equals(this.model.getApellido()) )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public ClickListenerPersona getClick()
    {
        return this.clickLst;
    }

    public void setView(PersonaView viewRecibida)
    {
        this.view = viewRecibida;
    }

    public void guardar()
    {
        this.view.cargarModelo();

        if (this.validarDatos() == true)
        {
            Log.d("Persona", this.model.toString());
        }
        else
        {
            Log.d("Persona","Faltan cargar datos o hay inválidos");
        }
    }
}
