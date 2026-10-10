package com.sandboxol.googlepay.c.a.b;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.pay.PayRecordInfo;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.googlepay.R;

/* JADX INFO: compiled from: RechargeDetailViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f18342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PayRecordInfo f18343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18346e;

    public b(Context context, PayRecordInfo payRecordInfo) {
        this.f18342a = context;
        this.f18343b = payRecordInfo;
        int currency = payRecordInfo.getCurrency();
        if (currency == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(payRecordInfo.getInoutType() != 0 ? "-" : "+");
            sb.append(payRecordInfo.getQty());
            sb.append(context.getString(R.string.gDiamond));
            this.f18344c = sb.toString();
        } else if (currency == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(payRecordInfo.getInoutType() != 0 ? "-" : "+");
            sb2.append(payRecordInfo.getQty());
            sb2.append(context.getString(R.string.Bcube));
            this.f18344c = sb2.toString();
        } else if (currency == 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(payRecordInfo.getInoutType() != 0 ? "-" : "+");
            sb3.append(payRecordInfo.getQty());
            sb3.append(context.getString(R.string.gold));
            this.f18344c = sb3.toString();
        }
        this.f18345d = com.sandboxol.googlepay.b.a.a(context, payRecordInfo.getTransactionType());
        this.f18346e = context.getString(payRecordInfo.getStatus() != 0 ? payRecordInfo.getStatus() == 1 ? R.string.googleplay_success : R.string.googleplay_failed : R.string.googleplay_recharge_finish);
    }
}
