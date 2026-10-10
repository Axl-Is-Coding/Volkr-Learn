package com.sandboxol.greendao.c;

import android.database.sqlite.SQLiteException;
import com.sandboxol.greendao.entity.DaoSession;
import com.sandboxol.greendao.entity.UserGameRecordInfo;
import com.sandboxol.greendao.entity.UserGameRecordInfoDao;
import java.util.List;

/* JADX INFO: compiled from: UserGameRecordInfoDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class ya extends ka {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ya f18571b;

    ya(String str) {
        super(str);
    }

    public static synchronized ya newInstance() {
        if (f18571b == null) {
            f18571b = new ya("bm-user-game-record-info-db");
        }
        return f18571b;
    }

    public void b(long j, com.sandboxol.greendao.a.c<Boolean> cVar) {
        post(new xa(this, j, cVar));
    }

    public /* synthetic */ void c(long j, boolean z) {
        try {
            UserGameRecordInfo userGameRecordInfoA = a(j);
            if (userGameRecordInfoA != null) {
                userGameRecordInfoA.setIsPlayed(z);
                getDao().update(userGameRecordInfoA);
            } else {
                getDao().insertOrReplace(new UserGameRecordInfo(j, z, false));
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void d(long j, boolean z) {
        try {
            UserGameRecordInfo userGameRecordInfoA = a(j);
            if (userGameRecordInfoA != null) {
                userGameRecordInfoA.setIsSignIn(z);
                getDao().update(userGameRecordInfoA);
            } else {
                getDao().insertOrReplace(new UserGameRecordInfo(j, false, z));
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sandboxol.greendao.c.ka
    protected org.greenrobot.greendao.a a(DaoSession daoSession) {
        return daoSession.getUserGameRecordInfoDao();
    }

    public void b(final long j, final boolean z) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f18542a.d(j, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public UserGameRecordInfoDao getDao() {
        return (UserGameRecordInfoDao) super.getDao();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UserGameRecordInfo a(long j) {
        org.greenrobot.greendao.d.i<UserGameRecordInfo> iVarQueryBuilder = getDao().queryBuilder();
        iVarQueryBuilder.a(UserGameRecordInfoDao.Properties.UserId.a(Long.valueOf(j)), new org.greenrobot.greendao.d.k[0]);
        List<UserGameRecordInfo> listC = iVarQueryBuilder.c();
        if (listC == null || listC.isEmpty()) {
            return null;
        }
        return listC.get(0);
    }

    public void a(long j, com.sandboxol.greendao.a.c<Boolean> cVar) {
        post(new wa(this, j, cVar));
    }

    public void a(final long j, final boolean z) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f18548a.c(j, z);
            }
        });
    }
}
