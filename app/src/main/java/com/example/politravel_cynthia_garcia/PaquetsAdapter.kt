package com.example.politravel_cynthia_garcia

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class PaquetsAdapter(context: Context, val layout: Int, val paquets: MutableList<Paquet>):
    ArrayAdapter<Paquet>(context, layout, paquets) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View

        if(convertView != null){
            view = convertView
        }else{
            view = LayoutInflater.from(getContext()).inflate(layout, parent, false)
        }
        bindPaquet(view, paquets[position])

        return view
    }

    fun bindPaquet(view: View, paquet: Paquet) {

        // Nombre del recurso de la imagen en drawable -> idPaquete+"_llista", según reto
        val txtFileImg = "a"+paquet.id.toString()+"_llista"

        val imgLow = getImgIdFromImgName(txtFileImg)

        val imgPaquet = view.findViewById(R.id.lstPaquetImg) as ImageView
// TODO: Sustituir imgLow por paquet.imgLow (cuando sepamos como informar paquet.imgLow con el Int de la imagen)
        imgPaquet.setImageResource(imgLow)

        val lblPaquetName = view.findViewById(R.id.lstPaquetName) as TextView
        lblPaquetName.text = paquet.name

        val lblPaquetTransport = view.findViewById(R.id.lstPaquetTransport) as TextView
        lblPaquetTransport.text = "Transporte: " + paquet.transport
    }

    // Extraer identificador de la imagen en drawable desde el nombre de imagen
    fun getImgIdFromImgName(imgName: String): Int {
        return context.resources.getIdentifier(imgName,"drawable", context.packageName)
    }
}