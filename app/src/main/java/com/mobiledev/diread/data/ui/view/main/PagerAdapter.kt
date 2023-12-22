package com.mobiledev.diread.data.ui.view.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobiledev.diread.data.ui.view.bookmark.Bokmark
import com.mobiledev.diread.data.ui.view.profile.Profile

class PagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return 3
    }
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->HomeFragment()
            1->Bokmark()
            2->Profile()
            else->throw IllegalArgumentException("invalid Position")
        }
    }
}