package com.example.listadapterdiffutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadapterdiffutils.adapter.DataAdapter
import com.example.listadapterdiffutils.databinding.ActivityMainBinding
import com.example.listadapterdiffutils.model.DataItems

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val recyclerview =mBinding.rvList
        val adapter=DataAdapter()
        val list1 =DataItems(1,"Henry","101")
        val list2 =DataItems(2,"Yatin","102")
        val list3 =DataItems(3,"Mohit","103")
        val list4 =DataItems(4,"Rashik","104")

        adapter.submitList(listOf(list1,list2,list3,list4))
        recyclerview.layoutManager=LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        recyclerview.adapter=adapter

        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            val list5 =DataItems(1,"Henry","101")
            val list6 =DataItems(2,"Yatin","102")
            val list7 =DataItems(5,"Mohit","103")
            val list8 =DataItems(6,"Rashik","104")

            adapter.submitList(listOf(list5,list6,list7,list8))


        },4000)

    }
}