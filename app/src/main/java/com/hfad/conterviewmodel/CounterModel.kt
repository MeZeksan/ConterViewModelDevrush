package com.hfad.conterviewmodel
//MODEL - Логика Приложения
data class CounterModel( var count: Int)

class CounterRepository{
    //создали объект data class, из него можно брать переменную count
    private var _counter = CounterModel(0)

    fun getCounter() = _counter

    fun incrementCounter(){
        _counter.count++
    }
    fun decrementCounter(){
        _counter.count--
    }
}