package com.sandboxol.gamedetail.a;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.sandboxol.gamedetail.view.dialog.ClickingHideView;
import com.sandboxol.gamedetail.view.dialog.marioguide.HandleLinearLayoutView;
import com.sandboxol.gamedetail.view.dialog.marioguide.HandlerView;
import com.sandboxol.gamedetail.view.dialog.marioguide.MarioGuideDialog;

/* JADX INFO: renamed from: com.sandboxol.gamedetail.a.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogMarioGuideBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2684m extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager f17851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClickingHideView f17852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f17853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HandlerView f17854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HandlerView f17855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HandleLinearLayoutView f17856f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    protected MarioGuideDialog j;

    protected AbstractC2684m(Object obj, View view, int i, ViewPager viewPager, ClickingHideView clickingHideView, View view2, HandlerView handlerView, HandlerView handlerView2, HandleLinearLayoutView handleLinearLayoutView, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        super(obj, view, i);
        this.f17851a = viewPager;
        this.f17852b = clickingHideView;
        this.f17853c = view2;
        this.f17854d = handlerView;
        this.f17855e = handlerView2;
        this.f17856f = handleLinearLayoutView;
        this.g = imageView;
        this.h = imageView2;
        this.i = imageView3;
    }

    public abstract void a(MarioGuideDialog marioGuideDialog);
}
