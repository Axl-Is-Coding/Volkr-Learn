package com.disabngo.blockynexus.e.b.S;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.e.b.y.C0953d;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.PartyCreateGameConfig;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.web.ChatGameApi;

/* JADX INFO: compiled from: PartyCreateModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0953d f9440a = new s(this);

    public void a(Context context, String str, OnDataListener<PartyCreateGameConfig> onDataListener) {
        GameApi.getPartyCreateGameConfig(context, str, new p(this, onDataListener, context));
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, ObservableField<Boolean> observableField) {
        observableField.set(true);
        DialogUtils.newsInstant().showLoadingDialog(context);
        GameApi.getChatRoomId(context, str, new q(this, context, str, i, i2, i3, i4, i5, str2, str3, observableField));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, int i, int i2, int i3, int i4, int i5, String str3, String str4, ObservableField<Boolean> observableField) {
        ChatGameApi.getPartyAuth(context, AccountCenter.newInstance().userId.get().longValue(), null, i5 == 1, new r(this, str, str2, i, i2, i3, i4, str4, str3, i5, context, observableField));
    }

    public void a() {
        Messenger.getDefault().unregister(this);
    }
}
