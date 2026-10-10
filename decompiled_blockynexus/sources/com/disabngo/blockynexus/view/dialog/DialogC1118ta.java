package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0717sb;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import rx.functions.Action0;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.dialog.ta, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DownloadInfoDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class DialogC1118ta extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f11686a;

    public DialogC1118ta(Context context) {
        super(context);
        this.f11686a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f11553a.onClose();
            }
        });
        initView();
    }

    private void initView() {
        AbstractC0717sb abstractC0717sb = (AbstractC0717sb) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_download_info, (ViewGroup) null, false);
        abstractC0717sb.a(this);
        setContentView(abstractC0717sb.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClose() {
        dismiss();
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }
}
