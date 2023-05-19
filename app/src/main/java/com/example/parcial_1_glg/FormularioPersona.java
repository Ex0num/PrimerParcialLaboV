package com.example.parcial_1_glg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioPersona extends AppCompatActivity {

    EditText input_nombre;
    EditText input_password;

    EditText input_confirm_password;

    RadioButton input_tipo_administrador;
    RadioButton input_tipo_usuario;
    Button button_guardar;
    ImageView imagen_representativaPersona;

    boolean esEdicion;
    PersonaModel datosPersonaClickeada;
    int posicionPersonaClickeada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_persona);

        Intent intencion = getIntent();
        this.esEdicion = intencion.getExtras().getBoolean("esEdicion");

        //Traer ref de los inputs y elementos
        this.input_nombre = super.findViewById(R.id.input_nombre);
        this.input_password = super.findViewById(R.id.input_password);
        this.input_confirm_password = super.findViewById(R.id.input_confirm_password);
        this.input_tipo_administrador = super.findViewById(R.id.input_tipo_administrador);
        this.input_tipo_usuario = super.findViewById(R.id.input_tipo_usuario);
        this.button_guardar = super.findViewById(R.id.button_guardar);
        this.imagen_representativaPersona = super.findViewById(R.id.imagen_representativaPersona);

        if (this.esEdicion == true) {
            System.out.println("Hay que editar los datos de una persona");

            //Se carga data
            this.datosPersonaClickeada = (PersonaModel) intencion.getExtras().get("personaClickeada");
            this.posicionPersonaClickeada = (int) intencion.getExtras().get("posicionPersonaClickeada");
            this.input_nombre.setText(datosPersonaClickeada.getNombre());
            //this.input_password.setText(datosPersonaClickeada.getPassword());

            if (this.datosPersonaClickeada.getTipo().equals("Administrador"))
            {
                this.input_tipo_usuario.setChecked(false);
                this.input_tipo_administrador.setChecked(true);
            }
            else
            {
                this.input_tipo_administrador.setChecked(false);
                this.input_tipo_usuario.setChecked(true);
            }

            System.out.println("==============================");
            System.out.println(this.datosPersonaClickeada.getTipo());
            System.out.println("==============================");

            ClickListenerFormulario clickLstnForm = new ClickListenerFormulario(this.esEdicion, this.posicionPersonaClickeada, this.input_nombre, this.input_password, this.input_tipo_administrador, this.input_tipo_usuario, this.input_confirm_password, this);
            this.button_guardar.setOnClickListener(clickLstnForm);
        }
        else
        {
            System.out.println("Hay que abrir el formulario vacio para dar de alta");

            //Se carga data default
            this.input_nombre.setText("");
            this.input_password.setText("");

            ClickListenerFormulario clickLstnForm = new ClickListenerFormulario(this.esEdicion, this.input_nombre, this.input_password, this.input_tipo_administrador, this.input_tipo_usuario, this.input_confirm_password, this);
            this.button_guardar.setOnClickListener(clickLstnForm);
        }

    }
}
