package com.sandbox.login.e;

import com.sandbox.login.entity.UserRecord;
import java.util.Comparator;

/* JADX INFO: compiled from: AccountRecordComparator.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements Comparator<UserRecord> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(UserRecord userRecord, UserRecord userRecord2) {
        return -(userRecord.getLoginTime() > userRecord2.getLoginTime() ? 1 : (userRecord.getLoginTime() == userRecord2.getLoginTime() ? 0 : -1));
    }
}
