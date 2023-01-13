package com.example.politravel_cynthia_garcia

import android.content.Context
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
 //       val imgPaquet = view.findViewById(R.id.lstPaquetImg) as ImageView
 //       imgPaquet.setImageResource(paquet.imgLow)

          val lblPaquetName = view.findViewById(R.id.lstPaquetName) as TextView
          lblPaquetName.text = paquet.name

          val lblPaquetTransport = view.findViewById(R.id.lstPaquetTransport) as TextView
          lblPaquetTransport.text = "Transporte: " + paquet.transport
    }
}