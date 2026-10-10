package io.rong.imkit.widget;

import android.view.View;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e;

/* JADX INFO: loaded from: classes5.dex */
public class BaseDialogFragment extends DialogInterfaceOnCancelListenerC0327e {
    protected <T extends View> T getView(View view, int i) {
        return (T) view.findViewById(i);
    }
}
