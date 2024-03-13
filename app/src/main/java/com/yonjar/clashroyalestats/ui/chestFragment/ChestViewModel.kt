package com.yonjar.clashroyalestats.ui.chestFragment

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class ChestViewModel: ViewModel() {

    private val _state = MutableStateFlow<ChestState>(ChestState.Loading)
    var state: StateFlow<ChestState> = _state

}