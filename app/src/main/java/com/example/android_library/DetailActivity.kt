package com.example.android_library

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.android_library.databinding.ActivityDetailBinding

class DetailActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if(result.resultCode == Activity.RESULT_OK)
        {
            result.data?.extras?.let {bundle ->
                binding.tvNameBook.text = bundle.getString("key_SachMoi")
                binding.tvTienCoc.text = bundle.getDouble("key_TienMoi",0.0).toString()
                binding.tvNguoiMuon.text = bundle.getString("key_SachMoi")
            }
        }
    }
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
        binding.btnEdit.setOnClickListener {
            with(binding){
                val intent = Intent(this@DetailActivity, ChinhSuaSachActivity::class.java).apply{
                    putExtra("key_TenSach", tvNameBook.text.toString())
                    putExtra("key_TienCoc", tvTienCoc.text.toString())
                    putExtra("key_nguoimuon", tvNguoiMuon.text.toString())
                }
                editLauncher.launch(intent)
            }
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}