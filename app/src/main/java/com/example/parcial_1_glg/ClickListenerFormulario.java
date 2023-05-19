package com.example.parcial_1_glg;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ClickListenerFormulario implements View.OnClickListener
{
    boolean esEdicion;

    EditText input_nombre;
    EditText input_password;
    EditText input_confirm_password;

    RadioButton input_administrador;
    RadioButton input_usuario;

    int posicionPersonaClickeada;

    Activity actividadFormulario;

    //Constructor
    public ClickListenerFormulario(boolean esEdicionRecibida, int posicionPersonaClickeadaRecibida , EditText input_nombreRecibido, EditText input_passwordRecibida, RadioButton input_administradorRecibido, RadioButton input_usuarioRecibido, EditText input_confirmPasswordRecibido, Activity actividadFormularioRecibida)
    {
        this.actividadFormulario = actividadFormularioRecibida;
        this.esEdicion = esEdicionRecibida;
        this.input_nombre = input_nombreRecibido;
        this.input_password = input_passwordRecibida;
        this.input_confirm_password = input_confirmPasswordRecibido;
        this.input_administrador = input_administradorRecibido;
        this.input_usuario = input_usuarioRecibido;
        this.posicionPersonaClickeada = posicionPersonaClickeadaRecibida;
    }

    public ClickListenerFormulario(boolean esEdicionRecibida, EditText input_nombreRecibido, EditText input_passwordRecibida, RadioButton input_administradorRecibido, RadioButton input_usuarioRecibido, EditText input_confirmPasswordRecibido, Activity actividadFormularioRecibida)
    {
        this.actividadFormulario = actividadFormularioRecibida;
        this.input_nombre = input_nombreRecibido;
        this.input_password = input_passwordRecibida;
        this.input_confirm_password = input_confirmPasswordRecibido;
        this.input_administrador = input_administradorRecibido;
        this.input_usuario = input_usuarioRecibido;
        this.esEdicion = esEdicionRecibida;
    }

    //Evento click
    @Override
    public void onClick(View view)
    {
        System.out.println("Se hizo click en guardar los datos ingresados");

        String passwordIngresada = this.input_password.getText().toString();
        String confirmacionPasswordIngresada = this.input_confirm_password.getText().toString();

        if (passwordIngresada.equals(confirmacionPasswordIngresada) == false || passwordIngresada.length() < 4)
        {
            System.out.println("Las passwords deben matchear y deben tener mas de 3 caracteres");
        }
        else
        {
            if (esEdicion == true)
            {
                System.out.println("Editando datos de una persona existente...");

                PersonaModel personaASerEditada = MainActivity.personas.get(posicionPersonaClickeada);
                personaASerEditada.setNombre(input_nombre.getText().toString());
                personaASerEditada.setPassword(input_password.getText().toString());

                if (this.input_administrador.isChecked() == true)
                {
                    personaASerEditada.setTipo("Administrador");
                }
                else
                {
                    personaASerEditada.setTipo("Usuario");
                }

                this.actividadFormulario.finish();
            }
            else if (esEdicion == false)
            {
                System.out.println("Creando persona...");

                String tipoUsuario;

                if (this.input_administrador.isChecked() == true)
                {
                    tipoUsuario = "Administrador";
                }
                else
                {
                    tipoUsuario = "Usuario";
                }

                PersonaModel personaASerCreada = new PersonaModel(input_nombre.getText().toString(), input_password.getText().toString(), tipoUsuario);
                MainActivity.personas.add(personaASerCreada);
                this.actividadFormulario.finish();
            }
        }
    }
}
