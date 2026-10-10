package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: DialogTribeGetContributionBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Jc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f7577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f7578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.Sa f7579d;

    protected Jc(Object obj, View view, int i, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView) {
        super(obj, view, i);
        this.f7576a = relativeLayout;
        this.f7577b = relativeLayout2;
        this.f7578c = textView;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.Sa sa);
}
