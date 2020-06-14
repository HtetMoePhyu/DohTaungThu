package com.roomdbexample.dohtaungthu.ui.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.roomdbexample.dohtaungthu.R
import com.roomdbexample.dohtaungthu.ui.home.adapter.RVImageListAdapter
import com.roomdbexample.dohtaungthu.ui.qualityseeds.StateAndRegionFragment
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    lateinit var imageList : MutableList<Int>
    private lateinit var imgListAdapter : RVImageListAdapter

    private var dotscount: Int = 0
    private var dots     : Array<ImageView?>? = null
    private val snapHelper: SnapHelper = PagerSnapHelper()
    private lateinit var layoutManager : LinearLayoutManager
    private var currentPosition = 0
    private lateinit var timer : Timer

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        doFragmentTransition(StateAndRegionFragment.newInstance())
        tabSeeds.isSelected = true

        tabSeeds.setOnClickListener {
            tabSelectedSeed.isVisible = true
            tabSelectedMap.isVisible  = false
            doFragmentTransition(StateAndRegionFragment.newInstance())
        }
        tabMap.setOnClickListener {
            tabSelectedSeed.isVisible = false
            tabSelectedMap.isVisible  = true

            doFragmentTransition(MapFragment.newInstance())
        }

        buildDataList()
        imgListAdapter = RVImageListAdapter(imageList)
        layoutManager =  LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL,false)
        rvImgList.layoutManager = layoutManager
        rvImgList.adapter = imgListAdapter

        dotscount = imgListAdapter.itemCount
        dots = arrayOfNulls<ImageView>(dotscount)

        for (i in 0 until dotscount) {
            dots?.set(i, ImageView(context))
            dots?.get(i)?.setImageDrawable(this.let { activity?.applicationContext?.let { it1 ->
                ContextCompat.getDrawable(
                    it1, R.drawable.non_active_dot)
            } })
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(8, 0, 8, 0)
            sliderDots.addView(dots?.get(i), params)
        }

        dots!![0]?.setImageDrawable(activity?.applicationContext?.let { ContextCompat.getDrawable(it, R.drawable.active_dot) })

        rvImgList.setOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val index: Int = layoutManager.findFirstVisibleItemPosition()
                for (i in 0 until dotscount) {
                    dots!![i]?.setImageDrawable(
                        ContextCompat.getDrawable(
                            activity!!.applicationContext,
                            R.drawable.non_active_dot
                        )
                    )
                }

                dots!![index]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        activity!!.applicationContext,
                        R.drawable.active_dot
                    ))
            }
        })

        createMenuImageSlideShow()
    }

    private fun createMenuImageSlideShow() {
        val handler = Handler()
        val runnable = object : Runnable{
            override fun run() {
                try {
                    if(currentPosition == imageList.size)
                        currentPosition = 0
                    rvImgList.scrollToPosition(currentPosition++)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        timer = Timer()
        timer.schedule(object : TimerTask(){
            override fun run() {
                handler.post(runnable)
            }

        },250,2000)
    }

    private fun buildDataList() {
        imageList = mutableListOf()
        imageList.add(R.drawable.img1)
        imageList.add(R.drawable.img2)
        imageList.add(R.drawable.img3)
        imageList.add(R.drawable.img4)

    }

    private fun doFragmentTransition(fragment: Fragment) {
        childFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayoutHome, fragment, tag)
            .commit()
    }
}
