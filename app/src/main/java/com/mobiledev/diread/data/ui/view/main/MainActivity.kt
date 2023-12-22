package com.mobiledev.diread.data.ui.view.main

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mobiledev.diread.R
import com.mobiledev.diread.data.item.Jurnal
import com.mobiledev.diread.data.ui.view.ViewModelFactory
import com.mobiledev.diread.data.ui.view.bookmark.Bokmark
import com.mobiledev.diread.data.ui.view.welcome.WelcomeActivity
import com.mobiledev.diread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    companion object {
        @StringRes
        private val TAB_TITLE = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3
        )

        @ArrayRes
        private val TAB_ICON = intArrayOf(
            R.drawable.baseline_home_24,
            R.drawable.baseline_bookmark_24,
            R.drawable.baseline_person_24
        )
    }

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeSession()
        setupView()
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        val selectionPagerAdapter = PagerAdapter(this)
        viewPager.adapter = selectionPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            val customeTab = layoutInflater.inflate(R.layout.tab_item, null)
            val tabIcon = customeTab.findViewById<ImageView>(R.id.tabIcon)
            val tabText = customeTab.findViewById<TextView>(R.id.tabText)
            tabIcon.setImageResource(TAB_ICON[position])
            tabText.text = resources.getString(TAB_TITLE[position])
            tab.customView = customeTab
        }.attach()
    }

    private fun observeSession() {
        viewModel.userSession.observe(this) { user ->
            if (user.isNullOrEmpty()) {
                startActivity(Intent(this@MainActivity, WelcomeActivity::class.java))
                finish()
            }
        }
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

    fun updateBookmarkList(jurnal: Jurnal){
        val bokmarkFragment = supportFragmentManager.findFragmentByTag(Bokmark::class.java.simpleName)
        if (bokmarkFragment is Bokmark) {
            bokmarkFragment.updateBookmarkList(jurnal)
        }
    }



}