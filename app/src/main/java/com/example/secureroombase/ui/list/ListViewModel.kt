package com.example.secureroombase.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.domain.Person
import com.example.domain.domain.Result
import com.example.domain.interactor.GetAllPersonUseCase
import kotlinx.coroutines.launch

class ListViewModel(private val getAllPersonUseCase: GetAllPersonUseCase) : ViewModel() {

    private val _getPersonState = MutableLiveData<Result<List<Person?>>>()
    val getPersonState: LiveData<Result<List<Person?>>>
        get() = _getPersonState

    fun getPersonList() {
        _getPersonState.value = Result.Loading
        viewModelScope.launch {
            _getPersonState.postValue(getAllPersonUseCase.invoke())
        }
    }

}