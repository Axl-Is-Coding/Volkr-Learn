package com.disabngo.blockynexus.view.fragment.tribeno;

import android.content.Context;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRecommendation;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeNoItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends ListItemViewModel<TribeRecommendation> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f12039c;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Context context, TribeRecommendation tribeRecommendation) {
        super(context, tribeRecommendation);
        this.f12037a = this.context.getString(R.string.tribe_chief_recommend, ((TribeRecommendation) this.item).getChiefNickName());
        this.f12038b = this.context.getString(R.string.tribe_recommend_member_count, Integer.valueOf(((TribeRecommendation) this.item).getCurrentCount()), Integer.valueOf(((TribeRecommendation) this.item).getMaxCount()));
        this.f12039c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribeno.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f12026a.f();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        Bundle bundle = new Bundle();
        bundle.putLong("tribe.clan.id", ((TribeRecommendation) this.item).getClanId());
        bundle.putString(StringConstant.TRIBE_DETAIL_ENTER_TYPE, "recommend");
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ma.e.class, context.getString(R.string.tribe_detail), bundle);
        ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_DETAIL_PAGE, "recommend");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public TribeRecommendation getItem() {
        return (TribeRecommendation) super.getItem();
    }
}
