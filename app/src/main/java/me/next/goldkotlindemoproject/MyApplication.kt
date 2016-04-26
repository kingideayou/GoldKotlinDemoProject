package me.next.goldkotlindemoproject

import android.app.Application
import com.avos.avoscloud.AVOSCloud
import com.avos.avoscloud.AVObject
import me.next.goldkotlindemoproject.constants.ConstantKey
import me.next.goldkotlindemoproject.model.Entry

/**
 * Created by NeXT on 16/4/26.
 * GoldKotlinDemoProject
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //https://kotlinlang.org/docs/reference/reflection.html
        AVObject.registerSubclass(Entry :: class.java)
        AVOSCloud.initialize(
                this,
                ConstantKey.APP_ID,
                ConstantKey.APP_KEY)
    }

}

