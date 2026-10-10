package com.sandboxol.vip.d.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.vip.R;
import com.sandboxol.vip.b.i;
import rx.functions.Action0;

/* JADX INFO: compiled from: SubscribeRuleDialog.java */
/* JADX INFO: loaded from: classes4.dex */
public class e extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f19067a;

    public e(Context context) {
        super(context);
        this.f19067a = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.d.a.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f19065a.dismiss();
            }
        });
        initView();
    }

    public void initView() {
        super.init(this.context);
        i iVar = (i) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.vip_dialog_subscribe_rules, (ViewGroup) null, false);
        setContentView(iVar.getRoot());
        iVar.a(this);
    }
}
