package com.sandboxol.report.entity;

import java.util.Map;
import org.greenrobot.greendao.c;
import org.greenrobot.greendao.c.a;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* JADX INFO: loaded from: classes4.dex */
public class DaoSession extends c {
    private final EventInfoRequestDao eventInfoRequestDao;
    private final a eventInfoRequestDaoConfig;
    private final NewEventInfoRequestDao newEventInfoRequestDao;
    private final a newEventInfoRequestDaoConfig;

    public DaoSession(org.greenrobot.greendao.b.a aVar, IdentityScopeType identityScopeType, Map<Class<? extends org.greenrobot.greendao.a<?, ?>>, a> map) {
        super(aVar);
        this.newEventInfoRequestDaoConfig = map.get(NewEventInfoRequestDao.class).clone();
        this.newEventInfoRequestDaoConfig.a(identityScopeType);
        this.eventInfoRequestDaoConfig = map.get(EventInfoRequestDao.class).clone();
        this.eventInfoRequestDaoConfig.a(identityScopeType);
        this.newEventInfoRequestDao = new NewEventInfoRequestDao(this.newEventInfoRequestDaoConfig, this);
        this.eventInfoRequestDao = new EventInfoRequestDao(this.eventInfoRequestDaoConfig, this);
        registerDao(NewEventInfoRequest.class, this.newEventInfoRequestDao);
        registerDao(EventInfoRequest.class, this.eventInfoRequestDao);
    }

    public void clear() {
        this.newEventInfoRequestDaoConfig.b();
        this.eventInfoRequestDaoConfig.b();
    }

    public EventInfoRequestDao getEventInfoRequestDao() {
        return this.eventInfoRequestDao;
    }

    public NewEventInfoRequestDao getNewEventInfoRequestDao() {
        return this.newEventInfoRequestDao;
    }
}
