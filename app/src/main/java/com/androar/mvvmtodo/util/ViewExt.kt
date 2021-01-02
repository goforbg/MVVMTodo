package com.androar.mvvmtodo.util

import androidx.appcompat.widget.SearchView

inline fun SearchView.onQueryChanged(crossinline listener: (String) -> Unit) {
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

        override fun onQueryTextSubmit(query: String?): Boolean {
            return true //we handled the submit, we need live updates like Insta search
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            listener(newText.orEmpty())
            return true //Handled it.
        }

    })
}