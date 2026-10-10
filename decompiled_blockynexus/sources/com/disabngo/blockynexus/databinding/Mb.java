package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: DialogMapFriendBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Mb extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f7666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f7667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f7668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f7669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f7670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f7671f;
    protected com.disabngo.blockynexus.view.dialog.Da g;

    protected Mb(Object obj, View view, int i, LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, ImageView imageView) {
        super(obj, view, i);
        this.f7666a = linearLayout;
        this.f7667b = relativeLayout;
        this.f7668c = relativeLayout2;
        this.f7669d = textView;
        this.f7670e = textView2;
        this.f7671f = imageView;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.Da da);
}
