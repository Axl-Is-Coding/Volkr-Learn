package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.lc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogSafeSettingGuideBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0642lc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f8546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f8547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.Ea f8548c;

    protected AbstractC0642lc(Object obj, View view, int i, RelativeLayout relativeLayout, TextView textView) {
        super(obj, view, i);
        this.f8546a = relativeLayout;
        this.f8547b = textView;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.Ea ea);
}
