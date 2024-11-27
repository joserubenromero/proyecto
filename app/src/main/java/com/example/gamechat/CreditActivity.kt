package com.example.gamechat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val name = intent.getStringExtra("Extra_texto") ?: "Rah"
        val textview2 = findViewById<TextView>(R.id.textView2)


        textview2.text = "$name estás usando la versión 1.0 de Game Chat"


        val buttonContactar = findViewById<Button>(R.id.button)
        buttonContactar.setOnClickListener {
            sendEmail()
        }
    }


    private fun sendEmail() {

        val email = "jromgon290@gmail.coom"
        val subject = "Consulta de la app Game Chat"
        val body = "Hola, tengo una consulta sobre la app Game Chat."


        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822"
            putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar correo"))
        } catch (ex: android.content.ActivityNotFoundException) {
            ex.printStackTrace()
        }
    }
}
