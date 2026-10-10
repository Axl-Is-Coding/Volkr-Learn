package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityContentTempWeekendBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0540c extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f8212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f8213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.activity.m f8214c;

    protected AbstractC0540c(Object obj, View view, int i, ImageView imageView, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f8212a = imageView;
        this.f8213b = relativeLayout;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.activity.m mVar);
}
