package com.example.tarefas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarefas.room.TarefaDb
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    val db by lazy { TarefaDb(this) }
    lateinit var tarefasAdapter: TarefasAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val tarefas = db.tarefaDao().getTarefas()
            Log.d("MainActivity","dbresponse: $tarefas")
            withContext(Dispatchers.Main){
                tarefasAdapter.setData(tarefas)
            }
        }
    }

    fun setupListener(){
        AddTarefa.setOnClickListener {
            startActivity(Intent(this, AddMainActivity::class.java))
        }
    }
    private fun setupRecyclerView(){
        tarefasAdapter = TarefasAdapter(arrayListOf())
        rv_tarefa.apply{
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = tarefasAdapter
        }
    }
}