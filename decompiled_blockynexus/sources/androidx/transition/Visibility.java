package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.C0376a;
import androidx.transition.Transition;

/* JADX INFO: loaded from: classes.dex */
public abstract class Visibility extends Transition {
    private static final String[] K = {"android:visibility:visibility", "android:visibility:parent"};
    private int L;

    private static class a extends AnimatorListenerAdapter implements Transition.c, C0376a.InterfaceC0035a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f2201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ViewGroup f2203c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f2204d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2205e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f2206f = false;

        a(View view, int i, boolean z) {
            this.f2201a = view;
            this.f2202b = i;
            this.f2203c = (ViewGroup) view.getParent();
            this.f2204d = z;
            a(true);
        }

        @Override // androidx.transition.Transition.c
        public void a(Transition transition) {
            a(true);
        }

        @Override // androidx.transition.Transition.c
        public void b(Transition transition) {
        }

        @Override // androidx.transition.Transition.c
        public void c(Transition transition) {
            a(false);
        }

        @Override // androidx.transition.Transition.c
        public void d(Transition transition) {
            a();
            transition.b(this);
        }

        @Override // androidx.transition.Transition.c
        public void e(Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2206f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.C0376a.InterfaceC0035a
        public void onAnimationPause(Animator animator) {
            if (this.f2206f) {
                return;
            }
            va.a(this.f2201a, this.f2202b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.C0376a.InterfaceC0035a
        public void onAnimationResume(Animator animator) {
            if (this.f2206f) {
                return;
            }
            va.a(this.f2201a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        private void a() {
            if (!this.f2206f) {
                va.a(this.f2201a, this.f2202b);
                ViewGroup viewGroup = this.f2203c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            ViewGroup viewGroup;
            if (!this.f2204d || this.f2205e == z || (viewGroup = this.f2203c) == null) {
                return;
            }
            this.f2205e = z;
            na.a(viewGroup, z);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f2208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2210d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ViewGroup f2211e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ViewGroup f2212f;

        b() {
        }
    }

    public Visibility() {
        this.L = 3;
    }

    private b b(ha haVar, ha haVar2) {
        b bVar = new b();
        bVar.f2207a = false;
        bVar.f2208b = false;
        if (haVar == null || !haVar.f2246a.containsKey("android:visibility:visibility")) {
            bVar.f2209c = -1;
            bVar.f2211e = null;
        } else {
            bVar.f2209c = ((Integer) haVar.f2246a.get("android:visibility:visibility")).intValue();
            bVar.f2211e = (ViewGroup) haVar.f2246a.get("android:visibility:parent");
        }
        if (haVar2 == null || !haVar2.f2246a.containsKey("android:visibility:visibility")) {
            bVar.f2210d = -1;
            bVar.f2212f = null;
        } else {
            bVar.f2210d = ((Integer) haVar2.f2246a.get("android:visibility:visibility")).intValue();
            bVar.f2212f = (ViewGroup) haVar2.f2246a.get("android:visibility:parent");
        }
        if (haVar == null || haVar2 == null) {
            if (haVar == null && bVar.f2210d == 0) {
                bVar.f2208b = true;
                bVar.f2207a = true;
            } else if (haVar2 == null && bVar.f2209c == 0) {
                bVar.f2208b = false;
                bVar.f2207a = true;
            }
        } else {
            if (bVar.f2209c == bVar.f2210d && bVar.f2211e == bVar.f2212f) {
                return bVar;
            }
            int i = bVar.f2209c;
            int i2 = bVar.f2210d;
            if (i != i2) {
                if (i == 0) {
                    bVar.f2208b = false;
                    bVar.f2207a = true;
                } else if (i2 == 0) {
                    bVar.f2208b = true;
                    bVar.f2207a = true;
                }
            } else if (bVar.f2212f == null) {
                bVar.f2208b = false;
                bVar.f2207a = true;
            } else if (bVar.f2211e == null) {
                bVar.f2208b = true;
                bVar.f2207a = true;
            }
        }
        return bVar;
    }

    private void d(ha haVar) {
        haVar.f2246a.put("android:visibility:visibility", Integer.valueOf(haVar.f2247b.getVisibility()));
        haVar.f2246a.put("android:visibility:parent", haVar.f2247b.getParent());
        int[] iArr = new int[2];
        haVar.f2247b.getLocationOnScreen(iArr);
        haVar.f2246a.put("android:visibility:screenLocation", iArr);
    }

    public Animator a(ViewGroup viewGroup, View view, ha haVar, ha haVar2) {
        return null;
    }

    public void a(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.L = i;
    }

    public Animator b(ViewGroup viewGroup, View view, ha haVar, ha haVar2) {
        return null;
    }

    @Override // androidx.transition.Transition
    public void c(ha haVar) {
        d(haVar);
    }

    @Override // androidx.transition.Transition
    public String[] n() {
        return K;
    }

    public int q() {
        return this.L;
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = 3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X.f2217e);
        int iB = androidx.core.content.a.i.b(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (iB != 0) {
            a(iB);
        }
    }

    @Override // androidx.transition.Transition
    public void a(ha haVar) {
        d(haVar);
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ha haVar, ha haVar2) {
        b bVarB = b(haVar, haVar2);
        if (!bVarB.f2207a) {
            return null;
        }
        if (bVarB.f2211e == null && bVarB.f2212f == null) {
            return null;
        }
        if (bVarB.f2208b) {
            return a(viewGroup, haVar, bVarB.f2209c, haVar2, bVarB.f2210d);
        }
        return b(viewGroup, haVar, bVarB.f2209c, haVar2, bVarB.f2210d);
    }

    public Animator a(ViewGroup viewGroup, ha haVar, int i, ha haVar2, int i2) {
        if ((this.L & 1) != 1 || haVar2 == null) {
            return null;
        }
        if (haVar == null) {
            View view = (View) haVar2.f2247b.getParent();
            if (b(a(view, false), b(view, false)).f2207a) {
                return null;
            }
        }
        return a(viewGroup, haVar2.f2247b, haVar, haVar2);
    }

    @Override // androidx.transition.Transition
    public boolean a(ha haVar, ha haVar2) {
        if (haVar == null && haVar2 == null) {
            return false;
        }
        if (haVar != null && haVar2 != null && haVar2.f2246a.containsKey("android:visibility:visibility") != haVar.f2246a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b bVarB = b(haVar, haVar2);
        if (bVarB.f2207a) {
            return bVarB.f2209c == 0 || bVarB.f2210d == 0;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator b(android.view.ViewGroup r10, androidx.transition.ha r11, int r12, androidx.transition.ha r13, int r14) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.b(android.view.ViewGroup, androidx.transition.ha, int, androidx.transition.ha, int):android.animation.Animator");
    }
}
