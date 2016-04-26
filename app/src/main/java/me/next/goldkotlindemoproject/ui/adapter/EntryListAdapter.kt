package me.next.goldkotlindemoproject.ui.adapter

import android.graphics.Bitmap
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avos.avoscloud.AVUser
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import kotlinx.android.synthetic.main.card_entry.view.*
import me.next.goldkotlindemoproject.R
import me.next.goldkotlindemoproject.model.Entry

/**
 * Created by NeXT on 16/4/26.
 * GoldKotlinDemoProject
 */
//https://kotlinlang.org/docs/reference/classes.html
class EntryListAdapter(val entryList: List<Entry>, val itemClick: OnItemClickListener) : RecyclerView.Adapter<EntryListAdapter.MyViewHolder>() {

    override fun getItemCount() = entryList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder? {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_entry, parent, false)
        return MyViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindViewHolder(entryList[position])
    }

    class MyViewHolder(itemView: View, val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        fun bindViewHolder(entry: Entry) {
            with(entry) {
                itemView.tvTitle.text = getString("title")
                itemView.tvContent.text = getString("content")
                Glide.with(itemView.context).load(getString("screenshot")).into(itemView.ivScreenShot)
                val user = getAVUser<AVUser>("user")
                if (user != null) {
                    Glide.with(itemView.context).load(user.getString("avatar_large")).asBitmap().error(R.mipmap.ic_launcher)
                            .into(object : BitmapImageViewTarget(itemView.ivAvatar) {
                                override fun setResource(resource: Bitmap) {
                                    super.setResource(resource)
                                    val circularBitmapDrawable = RoundedBitmapDrawableFactory.create(itemView.context.resources, resource)
                                    if (circularBitmapDrawable != null) {
                                        circularBitmapDrawable.cornerRadius = 100f
                                        itemView.ivAvatar.setImageDrawable(circularBitmapDrawable)
                                    }
                                }
                            })
                }
                itemView.setOnClickListener { itemClick(entry) }
            }
        }
    }

    interface OnItemClickListener {
        operator fun invoke(entry: Entry)
    }

}