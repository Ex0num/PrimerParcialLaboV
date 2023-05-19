package com.example.parcial_1_glg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterPersona extends RecyclerView.Adapter<ViewHolderPersona> {
    List<PersonaModel> personas;
    private MainActivity mainAct;

    public  AdapterPersona(List<PersonaModel> personas, MainActivity mainActRecibida)
    {
        this.personas = personas;
        this.mainAct = mainActRecibida;
    }

    @NonNull
    @Override
    public ViewHolderPersona onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.persona_item,parent,false);
        ViewHolderPersona viewHolder = new ViewHolderPersona(view,this.mainAct);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersona holder, int position)
    {
        PersonaModel p = this.personas.get(position);
        TextView nombre = holder.itemView.findViewById(R.id.tvNombre);
        //TextView password = holder.itemView.findViewById(R.id.tvPassword);
        TextView tipo = holder.itemView.findViewById(R.id.tvTipo);

        nombre.setText(p.getNombre());
        //password.setText(p.getPassword());
        tipo.setText(p.getTipo());
    }

    @Override
    public int getItemCount() {return this.personas.size();}
}
