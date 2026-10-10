package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes.dex */
public class Explode extends Visibility {
    private static final TimeInterpolator M = new DecelerateInterpolator();
    private static final TimeInterpolator N = new AccelerateInterpolator();
    private int[] O;

    public Explode() {
        this.O = new int[2];
        a(new C0402t());
    }

    private void e(ha haVar) {
        View view = haVar.f2247b;
        view.getLocationOnScreen(this.O);
        int[] iArr = this.O;
        int i = iArr[0];
        int i2 = iArr[1];
        haVar.f2246a.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void a(ha haVar) {
        super.a(haVar);
        e(haVar);
    }

    @Override // androidx.transition.Visibility
    public Animator b(ViewGroup viewGroup, View view, ha haVar, ha haVar2) {
        float f2;
        float f3;
        if (haVar == null) {
            return null;
        }
        Rect rect = (Rect) haVar.f2246a.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) haVar.f2247b.getTag(R.id.transition_position);
        if (iArr != null) {
            f2 = (iArr[0] - rect.left) + translationX;
            f3 = (iArr[1] - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f2 = translationX;
            f3 = translationY;
        }
        a(viewGroup, rect, this.O);
        int[] iArr2 = this.O;
        return ja.a(view, haVar, i, i2, translationX, translationY, f2 + iArr2[0], f3 + iArr2[1], N, this);
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
        Rect rect = (Rect) haVar2.f2246a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a(viewGroup, rect, this.O);
        int[] iArr = this.O;
        return ja.a(view, haVar2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, M, this);
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O = new int[2];
        a(new C0402t());
    }

    private void a(View view, Rect rect, int[] iArr) {
        int iCenterY;
        int width;
        view.getLocationOnScreen(this.O);
        int[] iArr2 = this.O;
        int i = iArr2[0];
        int i2 = iArr2[1];
        Rect rectD = d();
        if (rectD == null) {
            width = (view.getWidth() / 2) + i + Math.round(view.getTranslationX());
            iCenterY = (view.getHeight() / 2) + i2 + Math.round(view.getTranslationY());
        } else {
            int iCenterX = rectD.centerX();
            iCenterY = rectD.centerY();
            width = iCenterX;
        }
        float fCenterX = rect.centerX() - width;
        float fCenterY = rect.centerY() - iCenterY;
        if (fCenterX == WheelView.DividerConfig.FILL && fCenterY == WheelView.DividerConfig.FILL) {
            fCenterX = ((float) (Math.random() * 2.0d)) - 1.0f;
            fCenterY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float fA = a(fCenterX, fCenterY);
        float fA2 = a(view, width - i, iCenterY - i2);
        iArr[0] = Math.round((fCenterX / fA) * fA2);
        iArr[1] = Math.round(fA2 * (fCenterY / fA));
    }

    private static float a(View view, int i, int i2) {
        return a(Math.max(i, view.getWidth() - i), Math.max(i2, view.getHeight() - i2));
    }

    private static float a(float f2, float f3) {
        return (float) Math.sqrt((f2 * f2) + (f3 * f3));
    }
}
