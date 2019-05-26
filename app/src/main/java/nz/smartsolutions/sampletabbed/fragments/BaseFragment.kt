package nz.smartsolutions.sampletabbed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import nz.smartsolutions.sampletabbed.activities.MainActivity
import nz.smartsolutions.sampletabbed.viewmodels.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding>(private val mViewModelClass: Class<VM>) : Fragment(){

    lateinit var viewModel: VM
    lateinit var sharedViewModel: VM
    open lateinit var mBinding: DB

    fun init(inflater: LayoutInflater, container: ViewGroup) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
    }

    open fun init() {}
    @LayoutRes
    abstract fun getLayoutRes(): Int

    private fun getViewM(): VM = ViewModelProviders.of(this).get(mViewModelClass)
    private fun getSharedViewM(): VM = ViewModelProviders.of(activity as MainActivity).get(mViewModelClass)
    open fun onInject() {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewM()
        sharedViewModel = getSharedViewM()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        init(inflater, container!!)
        init()
        super.onCreateView(inflater, container, savedInstanceState)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel = getSharedViewM()
    }

    open fun refresh() {}
}
