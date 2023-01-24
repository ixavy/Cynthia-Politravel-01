package com.example.politravel_cynthia_garcia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*
        // Datos iniciales -------------------------------------------------

        val paquets: MutableList<Paquet> = mutableListOf(
            Paquet(1,
                "Paquete 1",
                this.getImgIdFromImgName("id_1_principal"),
                this.getImgIdFromImgName("id_1_llista"),
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
                this.getImgIdFromImgName("id_2_principal"),
                this.getImgIdFromImgName("id_2_llista"),
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
                this.getImgIdFromImgName("id_3_principal"),
                this.getImgIdFromImgName("id_3_llista"),
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

        this.writeJson(paquets)
*/
        val paquets: MutableList<Paquet> = this.readJson()

        //--------------------------------------------------------------

        val llayout = findViewById<LinearLayout>(R.id.Llayout)
        val lviewPaquets = findViewById<ListView>(R.id.LstPaquets)
        val footerPaquets = findViewById(R.id.LblPaquetName) as TextView

        val adapterPaquets = PaquetsAdapter(this, R.layout.paquets_list, paquets)
        lviewPaquets.adapter = adapterPaquets

        llayout.setOnClickListener {
            Toast.makeText(this, "Click", Toast.LENGTH_LONG).show()
        }

        lviewPaquets.setOnItemClickListener() {
            adapterView, view, i, l ->
            Toast.makeText(this, paquets[i].name, Toast.LENGTH_LONG).show()
        }
    }
    // Extraer identificador de la imagen en drawable desde el nombre de imagen
    fun getImgIdFromImgName(imgName: String): Int {
        return this.resources.getIdentifier(imgName, "drawable", this.packageName)
    }

    fun writeJson(datos: MutableList<Paquet>) {
        val jsonFilePath = this.filesDir.toString() + "/json/paquets.json"
        val jsonFile = FileWriter(jsonFilePath)

        val gson = Gson()
        val json: String = gson.toJson(datos)

        jsonFile.write(json)
        jsonFile.close()
    }

    fun readJson(): MutableList<Paquet> {
        val jsonFilePath = this.filesDir.toString() + "/json/paquets.json"
        val jsonFile = FileReader(jsonFilePath)

        val listPlayerType = object : TypeToken<MutableList<Paquet>>() {}.type
        return Gson().fromJson(jsonFile, listPlayerType)
    }
}