package com.example.my_movie_app.entrance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.my_movie_app.MainActivityForAdmin
import com.example.my_movie_app.R

class EntryForAdmin: AppCompatActivity() {
    private var entry: Button? = null
    private var back: TextView? = null
    private var fio: TextView? = null
    private var email: TextView? = null
    private var pass: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entry_for_admin)


    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        entry?.setOnClickListener {
            //нужно проверить данные на правильность
            val i = Intent(this, MainActivityForAdmin::class.java)
            startActivity(i)
        }
        back?.setOnClickListener{
            finish()
        }

    }

    private fun initFields() {
        entry = findViewById(R.id.entry_admin)
        back = findViewById(R.id.back)
        fio = findViewById(R.id.enter_fio)
        email = findViewById(R.id.enter_email)
        pass = findViewById(R.id.enter_pass)
    }

}