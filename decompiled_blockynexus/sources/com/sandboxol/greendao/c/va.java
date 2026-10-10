package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.DaoSession;
import com.sandboxol.greendao.entity.UserCache;
import com.sandboxol.greendao.entity.UserCacheDao;
import java.util.List;

/* JADX INFO: compiled from: UserCacheDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class va extends ka {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static va f18556b;

    va(String str) {
        super(str);
    }

    public static synchronized va newInstance() {
        if (f18556b == null) {
            f18556b = new va("bm-user-cache-db");
        }
        return f18556b;
    }

    public void b(long j, com.sandboxol.greendao.a.c<Boolean> cVar) {
        post(new sa(this, j, cVar));
    }

    public void c(long j, com.sandboxol.greendao.a.c<Boolean> cVar) {
        post(new ta(this, j, cVar));
    }

    public /* synthetic */ void d(long j, boolean z) {
        UserCache userCacheA = a(j);
        if (userCacheA == null) {
            getDao().insertOrReplace(new UserCache(j, false, false, false, z));
        } else {
            userCacheA.setIsExistGamePay(z);
            getDao().insertOrReplace(userCacheA);
        }
    }

    public /* synthetic */ void e(long j, boolean z) {
        UserCache userCacheA = a(j);
        if (userCacheA == null) {
            getDao().insertOrReplace(new UserCache(j, z, false, false, false));
        } else {
            userCacheA.setIsShowGoldDiamondDialog(z);
            getDao().insertOrReplace(userCacheA);
        }
    }

    public /* synthetic */ void f(long j, boolean z) {
        UserCache userCacheA = a(j);
        if (userCacheA == null) {
            getDao().insertOrReplace(new UserCache(j, false, z, false, false));
        } else {
            userCacheA.setIsShowPasswordSettingDialog(z);
            getDao().insertOrReplace(userCacheA);
        }
    }

    @Override // com.sandboxol.greendao.c.ka
    protected org.greenrobot.greendao.a a(DaoSession daoSession) {
        return daoSession.getUserCacheDao();
    }

    public void b(final long j, final boolean z) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f18526a.e(j, z);
            }
        });
    }

    public void c(final long j, final boolean z) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f18536a.f(j, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public UserCacheDao getDao() {
        return (UserCacheDao) super.getDao();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UserCache a(long j) {
        org.greenrobot.greendao.d.i<UserCache> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(UserCacheDao.Properties.UserId.a(Long.valueOf(j)), new org.greenrobot.greendao.d.k[0]);
        List<UserCache> listC = iVarQueryBuilder.c();
        if (listC == null || listC.isEmpty()) {
            return null;
        }
        return listC.get(0);
    }

    public void a(long j, com.sandboxol.greendao.a.c<Boolean> cVar) {
        post(new ua(this, j, cVar));
    }

    public void a(final long j, final boolean z) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f18531a.d(j, z);
            }
        });
    }
}
