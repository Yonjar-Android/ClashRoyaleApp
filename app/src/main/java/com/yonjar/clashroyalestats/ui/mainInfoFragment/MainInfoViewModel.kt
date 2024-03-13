package com.yonjar.clashroyalestats.ui.mainInfoFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yonjar.clashroyalestats.data.RepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainInfoViewModel @Inject constructor(private val repositoryImp: RepositoryImp): ViewModel() {

    private val _state = MutableStateFlow<MainInfoState>(MainInfoState.Loading)
    var state: StateFlow<MainInfoState> = _state

    fun chargePlayerInfo(tag:String){
        try {
            viewModelScope.launch {
                val response = repositoryImp.getPlayerInfo(tag)
                if(response != null){
                    _state.value = MainInfoState.Success(response)
                } else{
                    _state.value = MainInfoState.Error("Player was not found")
                }
            }
        }
        catch (e:Exception){
            _state.value = MainInfoState.Error(e.message ?: "Unknown error")
        }
    }
}