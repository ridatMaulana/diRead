package com.mobiledev.diread.data.ui.view.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobiledev.diread.R
import com.mobiledev.diread.data.item.Jurnal
import com.mobiledev.diread.data.ui.view.main.JurnalAdapter
import com.mobiledev.diread.databinding.FragmentBokmarkBinding

class Bokmark : Fragment(), JurnalAdapter.OnBookmarkClickListener {

    private lateinit var binding: FragmentBokmarkBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var jurnalAdapter: JurnalAdapter
    private val mlist = ArrayList<Jurnal>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBokmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rvBookmark
        recyclerView.setHasFixedSize(true)
        mlist.addAll(getList())

        jurnalAdapter = JurnalAdapter(mlist, this)

        recyclerView.adapter = jurnalAdapter
        showRecyclerView()

    }

    private fun showRecyclerView() {
        val bookmarkedList = mlist.filter { it.isBookmarked == true }
        recyclerView.adapter = JurnalAdapter(bookmarkedList, this)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
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
                linkWeb.getOrElse(i) { "" },
            )
            listJurnal.add(jurnal)
        }
        return listJurnal
    }

    fun updateBookmarkList(jurnal: Jurnal) {
        if (jurnal.isBookmarked == true) {
            mlist.add(jurnal)
        } else {
            mlist.remove(jurnal)
        }
        jurnalAdapter.notifyDataSetChanged()
        showRecyclerView()
    }


    override fun onBookmarkClick(jurnal: Jurnal) {
        updateBookmarkList(jurnal)
    }
}