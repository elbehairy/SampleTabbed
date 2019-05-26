package nz.smartsolutions.sampletabbed.activities

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

import nz.smartsolutions.sampletabbed.R
import nz.smartsolutions.sampletabbed.adapters.SectionsPagerAdapter
import nz.smartsolutions.sampletabbed.databinding.ActivityMainBinding
import nz.smartsolutions.sampletabbed.viewmodels.SharedViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView()

        val sectionsPagerAdapter =
            SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun bindView() {
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.setLifecycleOwner(this@MainActivity)
        binding.sharedviewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
    }
}