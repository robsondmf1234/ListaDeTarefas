package com.example.listadetarefas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetarefas.R
import com.example.listadetarefas.model.Tarefa

class TarefasAdapter(
    listaDeTarefa: MutableList<Tarefa>,
    private val itemClicado: (selectedItem: Tarefa) -> Unit
) : RecyclerView.Adapter<TarefasAdapter.MyViewHolder>() {

    //Recebendo a lista de filmes
    val lista = listaDeTarefa

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemLista: View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_lista, parent, false)

        return MyViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tarefa: Tarefa = lista.get(position)
        holder.tarefa.text = tarefa.nomeTarefa

        //Adicionando evento de clique no BindViewHolder
        holder.itemView.setOnClickListener {
            //pegando a tarefa atual
            itemClicado(tarefa)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tarefa: TextView = itemView.findViewById(R.id.tarefa)
    }
}