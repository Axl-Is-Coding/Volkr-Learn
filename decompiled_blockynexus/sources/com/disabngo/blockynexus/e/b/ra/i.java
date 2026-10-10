package com.disabngo.blockynexus.e.b.ra;

import android.content.Context;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRank;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeRankPageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends ListItemViewModel<TribeRank> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f10135a;

    public i(Context context, TribeRank tribeRank) {
        super(context, tribeRank);
        this.f10135a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ra.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f10128a.f();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        Bundle bundle = new Bundle();
        bundle.putLong("tribe.clan.id", ((TribeRank) this.item).getClanId());
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ma.e.class, context.getString(R.string.tribe_detail), bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public TribeRank getItem() {
        return (TribeRank) super.getItem();
    }
}
