package com.disabngo.blockynexus.view.dialog;

import android.view.View;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: loaded from: classes2.dex */
public class ReceiveAttachmentSuccessDialog extends FullScreenDialog implements View.OnClickListener {

    public class a extends ViewModel {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.disabngo.blockynexus.e.b.X.a f11360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.disabngo.blockynexus.view.fragment.inboxdetail.e f11361b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.btnSure) {
            return;
        }
        dismiss();
    }
}
