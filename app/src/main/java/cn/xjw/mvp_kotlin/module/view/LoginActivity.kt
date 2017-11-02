package cn.xjw.mvp_kotlin.module.view

import android.content.Intent
import cn.xjw.mvp_kotlin.R
import cn.xjw.mvp_kotlin.base.BaseActivity
import cn.xjw.mvp_kotlin.module.contract.LoginContract
import cn.xjw.mvp_kotlin.module.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginContract.View {

    override fun toMain() {
        startActivity(Intent(this, MainActivity::class.java))
        close()
    }

    override fun getLoginName(): String = et_name.text!!.toString()

    override fun getLoginPswd(): String = et_pswd.text!!.toString()

    private val presenter: LoginPresenter by lazy { LoginPresenter(this) }

    override fun getResID(): Int = R.layout.activity_login

    override fun start() {
        btn_login.setOnClickListener { presenter.login() }
    }

}
