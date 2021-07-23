package com.gfdellatin.bootcamp_inter_businesscard

import android.app.Application
import com.gfdellatin.bootcamp_inter_businesscard.data.AppDatabase
import com.gfdellatin.bootcamp_inter_businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}