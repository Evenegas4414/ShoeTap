package com.ervr.shoetap

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    val name: String,
    val imageUrl: String,
    val price: Double
) : Parcelable
