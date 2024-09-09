package com.demo.zapcom.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.zapcom.data.api.ApiService
import com.demo.zapcom.data.model.Item
import com.demo.zapcom.data.repository.ItemRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(private val repository : ItemRepository) : ViewModel() {
    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items
    init {
        viewModelScope.launch {
            _items.value = repository?.getItems()
        }
    }
}