package com.disabngo.blockynexus.e.b.x;

import android.content.Context;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: FriendModelImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class K {
    public static void a(Context context, Friend friend, FriendActivityIntentInfo friendActivityIntentInfo) {
        if (friend != null) {
            if (friend.isFriend()) {
                if (friendActivityIntentInfo.getType() == 2 || friendActivityIntentInfo.getType() == 1) {
                    friendActivityIntentInfo.setType(0);
                }
            } else if (friend.getUserId() != AccountCenter.newInstance().userId.get().longValue() && (friendActivityIntentInfo.getType() == 0 || friendActivityIntentInfo.getType() == 3)) {
                friendActivityIntentInfo.setType(2);
            }
        }
        com.disabngo.blockynexus.c.a.a(context, friendActivityIntentInfo, friend);
    }

    public static void a(Context context, Friend friend, FriendActivityIntentInfo friendActivityIntentInfo, int i) {
        if (friend != null) {
            if (friend.isFriend()) {
                if (friendActivityIntentInfo.getType() == 2 || friendActivityIntentInfo.getType() == 1) {
                    friendActivityIntentInfo.setType(0);
                }
            } else if (friend.getUserId() != AccountCenter.newInstance().userId.get().longValue() && (friendActivityIntentInfo.getType() == 0 || friendActivityIntentInfo.getType() == 3)) {
                friendActivityIntentInfo.setType(2);
            }
        }
        com.disabngo.blockynexus.c.a.a(context, friendActivityIntentInfo, friend, i);
    }
}
