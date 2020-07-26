package me.ibore.viewholder

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.os.Build
import android.text.TextUtils
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.core.util.keyIterator
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

open class ViewHolderImpl(private val parentView: View) : ViewHolder<ViewHolderImpl> {

    private val mViews: SparseArray<View> = SparseArray()

    override fun parent(): View = parentView

    override fun context(): Context {
        return parentView.context
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : View> view(@IdRes id: Int): T {
        var view: View? = mViews.get(id)
        if (null == view) {
            view = parentView.findViewById(id)
            mViews.append(id, view)
        }
        return view as T
    }

    override fun text(@IdRes id: Int, text: CharSequence?): ViewHolderImpl {
        view<TextView>(id).text = text
        return this
    }

    override fun text(@IdRes id: Int, @StringRes resId: Int): ViewHolderImpl {
        view<TextView>(id).setText(resId)
        return this
    }

    override fun textSize(@IdRes id: Int, textSize: Float): ViewHolderImpl {
        view<TextView>(id).textSize = textSize
        return this
    }

    override fun textColor(@IdRes id: Int, @ColorInt color: Int): ViewHolderImpl {
        view<TextView>(id).setTextColor(color)
        return this
    }

    override fun textColorRes(@IdRes id: Int, @ColorRes colorRes: Int): ViewHolderImpl {
        view<TextView>(id).setTextColor(ContextCompat.getColor(parentView.context, colorRes))
        return this
    }

    override fun textSingleLine(@IdRes id: Int, singleLine: Boolean): ViewHolderImpl {
        view<TextView>(id).isSingleLine = singleLine
        return this
    }

    override fun textMarquee(@IdRes id: Int, boolean: Boolean): ViewHolderImpl {
        view<TextView>(id).setSingleLine()
        view<TextView>(id).ellipsize = TextUtils.TruncateAt.MARQUEE
        view<TextView>(id).isFocusable = true
        view<TextView>(id).marqueeRepeatLimit = -1
        view<TextView>(id).isFocusableInTouchMode = true
        return this
    }

    override fun textEllipsize(@IdRes id: Int, where: TextUtils.TruncateAt): ViewHolderImpl {
        view<TextView>(id).ellipsize = where
        return this
    }

    override fun hint(@IdRes id: Int, hint: CharSequence?): ViewHolderImpl {
        view<TextView>(id).hint = hint
        return this
    }

    override fun hint(@IdRes id: Int, @StringRes resId: Int): ViewHolderImpl {
        view<TextView>(id).setHint(resId)
        return this
    }

    override fun hintColor(@IdRes id: Int, @ColorInt color: Int): ViewHolderImpl {
        view<TextView>(id).setHintTextColor(color)
        return this
    }

    override fun hintColorRes(@IdRes id: Int, @ColorRes colorRes: Int): ViewHolderImpl {
        view<TextView>(id).setHintTextColor(ContextCompat.getColor(parentView.context, colorRes))
        return this
    }

    override fun compoundDrawables(@IdRes id: Int, @DrawableRes left: Int, @DrawableRes top: Int, @DrawableRes right: Int, @DrawableRes bottom: Int): ViewHolderImpl {
        view<TextView>(id).setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)
        return this
    }

