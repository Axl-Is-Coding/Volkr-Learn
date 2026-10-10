package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: DialogTribeSettingGuideBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Nc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f7706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.Ta f7707b;

    protected Nc(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f7706a = textView;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.Ta ta);
}
