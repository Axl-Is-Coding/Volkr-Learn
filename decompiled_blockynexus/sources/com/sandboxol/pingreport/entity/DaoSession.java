package com.sandboxol.pingreport.entity;

import java.util.Map;
import org.greenrobot.greendao.c;
import org.greenrobot.greendao.c.a;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* JADX INFO: loaded from: classes4.dex */
public class DaoSession extends c {
    private final PingEventDao pingEventDao;
    private final a pingEventDaoConfig;

    public DaoSession(org.greenrobot.greendao.b.a aVar, IdentityScopeType identityScopeType, Map<Class<? extends org.greenrobot.greendao.a<?, ?>>, a> map) {
        super(aVar);
        this.pingEventDaoConfig = map.get(PingEventDao.class).clone();
        this.pingEventDaoConfig.a(identityScopeType);
        this.pingEventDao = new PingEventDao(this.pingEventDaoConfig, this);
        registerDao(PingEvent.class, this.pingEventDao);
    }

    public void clear() {
        this.pingEventDaoConfig.b();
    }

    public PingEventDao getPingEventDao() {
        return this.pingEventDao;
    }
}
