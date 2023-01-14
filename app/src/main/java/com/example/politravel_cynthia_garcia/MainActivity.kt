package com.example.politravel_cynthia_garcia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Datos iniciales ---------------------------------------------------
        val paquets: MutableList<Paquet> = mutableListOf(
            Paquet(1,
                "Paquete 1",
                this.getImgIdFromImgName("a1_principal"),
                this.getImgIdFromImgName("a1_llista"),
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
                this.getImgIdFromImgName("a2_principal"),
                this.getImgIdFromImgName("a2_llista"),
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
            ),
            Paquet(3,
                "Paquete 3",
                this.getImgIdFromImgName("a3_principal"),
                this.getImgIdFromImgName("a3_llista"),
                "Transporte 3",
                "Punto Salida 3",
                "Punto Llegada 3",
                17,
                "Coordenadas 3",
                mutableListOf(
                    "Cadiz",
                    "Sevilla",
                    "Cordoba",
                    "Granada",
                    "Malaga"
                )
            )
        )
        //--------------------------------------------------------------

        val lviewPaquets = findViewById<ListView>(R.id.LstPaquets)
        val adapterPaquets = PaquetsAdapter(this, R.layout.paquets_list, paquets)
        lviewPaquets.adapter = adapterPaquets

        lviewPaquets.setOnItemClickListener() {
            adapterView, view, i, l ->

            val footerPaquets = findViewById(R.id.LblPaquetName) as TextView
            footerPaquets.text = paquets[i].name
        }
    }
    // Extraer identificador de la imagen en drawable desde el nombre de imagen
    fun getImgIdFromImgName(imgName: String): Int {
        return this.resources.getIdentifier(imgName, "drawable", this.packageName)
    }
}