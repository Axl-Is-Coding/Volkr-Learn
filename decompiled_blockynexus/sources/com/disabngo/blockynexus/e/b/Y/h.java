package com.disabngo.blockynexus.e.b.Y;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.imchat.config.ChatStringConstant;

/* JADX INFO: compiled from: ReminderModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f9593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f9594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ i f9595c;

    h(i iVar, ObservableField observableField, Context context) {
        this.f9595c = iVar;
        this.f9593a = observableField;
        this.f9594b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Integer num) {
        this.f9593a.set(Boolean.valueOf(num.intValue() == 1));
        SharedUtils.putBoolean(this.f9594b, ChatStringConstant.IS_SHOW_FRIEND_IN_GAME, num.intValue() == 1);
    }
}
