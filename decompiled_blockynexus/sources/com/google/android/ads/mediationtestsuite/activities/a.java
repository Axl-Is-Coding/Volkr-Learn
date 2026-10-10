package com.google.android.ads.mediationtestsuite.activities;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.google.android.ads.mediationtestsuite.R;

/* JADX INFO: compiled from: AdUnitDetailActivity.java */
/* JADX INFO: loaded from: classes.dex */
class a implements Toolbar.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdUnitDetailActivity f12637a;

    a(AdUnitDetailActivity adUnitDetailActivity) {
        this.f12637a = adUnitDetailActivity;
    }

    @Override // androidx.appcompat.widget.Toolbar.a
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.gmts_load_ads) {
            return true;
        }
        this.f12637a.h();
        return true;
    }
}
