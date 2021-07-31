package com.example.tarefas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import com.example.tarefas.room.Tarefa
import kotlinx.android.synthetic.main.list_tarefa.view.*

class TarefasAdapter(private val tarefas: ArrayList<Tarefa>) : RecyclerView.Adapter<TarefasAdapter.TarefasViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefasViewHolder {
        return TarefasViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_tarefa, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TarefasViewHolder, position: Int) {
        val tarefa  = tarefas[position]
        holder.view.tx_titulo.text = tarefa.tarefa
    }

    override fun getItemCount() = tarefas.size

    class TarefasViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Tarefa>){
        tarefas.clear()
        tarefas.addAll(list)
        notifyDataSetChanged()
    }
}