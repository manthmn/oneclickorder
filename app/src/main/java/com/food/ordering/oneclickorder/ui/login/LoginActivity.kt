package com.food.ordering.oneclickorder.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.food.ordering.oneclickorder.R
import com.food.ordering.oneclickorder.data.local.PreferencesHelper
import com.food.ordering.oneclickorder.databinding.ActivityLoginBinding
import com.food.ordering.oneclickorder.ui.home.HomeActivity
import com.food.ordering.oneclickorder.ui.otp.OtpActivity
import com.food.ordering.oneclickorder.utils.AppConstants
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val preferencesHelper: PreferencesHelper by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setListener()
        if (!preferencesHelper.oauthId.isNullOrEmpty()&&preferencesHelper.userId!=-1) {
            startActivity(Intent(applicationContext, HomeActivity::class.java))
            finish()
        }
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    }

    private fun setListener() {
        binding.buttonLogin.setOnClickListener {
            val phoneNo = binding.editPhone.text.toString()
            if (phoneNo.isNotEmpty( ) && phoneNo.length==10) {
                val intent = Intent(applicationContext, OtpActivity::class.java)
                intent.putExtra(AppConstants.CUSTOMER_MOBILE, "+91$phoneNo")
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Invalid Phone Number!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
