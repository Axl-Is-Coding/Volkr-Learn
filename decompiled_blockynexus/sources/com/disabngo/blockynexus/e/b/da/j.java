package com.disabngo.blockynexus.e.b.da;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ScrapRewardInfo;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.SharedUtils;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScrapMainItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends ListItemViewModel<ScrapRewardInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Boolean> f9702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f9703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f9704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f9705d;

    public j(Context context, ScrapRewardInfo scrapRewardInfo, ObservableField<Boolean> observableField) {
        super(context, scrapRewardInfo);
        this.f9703b = new ObservableField<>(0);
        this.f9704c = new ObservableField<>(5);
        this.f9705d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.da.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9694a.f();
            }
        });
        this.f9702a = observableField;
    }

    private void a(ScrapRewardInfo scrapRewardInfo) {
        if (scrapRewardInfo == null || scrapRewardInfo.getCardProgress() == null || TextUtils.isEmpty(scrapRewardInfo.getCardProgress())) {
            return;
        }
        String[] strArrSplit = scrapRewardInfo.getCardProgress().split("/");
        if (strArrSplit.length == 2) {
            this.f9704c.set(Integer.valueOf(strArrSplit[1]));
            this.f9703b.set(Integer.valueOf(strArrSplit[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        if (this.item == 0) {
            return;
        }
        if (this.f9702a.get().booleanValue()) {
            this.f9702a.set(false);
            SharedUtils.putBoolean(this.context, AccountCenter.newInstance().userId.get() + StringConstant.KEY_HAS_SHOW_SCRAP_LIST_GUIDE, true);
        }
        new LoadingDialog(this.context).show();
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_COLLECT_ACTIV_ITEM);
        if (((ScrapRewardInfo) this.item).getStatus() == 1) {
            ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_AVAILABLE_ITEM);
        }
        ScrapApi.getScrapRewardDetails(this.context, ((ScrapRewardInfo) this.item).getCardId(), new i(this));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ScrapRewardInfo getItem() {
        a((ScrapRewardInfo) super.getItem());
        return (ScrapRewardInfo) super.getItem();
    }
}
