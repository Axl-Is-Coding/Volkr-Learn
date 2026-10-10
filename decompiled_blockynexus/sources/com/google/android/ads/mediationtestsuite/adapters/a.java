package com.google.android.ads.mediationtestsuite.adapters;

import android.content.Context;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.D;
import androidx.fragment.app.Fragment;
import com.google.android.ads.mediationtestsuite.activities.AdUnitsFragment;
import com.google.android.ads.mediationtestsuite.utils.logging.AdUnitsViewEvent;

/* JADX INFO: compiled from: AdUnitTypesPagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends D {
    private final Context g;
    private final AdUnitsFragment[] h;

    public a(AbstractC0336n abstractC0336n, Context context) {
        super(abstractC0336n);
        this.h = new AdUnitsFragment[2];
        this.g = context;
        this.h[0] = AdUnitsFragment.a(AdUnitsFragment.Type.FAILING);
        this.h[1] = AdUnitsFragment.a(AdUnitsFragment.Type.WORKING);
    }

    public static AdUnitsViewEvent.ViewType a(int i) {
        return i == 0 ? AdUnitsViewEvent.ViewType.FAILING : AdUnitsViewEvent.ViewType.WORKING;
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.h.length;
    }

    @Override // androidx.fragment.app.D
    public Fragment getItem(int i) {
        return this.h[i];
    }

    @Override // androidx.viewpager.widget.a
    public CharSequence getPageTitle(int i) {
        return this.h[i].g().getTitle(this.g.getResources());
    }
}
