package com.example.edudemo.data.local.courses

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class coursesViewModelProviderFactory  (val app: Application
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return coursesViewModel(app) as T
    }
}


