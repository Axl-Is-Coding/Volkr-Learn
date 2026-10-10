package com.sandboxol.vip.view.fragment.main;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.router.manager.BillingManager;

/* JADX INFO: compiled from: PrivilegeCenterModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class p {
    public void a(Context context, ObservableField<Boolean> observableField) {
        BillingManager.getInstance().vipSubsProductsList(context, new o(this, observableField));
    }
}
