package com.app.ardifc

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class FCadapter(var fcList: List<FCitems>) : RecyclerView.Adapter<FCadapter.FCViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FCViewHolder {
        return FCViewHolder(
            ItemFC().createView(
                AnkoContext.create(parent.context, parent)
            )
        )
    }

    override fun getItemCount(): Int {
        return fcList.size
    }

    override fun onBindViewHolder(holder: FCViewHolder, position: Int) {
        holder.bind(fcList[position])
    }

    class FCViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image_FC: ImageView = itemView.find(R.id.img_fc)
        val name_FC: TextView = itemView.find(R.id.txt_fc)

        fun bind(items: FCitems){
            items.image?.let {
                Picasso.get()
                    .load(it)
                    .into(image_FC)
            }
            name_FC.text = items.name
            itemView.setOnClickListener {
                itemView.context.startActivity<DetailActivity>("fc" to items)
            }
        }
    }


    class ItemFC : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
            relativeLayout {

                imageView{
                    id = R.id.img_fc
                }.lparams(width = 150, height = 150) {
                    padding = dip(10)
                }

                textView {
                    id = R.id.txt_fc
                    textSize = 19f
                }.lparams {
                    width = wrapContent
                    height = wrapContent
                    centerVertically()
                    rightOf(R.id.img_fc)
                    leftMargin = dip(10)
                }

                id = R.id.relative_layout
                lparams(width = matchParent, height = wrapContent) {
                    padding = dip(10)
                }
            }
        }
    }
}