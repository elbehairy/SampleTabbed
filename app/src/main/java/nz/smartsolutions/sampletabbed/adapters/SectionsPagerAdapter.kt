package nz.smartsolutions.sampletabbed.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import nz.smartsolutions.sampletabbed.R
import nz.smartsolutions.sampletabbed.fragments.Tab1Fragment
import nz.smartsolutions.sampletabbed.fragments.Tab2Fragment
import nz.smartsolutions.sampletabbed.fragments.Tab3Fragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)
private val TAB_CLASES = arrayOf(
    Tab1Fragment::class.java,
    Tab2Fragment::class.java,
    Tab3Fragment::class.java
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a FragmentClass instance (defined as a static inner class below).
        return TAB_CLASES[position].newInstance()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return TAB_CLASES.size
    }
}