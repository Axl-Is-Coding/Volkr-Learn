package com.disabngo.blockynexus.binding.adapter;

import com.disabngo.blockynexus.view.widget.ItemView;

/* JADX INFO: compiled from: ItemViewBindAdapters.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    public static void a(ItemView itemView, String str) {
        itemView.setRightText(str);
    }

    public static void a(ItemView itemView, boolean z, boolean z2) {
        itemView.setRedPoint(z);
        itemView.setLeftRedPoint(z2);
    }

    public static void a(ItemView itemView, int i) {
        itemView.setTvRightTextResColor(i);
    }
}
