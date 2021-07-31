package com.example.tarefas.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Tarefa
    (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val tarefa: String,
    val local: String
            )