package com.androar.mvvmtodo.ui.tasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.androar.mvvmtodo.R
import com.androar.mvvmtodo.databinding.TasksFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksFragment : Fragment(R.layout.tasks_fragment) {

    companion object {
        private const val TAG = "TasksFragment"
        fun newInstance() = TasksFragment()
    }

    private val viewModel by viewModels<TasksViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = TasksFragmentBinding.bind(view)

        val tasksAdapter = TasksAdapter()

        binding.apply {
            recyclerViewTasks.apply {
                setHasFixedSize(true)
                adapter = tasksAdapter
            }
        }

        viewModel.tasks.observe(viewLifecycleOwner) {
            tasksAdapter.submitList(it)
        }

    }

}