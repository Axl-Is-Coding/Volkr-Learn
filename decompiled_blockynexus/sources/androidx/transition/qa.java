package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: ViewOverlayApi14.java */
/* JADX INFO: loaded from: classes.dex */
class qa implements sa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f2282a;

    qa(Context context, ViewGroup viewGroup, View view) {
        this.f2282a = new a(context, viewGroup, view, this);
    }

    static qa c(View view) {
        ViewGroup viewGroupD = d(view);
        if (viewGroupD == null) {
            return null;
        }
        int childCount = viewGroupD.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroupD.getChildAt(i);
            if (childAt instanceof a) {
                return ((a) childAt).f2287e;
            }
        }
        return new ka(viewGroupD.getContext(), viewGroupD, view);
    }

    static ViewGroup d(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // androidx.transition.sa
    public void a(Drawable drawable) {
        this.f2282a.a(drawable);
    }

    @Override // androidx.transition.sa
    public void b(Drawable drawable) {
        this.f2282a.b(drawable);
    }

    /* JADX INFO: compiled from: ViewOverlayApi14.java */
    static class a extends ViewGroup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static Method f2283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ViewGroup f2284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        View f2285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList<Drawable> f2286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        qa f2287e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f2288f;

        static {
            try {
                f2283a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, qa qaVar) {
            super(context);
            this.f2286d = null;
            this.f2284b = viewGroup;
            this.f2285c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f2287e = qaVar;
        }

        public void a(Drawable drawable) {
            a();
            if (this.f2286d == null) {
                this.f2286d = new ArrayList<>();
            }
            if (this.f2286d.contains(drawable)) {
                return;
            }
            this.f2286d.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f2286d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                b();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.f2284b.getLocationOnScreen(new int[2]);
            this.f2285c.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.f2285c.getWidth(), this.f2285c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f2286d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f2286d.get(i).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f2284b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (!(this.f2284b instanceof ViewGroup)) {
                invalidate(rect);
                return null;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = new int[2];
            a(iArr2);
            rect.offset(iArr2[0], iArr2[1]);
            return super.invalidateChildInParent(iArr, rect);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f2286d) != null && arrayList.contains(drawable));
        }

        public void b(View view) {
            super.removeView(view);
            b();
        }

        private void b() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f2286d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f2288f = true;
                    this.f2284b.removeView(this);
                }
            }
        }

        public void a(View view) {
            a();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f2284b && viewGroup.getParent() != null && ViewCompat.B(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f2284b.getLocationOnScreen(iArr2);
                    ViewCompat.b(view, iArr[0] - iArr2[0]);
                    ViewCompat.c(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        private void a() {
            if (this.f2288f) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f2284b.getLocationOnScreen(iArr2);
            this.f2285c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }
    }
}
