package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: renamed from: androidx.appcompat.widget.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatHintHelper.java */
/* JADX INFO: loaded from: classes.dex */
class C0306t {
    static InputConnection a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                }
                if (parent instanceof ua) {
                    editorInfo.hintText = ((ua) parent).a();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return inputConnection;
    }
}
