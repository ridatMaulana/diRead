package com.mobiledev.diread.data.ui.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobiledev.diread.R
import com.mobiledev.diread.data.item.Jurnal
import com.mobiledev.diread.databinding.FragmentHomeBinding
import java.util.Locale

class HomeFragment : Fragment(),JurnalAdapter.OnBookmarkClickListener{

    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchBar: SearchView
    private lateinit var jurnalAdapter: JurnalAdapter
    private val mlist = ArrayList<Jurnal>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rvJournal
        recyclerView.setHasFixedSize(true)
        mlist.addAll(getList())
        showRecyclerView()

        searchBar = binding.searchSr
        jurnalAdapter = JurnalAdapter(mlist,this)
        jurnalAdapter.setOnBookmarkClickListener(this)
        recyclerView.adapter = jurnalAdapter

        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    filter(newText)
                }
                return true
            }
        })
    }

    private fun filter(query: String) {
        val filterjurnal = ArrayList<Jurnal>()
        for (i in mlist) {
            if (i.Judul.toLowerCase(Locale.ROOT).contains(query)) {
                filterjurnal.add(i)
            }
        }
        if (filterjurnal.isEmpty()) {
            Toast.makeText(requireContext(), "Tidak ada data", Toast.LENGTH_SHORT).show()
        } else {
            jurnalAdapter.setFilter(filterjurnal)
        }
    }

    private fun showRecyclerView() {
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        val listJurnal = JurnalAdapter(mlist,this)
        recyclerView.adapter = listJurnal
    }

    private fun getList(): ArrayList<Jurnal> {
        val gambar = resources.obtainTypedArray(R.array.data_gambar)
        val dataJudul = resources.getStringArray(R.array.judul_jurnal)
        val dataAbstrak = resources.getStringArray(R.array.Abstrack)
        val linkWeb = resources.getStringArray(R.array.link_web)
        val listJurnal = ArrayList<Jurnal>()

        val minSize = minOf(gambar.length(), dataJudul.size, dataAbstrak.size, linkWeb.size)

        for (i in 0 until minSize) {
            val jurnal = Jurnal(
                gambar.getResourceId(i, -1),
                dataJudul.getOrElse(i) { "" },
                dataAbstrak.getOrElse(i) { "" },
                linkWeb.getOrElse(i) { "" }
            )
            listJurnal.add(jurnal)
        }
        return listJurnal
    }



    override fun onBookmarkClick(jurnal: Jurnal) {
        if (jurnal.isBookmarked) {
            (activity as? MainActivity)?.updateBookmarkList(jurnal)
        } else {
        }
    }
}