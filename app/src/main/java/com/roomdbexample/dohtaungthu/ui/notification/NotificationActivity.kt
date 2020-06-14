package com.roomdbexample.dohtaungthu.ui.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.roomdbexample.dohtaungthu.R
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        iconBackNoti.setOnClickListener {
            onBackPressed()
        }
    }
}
