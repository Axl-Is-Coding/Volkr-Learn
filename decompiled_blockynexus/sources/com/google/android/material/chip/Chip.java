package com.google.android.material.chip;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.C0313a;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.b;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.chip.c;
import com.google.android.material.i.f;
import com.google.android.material.i.h;
import com.google.android.material.internal.s;
import com.google.android.material.internal.v;
import com.google.android.material.l.j;
import com.google.android.material.l.n;
import com.google.android.material.l.r;
import com.umeng.analytics.pro.au;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Chip extends AppCompatCheckBox implements c.a, r {
    private static final String BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.Button";
    private static final int CHIP_BODY_VIRTUAL_ID = 0;
    private static final int CLOSE_ICON_VIRTUAL_ID = 1;
    private static final String COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.CompoundButton";
    private static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private static final int MIN_TOUCH_TARGET_DP = 48;
    private static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private static final String TAG = "Chip";
    private c chipDrawable;
    private boolean closeIconFocused;
    private boolean closeIconHovered;
    private boolean closeIconPressed;
    private boolean deferredCheckedValue;
    private boolean ensureMinTouchTargetSize;
    private final h fontCallback;
    private InsetDrawable insetBackgroundDrawable;
    private int lastLayoutDirection;
    private int minTouchTargetSize;
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;
    private View.OnClickListener onCloseIconClickListener;
    private final Rect rect;
    private final RectF rectF;
    private RippleDrawable ripple;
    private final a touchHelper;
    private static final Rect EMPTY_BOUNDS = new Rect();
    private static final int[] SELECTED_STATE = {R.attr.state_selected};
    private static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};

    private class a extends androidx.customview.b.c {
        a(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.b.c
        protected int a(float f2, float f3) {
            return (Chip.this.hasCloseIcon() && Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 1 : 0;
        }

        @Override // androidx.customview.b.c
        protected void a(List<Integer> list) {
            list.add(0);
            if (Chip.this.hasCloseIcon() && Chip.this.isCloseIconVisible()) {
                list.add(1);
            }
        }

        @Override // androidx.customview.b.c
        protected void a(int i, boolean z) {
            if (i == 1) {
                Chip.this.closeIconFocused = z;
                Chip.this.refreshDrawableState();
            }
        }

        @Override // androidx.customview.b.c
        protected void a(int i, androidx.core.view.accessibility.b bVar) {
            if (i == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    bVar.c(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i2 = com.google.android.material.R.string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (TextUtils.isEmpty(text)) {
                        text = "";
                    }
                    objArr[0] = text;
                    bVar.c(context.getString(i2, objArr).trim());
                }
                bVar.c(Chip.this.getCloseIconTouchBoundsInt());
                bVar.a(b.a.f1237e);
                bVar.h(Chip.this.isEnabled());
                return;
            }
            bVar.c("");
            bVar.c(Chip.EMPTY_BOUNDS);
        }

        @Override // androidx.customview.b.c
        protected void a(androidx.core.view.accessibility.b bVar) {
            bVar.c(Chip.this.isCheckable());
            bVar.e(Chip.this.isClickable());
            if (!Chip.this.isCheckable() && !Chip.this.isClickable()) {
                bVar.b(Chip.GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
            } else {
                bVar.b((CharSequence) (Chip.this.isCheckable() ? Chip.COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME : Chip.BUTTON_ACCESSIBILITY_CLASS_NAME));
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.h(text);
            } else {
                bVar.c(text);
            }
        }

        @Override // androidx.customview.b.c
        protected boolean a(int i, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            if (i == 0) {
                return Chip.this.performClick();
            }
            if (i == 1) {
                return Chip.this.performCloseIconClick();
            }
            return false;
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    private void applyChipDrawable(c cVar) {
        cVar.a(this);
    }

    private int[] createCloseIconDrawableState() {
        int i = 0;
        int i2 = isEnabled() ? 1 : 0;
        if (this.closeIconFocused) {
            i2++;
        }
        if (this.closeIconHovered) {
            i2++;
        }
        if (this.closeIconPressed) {
            i2++;
        }
        if (isChecked()) {
            i2++;
        }
        int[] iArr = new int[i2];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i = 1;
        }
        if (this.closeIconFocused) {
            iArr[i] = 16842908;
            i++;
        }
        if (this.closeIconHovered) {
            iArr[i] = 16843623;
            i++;
        }
        if (this.closeIconPressed) {
            iArr[i] = 16842919;
            i++;
        }
        if (isChecked()) {
            iArr[i] = 16842913;
        }
        return iArr;
    }

    private void ensureChipDrawableHasCallback() {
        if (getBackgroundDrawable() == this.insetBackgroundDrawable && this.chipDrawable.getCallback() == null) {
            this.chipDrawable.setCallback(this.insetBackgroundDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if (hasCloseIcon()) {
            this.chipDrawable.a(this.rectF);
        }
        return this.rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.rect.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.rect;
    }

    private f getTextAppearance() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.U();
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private boolean handleAccessibilityExit(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = androidx.customview.b.c.class.getDeclaredField(au.aw);
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.touchHelper)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = androidx.customview.b.c.class.getDeclaredMethod(au.ay, Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.touchHelper, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Unable to send Accessibility Exit event", e2);
            } catch (NoSuchFieldException e3) {
                Log.e(TAG, "Unable to send Accessibility Exit event", e3);
            } catch (NoSuchMethodException e4) {
                Log.e(TAG, "Unable to send Accessibility Exit event", e4);
            } catch (InvocationTargetException e5) {
                Log.e(TAG, "Unable to send Accessibility Exit event", e5);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasCloseIcon() {
        c cVar = this.chipDrawable;
        return (cVar == null || cVar.G() == null) ? false : true;
    }

    private void initMinTouchTarget(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayA = s.a(context, attributeSet, com.google.android.material.R.styleable.Chip, i, com.google.android.material.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        this.ensureMinTouchTargetSize = typedArrayA.getBoolean(com.google.android.material.R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.minTouchTargetSize = (int) Math.ceil(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(v.a(getContext(), 48))));
        typedArrayA.recycle();
    }

    private void initOutlineProvider() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b(this));
        }
    }

    private void insetChipBackgroundDrawable(int i, int i2, int i3, int i4) {
        this.insetBackgroundDrawable = new InsetDrawable((Drawable) this.chipDrawable, i, i2, i3, i4);
    }

    private void removeBackgroundInset() {
        if (this.insetBackgroundDrawable != null) {
            this.insetBackgroundDrawable = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            updateBackgroundDrawable();
        }
    }

    private void setCloseIconHovered(boolean z) {
        if (this.closeIconHovered != z) {
            this.closeIconHovered = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.closeIconPressed != z) {
            this.closeIconPressed = z;
            refreshDrawableState();
        }
    }

    private void unapplyChipDrawable(c cVar) {
        if (cVar != null) {
            cVar.a((c.a) null);
        }
    }

    private void updateAccessibilityDelegate() {
        if (Build.VERSION.SDK_INT >= 24) {
            return;
        }
        if (hasCloseIcon() && isCloseIconVisible()) {
            ViewCompat.a(this, this.touchHelper);
        } else {
            ViewCompat.a(this, (C0313a) null);
        }
    }

    private void updateBackgroundDrawable() {
        if (com.google.android.material.j.c.f13496a) {
            updateFrameworkRippleBackground();
            return;
        }
        this.chipDrawable.f(true);
        ViewCompat.a(this, getBackgroundDrawable());
        ensureChipDrawableHasCallback();
    }

    private void updateFrameworkRippleBackground() {
        this.ripple = new RippleDrawable(com.google.android.material.j.c.b(this.chipDrawable.R()), getBackgroundDrawable(), null);
        this.chipDrawable.f(false);
        ViewCompat.a(this, this.ripple);
    }

    private void updatePaddingInternal() {
        c cVar;
        if (TextUtils.isEmpty(getText()) || (cVar = this.chipDrawable) == null) {
            return;
        }
        ViewCompat.b(this, (int) (this.chipDrawable.D() + this.chipDrawable.W() + this.chipDrawable.t()), getPaddingTop(), (int) (cVar.y() + this.chipDrawable.V() + this.chipDrawable.u()), getPaddingBottom());
    }

    private void updateTextPaintDrawState() {
        TextPaint paint = getPaint();
        c cVar = this.chipDrawable;
        if (cVar != null) {
            paint.drawableState = cVar.getState();
        }
        f textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.b(getContext(), paint, this.fontCallback);
        }
    }

    private void validateAttributes(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "background") != null) {
            Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue(NAMESPACE_ANDROID, "singleLine", true) || attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "lines", 1) != 1 || attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "minLines", 1) != 1 || attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "gravity", 8388627) != 8388627) {
            Log.w(TAG, "Chip text must be vertically center and start aligned");
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return handleAccessibilityExit(motionEvent) || this.touchHelper.a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.touchHelper.a(keyEvent) || this.touchHelper.c() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        c cVar = this.chipDrawable;
        if ((cVar == null || !cVar.ba()) ? false : this.chipDrawable.a(createCloseIconDrawableState())) {
            invalidate();
        }
    }

    public boolean ensureAccessibleTouchTarget(int i) {
        this.minTouchTargetSize = i;
        if (!shouldEnsureMinTouchTargetSize()) {
            removeBackgroundInset();
            return false;
        }
        int iMax = Math.max(0, i - this.chipDrawable.getIntrinsicHeight());
        int iMax2 = Math.max(0, i - this.chipDrawable.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            removeBackgroundInset();
            return false;
        }
        int i2 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i3 = iMax > 0 ? iMax / 2 : 0;
        if (this.insetBackgroundDrawable != null) {
            Rect rect = new Rect();
            this.insetBackgroundDrawable.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                return true;
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (getMinHeight() != i) {
                setMinHeight(i);
            }
            if (getMinWidth() != i) {
                setMinWidth(i);
            }
        } else {
            setMinHeight(i);
            setMinWidth(i);
        }
        insetChipBackgroundDrawable(i2, i3, i2, i3);
        return true;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.insetBackgroundDrawable;
        return insetDrawable == null ? this.chipDrawable : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.v();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.w();
        }
        return null;
    }

    public float getChipCornerRadius() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.x() : WheelView.DividerConfig.FILL;
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.y() : WheelView.DividerConfig.FILL;
    }

    public Drawable getChipIcon() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.z();
        }
        return null;
    }

    public float getChipIconSize() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.A() : WheelView.DividerConfig.FILL;
    }

    public ColorStateList getChipIconTint() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.B();
        }
        return null;
    }

    public float getChipMinHeight() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.C() : WheelView.DividerConfig.FILL;
    }

    public float getChipStartPadding() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.D() : WheelView.DividerConfig.FILL;
    }

    public ColorStateList getChipStrokeColor() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.E();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.F() : WheelView.DividerConfig.FILL;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.G();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.H();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.I() : WheelView.DividerConfig.FILL;
    }

    public float getCloseIconSize() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.J() : WheelView.DividerConfig.FILL;
    }

    public float getCloseIconStartPadding() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.K() : WheelView.DividerConfig.FILL;
    }

    public ColorStateList getCloseIconTint() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.M();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.N();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.touchHelper.c() == 1 || this.touchHelper.b() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public com.google.android.material.a.h getHideMotionSpec() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.O();
        }
        return null;
    }

    public float getIconEndPadding() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.P() : WheelView.DividerConfig.FILL;
    }

    public float getIconStartPadding() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.Q() : WheelView.DividerConfig.FILL;
    }

    public ColorStateList getRippleColor() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.R();
        }
        return null;
    }

    public n getShapeAppearanceModel() {
        return this.chipDrawable.l();
    }

    public com.google.android.material.a.h getShowMotionSpec() {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            return cVar.S();
        }
        return null;
    }

    public float getTextEndPadding() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.V() : WheelView.DividerConfig.FILL;
    }

    public float getTextStartPadding() {
        c cVar = this.chipDrawable;
        return cVar != null ? cVar.W() : WheelView.DividerConfig.FILL;
    }

    public boolean isCheckable() {
        c cVar = this.chipDrawable;
        return cVar != null && cVar.Y();
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        c cVar = this.chipDrawable;
        return cVar != null && cVar.Z();
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        c cVar = this.chipDrawable;
        return cVar != null && cVar.aa();
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconVisible() {
        c cVar = this.chipDrawable;
        return cVar != null && cVar.ca();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.a(this, this.chipDrawable);
    }

    @Override // com.google.android.material.chip.c.a
    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        updateBackgroundDrawable();
        updatePaddingInternal();
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, SELECTED_STATE);
        }
        if (isCheckable()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        this.touchHelper.a(z, i, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (isCheckable() || isClickable()) {
            accessibilityNodeInfo.setClassName(isCheckable() ? COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME : BUTTON_ACCESSIBILITY_CLASS_NAME);
        } else {
            accessibilityNodeInfo.setClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
        }
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.lastLayoutDirection != i) {
            this.lastLayoutDirection = i;
            updatePaddingInternal();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L39
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.closeIconPressed
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r2)
            goto L3e
        L2b:
            boolean r0 = r5.closeIconPressed
            if (r0 == 0) goto L34
            r5.performCloseIconClick()
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            r5.setCloseIconPressed(r2)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r3)
        L3e:
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L49
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
        L49:
            r2 = 1
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean performCloseIconClick() {
        boolean z = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.onCloseIconClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        }
        this.touchHelper.a(1, 1);
        return z;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.ripple) {
            super.setBackground(drawable);
        } else {
            Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w(TAG, "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.ripple) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w(TAG, "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i) {
        Log.w(TAG, "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w(TAG, "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w(TAG, "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.a(z);
        }
    }

    public void setCheckableResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.d(i);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        c cVar = this.chipDrawable;
        if (cVar == null) {
            this.deferredCheckedValue = z;
            return;
        }
        if (cVar.Y()) {
            boolean zIsChecked = isChecked();
            super.setChecked(z);
            if (zIsChecked == z || (onCheckedChangeListener = this.onCheckedChangeListenerInternal) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.a(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.e(i);
        }
    }

    public void setCheckedIconVisible(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.f(i);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.c(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.g(i);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.f(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.h(i);
        }
    }

    public void setChipDrawable(c cVar) {
        c cVar2 = this.chipDrawable;
        if (cVar2 != cVar) {
            unapplyChipDrawable(cVar2);
            this.chipDrawable = cVar;
            this.chipDrawable.e(false);
            applyChipDrawable(this.chipDrawable);
            ensureAccessibleTouchTarget(this.minTouchTargetSize);
            updateBackgroundDrawable();
        }
    }

    public void setChipEndPadding(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.g(f2);
        }
    }

    public void setChipEndPaddingResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.i(i);
        }
    }

    public void setChipIcon(Drawable drawable) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.b(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.j(i);
        }
    }

    public void setChipIconSize(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.h(f2);
        }
    }

    public void setChipIconSizeResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.k(i);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.d(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.l(i);
        }
    }

    public void setChipIconVisible(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.m(i);
        }
    }

    public void setChipMinHeight(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.i(f2);
        }
    }

    public void setChipMinHeightResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.n(i);
        }
    }

    public void setChipStartPadding(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.j(f2);
        }
    }

    public void setChipStartPaddingResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.o(i);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.e(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.p(i);
        }
    }

    public void setChipStrokeWidth(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.k(f2);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.q(i);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.c(drawable);
        }
        updateAccessibilityDelegate();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.a(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.l(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.r(i);
        }
    }

    public void setCloseIconResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.s(i);
        }
        updateAccessibilityDelegate();
    }

    public void setCloseIconSize(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.m(f2);
        }
    }

    public void setCloseIconSizeResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.t(i);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.n(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.u(i);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.f(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.v(i);
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.b(f2);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.chipDrawable == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.a(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.ensureMinTouchTargetSize = z;
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w(TAG, "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(com.google.android.material.a.h hVar) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.a(hVar);
        }
    }

    public void setHideMotionSpecResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.w(i);
        }
    }

    public void setIconEndPadding(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.o(f2);
        }
    }

    public void setIconEndPaddingResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.x(i);
        }
    }

    public void setIconStartPadding(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.p(f2);
        }
    }

    public void setIconStartPaddingResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.y(i);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.chipDrawable != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.z(i);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListenerInternal = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.onCloseIconClickListener = onClickListener;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.g(colorStateList);
        }
        if (this.chipDrawable.X()) {
            return;
        }
        updateFrameworkRippleBackground();
    }

    public void setRippleColorResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.A(i);
            if (this.chipDrawable.X()) {
                return;
            }
            updateFrameworkRippleBackground();
        }
    }

    @Override // com.google.android.material.l.r
    public void setShapeAppearanceModel(n nVar) {
        this.chipDrawable.setShapeAppearanceModel(nVar);
    }

    public void setShowMotionSpec(com.google.android.material.a.h hVar) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.b(hVar);
        }
    }

    public void setShowMotionSpecResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.B(i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.chipDrawable == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(this.chipDrawable.ea() ? null : charSequence, bufferType);
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.b(charSequence);
        }
    }

    public void setTextAppearance(f fVar) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.a(fVar);
        }
        updateTextPaintDrawState();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.q(f2);
        }
    }

    public void setTextEndPaddingResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.D(i);
        }
    }

    public void setTextStartPadding(float f2) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.r(f2);
        }
    }

    public void setTextStartPaddingResource(int i) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.E(i);
        }
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.d(z);
        }
        updateAccessibilityDelegate();
    }

    public Chip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rect = new Rect();
        this.rectF = new RectF();
        this.fontCallback = new com.google.android.material.chip.a(this);
        validateAttributes(attributeSet);
        c cVarA = c.a(context, attributeSet, i, com.google.android.material.R.style.Widget_MaterialComponents_Chip_Action);
        initMinTouchTarget(context, attributeSet, i);
        setChipDrawable(cVarA);
        cVarA.b(ViewCompat.i(this));
        TypedArray typedArrayA = s.a(context, attributeSet, com.google.android.material.R.styleable.Chip, i, com.google.android.material.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(com.google.android.material.i.c.a(context, typedArrayA, com.google.android.material.R.styleable.Chip_android_textColor));
        }
        boolean zHasValue = typedArrayA.hasValue(com.google.android.material.R.styleable.Chip_shapeAppearance);
        typedArrayA.recycle();
        this.touchHelper = new a(this);
        if (Build.VERSION.SDK_INT >= 24) {
            ViewCompat.a(this, this.touchHelper);
        } else {
            updateAccessibilityDelegate();
        }
        if (!zHasValue) {
            initOutlineProvider();
        }
        setChecked(this.deferredCheckedValue);
        setText(cVarA.T());
        setEllipsize(cVarA.N());
        setIncludeFontPadding(false);
        updateTextPaintDrawState();
        if (!this.chipDrawable.ea()) {
            setSingleLine();
        }
        setGravity(8388627);
        updatePaddingInternal();
        if (shouldEnsureMinTouchTargetSize()) {
            setMinHeight(this.minTouchTargetSize);
        }
        this.lastLayoutDirection = ViewCompat.m(this);
    }

    public void setCheckedIconVisible(boolean z) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.b(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.c(z);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.C(i);
        }
        updateTextPaintDrawState();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        c cVar = this.chipDrawable;
        if (cVar != null) {
            cVar.C(i);
        }
        updateTextPaintDrawState();
    }
}
