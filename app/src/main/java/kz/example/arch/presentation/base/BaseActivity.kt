package kz.example.arch.presentation.base

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import kz.example.arch.R

abstract class BaseActivity : AppCompatActivity() {

    open fun setStatusBarColor(colorId: Int = R.color.colorPrimaryDark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = resources.getColor(colorId, this.theme)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(colorId)
        }
    }

    override fun onBackPressed() {
        if (this.supportFragmentManager.backStackEntryCount > 1) {
            this.supportFragmentManager.popBackStack()
        } else {
            this.finish()
        }
    }
}