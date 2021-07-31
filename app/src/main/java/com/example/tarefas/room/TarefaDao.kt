package com.example.tarefas.room

import androidx.room.*

@Dao
interface TarefaDao {
    @Insert
    suspend fun addTarefa(tarefa: Tarefa)

    @Update
    suspend fun attTarefa(tarefa: Tarefa)

    @Delete
    suspend fun delTarefa (tarefa: Tarefa)

    @Query ("SELECT * FROM Tarefa")
    suspend fun getTarefas(): List<Tarefa>

}