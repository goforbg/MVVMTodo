package com.androar.mvvmtodo.ui.tasks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.androar.mvvmtodo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksFragment : Fragment(R.layout.tasks_fragment) {

    companion object {
        private const val TAG = "TasksFragment"
        fun newInstance() = TasksFragment()
    }

    private val viewModel by viewModels<TasksViewModel>()


}