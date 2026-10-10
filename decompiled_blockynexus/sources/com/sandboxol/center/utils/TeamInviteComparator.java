package com.sandboxol.center.utils;

import com.sandboxol.greendao.entity.Friend;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public class TeamInviteComparator implements Comparator<Friend> {
    private static final int IN_GAME = 20;
    private static final int IN_PARTY = 15;
    private static final int OFFLINE = 30;
    private static final int ONLINE = 10;

    private int priority(Friend friend) {
        int status = friend.getStatus();
        if (status == 10) {
            return 4;
        }
        if (status != 15) {
            return status != 20 ? 1 : 3;
        }
        return 2;
    }

    @Override // java.util.Comparator
    public int compare(Friend friend, Friend friend2) {
        return -Integer.compare(priority(friend), priority(friend2));
    }
}
