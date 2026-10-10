package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import android.os.CountDownTimer;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Kb extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10795b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Kb(bc bcVar, long j, long j2, Context context) {
        super(j, j2);
        this.f10795b = bcVar;
        this.f10794a = context;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        SharedUtils.putBoolean(this.f10794a, SharedConstant.SHARE_KEY_SHOW_PARTY_DIALOG, true);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}
