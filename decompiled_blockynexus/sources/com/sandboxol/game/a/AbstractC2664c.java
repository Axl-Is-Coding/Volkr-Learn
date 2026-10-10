package com.sandboxol.game.a;

import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blockmango.webvideo.WebVideoViewModel;

/* JADX INFO: renamed from: com.sandboxol.game.a.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityWebVideoBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2664c extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f17666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected WebVideoViewModel f17667b;

    protected AbstractC2664c(Object obj, View view, int i, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f17666a = linearLayout;
    }

    public abstract void a(WebVideoViewModel webVideoViewModel);
}
