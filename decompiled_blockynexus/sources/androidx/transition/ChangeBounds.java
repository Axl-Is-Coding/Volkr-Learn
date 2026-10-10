package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private static final String[] K = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> L = new C0382d(PointF.class, "boundsOrigin");
    private static final Property<a, PointF> M = new C0384e(PointF.class, "topLeft");
    private static final Property<a, PointF> N = new C0386f(PointF.class, "bottomRight");
    private static final Property<View, PointF> O = new C0388g(PointF.class, "bottomRight");
    private static final Property<View, PointF> P = new C0390h(PointF.class, "topLeft");
    private static final Property<View, PointF> Q = new C0391i(PointF.class, "position");
    private static N R = new N();
    private int[] S;
    private boolean T;
    private boolean U;

    public ChangeBounds() {
        this.S = new int[2];
        this.T = false;
        this.U = false;
    }

    private void d(ha haVar) {
        View view = haVar.f2247b;
        if (!ViewCompat.C(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        haVar.f2246a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        haVar.f2246a.put("android:changeBounds:parent", haVar.f2247b.getParent());
        if (this.U) {
            haVar.f2247b.getLocationInWindow(this.S);
            haVar.f2246a.put("android:changeBounds:windowX", Integer.valueOf(this.S[0]));
            haVar.f2246a.put("android:changeBounds:windowY", Integer.valueOf(this.S[1]));
        }
        if (this.T) {
            haVar.f2246a.put("android:changeBounds:clip", ViewCompat.g(view));
        }
    }

    @Override // androidx.transition.Transition
    public void a(ha haVar) {
        d(haVar);
    }

    public void b(boolean z) {
        this.T = z;
    }

    @Override // androidx.transition.Transition
    public void c(ha haVar) {
        d(haVar);
    }

    @Override // androidx.transition.Transition
    public String[] n() {
        return K;
    }

    private boolean a(View view, View view2) {
        if (!this.U) {
            return true;
        }
        ha haVarA = a(view, true);
        if (haVarA == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == haVarA.f2247b) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f2138e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f2139f;
        private int g;

        a(View view) {
            this.f2138e = view;
        }

        void a(PointF pointF) {
            this.f2136c = Math.round(pointF.x);
            this.f2137d = Math.round(pointF.y);
            this.g++;
            if (this.f2139f == this.g) {
                a();
            }
        }

        void b(PointF pointF) {
            this.f2134a = Math.round(pointF.x);
            this.f2135b = Math.round(pointF.y);
            this.f2139f++;
            if (this.f2139f == this.g) {
                a();
            }
        }

        private void a() {
            va.a(this.f2138e, this.f2134a, this.f2135b, this.f2136c, this.f2137d);
            this.f2139f = 0;
            this.g = 0;
        }
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = new int[2];
        this.T = false;
        this.U = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X.f2216d);
        boolean zA = androidx.core.content.a.i.a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "resizeClip", 0, false);
        typedArrayObtainStyledAttributes.recycle();
        b(zA);
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ha haVar, ha haVar2) {
        int i;
        View view;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimatorOfObject;
        Animator animatorA;
        if (haVar == null || haVar2 == null) {
            return null;
        }
        Map<String, Object> map = haVar.f2246a;
        Map<String, Object> map2 = haVar2.f2246a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = haVar2.f2247b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) haVar.f2246a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) haVar2.f2246a.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            int i4 = rect3.left;
            int i5 = rect2.top;
            int i6 = rect3.top;
            int i7 = rect2.right;
            int i8 = rect3.right;
            int i9 = rect2.bottom;
            int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            Rect rect4 = (Rect) haVar.f2246a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) haVar2.f2246a.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (i7 != i8 || i9 != i10) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i <= 0) {
                return null;
            }
            if (!this.T) {
                view = view2;
                va.a(view, i3, i5, i7, i9);
                if (i == 2) {
                    if (i11 == i13 && i12 == i14) {
                        animatorA = K.a(view, Q, g().a(i3, i5, i4, i6));
                    } else {
                        a aVar = new a(view);
                        ObjectAnimator objectAnimatorA = K.a(aVar, M, g().a(i3, i5, i4, i6));
                        ObjectAnimator objectAnimatorA2 = K.a(aVar, N, g().a(i7, i9, i8, i10));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(objectAnimatorA, objectAnimatorA2);
                        animatorSet.addListener(new C0392j(this, aVar));
                        animatorA = animatorSet;
                    }
                } else if (i3 == i4 && i5 == i6) {
                    animatorA = K.a(view, O, g().a(i7, i9, i8, i10));
                } else {
                    animatorA = K.a(view, P, g().a(i3, i5, i4, i6));
                }
            } else {
                view = view2;
                va.a(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                ObjectAnimator objectAnimatorA3 = (i3 == i4 && i5 == i6) ? null : K.a(view, Q, g().a(i3, i5, i4, i6));
                if (rect4 == null) {
                    i2 = 0;
                    rect = new Rect(0, 0, i11, i12);
                } else {
                    i2 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
                if (rect.equals(rect6)) {
                    objectAnimatorOfObject = null;
                } else {
                    ViewCompat.a(view, rect);
                    N n = R;
                    Object[] objArr = new Object[2];
                    objArr[i2] = rect;
                    objArr[1] = rect6;
                    objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", n, objArr);
                    objectAnimatorOfObject.addListener(new C0393k(this, view, rect5, i4, i6, i8, i10));
                }
                animatorA = C0389ga.a(objectAnimatorA3, objectAnimatorOfObject);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                na.a(viewGroup4, true);
                a(new C0394l(this, viewGroup4));
            }
            return animatorA;
        }
        int iIntValue = ((Integer) haVar.f2246a.get("android:changeBounds:windowX")).intValue();
        int iIntValue2 = ((Integer) haVar.f2246a.get("android:changeBounds:windowY")).intValue();
        int iIntValue3 = ((Integer) haVar2.f2246a.get("android:changeBounds:windowX")).intValue();
        int iIntValue4 = ((Integer) haVar2.f2246a.get("android:changeBounds:windowY")).intValue();
        if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.S);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(bitmapCreateBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
        float fC = va.c(view2);
        va.a(view2, WheelView.DividerConfig.FILL);
        va.b(viewGroup).a(bitmapDrawable);
        PathMotion pathMotionG = g();
        int[] iArr = this.S;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, M.a(L, pathMotionG.a(iIntValue - iArr[0], iIntValue2 - iArr[1], iIntValue3 - iArr[0], iIntValue4 - iArr[1])));
        objectAnimatorOfPropertyValuesHolder.addListener(new C0380c(this, viewGroup, bitmapDrawable, view2, fC));
        return objectAnimatorOfPropertyValuesHolder;
    }
}
