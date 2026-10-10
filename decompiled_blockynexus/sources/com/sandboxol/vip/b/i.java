package com.sandboxol.vip.b;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: VipDialogSubscribeRulesBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class i extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f18990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f18991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f18992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f18993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f18994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.sandboxol.vip.d.a.e f18995f;

    protected i(Object obj, View view, int i, Button button, TextView textView, TextView textView2, View view2, View view3) {
        super(obj, view, i);
        this.f18990a = button;
        this.f18991b = textView;
        this.f18992c = textView2;
        this.f18993d = view2;
        this.f18994e = view3;
    }

    public abstract void a(com.sandboxol.vip.d.a.e eVar);
}
