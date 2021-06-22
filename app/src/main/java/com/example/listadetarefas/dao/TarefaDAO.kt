package com.example.listadetarefas.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.listadetarefas.helper.DbHelper
import com.example.listadetarefas.model.Tarefa

class TarefaDAO(context: Context) : ITarefaDAO {

    var dbHelper: DbHelper
    var escreve: SQLiteDatabase
    var le: SQLiteDatabase

    init {
        dbHelper = DbHelper(context)
        escreve = dbHelper.writableDatabase
        le = dbHelper.readableDatabase
    }

    override fun salvar(tarefa: Tarefa): Boolean {

        val cv = ContentValues()
        cv.put("nome", tarefa.nomeTarefa)

        try {
            escreve.insert("tarefas", null, cv)
            Log.i("INFO DB", "Tarefa salva com sucesso!")
        } catch (e: Exception) {
            Log.i("INFO DB", "Erro ao salvar tarefa ${e.message}")
            return false
        }

        return true
    }

    override fun atualizar(tarefa: Tarefa): Boolean {
        TODO("Not yet implemented")
    }

    override fun deletar(tarefa: Tarefa): Boolean {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Tarefa> {
        TODO("Not yet implemented")
    }
}