package com.disabngo.blockynexus.view.activity.friends;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.entity.StatusBean;
import com.disabngo.blockynexus.web.FriendApi;

/* JADX INFO: compiled from: FriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class P {
    public void a(Context context, ObservableField<Long> observableField, ObservableField<Boolean> observableField2, int i, ObservableField<String> observableField3, ObservableField<StatusBean> observableField4) {
        if (observableField == null || observableField.get().longValue() == 0) {
            return;
        }
        FriendApi.friendGamingInfo(context, observableField.get().longValue(), new O(this, i, observableField2, observableField3, context, observableField4));
    }
}
