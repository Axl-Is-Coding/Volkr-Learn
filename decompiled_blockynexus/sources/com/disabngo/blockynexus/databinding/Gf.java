package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentTribeCreateBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Gf extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f7494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f7495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.la.n f7496c;

    protected Gf(Object obj, View view, int i, EditText editText, ImageView imageView) {
        super(obj, view, i);
        this.f7494a = editText;
        this.f7495b = imageView;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.la.n nVar);
}
