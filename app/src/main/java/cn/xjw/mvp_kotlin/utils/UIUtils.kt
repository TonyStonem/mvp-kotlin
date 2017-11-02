package cn.xjw.mvp_kotlin.utils

import android.content.Context
import android.widget.Toast
import cn.xjw.mvp_kotlin.base.App

/**
 * Created by xjw on 2017/11/1 15:34
 * Email : 1521975316@qq.com
 */
class UIUtils {

    companion object {

        private var toast: Toast? = null

        fun showToast(context: Context, str: String) {
            if (toast == null) {
                toast = Toast.makeText(context, str, Toast.LENGTH_LONG)
            }
            toast!!.apply {
                setText(str)
                show()
            }
        }

        fun showToast(str: String) {
            showToast(App.get(), str)
        }
    }

}