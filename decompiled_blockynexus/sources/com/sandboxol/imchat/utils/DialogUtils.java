package com.sandboxol.imchat.utils;

import android.content.Context;
import com.sandboxol.imchat.ui.dialog.LoadingDialog;

/* JADX INFO: loaded from: classes4.dex */
public class DialogUtils {
    private static DialogUtils instant;
    private LoadingDialog loadingDialog;

    public static DialogUtils newsInstant() {
        if (instant == null) {
            instant = new DialogUtils();
        }
        return instant;
    }

    public void hideLoadingDialog() {
        LoadingDialog loadingDialog = this.loadingDialog;
        if (loadingDialog != null && loadingDialog.isShowing()) {
            this.loadingDialog.cancel();
        }
        this.loadingDialog = null;
    }

    public void showLoadingDialog(Context context) {
        if (this.loadingDialog != null || context == null) {
            return;
        }
        this.loadingDialog = new LoadingDialog(context);
        this.loadingDialog.show();
    }
}
