package com.yonjar.clashroyalestats.ui.startFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yonjar.clashroyalestats.data.RepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(private val repositoryImp: RepositoryImp): ViewModel() {

    private val _state = MutableStateFlow<StartFragmentState>(StartFragmentState.Success(""))
    var state: StateFlow<StartFragmentState> = _state

    fun verifyPlayer(playerTag:String){
        try {
            _state.value = StartFragmentState.Loading
            viewModelScope.launch {
                val response = repositoryImp.getPlayerInfo(playerTag)

                if(response != null){
                    _state.value = StartFragmentState.Success(playerTag)
                } else{
                    _state.value = StartFragmentState.Error("Player was not found")
                }
            }
        } catch (e:Exception){
            _state.value = StartFragmentState.Error(e.message ?: "Unknown error")
        }
    }

}