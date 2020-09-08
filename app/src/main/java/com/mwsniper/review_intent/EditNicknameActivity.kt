package com.mwsniper.review_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)

        // 닉네임 수정 후 완료버튼을 눌렀을 때
        okBtn.setOnClickListener {

            // 돌아갈 때 첨부할 데이터를 들고 있어주는 Intent와는 별개로 생성
            val resultsIntent = Intent()

            // 입력한 닉네임을 resultsIntent에 첨부 = putExtra
            val input = nickNameEdt.text.toString()
            resultsIntent.putExtra("newNickname", input)

            // OK 버튼을 눌렀을 때 데이터 담고있는 resultsIntent를 갖고 복귀처리
            // 기존에는 그냥 finish()처리만 해줬지만 이번에는
            // 결과값을 들고 가야하기에 꼭 필요
            // public static final int RESULT_OK = -1;
            setResult(Activity.RESULT_OK, resultsIntent)

            // 복귀한다는 의미
            finish()
        }
    }
}