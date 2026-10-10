package com.sandboxol.decorate.c;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogLeaveDressShopBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2595u extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f17118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f17119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f17120c;

    protected AbstractC2595u(Object obj, View view, int i, Button button, Button button2, TextView textView) {
        super(obj, view, i);
        this.f17118a = button;
        this.f17119b = button2;
        this.f17120c = textView;
    }
}
