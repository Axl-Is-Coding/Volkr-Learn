package com.google.android.ads.mediationtestsuite.activities;

import androidx.viewpager.widget.ViewPager;
import com.google.android.ads.mediationtestsuite.utils.logging.AdUnitsViewEvent;

/* JADX INFO: compiled from: HomeActivity.java */
/* JADX INFO: loaded from: classes.dex */
class j implements ViewPager.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ HomeActivity f12647a;

    j(HomeActivity homeActivity) {
        this.f12647a = homeActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageSelected(int i) {
        com.google.android.ads.mediationtestsuite.utils.logging.e.a(new AdUnitsViewEvent(com.google.android.ads.mediationtestsuite.adapters.a.a(i)), this.f12647a);
    }
}
