package com.ppb.aditya_prasetyo18102075.praktikum8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_sms_receiver.*

class SmsReceiverActivity : AppCompatActivity() {

    val keywords_dont = arrayOf("hadiah", "blogspot", "wordpress", "pulsa", "selamat", "transfer", "mobil", "polisi", "rumah")

    companion object {
        const val EXTRA_SMS_NO = "extra_sms_no"
        const val EXTRA_SMS_MESSAGE = "extra_sms_message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_receiver)

        title = getString(R.string.coming_from)
        val senderNo = intent.getStringExtra(EXTRA_SMS_NO)
        val senderMessage = intent.getStringExtra(EXTRA_SMS_MESSAGE)

        val match = keywords_dont.filter { it in senderMessage!!.split(" ") }
        if(match.isNotEmpty()){
            activity_sms_receiver.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
            Toast.makeText(this, "SMS ini HOAXXXX!!", Toast.LENGTH_SHORT).show()
        }

        tv_from.text = getString(R.string.coming_from)+": "+senderNo
        tv_message.text = senderMessage
        btn_close.setOnClickListener { finish() }
    }

}