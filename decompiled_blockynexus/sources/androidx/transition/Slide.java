package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class Slide extends Visibility {
    private static final TimeInterpolator M = new DecelerateInterpolator();
    private static final TimeInterpolator N = new AccelerateInterpolator();
    private static final a O = new Q();
    private static final a P = new S();
    private static final a Q = new T();
    private static final a R = new U();
    private static final a S = new V();
    private static final a T = new W();
    private a U;
    private int V;

    private interface a {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class b implements a {
        private b() {
        }

        @Override // androidx.transition.Slide.a
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        /* synthetic */ b(Q q) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class c implements a {
        private c() {
        }

        @Override // androidx.transition.Slide.a
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        /* synthetic */ c(Q q) {
            this();
        }
    }

    public Slide() {
        this.U = T;
        this.V = 80;
        b(80);
    }

    private void e(ha haVar) {
        int[] iArr = new int[2];
        haVar.f2247b.getLocationOnScreen(iArr);
        haVar.f2246a.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void a(ha haVar) {
        super.a(haVar);
        e(haVar);
    }

    public void b(int i) {
        if (i == 3) {
            this.U = O;
        } else if (i == 5) {
            this.U = R;
        } else if (i == 48) {
            this.U = Q;
        } else if (i == 80) {
            this.U = T;
        } else if (i == 8388611) {
            this.U = P;
        } else {
            if (i != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.U = S;
        }
        this.V = i;
        P p = new P();
        p.a(i);
        a(p);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void c(ha haVar) {
        super.c(haVar);
        e(haVar);
    }

    @Override // androidx.transition.Visibility
    public Animator a(ViewGroup viewGroup, View view, ha haVar, ha haVar2) {
        if (haVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) haVar2.f2246a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return ja.a(view, haVar2, iArr[0], iArr[1], this.U.b(viewGroup, view), this.U.a(viewGroup, view), translationX, translationY, M, this);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.U = T;
        this.V = 80;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X.h);
        int iB = androidx.core.content.a.i.b(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        typedArrayObtainStyledAttributes.recycle();
        b(iB);
    }

    @Override // androidx.transition.Visibility
    public Animator b(ViewGroup viewGroup, View view, ha haVar, ha haVar2) {
        if (haVar == null) {
            return null;
        }
        int[] iArr = (int[]) haVar.f2246a.get("android:slide:screenPosition");
        return ja.a(view, haVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.U.b(viewGroup, view), this.U.a(viewGroup, view), N, this);
    }
}
