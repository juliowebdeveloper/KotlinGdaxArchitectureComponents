package com.karchitecture.shido.karchitecture

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.completed_trades.view.*
import org.jetbrains.anko.include
import org.jetbrains.anko.textColor

/**
 * Created by Shido on 23/09/2017.
 */

data class Trade(val size: Float, val price: Float, val time: String, val isBuy: Boolean)

class MyAdapter (val context: Context, val db: AppDatabase) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    val trades = mutableListOf<Trade>()

    override fun getItemCount() = trades.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.include<ConstraintLayout>(R.layout.completed_trades)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(trades[position])
    }


   inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(trade: Trade){
            with(trade){
                itemView.sizeTextView.text = trade.size.toString().padEnd(10, '0') //Pads the string to the specified [length] at the end with the specified character or space.
                itemView.priceTextView.text = trade.price.toString()
                itemView.priceTextView.textColor = if(trade.isBuy) ContextCompat.getColor(context, R.color.green)
                else ContextCompat.getColor(context, R.color.red)
                itemView.timeTextView.text = trade.time.substringAfter("T").substringBefore(".")

            }
        }
    }



}