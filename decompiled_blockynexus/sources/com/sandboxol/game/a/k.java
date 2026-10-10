package com.sandboxol.game.a;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: DialogRechargeStarCodeViewBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f17690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f17691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Guideline f17692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f17693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f17694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f17695f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    protected com.sandboxol.recharge.dialog.rechargeshop.k j;

    protected k(Object obj, View view, int i, Button button, EditText editText, Guideline guideline, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f17690a = button;
        this.f17691b = editText;
        this.f17692c = guideline;
        this.f17693d = imageView;
        this.f17694e = imageView2;
        this.f17695f = imageView3;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
    }

    public abstract void a(com.sandboxol.recharge.dialog.rechargeshop.k kVar);
}
