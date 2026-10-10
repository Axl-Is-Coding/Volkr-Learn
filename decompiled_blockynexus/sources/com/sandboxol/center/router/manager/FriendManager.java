package com.sandboxol.center.router.manager;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IFriendService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FriendManager {
    private static IFriendService iFriendService = (IFriendService) RouteServiceManager.provide(RouterServicePath.EventFriend.FRIEND_SERVICE);

    public static void addFriend(Context context, long j, ObservableField<Boolean> observableField, boolean z, ObservableField<String> observableField2) {
        IFriendService iFriendService2 = iFriendService;
        if (iFriendService2 != null) {
            iFriendService2.addFriend(context, j, observableField, z, observableField2);
        }
    }

    public static void getFriendDataAndEnterFriendInfo(Context context, Friend friend, long j) {
        IFriendService iFriendService2 = iFriendService;
        if (iFriendService2 != null) {
            iFriendService2.getFriendDataAndEnterFriendInfo(context, friend, j);
        }
    }

    public static void getFriendsList(Context context, OnResponseListener<List<Friend>> onResponseListener, String str, boolean z) {
        IFriendService iFriendService2 = iFriendService;
        if (iFriendService2 != null) {
            iFriendService2.getFriendsList(context, onResponseListener, str, z);
        }
    }

    public static void startSearchFiendActivity(Context context) {
        IFriendService iFriendService2 = iFriendService;
        if (iFriendService2 != null) {
            iFriendService2.startSearchFiendActivity(context);
        }
    }

    public static void startSearchFiendActivity(Context context, boolean z) {
        IFriendService iFriendService2 = iFriendService;
        if (iFriendService2 != null) {
            iFriendService2.startSearchFiendActivity(context, z);
        }
    }
}
