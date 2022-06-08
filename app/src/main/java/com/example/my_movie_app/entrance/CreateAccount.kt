package com.example.my_movie_app.entrance

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.my_movie_app.R

class CreateAccount: AppCompatActivity() {
    private var create: Button? = null
    private var haveAcc: TextView? = null
    private var skip: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account)

        create = findViewById(R.id.create)
        haveAcc = findViewById(R.id.haveAcc)
        skip = findViewById(R.id.skip)


        haveAcc?.setOnClickListener{
            val EntryIntent = Intent(this, Entry::class.java)
            startActivity(EntryIntent)
        }

        create?.setOnClickListener{
            // обработка занесение в БД и проверка
            // После идет переход на вход в систему
            val EntryIntent = Intent(this, Entry::class.java)
            startActivity(EntryIntent)
        }

    }


}