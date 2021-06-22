package com.example.listadetarefas.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

const val VERSION = 1
//const val NOME_DB = "DB_TAREFAS"
//const val TABELAS_TAREFAS = "tarefas"

class DbHelper(context: Context) : SQLiteOpenHelper(context, NOME_DB, null, VERSION) {

    companion object {
        val NOME_DB = "DB_TAREFAS"
        val TABELAS_TAREFAS = "tarefas"
    }

    //OnCreate é chamado assim que o App for instalado
    override fun onCreate(db: SQLiteDatabase?) {

        val sql = "CREATE TABLE IF NOT EXISTS $TABELAS_TAREFAS (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT NOT NULL);"

        try {
            db?.execSQL(sql)
            Log.i("INFO DB", "Sucesso ao criar tabela.")
        } catch (e: Exception) {
            Log.i("INFO DB", "Erro ao criar a tabela: ${e.message}")
        }
    }

    //onUpgrade será chamado para atualizar seu banco de dados
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        val sqlParaExcluir = "DROP TABLE IF EXISTS $TABELAS_TAREFAS;"
//        val sqlUpdateTable = "ALTER TABLE $TABELAS_TAREFAS ADD COLUMN status VARCHAR(2)"

        try {
            //Executando comando para deletar tabela
            db?.execSQL(sqlParaExcluir)
            //Executando comando para criar a tabela novamente
            onCreate(db)
            Log.i("INFO DB", "Sucesso ao atualizar tabela.")
        } catch (e: Exception) {
            Log.i("INFO DB", "Erro ao atualizar a tabela: ${e.message}")
        }
    }
}