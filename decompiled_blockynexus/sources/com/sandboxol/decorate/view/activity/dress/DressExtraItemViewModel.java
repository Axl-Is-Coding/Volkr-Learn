package com.sandboxol.decorate.view.activity.dress;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class DressExtraItemViewModel extends ListItemViewModel<SingleDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Long> f17224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f17225b;

    public DressExtraItemViewModel(Context context, SingleDressInfo singleDressInfo) {
        super(context, singleDressInfo);
        this.f17224a = new ObservableField<>();
        this.f17225b = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f17271a.onClick();
            }
        });
        this.f17224a.set(Long.valueOf(singleDressInfo.getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick() {
        if (this.f17224a.get() == null || this.f17224a.get().longValue() != -2) {
            return;
        }
        com.sandboxol.decorate.manager.l.d().a(com.sandboxol.decorate.manager.v.b());
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list32");
    }
}
