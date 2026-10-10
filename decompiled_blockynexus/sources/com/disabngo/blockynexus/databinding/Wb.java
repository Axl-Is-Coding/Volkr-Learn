package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: DialogPartyChooseGameBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Wb extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f7989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataRecyclerView f7990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f7991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f7992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.c.a f7993e;

    protected Wb(Object obj, View view, int i, ConstraintLayout constraintLayout, DataRecyclerView dataRecyclerView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7989a = constraintLayout;
        this.f7990b = dataRecyclerView;
        this.f7991c = textView;
        this.f7992d = textView2;
    }
}
