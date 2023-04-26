package com.example.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.data.Cat
import kotlinx.coroutines.*

class MainViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val catsList = MutableLiveData<List<Cat>>()
    var job: Job? = null
    val exceptionHandler =
        CoroutineExceptionHandler { _, throwable -> onError("Exception handled: ${throwable.localizedMessage}") }
    val loading = MutableLiveData<Boolean>()

    fun getAllCats() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = mainRepository.getAllCats()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    catsList.postValue(response.body())
                    Log.d("TAG", response.body().toString())
                    loading.value = false
                } else {
                    onError("Error: ${response.message()}")
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        loading.postValue(false)
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.postValue(false)
    }
}
