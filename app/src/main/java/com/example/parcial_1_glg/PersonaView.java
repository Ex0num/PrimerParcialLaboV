package com.example.parcial_1_glg;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class PersonaView {
    Activity act;
    PersonaModel model;
    EditText input_nombre;
    EditText input_apellido;

    RadioButton input_tipo_administrador;
    Button button_guardar;

    //Constructor
    PersonaView(Activity actRecibida, ClickListenerPersona clickLst, PersonaModel modelRecibido)
    {
        if (actRecibida != null)
        {
            this.act = actRecibida;
            this.model = modelRecibido;
            this.recuperarViews();

            this.button_guardar.setOnClickListener(clickLst);
        }

    }

    public void recuperarViews()
    {
        this.input_nombre = this.act.findViewById(R.id.input_nombre);
        this.input_apellido = this.act.findViewById(R.id.input_password);
        this.input_tipo_administrador = this.act.findViewById(R.id.input_tipo_administrador);
        this.button_guardar = this.act.findViewById(R.id.button_guardar);
    }

    public void cargarModelo()
    {
        recuperarViews();
        model.setNombre(this.input_nombre.getText().toString());
        model.setPassword(this.input_apellido.getText().toString());

        if (this.input_tipo_administrador.isChecked() == true)
        {
            model.setTipo("Administrador");
        }
        else
        {
            model.setTipo("Usuario");
        }

        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");

        System.out.println("Cargando el modelo con los datos de los inputs." + " " + this.input_nombre.getText().toString() + "+" +
                this.input_apellido.getText().toString() + "Admin is: " +this.input_tipo_administrador.isChecked());
    }
}