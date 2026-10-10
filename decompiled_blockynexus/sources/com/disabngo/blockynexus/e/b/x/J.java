package com.disabngo.blockynexus.e.b.x;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.FriendRequestAdd;
import com.disabngo.blockynexus.entity.StatusBean;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.greendao.c.P;
import com.sandboxol.greendao.entity.Friend;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class J {
    public static void c(Context context, long j) {
        FriendRequestAdd friendRequestAdd = new FriendRequestAdd();
        friendRequestAdd.setMsg("");
        friendRequestAdd.setFriendId(j);
        FriendApi.friendAdd(context, friendRequestAdd, new G(j, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<Long> d(List<Friend> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Friend> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getUserId()));
        }
        return arrayList;
    }

    public static void b(Context context, long j) {
        FriendApi.friendDetails(context, j, new E(j, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(List<Friend> list, boolean z) {
        Iterator<Friend> it = list.iterator();
        while (it.hasNext()) {
            Friend next = it.next();
            if (next.getUserId() == AccountCenter.newInstance().userId.get().longValue()) {
                it.remove();
            } else if (!z && next.getUserId() == 32) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(List<Friend> list, List<StatusBean> list2) {
        for (Friend friend : list) {
            for (StatusBean statusBean : list2) {
                if (friend.getUserId() != 32 && friend.getUserId() == statusBean.getUserId()) {
                    friend.setStatus(statusBean.getStatus());
                    friend.setGameId(statusBean.getGameId());
                    friend.setGameName(statusBean.getGameName());
                    friend.setFriendPartyStatus(statusBean.getPartyInfo());
                    friend.setGamingInfo(statusBean.getGamingInfo());
                    friend.setLogoutTime(statusBean.getLogoutTime());
                }
            }
        }
    }

    public static void a(Context context, Friend friend, FriendActivityIntentInfo friendActivityIntentInfo) {
        K.a(context, friend, friendActivityIntentInfo);
    }

    public static void a(Context context, Friend friend, FriendActivityIntentInfo friendActivityIntentInfo, int i) {
        K.a(context, friend, friendActivityIntentInfo, i);
    }

    public static void a(Context context, long j) {
        FriendApi.friendAgreeAdd(context, j, new F(j, context));
    }

    public static void a(Context context, OnResponseListener<List<Friend>> onResponseListener, String str, boolean z) {
        P.newInstance().a(new I(z, context, onResponseListener, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<Friend> list, List<Friend> list2) {
        for (Friend friend : list) {
            if (friend.getUserId() == 32) {
                list2.add(friend);
            }
        }
        if (list2.size() == 0) {
            Friend friend2 = new Friend();
            friend2.setNickName(context.getString(R.string.friend_system_message));
            friend2.setUserId(32L);
            friend2.setPicUrl(UrlConstant.IC_CUSTOM_SERVICE);
            friend2.setStatus(10);
            list2.add(friend2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<Long> c(List<StatusBean> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<StatusBean> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getUserId()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(List<Long> list, List<Long> list2, String str) {
        List<List<Long>> listB = b(list, list2);
        List<Long> list3 = listB.get(0);
        List<Long> list4 = listB.get(1);
        if (list3.size() > 0) {
            Iterator<Long> it = list3.iterator();
            while (it.hasNext()) {
                P.newInstance().c(it.next().longValue());
            }
            if (str != null) {
                Messenger.getDefault().send(RefreshMsg.create(), str);
            }
        }
        if (list4.size() > 0) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_RELOAD_FRIEND_LIST);
        }
    }

    private static List<List<Long>> b(List<Long> list, List<Long> list2) {
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().longValue() == 32) {
                it.remove();
            }
        }
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap(list2.size());
        Iterator<Long> it2 = list2.iterator();
        while (it2.hasNext()) {
            map.put(Long.valueOf(it2.next().longValue()), 1);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<Long> it3 = list.iterator();
        while (it3.hasNext()) {
            long jLongValue = it3.next().longValue();
            if (map.get(Long.valueOf(jLongValue)) != null) {
                map.put(Long.valueOf(jLongValue), 2);
            } else {
                arrayList2.add(Long.valueOf(jLongValue));
            }
        }
        arrayList.add(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == 1) {
                arrayList3.add(entry.getKey());
            }
        }
        arrayList.add(arrayList3);
        return arrayList;
    }
}
