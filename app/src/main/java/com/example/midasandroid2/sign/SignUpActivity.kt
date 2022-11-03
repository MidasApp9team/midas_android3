package com.example.midasandroid2.sign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.domain.entity.SignUpEntity
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseActivity
import com.example.midasandroid2.databinding.ActivitySignUpBinding
import com.example.midasandroid2.util.repeatOnStarted
import com.example.midasandroid2.util.ts
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up){

    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun initView() {
        binding.run {
            btnLogin.setOnClickListener {
                startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
            }
            btnSignUp.setOnClickListener {
                signUpViewModel.signUp(
                    SignUpEntity(
                        empnum = ts(etEmployeeNum),
                        email = ts(etEmail),
                        check = ts(etEmailCheck),
                        password = ts(etPassword)
                    )
                )
            }
        }
    }

    override fun observeEvent() {
        repeatOnStarted {
            signUpViewModel.eventFlow.collect {
                when(it){
                    is SignUpViewModel.Event.Success -> {
                        showToastShort("회원가입 성공")
                        startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                    }
                    else -> showToastShort("알 수 없는 오류입니다")
                }
            }
        }
    }

}