package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.i.c;
import com.google.android.material.internal.s;
import com.google.android.material.internal.v;
import com.google.android.material.l.j;
import com.google.android.material.l.n;
import com.google.android.material.l.r;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialButton extends AppCompatButton implements Checkable, r {
    private static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_Button;
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    private static final String LOG_TAG = "MaterialButton";
    private boolean broadcasting;
    private boolean checked;
    private Drawable icon;
    private int iconGravity;
    private int iconLeft;
    private int iconPadding;
    private int iconSize;
    private ColorStateList iconTint;
    private PorterDuff.Mode iconTintMode;
    private final com.google.android.material.button.a materialButtonHelper;
    private final LinkedHashSet<a> onCheckedChangeListeners;
    private b onPressedChangeListenerInternal;

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    public MaterialButton(Context context) {
        this(context, null);
    }

    private String getA11yClassName() {
        return (isCheckable() ? CompoundButton.class : Button.class).getName();
    }

    private boolean isLayoutRTL() {
        return ViewCompat.m(this) == 1;
    }

    private boolean isUsingOriginalBackground() {
        com.google.android.material.button.a aVar = this.materialButtonHelper;
        return (aVar == null || aVar.j()) ? false : true;
    }

    private void resetIconDrawable(boolean z) {
        if (z) {
            TextViewCompat.a(this, this.icon, null, null, null);
        } else {
            TextViewCompat.a(this, null, null, this.icon, null);
        }
    }

    private void updateIcon(boolean z) {
        Drawable drawable = this.icon;
        boolean z2 = false;
        if (drawable != null) {
            this.icon = androidx.core.graphics.drawable.a.i(drawable).mutate();
            androidx.core.graphics.drawable.a.a(this.icon, this.iconTint);
            PorterDuff.Mode mode = this.iconTintMode;
            if (mode != null) {
                androidx.core.graphics.drawable.a.a(this.icon, mode);
            }
            int intrinsicWidth = this.iconSize;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.icon.getIntrinsicWidth();
            }
            int intrinsicHeight = this.iconSize;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.icon.getIntrinsicHeight();
            }
            Drawable drawable2 = this.icon;
            int i = this.iconLeft;
            drawable2.setBounds(i, 0, intrinsicWidth + i, intrinsicHeight);
        }
        int i2 = this.iconGravity;
        boolean z3 = i2 == 1 || i2 == 2;
        if (z) {
            resetIconDrawable(z3);
            return;
        }
        Drawable[] drawableArrA = TextViewCompat.a(this);
        Drawable drawable3 = drawableArrA[0];
        Drawable drawable4 = drawableArrA[2];
        if ((z3 && drawable3 != this.icon) || (!z3 && drawable4 != this.icon)) {
            z2 = true;
        }
        if (z2) {
            resetIconDrawable(z3);
        }
    }

    private void updateIconPosition() {
        if (this.icon == null || getLayout() == null) {
            return;
        }
        int i = this.iconGravity;
        if (i == 1 || i == 3) {
            this.iconLeft = 0;
            updateIcon(false);
            return;
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        int iMin = Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
        int intrinsicWidth = this.iconSize;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.icon.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - iMin) - ViewCompat.q(this)) - intrinsicWidth) - this.iconPadding) - ViewCompat.r(this)) / 2;
        if (isLayoutRTL() != (this.iconGravity == 4)) {
            measuredWidth = -measuredWidth;
        }
        if (this.iconLeft != measuredWidth) {
            this.iconLeft = measuredWidth;
            updateIcon(false);
        }
    }

    public void addOnCheckedChangeListener(a aVar) {
        this.onCheckedChangeListeners.add(aVar);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.a();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.d();
        }
        return null;
    }

    public n getShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.e();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.f();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.g();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.v
    public ColorStateList getSupportBackgroundTintList() {
        return isUsingOriginalBackground() ? this.materialButtonHelper.h() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.v
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return isUsingOriginalBackground() ? this.materialButtonHelper.i() : super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        com.google.android.material.button.a aVar = this.materialButtonHelper;
        return aVar != null && aVar.k();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.a(this, this.materialButtonHelper.c());
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isCheckable()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.google.android.material.button.a aVar;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.materialButtonHelper) == null) {
            return;
        }
        aVar.a(i4 - i2, i3 - i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        updateIconPosition();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        updateIconPosition();
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void removeOnCheckedChangeListener(a aVar) {
        this.onCheckedChangeListeners.remove(aVar);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.a(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!isUsingOriginalBackground()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w(LOG_TAG, "Do not set the background; MaterialButton manages its own background drawable.");
            this.materialButtonHelper.l();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.a(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (isCheckable() && isEnabled() && this.checked != z) {
            this.checked = z;
            refreshDrawableState();
            if (this.broadcasting) {
                return;
            }
            this.broadcasting = true;
            Iterator<a> it = this.onCheckedChangeListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.checked);
            }
            this.broadcasting = false;
        }
    }

    public void setCornerRadius(int i) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.b(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.c().b(f2);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.icon != drawable) {
            this.icon = drawable;
            updateIcon(true);
        }
    }

    public void setIconGravity(int i) {
        if (this.iconGravity != i) {
            this.iconGravity = i;
            updateIconPosition();
        }
    }

    public void setIconPadding(int i) {
        if (this.iconPadding != i) {
            this.iconPadding = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.iconSize != i) {
            this.iconSize = i;
            updateIcon(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.iconTint != colorStateList) {
            this.iconTint = colorStateList;
            updateIcon(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.iconTintMode != mode) {
            this.iconTintMode = mode;
            updateIcon(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(androidx.appcompat.a.a.a.a(getContext(), i));
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(b bVar) {
        this.onPressedChangeListenerInternal = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        b bVar = this.onPressedChangeListenerInternal;
        if (bVar != null) {
            bVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.a(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (isUsingOriginalBackground()) {
            setRippleColor(androidx.appcompat.a.a.a.a(getContext(), i));
        }
    }

    @Override // com.google.android.material.l.r
    public void setShapeAppearanceModel(n nVar) {
        if (!isUsingOriginalBackground()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.materialButtonHelper.a(nVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.b(z);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.b(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (isUsingOriginalBackground()) {
            setStrokeColor(androidx.appcompat.a.a.a.a(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.c(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.v
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.c(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.v
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.a(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialButtonStyle);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(s.a(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.onCheckedChangeListeners = new LinkedHashSet<>();
        this.checked = false;
        this.broadcasting = false;
        Context context2 = getContext();
        TypedArray typedArrayA = s.a(context2, attributeSet, com.google.android.material.R.styleable.MaterialButton, i, DEF_STYLE_RES, new int[0]);
        this.iconPadding = typedArrayA.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = v.a(typedArrayA.getInt(com.google.android.material.R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = c.a(getContext(), typedArrayA, com.google.android.material.R.styleable.MaterialButton_iconTint);
        this.icon = c.b(getContext(), typedArrayA, com.google.android.material.R.styleable.MaterialButton_icon);
        this.iconGravity = typedArrayA.getInteger(com.google.android.material.R.styleable.MaterialButton_iconGravity, 1);
        this.iconSize = typedArrayA.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconSize, 0);
        this.materialButtonHelper = new com.google.android.material.button.a(this, n.a(context2, attributeSet, i, DEF_STYLE_RES).a());
        this.materialButtonHelper.a(typedArrayA);
        typedArrayA.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        updateIcon(this.icon != null);
    }
}
