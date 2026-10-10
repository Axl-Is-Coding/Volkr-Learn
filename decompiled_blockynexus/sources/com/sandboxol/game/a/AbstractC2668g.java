package com.sandboxol.game.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.StrokeTextView;

/* JADX INFO: renamed from: com.sandboxol.game.a.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogRechargeDetailBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2668g extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f17678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f17679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StrokeTextView f17680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected b.h.c.a.a.c f17681d;

    protected AbstractC2668g(Object obj, View view, int i, LinearLayout linearLayout, RelativeLayout relativeLayout, StrokeTextView strokeTextView) {
        super(obj, view, i);
        this.f17678a = linearLayout;
        this.f17679b = relativeLayout;
        this.f17680c = strokeTextView;
    }

    public abstract void a(b.h.c.a.a.c cVar);
}
