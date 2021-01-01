package com.androar.mvvmtodo.ui.tasks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.androar.mvvmtodo.R

class AddEditTasksFragment : Fragment(R.layout.add_edit_tasks_fragment) {

    companion object {
        private const val TAG = "AddEditTasksFragment"
        fun newInstance() = AddEditTasksFragment()
    }

    private val viewModel by viewModels<AddEditTasksViewModel>()


}