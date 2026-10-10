package com.twitter.sdk.android.tweetui;

import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: GalleryActivity.java */
/* JADX INFO: loaded from: classes5.dex */
class p implements ViewPager.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f20448a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ GalleryActivity f20449b;

    p(GalleryActivity galleryActivity) {
        this.f20449b = galleryActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageScrolled(int i, float f2, int i2) {
        int i3 = this.f20448a;
        if (i3 == -1 && i == 0 && f2 == 0.0d) {
            this.f20448a = i3 + 1;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageSelected(int i) {
        this.f20448a++;
    }
}
