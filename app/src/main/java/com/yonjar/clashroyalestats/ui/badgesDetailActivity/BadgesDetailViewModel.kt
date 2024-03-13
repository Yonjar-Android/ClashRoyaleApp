package com.yonjar.clashroyalestats.ui.badgesDetailActivity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class BadgesDetailViewModel: ViewModel() {

    private val _state = MutableStateFlow<BadgesDetailState>(BadgesDetailState.Loading)
    var state: StateFlow<BadgesDetailState> = _state

}