package com.example.android_library

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_library.databinding.ActivityMainBinding
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var tenSach_313: String? = null
    private var tienCoc_313: Double? = null
    private var tenNguoiMuon_313: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnThem.setOnClickListener {
            val sachmuon_313 = binding.edtBookname.text.toString().trim()
            val coctien_313 = binding.edtBtiencoc.text.toString().trim()
            val nguoimuon_313 = binding.edtNguoimuon.text.toString().trim()

            val sotien = coctien_313.toDoubleOrNull()
            if (sachmuon_313.isEmpty() || nguoimuon_313.isEmpty() ||sotien == null || sotien <= 0) {
                Toast.makeText(
                    this@MainActivity, "tien coc phai la so lon hon khong va khong null",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            tenSach_313 = sachmuon_313
            tienCoc_313 = sotien
            tenNguoiMuon_313 = nguoimuon_313

            Toast.makeText(this@MainActivity, "Da them",Toast.LENGTH_SHORT).show()
        }

        binding.btnDetail.setOnClickListener {
            with(binding){
                if (tenSach_313.isNullOrEmpty() || tienCoc_313 == null) {
                    Toast.makeText(
                        this@MainActivity,
                        "Chưa có thông tin sách! Vui lòng bấm Thêm trước.",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }

                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply{
                        putExtra("key_TenSach", tenSach_313)
                        putExtra("key_TienCoc", tienCoc_313)
                        putExtra("key_nguoimuon", tenNguoiMuon_313)
                }
                startActivity(intent)
            }
        }
    }
}