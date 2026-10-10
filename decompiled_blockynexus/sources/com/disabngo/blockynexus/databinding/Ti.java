package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemScrapRequestBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ti extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CardView f7914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f7915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.g.g f7916d;

    protected Ti(Object obj, View view, int i, View view2, CardView cardView, TextView textView) {
        super(obj, view, i);
        this.f7913a = view2;
        this.f7914b = cardView;
        this.f7915c = textView;
    }
}
