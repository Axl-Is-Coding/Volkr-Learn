package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemRankDetailTitleBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Di extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f7400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f7401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.W.b f7402c;

    protected Di(Object obj, View view, int i, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f7400a = linearLayout;
    }

    public abstract void setType(String str);
}
