package kz.example.arch.presentation.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlin.reflect.KProperty

inline fun EditText.doOnTextChange(crossinline body: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            // do nothing
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // do nothing
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            s?.let {
                body(s.toString())
            }
        }
    })
}
//
//inline fun EditText.setMaskedTextListener(
//    defaultTextFormat: String = "+7 ([000]) [000]-[00]-[00]",
//    affineFormats: ArrayList<String> = arrayListOf("8 ([000]) [000]-[00]-[00]"),
//    hint: String? = null,
//    crossinline callback: (String) -> Unit
//) {
//    val phoneMaskListener = MaskedTextChangedListener.installOn(
//        this,
//        defaultTextFormat,
//        affineFormats,
//        AffinityCalculationStrategy.PREFIX,
//        object : MaskedTextChangedListener.ValueListener {
//            override fun onTextChanged(maskFilled: Boolean, extractedValue: String, formattedValue: String) {
//                callback(extractedValue)
//            }
//        }
//    )
//    this.hint = hint ?: phoneMaskListener.placeholder()
//    this.maskListener = phoneMaskListener
//}


/**
 * [FieldProperty] - дает возможность создавать новые поля для существующих классов
 * так как котлин не дает создавать extension поля, а только методы,
 * используем делегирование
 */
class FieldProperty<R, T : Any>(
    val initializer: (R) -> T = { throw IllegalStateException("Not initialized.") }
) {
    private val map = HashMap<R, T>()

    operator fun getValue(thisRef: R, property: KProperty<*>): T =
        map[thisRef] ?: setValue(thisRef, property, initializer(thisRef))

    operator fun setValue(thisRef: R, property: KProperty<*>, value: T): T {
        map[thisRef] = value
        return value
    }
}

/**
 * Extension field for masked EditText
 * Используется для setText() маски
 */
//var EditText.maskListener: MaskedTextChangedListener by FieldProperty { it.maskListener }