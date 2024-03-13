package com.yonjar.clashroyalestats.ui.startFragment

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class StartViewModel: ViewModel() {

    private val _state = MutableStateFlow<StartFragmentState>(StartFragmentState.Loading)
    var state: StateFlow<StartFragmentState> = _state

}