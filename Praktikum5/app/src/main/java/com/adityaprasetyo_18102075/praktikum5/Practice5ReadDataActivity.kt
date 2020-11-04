package com.adityaprasetyo_18102075.praktikum5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_practice5_read_data.*
import kotlinx.android.synthetic.main.activity_practice5_read_data.btnKembaliBeranda
import kotlinx.android.synthetic.main.fragment_practice5_read_data.*

class Practice5ReadDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice5_read_data)

        val prodi = intent.getStringExtra(EXTRA_PRODI)
        lblProdiSaya.text = "Prodi Saya Adalah $prodi"

        btnKembaliBeranda.setOnClickListener{
            val mIntent = Intent(this@Practice5ReadDataActivity, Practice5Activity::class.java)
            startActivity(mIntent)
        }

    }

    companion object {
        const val EXTRA_PRODI = "extra_prodi"
    }
}