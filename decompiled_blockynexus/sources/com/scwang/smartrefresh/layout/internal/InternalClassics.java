package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.a.i;
import com.scwang.smartrefresh.layout.a.j;
import com.scwang.smartrefresh.layout.internal.InternalClassics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class InternalClassics<T extends InternalClassics> extends InternalAbstract implements h {
    protected b mArrowDrawable;
    protected ImageView mArrowView;
    protected int mBackgroundColor;
    protected int mFinishDuration;
    protected int mMinHeightOfContent;
    protected int mPaddingBottom;
    protected int mPaddingTop;
    protected b mProgressDrawable;
    protected ImageView mProgressView;
    protected i mRefreshKernel;
    protected boolean mSetAccentColor;
    protected boolean mSetPrimaryColor;
    protected TextView mTitleText;
    public static final int ID_TEXT_TITLE = R.id.srl_classics_title;
    public static final int ID_IMAGE_ARROW = R.id.srl_classics_arrow;
    public static final int ID_IMAGE_PROGRESS = R.id.srl_classics_progress;

    public InternalClassics(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFinishDuration = 500;
        this.mPaddingTop = 20;
        this.mPaddingBottom = 20;
        this.mMinHeightOfContent = 0;
        this.mSpinnerStyle = com.scwang.smartrefresh.layout.constant.b.f19149a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 14) {
            ImageView imageView = this.mArrowView;
            ImageView imageView2 = this.mProgressView;
            imageView.animate().cancel();
            imageView2.animate().cancel();
        }
        Object drawable = this.mProgressView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public int onFinish(j jVar, boolean z) {
        ImageView imageView = this.mProgressView;
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(WheelView.DividerConfig.FILL).setDuration(0L);
        }
        imageView.setVisibility(8);
        return this.mFinishDuration;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public void onInitialized(i iVar, int i, int i2) {
        this.mRefreshKernel = iVar;
        this.mRefreshKernel.a(this, this.mBackgroundColor);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mMinHeightOfContent == 0) {
            this.mPaddingTop = getPaddingTop();
            this.mPaddingBottom = getPaddingBottom();
            if (this.mPaddingTop == 0 || this.mPaddingBottom == 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int iA = this.mPaddingTop;
                if (iA == 0) {
                    iA = com.scwang.smartrefresh.layout.c.c.a(20.0f);
                }
                this.mPaddingTop = iA;
                int iA2 = this.mPaddingBottom;
                if (iA2 == 0) {
                    iA2 = com.scwang.smartrefresh.layout.c.c.a(20.0f);
                }
                this.mPaddingBottom = iA2;
                setPadding(paddingLeft, this.mPaddingTop, paddingRight, this.mPaddingBottom);
            }
            setClipToPadding(false);
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            int size = View.MeasureSpec.getSize(i2);
            int i3 = this.mMinHeightOfContent;
            if (size < i3) {
                int i4 = (size - i3) / 2;
                setPadding(getPaddingLeft(), i4, getPaddingRight(), i4);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.mPaddingTop, getPaddingRight(), this.mPaddingBottom);
        }
        super.onMeasure(i, i2);
        if (this.mMinHeightOfContent == 0) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                int measuredHeight = getChildAt(i5).getMeasuredHeight();
                if (this.mMinHeightOfContent < measuredHeight) {
                    this.mMinHeightOfContent = measuredHeight;
                }
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public void onReleased(j jVar, int i, int i2) {
        onStartAnimator(jVar, i, i2);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public void onStartAnimator(j jVar, int i, int i2) {
        ImageView imageView = this.mProgressView;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Object drawable = this.mProgressView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000L);
            }
        }
    }

    protected T self() {
        return this;
    }

    public T setAccentColor(int i) {
        this.mSetAccentColor = true;
        this.mTitleText.setTextColor(i);
        b bVar = this.mArrowDrawable;
        if (bVar != null) {
            bVar.a(i);
            this.mArrowView.invalidateDrawable(this.mArrowDrawable);
        }
        b bVar2 = this.mProgressDrawable;
        if (bVar2 != null) {
            bVar2.a(i);
            this.mProgressView.invalidateDrawable(this.mProgressDrawable);
        }
        return (T) self();
    }

    public T setAccentColorId(int i) {
        setAccentColor(androidx.core.content.b.a(getContext(), i));
        return (T) self();
    }

    public T setArrowDrawable(Drawable drawable) {
        this.mArrowDrawable = null;
        this.mArrowView.setImageDrawable(drawable);
        return (T) self();
    }

    public T setArrowResource(int i) {
        this.mArrowDrawable = null;
        this.mArrowView.setImageResource(i);
        return (T) self();
    }

    public T setDrawableArrowSize(float f2) {
        ImageView imageView = this.mArrowView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iA = com.scwang.smartrefresh.layout.c.c.a(f2);
        layoutParams.width = iA;
        layoutParams.height = iA;
        imageView.setLayoutParams(layoutParams);
        return (T) self();
    }

    public T setDrawableMarginRight(float f2) {
        ImageView imageView = this.mArrowView;
        ImageView imageView2 = this.mProgressView;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) imageView2.getLayoutParams();
        int iA = com.scwang.smartrefresh.layout.c.c.a(f2);
        marginLayoutParams2.rightMargin = iA;
        marginLayoutParams.rightMargin = iA;
        imageView.setLayoutParams(marginLayoutParams);
        imageView2.setLayoutParams(marginLayoutParams2);
        return (T) self();
    }

    public T setDrawableProgressSize(float f2) {
        ImageView imageView = this.mProgressView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iA = com.scwang.smartrefresh.layout.c.c.a(f2);
        layoutParams.width = iA;
        layoutParams.height = iA;
        imageView.setLayoutParams(layoutParams);
        return (T) self();
    }

    public T setDrawableSize(float f2) {
        ImageView imageView = this.mArrowView;
        ImageView imageView2 = this.mProgressView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int iA = com.scwang.smartrefresh.layout.c.c.a(f2);
        layoutParams2.width = iA;
        layoutParams.width = iA;
        int iA2 = com.scwang.smartrefresh.layout.c.c.a(f2);
        layoutParams2.height = iA2;
        layoutParams.height = iA2;
        imageView.setLayoutParams(layoutParams);
        imageView2.setLayoutParams(layoutParams2);
        return (T) self();
    }

    public T setFinishDuration(int i) {
        this.mFinishDuration = i;
        return (T) self();
    }

    public T setPrimaryColor(int i) {
        this.mSetPrimaryColor = true;
        this.mBackgroundColor = i;
        i iVar = this.mRefreshKernel;
        if (iVar != null) {
            iVar.a(this, i);
        }
        return (T) self();
    }

    public T setPrimaryColorId(int i) {
        setPrimaryColor(androidx.core.content.b.a(getContext(), i));
        return (T) self();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && !this.mSetPrimaryColor) {
                setPrimaryColor(iArr[0]);
                this.mSetPrimaryColor = false;
            }
            if (this.mSetAccentColor) {
                return;
            }
            if (iArr.length > 1) {
                setAccentColor(iArr[1]);
            } else {
                setAccentColor(iArr[0] == -1 ? -10066330 : -1);
            }
            this.mSetAccentColor = false;
        }
    }

    public T setProgressDrawable(Drawable drawable) {
        this.mProgressDrawable = null;
        this.mProgressView.setImageDrawable(drawable);
        return (T) self();
    }

    public T setProgressResource(int i) {
        this.mProgressDrawable = null;
        this.mProgressView.setImageResource(i);
        return (T) self();
    }

    public T setSpinnerStyle(com.scwang.smartrefresh.layout.constant.b bVar) {
        this.mSpinnerStyle = bVar;
        return (T) self();
    }

    public T setTextSizeTitle(float f2) {
        this.mTitleText.setTextSize(f2);
        i iVar = this.mRefreshKernel;
        if (iVar != null) {
            iVar.a(this);
        }
        return (T) self();
    }
}
