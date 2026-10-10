package b.e.a.a.a.d;

import android.os.Build;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static float a(View view) {
        return Build.VERSION.SDK_INT >= 21 ? view.getZ() : WheelView.DividerConfig.FILL;
    }

    public static View b(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    public static boolean c(View view) {
        if ((Build.VERSION.SDK_INT >= 19 && !view.isAttachedToWindow()) || !view.isShown()) {
            return false;
        }
        while (view != null) {
            if (view.getAlpha() == WheelView.DividerConfig.FILL) {
                return false;
            }
            view = b(view);
        }
        return true;
    }

    public static boolean d(View view) {
        return e(view) == null;
    }

    public static String e(View view) {
        if (Build.VERSION.SDK_INT >= 19 && !view.isAttachedToWindow()) {
            return "notAttached";
        }
        int visibility = view.getVisibility();
        if (visibility != 0) {
            return visibility != 4 ? visibility != 8 ? "viewNotVisible" : "viewGone" : "viewInvisible";
        }
        if (view.getAlpha() == WheelView.DividerConfig.FILL) {
            return "viewAlphaZero";
        }
        return null;
    }
}
