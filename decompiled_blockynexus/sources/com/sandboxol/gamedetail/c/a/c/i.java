package com.sandboxol.gamedetail.c.a.c;

import android.content.Context;
import com.sandboxol.center.entity.CampaignRank;
import com.sandboxol.center.router.manager.FriendManager;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: compiled from: GameDetailRankPageItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends ListItemViewModel<CampaignRank> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f18086a;

    public i(Context context, CampaignRank campaignRank) {
        super(context, campaignRank);
        this.f18086a = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.c.a.c.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18077a.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        FriendManager.getFriendDataAndEnterFriendInfo(this.context, null, ((CampaignRank) this.item).getUserId());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public CampaignRank getItem() {
        return (CampaignRank) super.getItem();
    }
}
