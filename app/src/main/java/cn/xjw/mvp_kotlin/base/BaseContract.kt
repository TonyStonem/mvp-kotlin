package cn.xjw.mvp_kotlin.base

/**
 * Created by xjw on 2017/11/1 15:21
 * Email : 1521975316@qq.com
 */
interface BaseContract {

    interface View {

        fun showLoadingDialog()

        fun cancelLoadingDialog()

        fun close()

    }

}