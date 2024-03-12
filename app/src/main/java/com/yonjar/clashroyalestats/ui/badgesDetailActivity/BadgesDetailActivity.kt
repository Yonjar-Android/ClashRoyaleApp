package com.yonjar.clashroyalestats.ui.badgesDetailActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yonjar.clashroyalestats.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BadgesDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_badges_detail)
    }
}