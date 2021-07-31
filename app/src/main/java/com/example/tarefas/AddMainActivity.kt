package com.example.tarefas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tarefas.room.Tarefa
import com.example.tarefas.room.TarefaDb
import kotlinx.android.synthetic.main.activity_add_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class AddMainActivity : AppCompatActivity() {
    val db by lazy { TarefaDb(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_main)
        setupListener()
    }

    fun setupListener(){
        btn_adicionar.setOnClickListener{
          CoroutineScope(Dispatchers.IO).launch {
              db.tarefaDao().addTarefa(
                  Tarefa(0, edt_NomeTarefa.text.toString(), edt_local.text.toString())
              )
              finish()
          }
        }
    }
}