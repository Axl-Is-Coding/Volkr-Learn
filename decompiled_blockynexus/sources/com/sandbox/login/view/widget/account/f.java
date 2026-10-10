package com.sandbox.login.view.widget.account;

import android.content.Context;
import com.sandbox.login.entity.UserRecord;
import com.sandbox.login.f.a.e.q;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;

/* JADX INFO: compiled from: AccountSelectItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends ListItemViewModel<UserRecord> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f16006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f16007b;

    public f(Context context, UserRecord userRecord) {
        super(context, userRecord);
        this.f16006a = new ReplyCommand(new Action0() { // from class: com.sandbox.login.view.widget.account.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f16003a.f();
            }
        });
        this.f16007b = new ReplyCommand(new Action0() { // from class: com.sandbox.login.view.widget.account.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f16002a.h();
            }
        });
    }

    public /* synthetic */ void f() {
        Messenger.getDefault().send(getItem(), "token.click.account.item");
        ReportDataAdapter.onEvent(this.context, EventConstant.CHOSE_AVAILABLE_ID);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void h() {
        new q().a(this.context, (UserRecord) this.item, true);
    }
}
