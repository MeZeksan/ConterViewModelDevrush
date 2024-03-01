package com.hfad.conterviewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
//VIEW MODEL - Связь между CounterModel с помощью переменной _repository и MainActivity
class CounterViewModel() :ViewModel() {
    //создаем экзепляр класса CounterRepository()
    private val _repository: CounterRepository = CounterRepository()
    private val _count = mutableStateOf(_repository.getCounter().count)
    val count = _count

    //суть в том, что вся логика происходит в отдельном классе.
    fun increment() {
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }

    fun decrement() {
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }

}