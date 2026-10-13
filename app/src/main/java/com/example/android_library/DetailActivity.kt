package com.example.android_library

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_library.databinding.ActivityDetailBinding

class DetailActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let { bundle->
            with(binding){
                val nameSach_313  = bundle.getString("key_TenSach")
                val moneyCoc_313 = bundle.getDouble("key_TienCoc", 0.0)
                val nameNguoi_313 = bundle.getString("key_nguoimuon")

                tvNameBook.text = "Ten sach la: ${nameSach_313}"
                tvTienCoc.text = "Tien da coc: ${moneyCoc_313}"
                tvNguoiMuon.text = "Nguoi muon la: ${nameNguoi_313}"
            }
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}