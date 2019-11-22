package com.cherry.room.viewmodel

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cherry.room.BaseApplication.Companion.appContext
import com.cherry.room.database.AppDataBase
import com.cherry.room.database.DaoManager
import com.cherry.room.entity.User
import java.lang.StringBuilder

class MainViewModel : ViewModel() {

    val userString = ObservableField<String>()

    val handler = Handler(Looper.getMainLooper()) {
        when (it.what) {
            1 -> userString.set(it.obj as String)
        }
        true
    }

    fun addData(view: View) {
        Thread(Runnable {
            val size = AppDataBase.getInstance(appContext).userDao().getAll().size
            val user = User(size + 1, "yin${size}", "peng${size}")
            AppDataBase.getInstance(appContext).userDao().insertAll(user)
            val lists = DaoManager.db.userDao().getAll()
            val userInfos = StringBuilder()
            lists.forEach {
                userInfos.append(it.toString())
            }
            Message.obtain().apply {
                what = 1
                obj = userInfos.toString()
                handler.sendMessage(this)
            }
        }).start()


    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.newInstance()
        }
    }

}