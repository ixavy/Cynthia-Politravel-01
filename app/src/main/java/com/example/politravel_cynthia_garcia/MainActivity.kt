package com.example.politravel_cynthia_garcia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Datos iniciales

        val paquets = arrayOf(
            Paquet(1,
                "Paquete 1",
                23,
                21,
                "Transporte 1",
                "Punto Salida 1",
                "Punto Llegada 1",
                12,
                "Coordenadas 1",
                mutableListOf(
                    "Cuenca",
                    "Toledo",
                    "Madrid",
                    "Zaragoza",
                    "Barcelona"
                )
            ),
            Paquet(2,
                "Paquete 2",
                53,
                31,
                "Transporte 2",
                "Punto Salida 2",
                "Punto Llegada 2",
                7,
                "Coordenadas 2",
                mutableListOf(
                    "Sabadell",
                    "Terrassa",
                    "Mollet",
                    "Esplugues",
                    "Badalona"
                )
            )
        )

        val disPaquets = ArrayList<String>()
        for(paquet: Paquet in paquets) {
            disPaquets.add(paquet.name)
        }

        val lviewPaquets = findViewById<ListView>(R.id.LstPaquets)
        val adapterPaquets = ArrayAdapter(this, android.R.layout.simple_list_item_1, disPaquets)

        lviewPaquets.adapter = adapterPaquets



   }
}