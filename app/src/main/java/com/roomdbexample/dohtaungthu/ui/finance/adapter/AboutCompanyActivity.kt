package com.roomdbexample.dohtaungthu.ui.finance.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.roomdbexample.dohtaungthu.R
import kotlinx.android.synthetic.main.activity_about_company.*

class AboutCompanyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_company)

        iconBackAboutCompany.setOnClickListener {
            onBackPressed()
        }

        val company = intent.getStringExtra("company")
        val about = intent.getStringExtra("about")
        when(company){

            "MAHA" -> {
                tvFinanceCompanyName.text = "$company"
                imgCompanyLogo.setImageResource(R.drawable.ic_maha)
            }

            "Proximity" -> {
                tvFinanceCompanyName.text = "$company"
                imgCompanyLogo.setImageResource(R.drawable.ic_proximity)
            }
        }
        tvAboutCompany.text = about
    }
}
