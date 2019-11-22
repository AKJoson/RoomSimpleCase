package com.cherry.room.database

import androidx.room.Room
import com.cherry.room.BaseApplication.Companion.appContext

class DaoManager {
    companion object {
        val db = Room.databaseBuilder(
            appContext,
            AppDataBase::class.java, "yp-database"
        ).build()
    }
}
