package com.sandboxol.common.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import com.sandboxol.common.R;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: loaded from: classes3.dex */
public class LoadingDialog extends FullScreenDialog {
    private Context context;
    private AnimationDrawable loadingAnim;

    public LoadingDialog(Context context) {
        super(context);
    }

    public /* synthetic */ void a(Context context) {
        if (isShowing()) {
            if (!(context instanceof Activity)) {
                dismiss();
            } else {
                if (((Activity) context).isFinishing()) {
                    return;
                }
                dismiss();
            }
        }
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            Messenger.getDefault().unregister(this);
            MessagerClient.getIns().unRegisterMsg(getClass());
            if (this.loadingAnim.isRunning()) {
                this.loadingAnim.stop();
            }
            super.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(final Context context) {
        super.init(context);
        this.context = context;
        setContentView(R.layout.common_dialog_app_loading);
        this.loadingAnim = (AnimationDrawable) ((ImageView) findViewById(R.id.ivLoading)).getBackground();
        if (!this.loadingAnim.isRunning()) {
            this.loadingAnim.start();
        }
        MessagerClient.getIns().registerMsg0(LoadingDialog.class, CommonMessageToken.COMMON_CLOSE_LOADING_DIALOG, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.common.dialog.b
            @Override // com.sandboxol.messager.a.a
            public final void onCall() {
                this.f16902a.a(context);
            }
        });
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        if (isShowing()) {
            dismiss();
        }
    }
}
