package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: GhostViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
class G {
    static B a(View view, ViewGroup viewGroup, Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? D.a(view, viewGroup, matrix) : F.a(view, viewGroup, matrix);
    }

    static void a(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            D.a(view);
        } else {
            F.b(view);
        }
    }
}
