package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.na, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentHeaderBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0662na extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Toolbar f8610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.activity.main.nc f8611b;

    protected AbstractC0662na(Object obj, View view, int i, Toolbar toolbar) {
        super(obj, view, i);
        this.f8610a = toolbar;
    }

    public abstract void a(com.disabngo.blockynexus.view.activity.main.nc ncVar);
}
