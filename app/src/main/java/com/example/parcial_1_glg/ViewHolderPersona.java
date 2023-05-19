package com.example.parcial_1_glg;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderPersona extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView nombre;
    TextView password;

    TextView tipo;

    int posicionElemSiendoLlamado;
    MainActivity mainAct;

    public ViewHolderPersona(@NonNull View viewRecibida, MainActivity mainActRecibida)
    {
        super(viewRecibida);
        this.mainAct = mainActRecibida;
        nombre = viewRecibida.findViewById(R.id.tvNombre);
        //password = viewRecibida.findViewById(R.id.tvPassword);
        tipo = viewRecibida.findViewById(R.id.tvTipo);
        viewRecibida.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        Log.d("Se hizo click","En la persona "+super.getAdapterPosition());
        posicionElemSiendoLlamado = super.getAdapterPosition();
        mainAct.abrirFormularioEdicionPersona(posicionElemSiendoLlamado);
    }

}
