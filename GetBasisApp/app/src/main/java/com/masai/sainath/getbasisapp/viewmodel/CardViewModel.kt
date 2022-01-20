package com.masai.sainath.getbasisapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.masai.sainath.getbasisapp.Model.data.ResponseModel
import com.masai.sainath.getbasisapp.repo.CardRepo
import com.masai.sainath.getbasisapp.Model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
open class CardViewModel @Inject constructor(val cardRepo: CardRepo) : ViewModel() {

     fun getData(): LiveData<Resource<ResponseModel>> {
        return liveData(Dispatchers.IO) {
            val response = cardRepo.getData()
            emit(response)
        }
    }
}