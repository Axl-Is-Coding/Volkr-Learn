package com.disabngo.blockynexus.e.b.Y;

import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.utils.SharedUtils;
import io.rong.imlib.RongIMClient;

/* JADX INFO: compiled from: ReminderViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements com.disabngo.blockynexus.interfaces.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f9596a;

    j(l lVar) {
        this.f9596a = lVar;
    }

    @Override // com.disabngo.blockynexus.interfaces.c
    public void onError(RongIMClient.ErrorCode errorCode) {
        this.f9596a.f9602e.set(true);
        this.f9596a.f9599b.f8031a.setChecked(this.f9596a.f9601d.get().booleanValue());
    }

    @Override // com.disabngo.blockynexus.interfaces.c
    public void onSuccess() {
        this.f9596a.f9602e.set(true);
        this.f9596a.f9601d.set(false);
        this.f9596a.f9599b.f8031a.setChecked(this.f9596a.f9601d.get().booleanValue());
        SharedUtils.putBoolean(this.f9596a.f9598a, StringConstant.IS_NEWS_REMINDER, false);
    }
}
