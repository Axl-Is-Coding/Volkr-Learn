package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: OneShotPreDrawListener.java */
/* JADX INFO: loaded from: classes.dex */
public final class s implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f1269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f1270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f1271c;

    private s(View view, Runnable runnable) {
        this.f1269a = view;
        this.f1270b = view.getViewTreeObserver();
        this.f1271c = runnable;
    }

    public static s a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        s sVar = new s(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(sVar);
        view.addOnAttachStateChangeListener(sVar);
        return sVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        this.f1271c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f1270b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }

    public void a() {
        if (this.f1270b.isAlive()) {
            this.f1270b.removeOnPreDrawListener(this);
        } else {
            this.f1269a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f1269a.removeOnAttachStateChangeListener(this);
    }
}
