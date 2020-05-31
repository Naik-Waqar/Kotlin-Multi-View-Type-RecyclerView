package com.softwindevs.kotlinrv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.covid19_live_item_layout.view.*
import kotlinx.android.synthetic.main.trendingin_india_item_layout.view.*

class MyAdapter(val News: ArrayList<MyModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_COVID_19: Int = 1
    private val TYPE_TRENDING_INDIA: Int = 2

    //the class is hodling the list view
    class CovidViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvHeading = itemView.Covid_heading_TV
    }

    class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTag = itemView.Tag_TV
        val tvTweets = itemView.Tweet_TV
    }

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        //inflating layout
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_COVID_19) {
            val v = inflater.inflate(R.layout.covid19_live_item_layout, parent, false)
            CovidViewHolder(v)
        } else {
            val v = inflater.inflate(R.layout.trendingin_india_item_layout, parent, false)
            TrendingViewHolder(v)
        }

    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val NewsdData = News[position]
      //  val context = holder.itemView.context

        //check and set the view item
        if (holder.itemViewType == TYPE_COVID_19) {
            val vh = holder as CovidViewHolder

            vh.tvHeading.text = NewsdData.CovidHeading

        } else{
            val vh = holder as TrendingViewHolder

            vh.tvTag.text = NewsdData.TagTv
            vh.tvTweets.text = NewsdData.TweetTv
        }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return News.size
    }


    //set item view type
    override fun getItemViewType(position: Int): Int {

        return if (News[position].CovidHeading.isEmpty())
            TYPE_TRENDING_INDIA
        else
            TYPE_COVID_19

    }
}