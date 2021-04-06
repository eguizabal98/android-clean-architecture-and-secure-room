package com.example.secureroombase.ui.update

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.domain.Person
import com.example.domain.domain.Result
import com.example.domain.interactor.DeletePersonUseCase
import com.example.domain.interactor.GetPersonUseCase
import com.example.domain.interactor.UpdatePersonUseCase
import kotlinx.coroutines.launch

class UpdateViewModel(
    private val getPersonUseCase: GetPersonUseCase,
    private val updatePersonUseCase: UpdatePersonUseCase,
    private val deletePersonUseCase: DeletePersonUseCase
) : ViewModel() {

    val firstNameField = ObservableField<String>()
    val secondNameField = ObservableField<String>()
    val ageField = ObservableField<String>()
    private var currentPerson: Person? = null

    private val _updatePersonState = MutableLiveData<Result<Person>>()
    val updatePersonState: LiveData<Result<Person>>
        get() = _updatePersonState

    private val _getPersonState = MutableLiveData<Result<Person?>>()
    val getPersonState: LiveData<Result<Person?>>
        get() = _getPersonState

    private val _deletePersonState = MutableLiveData<Result<Boolean>>()
    val deletePersonState: LiveData<Result<Boolean>>
        get() = _deletePersonState

    fun checkForUpdatePerson() {
        if (checkFields()) {
            updatePerson()
        }
    }

    private fun updatePerson() {
        val person =
            Person(
                currentPerson!!.id,
                firstNameField.get()!!,
                secondNameField.get()!!,
                ageField.get()!!.toInt()
            )
        _updatePersonState.value = Result.Loading
        viewModelScope.launch {
            _updatePersonState.postValue(updatePersonUseCase.invoke(person))
        }
    }

    fun getPerson(id: Int) {
        _getPersonState.value = Result.Loading
        viewModelScope.launch {
            _getPersonState.postValue(getPersonUseCase.invoke(id))
        }
    }

    fun deletePerson() {
        _deletePersonState.value = Result.Loading
        viewModelScope.launch {
            _deletePersonState.postValue(deletePersonUseCase.invoke(currentPerson!!.id))
        }
    }

    private fun checkFields(): Boolean =
        !firstNameField.get().isNullOrEmpty() &&
                !secondNameField.get().isNullOrEmpty() &&
                !ageField.get().isNullOrEmpty()

    fun assignPerson(person: Person) {
        currentPerson = person
        firstNameField.set(person.name)
        secondNameField.set(person.secondName)
        ageField.set(person.age.toString())
    }

}