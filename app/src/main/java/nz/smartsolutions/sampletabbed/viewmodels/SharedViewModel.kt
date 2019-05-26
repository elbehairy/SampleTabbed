package nz.smartsolutions.sampletabbed.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import nz.smartsolutions.sampletabbed.dependantLiveData

class SharedViewModel(app: Application) : BaseViewModel(app) {
    // TODO: Implement the ViewModel
    val tab1text = MutableLiveData<String>()
    val tab2text = MutableLiveData<String>()
    val tab3text = MutableLiveData<String>()
    val activity2fragment = MutableLiveData<String>()

    val fragment2activity = dependantLiveData(tab1text, tab2text, tab3text) {
        String.format("Tab1 : %s, Tab2 : %s, Tab3 : %s", tab1text.value , tab2text.value , tab3text.value)
    }

    init {
        //(app as? App)?.component?.inject(this)
    }
}
