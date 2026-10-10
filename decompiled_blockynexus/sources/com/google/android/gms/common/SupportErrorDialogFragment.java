package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class SupportErrorDialogFragment extends DialogInterfaceOnCancelListenerC0327e {
    private Dialog mDialog = null;
    private DialogInterface.OnCancelListener zaan = null;

    public static SupportErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, null);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.zaan;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.mDialog == null) {
            setShowsDialog(false);
        }
        return this.mDialog;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e
    public void show(AbstractC0336n abstractC0336n, String str) {
        super.show(abstractC0336n, str);
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.mDialog = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.zaan = onCancelListener;
        }
        return supportErrorDialogFragment;
    }
}
