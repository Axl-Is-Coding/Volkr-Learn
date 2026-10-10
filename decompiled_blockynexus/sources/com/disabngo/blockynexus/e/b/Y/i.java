package com.disabngo.blockynexus.e.b.Y;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.web.UserApi;

/* JADX INFO: compiled from: ReminderModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    public void a(Context context, ObservableField<Boolean> observableField) {
        UserApi.getIsShowFriendInGame(context, new g(this, observableField, context));
    }

    public void b(Context context, ObservableField<Boolean> observableField) {
        UserApi.setIsShowFriendInGame(context, new h(this, observableField, context));
    }
}
