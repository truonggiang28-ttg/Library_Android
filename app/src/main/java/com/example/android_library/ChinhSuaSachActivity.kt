package com.example.android_library

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_library.databinding.ActivityChinhsuasachBinding

class ChinhSuaSachActivity: AppCompatActivity() {
    private lateinit var binding: ActivityChinhsuasachBinding
    private var tensachnow_313 : String? = null
    private var tiencocnow_313 : Double? = null
    private var tennguoimuonow_313 : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChinhsuasachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let{
            bundle ->
            with(binding){
                val tensachnow_313  = bundle.getString("key_TenSach")?:""
                val tiencocnow_313  = bundle.getDouble("key_TienCoc",0.0)
                val tennguoimuonow_313  = bundle.getString("key_nguoimuon")?:""

                edtBookNamesua.setText(tensachnow_313)
                edtTienCocsua.setText(tiencocnow_313.toString())
                edtNguoiMuonsua.setText(tennguoimuonow_313)
            }
        }
        binding.btnLuu.setOnClickListener {
            val tensachmoi_313 = binding.edtBookNamesua.text.toString().trim()
            val tiencocmoi_313 = binding.edtTienCocsua.text.toString().trim()
            val nguoimuonmoi_313 = binding.edtNguoiMuonsua.text.toString().trim()

            val tienmoi_313 = tiencocmoi_313.toDoubleOrNull()

            val resultIntent = Intent().apply{
                putExtra("key_SachMoi", tensachmoi_313)
                putExtra("key_TienMoi", tienmoi_313)
                putExtra("key_NguoiMoi",nguoimuonmoi_313)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
        binding.btnHuy.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}