package com.example.mywishlist.ui

sealed interface UiEvent {
    object OnViewCardClicked : UiEvent
    object OnAddCardClicked : UiEvent
    object OnSearchCardClicked : UiEvent
    object OnSaveClicked : UiEvent {

    }


    data class OnSetTitle(val title: String) : UiEvent
    data class OnSetWebsite(val website: String) : UiEvent
    data class OnSetImage(val image: String) : UiEvent
    data class OnSetPriority(val priority: com.example.mywishlist.data.Priority) : UiEvent
}