package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentPartyHallBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ne extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f7709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f7710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f7711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.fragment.partyhall.G f7712d;

    protected Ne(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, View view2) {
        super(obj, view, i);
        this.f7709a = linearLayout;
        this.f7710b = linearLayout2;
        this.f7711c = view2;
    }

    public abstract void a(com.disabngo.blockynexus.view.fragment.partyhall.G g);
}
