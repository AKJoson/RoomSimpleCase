package com.cherry.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.cherry.room.database.DaoManager
import com.cherry.room.databinding.ActivityMainBinding
import com.cherry.room.entity.User
import com.cherry.room.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val viewModel =
            ViewModelProvider(this, MainViewModel.Factory()).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        setContentView(binding.root)
    }
}
