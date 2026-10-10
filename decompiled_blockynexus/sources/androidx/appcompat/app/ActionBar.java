package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.d.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionBar {

    public interface a {
        void onMenuVisibilityChanged(boolean z);
    }

    @Deprecated
    public static abstract class b {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract int d();

        public abstract CharSequence e();

        public abstract void f();
    }

    @Deprecated
    public interface c {
        void a(b bVar, androidx.fragment.app.F f2);

        void b(b bVar, androidx.fragment.app.F f2);

        void c(b bVar, androidx.fragment.app.F f2);
    }

    public androidx.appcompat.d.b a(b.a aVar) {
        return null;
    }

    public abstract void a(float f2);

    public abstract void a(int i);

    public void a(Configuration configuration) {
    }

    public abstract void a(CharSequence charSequence);

    public abstract boolean a(int i, KeyEvent keyEvent);

    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public abstract void b(CharSequence charSequence);

    public abstract void b(boolean z);

    public abstract void c(boolean z);

    public abstract void d(boolean z);

    public abstract void e(boolean z);

    public boolean e() {
        return false;
    }

    public abstract void f(boolean z);

    public abstract boolean f();

    public abstract View g();

    public abstract void g(boolean z);

    public abstract int h();

    public abstract void h(boolean z);

    public abstract Context i();

    public boolean j() {
        return false;
    }

    void k() {
    }

    public boolean l() {
        return false;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f196a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f196a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f196a = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f196a = 0;
            this.f196a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f196a = 0;
            this.f196a = layoutParams.f196a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f196a = 0;
        }
    }
}
