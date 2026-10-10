package com.disabngo.blockynexus.view.dialog.activity;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.h.C0850a;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: ActivityTaskContentViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class u extends ListItemViewModel<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f11507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0850a f11508b;

    public u(Context context, String str, String str2, String str3, String str4) {
        super(context, str);
        this.f11508b = new C0850a();
        this.f11507a = new q(context, R.string.no_data, str, str2, str3, str4);
        if ("recharge".equals(str4)) {
            ReportDataAdapter.onEvent(context, EventConstant.TOPUP_GIFT_TIME);
        }
    }
}
