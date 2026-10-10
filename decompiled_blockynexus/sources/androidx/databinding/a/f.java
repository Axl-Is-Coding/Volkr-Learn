package androidx.databinding.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: ViewBindingAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
