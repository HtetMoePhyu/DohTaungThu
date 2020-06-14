package com.roomdbexample.dohtaungthu.ui.qualityseeds

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.roomdbexample.dohtaungthu.R
import kotlinx.android.synthetic.main.fragment_quality_seeds.*

class QualitySeedFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_quality_seeds, container, false)

        return root
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        doFragmentTransition(StateAndRegionFragment.newInstance())
        btnRegions.isSelected = true
        btnRegions.setTextColor(context!!.resources.getColor(R.color.colorWhite))

        btnRegions.setOnClickListener {
            btnRegions.isSelected = true
            btnAgent.isSelected = false
            btnMerchants.isSelected = false
            btnRegions.setTextColor(context!!.resources.getColor(R.color.colorWhite))
            btnAgent.setTextColor(context!!.resources.getColor(android.R.color.black))
            btnMerchants.setTextColor(context!!.resources.getColor(android.R.color.black))

            doFragmentTransition(StateAndRegionFragment.newInstance())
        }
        btnAgent.setOnClickListener {
            btnAgent.isSelected = true
            btnRegions.isSelected = false
            btnMerchants.isSelected = false
            btnAgent.setTextColor(context!!.resources.getColor(R.color.colorWhite))
            btnRegions.setTextColor(context!!.resources.getColor(android.R.color.black))
            btnMerchants.setTextColor(context!!.resources.getColor(android.R.color.black))

        }
        btnMerchants.setOnClickListener {
            btnMerchants.isSelected = true
            btnRegions.isSelected = false
            btnAgent.isSelected = false
            btnMerchants.setTextColor(context!!.resources.getColor(R.color.colorWhite))
            btnRegions.setTextColor(context!!.resources.getColor(android.R.color.black))
            btnAgent.setTextColor(context!!.resources.getColor(android.R.color.black))
        }
    }

    private fun doFragmentTransition(fragment: Fragment) {
        childFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayoutQS, fragment, tag)
            .commit()
    }
}
