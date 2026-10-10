package com.disabngo.blockynexus.d;

import com.sandboxol.greendao.entity.Friend;
import java.util.Comparator;

/* JADX INFO: compiled from: FriendStatusComparator.java */
/* JADX INFO: loaded from: classes2.dex */
public class o implements Comparator<Friend> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Friend friend, Friend friend2) {
        return (friend.getStatus() == 30 && friend2.getStatus() == 30) ? -(friend.getLogoutTime() > friend2.getLogoutTime() ? 1 : (friend.getLogoutTime() == friend2.getLogoutTime() ? 0 : -1)) : -Integer.compare(a(friend), a(friend2));
    }

    private int a(Friend friend) {
        int status = friend.getStatus();
        if (status == 10) {
            return 2;
        }
        if (status != 15) {
            return status != 20 ? 1 : 4;
        }
        return 3;
    }
}
