package com.notes.com.mainActivity

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.notes.com.R
import com.notes.com.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityFactory : MainActivityFactory
    private lateinit var mainActivityVM : MainActivityVM
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainActivityFactory = MainActivityFactory(this)
        mainActivityVM = ViewModelProvider(this, mainActivityFactory).get(MainActivityVM::class.java)
        binding.mainActivityVM = mainActivityVM
    }
}