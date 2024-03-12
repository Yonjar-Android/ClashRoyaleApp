package com.yonjar.clashroyalestats.ui.userActitivy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    lateinit var binding:ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}