    override fun compoundDrawables(@IdRes id: Int, left: Drawable, top: Drawable, right: Drawable, bottom: Drawable): ViewHolderImpl {
        view<TextView>(id).setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)
        return this
    }

    override fun compoundDrawablePadding(@IdRes id: Int, pad: Int): ViewHolderImpl {
        view<TextView>(id).compoundDrawablePadding = pad
        return this
    }

    override fun imageUrl(@IdRes id: Int, url: String): ViewHolderImpl {
        Glide.with(view<ImageView>(id)).load(url).into(view(id))
        return this
    }

    override fun imageUrl(@IdRes id: Int, url: String, requestOptions: RequestOptions): ViewHolderImpl {
        Glide.with(view<ImageView>(id).context).load(url).apply(requestOptions).into(view(id))
        return this
    }

    override fun imageResource(@IdRes id: Int, @DrawableRes resId: Int): ViewHolderImpl {
        view<ImageView>(id).setImageResource(resId)
        return this
    }

    override fun imageDrawable(@IdRes id: Int, drawable: Drawable): ViewHolderImpl {
        view<ImageView>(id).setImageDrawable(drawable)
        return this
    }

    override fun imageBitmap(@IdRes id: Int, bitmap: Bitmap): ViewHolderImpl {
        view<ImageView>(id).setImageBitmap(bitmap)
        return this
    }

    override fun backgroundRes(@IdRes id: Int, @DrawableRes resId: Int): ViewHolderImpl {
        view<View>(id).setBackgroundResource(resId)
        return this
    }

    override fun background(@IdRes id: Int, background: Drawable): ViewHolderImpl {
        view<View>(id).background = background
        return this
    }

    override fun backgroundColorRes(@IdRes id: Int, @ColorRes normalColor: Int, @ColorRes pressedColor: Int): ViewHolderImpl {
        return backgroundColorRes(id, normalColor, pressedColor, radius = 0F)
    }

    override fun backgroundColorRes(@IdRes id: Int, @ColorRes normalColor: Int, @ColorRes pressedColor: Int, radius: Float): ViewHolderImpl {
        return backgroundColor(id, ContextCompat.getColor(parentView.context, normalColor), ContextCompat.getColor(parentView.context, pressedColor), radius)
    }

    override fun backgroundColorRes(@IdRes id: Int, @ColorRes normalColor: Int, @ColorRes pressedColor: Int, topStartRadius: Float, topEndRadius: Float, bottomEndRadius: Float, bottomStartRadius: Float): ViewHolderImpl {
        return backgroundColor(id, ContextCompat.getColor(parentView.context, normalColor), ContextCompat.getColor(parentView.context, pressedColor), topStartRadius, topEndRadius, bottomEndRadius, bottomStartRadius)
    }

    override fun backgroundColor(@IdRes id: Int, @ColorInt normalColor: Int, @ColorInt pressedColor: Int): ViewHolderImpl {
        return backgroundColor(id, normalColor, pressedColor, radius = 0F)
    }

    override fun backgroundColor(@IdRes id: Int, @ColorInt normalColor: Int, @ColorInt pressedColor: Int, radius: Float): ViewHolderImpl {
        return backgroundColor(id, normalColor, pressedColor, radius, radius, radius, radius)
    }

    override fun backgroundColor(@IdRes id: Int, @ColorInt normalColor: Int, @ColorInt pressedColor: Int, topStartRadius: Float, topEndRadius: Float, bottomEndRadius: Float, bottomStartRadius: Float): ViewHolderImpl {
        val cornerRadii = floatArrayOf(topStartRadius, topStartRadius, topEndRadius, topEndRadius, bottomEndRadius, bottomEndRadius, bottomStartRadius, bottomStartRadius)
        val stateListDrawable = StateListDrawable()
        val drawableNormal = GradientDrawable()
        drawableNormal.setColor(normalColor)
        drawableNormal.cornerRadii = cornerRadii
        val drawablePressed = GradientDrawable()
        drawablePressed.setColor(pressedColor)
        drawablePressed.cornerRadii = cornerRadii
        stateListDrawable.addState(intArrayOf(android.R.attr.state_pressed), drawablePressed)
        stateListDrawable.addState(intArrayOf(android.R.attr.state_selected), drawablePressed)
        stateListDrawable.addState(intArrayOf(), drawableNormal)
        view<View>(id).background = stateListDrawable
        return this
    }

    override fun layoutParams(@IdRes id: Int, layoutParams: ViewGroup.LayoutParams): ViewHolderImpl {
        view<View>(id).layoutParams = layoutParams
        return this
    }

    override fun visibility(@IdRes id: Int, visibility: Int): ViewHolderImpl {
        view<View>(id).visibility = visibility
        return this
    }

    override fun checked(@IdRes id: Int, checked: Boolean): ViewHolderImpl {
        view<CompoundButton>(id).isChecked = checked
        return this
    }

    override fun selected(@IdRes id: Int, selected: Boolean): ViewHolderImpl {
        view<View>(id).isSelected = selected
        return this
    }

    override fun enabled(@IdRes id: Int, enabled: Boolean): ViewHolderImpl {
        view<View>(id).isEnabled = enabled
        return this
    }

    override fun clickable(@IdRes id: Int, clickable: Boolean): ViewHolderImpl {
        view<View>(id).isClickable = clickable
        return this
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun elevation(@IdRes id: Int, elevation: Float): ViewHolderImpl {
        view<View>(id).elevation = elevation
        return this
    }

    override fun padding(@IdRes id: Int, left: Int, top: Int, right: Int, bottom: Int): ViewHolderImpl {
        view<View>(id).setPadding(left, top, right, bottom)
        return this
    }

    override fun padding(@IdRes id: Int, left: Int, top: Int, right: Int, bottom: Int, clipToPadding: Boolean): ViewHolderImpl {
        padding(id, left, top, right, bottom)
        clipToPadding(id, clipToPadding)
        return this
    }

    override fun margin(@IdRes id: Int, left: Int, top: Int, right: Int, bottom: Int): ViewHolderImpl {
        val layoutParams = view<View>(id).layoutParams
        val marginLayoutParams = if (layoutParams is ViewGroup.MarginLayoutParams) {
            layoutParams
        } else {
            ViewGroup.MarginLayoutParams(layoutParams.width, layoutParams.height)
        }
        marginLayoutParams.setMargins(left, top, right, bottom)
        view<View>(id).layoutParams = marginLayoutParams
        return this
    }

    override fun clipToPadding(@IdRes id: Int, clipToPadding: Boolean): ViewHolderImpl {
        view<ViewGroup>(id).clipToPadding = clipToPadding
        return this
    }

    override fun clipChildren(@IdRes id: Int, clipChildren: Boolean): ViewHolderImpl {
        view<ViewGroup>(id).clipChildren = clipChildren
        return this
    }

    override fun translationX(@IdRes id: Int, translationX: Float): ViewHolderImpl {
        view<View>(id).translationX = translationX
        return this
    }

    override fun translationY(@IdRes id: Int, translationY: Float): ViewHolderImpl {
        view<View>(id).translationY = translationY
        return this
    }

    override fun onClickListener(@IdRes id: Int, onClickListener: View.OnClickListener): ViewHolderImpl {
        view<View>(id).setOnClickListener(onClickListener)
        return this
    }

    override fun onLongClickListener(@IdRes id: Int, onLongClickListener: View.OnLongClickListener): ViewHolderImpl {
        view<View>(id).setOnLongClickListener(onLongClickListener)
        return this
    }

    override fun recyclerView(@IdRes id: Int, layoutManager: RecyclerView.LayoutManager, adapter: RecyclerView.Adapter<*>): ViewHolderImpl {
        view<RecyclerView>(id).layoutManager = layoutManager
        view<RecyclerView>(id).adapter = adapter
        return this
    }

    override fun adapter(@IdRes id: Int, adapter: RecyclerView.Adapter<*>): ViewHolderImpl {
        view<RecyclerView>(id).adapter = adapter
        return this
    }

    override fun adapter(@IdRes id: Int, adapter: ListAdapter): ViewHolderImpl {
        view<ListView>(id).adapter = adapter
        return this
    }

    override fun adapter(@IdRes id: Int, adapter: PagerAdapter): ViewHolderImpl {
        view<ViewPager>(id).adapter = adapter
        return this
    }

    override fun adapter(id: Int, adapter: SpinnerAdapter): ViewHolderImpl {
        view<Spinner>(id).adapter = adapter
        return this
    }

    override fun adapter(@IdRes id: Int, adapter: Adapter): ViewHolderImpl {
        view<AdapterView<*>>(id).adapter = adapter
        return this
    }

    override fun destroy() {
        for (id in mViews.keyIterator()) {
            if (mViews[id] is ImageView) {
                mViews[id].setWillNotDraw(true)
            }
        }
        mViews.clear()
    }

}