package com.sandboxol.decorate.a;

import com.sandboxol.decorate.widget.DressLoadingView;

/* JADX INFO: compiled from: DressLoadingBindAdapters.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static void a(DressLoadingView dressLoadingView, boolean z) {
        if (z) {
            dressLoadingView.setVisibility(0);
            dressLoadingView.startAnimate();
        } else {
            dressLoadingView.setVisibility(8);
            dressLoadingView.stopAnimate();
        }
    }
}
