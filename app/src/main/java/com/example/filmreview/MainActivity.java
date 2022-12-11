package com.example.filmreview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listGames;

    public static String[][] data = {
            {"Calisto Protocol","Krafton","12","7","The Calslisto Protocol es un juego de acción y terror con planteamiento de survival horror para PS5, Xbox Series S/X y PC que lleva a los jugadores a una historia que transcurre en el año 2320 en Calisto, uno de los satélites de Júpiter.","55"},
            {"Deathloop","Arkane Studios","16","5","shooter en primera persona de nueva generación desarrollado por Arkane Lyon.Dos asesinos rivales se ven atrapados en un bucle temporal en la misteriosa isla de Blackreef, condenados a repetir una y otra vez el mismo día.","60"},
            {"Sonic Frontiers","Sonic Team","20","8","En Sonic Frontiers, el antiguo enemigo de Sonic, el Dr. Eggman, descubre una tecnología antigua en las Islas Starfall e instala su programa de inteligencia artificial SAGE para piratear y hacerse cargo. Pero esta tecnología es más de lo que se da cuenta, y las consecuencias no deseadas llegan de inmediato. Sonic debe correr contra el tiempo para descubrir la verdad, salvar a sus amigos y tal vez incluso salvarse a sí mismo al mismo tiempo","60"},
            {"God of War: Ragnarök","SIE Santa Monica Studio","45","10","Ragnarök es la batalla del fin del mundo. Esta batalla será emprendida entre los dioses, los Æsir, liderados por Odín y los gigantes de fuego liderados por Surt, a los cuales también se les unen los jötnar liderados por Loki.","70"}

    };


    public static int[] dataImg = {
            R.drawable.calistoprotocol,
            R.drawable.deahloop,
            R.drawable.sonic,
            R.drawable.godofwar};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listGames = findViewById(R.id.list_Games);

        listGames.setAdapter(new AdaptadorComplex(this,data,dataImg));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.compras_action_button:
                Intent compras = new Intent(this, Compra_Activity.class);
                this.startActivity(compras);
                break;
            case R.id.contacto_action_button:
                Intent contacto = new Intent(this,Contacto_Activity.class);
                this.startActivity(contacto);
                break;
        }

        return true;
    }
}