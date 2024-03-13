package com.yonjar.clashroyalestats.ui.cardsFragment

import androidx.lifecycle.ViewModel
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltAndroidApp
class CardsViewModel: ViewModel() {
    private val _state = MutableStateFlow<CardsState>(CardsState.Loading)
    var state: StateFlow<CardsState> = _state

}