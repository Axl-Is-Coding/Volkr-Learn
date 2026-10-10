package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.af, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentReportDetailBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0522af extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f8167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f8168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f8169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f8170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.aa.i f8171e;

    protected AbstractC0522af(Object obj, View view, int i, EditText editText, RecyclerView recyclerView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f8167a = editText;
        this.f8168b = recyclerView;
        this.f8169c = textView;
        this.f8170d = textView2;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.aa.i iVar);
}
