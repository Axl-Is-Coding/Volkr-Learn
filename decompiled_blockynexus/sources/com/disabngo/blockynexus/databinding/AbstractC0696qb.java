package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.DialogC1116sa;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.qb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogDiskGameCleanBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0696qb extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProgressBar f8716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f8717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f8718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected DialogC1116sa f8719d;

    protected AbstractC0696qb(Object obj, View view, int i, ProgressBar progressBar, TextView textView, View view2) {
        super(obj, view, i);
        this.f8716a = progressBar;
        this.f8717b = textView;
        this.f8718c = view2;
    }

    public abstract void a(DialogC1116sa dialogC1116sa);
}
