package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EL extends AbstractC1929Si {
    public static TimeInterpolator A0B;
    public static String[] A0C;
    public ArrayList<C4W> A0A = new ArrayList<>();
    public ArrayList<C4W> A07 = new ArrayList<>();
    public ArrayList<C13273m> A09 = new ArrayList<>();
    public ArrayList<C13263l> A08 = new ArrayList<>();
    public ArrayList<ArrayList<C4W>> A01 = new ArrayList<>();
    public ArrayList<ArrayList<C13273m>> A05 = new ArrayList<>();
    public ArrayList<ArrayList<C13263l>> A03 = new ArrayList<>();
    public ArrayList<C4W> A00 = new ArrayList<>();
    public ArrayList<C4W> A04 = new ArrayList<>();
    public ArrayList<C4W> A06 = new ArrayList<>();
    public ArrayList<C4W> A02 = new ArrayList<>();

    static {
        A01();
    }

    public static void A01() {
        A0C = new String[]{"K3xavpXOVVnTPS8V8FmisIpuez1NdmFn", "QjoCrUVtXYT15qNhmppxWCsnlOvXMRWn", "HVYav4KnfeU3lAWSFDiSVAYelCZD7hW1", "SKhwmHHGUoQzTLK2kw5WKB1efbL3jYLm", "aZpNXGptJoOcjVlsPlgA0RFw1bcc4fI1", "y8DDj9eTKGlZyxtiH83YwnquX80t2qUq", "Eqht3urb", "PkOCx2w9GPXTa0iGANdHxOJetOGxrMw0"};
    }

    private void A02(C13263l c13263l) {
        if (c13263l.A05 != null) {
            A07(c13263l, c13263l.A05);
        }
        if (c13263l.A04 != null) {
            A07(c13263l, c13263l.A04);
        }
    }

    private void A03(final C4W c4w) {
        final View view = c4w.A0H;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.A06.add(c4w);
        viewPropertyAnimatorAnimate.setDuration(A06()).alpha(WheelView.DividerConfig.FILL).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.3g
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                this.A02.A0Q(c4w);
                this.A02.A06.remove(c4w);
                this.A02.A0Y();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                this.A02.A0R(c4w);
            }
        }).start();
    }

    private void A04(C4W c4w) {
        if (A0B == null) {
            A0B = new ValueAnimator().getInterpolator();
        }
        c4w.A0H.animate().setInterpolator(A0B);
        A0E(c4w);
    }

    private final void A05(List<C4W> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).A0H.animate().cancel();
        }
    }

    private void A06(List<C13263l> list, C4W c4w) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C13263l c13263l = list.get(size);
            if (A07(c13263l, c4w) && c13263l.A05 == null && c13263l.A04 == null) {
                list.remove(c13263l);
            }
        }
    }

    private boolean A07(C13263l c13263l, C4W c4w) {
        boolean z = false;
        if (c13263l.A04 == c4w) {
            c13263l.A04 = null;
        } else if (c13263l.A05 == c4w) {
            c13263l.A05 = null;
            z = true;
        } else {
            return false;
        }
        c4w.A0H.setAlpha(1.0f);
        c4w.A0H.setTranslationX(WheelView.DividerConfig.FILL);
        c4w.A0H.setTranslationY(WheelView.DividerConfig.FILL);
        A0S(c4w, z);
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.C4A
    public final void A0C() {
        for (int size = this.A09.size() - 1; size >= 0; size--) {
            C13273m c13273m = this.A09.get(size);
            View view = c13273m.A04.A0H;
            view.setTranslationY(WheelView.DividerConfig.FILL);
            view.setTranslationX(WheelView.DividerConfig.FILL);
            A0O(c13273m.A04);
            this.A09.remove(size);
        }
        for (int size2 = this.A0A.size() - 1; size2 >= 0; size2--) {
            A0Q(this.A0A.get(size2));
            this.A0A.remove(size2);
        }
        for (int size3 = this.A07.size() - 1; size3 >= 0; size3--) {
            C4W c4w = this.A07.get(size3);
            c4w.A0H.setAlpha(1.0f);
            A0M(c4w);
            this.A07.remove(size3);
        }
        for (int size4 = this.A08.size() - 1; size4 >= 0; size4--) {
            A02(this.A08.get(size4));
        }
        this.A08.clear();
        if (!A0F()) {
            return;
        }
        int listCount = this.A05.size();
        for (int i = listCount - 1; i >= 0; i--) {
            ArrayList<C13273m> arrayList = this.A05.get(i);
            int listCount2 = arrayList.size();
            for (int i2 = listCount2 - 1; i2 >= 0; i2--) {
                C13273m moveInfo = arrayList.get(i2);
                View view2 = moveInfo.A04.A0H;
                view2.setTranslationY(WheelView.DividerConfig.FILL);
                view2.setTranslationX(WheelView.DividerConfig.FILL);
                A0O(moveInfo.A04);
                arrayList.remove(i2);
                if (arrayList.isEmpty()) {
                    this.A05.remove(arrayList);
                }
            }
        }
        for (int size5 = this.A01.size() - 1; size5 >= 0; size5--) {
            ArrayList<C4W> arrayList2 = this.A01.get(size5);
            int i3 = arrayList2.size();
            for (int i4 = i3 - 1; i4 >= 0; i4--) {
                C4W item = arrayList2.get(i4);
                item.A0H.setAlpha(1.0f);
                A0M(item);
                arrayList2.remove(i4);
                if (arrayList2.isEmpty()) {
                    this.A01.remove(arrayList2);
                }
            }
        }
        for (int size6 = this.A03.size() - 1; size6 >= 0; size6--) {
            ArrayList<C13263l> arrayList3 = this.A03.get(size6);
            int j = arrayList3.size();
            for (int i5 = j - 1; i5 >= 0; i5--) {
                A02(arrayList3.get(i5));
                if (arrayList3.isEmpty()) {
                    this.A03.remove(arrayList3);
                }
            }
        }
        A05(this.A06);
        A05(this.A04);
        A05(this.A00);
        A05(this.A02);
        A09();
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x0033 */
    @Override // com.facebook.ads.redexgen.X.C4A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0D() {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EL.A0D():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00db, code lost:
    
        r5 = r5 - 1;
     */
    @Override // com.facebook.ads.redexgen.X.C4A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0E(com.facebook.ads.redexgen.X.C4W r10) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EL.A0E(com.facebook.ads.redexgen.X.4W):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    @Override // com.facebook.ads.redexgen.X.C4A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0F() {
        /*
            r4 = this;
            java.util.ArrayList<com.facebook.ads.redexgen.X.4W> r0 = r4.A07
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lc2
            java.util.ArrayList<com.facebook.ads.redexgen.X.3l> r0 = r4.A08
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lc2
            java.util.ArrayList<com.facebook.ads.redexgen.X.3m> r0 = r4.A09
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lc2
            java.util.ArrayList<com.facebook.ads.redexgen.X.4W> r0 = r4.A0A
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lc2
            java.util.ArrayList<com.facebook.ads.redexgen.X.4W> r0 = r4.A04
            boolean r3 = r0.isEmpty()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EL.A0C
            r0 = 2
            r1 = r2[r0]
            r0 = 5
            r2 = r2[r0]
            r0 = 18
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto Laa
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EL.A0C
            java.lang.String r1 = "HATKbuX1ioRbKjbJza4uRkbMkwnilInw"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "55W5G9gSwoJRpeM2nuMk9rdzPBhIsXI5"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto Lc2
            java.util.ArrayList<com.facebook.ads.redexgen.X.4W> r0 = r4.A06
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lc2
            java.util.ArrayList<com.facebook.ads.redexgen.X.4W> r0 = r4.A00
            boolean r3 = r0.isEmpty()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EL.A0C
            r0 = 2
            r1 = r2[r0]
            r0 = 5
            r2 = r2[r0]
            r0 = 18
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto La7
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EL.A0C
            java.lang.String r1 = "PBqWGImhwZdo7IXQpaNFK9QlBHxMp4wk"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "PBqWGImhwZdo7IXQpaNFK9QlBHxMp4wk"
            r0 = 7
            r2[r0] = r1
            if (r3 == 0) goto Lc2
        L78:
            java.util.ArrayList<com.facebook.ads.redexgen.X.4W> r0 = r4.A02
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lc2
            java.util.ArrayList<java.util.ArrayList<com.facebook.ads.redexgen.X.3m>> r0 = r4.A05
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lc2
            java.util.ArrayList<java.util.ArrayList<com.facebook.ads.redexgen.X.4W>> r0 = r4.A01
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lc2
            java.util.ArrayList<java.util.ArrayList<com.facebook.ads.redexgen.X.3l>> r3 = r4.A03
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.EL.A0C
            r0 = 7
            r1 = r1[r0]
            r0 = 30
            char r1 = r1.charAt(r0)
            r0 = 119(0x77, float:1.67E-43)
            if (r1 == r0) goto Lb0
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        La7:
            if (r3 == 0) goto Lc2
            goto L78
        Laa:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        Lb0:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EL.A0C
            java.lang.String r1 = "80rjjAfjuSoUPBYOWBOUrC4mhnJBtDwK"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "80rjjAfjuSoUPBYOWBOUrC4mhnJBtDwK"
            r0 = 7
            r2[r0] = r1
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto Lc4
        Lc2:
            r0 = 1
        Lc3:
            return r0
        Lc4:
            r0 = 0
            goto Lc3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EL.A0F():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.C4A
    public final boolean A0G(@NonNull C4W c4w, @NonNull List<Object> list) {
        return !list.isEmpty() || super.A0G(c4w, list);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1929Si
    public final boolean A0U(C4W c4w) {
        A04(c4w);
        c4w.A0H.setAlpha(WheelView.DividerConfig.FILL);
        this.A07.add(c4w);
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1929Si
    public final boolean A0V(C4W c4w) {
        A04(c4w);
        this.A0A.add(c4w);
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1929Si
    public final boolean A0W(C4W c4w, int i, int i2, int i3, int i4) {
        View view = c4w.A0H;
        int deltaY = i + ((int) c4w.A0H.getTranslationX());
        int fromX = (int) c4w.A0H.getTranslationY();
        int i5 = i2 + fromX;
        A04(c4w);
        int fromY = i3 - deltaY;
        int i6 = i4 - i5;
        if (fromY == 0 && i6 == 0) {
            A0O(c4w);
            return false;
        }
        if (fromY != 0) {
            int deltaX = -fromY;
            view.setTranslationX(deltaX);
        }
        if (i6 != 0) {
            int deltaX2 = -i6;
            view.setTranslationY(deltaX2);
        }
        this.A09.add(new C13273m(c4w, deltaY, i5, i3, i4));
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1929Si
    public final boolean A0X(C4W c4w, C4W c4w2, int deltaX, int deltaY, int i, int i2) {
        if (c4w == c4w2) {
            return A0W(c4w, deltaX, deltaY, i, i2);
        }
        float translationX = c4w.A0H.getTranslationX();
        float translationY = c4w.A0H.getTranslationY();
        float alpha = c4w.A0H.getAlpha();
        A04(c4w);
        int i3 = (int) ((i - deltaX) - translationX);
        int i4 = (int) ((i2 - deltaY) - translationY);
        c4w.A0H.setTranslationX(translationX);
        c4w.A0H.setTranslationY(translationY);
        c4w.A0H.setAlpha(alpha);
        if (c4w2 != null) {
            A04(c4w2);
            c4w2.A0H.setTranslationX(-i3);
            c4w2.A0H.setTranslationY(-i4);
            c4w2.A0H.setAlpha(WheelView.DividerConfig.FILL);
        }
        this.A08.add(new C13263l(c4w, c4w2, deltaX, deltaY, i, i2));
        return true;
    }

    public final void A0Y() {
        if (!A0F()) {
            A09();
        }
    }

    public final void A0Z(final C13263l c13263l) {
        final View view;
        C4W c4w = c13263l.A05;
        if (c4w == null) {
            view = null;
        } else {
            view = c4w.A0H;
        }
        C4W c4w2 = c13263l.A04;
        final View view2 = c4w2 != null ? c4w2.A0H : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(A04());
            this.A02.add(c13263l.A05);
            duration.translationX(c13263l.A02 - c13263l.A00);
            duration.translationY(c13263l.A03 - c13263l.A01);
            ViewPropertyAnimator oldViewAnim = duration.alpha(WheelView.DividerConfig.FILL).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.3j
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(WheelView.DividerConfig.FILL);
                    view.setTranslationY(WheelView.DividerConfig.FILL);
                    this.A03.A0S(c13263l.A05, true);
                    this.A03.A02.remove(c13263l.A05);
                    this.A03.A0Y();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    this.A03.A0T(c13263l.A05, true);
                }
            });
            oldViewAnim.start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.A02.add(c13263l.A04);
            ViewPropertyAnimator newViewAnimation = viewPropertyAnimatorAnimate.translationX(WheelView.DividerConfig.FILL);
            newViewAnimation.translationY(WheelView.DividerConfig.FILL).setDuration(A04()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.3k
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(WheelView.DividerConfig.FILL);
                    view2.setTranslationY(WheelView.DividerConfig.FILL);
                    this.A03.A0S(c13263l.A04, false);
                    this.A03.A02.remove(c13263l.A04);
                    this.A03.A0Y();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    this.A03.A0T(c13263l.A04, false);
                }
            }).start();
        }
    }

    public final void A0a(final C4W c4w) {
        final View view = c4w.A0H;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.A00.add(c4w);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(A03()).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.3h
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                this.A02.A0M(c4w);
                this.A02.A00.remove(c4w);
                this.A02.A0Y();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                this.A02.A0N(c4w);
            }
        }).start();
    }

    public final void A0b(final C4W c4w, int i, int i2, int i3, int deltaX) {
        final View view = c4w.A0H;
        final int i4 = i3 - i;
        final int deltaX2 = deltaX - i2;
        if (i4 != 0) {
            view.animate().translationX(WheelView.DividerConfig.FILL);
        }
        if (deltaX2 != 0) {
            view.animate().translationY(WheelView.DividerConfig.FILL);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.A04.add(c4w);
        ViewPropertyAnimator animation = viewPropertyAnimatorAnimate.setDuration(A05());
        animation.setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.3i
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                if (i4 != 0) {
                    view.setTranslationX(WheelView.DividerConfig.FILL);
                }
                if (deltaX2 != 0) {
                    view.setTranslationY(WheelView.DividerConfig.FILL);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                this.A04.A0O(c4w);
                this.A04.A04.remove(c4w);
                this.A04.A0Y();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                this.A04.A0P(c4w);
            }
        }).start();
    }
}
