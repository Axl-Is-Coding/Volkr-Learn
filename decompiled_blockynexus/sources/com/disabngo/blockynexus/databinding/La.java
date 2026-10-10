package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: DialogActivityBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class La extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f7634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f7635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f7636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataRecyclerView f7637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.activity.A f7638e;

    protected La(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout, DataRecyclerView dataRecyclerView) {
        super(obj, view, i);
        this.f7634a = imageView;
        this.f7635b = linearLayout;
        this.f7636c = relativeLayout;
        this.f7637d = dataRecyclerView;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.activity.A a2);
}
