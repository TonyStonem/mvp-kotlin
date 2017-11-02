package cn.xjw.mvp_kotlin.module.presenter

import android.text.TextUtils
import cn.xjw.mvp_kotlin.module.OnNetLoadListener
import cn.xjw.mvp_kotlin.module.contract.LoginContract
import cn.xjw.mvp_kotlin.module.model.LoginModel
import cn.xjw.mvp_kotlin.utils.UIUtils

/**
 * Created by xjw on 2017/11/1 14:16
 * Email : 1521975316@qq.com
 */
class LoginPresenter : LoginContract.Presenter {

    private val model: LoginModel by lazy { LoginModel() }
    private lateinit var view: LoginContract.View

    constructor(view: LoginContract.View) {
        this.view = view
    }

    override fun login() {
        val name = view.getLoginName()
        val pswd = view.getLoginPswd()
        if (TextUtils.isEmpty(name)) {
            UIUtils.showToast("账号不能为空")
            return
        }
        if (TextUtils.isEmpty(pswd)) {
            UIUtils.showToast("密码不能为空")
            return
        }
        model.login(name, pswd, object : OnNetLoadListener {
            override fun start() {
                view.showLoadingDialog()
            }

            override fun success(json: String) {
                UIUtils.showToast(json)
                view.toMain()
            }

            override fun error(msg: String) {
                UIUtils.showToast(msg)
            }

            override fun end() {
                view.cancelLoadingDialog()
            }

        })
    }


}