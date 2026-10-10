package com.disabngo.blockynexus.e.b.F;

import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.greendao.entity.Friend;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: GroupMemberListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class l implements com.sandboxol.greendao.a.c<List<Friend>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f9259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f9260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f9261c;

    l(n nVar, List list, com.sandboxol.greendao.a.c cVar) {
        this.f9261c = nVar;
        this.f9259a = list;
        this.f9260b = cVar;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Friend> list) {
        if (list != null) {
            List listA = this.f9261c.a((List<Friend>) list);
            for (GroupMember groupMember : this.f9259a) {
                Iterator it = listA.iterator();
                while (true) {
                    if (it.hasNext()) {
                        GroupMember groupMember2 = (GroupMember) it.next();
                        if (groupMember2.getUserId() == groupMember.getUserId()) {
                            listA.remove(groupMember2);
                            break;
                        }
                    }
                }
            }
            if (listA.size() > 0) {
                listA.add(new GroupMember(-1L));
            }
            this.f9260b.onSuccess(listA);
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
