package com.mobiledev.diread.data.ui.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mobiledev.diread.data.ui.view.ViewModelFactory
import com.mobiledev.diread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:MainViewModel by viewModels{
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager=GridLayoutManager(applicationContext)
        binding.recyclerView.adapter=JurnalAdapter

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(menuItemSelected)with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView.editText.setOnEditorActionListener { textView, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    val searchKeyword = searchView.text.toString()
                    performSearch(searchKeyword)
                    searchView.hide()
                }
                return@setOnEditorActionListener false
            }
        }
        if(savedInstanceState==null){
            viewModel.getUser()
        }

    }
}