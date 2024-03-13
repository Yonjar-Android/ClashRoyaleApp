package com.yonjar.clashroyalestats.ui.cardsDetailActivity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class CardDetailViewModel: ViewModel() {

    private val _state = MutableStateFlow<CardDetailState>(CardDetailState.Loading)
    var state: StateFlow<CardDetailState> = _state

}