package com.disabngo.blockynexus.e.b.Y;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.imchat.config.ChatStringConstant;

/* JADX INFO: compiled from: ReminderModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f9590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f9591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ i f9592c;

    g(i iVar, ObservableField observableField, Context context) {
        this.f9592c = iVar;
        this.f9590a = observableField;
        this.f9591b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Integer num) {
        this.f9590a.set(Boolean.valueOf(num.intValue() == 1));
        SharedUtils.putBoolean(this.f9591b, ChatStringConstant.IS_SHOW_FRIEND_IN_GAME, num.intValue() == 1);
    }
}
