package com.sandboxol.gamedetail.view.dialog.marioguide;

import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: MarioGuideDialog.java */
/* JADX INFO: loaded from: classes3.dex */
class f implements ViewPager.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MarioGuideDialog f18163a;

    f(MarioGuideDialog marioGuideDialog) {
        this.f18163a = marioGuideDialog;
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageSelected(int i) {
        this.f18163a.f18154e = i;
        this.f18163a.f18150a.f17856f.changeStatus(i);
    }
}
