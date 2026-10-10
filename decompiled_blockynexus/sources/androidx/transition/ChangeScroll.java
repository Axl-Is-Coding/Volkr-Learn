package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ChangeScroll extends Transition {
    private static final String[] K = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    private void d(ha haVar) {
        haVar.f2246a.put("android:changeScroll:x", Integer.valueOf(haVar.f2247b.getScrollX()));
        haVar.f2246a.put("android:changeScroll:y", Integer.valueOf(haVar.f2247b.getScrollY()));
    }

    @Override // androidx.transition.Transition
    public void a(ha haVar) {
        d(haVar);
    }

    @Override // androidx.transition.Transition
    public void c(ha haVar) {
        d(haVar);
    }

    @Override // androidx.transition.Transition
    public String[] n() {
        return K;
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ha haVar, ha haVar2) {
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfInt2 = null;
        if (haVar == null || haVar2 == null) {
            return null;
        }
        View view = haVar2.f2247b;
        int iIntValue = ((Integer) haVar.f2246a.get("android:changeScroll:x")).intValue();
        int iIntValue2 = ((Integer) haVar2.f2246a.get("android:changeScroll:x")).intValue();
        int iIntValue3 = ((Integer) haVar.f2246a.get("android:changeScroll:y")).intValue();
        int iIntValue4 = ((Integer) haVar2.f2246a.get("android:changeScroll:y")).intValue();
        if (iIntValue != iIntValue2) {
            view.setScrollX(iIntValue);
            objectAnimatorOfInt = ObjectAnimator.ofInt(view, "scrollX", iIntValue, iIntValue2);
        } else {
            objectAnimatorOfInt = null;
        }
        if (iIntValue3 != iIntValue4) {
            view.setScrollY(iIntValue3);
            objectAnimatorOfInt2 = ObjectAnimator.ofInt(view, "scrollY", iIntValue3, iIntValue4);
        }
        return C0389ga.a(objectAnimatorOfInt, objectAnimatorOfInt2);
    }
}
