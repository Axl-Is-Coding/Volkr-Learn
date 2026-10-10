package com.disabngo.blockynexus.view.fragment.partyhall;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.imchat.web.ChatGameApi;
import io.rong.imkit.RongContext;
import java.util.Map;
import rx.functions.Action0;

/* JADX INFO: compiled from: PartyHallItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class u extends ListItemViewModel<PartyItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f11944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f11945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f11946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f11947d;

    public u(Context context, PartyItem partyItem, Map<String, String> map) {
        super(context, partyItem);
        this.f11945b = new ObservableField<>();
        this.f11946c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f11908a.f();
            }
        });
        this.f11947d = map;
        if (partyItem.getLang() != null) {
            this.f11945b.set(map.get(partyItem.getLang()));
        }
        this.f11944a = new q(context, partyItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"CheckResult"})
    public void f() {
        if (RongContext.getInstance() == null) {
            Context context = this.context;
            AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.inner_error));
        } else {
            DialogUtils.newsInstant().showLoadingDialog(this.context);
            ChatGameApi.getPartyAuth(this.context, AccountCenter.newInstance().userId.get().longValue(), ((PartyItem) this.item).getPsid(), ((PartyItem) this.item).getIsNewEngine(), new t(this));
            ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_PARTYCARD_TIME);
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setItem(PartyItem partyItem) {
        super.setItem(partyItem);
        if (partyItem.getLang() != null) {
            this.f11945b.set(this.f11947d.get(partyItem.getLang()));
        }
        this.f11944a.a(partyItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public PartyItem getItem() {
        return (PartyItem) super.getItem();
    }
}
