package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform extends Transition {
    private static final String[] K = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    private static final Property<b, float[]> L = new C0399q(float[].class, "nonTranslations");
    private static final Property<b, PointF> M = new C0400r(PointF.class, "translations");
    private static final boolean N;
    boolean O;
    private boolean P;
    private Matrix Q;

    private static class a extends C0379ba {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private View f2140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private B f2141b;

        a(View view, B b2) {
            this.f2140a = view;
            this.f2141b = b2;
        }

        @Override // androidx.transition.C0379ba, androidx.transition.Transition.c
        public void a(Transition transition) {
            this.f2141b.setVisibility(0);
        }

        @Override // androidx.transition.C0379ba, androidx.transition.Transition.c
        public void c(Transition transition) {
            this.f2141b.setVisibility(4);
        }

        @Override // androidx.transition.Transition.c
        public void d(Transition transition) {
            transition.b(this);
            G.a(this.f2140a);
            this.f2140a.setTag(R.id.transition_transform, null);
            this.f2140a.setTag(R.id.parent_matrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f2147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f2148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f2149c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final float f2150d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final float f2151e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final float f2152f;
        final float g;
        final float h;

        c(View view) {
            this.f2147a = view.getTranslationX();
            this.f2148b = view.getTranslationY();
            this.f2149c = ViewCompat.u(view);
            this.f2150d = view.getScaleX();
            this.f2151e = view.getScaleY();
            this.f2152f = view.getRotationX();
            this.g = view.getRotationY();
            this.h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.a(view, this.f2147a, this.f2148b, this.f2149c, this.f2150d, this.f2151e, this.f2152f, this.g, this.h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f2147a == this.f2147a && cVar.f2148b == this.f2148b && cVar.f2149c == this.f2149c && cVar.f2150d == this.f2150d && cVar.f2151e == this.f2151e && cVar.f2152f == this.f2152f && cVar.g == this.g && cVar.h == this.h;
        }

        public int hashCode() {
            float f2 = this.f2147a;
            int iFloatToIntBits = (f2 != WheelView.DividerConfig.FILL ? Float.floatToIntBits(f2) : 0) * 31;
            float f3 = this.f2148b;
            int iFloatToIntBits2 = (iFloatToIntBits + (f3 != WheelView.DividerConfig.FILL ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f2149c;
            int iFloatToIntBits3 = (iFloatToIntBits2 + (f4 != WheelView.DividerConfig.FILL ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.f2150d;
            int iFloatToIntBits4 = (iFloatToIntBits3 + (f5 != WheelView.DividerConfig.FILL ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f2151e;
            int iFloatToIntBits5 = (iFloatToIntBits4 + (f6 != WheelView.DividerConfig.FILL ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f2152f;
            int iFloatToIntBits6 = (iFloatToIntBits5 + (f7 != WheelView.DividerConfig.FILL ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.g;
            int iFloatToIntBits7 = (iFloatToIntBits6 + (f8 != WheelView.DividerConfig.FILL ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.h;
            return iFloatToIntBits7 + (f9 != WheelView.DividerConfig.FILL ? Float.floatToIntBits(f9) : 0);
        }
    }

    static {
        N = Build.VERSION.SDK_INT >= 21;
    }

    public ChangeTransform() {
        this.O = true;
        this.P = true;
        this.Q = new Matrix();
    }

    private void b(ViewGroup viewGroup, ha haVar, ha haVar2) {
        View view = haVar2.f2247b;
        Matrix matrix = new Matrix((Matrix) haVar2.f2246a.get("android:changeTransform:parentMatrix"));
        va.c(viewGroup, matrix);
        B bA = G.a(view, viewGroup, matrix);
        if (bA == null) {
            return;
        }
        bA.a((ViewGroup) haVar.f2246a.get("android:changeTransform:parent"), haVar.f2247b);
        Transition transition = this;
        while (true) {
            TransitionSet transitionSet = transition.u;
            if (transitionSet == null) {
                break;
            } else {
                transition = transitionSet;
            }
        }
        transition.a(new a(view, bA));
        if (N) {
            View view2 = haVar.f2247b;
            if (view2 != haVar2.f2247b) {
                va.a(view2, WheelView.DividerConfig.FILL);
            }
            va.a(view, 1.0f);
        }
    }

    private void d(ha haVar) {
        View view = haVar.f2247b;
        if (view.getVisibility() == 8) {
            return;
        }
        haVar.f2246a.put("android:changeTransform:parent", view.getParent());
        haVar.f2246a.put("android:changeTransform:transforms", new c(view));
        Matrix matrix = view.getMatrix();
        haVar.f2246a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.P) {
            Matrix matrix2 = new Matrix();
            va.b((ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r2.getScrollX(), -r2.getScrollY());
            haVar.f2246a.put("android:changeTransform:parentMatrix", matrix2);
            haVar.f2246a.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
            haVar.f2246a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
        }
    }

    static void f(View view) {
        a(view, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 1.0f, 1.0f, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
    }

    @Override // androidx.transition.Transition
    public void a(ha haVar) {
        d(haVar);
    }

    @Override // androidx.transition.Transition
    public void c(ha haVar) {
        d(haVar);
        if (N) {
            return;
        }
        ((ViewGroup) haVar.f2247b.getParent()).startViewTransition(haVar.f2247b);
    }

    @Override // androidx.transition.Transition
    public String[] n() {
        return K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Matrix f2142a = new Matrix();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f2143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float[] f2144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f2145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f2146e;

        b(View view, float[] fArr) {
            this.f2143b = view;
            this.f2144c = (float[]) fArr.clone();
            float[] fArr2 = this.f2144c;
            this.f2145d = fArr2[2];
            this.f2146e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.f2144c;
            fArr[2] = this.f2145d;
            fArr[5] = this.f2146e;
            this.f2142a.setValues(fArr);
            va.a(this.f2143b, this.f2142a);
        }

        void a(float[] fArr) {
            System.arraycopy(fArr, 0, this.f2144c, 0, fArr.length);
            b();
        }

        void a(PointF pointF) {
            this.f2145d = pointF.x;
            this.f2146e = pointF.y;
            b();
        }

        Matrix a() {
            return this.f2142a;
        }
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ha haVar, ha haVar2) {
        if (haVar == null || haVar2 == null || !haVar.f2246a.containsKey("android:changeTransform:parent") || !haVar2.f2246a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) haVar.f2246a.get("android:changeTransform:parent");
        boolean z = this.P && !a(viewGroup2, (ViewGroup) haVar2.f2246a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) haVar.f2246a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            haVar.f2246a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) haVar.f2246a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            haVar.f2246a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            b(haVar, haVar2);
        }
        ObjectAnimator objectAnimatorA = a(haVar, haVar2, z);
        if (z && objectAnimatorA != null && this.O) {
            b(viewGroup, haVar, haVar2);
        } else if (!N) {
            viewGroup2.endViewTransition(haVar.f2247b);
        }
        return objectAnimatorA;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O = true;
        this.P = true;
        this.Q = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X.g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.O = androidx.core.content.a.i.a(typedArrayObtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.P = androidx.core.content.a.i.a(typedArrayObtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void b(ha haVar, ha haVar2) {
        Matrix matrix = (Matrix) haVar2.f2246a.get("android:changeTransform:parentMatrix");
        haVar2.f2247b.setTag(R.id.parent_matrix, matrix);
        Matrix matrix2 = this.Q;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) haVar.f2246a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            haVar.f2246a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) haVar.f2246a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    private ObjectAnimator a(ha haVar, ha haVar2, boolean z) {
        Matrix matrix = (Matrix) haVar.f2246a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) haVar2.f2246a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = J.f2174a;
        }
        if (matrix2 == null) {
            matrix2 = J.f2174a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        c cVar = (c) haVar2.f2246a.get("android:changeTransform:transforms");
        View view = haVar2.f2247b;
        f(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        b bVar = new b(view, fArr);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bVar, PropertyValuesHolder.ofObject(L, new C0404v(new float[9]), fArr, fArr2), M.a(M, g().a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        C0401s c0401s = new C0401s(this, z, matrix3, view, cVar, bVar);
        objectAnimatorOfPropertyValuesHolder.addListener(c0401s);
        C0376a.a(objectAnimatorOfPropertyValuesHolder, c0401s);
        return objectAnimatorOfPropertyValuesHolder;
    }

    private boolean a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (b(viewGroup) && b(viewGroup2)) {
            ha haVarA = a((View) viewGroup, true);
            if (haVarA == null || viewGroup2 != haVarA.f2247b) {
                return false;
            }
        } else if (viewGroup != viewGroup2) {
            return false;
        }
        return true;
    }

    static void a(View view, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        ViewCompat.b(view, f4);
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setRotationX(f7);
        view.setRotationY(f8);
        view.setRotation(f9);
    }
}
