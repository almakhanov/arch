package kz.example.arch.presentation.extensions

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

fun DialogFragment.show(fragmentManager: FragmentManager) {
    if (fragmentManager.findFragmentByTag(this.tag) == null) {
        this.show(fragmentManager, this.javaClass.name)
    }
}