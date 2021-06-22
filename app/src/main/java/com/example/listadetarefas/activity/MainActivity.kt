package com.example.listadetarefas.activity

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetarefas.R
import com.example.listadetarefas.adapter.TarefasAdapter
import com.example.listadetarefas.helper.DbHelper
import com.example.listadetarefas.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var tarefaAdapter: TarefasAdapter
    lateinit var db: DbHelper
    lateinit var cv: ContentValues

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val segundaActivity = Intent(this, AdicionarTarefaActivity::class.java)
            startActivity(segundaActivity)
        }

        db = DbHelper(applicationContext)

        cv = ContentValues()
        cv.put("nome", "Teste")

        db.writableDatabase.insert("tarefas", null, cv)
    }

    override fun onStart() {
        carregarListaTarefas()
        super.onStart()
    }

    fun carregarListaTarefas() {

        //Listar Tarefas
        val tarefa = Tarefa()
        val lista = tarefa.getTarefas()

        //Configurar Adapter
        tarefaAdapter = TarefasAdapter(lista, this::itemClicado)

        //Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = (tarefaAdapter)
    }

    //Evento de clique
    private fun itemClicado(tarefa: Tarefa) {
        Toast.makeText(
            applicationContext,
            "Tarefa clicada: ${tarefa.nomeTarefa}",
            Toast.LENGTH_SHORT
        )
            .show()
    }
}