package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentDiskGameManageBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ed extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CheckBox f7424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f7425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f7426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.q.n f7427d;

    protected Ed(Object obj, View view, int i, CheckBox checkBox, ImageView imageView, View view2) {
        super(obj, view, i);
        this.f7424a = checkBox;
        this.f7425b = imageView;
        this.f7426c = view2;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.q.n nVar);
}
