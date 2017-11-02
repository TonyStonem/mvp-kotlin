package cn.xjw.mvp_kotlin.module.model

import android.os.Handler
import android.os.Looper
import android.os.Message
import cn.xjw.mvp_kotlin.module.OnNetLoadListener
import cn.xjw.mvp_kotlin.module.contract.LoginContract

/**
 * Created by xjw on 2017/11/1 14:29
 * Email : 1521975316@qq.com
 */
class LoginModel : LoginContract.Model {

    private var handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            if (msg!!.what == 0) {

            }
        }
    }

    override fun login(name: String, pswd: String, listener: OnNetLoadListener) {
        listener.start()
        handler.postDelayed(Runnable {
            listener.end()
            if (name.equals("admin") && pswd.equals("admin")) {
                listener.success("{'msg':'登录成功'}")
            } else {
                listener.error("账号或密码不正确,登录失败")
            }
        }, 2000)
    }


}