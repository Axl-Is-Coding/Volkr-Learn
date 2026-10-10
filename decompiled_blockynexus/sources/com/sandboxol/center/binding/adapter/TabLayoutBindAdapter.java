package com.sandboxol.center.binding.adapter;

import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayoutBindAdapter {
    public static void setTabLayout(TabLayout tabLayout, int i, int i2, int i3) {
        if (tabLayout != null) {
            tabLayout.setSelectedTabIndicatorColor(i);
            tabLayout.setTabTextColors(i3, i2);
        }
    }
}
