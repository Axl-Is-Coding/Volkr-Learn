package me.iwf.photopicker;

import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: PhotoPagerActivity.java */
/* JADX INFO: loaded from: classes5.dex */
class c extends ViewPager.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PhotoPagerActivity f22921a;

    c(PhotoPagerActivity photoPagerActivity) {
        this.f22921a = photoPagerActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageScrolled(int i, float f2, int i2) {
        this.f22921a.g();
    }
}
