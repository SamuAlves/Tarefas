package com.example.tarefas.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Tarefa::class],
    version = 1
)
abstract class TarefaDb : RoomDatabase(){
    abstract fun tarefaDao() : TarefaDao
    companion object {
        @Volatile private var instance : TarefaDb? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{
                instance = it

            }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TarefaDb::class.java,
            "tarefas.db"
        ).build()
    }

}

