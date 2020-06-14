package com.roomdbexample.dohtaungthu.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roomdbexample.dohtaungthu.R
import kotlinx.android.synthetic.main.image_item_view.view.*

internal class RVImageListAdapter(val imgList : MutableList<Int>) : RecyclerView.Adapter<RVImageListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.image_item_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val img = imgList[position]
       holder.bind(img)
    }

    internal class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        fun bind(img : Int){
            itemView.imgMenu.setImageResource(img)
        }
    }
}