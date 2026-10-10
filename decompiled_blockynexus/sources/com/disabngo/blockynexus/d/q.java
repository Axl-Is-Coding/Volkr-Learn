package com.disabngo.blockynexus.d;

import com.disabngo.blockynexus.entity.GroupMember;
import java.util.Comparator;

/* JADX INFO: compiled from: GroupMemberComparator.java */
/* JADX INFO: loaded from: classes2.dex */
public class q implements Comparator<GroupMember> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(GroupMember groupMember, GroupMember groupMember2) {
        if (groupMember.getIdentity() > groupMember2.getIdentity()) {
            return -1;
        }
        if (groupMember.getIdentity() == groupMember2.getIdentity()) {
            if (groupMember.getVip() > groupMember2.getVip()) {
                return -1;
            }
            if (groupMember.getVip() == groupMember2.getVip() && groupMember.getUserName().compareToIgnoreCase(groupMember2.getUserName()) < 0) {
                return -1;
            }
        }
        return 1;
    }
}
