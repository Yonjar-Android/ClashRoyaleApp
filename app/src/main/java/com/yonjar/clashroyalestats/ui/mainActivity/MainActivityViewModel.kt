package com.yonjar.clashroyalestats.ui.mainActivity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(): ViewModel() {

    private val _state = MutableStateFlow<MainActivityState>(MainActivityState.Loading)
    var state: StateFlow<MainActivityState> = _state

}