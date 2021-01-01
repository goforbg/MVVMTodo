package com.androar.mvvmtodo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.androar.mvvmtodo.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    class CallBack @Inject constructor(
        private val database: Provider<TaskDatabase>, //Provider of something is Lazy loading
        @ApplicationScope private val applicationScope: CoroutineScope //The annotation scope is so that if later there's more than one co routine scope, it will know which one to pick.
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            //executed a little later after build of App Module provide Task Database
            val dao = database.get().taskDao()
            //Doing all this shit so we can have some data inside it on start itself like new google task app has dummy to-dos
            applicationScope.launch {
                dao.insert(Task("This is a task"))
                dao.insert(Task("This is an important task", isImportant = true))
            } //Better alternative to Global scope.
        }

    }

}