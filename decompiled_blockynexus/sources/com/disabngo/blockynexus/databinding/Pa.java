package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: DialogActivitySignUpBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Pa extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataRecyclerView f7759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f7760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.a.k f7761c;

    protected Pa(Object obj, View view, int i, DataRecyclerView dataRecyclerView, ImageView imageView) {
        super(obj, view, i);
        this.f7759a = dataRecyclerView;
        this.f7760b = imageView;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.a.k kVar);
}
