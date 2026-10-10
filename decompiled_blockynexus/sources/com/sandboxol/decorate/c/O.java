package com.sandboxol.decorate.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.decorate.view.fragment.dress.DressExtraItemViewModel;

/* JADX INFO: compiled from: ItemDressSpecialBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class O extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f17027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Group f17028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Group f17029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f17030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f17031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f17032f;
    public final View g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    protected DressExtraItemViewModel k;

    protected O(Object obj, View view, int i, View view2, Group group, Group group2, ImageView imageView, ImageView imageView2, View view3, View view4, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f17027a = view2;
        this.f17028b = group;
        this.f17029c = group2;
        this.f17030d = imageView;
        this.f17031e = imageView2;
        this.f17032f = view3;
        this.g = view4;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
    }
}
