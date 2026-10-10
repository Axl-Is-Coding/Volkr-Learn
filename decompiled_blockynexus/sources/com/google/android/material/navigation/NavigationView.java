package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.ia;
import androidx.core.view.J;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.g;
import com.google.android.material.internal.s;
import com.google.android.material.l.i;
import com.google.android.material.l.j;
import com.google.android.material.l.n;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    a listener;
    private final int maxWidth;
    private final g menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final int[] tmpLocation;

    public interface a {
        boolean a(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    private ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = androidx.appcompat.a.a.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(DISABLED_STATE_SET, defaultColor), i2, defaultColor});
    }

    private final Drawable createDefaultItemBackground(ia iaVar) {
        i iVar = new i(n.a(getContext(), iaVar.g(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0), iaVar.g(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).a());
        iVar.a(com.google.android.material.i.c.a(getContext(), iaVar, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) iVar, iaVar.c(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), iaVar.c(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), iaVar.c(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), iaVar.c(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new androidx.appcompat.d.g(getContext());
        }
        return this.menuInflater;
    }

    private boolean hasShapeAppearance(ia iaVar) {
        return iaVar.g(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) || iaVar.g(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new com.google.android.material.navigation.b(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void addHeaderView(View view) {
        this.presenter.a(view);
    }

    public MenuItem getCheckedItem() {
        return this.presenter.c();
    }

    public int getHeaderCount() {
        return this.presenter.d();
    }

    public View getHeaderView(int i) {
        return this.presenter.a(i);
    }

    public Drawable getItemBackground() {
        return this.presenter.e();
    }

    public int getItemHorizontalPadding() {
        return this.presenter.f();
    }

    public int getItemIconPadding() {
        return this.presenter.g();
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.j();
    }

    public int getItemMaxLines() {
        return this.presenter.h();
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.i();
    }

    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(int i) {
        return this.presenter.b(i);
    }

    public void inflateMenu(int i) {
        this.presenter.c(true);
        getMenuInflater().inflate(i, this.menu);
        this.presenter.c(false);
        this.presenter.a(false);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.a(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    protected void onInsetsChanged(J j) {
        this.presenter.a(j);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.maxWidth), FileTypeUtils.GIGABYTE);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, FileTypeUtils.GIGABYTE);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.a());
        this.menu.b(bVar.f13575c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f13575c = new Bundle();
        this.menu.d(bVar.f13575c);
        return bVar;
    }

    public void removeHeaderView(View view) {
        this.presenter.b(view);
    }

    public void setCheckedItem(int i) {
        MenuItem menuItemFindItem = this.menu.findItem(i);
        if (menuItemFindItem != null) {
            this.presenter.a((MenuItemImpl) menuItemFindItem);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        j.a(this, f2);
    }

    public void setItemBackground(Drawable drawable) {
        this.presenter.a(drawable);
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(androidx.core.content.b.c(getContext(), i));
    }

    public void setItemHorizontalPadding(int i) {
        this.presenter.d(i);
    }

    public void setItemHorizontalPaddingResource(int i) {
        this.presenter.d(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconPadding(int i) {
        this.presenter.e(i);
    }

    public void setItemIconPaddingResource(int i) {
        this.presenter.e(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconSize(int i) {
        this.presenter.f(i);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.presenter.a(colorStateList);
    }

    public void setItemMaxLines(int i) {
        this.presenter.g(i);
    }

    public void setItemTextAppearance(int i) {
        this.presenter.h(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.presenter.b(colorStateList);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.listener = aVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.i(i);
        }
    }

    public static class b extends androidx.customview.a.c {
        public static final Parcelable.Creator<b> CREATOR = new c();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bundle f13575c;

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13575c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f13575c);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.navigationViewStyle);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateListCreateDefaultColorStateList;
        boolean z;
        int iG;
        super(context, attributeSet, i);
        this.presenter = new NavigationMenuPresenter();
        this.tmpLocation = new int[2];
        this.menu = new g(context);
        ia iaVarB = s.b(context, attributeSet, com.google.android.material.R.styleable.NavigationView, i, com.google.android.material.R.style.Widget_Design_NavigationView, new int[0]);
        if (iaVarB.g(com.google.android.material.R.styleable.NavigationView_android_background)) {
            ViewCompat.a(this, iaVarB.b(com.google.android.material.R.styleable.NavigationView_android_background));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            Drawable background = getBackground();
            i iVar = new i();
            if (background instanceof ColorDrawable) {
                iVar.a(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            iVar.a(context);
            ViewCompat.a(this, iVar);
        }
        if (iaVarB.g(com.google.android.material.R.styleable.NavigationView_elevation)) {
            setElevation(iaVarB.c(com.google.android.material.R.styleable.NavigationView_elevation, 0));
        }
        setFitsSystemWindows(iaVarB.a(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = iaVarB.c(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        if (iaVarB.g(com.google.android.material.R.styleable.NavigationView_itemIconTint)) {
            colorStateListCreateDefaultColorStateList = iaVarB.a(com.google.android.material.R.styleable.NavigationView_itemIconTint);
        } else {
            colorStateListCreateDefaultColorStateList = createDefaultColorStateList(R.attr.textColorSecondary);
        }
        if (iaVarB.g(com.google.android.material.R.styleable.NavigationView_itemTextAppearance)) {
            iG = iaVarB.g(com.google.android.material.R.styleable.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            z = false;
            iG = 0;
        }
        if (iaVarB.g(com.google.android.material.R.styleable.NavigationView_itemIconSize)) {
            setItemIconSize(iaVarB.c(com.google.android.material.R.styleable.NavigationView_itemIconSize, 0));
        }
        ColorStateList colorStateListA = iaVarB.g(com.google.android.material.R.styleable.NavigationView_itemTextColor) ? iaVarB.a(com.google.android.material.R.styleable.NavigationView_itemTextColor) : null;
        if (!z && colorStateListA == null) {
            colorStateListA = createDefaultColorStateList(R.attr.textColorPrimary);
        }
        Drawable drawableB = iaVarB.b(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (drawableB == null && hasShapeAppearance(iaVarB)) {
            drawableB = createDefaultItemBackground(iaVarB);
        }
        if (iaVarB.g(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding)) {
            this.presenter.d(iaVarB.c(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding, 0));
        }
        int iC = iaVarB.c(com.google.android.material.R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(iaVarB.d(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        this.menu.setCallback(new com.google.android.material.navigation.a(this));
        this.presenter.c(1);
        this.presenter.a(context, this.menu);
        this.presenter.a(colorStateListCreateDefaultColorStateList);
        this.presenter.i(getOverScrollMode());
        if (z) {
            this.presenter.h(iG);
        }
        this.presenter.b(colorStateListA);
        this.presenter.a(drawableB);
        this.presenter.e(iC);
        this.menu.a(this.presenter);
        addView((View) this.presenter.a((ViewGroup) this));
        if (iaVarB.g(com.google.android.material.R.styleable.NavigationView_menu)) {
            inflateMenu(iaVarB.g(com.google.android.material.R.styleable.NavigationView_menu, 0));
        }
        if (iaVarB.g(com.google.android.material.R.styleable.NavigationView_headerLayout)) {
            inflateHeaderView(iaVarB.g(com.google.android.material.R.styleable.NavigationView_headerLayout, 0));
        }
        iaVarB.a();
        setupInsetScrimsListener();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.menu.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.presenter.a((MenuItemImpl) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
