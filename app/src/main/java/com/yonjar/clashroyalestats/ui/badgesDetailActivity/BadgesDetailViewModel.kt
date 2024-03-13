package com.yonjar.clashroyalestats.ui.badgesDetailActivity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BadgesDetailViewModel @Inject constructor(): ViewModel() {

    private val _state = MutableStateFlow<BadgesDetailState>(BadgesDetailState.Loading)
    var state: StateFlow<BadgesDetailState> = _state

}