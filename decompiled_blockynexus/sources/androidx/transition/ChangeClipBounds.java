package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ChangeClipBounds extends Transition {
    private static final String[] K = {"android:clipBounds:clip"};

    public ChangeClipBounds() {
    }

    private void d(ha haVar) {
        View view = haVar.f2247b;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect rectG = ViewCompat.g(view);
        haVar.f2246a.put("android:clipBounds:clip", rectG);
        if (rectG == null) {
            haVar.f2246a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
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

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ha haVar, ha haVar2) {
        ObjectAnimator objectAnimatorOfObject = null;
        if (haVar != null && haVar2 != null && haVar.f2246a.containsKey("android:clipBounds:clip") && haVar2.f2246a.containsKey("android:clipBounds:clip")) {
            Rect rect = (Rect) haVar.f2246a.get("android:clipBounds:clip");
            Rect rect2 = (Rect) haVar2.f2246a.get("android:clipBounds:clip");
            boolean z = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = (Rect) haVar.f2246a.get("android:clipBounds:bounds");
            } else if (rect2 == null) {
                rect2 = (Rect) haVar2.f2246a.get("android:clipBounds:bounds");
            }
            if (rect.equals(rect2)) {
                return null;
            }
            ViewCompat.a(haVar2.f2247b, rect);
            objectAnimatorOfObject = ObjectAnimator.ofObject(haVar2.f2247b, (Property<View, V>) va.f2302c, (TypeEvaluator) new N(new Rect()), (Object[]) new Rect[]{rect, rect2});
            if (z) {
                objectAnimatorOfObject.addListener(new C0395m(this, haVar2.f2247b));
            }
        }
        return objectAnimatorOfObject;
    }
}
