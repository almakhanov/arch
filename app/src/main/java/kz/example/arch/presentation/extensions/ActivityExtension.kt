package kz.example.arch.presentation.extensions

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.FragmentActivity

fun FragmentActivity?.back() {
    if (this?.supportFragmentManager?.backStackEntryCount ?: 0 > 1) {
        this?.supportFragmentManager?.popBackStack()
    } else {
        this?.finish()
    }
}

fun FragmentActivity?.pop() = this?.supportFragmentManager?.popBackStack()
//
//fun FragmentActivity?.showFragment(fragment: Fragment, tag: String = fragment.javaClass.name) {
//    this?.supportFragmentManager
//        ?.beginTransaction()
//        ?.setCustomAnimations(
//            R.anim.fade_in_fragment, R.anim.fade_out_fragment,
//            R.anim.fade_in_fragment, R.anim.fade_out_fragment
//        )
//        ?.replace(R.id.fragmentContainer, fragment, tag)
//        ?.addToBackStack(null)
//        ?.commit()
//}

fun Activity?.showKeyboard(view: View) {
    val inputMethodManager =
        this?.getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager?
    inputMethodManager?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

fun Activity?.hideKeyboard() {
    val inputMethodManager =
        this?.getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager?
    inputMethodManager?.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    inputMethodManager?.hideSoftInputFromWindow(
        this?.currentFocus?.windowToken,
        InputMethodManager.HIDE_IMPLICIT_ONLY
    )
}

fun Activity?.getRecourseText(resId: Int) = this?.resources?.getText(resId).toString()

//fun FragmentActivity?.showErrorMessage(
//    title: String = "Error",
//    description: String = "Something went wrong...",
//    iconResId: Int = R.drawable.ic_error
//) {
//    ErrorDialogFragment(title, description, iconResId).show(this?.supportFragmentManager ?: return)
//}
