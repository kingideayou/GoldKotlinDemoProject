package me.next.goldkotlindemoproject

import android.app.Application
import com.avos.avoscloud.AVOSCloud
import me.next.goldkotlindemoproject.constants.ConstantKey

/**
 * Created by NeXT on 16/4/26.
 * GoldKotlinDemoProject
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AVOSCloud.initialize(
                this,
                ConstantKey.APP_ID,
                ConstantKey.APP_KEY)
    }

}

