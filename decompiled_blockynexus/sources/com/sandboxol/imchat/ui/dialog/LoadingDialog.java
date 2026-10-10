package com.sandboxol.imchat.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.R;
import com.sandboxol.messager.MessagerClient;
import com.sandboxol.messager.a.a;

/* JADX INFO: loaded from: classes4.dex */
public class LoadingDialog extends FullScreenDialog {
    private Context context;
    private AnimationDrawable loadingAnim;

    public LoadingDialog(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeDialog() {
        if (isShowing()) {
            Context context = this.context;
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
            if (this.loadingAnim.isRunning()) {
                this.loadingAnim.stop();
            }
            MessagerClient.getIns().unRegisterMsg(getClass());
            super.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(Context context) {
        super.init(context);
        this.context = context;
        setContentView(R.layout.dialog_app_loading);
        this.loadingAnim = (AnimationDrawable) ((ImageView) findViewById(R.id.ivLoading)).getBackground();
        if (!this.loadingAnim.isRunning()) {
            this.loadingAnim.start();
        }
        MessagerClient.getIns().registerMsg0(LoadingDialog.class, "test.sandboxol.blockymods.close.loading.dialog", new a() { // from class: com.sandboxol.imchat.ui.dialog.LoadingDialog.1
            @Override // com.sandboxol.messager.a.a
            public void onCall() {
                LoadingDialog.this.closeDialog();
            }
        });
        MessagerClient.getIns().registerMsg0(LoadingDialog.class, "com.disabmgo.blockynexus.close.loading.dialog", new a() { // from class: com.sandboxol.imchat.ui.dialog.LoadingDialog.2
            @Override // com.sandboxol.messager.a.a
            public void onCall() {
                LoadingDialog.this.closeDialog();
            }
        });
    }
}
