package com.yonjar.clashroyalestats.ui.cardsFragment

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(): ViewModel() {
    private val _state = MutableStateFlow<CardsState>(CardsState.Loading)
    var state: StateFlow<CardsState> = _state

}