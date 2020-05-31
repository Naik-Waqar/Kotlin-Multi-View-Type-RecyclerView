package com.softwindevs.kotlinrv2

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val News = ArrayList<MyModel>()
        News.add(MyModel("Coronavirus research: India identifies 6 local vaccine","",""))
        News.add(MyModel("","#Suleman","2.2k Tweets"))
        News.add(MyModel("Covid-19: With record 116 deaths in 24 hours, Maharashtra's","",""))
        News.add(MyModel("", "#Waqar","1k Tweets"))
        News.add(MyModel("", "#SpaceX","5M Tweets"))
        News.add(MyModel("Covid-19: will disappeared soon","",""))

        //creating our adapter
        val adapter = MyAdapter(News)
        //now adding the adapter to recyclerview
        Main_RV.adapter = adapter

    }

}