package com.sandbox.login.d;

import com.sandbox.login.entity.DaoSession;
import com.sandbox.login.entity.UserRecord;
import com.sandbox.login.entity.UserRecordDao;
import com.sandboxol.common.base.dao.DaoTransformers;
import com.sandboxol.common.base.dao.OnDaoResponseListener;
import com.sandboxol.greendao.entity.User;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: UserRecordHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static t f15739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private UserRecordDao f15740d;

    private t(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UserRecord b(String str) {
        synchronized (t.class) {
            org.greenrobot.greendao.d.i<UserRecord> iVarQueryBuilder = this.f15740d.queryBuilder();
            iVarQueryBuilder.a(UserRecordDao.Properties.UserId.a(str), new org.greenrobot.greendao.d.k[0]);
            List<UserRecord> listC = iVarQueryBuilder.c();
            if (listC == null || listC.size() <= 0) {
                return null;
            }
            return listC.get(0);
        }
    }

    @Override // com.sandbox.login.d.c
    protected void a(DaoSession daoSession) {
        this.f15740d = daoSession.getUserRecordDao();
    }

    public static synchronized t a() {
        if (f15739c == null) {
            f15739c = new t("bm-user-record-db");
        }
        return f15739c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UserRecord a(String str) {
        synchronized (t.class) {
            org.greenrobot.greendao.d.i<UserRecord> iVarQueryBuilder = this.f15740d.queryBuilder();
            iVarQueryBuilder.a(UserRecordDao.Properties.Account.a(str), new org.greenrobot.greendao.d.k[0]);
            List<UserRecord> listC = iVarQueryBuilder.c();
            if (listC == null || listC.size() <= 0) {
                return null;
            }
            return listC.get(0);
        }
    }

    public void b(String str, OnDaoResponseListener<UserRecord> onDaoResponseListener) {
        Observable.create(new l(this, str)).compose(DaoTransformers.applySchedulers()).subscribe(new k(this, onDaoResponseListener));
    }

    public void a(String str, String str2) {
        Observable.create(new n(this, str, str2)).compose(DaoTransformers.applySchedulers()).subscribe(new m(this));
    }

    public void a(String str, String str2, String str3) {
        Observable.create(new p(this, str, str2, str3)).compose(DaoTransformers.applySchedulers()).subscribe(new o(this));
    }

    public void a(User user) {
        Observable.create(new r(this, user)).compose(DaoTransformers.applySchedulers()).subscribe(new q(this));
    }

    public void a(String str, OnDaoResponseListener onDaoResponseListener) {
        Observable.create(new d(this, str)).compose(DaoTransformers.applySchedulers()).subscribe(new s(this, onDaoResponseListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserRecord userRecord, User user, boolean z) {
        if (!z) {
            userRecord.setUserId(user.getUserId() + "");
            if (user.getAccount() != null && !"".equals(user.getAccount())) {
                userRecord.setAccount(user.getAccount());
            }
            if (user.getPicUrl() != null && !"".endsWith(user.getPicUrl())) {
                userRecord.setUserIcon(user.getPicUrl());
            }
            if (user.getNickName() != null && !"".endsWith(user.getNickName())) {
                userRecord.setNickName(user.getNickName());
            }
            if (user.getHasPassword()) {
                userRecord.setHasPassword(user.getHasPassword());
            }
            userRecord.setLoginTime(System.currentTimeMillis());
        }
        if (this.f15740d.count() < 1000) {
            this.f15740d.insertOrReplace(userRecord);
        }
    }

    public void a(String str, String str2, User user) {
        Observable.create(new f(this, user, str, str2)).compose(DaoTransformers.applySchedulers()).subscribe(new e(this));
    }

    public void a(OnDaoResponseListener<List<UserRecord>> onDaoResponseListener) {
        Observable.create(new h(this)).compose(DaoTransformers.applySchedulers()).subscribe(new g(this, onDaoResponseListener));
    }

    public void a(UserRecord userRecord) {
        Observable.create(new j(this, userRecord)).compose(DaoTransformers.applySchedulers()).subscribe(new i(this));
    }
}
