package cn.xjw.mvp_kotlin.module.contract

import cn.xjw.mvp_kotlin.base.BaseContract
import cn.xjw.mvp_kotlin.module.OnNetLoadListener

/**
 * Created by xjw on 2017/11/1 14:16
 * Email : 1521975316@qq.com
 */
interface LoginContract {

    interface View : BaseContract.View {

        fun getLoginName(): String

        fun getLoginPswd(): String

        fun toMain()

    }

    interface Presenter {

        fun login()

    }

    interface Model {
        fun login(name: String, pswd: String, listener: OnNetLoadListener)
    }

}