package com.bytedance.sdk.openadsdk.component.banner;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;

/* JADX INFO: compiled from: BannerView.java */
/* JADX INFO: loaded from: classes.dex */
class d extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f5835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f5836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageView f5837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f5838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.dislike.b f5839f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;

    public d(Context context) {
        super(context);
        this.i = false;
        this.j = false;
        this.f5834a = context;
        g();
    }

    private void g() {
        this.f5835b = new c(this.f5834a);
        addView(this.f5835b, new FrameLayout.LayoutParams(-1, -1));
        i();
        h();
    }

    private void h() {
        if (this.j) {
            return;
        }
        this.j = true;
        this.f5837d = new ImageView(this.f5834a);
        this.f5837d.setImageResource(t.d(o.a(), "tt_dislike_icon"));
        this.f5837d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f5837d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.banner.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.f5839f != null) {
                    d.this.f5839f.showDislikeDialog();
                }
            }
        });
        int iA = (int) ac.a(this.f5834a, 15.0f);
        int iA2 = (int) ac.a(this.f5834a, 10.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = iA2;
        layoutParams.rightMargin = iA2;
        addView(this.f5837d, layoutParams);
        ac.a(this.f5837d, iA, iA, iA, iA);
    }

    private void i() {
        if (this.i) {
            return;
        }
        this.i = true;
        this.f5838e = new ImageView(this.f5834a);
        this.f5838e.setImageResource(t.d(o.a(), "tt_ad_logo_small"));
        this.f5838e.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(20, 20);
        layoutParams.gravity = 8388693;
        addView(this.f5838e, layoutParams);
    }

    private void j() {
        ImageView imageView = this.f5838e;
        if (imageView != null) {
            bringChildToFront(imageView);
        }
        ImageView imageView2 = this.f5837d;
        if (imageView2 != null) {
            bringChildToFront(imageView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        c cVar = this.f5835b;
        this.f5835b = this.f5836c;
        this.f5836c = cVar;
        this.f5836c.b();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        j();
    }

    public c c() {
        return this.f5836c;
    }

    public View d() {
        return this.f5837d;
    }

    public void e() {
        if (this.h) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a(this.f5835b)).with(b(this.f5836c));
        animatorSet.setDuration(this.g).start();
        this.f5836c.setVisibility(0);
        this.h = true;
    }

    public boolean f() {
        c cVar = this.f5836c;
        return (cVar == null || cVar.a() == null) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
        this.j = false;
    }

    public c b() {
        return this.f5835b;
    }

    private ObjectAnimator b(final c cVar) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(cVar, "translationX", getWidth(), WheelView.DividerConfig.FILL);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.component.banner.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.h = false;
                d.this.k();
                c cVar2 = cVar;
                if (cVar2 != null) {
                    d.this.a(cVar2.a());
                }
                com.bytedance.sdk.openadsdk.utils.o.b("TTBannerAd", "SLIDE END");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                com.bytedance.sdk.openadsdk.utils.o.b("TTBannerAd", "SLIDE START");
            }
        });
        return objectAnimatorOfFloat;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        j();
    }

    public void a() {
        this.f5836c = new c(this.f5834a);
        this.f5836c.setVisibility(8);
        addView(this.f5836c, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        j();
    }

    void a(com.bytedance.sdk.openadsdk.dislike.b bVar) {
        this.f5839f = bVar;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        super.addView(view, i, i2);
        j();
    }

    public void a(int i) {
        this.g = i;
    }

    private ObjectAnimator a(c cVar) {
        return ObjectAnimator.ofFloat(cVar, "translationX", WheelView.DividerConfig.FILL, -getWidth());
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar) {
        com.bytedance.sdk.openadsdk.dislike.b bVar = this.f5839f;
        if (bVar == null || hVar == null) {
            return;
        }
        bVar.a(hVar);
    }
}
