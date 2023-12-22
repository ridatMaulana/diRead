package com.mobiledev.diread.data.item

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Jurnal(
    val gambar:Int,
    val Judul:String,
    val abstract:String,
    val webLink:String,
    var isBookmarked:Boolean=true
):Parcelable
