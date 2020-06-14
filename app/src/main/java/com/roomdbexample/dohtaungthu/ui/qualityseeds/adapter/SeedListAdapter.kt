package com.roomdbexample.dohtaungthu.ui.qualityseeds.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.roomdbexample.dohtaungthu.R
import com.roomdbexample.dohtaungthu.model.SeedInfo
import com.roomdbexample.dohtaungthu.model.Seeds
import kotlinx.android.synthetic.main.row_seed_itemview.view.*


internal class SeedListAdapter(val seedInfo : SeedInfo) : RecyclerView.Adapter<SeedListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.row_seed_itemview,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return seedInfo.seedList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val seed = seedInfo.seedList[position]
       holder.bind(seed)
    }

    internal class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val context = itemView.context

        @SuppressLint("MissingPermission")
        fun bind(seeds: Seeds){
            itemView.tvCompanyNameSeed.text = seeds.companyName
            itemView.tvPersonNameSeed.text  = seeds.personName
            itemView.tvSeedName.text = "မျိုးအမည်  - ${seeds.seedName}"
            itemView.tvProductionRegion.text = "မျိုးစေ့ထုတ်လုပ်မည့်ဒေသ - ${seeds.productionRegion}"
            itemView.tvContactToBuy.text = "ဆက်သွယ်ရန် : ${seeds.phoneNumber}"

            itemView.btnOrder.setOnClickListener {
                val callIntent = Intent(Intent.ACTION_DIAL)
                callIntent.data = Uri.parse("tel:" + seeds.phoneNumber) //change the number

                context.startActivity(callIntent)
            }
        }
    }
}