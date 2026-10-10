package com.sandboxol.googlepay.c.a.c;

import android.content.Context;
import android.os.Bundle;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleInfo.pay.PayRecordInfo;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.googlepay.R;
import java.io.Serializable;
import rx.functions.Action0;

/* JADX INFO: compiled from: RechargeHistoryItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends ListItemViewModel<PayRecordInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f18349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f18351d;

    public c(Context context, PayRecordInfo payRecordInfo) {
        super(context, payRecordInfo);
        this.f18351d = new ReplyCommand(new Action0() { // from class: com.sandboxol.googlepay.c.a.c.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18347a.f();
            }
        });
        int currency = payRecordInfo.getCurrency();
        if (currency == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(payRecordInfo.getInoutType() != 0 ? "-" : "+");
            sb.append(payRecordInfo.getQty());
            sb.append(context.getString(R.string.gDiamond));
            this.f18348a = sb.toString();
        } else if (currency == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(payRecordInfo.getInoutType() != 0 ? "-" : "+");
            sb2.append(payRecordInfo.getQty());
            sb2.append(context.getString(R.string.Bcube));
            this.f18348a = sb2.toString();
        } else if (currency == 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(payRecordInfo.getInoutType() != 0 ? "-" : "+");
            sb3.append(payRecordInfo.getQty());
            sb3.append(context.getString(R.string.gold));
            this.f18348a = sb3.toString();
        }
        this.f18349b = context.getString(payRecordInfo.getStatus() != 0 ? payRecordInfo.getStatus() == 1 ? R.string.googleplay_success : R.string.googleplay_failed : R.string.googleplay_recharge_finish);
        this.f18350c = com.sandboxol.googlepay.b.a.a(context, payRecordInfo.getTransactionType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StringConstant.RECHARGE_DETAIL_INFO, (Serializable) this.item);
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.sandboxol.googlepay.c.a.b.a.class, context.getString(R.string.googleplay_recharge_detail), bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public PayRecordInfo getItem() {
        return (PayRecordInfo) super.getItem();
    }
}
