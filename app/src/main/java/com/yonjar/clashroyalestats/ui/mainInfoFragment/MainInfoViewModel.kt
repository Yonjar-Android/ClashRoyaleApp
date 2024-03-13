package com.yonjar.clashroyalestats.ui.mainInfoFragment

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class MainInfoViewModel: ViewModel() {

    private val _state = MutableStateFlow<MainInfoState>(MainInfoState.Loading)
    var state: StateFlow<MainInfoState> = _state

}