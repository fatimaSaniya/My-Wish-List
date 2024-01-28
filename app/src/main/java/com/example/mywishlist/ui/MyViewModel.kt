package com.example.mywishlist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywishlist.data.Item
import com.example.mywishlist.data.Priority
import com.example.mywishlist.data.WishListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MyViewModel(private val itemsRepository: WishListRepository) : ViewModel() {
    private var _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            itemsRepository.getWishList().collect(){items ->
                _uiState.update { it.copy( items = items) }
            }
        }
    }

    fun onEvent(event: UiEvent) {
        when (event) {
            UiEvent.OnSaveClicked -> saveToDatabase()
            is UiEvent.OnSetImage -> {
                _uiState.update { it.copy(img = event.image) }
            }

            is UiEvent.OnSetPriority -> {
                _uiState.update { it.copy(priority = event.priority) }
            }

            is UiEvent.OnSetTitle -> {
                _uiState.update { it.copy(title = event.title) }
            }

            is UiEvent.OnSetWebsite -> {
                _uiState.update { it.copy(website = event.website) }
            }

            else -> {}
        }
    }

    private fun saveToDatabase() {
        val item = Item(
            title = uiState.value.title,
            website = uiState.value.website,
            priority = uiState.value.priority,
            img = uiState.value.img,
        )

        viewModelScope.launch {
            itemsRepository.addItem(item)
            clearUiState()
        }
    }

    private fun clearUiState(){
        _uiState.update {
            it.copy(
                title = " ",
                priority = Priority.Low,
                website = " ",
                img = " ",
            )
        }
    }
}