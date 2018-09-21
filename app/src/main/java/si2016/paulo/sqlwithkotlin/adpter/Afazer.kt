package si2016.paulo.sqlwithkotlin.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.util.ArrayList
import si2016.paulo.sqlwithkotlin.R

import si2016.paulo.sqlwithkotlin.dao.Afazer as DaoAfazer

class CustomAdapterTemperaturas//public View convertView;
(internal var contextTela: Context,
 listaAfazeres: ArrayList<DaoAfazer>) : ArrayAdapter<DaoAfazer>(contextTela, 0, listaAfazeres) {

    private val listaAfazer: ArrayList<DaoAfazer>? = null
    internal var afazer: DaoAfazer = DaoAfazer()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        afazer = getItem(position) as DaoAfazer

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.linha_afazer,
                    parent, false)
        }

        val datatemperatura = convertView!!.findViewById(
                R.id.txtViewNomeAfazer) as TextView

        datatemperatura.setText(afazer.nomeProduto.toString())

        convertView.tag = position

        return convertView
    }
}
