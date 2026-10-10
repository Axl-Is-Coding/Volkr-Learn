package org.greenrobot.greendao;

import java.util.HashMap;
import java.util.Map;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* JADX INFO: compiled from: AbstractDaoMaster.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {
    protected final Map<Class<? extends a<?, ?>>, org.greenrobot.greendao.c.a> daoConfigMap = new HashMap();
    protected final org.greenrobot.greendao.b.a db;
    protected final int schemaVersion;

    public b(org.greenrobot.greendao.b.a aVar, int i) {
        this.db = aVar;
        this.schemaVersion = i;
    }

    public org.greenrobot.greendao.b.a getDatabase() {
        return this.db;
    }

    public int getSchemaVersion() {
        return this.schemaVersion;
    }

    public abstract c newSession();

    public abstract c newSession(IdentityScopeType identityScopeType);

    protected void registerDaoClass(Class<? extends a<?, ?>> cls) {
        this.daoConfigMap.put(cls, new org.greenrobot.greendao.c.a(this.db, cls));
    }
}
