package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentFriendBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ud extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataRecyclerView f7930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f7931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f7932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f7933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.x.M f7934e;

    protected Ud(Object obj, View view, int i, DataRecyclerView dataRecyclerView, ImageView imageView, RelativeLayout relativeLayout, TextView textView) {
        super(obj, view, i);
        this.f7930a = dataRecyclerView;
        this.f7931b = imageView;
        this.f7932c = relativeLayout;
        this.f7933d = textView;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.x.M m);
}
