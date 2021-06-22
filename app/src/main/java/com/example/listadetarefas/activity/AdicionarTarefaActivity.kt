package com.example.listadetarefas.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listadetarefas.R
import com.example.listadetarefas.dao.TarefaDAO
import com.example.listadetarefas.model.Tarefa
import com.google.android.material.textfield.TextInputEditText

class AdicionarTarefaActivity : AppCompatActivity() {

    lateinit var editTarefa: TextInputEditText
    lateinit var tarefaDAO: TarefaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_tarefa)

        editTarefa = findViewById(R.id.textTarefa)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {
                //Executa ação para salvar
                tarefaDAO = TarefaDAO(applicationContext)

                val tarefa = Tarefa(null, "Ir ao mercado")

                if (tarefaDAO.salvar(tarefa)) {
                    Toast.makeText(this, "Tarefa salva com sucesso!", Toast.LENGTH_SHORT).show()
                }

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}