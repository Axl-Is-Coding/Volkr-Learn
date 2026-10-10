package com.disabngo.blockynexus.view.activity.tribesearch;

import android.content.Context;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.RequestJoinTribe;
import com.disabngo.blockynexus.entity.TribeRecommendation;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeSearchPageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ListItemViewModel<TribeRecommendation> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f11134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f11135b;

    public h(Context context, TribeRecommendation tribeRecommendation) {
        super(context, tribeRecommendation);
        this.f11134a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribesearch.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11127a.f();
            }
        });
        this.f11135b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribesearch.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f11128a.h();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        Bundle bundle = new Bundle();
        bundle.putLong("tribe.clan.id", ((TribeRecommendation) this.item).getClanId());
        bundle.putString(StringConstant.TRIBE_DETAIL_ENTER_TYPE, "search");
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ma.e.class, context.getString(R.string.tribe_detail), bundle);
        ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_DETAIL_PAGE, "search");
    }

    public /* synthetic */ void h() {
        new EditTextDialog(this.context).c(this.context.getString(R.string.tribe_request_join)).b(this.context.getString(R.string.tribe_request_join)).a(20).a(new f(this)).show();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public TribeRecommendation getItem() {
        return (TribeRecommendation) super.getItem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str) {
        TribeApi.requestJoinTribe(this.context, new RequestJoinTribe(((TribeRecommendation) this.item).getClanId(), str), new g(this));
    }
}
