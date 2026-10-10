package com.sandboxol.vip.d.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.vip.R;
import com.sandboxol.vip.b.g;
import rx.functions.Action0;

/* JADX INFO: compiled from: SubscribeHelpDialog.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f19066a;

    public d(Context context) {
        super(context);
        this.f19066a = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.d.a.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f19042a.dismiss();
            }
        });
        initView();
    }

    public void initView() {
        super.init(this.context);
        g gVar = (g) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.vip_dialog_subscribe_help, (ViewGroup) null, false);
        setContentView(gVar.getRoot());
        gVar.a(this);
    }
}
