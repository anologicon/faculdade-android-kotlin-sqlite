package si2016.paulo.sqlwithkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.facebook.stetho.Stetho

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build())

        val cadastrarCateogria = findViewById<Button>(R.id.btnSalvar)

        val inputView = findViewById<EditText>(R.id.inputTodo)

        cadastrarCateogria.setOnClickListener(View.OnClickListener {

        })
    }

    fun listarAfazeres()
    {

    }

}
