package com.disabngo.blockynexus.view.dialog;

import android.view.View;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: loaded from: classes2.dex */
public class BuyGameDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnTwoButtonDialogClickListener f11267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f11268b;

    public interface OnTwoButtonDialogClickListener {
        void onClick();
    }

    public interface a {
        void onLeftClick();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnCancel) {
            dismiss();
            a aVar = this.f11268b;
            if (aVar != null) {
                aVar.onLeftClick();
                return;
            }
            return;
        }
        if (id != R.id.btnSure) {
            return;
        }
        dismiss();
        OnTwoButtonDialogClickListener onTwoButtonDialogClickListener = this.f11267a;
        if (onTwoButtonDialogClickListener != null) {
            onTwoButtonDialogClickListener.onClick();
        }
    }
}
