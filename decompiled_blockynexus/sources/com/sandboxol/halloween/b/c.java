package com.sandboxol.halloween.b;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: HalloweenDialogRewardBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f18589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f18590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataRecyclerView f18591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.sandboxol.halloween.view.dialog.a.b f18592d;

    protected c(Object obj, View view, int i, View view2, ImageView imageView, DataRecyclerView dataRecyclerView) {
        super(obj, view, i);
        this.f18589a = view2;
        this.f18590b = imageView;
        this.f18591c = dataRecyclerView;
    }

    public abstract void a(com.sandboxol.halloween.view.dialog.a.b bVar);
}
