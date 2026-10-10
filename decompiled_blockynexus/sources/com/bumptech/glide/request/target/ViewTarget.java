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
@Deprecated
public abstract class ViewTarget<T extends View, Z> extends a<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f4826b = R.id.glide_custom_view_target_tag;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final T f4827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SizeDeterminer f4828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View.OnAttachStateChangeListener f4829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4830f;
    private boolean g;

    public ViewTarget(T t) {
        l.a(t);
        this.f4827c = t;
        this.f4828d = new SizeDeterminer(t);
    }

    private void a(Object obj) {
        f4825a = true;
        this.f4827c.setTag(f4826b, obj);
    }

    private void b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f4829e;
        if (onAttachStateChangeListener == null || this.g) {
            return;
        }
        this.f4827c.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.g = true;
    }

    private void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f4829e;
        if (onAttachStateChangeListener == null || !this.g) {
            return;
        }
        this.f4827c.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.g = false;
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.Target
    public com.bumptech.glide.request.d getRequest() {
        Object objA = a();
        if (objA == null) {
            return null;
        }
        if (objA instanceof com.bumptech.glide.request.d) {
            return (com.bumptech.glide.request.d) objA;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(h hVar) {
        this.f4828d.a(hVar);
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.f4828d.b();
        if (this.f4830f) {
            return;
        }
        c();
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        b();
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(h hVar) {
        this.f4828d.removeCallback(hVar);
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.Target
    public void setRequest(com.bumptech.glide.request.d dVar) {
        a(dVar);
    }

    public String toString() {
        return "Target for: " + this.f4827c;
    }

    static final class SizeDeterminer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static Integer f4831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f4832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<h> f4833c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f4834d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private a f4835e;

        private static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<SizeDeterminer> f4836a;

            a(SizeDeterminer sizeDeterminer) {
                this.f4836a = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = this.f4836a.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.a();
                return true;
            }
        }

        SizeDeterminer(View view) {
            this.f4832b = view;
        }

        private static int a(Context context) {
            if (f4831a == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                l.a(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f4831a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f4831a.intValue();
        }

        private boolean a(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private void b(int i, int i2) {
            Iterator it = new ArrayList(this.f4833c).iterator();
            while (it.hasNext()) {
                ((h) it.next()).a(i, i2);
            }
        }

        private int c() {
            int paddingTop = this.f4832b.getPaddingTop() + this.f4832b.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f4832b.getLayoutParams();
            return a(this.f4832b.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f4832b.getPaddingLeft() + this.f4832b.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f4832b.getLayoutParams();
            return a(this.f4832b.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        void removeCallback(h hVar) {
            this.f4833c.remove(hVar);
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f4832b.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f4835e);
            }
            this.f4835e = null;
            this.f4833c.clear();
        }

        void a() {
            if (this.f4833c.isEmpty()) {
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
            if (!this.f4833c.contains(hVar)) {
                this.f4833c.add(hVar);
            }
            if (this.f4835e == null) {
                ViewTreeObserver viewTreeObserver = this.f4832b.getViewTreeObserver();
                this.f4835e = new a(this);
                viewTreeObserver.addOnPreDrawListener(this.f4835e);
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
            if (this.f4834d && this.f4832b.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f4832b.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f4832b.getContext());
        }
    }

    private Object a() {
        return this.f4827c.getTag(f4826b);
    }
}
