package com.disabngo.blockynexus.view.dialog;

import android.view.View;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: loaded from: classes2.dex */
public class OneButtonLoginDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private onClickListener f11333a;

    public interface onClickListener {
        void onClick();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btnSure) {
            if (id != R.id.rlBg) {
                return;
            }
            dismiss();
        } else {
            onClickListener onclicklistener = this.f11333a;
            if (onclicklistener != null) {
                onclicklistener.onClick();
            }
            dismiss();
        }
    }
}
