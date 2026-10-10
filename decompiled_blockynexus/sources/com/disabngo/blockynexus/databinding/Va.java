package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.DialogC1111pa;

/* JADX INFO: compiled from: DialogAdsRewardBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Va extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f7951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f7952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f7953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RelativeLayout f7954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f7955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f7956f;
    public final View g;
    protected DialogC1111pa h;

    protected Va(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, ImageView imageView2, RelativeLayout relativeLayout, TextView textView, View view2, View view3) {
        super(obj, view, i);
        this.f7951a = imageView;
        this.f7952b = constraintLayout;
        this.f7953c = imageView2;
        this.f7954d = relativeLayout;
        this.f7955e = textView;
        this.f7956f = view2;
        this.g = view3;
    }

    public abstract void a(DialogC1111pa dialogC1111pa);
}
