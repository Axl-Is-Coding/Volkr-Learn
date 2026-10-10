package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: TooltipCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class na {
    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            qa.a(view, charSequence);
        }
    }
}
