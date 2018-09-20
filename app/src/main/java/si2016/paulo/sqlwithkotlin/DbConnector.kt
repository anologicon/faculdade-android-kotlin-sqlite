package si2016.paulo.sqlwithkotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.util.HashMap

class DataBaseConnector(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    val connection: SQLiteDatabase

    get() = writableDatabase

    // Criar tabelas
    override fun onCreate(db: SQLiteDatabase) {

        val sqlSQL = arrayOf("CREATE TABLE afazer" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeCurso TEXT, feito boolean  );  ")
        Log.i("XXX", "Iniciando criacao do banco")
        for (i in sqlSQL.indices) {
            db.execSQL(sqlSQL[i])
            Log.i("XXX", "SQL = " + sqlSQL[i])
        }
        Log.i("XXX", "Terminou criacao do banco")
    }

    // Upgrading database
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    /**
     * @param ctx
     * @param tableName
     * @param addElements
     */
    fun addElements(ctx: Context, tableName: String,
        addElements: HashMap<String, String>) {
            val i = addElements.entries.iterator()
            val cv = ContentValues()
            while (i.hasNext()) {
                val me = i.next()
                cv.put(me.key.toString(), me.value.toString())
            }
            connection.insert(tableName, null, cv)

        }

    fun updateElements(tableName: String,
                       elementsUpdate: HashMap<String, String>, whereClause: String,
                       whereArgs: String) {
        val i = elementsUpdate.entries.iterator()
        val cv = ContentValues()
        while (i.hasNext()) {
            val me = i.next()
            cv.put(me.key.toString(), me.value.toString())
        }

        connection.update(tableName, cv, whereClause,
                arrayOf(whereArgs))
    }

    fun deleteElements(tableName: String, whereClause: String,
                       whereArgs: String) {
        connection.delete(tableName, whereClause,
                arrayOf(whereArgs))

    }

    companion object {

        private val DATABASE_VERSION = 2

        private val DATABASE_NAME = "Unifebe.db"
    }

}
