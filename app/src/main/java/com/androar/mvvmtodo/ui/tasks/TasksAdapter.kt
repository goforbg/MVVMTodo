package com.androar.mvvmtodo.ui.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.androar.mvvmtodo.data.Task
import com.androar.mvvmtodo.databinding.ItemTasksBinding

class TasksAdapter : ListAdapter<Task, TasksAdapter.TaskViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTasksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = getItem(position)
        holder.bind(task)
    }

    inner class TaskViewHolder(private val binding: ItemTasksBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {

        }

        fun bind(task: Task): Unit {
            binding.apply {
                textViewName.text = task.name
                textViewName.paint.isStrikeThruText = task.isCompleted
                checkBoxCompleted.isChecked = task.isCompleted
                labelPriority.isVisible = task.isImportant
            }
        }

    }

    class DiffCallBack : DiffUtil.ItemCallback<Task>() {

        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean =
            oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean =
            oldItem == newItem

    }

}