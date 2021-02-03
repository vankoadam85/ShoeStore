package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {


    private val _shoeList = MutableLiveData<MutableList<Shoe>>(
        mutableListOf(
//        Initial data seed
            Shoe("Test", 12.0, "Test", "Test"),
            Shoe("Air Jordan", 23.0, "Nike", "slam dunk")
        )
    )
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private var _newShoe = Shoe("", 0.0, "", "")
    val newShoe
        get() = _newShoe

    fun saveNewShoe() {
        _shoeList.value?.add(_newShoe)
        _newShoe = Shoe("", 0.0, "", "")
    }
}