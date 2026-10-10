package com.sandboxol.decorate.view.fragment.dress;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class DressExtraItemViewModel extends ListItemViewModel<SingleDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Long> f17380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f17381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f17382c;

    public DressExtraItemViewModel(Context context, SingleDressInfo singleDressInfo, long j) {
        super(context, singleDressInfo);
        this.f17380a = new ObservableField<>(0L);
        this.f17381b = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f17406a.onClick();
            }
        });
        this.f17380a.set(Long.valueOf(singleDressInfo.getId()));
        this.f17382c = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick() {
        if (this.f17380a.get().longValue() == -1) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_SWITCH_TO_SHOP);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_ROOM_SHOP, String.valueOf(this.f17382c));
        } else if (this.f17380a.get().longValue() == -2) {
            com.sandboxol.decorate.manager.l.c().a(com.sandboxol.decorate.manager.v.a());
            Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type32");
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public SingleDressInfo getItem() {
        return (SingleDressInfo) super.getItem();
    }
}
