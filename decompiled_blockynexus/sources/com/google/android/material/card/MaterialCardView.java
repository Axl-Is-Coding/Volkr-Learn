package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.google.android.material.internal.s;
import com.google.android.material.l.j;
import com.google.android.material.l.n;
import com.google.android.material.l.r;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialCardView extends CardView implements Checkable, r {
    private static final String LOG_TAG = "MaterialCardView";
    private final b cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private a onCheckedChangeListener;
    private static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DRAGGED_STATE_SET = {com.google.android.material.R.attr.state_dragged};
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_CardView;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z);
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    private void forceRippleRedrawIfNeeded() {
        if (Build.VERSION.SDK_INT > 26) {
            this.cardViewHelper.a();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.c();
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.cardViewHelper.d();
    }

    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.e();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.cardViewHelper.m().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.cardViewHelper.m().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.cardViewHelper.m().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.cardViewHelper.m().top;
    }

    public float getProgress() {
        return this.cardViewHelper.g();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.cardViewHelper.f();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.h();
    }

    public n getShapeAppearanceModel() {
        return this.cardViewHelper.i();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.cardViewHelper.j();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.k();
    }

    public int getStrokeWidth() {
        return this.cardViewHelper.l();
    }

    public boolean isCheckable() {
        b bVar = this.cardViewHelper;
        return bVar != null && bVar.o();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isDragged() {
        return this.dragged;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.a(this, this.cardViewHelper.b());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (isCheckable()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        if (isDragged()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, DRAGGED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(CardView.class.getName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CardView.class.getName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.cardViewHelper.a(getMeasuredWidth(), getMeasuredHeight());
    }

    void setAncestorContentPadding(int i, int i2, int i3, int i4) {
        super.setContentPadding(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.isParentCardViewDoneInitializing) {
            if (!this.cardViewHelper.n()) {
                Log.i(LOG_TAG, "Setting a custom background is not supported.");
                this.cardViewHelper.a(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i) {
        this.cardViewHelper.a(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        this.cardViewHelper.r();
    }

    public void setCheckable(boolean z) {
        this.cardViewHelper.b(z);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.checked != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.cardViewHelper.a(drawable);
    }

    public void setCheckedIconResource(int i) {
        this.cardViewHelper.a(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.cardViewHelper.b(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        this.cardViewHelper.p();
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.cardViewHelper.a(i, i2, i3, i4);
    }

    public void setDragged(boolean z) {
        if (this.dragged != z) {
            this.dragged = z;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.cardViewHelper.s();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.onCheckedChangeListener = aVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.cardViewHelper.s();
        this.cardViewHelper.q();
    }

    public void setProgress(float f2) {
        this.cardViewHelper.b(f2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f2) {
        super.setRadius(f2);
        this.cardViewHelper.a(f2);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.cardViewHelper.c(colorStateList);
    }

    public void setRippleColorResource(int i) {
        this.cardViewHelper.c(androidx.appcompat.a.a.a.a(getContext(), i));
    }

    @Override // com.google.android.material.l.r
    public void setShapeAppearanceModel(n nVar) {
        this.cardViewHelper.a(nVar);
    }

    public void setStrokeColor(int i) {
        this.cardViewHelper.d(ColorStateList.valueOf(i));
    }

    public void setStrokeWidth(int i) {
        this.cardViewHelper.a(i);
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.cardViewHelper.s();
        this.cardViewHelper.q();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.checked = !this.checked;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            a aVar = this.onCheckedChangeListener;
            if (aVar != null) {
                aVar.a(this, this.checked);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.cardViewHelper.a(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.cardViewHelper.d(colorStateList);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        super(s.a(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray typedArrayA = s.a(getContext(), attributeSet, com.google.android.material.R.styleable.MaterialCardView, i, DEF_STYLE_RES, new int[0]);
        this.cardViewHelper = new b(this, attributeSet, i, DEF_STYLE_RES);
        this.cardViewHelper.a(super.getCardBackgroundColor());
        this.cardViewHelper.a(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        this.cardViewHelper.a(typedArrayA);
        typedArrayA.recycle();
    }
}
