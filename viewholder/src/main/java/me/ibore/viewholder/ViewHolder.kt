package me.ibore.viewholder

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ListAdapter
import android.widget.SpinnerAdapter
import androidx.annotation.*
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.request.RequestOptions

interface ViewHolder<VH : ViewHolder<VH>> {

    companion object {
        fun create(itemView: View): ViewHolderImpl {
            return ViewHolderImpl(itemView)
        }
    }

    fun parent(): View

    fun context(): Context

    fun <T : View> view(@IdRes id: Int): T

    fun text(@IdRes id: Int, text: CharSequence?): VH

    fun text(@IdRes id: Int, @StringRes resId: Int): VH

    fun textSize(@IdRes id: Int, textSize: Float): VH

    fun textColor(@IdRes id: Int, @ColorInt color: Int): VH

    fun textColorRes(@IdRes id: Int, @ColorRes colorRes: Int): VH

    fun textSingleLine(@IdRes id: Int, singleLine: Boolean): VH

    fun textMarquee(@IdRes id: Int, boolean: Boolean): VH

    fun textEllipsize(@IdRes id: Int, where: TextUtils.TruncateAt): ViewHolderImpl

    fun hint(@IdRes id: Int, hint: CharSequence?): VH

    fun hint(@IdRes id: Int, @StringRes resId: Int): VH

    fun hintColor(@IdRes id: Int, @ColorInt color: Int): VH

    fun hintColorRes(@IdRes id: Int, @ColorRes colorRes: Int): VH

    fun compoundDrawables(@IdRes id: Int, @DrawableRes left: Int, @DrawableRes top: Int, @DrawableRes right: Int, @DrawableRes bottom: Int): VH

    fun compoundDrawables(@IdRes id: Int, left: Drawable, top: Drawable, right: Drawable, bottom: Drawable): VH

    fun compoundDrawablePadding(@IdRes id: Int, pad: Int): VH

    fun imageUrl(@IdRes id: Int, url: String): VH

    fun imageUrl(@IdRes id: Int, url: String, requestOptions: RequestOptions): VH

    fun imageResource(@IdRes id: Int, @DrawableRes resId: Int): VH

    fun imageDrawable(@IdRes id: Int, drawable: Drawable): VH

    fun imageBitmap(@IdRes id: Int, bitmap: Bitmap): VH

    fun backgroundRes(@IdRes id: Int, @DrawableRes resId: Int): VH

    fun background(@IdRes id: Int, background: Drawable): VH

    fun backgroundColorRes(@IdRes id: Int, @ColorRes normalColor: Int, @ColorRes pressedColor: Int): ViewHolderImpl

    fun backgroundColorRes(@IdRes id: Int, @ColorRes normalColor: Int, @ColorRes pressedColor: Int, radius: Float): ViewHolderImpl

    fun backgroundColorRes(@IdRes id: Int, @ColorRes normalColor: Int, @ColorRes pressedColor: Int, topStartRadius: Float, topEndRadius: Float, bottomEndRadius: Float, bottomStartRadius: Float): ViewHolderImpl

    fun backgroundColor(@IdRes id: Int, @ColorInt normalColor: Int, @ColorInt pressedColor: Int): ViewHolderImpl

    fun backgroundColor(@IdRes id: Int, @ColorInt normalColor: Int, @ColorInt pressedColor: Int, radius: Float): ViewHolderImpl

    fun backgroundColor(@IdRes id: Int, @ColorInt normalColor: Int, @ColorInt pressedColor: Int, topStartRadius: Float, topEndRadius: Float, bottomEndRadius: Float, bottomStartRadius: Float): ViewHolderImpl

    fun layoutParams(@IdRes id: Int, layoutParams: ViewGroup.LayoutParams): VH

    fun visibility(@IdRes id: Int, visibility: Int): VH

    fun checked(@IdRes id: Int, checked: Boolean): VH

    fun selected(@IdRes id: Int, selected: Boolean): VH

    fun enabled(@IdRes id: Int, enabled: Boolean): VH

    fun clickable(@IdRes id: Int, clickable: Boolean): VH

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun elevation(@IdRes id: Int, elevation: Float): VH

    fun padding(@IdRes id: Int, left: Int, top: Int, right: Int, bottom: Int): VH

    fun padding(@IdRes id: Int, left: Int, top: Int, right: Int, bottom: Int, clipToPadding: Boolean): VH

    fun margin(@IdRes id: Int, left: Int, top: Int, right: Int, bottom: Int): VH

    fun clipToPadding(@IdRes id: Int, clipToPadding: Boolean): VH

    fun clipChildren(@IdRes id: Int, clipChildren: Boolean): VH

    fun translationX(@IdRes id: Int, translationX: Float): VH

    fun translationY(@IdRes id: Int, translationY: Float): VH

    fun onClickListener(@IdRes id: Int, onClickListener: View.OnClickListener): VH

    fun onLongClickListener(@IdRes id: Int, onLongClickListener: View.OnLongClickListener): VH

    fun recyclerView(@IdRes id: Int, layoutManager: RecyclerView.LayoutManager, adapter: RecyclerView.Adapter<*>): VH

    fun adapter(@IdRes id: Int, adapter: RecyclerView.Adapter<*>): VH

    fun adapter(@IdRes id: Int, adapter: ListAdapter): VH

    fun adapter(@IdRes id: Int, adapter: PagerAdapter): VH

    fun adapter(@IdRes id: Int, adapter: SpinnerAdapter): VH

    fun adapter(@IdRes id: Int, adapter: Adapter): VH

    fun destroy()

}