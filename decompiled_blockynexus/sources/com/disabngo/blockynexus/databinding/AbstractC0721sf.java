package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.ItemView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.sf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentSettingBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0721sf extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f8797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemView f8798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.ia.m f8799c;

    protected AbstractC0721sf(Object obj, View view, int i, LinearLayout linearLayout, ItemView itemView) {
        super(obj, view, i);
        this.f8797a = linearLayout;
        this.f8798b = itemView;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.ia.m mVar);
}
