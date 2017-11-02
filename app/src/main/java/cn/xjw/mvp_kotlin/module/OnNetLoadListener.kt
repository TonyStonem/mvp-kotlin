package cn.xjw.mvp_kotlin.module

/**
 * Created by xjw on 2017/11/1 14:17
 * Email : 1521975316@qq.com
 */
interface OnNetLoadListener {

    fun start()

    fun success(json: String)

    fun error(msg: String)

    fun end()

}