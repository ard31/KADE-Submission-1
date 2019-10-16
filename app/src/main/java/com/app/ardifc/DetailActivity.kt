package com.app.ardifc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    lateinit var fc: FCitems

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DetailActivityUI().setContentView(this)
        initComponent()
    }

    fun initComponent(){
        val imageFC = findViewById<ImageView>(R.id.imgDetail)
        val nameFC = findViewById<TextView>(R.id.txtNameDetail)
        val detailFC = findViewById<TextView>(R.id.txtNameDetail)
        fc = intent.getParcelableExtra("fc")

        nameFC.text = fc.name
        detailFC.text = fc.detail
        fc.image?.let {
            Picasso.get()
                .load(it)
                .into(imageFC)
        }
    }

    class DetailActivityUI : AnkoComponent<DetailActivity> {

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout {
                imageView {
                    id = R.id.imgDetail
                }.lparams(410, 410) {
                    bottomMargin = dip(25)
                    padding = dip(10)
                    gravity = Gravity.CENTER
                }
                textView {
                    id = R.id.txtNameDetail
                    textSize = 18f
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(width = wrapContent, height = wrapContent) {
                    bottomMargin = dip(20)
                    rightMargin = dip(10)
                    leftMargin = dip(10)
                    gravity = Gravity.CENTER
                }
                textView {
                    id = R.id.txtDescDetail
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(width = wrapContent, height = wrapContent) {
                    rightMargin = dip(10)
                    leftMargin = dip(10)
                    gravity = Gravity.CENTER
                }.lparams(width = wrapContent, height = wrapContent) {
                    gravity = Gravity.CENTER
                }
            }
        }

    }
}