package com.yonjar.clashroyalestats.ui.badgesFragment

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class BadgesViewModel: ViewModel() {

    private val _state = MutableStateFlow<BadgesState>(BadgesState.Loading)
    var state: StateFlow<BadgesState> = _state

}