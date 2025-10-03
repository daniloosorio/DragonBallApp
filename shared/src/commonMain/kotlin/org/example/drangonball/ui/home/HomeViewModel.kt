package org.example.drangonball.ui.home

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import org.example.drangonball.domain.Repository
import org.example.drangonball.domain.model.CharacterModel

class HomeViewModel(private val repository: Repository): ViewModel() {

    private val _example = MutableStateFlow<String>(viewModelScope,"pepe")
    @NativeCoroutines
    val example : StateFlow<String> = _example

    private val _characters = MutableStateFlow<List<CharacterModel>>(viewModelScope,emptyList())
    @NativeCoroutines
    val characters : StateFlow<List<CharacterModel>> = _characters

    init {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO){
                repository.getCharacters()
            }
            _characters.value = response
        }
    }
}