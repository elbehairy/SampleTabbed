package nz.smartsolutions.sampletabbed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import nz.smartsolutions.sampletabbed.R
import nz.smartsolutions.sampletabbed.viewmodels.SharedViewModel

class Tab2Fragment : BaseFragment<SharedViewModel, nz.smartsolutions.sampletabbed.databinding.Tab2FragmentBinding>(
    SharedViewModel::class.java) {

    companion object {
        fun newInstance() = Tab2Fragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        init(inflater, container!!)
        mBinding.lifecycleOwner = this
        return mBinding.root
    }
    override fun getLayoutRes() = R.layout.tab2_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.sharedviewModel = sharedViewModel
        // TODO: Use the ViewModel
    }

}
