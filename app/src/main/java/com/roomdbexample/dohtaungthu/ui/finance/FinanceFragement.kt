package com.roomdbexample.dohtaungthu.ui.finance

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.roomdbexample.dohtaungthu.R
import kotlinx.android.synthetic.main.fragment_finance.*

class FinanceFragement : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = Intent(context,FinanceDetailActivity::class.java)
        layoutMaha.setOnClickListener {
            intent.putExtra("finance","maha")
            startActivity(intent)
        }

        layoutProxinity.setOnClickListener {
            intent.putExtra("finance","proximity")
            startActivity(intent)
        }

        layoutLOCL.setOnClickListener {
            intent.putExtra("finance","lolc")
            startActivity(intent)

        }

        layoutGBS.setOnClickListener {
            startActivity(intent)

        }

        layoutFulleton.setOnClickListener {
            startActivity(intent)

        }

        layoutAlliance.setOnClickListener {
            startActivity(intent)

        }
        layoutYTK.setOnClickListener {
            startActivity(intent)

        }

    }
}
