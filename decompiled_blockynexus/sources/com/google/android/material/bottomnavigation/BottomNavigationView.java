package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.d.g;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ia;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.s;
import com.google.android.material.internal.v;
import com.google.android.material.l.i;
import com.google.android.material.l.j;

/* JADX INFO: loaded from: classes2.dex */
public class BottomNavigationView extends FrameLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomNavigationView;
    private static final int MENU_PRESENTER_ID = 1;
    private ColorStateList itemRippleColor;
    private final MenuBuilder menu;
    private MenuInflater menuInflater;
    final BottomNavigationMenuView menuView;
    private final BottomNavigationPresenter presenter;
    private a reselectedListener;
    private b selectedListener;

    public interface a {
        void a(MenuItem menuItem);
    }

    public interface b {
        boolean a(MenuItem menuItem);
    }

    static class c extends androidx.customview.a.c {
        public static final Parcelable.Creator<c> CREATOR = new f();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Bundle f13200c;

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f13200c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f13200c);
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader == null ? c.class.getClassLoader() : classLoader);
        }
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    private void addCompatibilityTopDivider(Context context) {
        View view = new View(context);
        view.setBackgroundColor(androidx.core.content.b.a(context, R.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private void applyWindowInsets() {
        v.a(this, new e(this));
    }

    private i createMaterialShapeDrawableBackground(Context context) {
        i iVar = new i();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            iVar.a(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        iVar.a(context);
        return iVar;
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new g(getContext());
        }
        return this.menuInflater;
    }

    public com.google.android.material.b.b getBadge(int i) {
        return this.menuView.getBadge(i);
    }

    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public com.google.android.material.b.b getOrCreateBadge(int i) {
        return this.menuView.getOrCreateBadge(i);
    }

    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void inflateMenu(int i) {
        this.presenter.b(true);
        getMenuInflater().inflate(i, this.menu);
        this.presenter.b(false);
        this.presenter.a(true);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.menuView.isItemHorizontalTranslationEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.a(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.a());
        this.menu.b(cVar.f13200c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f13200c = new Bundle();
        this.menu.d(cVar.f13200c);
        return cVar;
    }

    public void removeBadge(int i) {
        this.menuView.removeBadge(i);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        j.a(this, f2);
    }

    public void setItemBackground(Drawable drawable) {
        this.menuView.setItemBackground(drawable);
        this.itemRippleColor = null;
    }

    public void setItemBackgroundResource(int i) {
        this.menuView.setItemBackgroundRes(i);
        this.itemRippleColor = null;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.menuView.isItemHorizontalTranslationEnabled() != z) {
            this.menuView.setItemHorizontalTranslationEnabled(z);
            this.presenter.a(false);
        }
    }

    public void setItemIconSize(int i) {
        this.menuView.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.menuView.setIconTintList(colorStateList);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        if (this.itemRippleColor == colorStateList) {
            if (colorStateList != null || this.menuView.getItemBackground() == null) {
                return;
            }
            this.menuView.setItemBackground(null);
            return;
        }
        this.itemRippleColor = colorStateList;
        if (colorStateList == null) {
            this.menuView.setItemBackground(null);
            return;
        }
        ColorStateList colorStateListA = com.google.android.material.j.c.a(colorStateList);
        if (Build.VERSION.SDK_INT >= 21) {
            this.menuView.setItemBackground(new RippleDrawable(colorStateListA, null, null));
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(1.0E-5f);
        Drawable drawableI = androidx.core.graphics.drawable.a.i(gradientDrawable);
        androidx.core.graphics.drawable.a.a(drawableI, colorStateListA);
        this.menuView.setItemBackground(drawableI);
    }

    public void setItemTextAppearanceActive(int i) {
        this.menuView.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceInactive(int i) {
        this.menuView.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.menuView.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i) {
        if (this.menuView.getLabelVisibilityMode() != i) {
            this.menuView.setLabelVisibilityMode(i);
            this.presenter.a(false);
        }
    }

    public void setOnNavigationItemReselectedListener(a aVar) {
        this.reselectedListener = aVar;
    }

    public void setOnNavigationItemSelectedListener(b bVar) {
        this.selectedListener = bVar;
    }

    public void setSelectedItemId(int i) {
        MenuItem menuItemFindItem = this.menu.findItem(i);
        if (menuItemFindItem == null || this.menu.a(menuItemFindItem, this.presenter, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(s.a(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.presenter = new BottomNavigationPresenter();
        Context context2 = getContext();
        this.menu = new com.google.android.material.bottomnavigation.b(context2);
        this.menuView = new BottomNavigationMenuView(context2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.menuView.setLayoutParams(layoutParams);
        this.presenter.a(this.menuView);
        this.presenter.a(1);
        this.menuView.setPresenter(this.presenter);
        this.menu.a(this.presenter);
        this.presenter.a(getContext(), this.menu);
        ia iaVarB = s.b(context2, attributeSet, R.styleable.BottomNavigationView, i, R.style.Widget_Design_BottomNavigationView, R.styleable.BottomNavigationView_itemTextAppearanceInactive, R.styleable.BottomNavigationView_itemTextAppearanceActive);
        if (iaVarB.g(R.styleable.BottomNavigationView_itemIconTint)) {
            this.menuView.setIconTintList(iaVarB.a(R.styleable.BottomNavigationView_itemIconTint));
        } else {
            BottomNavigationMenuView bottomNavigationMenuView = this.menuView;
            bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.createDefaultColorStateList(android.R.attr.textColorSecondary));
        }
        setItemIconSize(iaVarB.c(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
        if (iaVarB.g(R.styleable.BottomNavigationView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(iaVarB.g(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (iaVarB.g(R.styleable.BottomNavigationView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(iaVarB.g(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (iaVarB.g(R.styleable.BottomNavigationView_itemTextColor)) {
            setItemTextColor(iaVarB.a(R.styleable.BottomNavigationView_itemTextColor));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            ViewCompat.a(this, createMaterialShapeDrawableBackground(context2));
        }
        if (iaVarB.g(R.styleable.BottomNavigationView_elevation)) {
            ViewCompat.a(this, iaVarB.c(R.styleable.BottomNavigationView_elevation, 0));
        }
        androidx.core.graphics.drawable.a.a(getBackground().mutate(), com.google.android.material.i.c.a(context2, iaVarB, R.styleable.BottomNavigationView_backgroundTint));
        setLabelVisibilityMode(iaVarB.e(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(iaVarB.a(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int iG = iaVarB.g(R.styleable.BottomNavigationView_itemBackground, 0);
        if (iG != 0) {
            this.menuView.setItemBackgroundRes(iG);
        } else {
            setItemRippleColor(com.google.android.material.i.c.a(context2, iaVarB, R.styleable.BottomNavigationView_itemRippleColor));
        }
        if (iaVarB.g(R.styleable.BottomNavigationView_menu)) {
            inflateMenu(iaVarB.g(R.styleable.BottomNavigationView_menu, 0));
        }
        iaVarB.a();
        addView(this.menuView, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            addCompatibilityTopDivider(context2);
        }
        this.menu.setCallback(new d(this));
        applyWindowInsets();
    }
}
