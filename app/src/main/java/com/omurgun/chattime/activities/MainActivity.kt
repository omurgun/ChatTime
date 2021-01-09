package com.omurgun.chattime.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.omurgun.chattime.R
import com.omurgun.chattime.adapters.SectionsPagerAdapter
import com.omurgun.chattime.databinding.ActivityMainBinding
import com.omurgun.chattime.fragments.CallsFragment
import com.omurgun.chattime.fragments.CameraFragment
import com.omurgun.chattime.fragments.ChatsFragment
import com.omurgun.chattime.fragments.StatusFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setUpWithViewPager(binding.viewPager)
        setContentView(binding.root)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        setSupportActionBar(binding.toolbar)

        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                changeFabICon(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

    }
    private fun setUpWithViewPager(viewPager: ViewPager) {
        val adapter = SectionsPagerAdapter(supportFragmentManager)
        adapter.addFragment(CameraFragment(), "")
        adapter.addFragment(ChatsFragment(), "Chats")
        adapter.addFragment(StatusFragment(), "Status")
        adapter.addFragment(CallsFragment(), "Calls")
        viewPager.adapter = adapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_search -> Toast.makeText(
                this@MainActivity,
                "Action Search",
                Toast.LENGTH_LONG
            ).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun changeFabICon(index: Int) {
        binding.fabAction.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            when (index) {
                0 -> binding.fabAction.hide()
                1 -> {
                    binding.fabAction.show()
                    binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_chat_24))
                }
                2 -> {
                    binding.fabAction.show()
                    binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_camera_alt_24))
                }
                3 -> {
                    binding.fabAction.show()
                    binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_call_24))
                }
            }
        }, 400)
    }
}