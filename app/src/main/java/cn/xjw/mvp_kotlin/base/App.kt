package cn.xjw.mvp_kotlin.base

import android.app.Application

/**
 * Created by xjw on 2017/11/1 9:48
 * Email : 1521975316@qq.com
 */
class App : Application() {

    companion object {
        private lateinit var instance: App
        fun get(): App = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}