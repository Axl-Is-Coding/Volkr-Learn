package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e;

/* JADX INFO: compiled from: AppCompatDialogFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class y extends DialogInterfaceOnCancelListenerC0327e {
    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e
    public Dialog onCreateDialog(Bundle bundle) {
        return new x(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e
    public void setupDialog(Dialog dialog, int i) {
        if (!(dialog instanceof x)) {
            super.setupDialog(dialog, i);
            return;
        }
        x xVar = (x) dialog;
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        xVar.a(1);
    }
}
