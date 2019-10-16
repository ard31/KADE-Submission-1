package com.app.ardifc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(), AnkoLogger {

    var fcList: ArrayList<FCitems> = arrayListOf()


    private val rvFootball by lazy {
        find<RecyclerView>(R.id.rv_football)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

        initializeData()
        initComponent()
    }

    fun initComponent(){
        rvFootball.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, 0)
        rvFootball.addItemDecoration(dividerItemDecoration)
        val adapter = FCadapter(fcList)
        rvFootball.adapter = adapter
    }

    fun initializeData() {
        val name = resources.getStringArray(R.array.club_name)
        val description = resources.getStringArray(R.array.club_description)
        val image = resources.obtainTypedArray(R.array.club_image)

        for (i in name.indices) {
            fcList.add(FCitems(name[i], image.getResourceId(i, 0), description[i]))
        }
        image.recycle()
    }


    class MainActivityUI : AnkoComponent<MainActivity>{
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            relativeLayout {
                recyclerView{
                    id = R.id.rv_football
                }.lparams(width = matchParent, height = wrapContent)
            }
        }
    }
}
