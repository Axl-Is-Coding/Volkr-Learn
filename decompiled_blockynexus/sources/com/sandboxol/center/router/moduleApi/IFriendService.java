package com.sandboxol.center.router.moduleApi;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IFriendService extends IBaseService {
    void addFriend(Context context, long j, ObservableField<Boolean> observableField, boolean z, ObservableField<String> observableField2);

    void getFriendDataAndEnterFriendInfo(Context context, Friend friend, long j);

    void getFriendsList(Context context, OnResponseListener<List<Friend>> onResponseListener, String str, boolean z);

    void startSearchFiendActivity(Context context);

    void startSearchFiendActivity(Context context, boolean z);
}
