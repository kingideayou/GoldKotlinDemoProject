package me.next.goldkotlindemoproject.ui.adapter

import android.graphics.Bitmap
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.avos.avoscloud.AVUser
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import me.next.goldkotlindemoproject.R
import me.next.goldkotlindemoproject.model.Entry
import org.jetbrains.anko.find

/**
 * Created by NeXT on 16/4/26.
 * GoldKotlinDemoProject
 */
//https://kotlinlang.org/docs/reference/classes.html
class EntryListAdapter(val entryList: List<Entry>) : RecyclerView.Adapter<EntryListAdapter.MyViewHolder>() {

    override fun getItemCount() = entryList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder? {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_entry, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindViewHolder(entryList[position])
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivScreenshot : ImageView
        val ivAvatar : ImageView
        val tvTitle : TextView
        val tvContent : TextView

        init {
            ivAvatar = itemView.find(R.id.ivAvatar)
            ivScreenshot = itemView.find(R.id.ivScreenShot)
            tvTitle = itemView.find(R.id.tvTitle)
            tvContent = itemView.find(R.id.tvContent)
        }

        fun bindViewHolder(entry: Entry) {
            //TODO with
            tvTitle.text = entry.getString("title")
            tvContent.text = entry.getString("content")
            Glide.with(itemView.context).load(entry.getString("screenshot")).into(ivScreenshot)
            val user = entry.getAVUser<AVUser>("user")
            if (user != null) {
                Glide.with(itemView.context).load(user.getString("avatar_large")).asBitmap().error(R.mipmap.ic_launcher)
                        .into(object : BitmapImageViewTarget(ivAvatar) {
                            override fun setResource(resource: Bitmap) {
                                super.setResource(resource)
                                val circularBitmapDrawable = RoundedBitmapDrawableFactory.create(itemView.context.resources, resource)
                                if (circularBitmapDrawable != null) {
                                    circularBitmapDrawable.cornerRadius = 100f
                                    ivAvatar.setImageDrawable(circularBitmapDrawable)
                                }
                            }
                        })
            }
        }
    }

}