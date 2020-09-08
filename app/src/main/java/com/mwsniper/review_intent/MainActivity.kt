package com.mwsniper.review_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. 액티비티로 그냥 이동 버튼
        // moveToBtn 클릭이벤트
        moveToBtn.setOnClickListener {

            // 이동할 액티비티 경로 잡기
            val myIntent = Intent(this, DataActivity::class.java)

            // 이동하기
            startActivity(myIntent)

        }

        //2. 이동할 화면에 전달할 메시지 들고가는 버튼
        // bringToBtn
        bringToBtn.setOnClickListener {

            // 우선 들고갈 메시지 변수에 담기
            val inputMsg = messageEdt.text.toString()

            // 이동할 액티비티 경로 잡기
            val myIntent = Intent(this, DataActivity::class.java)

            // 가지고 갈 메시지를 putExtra에 담기
            myIntent.putExtra("message", inputMsg)

            // 이동하기
            startActivity(myIntent)
        }


        //3. 닉네임 변경 버튼 클릭
        //changeNickNameBtn
        changeNickNameBtn.setOnClickListener {

            // 닉네임 변경 액티비티로 이동한다고 명시
            val myIntent = Intent(this, EditNicknameActivity::class.java)

            // 지금까지한 내용과 다르게 여기서는 결과값을 받고 다시 돌아와야함
            // 그래서 기존에는 startActivity를 사용했지만 여기서는 startActivityForResult를 사용함
            // requestCode는 저와 같이 직접 입력하지 않고 멤버변수로 담아서 가독성을 높여주는걸 추천
            startActivityForResult(myIntent, 200)

        }
    }

    // 결과를 받아올 때 실행되는 함수 오버라이딩
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // resultCode를 우선 검사해야합니다.
        // 화면에 들어가기 전 200이라는 resultCode를 주어줬는데 해당 값이 맞는지 체크
        if(requestCode == 200)
        {
            //setResult(Activity.RESULT_OK, resultsIntent) 에서 부여했던 result_OK 값이 맞는지
            if(resultCode == Activity.RESULT_OK)
            {
                // 모든 것이 맞으면 새로 변경한 닉네임으로 text반영
                val newNickName = data?.getStringExtra("newNickname")

                // 메인화면에 있는 닉네임 TextView 변경
                nickNameTxt.text = newNickName
            }
        }
    }
}