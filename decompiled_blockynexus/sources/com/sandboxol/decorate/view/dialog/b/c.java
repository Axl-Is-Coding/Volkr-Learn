package com.sandboxol.decorate.view.dialog.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.c.AbstractC2592q;
import com.sandboxol.decorate.entity.DressExpireInfo;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: DressExpiredDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<DressExpireInfo> f17362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f17363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f17364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f17365d;

    public c(Context context, List<DressExpireInfo> list) {
        super(context);
        this.f17363b = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.dialog.b.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f17361a.dismiss();
            }
        });
        this.f17364c = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.dialog.b.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f17360a.a();
            }
        });
        this.f17362a = list;
        initView();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_SWITCH_TO_SHOP);
        dismiss();
    }

    private void initData() {
        this.f17365d = new e(this.context, R.string.no_data, this.f17362a);
    }

    private void initView() {
        AbstractC2592q abstractC2592q = (AbstractC2592q) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_dress_expired, (ViewGroup) null, false);
        abstractC2592q.a(this);
        setContentView(abstractC2592q.getRoot());
    }
}
