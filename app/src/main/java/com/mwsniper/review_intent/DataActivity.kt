package com.mwsniper.review_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_data.*

class DataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        // 액티비티에 들어오자마자 바로 첨부된 값을 받아서 텍스트뷰에 반영
        val receivedMessage = intent.getStringExtra("message")
        receivedMessageTxt.text = receivedMessage

        goBackToMainBtn.setOnClickListener {
            // 메인으로 돌아기기 버튼을 누른 경우 finish()
            finish()
        }

    }
}