package com.example.listadetarefas.model

data class Tarefa(
    val id: Int? = null,
    val nomeTarefa: String = ""
) {
    fun getTarefas(): MutableList<Tarefa> {
        val listaDeTarefa = mutableListOf(
            Tarefa(null, "Ir ao mercado"),
            Tarefa(null, "Ir a feira"),
            Tarefa(null, "Ir a academia"),
            Tarefa(null, "Ir ao cinema")
        )
        return listaDeTarefa
    }
}