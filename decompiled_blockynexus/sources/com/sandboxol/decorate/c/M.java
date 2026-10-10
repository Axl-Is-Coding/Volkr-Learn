package com.sandboxol.decorate.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.decorate.view.fragment.dress.DressSuitExtraItemViewModel;

/* JADX INFO: compiled from: ItemDressShopSpecialBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class M extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f17021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Group f17022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f17023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f17024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f17025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f17026f;
    public final TextView g;
    protected DressSuitExtraItemViewModel h;

    protected M(Object obj, View view, int i, View view2, Group group, ImageView imageView, View view3, View view4, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f17021a = view2;
        this.f17022b = group;
        this.f17023c = imageView;
        this.f17024d = view3;
        this.f17025e = view4;
        this.f17026f = textView;
        this.g = textView2;
    }
}
