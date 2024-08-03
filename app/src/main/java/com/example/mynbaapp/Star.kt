package com.example.mynbaapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Star(
    val name: String,
    val team: String,
    val photo : Int,
    val desc: String,
    val height: String,
    val pos: String,

): Parcelable
