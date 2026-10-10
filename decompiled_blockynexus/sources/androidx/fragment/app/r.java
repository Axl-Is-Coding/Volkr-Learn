package androidx.fragment.app;

import android.view.ViewGroup;
import android.view.animation.Animation;

/* JADX INFO: compiled from: FragmentManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
class r implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup f1519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fragment f1520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LayoutInflaterFactory2C0343v f1521c;

    r(LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v, ViewGroup viewGroup, Fragment fragment) {
        this.f1521c = layoutInflaterFactory2C0343v;
        this.f1519a = viewGroup;
        this.f1520b = fragment;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f1519a.post(new RunnableC0339q(this));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
