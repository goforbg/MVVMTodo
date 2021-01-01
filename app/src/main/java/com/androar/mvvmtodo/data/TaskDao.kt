package com.androar.mvvmtodo.data

import androidx.room.*
import com.androar.mvvmtodo.Constants.TASKS_TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //probably wanna use replace on all inserts.
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM $TASKS_TABLE_NAME")
    fun getTasks() : Flow<List<Task>>

}