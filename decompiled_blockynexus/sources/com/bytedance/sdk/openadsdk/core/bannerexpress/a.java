package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.ac;

/* JADX INFO: compiled from: BannerExpressView.java */
/* JADX INFO: loaded from: classes.dex */
class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NativeExpressView f6020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NativeExpressView f6021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h f6022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AdSlot f6023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TTNativeExpressAd.ExpressAdInteractionListener f6024f;
    private int g;
    private boolean h;
    private String i;

    public a(Context context, h hVar, AdSlot adSlot) {
        super(context);
        this.i = "banner_ad";
        this.f6019a = context;
        this.f6022d = hVar;
        this.f6023e = adSlot;
        g();
    }

    private void g() {
        this.f6020b = new NativeExpressView(this.f6019a, this.f6022d, this.f6023e, this.i);
        addView(this.f6020b, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.h || this.f6021c == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a(this.f6020b)).with(b(this.f6021c));
        animatorSet.setDuration(this.g).start();
        ac.a((View) this.f6021c, 0);
        this.h = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        NativeExpressView nativeExpressView = this.f6020b;
        this.f6020b = this.f6021c;
        this.f6021c = nativeExpressView;
        NativeExpressView nativeExpressView2 = this.f6021c;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.f6021c.k();
            this.f6021c = null;
        }
    }

    public NativeExpressView d() {
        return this.f6021c;
    }

    public void e() {
        NativeExpressView nativeExpressView = this.f6021c;
        if (nativeExpressView != null) {
            nativeExpressView.h();
        }
    }

    public boolean f() {
        return this.f6021c != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void b() {
        NativeExpressView nativeExpressView = this.f6020b;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.f6020b.k();
            this.f6020b = null;
        }
        NativeExpressView nativeExpressView2 = this.f6021c;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.f6021c.k();
            this.f6021c = null;
        }
    }

    public NativeExpressView c() {
        return this.f6020b;
    }

    public void a(h hVar, AdSlot adSlot) {
        this.f6021c = new NativeExpressView(this.f6019a, hVar, adSlot, this.i);
        this.f6021c.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                if (a.this.f6024f != null) {
                    a.this.f6024f.onAdClicked(a.this, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                a.this.a(f2, f3);
                a.this.h();
            }
        });
        ac.a((View) this.f6021c, 8);
        addView(this.f6021c, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f6024f = expressAdInteractionListener;
        this.f6020b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                if (a.this.f6024f != null) {
                    a.this.f6024f.onAdClicked(a.this, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                if (a.this.f6024f != null) {
                    a.this.f6024f.onRenderFail(a.this, str, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).m()) {
                    a.this.a(f2, f3);
                }
                if (a.this.f6024f != null) {
                    a.this.f6024f.onRenderSuccess(a.this, f2, f3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2, float f3) {
        int iA = (int) ac.a(this.f6019a, f2);
        int iA2 = (int) ac.a(this.f6019a, f3);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iA, iA2);
        }
        layoutParams.width = iA;
        layoutParams.height = iA2;
        setLayoutParams(layoutParams);
    }

    private ObjectAnimator b(NativeExpressView nativeExpressView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), WheelView.DividerConfig.FILL);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.h = false;
                a.this.i();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        return objectAnimatorOfFloat;
    }

    public void a() {
        NativeExpressView nativeExpressView = this.f6020b;
        if (nativeExpressView != null) {
            nativeExpressView.h();
        }
    }

    public void a(int i) {
        this.g = i;
    }

    private ObjectAnimator a(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", WheelView.DividerConfig.FILL, -getWidth());
    }
}
