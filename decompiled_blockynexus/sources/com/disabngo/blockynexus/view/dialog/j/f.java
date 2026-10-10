package com.disabngo.blockynexus.view.dialog.j;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: compiled from: LatelyGameLoadingDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimationDrawable f11617a;
    private Context context;

    public f(Context context) {
        super(context);
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (this.f11617a.isRunning()) {
                this.f11617a.stop();
            }
            super.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(Context context) {
        super.init(context);
        this.context = context;
        setContentView(R.layout.common_dialog_app_loading);
        this.f11617a = (AnimationDrawable) ((ImageView) findViewById(R.id.ivLoading)).getBackground();
        if (this.f11617a.isRunning()) {
            return;
        }
        this.f11617a.start();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        if (isShowing()) {
            dismiss();
        }
    }
}
