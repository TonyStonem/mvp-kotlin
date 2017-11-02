package cn.xjw.mvp_kotlin.base

import android.app.Dialog
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import cn.xjw.mvp_kotlin.BuildConfig
import cn.xjw.mvp_kotlin.R

/**
 * Created by xjw on 2017/11/1 9:51
 * Email : 1521975316@qq.com
 */
abstract class BaseActivity : AppCompatActivity(), BaseContract.View {

    private val loadingDialog: Dialog by lazy {
        Dialog(this, R.style.loadingDialog).apply {
            val view = View.inflate(activity, R.layout.dialog_layout_view, null)
            val pb = view.findViewById<View>(R.id.pb_loading) as ProgressBar
            val color = ContextCompat.getColor(activity, R.color.colorAccent)
            pb.indeterminateDrawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
            setCanceledOnTouchOutside(BuildConfig.DEBUG)
            setCancelable(true)
            setContentView(view)
            loadingDialogCount = 0
        }
    }

    @Volatile private var loadingDialogCount = 0 //同步
    protected lateinit var activity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        setContentView(getResID())
        start()
    }

    @LayoutRes
    abstract fun getResID(): Int

    abstract fun start()


    override fun showLoadingDialog() {
        if (!loadingDialog.isShowing) {
            loadingDialog.show()
        }
        loadingDialogCount++
    }

    protected fun cancelLoadingDialog(b: Boolean) {
        if (b) {
            loadingDialogCount = 0
        }
        loadingDialogCount--
        if (loadingDialogCount <= 0) {
            loadingDialog.cancel()
        }
    }

    override fun cancelLoadingDialog() {
        cancelLoadingDialog(false)
    }

    override fun close() {
        finish()
    }

    override fun onDestroy() {
        cancelLoadingDialog(true)
        super.onDestroy()
    }


}