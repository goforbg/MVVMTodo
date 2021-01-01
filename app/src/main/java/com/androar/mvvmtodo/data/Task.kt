package com.androar.mvvmtodo.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.androar.mvvmtodo.Constants.TASKS_TABLE_NAME
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

@Entity(tableName = TASKS_TABLE_NAME) //Room DB Table
@Parcelize
data class Task(
    val name: String,
    val isImportant: Boolean = false,
    val isCompleted: Boolean = false,
    val dateCreated: Long = System.currentTimeMillis(), //Defaults to current time in millis which is stored in Long,
    @PrimaryKey(autoGenerate = true) val id: Int = 0 //Room DB will auto generate for each starting from 0.
) : Parcelable {
    val dateCreatedString: String
        get() = DateFormat.getDateTimeInstance()
            .format(dateCreated) //Formats date to human-readable string. Jan 1, 2021, 9:43 AM
}