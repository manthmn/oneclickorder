package com.food.ordering.oneclickorder.ui.contactus

import android.animation.LayoutTransition
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.food.ordering.oneclickorder.R
import com.food.ordering.oneclickorder.data.local.PreferencesHelper
import com.food.ordering.oneclickorder.databinding.ActivityContactUsBinding
import com.food.ordering.oneclickorder.databinding.ActivityPaymentBinding
import com.food.ordering.oneclickorder.ui.placeorder.PlaceOrderActivity
import com.food.ordering.oneclickorder.utils.AppConstants
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ContactUsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactUsBinding
    private val preferencesHelper: PreferencesHelper by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setListener()
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact_us)
        binding.layoutContent.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
    }

    private fun setListener(){
        binding.imageClose.setOnClickListener {
            onBackPressed()
        }
    }

}
