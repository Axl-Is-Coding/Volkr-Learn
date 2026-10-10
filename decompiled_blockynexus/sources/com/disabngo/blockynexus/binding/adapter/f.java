package com.disabngo.blockynexus.binding.adapter;

import android.widget.ProgressBar;

/* JADX INFO: compiled from: BMProgressBarBindingAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static void a(ProgressBar progressBar, int i, int i2) {
        if (progressBar != null) {
            progressBar.setMax(i2);
            progressBar.setProgress(i);
        }
    }
}
