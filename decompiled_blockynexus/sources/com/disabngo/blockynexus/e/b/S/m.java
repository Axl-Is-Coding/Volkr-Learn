package com.disabngo.blockynexus.e.b.S;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AllGameIdInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;

/* JADX INFO: compiled from: PartyCreateItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends ListItemViewModel<AllGameIdInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<AllGameIdInfo> f9420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f9421b;

    public m(Context context, AllGameIdInfo allGameIdInfo, ObservableField<AllGameIdInfo> observableField, AllGameIdInfo allGameIdInfo2) {
        super(context, allGameIdInfo);
        this.f9421b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.S.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9409a.f();
            }
        });
        this.f9420a = observableField;
        if (TextUtils.equals(allGameIdInfo2.getGameId(), allGameIdInfo.getGameId())) {
            observableField.set(allGameIdInfo2);
        }
    }

    public /* synthetic */ void f() {
        Messenger.getDefault().send(this.item, MessageToken.PARTY_CHOOSE_GAME);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public AllGameIdInfo getItem() {
        return (AllGameIdInfo) super.getItem();
    }
}
