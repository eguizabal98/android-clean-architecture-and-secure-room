package com.example.secureroombase.ui.create

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.domain.Person
import com.example.domain.domain.Result
import com.example.domain.interactor.SavePersonUseCase
import kotlinx.coroutines.launch

class CreatePersonViewModel(private val savePersonUseCase: SavePersonUseCase) : ViewModel() {

    val firstNameField = ObservableField<String>()
    val secondNameField = ObservableField<String>()
    val ageField = ObservableField<String>()

    private val _savePersonState = MutableLiveData<Result<Person>>()
    val savePersonState: LiveData<Result<Person>>
        get() = _savePersonState

    fun checkForSavePerson() {
        if (checkFields()) {
            savePerson()
        }
    }

    private fun savePerson() {
        val person =
            Person(0, firstNameField.get()!!, secondNameField.get()!!, ageField.get()!!.toInt())
        _savePersonState.value = Result.Loading
        viewModelScope.launch {
            _savePersonState.postValue(savePersonUseCase.invoke(person))
        }
    }

    fun cleanFields() {
        firstNameField.set("")
        secondNameField.set("")
        ageField.set("")
    }

    private fun checkFields(): Boolean =
        !firstNameField.get().isNullOrEmpty() &&
                !secondNameField.get().isNullOrEmpty() &&
                !ageField.get().isNullOrEmpty()


}