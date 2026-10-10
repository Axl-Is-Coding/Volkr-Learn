package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: DialogPartyChooseMemberNumBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Yb extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f8051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataRecyclerView f8052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f8053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f8054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.d.a f8055e;

    protected Yb(Object obj, View view, int i, ConstraintLayout constraintLayout, DataRecyclerView dataRecyclerView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f8051a = constraintLayout;
        this.f8052b = dataRecyclerView;
        this.f8053c = textView;
        this.f8054d = textView2;
    }
}
