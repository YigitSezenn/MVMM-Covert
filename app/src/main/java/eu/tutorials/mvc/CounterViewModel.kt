package eu.tutorials.mvc

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel( ) { // Create a class CounterViewModel that extends ViewModel
    private  val  _repository:CounterModel.CounterRepository= CounterModel.CounterRepository() // Create an instance of the CounterRepository class
    private val _count = mutableStateOf(_repository.getCounter().count) // Create a MutableState variable _count and initialize it with the value of the count variable of the CounterModel.CounterRepository instance
    val count: MutableState<Int> = _count // Create a MutableState variable count and initialize it with the value of _count

    fun  incrementCount() { // Create a function incrementCount() that increments the count variable of the CounterModel.CounterRepository instance
        _repository.incrementCounter() // Call the incrementCounter() function of the CounterModel.CounterRepository instance
        _count.value = _repository.getCounter().count   // Update the value of the _count variable with the value of the count variable of the CounterModel.CounterRepository instance
    }

    fun DecrementCount() {
       _repository.decrementCounter()
        _count.value = _repository.getCounter().count

    }
}