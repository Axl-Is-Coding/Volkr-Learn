package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.DaoSession;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.FriendDao;
import java.util.List;

/* JADX INFO: compiled from: FriendDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class P extends ka {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static P f18443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f18444c;

    private P(String str) {
        super(str);
        this.f18444c = 0L;
    }

    private void b(long j, long j2) {
        org.greenrobot.greendao.d.i<Friend> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(iVarQueryBuilder.a(FriendDao.Properties.LocalUserId.a(Long.valueOf(j)), FriendDao.Properties.UserId.a(Long.valueOf(j2)), new org.greenrobot.greendao.d.k[0]), new org.greenrobot.greendao.d.k[0]);
        iVarQueryBuilder.b().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Friend> e(long j) {
        getDao().loadAll();
        org.greenrobot.greendao.d.i<Friend> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(FriendDao.Properties.LocalUserId.a(Long.valueOf(j)), new org.greenrobot.greendao.d.k[0]);
        return iVarQueryBuilder.c();
    }

    private void f(long j) {
        org.greenrobot.greendao.d.i<Friend> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(FriendDao.Properties.LocalUserId.a(Long.valueOf(j)), new org.greenrobot.greendao.d.k[0]);
        iVarQueryBuilder.b().b();
    }

    public static synchronized P newInstance() {
        if (f18443b == null) {
            f18443b = new P("bm-friend-db");
        }
        return f18443b;
    }

    public void c(final long j) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f18500a.b(j);
            }
        });
    }

    public void d(long j) {
        this.f18444c = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public FriendDao getDao() {
        return (FriendDao) super.getDao();
    }

    @Override // com.sandboxol.greendao.c.ka
    protected org.greenrobot.greendao.a a(DaoSession daoSession) {
        return daoSession.getFriendDao();
    }

    public /* synthetic */ void b(long j) {
        b(this.f18444c, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Friend a(long j, long j2) {
        org.greenrobot.greendao.d.i<Friend> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(iVarQueryBuilder.a(FriendDao.Properties.LocalUserId.a(Long.valueOf(j)), FriendDao.Properties.UserId.a(Long.valueOf(j2)), new org.greenrobot.greendao.d.k[0]), new org.greenrobot.greendao.d.k[0]);
        List<Friend> listC = iVarQueryBuilder.c();
        if (listC == null || listC.size() <= 0) {
            return null;
        }
        return listC.get(0);
    }

    public void b() {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f18503a.a();
            }
        });
    }

    public void a(Friend friend) {
        a(friend, (com.sandboxol.greendao.a.c<Friend>) null);
    }

    public void a(Friend friend, com.sandboxol.greendao.a.c<Friend> cVar) {
        post(new L(this, friend, cVar));
    }

    public Friend a(long j) {
        if (getDao() == null || getDao() == null) {
            return null;
        }
        return a(this.f18444c, j);
    }

    public void a(long j, String str, com.sandboxol.greendao.a.c<Friend> cVar) {
        post(new M(this, j, str, cVar));
    }

    public void a(long j, com.sandboxol.greendao.a.c<Friend> cVar) {
        post(new N(this, j, cVar));
    }

    public /* synthetic */ void a() {
        f(this.f18444c);
    }

    public void a(com.sandboxol.greendao.a.c<List<Friend>> cVar) {
        post(new O(this, cVar));
    }
}
