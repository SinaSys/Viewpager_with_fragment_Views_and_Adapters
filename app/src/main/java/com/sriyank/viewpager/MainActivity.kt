package com.sriyank.viewpager

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.sriyank.viewpager.fragmentpager.FooItems
import com.sriyank.viewpager.fragmentpager.MyFragmentStateAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()

        setupViewPagerWithFragments()
    }

    fun setupViewPagerWithFragments() {

        val adapter = MyFragmentStateAdapter(this, FooItems.list!!)
        viewPagerWithFragment.adapter = adapter
        viewPagerWithFragment.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    fun setupViewPager() {

        val adapter = MyAdapter(this, Items.list!!)

        viewPager2.adapter = adapter
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                Toast.makeText(this@MainActivity, "$position selected", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
