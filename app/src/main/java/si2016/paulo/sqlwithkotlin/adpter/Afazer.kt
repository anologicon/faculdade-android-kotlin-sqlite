package si2016.paulo.sqlwithkotlin.adpter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import si2016.paulo.sqlwithkotlin.R
import si2016.paulo.sqlwithkotlin.dao.Afazer as DaoAfazer

/**
 * Created by bett on 8/21/17.
 */
class Afazer(private var activity: Activity, private var items: ArrayList<DaoAfazer>): BaseAdapter() {
//    var items = ArrayList<UserDto>()
//    var activity: Activity? = null

//    init {
//        this.activity = activity
//        this.items = items
//    }

    private class ViewHolder(row: View?) {
        var txtViewNomeAfazer: TextView? = null

        init {
            this.txtViewNomeAfazer = row?.findViewById<TextView>(R.id.txtViewNomeAfazer)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View?
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.linha_afazer, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var userData = items[position]

        viewHolder.txtViewNomeAfazer?.text = userData.nome

        return view as View
    }

    override fun getItem(i: Int): DaoAfazer {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }


}