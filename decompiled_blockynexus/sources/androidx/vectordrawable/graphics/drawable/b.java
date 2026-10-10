package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: compiled from: Animatable2Compat.java */
/* JADX INFO: loaded from: classes.dex */
class b extends Animatable2.AnimationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Animatable2Compat.AnimationCallback f2335a;

    b(Animatable2Compat.AnimationCallback animationCallback) {
        this.f2335a = animationCallback;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        this.f2335a.a(drawable);
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public void onAnimationStart(Drawable drawable) {
        this.f2335a.b(drawable);
    }
}
