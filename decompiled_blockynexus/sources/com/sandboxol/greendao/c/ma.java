package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.DaoSession;
import com.sandboxol.greendao.entity.PartyMemberInfo;
import com.sandboxol.greendao.entity.PartyMemberInfoDao;
import java.util.List;

/* JADX INFO: compiled from: PartyMemberDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class ma extends ka {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ma f18512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f18513c;

    private ma(String str) {
        super(str);
        this.f18513c = 0L;
    }

    public static synchronized ma newInstance() {
        if (f18512b == null) {
            f18512b = new ma("bm-party-member-db");
        }
        return f18512b;
    }

    public void b(long j) {
        this.f18513c = j;
    }

    public /* synthetic */ void b(PartyMemberInfo partyMemberInfo) {
        PartyMemberInfo partyMemberInfoA = a(this.f18513c, partyMemberInfo.getUserId());
        if (partyMemberInfoA != null) {
            partyMemberInfo.setID(partyMemberInfoA.getID());
        }
        partyMemberInfo.setLocalUserId(this.f18513c);
        getDao().insertOrReplace(partyMemberInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public PartyMemberInfoDao getDao() {
        return (PartyMemberInfoDao) super.getDao();
    }

    @Override // com.sandboxol.greendao.c.ka
    protected org.greenrobot.greendao.a a(DaoSession daoSession) {
        return daoSession.getPartyMemberInfoDao();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PartyMemberInfo a(long j, long j2) {
        org.greenrobot.greendao.d.i<PartyMemberInfo> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(iVarQueryBuilder.a(PartyMemberInfoDao.Properties.LocalUserId.a(Long.valueOf(j)), PartyMemberInfoDao.Properties.UserId.a(Long.valueOf(j2)), new org.greenrobot.greendao.d.k[0]), new org.greenrobot.greendao.d.k[0]);
        List<PartyMemberInfo> listC = iVarQueryBuilder.c();
        if (listC == null || listC.size() <= 0) {
            return null;
        }
        return listC.get(0);
    }

    public void a(final PartyMemberInfo partyMemberInfo) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f18510a.b(partyMemberInfo);
            }
        });
    }

    public PartyMemberInfo a(long j) {
        if (getDao() != null) {
            return a(this.f18513c, j);
        }
        return null;
    }

    public void a(long j, com.sandboxol.greendao.a.c<PartyMemberInfo> cVar) {
        post(new la(this, j, cVar));
    }
}
