package com.disabngo.blockynexus.e.b.Y;

import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.utils.SharedUtils;
import io.rong.imlib.RongIMClient;

/* JADX INFO: compiled from: ReminderViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements com.disabngo.blockynexus.interfaces.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f9597a;

    k(l lVar) {
        this.f9597a = lVar;
    }

    @Override // com.disabngo.blockynexus.interfaces.c
    public void onError(RongIMClient.ErrorCode errorCode) {
        this.f9597a.f9602e.set(true);
        this.f9597a.f9599b.f8031a.setChecked(this.f9597a.f9601d.get().booleanValue());
    }

    @Override // com.disabngo.blockynexus.interfaces.c
    public void onSuccess() {
        this.f9597a.f9602e.set(true);
        this.f9597a.f9601d.set(true);
        this.f9597a.f9599b.f8031a.setChecked(this.f9597a.f9601d.get().booleanValue());
        SharedUtils.putBoolean(this.f9597a.f9598a, StringConstant.IS_NEWS_REMINDER, true);
    }
}
