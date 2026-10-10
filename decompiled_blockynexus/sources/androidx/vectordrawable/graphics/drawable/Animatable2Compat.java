package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public interface Animatable2Compat extends Animatable {

    public static abstract class AnimationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Animatable2.AnimationCallback f2317a;

        public void a(Drawable drawable) {
        }

        public void b(Drawable drawable) {
        }

        Animatable2.AnimationCallback getPlatformCallback() {
            if (this.f2317a == null) {
                this.f2317a = new b(this);
            }
            return this.f2317a;
        }
    }

    void registerAnimationCallback(AnimationCallback animationCallback);

    boolean unregisterAnimationCallback(AnimationCallback animationCallback);
}
