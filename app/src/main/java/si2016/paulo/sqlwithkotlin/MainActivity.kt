package si2016.paulo.sqlwithkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.facebook.stetho.Stetho
import si2016.paulo.sqlwithkotlin.dao.Afazer as DaoAfazer;
import si2016.paulo.sqlwithkotlin.adpter.Afazer as AdpAfazer;
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    var arrayListAfazeres: ArrayList<DaoAfazer> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build())

        val db = DbConnector(applicationContext).connection

        val cadastrarCateogria = findViewById<Button>(R.id.btnSalvar)

        val inputView = findViewById<EditText>(R.id.inputTodo)

        cadastrarCateogria.setOnClickListener {
            val newAfazer = DaoAfazer()

            newAfazer.nome = inputView.text.toString()
            newAfazer.feito = 0

            this.inserirAfazer(newAfazer)

            this.listarAfazeres()
        }

        this.listarAfazeres()
    }


    fun inserirAfazer(afazer: DaoAfazer)
    {
        val db = DbConnector(applicationContext)

        val hm = HashMap<String, String>()

        hm.put("nome", afazer.nome.toString())
        hm.put("feito", afazer.feito.toString())

        db.addElements(applicationContext, "afazer", hm)
        Toast.makeText(this, "Salvo vom sucesso", Toast.LENGTH_SHORT).show()
    }

    fun listarAfazeres()
    {
        this.consultarAfazerDb()

        val listViewAfazer = findViewById<ListView>(R.id.listaDeAfazeres)

        val adapter = AdpAfazer(this, arrayListAfazeres)

        listViewAfazer?.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    fun consultarAfazerDb() {
        val dataBaseConnector = DbConnector(applicationContext)
        val r = dataBaseConnector.connection.rawQuery("select nome from afazer ", null)
        if (r.moveToFirst()) {
            arrayListAfazeres = ArrayList()

            do {
                val _afazer = DaoAfazer()

                _afazer.nome = r.getString(r.getColumnIndex("nome"))


                arrayListAfazeres.add(_afazer)
            } while (r.moveToNext())
        }
    }

}
