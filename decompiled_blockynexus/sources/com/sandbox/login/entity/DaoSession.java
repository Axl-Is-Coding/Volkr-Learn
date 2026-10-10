package com.sandbox.login.entity;

import java.util.Map;
import org.greenrobot.greendao.c;
import org.greenrobot.greendao.c.a;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* JADX INFO: loaded from: classes2.dex */
public class DaoSession extends c {
    private final UserRecordDao userRecordDao;
    private final a userRecordDaoConfig;

    public DaoSession(org.greenrobot.greendao.b.a aVar, IdentityScopeType identityScopeType, Map<Class<? extends org.greenrobot.greendao.a<?, ?>>, a> map) {
        super(aVar);
        this.userRecordDaoConfig = map.get(UserRecordDao.class).clone();
        this.userRecordDaoConfig.a(identityScopeType);
        this.userRecordDao = new UserRecordDao(this.userRecordDaoConfig, this);
        registerDao(UserRecord.class, this.userRecordDao);
    }

    public void clear() {
        this.userRecordDaoConfig.b();
    }

    public UserRecordDao getUserRecordDao() {
        return this.userRecordDao;
    }
}
