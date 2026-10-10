package com.sandboxol.decorate.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.decorate.view.activity.dress.DressExtraItemViewModel;

/* JADX INFO: compiled from: ItemDressShopClearHistoryBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class K extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f17015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Group f17016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f17017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f17018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected DressExtraItemViewModel f17019e;

    protected K(Object obj, View view, int i, View view2, Group group, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f17015a = view2;
        this.f17016b = group;
        this.f17017c = imageView;
        this.f17018d = textView;
    }
}
