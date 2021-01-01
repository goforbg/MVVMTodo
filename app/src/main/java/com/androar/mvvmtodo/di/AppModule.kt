package com.androar.mvvmtodo.di

import android.app.Application
import androidx.room.Room
import com.androar.mvvmtodo.Constants.TASKS_DATABASE_NAME
import com.androar.mvvmtodo.data.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDatabase(applicationContext: Application, callBack: TaskDatabase.CallBack) =
        Room.databaseBuilder(applicationContext, TaskDatabase::class.java, TASKS_DATABASE_NAME)
            .fallbackToDestructiveMigration() //Drops table and create new one when schema replaced.
            .addCallback(callBack)
            .build()

    @Provides
    @Singleton //Not needed
    fun provideTaskDao(taskDatabase: TaskDatabase) =
        taskDatabase.taskDao()

    @Provides
    @Singleton
    @ApplicationScope
    //Creating this as an alternative to Global scope so it dies along with application, since it's single tone installed in AppComponent
    fun provideApplicationScope() =
        CoroutineScope(SupervisorJob()) //Supervisor job helps in other child jobs running when one fails (which is default of coroutine scope)

}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope //This is so that if later there's more than one co routine scope, it will know which one to pick.