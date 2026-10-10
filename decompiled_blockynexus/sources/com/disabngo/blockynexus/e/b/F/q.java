package com.disabngo.blockynexus.e.b.F;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: compiled from: GroupMemberModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class q {
    public void a(Context context, ObservableField<Integer> observableField, ObservableField<Integer> observableField2, ObservableField<Integer> observableField3) {
        GroupChatApi.getCreateGroupTypeAndPrice(context, new o(this, observableField3, observableField, observableField2, context));
    }

    public void a(Context context, long j, List<Long> list, OnResponseListener onResponseListener) {
        GroupChatApi.postJoinGroupInvite(context, j, list, onResponseListener);
    }

    public void a(Context context, long j, ObservableField<Integer> observableField, ObservableField<Integer> observableField2, ObservableField<Integer> observableField3, ObservableField<Boolean> observableField4, ObservableField<String> observableField5) {
        GroupChatApi.getGroupInviteCount(context, j, new p(this, observableField4, observableField, observableField2, observableField3, observableField5, context));
    }

    public void a(Context context, ObservableField<String> observableField, int i, ObservableField<Integer> observableField2, int i2) {
        observableField.set(context.getString(R.string.new_group_invite_limit, String.valueOf((i - observableField2.get().intValue()) + i2), String.valueOf(i)));
        observableField2.set(Integer.valueOf(observableField2.get().intValue() - i2));
    }
}
