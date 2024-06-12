package com.example.blutspendekompabilitaetsapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.blutspendekompabilitaetsapp.R


class MainActivity : AppCompatActivity() {

    private lateinit var spinnerBloodType: Spinner
    private lateinit var buttonCheck: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerBloodType = findViewById(R.id.spinner_blood_type)
        buttonCheck = findViewById(R.id.btn_check)
        textViewResult = findViewById(R.id.tv_result)

        buttonCheck.setOnClickListener {
            val selectedBloodType = spinnerBloodType.selectedItem.toString()
            val compatibleBloodTypes = getCompatibleBloodTypes(selectedBloodType)
            textViewResult.text = "Kompatible Blutgruppen: $compatibleBloodTypes"
        }
    }

    fun getCompatibleBloodTypes(bloodType: String): String {
        return when (bloodType) {
            "A+" -> "A+, A-, O+, O-"
            "A-" -> "A-, O-"
            "B+" -> "B+, B-, O+, O-"
            "B-" -> "B-, O-"
            "AB+" -> "Alle Blutgruppen"
            "AB-" -> "AB-, A-, B-, O-"
            "O+" -> "O+, O-"
            "O-" -> "O-"
            else -> "Unbekannt"
        }
    }
}