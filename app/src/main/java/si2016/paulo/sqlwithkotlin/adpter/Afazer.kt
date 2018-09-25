package si2016.paulo.sqlwithkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text
import si2016.paulo.sqlwithkotlin.R
import si2016.paulo.sqlwithkotlin.dao.Afazer as DaoAfazer

class Afazer(private val context: Context,
                    private val dataSource: ArrayList<DaoAfazer>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = convertView  ?: inflater.inflate(R.layout.linha_afazer, parent, false)

        val textViewLinha = rowView.findViewById<TextView>(R.id.txtViewNomeAfazer)

        val _afazer = getItem(position) as DaoAfazer

        textViewLinha.text = _afazer.nome.toString()

        return rowView
    }

}

