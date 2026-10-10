package com.sandboxol.decorate.view.fragment.dress;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class DressSuitExtraItemViewModel extends ListItemViewModel<SuitDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Long> f17383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f17384b;

    public DressSuitExtraItemViewModel(Context context, SuitDressInfo suitDressInfo) {
        super(context, suitDressInfo);
        this.f17383a = new ObservableField<>();
        this.f17384b = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.j
            @Override // rx.functions.Action0
            public final void call() {
                this.f17433a.onClick();
            }
        });
        this.f17383a.set(Long.valueOf(suitDressInfo.getSuitId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick() {
        if (this.f17383a.get().longValue() == -1) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_SWITCH_TO_SHOP);
        }
    }
}
