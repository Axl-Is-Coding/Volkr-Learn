package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R;
import com.bumptech.glide.e.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f4804a = R.id.glide_custom_view_target_tag;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SizeDeterminer f4805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final T f4806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View.OnAttachStateChangeListener f4807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4809f;

    public CustomViewTarget(T t) {
        l.a(t);
        this.f4806c = t;
        this.f4805b = new SizeDeterminer(t);
    }

    private void a(Object obj) {
        this.f4806c.setTag(f4804a, obj);
    }

    private void b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f4807d;
        if (onAttachStateChangeListener == null || this.f4809f) {
            return;
        }
        this.f4806c.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f4809f = true;
    }

    private void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f4807d;
        if (onAttachStateChangeListener == null || !this.f4809f) {
            return;
        }
        this.f4806c.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f4809f = false;
    }

    protected abstract void a(Drawable drawable);

    protected void b(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final com.bumptech.glide.request.d getRequest() {
        Object objA = a();
        if (objA == null) {
            return null;
        }
        if (objA instanceof com.bumptech.glide.request.d) {
            return (com.bumptech.glide.request.d) objA;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(h hVar) {
        this.f4805b.a(hVar);
    }

    @Override // com.bumptech.glide.manager.j
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable) {
        this.f4805b.b();
        a(drawable);
        if (this.f4808e) {
            return;
        }
        c();
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadStarted(Drawable drawable) {
        b();
        b(drawable);
    }

    @Override // com.bumptech.glide.manager.j
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.j
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(h hVar) {
        this.f4805b.removeCallback(hVar);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(com.bumptech.glide.request.d dVar) {
        a(dVar);
    }

    public String toString() {
        return "Target for: " + this.f4806c;
    }

    static final class SizeDeterminer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static Integer f4810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f4811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<h> f4812c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f4813d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private a f4814e;

        private static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<SizeDeterminer> f4815a;

            a(SizeDeterminer sizeDeterminer) {
                this.f4815a = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = this.f4815a.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.a();
                return true;
            }
        }

        SizeDeterminer(View view) {
            this.f4811b = view;
        }

        private static int a(Context context) {
            if (f4810a == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                l.a(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f4810a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f4810a.intValue();
        }

        private boolean a(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private void b(int i, int i2) {
            Iterator it = new ArrayList(this.f4812c).iterator();
            while (it.hasNext()) {
                ((h) it.next()).a(i, i2);
            }
        }

        private int c() {
            int paddingTop = this.f4811b.getPaddingTop() + this.f4811b.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f4811b.getLayoutParams();
            return a(this.f4811b.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f4811b.getPaddingLeft() + this.f4811b.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f4811b.getLayoutParams();
            return a(this.f4811b.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        void removeCallback(h hVar) {
            this.f4812c.remove(hVar);
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f4811b.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f4814e);
            }
            this.f4814e = null;
            this.f4812c.clear();
        }

        void a() {
            if (this.f4812c.isEmpty()) {
                return;
            }
            int iD = d();
            int iC = c();
            if (a(iD, iC)) {
                b(iD, iC);
                b();
            }
        }

        void a(h hVar) {
            int iD = d();
            int iC = c();
            if (a(iD, iC)) {
                hVar.a(iD, iC);
                return;
            }
            if (!this.f4812c.contains(hVar)) {
                this.f4812c.add(hVar);
            }
            if (this.f4814e == null) {
                ViewTreeObserver viewTreeObserver = this.f4811b.getViewTreeObserver();
                this.f4814e = new a(this);
                viewTreeObserver.addOnPreDrawListener(this.f4814e);
            }
        }

        private boolean a(int i, int i2) {
            return a(i) && a(i2);
        }

        private int a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f4813d && this.f4811b.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f4811b.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f4811b.getContext());
        }
    }

    private Object a() {
        return this.f4806c.getTag(f4804a);
    }
}
