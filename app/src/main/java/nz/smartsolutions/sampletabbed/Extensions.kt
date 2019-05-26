package nz.smartsolutions.sampletabbed

import androidx.lifecycle.*

inline fun <T> dependantLiveData(vararg dependencies: LiveData<*>, crossinline mapper: () -> T?) =
    MediatorLiveData<T>().also { mediatorLiveData ->
        val observer = Observer<Any> { mediatorLiveData.value = mapper() }
        dependencies.forEach { dependencyLiveData ->
            mediatorLiveData.addSource(dependencyLiveData, observer)
        }
    }


