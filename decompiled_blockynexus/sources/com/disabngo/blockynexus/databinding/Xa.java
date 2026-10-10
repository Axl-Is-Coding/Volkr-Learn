package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.DialogC1122va;

/* JADX INFO: compiled from: DialogAppEnterGameBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Xa extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f8019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f8020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f8021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f8022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected DialogC1122va.b f8023e;

    protected Xa(Object obj, View view, int i, Button button, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.f8019a = button;
        this.f8020b = imageView;
        this.f8021c = linearLayout;
        this.f8022d = textView;
    }

    public abstract void a(DialogC1122va.b bVar);
}
