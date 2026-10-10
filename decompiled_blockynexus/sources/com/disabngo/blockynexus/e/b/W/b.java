package com.disabngo.blockynexus.e.b.W;

import android.content.Context;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.ma.e;
import com.disabngo.blockynexus.e.b.x.K;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.RankInfoResponse;
import rx.functions.Action0;

/* JADX INFO: compiled from: RankPageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends ListItemViewModel<RankInfoResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f9504a;

    public b(Context context, RankInfoResponse rankInfoResponse) {
        super(context, rankInfoResponse);
        this.f9504a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.W.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9466a.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        if (!"clan".equals(((RankInfoResponse) this.item).getRankType())) {
            K.a(this.context, null, new FriendActivityIntentInfo(((RankInfoResponse) this.item).getId(), ((RankInfoResponse) this.item).getId() == AccountCenter.newInstance().userId.get().longValue() ? 4 : 2));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("tribe.clan.id", ((RankInfoResponse) this.item).getId());
        Context context = this.context;
        TemplateUtils.startTemplate(context, e.class, context.getString(R.string.tribe_detail), bundle);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public RankInfoResponse getItem() {
        return (RankInfoResponse) super.getItem();
    }
}
