package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.DialogC1118ta;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.sb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogDownloadInfoBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0717sb extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f8783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f8784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f8785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f8786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f8787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f8788f;
    public final View g;
    public final View h;
    protected DialogC1118ta i;

    protected AbstractC0717sb(Object obj, View view, int i, TextView textView, ProgressBar progressBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, View view3) {
        super(obj, view, i);
        this.f8783a = textView;
        this.f8784b = progressBar;
        this.f8785c = textView2;
        this.f8786d = textView3;
        this.f8787e = textView4;
        this.f8788f = textView5;
        this.g = view2;
        this.h = view3;
    }

    public abstract void a(DialogC1118ta dialogC1118ta);
}
