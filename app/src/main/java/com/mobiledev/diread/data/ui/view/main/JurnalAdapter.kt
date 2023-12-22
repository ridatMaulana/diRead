package com.mobiledev.diread.data.ui.view.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobiledev.diread.R
import com.mobiledev.diread.data.item.Jurnal
import com.mobiledev.diread.data.ui.view.bookmark.Bokmark
import com.mobiledev.diread.data.ui.view.detailJurnal.DetailJournalActivity

class JurnalAdapter(var jurnalList: List<Jurnal>, private var bookmarkClickListener: OnBookmarkClickListener) :
    RecyclerView.Adapter<JurnalAdapter.ListViewHolder>() {

    interface OnBookmarkClickListener {
        fun onBookmarkClick(jurnal: Jurnal)
    }

    fun setOnBookmarkClickListener(listener: OnBookmarkClickListener) {
        this.bookmarkClickListener = listener
    }
    private var filteredList: List<Jurnal> = jurnalList

    class ListViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val gambar: ImageView = itemview.findViewById(R.id.imageJurnal)
        val judulJurnal: TextView = itemview.findViewById(R.id.judulJurnal)
        val abstract: TextView = itemview.findViewById(R.id.abstrack)
        val icon: ImageView = itemview.findViewById(R.id.iconBookmark)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.journal_item, parent, false)
        return ListViewHolder(itemView)
    }

    fun setFilter(List: List<Jurnal>) {
        this.jurnalList = List
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        if (position < filteredList.size) {
            val (gambar, judul, abstract, webLink, bookmarked) = filteredList[position]
            val jurnal=filteredList[position]
            holder.gambar.setImageResource(gambar)
            holder.judulJurnal.text = judul
            holder.abstract.text = abstract

            holder.itemView.setOnClickListener {
                val intentDetail =
                    Intent(holder.itemView.context, DetailJournalActivity::class.java)
                intentDetail.putExtra("shadow", jurnalList[holder.adapterPosition])
                holder.itemView.context.startActivities(arrayOf(intentDetail))
            }


            holder.icon.setOnClickListener {
                val updatedBookmarkState = !jurnal.isBookmarked
                jurnalList.firstOrNull { it == jurnal }?.isBookmarked = updatedBookmarkState
                if (updatedBookmarkState==true) {
                    holder.icon.setImageResource(R.drawable.baseline_bookmark_24)
                    notifyItemChanged(position)
                } else if (updatedBookmarkState==false){
                    holder.icon.setImageResource(R.drawable.bookmarkosong)
                }else{

                }
                bookmarkClickListener.onBookmarkClick(jurnal)
            }
        }

    }


    override fun getItemCount(): Int = jurnalList.size
}
