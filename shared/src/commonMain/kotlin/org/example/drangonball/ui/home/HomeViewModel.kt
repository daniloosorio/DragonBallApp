package org.example.drangonball.ui.home

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(): ViewModel() {

    private val _example = MutableStateFlow<String>(viewModelScope,"pepe")
    @NativeCoroutines
    val example : StateFlow<String> = _example

}