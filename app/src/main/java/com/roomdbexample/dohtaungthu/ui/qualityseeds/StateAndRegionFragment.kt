package com.roomdbexample.dohtaungthu.ui.qualityseeds

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.roomdbexample.dohtaungthu.R
import kotlinx.android.synthetic.main.fragment_state_and_region.*

class StateAndRegionFragment : Fragment() {

    companion object{
        fun newInstance() = StateAndRegionFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_state_and_region, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = Intent(context,SeedListDetailActivity::class.java)

        tvKaChin.setOnClickListener {
            intent.putExtra("region","kachin")
            startActivity(intent)
        }

        tvYangon.setOnClickListener {
            intent.putExtra("region","ygn")
            startActivity(intent)
        }

        tvShan.setOnClickListener {
            intent.putExtra("region","shan")
            startActivity(intent)
        }

        tvSagaing.setOnClickListener {
            intent.putExtra("region","sagaing")
            startActivity(intent)
        }

        tvNPT.setOnClickListener {
            intent.putExtra("region","npt")
            startActivity(intent)
        }

        tvAyaWaddy.setOnClickListener {
            intent.putExtra("region","ayawaddy")
            startActivity(intent)
        }

        tvMagway.setOnClickListener {
            intent.putExtra("region","magway")
            startActivity(intent)
        }

        tvMdy.setOnClickListener {
            intent.putExtra("region","mdy")
            startActivity(intent)
        }

    }
}
