package com.example.midasandroid2.sign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.domain.entity.SignInEntity
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseActivity
import com.example.midasandroid2.databinding.ActivitySignInBinding
import com.example.midasandroid2.main.MainActivity
import com.example.midasandroid2.util.ACCESS_TOKEN
import com.example.midasandroid2.util.repeatOnStarted
import com.example.midasandroid2.util.ts
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in){

    private val signInViewModel: SignInViewModel by viewModels()

    override fun initView() {
        binding.run {
            btnLogin.setOnClickListener {
                //signInViewModel.signIn(SignInEntity(ts(etEmployeeNum), ts(etPassword)))
                startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                finish()
            }
            btnSignUp.setOnClickListener {
                startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
                finish()
            }
        }

    }

    override fun observeEvent() {
        repeatOnStarted {
            signInViewModel.eventFlow.collect {
                when(it) {
                    is SignInViewModel.Event.Success -> {
                        startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                        finish()
                    }
                    is SignInViewModel.Event.Server -> showToastShort("서버가 닫혀있습니다")
                    else -> showToastShort("알 수 없는 오류입니다")
                }
            }
        }
    }

}