package com.example.midasandroid2.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.exception.NeedLoginException
import com.example.midasandroid2.util.MutableEventFlow
import com.example.midasandroid2.util.asEventFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<T> : ViewModel() {

    private val _eventFlow = MutableEventFlow<T>()
    val eventFlow = _eventFlow.asEventFlow()

    protected suspend fun emitEvent(event: T){
        _eventFlow.emit(event)
    }

    protected fun <V> execute(
        job: suspend () -> V,
        onSuccess: suspend (value: V) -> Unit,
        onFailure: suspend (t: Throwable) -> Unit
    ) = viewModelScope.launch {
        kotlin.runCatching { job() }
            .onSuccess { onSuccess(it) }
            .onFailure {
                if(it is NeedLoginException) throw it
                onFailure(it)
            }
    }
}