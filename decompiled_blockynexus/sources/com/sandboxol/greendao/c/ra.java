package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.DaoSession;
import com.sandboxol.greendao.entity.TribeMember;
import com.sandboxol.greendao.entity.TribeMemberDao;
import java.util.List;

/* JADX INFO: compiled from: TribeDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class ra extends ka {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ra f18534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f18535c;

    private ra(String str) {
        super(str);
        this.f18535c = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TribeMember> c(long j) {
        org.greenrobot.greendao.d.i<TribeMember> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(TribeMemberDao.Properties.LocalUserId.a(Long.valueOf(j)), new org.greenrobot.greendao.d.k[0]);
        return iVarQueryBuilder.c();
    }

    public static synchronized ra newInstance() {
        if (f18534b == null) {
            f18534b = new ra("bm-tribe-db");
        }
        return f18534b;
    }

    public void b(long j) {
        this.f18535c = j;
    }

    public /* synthetic */ void b(TribeMember tribeMember) {
        TribeMember tribeMemberA = a(this.f18535c, tribeMember.getUserId());
        if (tribeMemberA != null) {
            tribeMember.setID(tribeMemberA.getID());
        }
        tribeMember.setLocalUserId(this.f18535c);
        getDao().insertOrReplace(tribeMember);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public TribeMemberDao getDao() {
        return (TribeMemberDao) super.getDao();
    }

    @Override // com.sandboxol.greendao.c.ka
    protected org.greenrobot.greendao.a a(DaoSession daoSession) {
        return daoSession.getTribeMemberDao();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TribeMember a(long j, long j2) {
        org.greenrobot.greendao.d.i<TribeMember> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(iVarQueryBuilder.a(TribeMemberDao.Properties.LocalUserId.a(Long.valueOf(j)), TribeMemberDao.Properties.UserId.a(Long.valueOf(j2)), new org.greenrobot.greendao.d.k[0]), new org.greenrobot.greendao.d.k[0]);
        List<TribeMember> listC = iVarQueryBuilder.c();
        if (listC == null || listC.size() <= 0) {
            return null;
        }
        return listC.get(0);
    }

    public void a(final TribeMember tribeMember) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f18521a.b(tribeMember);
            }
        });
    }

    public TribeMember a(long j) {
        if (getDao() != null) {
            return a(this.f18535c, j);
        }
        return null;
    }

    public void a(long j, com.sandboxol.greendao.a.c<TribeMember> cVar) {
        post(new pa(this, j, cVar));
    }

    public void a(com.sandboxol.greendao.a.c<List<TribeMember>> cVar) {
        post(new qa(this, cVar));
    }
}
