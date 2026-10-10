package com.disabngo.blockynexus.view.activity.main;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Sb extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f10833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f10834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ RelativeLayout f10835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ AnimatorSet f10836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ DataRecyclerView f10837f;
    final /* synthetic */ io.reactivex.b.a g;
    final /* synthetic */ bc h;

    Sb(bc bcVar, Context context, View view, View view2, RelativeLayout relativeLayout, AnimatorSet animatorSet, DataRecyclerView dataRecyclerView, io.reactivex.b.a aVar) {
        this.h = bcVar;
        this.f10832a = context;
        this.f10833b = view;
        this.f10834c = view2;
        this.f10835d = relativeLayout;
        this.f10836e = animatorSet;
        this.f10837f = dataRecyclerView;
        this.g = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        ImageView imageView = new ImageView(this.f10832a);
        imageView.setImageResource(R.mipmap.ic_scrap_shadow);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        float x = this.f10833b.getX() + ((int) this.f10832a.getResources().getDimension(R.dimen.dp_2));
        float y = this.f10833b.getY() + this.f10834c.getHeight() + ((int) this.f10832a.getResources().getDimension(R.dimen.dp_5));
        imageView.setX(x);
        imageView.setY(y);
        this.f10835d.addView(imageView, this.f10833b.getWidth(), (int) this.f10832a.getResources().getDimension(R.dimen.dp_44));
        ObjectAnimator duration = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, WheelView.DividerConfig.FILL).setDuration(2000L);
        duration.setStartDelay(2000L);
        duration.start();
        duration.addListener(new Rb(this, imageView));
    }
}
