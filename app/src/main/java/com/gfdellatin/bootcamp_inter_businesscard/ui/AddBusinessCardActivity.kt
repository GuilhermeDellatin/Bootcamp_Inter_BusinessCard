package com.gfdellatin.bootcamp_inter_businesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gfdellatin.bootcamp_inter_businesscard.App
import com.gfdellatin.bootcamp_inter_businesscard.R
import com.gfdellatin.bootcamp_inter_businesscard.data.BusinessCard
import com.gfdellatin.bootcamp_inter_businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.tilName.editText?.text.toString(),
                phone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilMail.editText?.text.toString(),
                enterprise = binding.tilEnterprise.editText?.text.toString(),
                colorPersonalization = binding.tilColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}