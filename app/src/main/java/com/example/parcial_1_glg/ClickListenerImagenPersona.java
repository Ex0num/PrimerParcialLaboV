package com.example.parcial_1_glg;

import android.view.View;

public class ClickListenerImagenPersona implements View.OnClickListener
{
    PersonaController controller;

    //Constructor
    public ClickListenerImagenPersona(PersonaController controllerRecibido)
    {
        this.controller = controllerRecibido;
    }

    //Evento click
    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.button_guardar)
        {
            this.controller.guardar();
        }
    }
}
