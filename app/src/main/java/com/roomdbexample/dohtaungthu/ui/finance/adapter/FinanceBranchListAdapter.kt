package com.roomdbexample.dohtaungthu.ui.finance.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roomdbexample.dohtaungthu.R
import com.roomdbexample.dohtaungthu.model.FinanceBranch
import kotlinx.android.synthetic.main.image_item_view.view.*
import kotlinx.android.synthetic.main.row_finance_branch_item_view.view.*

internal class FinanceBranchListAdapter(val branchList : List<FinanceBranch>) : RecyclerView.Adapter<FinanceBranchListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.row_finance_branch_item_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return branchList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val branch = branchList[position]
       holder.bind(branch)
    }

    internal class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        fun bind(b : FinanceBranch){
            itemView.tvRowNumber.text = (adapterPosition+1).toString()
            itemView.tvRowBranchName.text = b.branchName
        }
    }
}