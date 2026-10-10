package com.sandboxol.greendao.b;

import android.text.TextUtils;
import com.sandboxol.greendao.entity.FriendPartyStatus;

/* JADX INFO: compiled from: FriendPartyStatusConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements org.greenrobot.greendao.a.a<FriendPartyStatus, String> {
    public FriendPartyStatus a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (FriendPartyStatus) new com.google.gson.j().a(str, FriendPartyStatus.class);
    }

    public String a(FriendPartyStatus friendPartyStatus) {
        if (friendPartyStatus == null) {
            return null;
        }
        return new com.google.gson.j().a(friendPartyStatus);
    }
}
