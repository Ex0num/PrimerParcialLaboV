package com.example.parcial_1_glg;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial_1_glg.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private AdapterPersona adapterPersona;

    public static List<PersonaModel> personas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        /*1er Parcial - Gabriel Lopez Gasal - Laboratorio V*/

        //10 Personas
        personas.add(new PersonaModel("Gabriel","123abc","Administrador"));
        personas.add(new PersonaModel("Alfonso","soyelmejor","Administrador"));
        personas.add(new PersonaModel("Martina","hola123","Usuario"));
        personas.add(new PersonaModel("Leonardo","cactus099902","Administrador"));
        personas.add(new PersonaModel("Camila","4492995923","Usuario"));
        personas.add(new PersonaModel("German","resurreccion123322","Usuario"));
        personas.add(new PersonaModel("Enrique","1818111","Usuario"));
        personas.add(new PersonaModel("Julian","232223","Usuario"));
        personas.add(new PersonaModel("Sabrina","mamateamo12332","Administrador"));
        personas.add(new PersonaModel("Carlos","aguanteriverplate321","Usuario"));

        RecyclerView rv = super.findViewById(R.id.rv);
        this.adapterPersona = new AdapterPersona(personas,this);
        rv.setAdapter(this.adapterPersona);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    public void abrirFormularioEdicionPersona(int posicionPersonaClickeada)
    {
        Log.d("Abrir info de...",personas.get(posicionPersonaClickeada).getNombre() + " " + personas.get(posicionPersonaClickeada).getPassword() + " "  + personas.get(posicionPersonaClickeada).getTipo());

        Intent intencionAbrirFormPersona = new Intent(this, FormularioPersona.class);
        //Paso la data de la persona a editar
        intencionAbrirFormPersona.putExtra("esEdicion",true);
        intencionAbrirFormPersona.putExtra("personaClickeada", personas.get(posicionPersonaClickeada));
        intencionAbrirFormPersona.putExtra("posicionPersonaClickeada", posicionPersonaClickeada);
        super.startActivity(intencionAbrirFormPersona);
    }

    public void abrirFormularioAltaPersona()
    {
        Log.d("Click","Abriendo Formulario vacio");

        Intent intencionAbrirFormPersona = new Intent(this, FormularioPersona.class);
        //Paso la data de la persona a editar
        intencionAbrirFormPersona.putExtra("esEdicion",false);
        super.startActivity(intencionAbrirFormPersona);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.dar_de_alta) {
            Log.d("TEST","TESTING");
            this.abrirFormularioAltaPersona();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        Toast.makeText(this, "Volviendo a la lista principal y verificando cambios...", Toast.LENGTH_SHORT).show();
        Log.d("LISTA ACTUAL: ",this.personas.toString());

        //Debo usar datasetchanged xq puedo dar de alta ademas de modificar.
        this.adapterPersona.notifyDataSetChanged();
        super.onRestart();
    }
}