package com.squareup.picasso;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.squareup.picasso.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DeferredRequestCreator.java */
/* JADX INFO: loaded from: classes5.dex */
class ViewTreeObserverOnPreDrawListenerC2760o implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final D f19298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final WeakReference<ImageView> f19299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    InterfaceC2757l f19300c;

    ViewTreeObserverOnPreDrawListenerC2760o(D d2, ImageView imageView, InterfaceC2757l interfaceC2757l) {
        this.f19298a = d2;
        this.f19299b = new WeakReference<>(imageView);
        this.f19300c = interfaceC2757l;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    void a() {
        this.f19300c = null;
        ImageView imageView = this.f19299b.get();
        if (imageView == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ImageView imageView = this.f19299b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            viewTreeObserver.removeOnPreDrawListener(this);
            D d2 = this.f19298a;
            d2.c();
            d2.a(width, height);
            d2.a(imageView, this.f19300c);
        }
        return true;
    }
}
