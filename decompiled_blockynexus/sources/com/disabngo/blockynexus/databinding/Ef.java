package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentTribeContributionBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ef extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f7428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f7429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f7430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.ka.p f7431d;

    protected Ef(Object obj, View view, int i, ImageView imageView, ProgressBar progressBar, TextView textView) {
        super(obj, view, i);
        this.f7428a = imageView;
        this.f7429b = progressBar;
        this.f7430c = textView;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.ka.p pVar);
}
