package com.gfdellatin.bootcamp_inter_businesscard.data

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessCard(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String?,
    val enterprise: String?,
    val phone: String?,
    val email: String?,
    val colorPersonalization: String?
)