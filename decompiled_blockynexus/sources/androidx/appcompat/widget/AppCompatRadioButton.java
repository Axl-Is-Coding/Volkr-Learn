package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements androidx.core.view.v, androidx.core.widget.l {
    private final C0303p mBackgroundTintHelper;
    private final C0304q mCompoundButtonHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.a();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0304q c0304q = this.mCompoundButtonHelper;
        return c0304q != null ? c0304q.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.view.v
    public ColorStateList getSupportBackgroundTintList() {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            return c0303p.b();
        }
        return null;
    }

    @Override // androidx.core.view.v
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            return c0303p.c();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportButtonTintList() {
        C0304q c0304q = this.mCompoundButtonHelper;
        if (c0304q != null) {
            return c0304q.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0304q c0304q = this.mCompoundButtonHelper;
        if (c0304q != null) {
            return c0304q.c();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0304q c0304q = this.mCompoundButtonHelper;
        if (c0304q != null) {
            c0304q.d();
        }
    }

    @Override // androidx.core.view.v
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.b(colorStateList);
        }
    }

    @Override // androidx.core.view.v
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0304q c0304q = this.mCompoundButtonHelper;
        if (c0304q != null) {
            c0304q.a(colorStateList);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0304q c0304q = this.mCompoundButtonHelper;
        if (c0304q != null) {
            c0304q.a(mode);
        }
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.mCompoundButtonHelper = new C0304q(this);
        this.mCompoundButtonHelper.a(attributeSet, i);
        this.mBackgroundTintHelper = new C0303p(this);
        this.mBackgroundTintHelper.a(attributeSet, i);
        this.mTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper.a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }
}
