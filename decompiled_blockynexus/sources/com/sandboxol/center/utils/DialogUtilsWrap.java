package com.sandboxol.center.utils;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class DialogUtilsWrap {
    private static DialogUtilsWrap instant = new DialogUtilsWrap();
    private DialogUtilsImpl dialogUtils;

    public static DialogUtilsWrap newsInstant() {
        return instant;
    }

    public void hideLoadingDialog() {
        DialogUtilsImpl dialogUtilsImpl = this.dialogUtils;
        if (dialogUtilsImpl != null) {
            dialogUtilsImpl.hideLoadingDialog();
        }
    }

    public void setImpl(DialogUtilsImpl dialogUtilsImpl) {
        this.dialogUtils = dialogUtilsImpl;
    }

    public void showLoadingDialog(Context context) {
        DialogUtilsImpl dialogUtilsImpl = this.dialogUtils;
        if (dialogUtilsImpl == null || context == null) {
            return;
        }
        dialogUtilsImpl.showLoadingDialog(context);
    }
}
