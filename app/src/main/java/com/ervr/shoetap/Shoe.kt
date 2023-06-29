package com.ervr.shoetap

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    val id: Int,
    val name: String,
    val price: Double,
    val image: String
) : Parcelable
