package com.sandboxol.decorate.c;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogDressExpiredBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2592q extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f17106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataRecyclerView f17107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f17108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.sandboxol.decorate.view.dialog.b.c f17109d;

    protected AbstractC2592q(Object obj, View view, int i, Button button, DataRecyclerView dataRecyclerView, TextView textView) {
        super(obj, view, i);
        this.f17106a = button;
        this.f17107b = dataRecyclerView;
        this.f17108c = textView;
    }

    public abstract void a(com.sandboxol.decorate.view.dialog.b.c cVar);
}
