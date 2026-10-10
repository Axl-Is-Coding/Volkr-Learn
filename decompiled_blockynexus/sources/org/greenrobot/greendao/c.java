package org.greenrobot.greendao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.d.i;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: AbstractDaoSession.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {
    private final org.greenrobot.greendao.b.a db;
    private final Map<Class<?>, a<?, ?>> entityToDao = new HashMap();
    private volatile org.greenrobot.greendao.e.c rxTxIo;
    private volatile org.greenrobot.greendao.e.c rxTxPlain;

    public c(org.greenrobot.greendao.b.a aVar) {
        this.db = aVar;
    }

    public <V> V callInTx(Callable<V> callable) throws Exception {
        this.db.D();
        try {
            V vCall = callable.call();
            this.db.E();
            return vCall;
        } finally {
            this.db.F();
        }
    }

    public <V> V callInTxNoException(Callable<V> callable) {
        this.db.D();
        try {
            try {
                V vCall = callable.call();
                this.db.E();
                return vCall;
            } catch (Exception e2) {
                throw new DaoException("Callable failed", e2);
            }
        } finally {
            this.db.F();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void delete(T t) {
        getDao(t.getClass()).delete(t);
    }

    public <T> void deleteAll(Class<T> cls) {
        getDao(cls).deleteAll();
    }

    public Collection<a<?, ?>> getAllDaos() {
        return Collections.unmodifiableCollection(this.entityToDao.values());
    }

    public a<?, ?> getDao(Class<? extends Object> cls) {
        a<?, ?> aVar = this.entityToDao.get(cls);
        if (aVar != null) {
            return aVar;
        }
        throw new DaoException("No DAO registered for " + cls);
    }

    public org.greenrobot.greendao.b.a getDatabase() {
        return this.db;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> long insert(T t) {
        return getDao(t.getClass()).insert(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> long insertOrReplace(T t) {
        return getDao(t.getClass()).insertOrReplace(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T, K> T load(Class<T> cls, K k) {
        return (T) getDao(cls).load(k);
    }

    public <T, K> List<T> loadAll(Class<T> cls) {
        return (List<T>) getDao(cls).loadAll();
    }

    public <T> i<T> queryBuilder(Class<T> cls) {
        return (i<T>) getDao(cls).queryBuilder();
    }

    public <T, K> List<T> queryRaw(Class<T> cls, String str, String... strArr) {
        return (List<T>) getDao(cls).queryRaw(str, strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void refresh(T t) {
        getDao(t.getClass()).refresh(t);
    }

    protected <T> void registerDao(Class<T> cls, a<T, ?> aVar) {
        this.entityToDao.put(cls, aVar);
    }

    public void runInTx(Runnable runnable) {
        this.db.D();
        try {
            runnable.run();
            this.db.E();
        } finally {
            this.db.F();
        }
    }

    public org.greenrobot.greendao.e.c rxTx() {
        if (this.rxTxIo == null) {
            this.rxTxIo = new org.greenrobot.greendao.e.c(this, Schedulers.io());
        }
        return this.rxTxIo;
    }

    public org.greenrobot.greendao.e.c rxTxPlain() {
        if (this.rxTxPlain == null) {
            this.rxTxPlain = new org.greenrobot.greendao.e.c(this);
        }
        return this.rxTxPlain;
    }

    public org.greenrobot.greendao.async.d startAsyncSession() {
        return new org.greenrobot.greendao.async.d(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void update(T t) {
        getDao(t.getClass()).update(t);
    }
}
