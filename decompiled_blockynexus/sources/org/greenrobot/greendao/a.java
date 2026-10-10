package org.greenrobot.greendao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.d.h;
import org.greenrobot.greendao.d.i;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: AbstractDao.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T, K> {
    protected final org.greenrobot.greendao.c.a config;
    protected final org.greenrobot.greendao.b.a db;
    protected final org.greenrobot.greendao.identityscope.a<K, T> identityScope;
    protected final org.greenrobot.greendao.identityscope.b<T> identityScopeLong;
    protected final boolean isStandardSQLite;
    protected final int pkOrdinal;
    private volatile org.greenrobot.greendao.e.b<T, K> rxDao;
    private volatile org.greenrobot.greendao.e.b<T, K> rxDaoPlain;
    protected final c session;
    protected final org.greenrobot.greendao.c.e statements;

    public a(org.greenrobot.greendao.c.a aVar) {
        this(aVar, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void deleteByKeyInsideSynchronized(K k, org.greenrobot.greendao.b.c cVar) {
        if (k instanceof Long) {
            cVar.a(1, ((Long) k).longValue());
        } else {
            if (k == 0) {
                throw new DaoException("Cannot delete entity, key is null");
            }
            cVar.a(1, k.toString());
        }
        cVar.execute();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040 A[Catch: all -> 0x003c, TryCatch #2 {all -> 0x003c, blocks: (B:10:0x0021, B:11:0x0025, B:13:0x002b, B:15:0x0038, B:19:0x0040, B:20:0x0044, B:22:0x004a, B:24:0x0053), top: B:50:0x0021, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065 A[Catch: all -> 0x0081, Merged into TryCatch #1 {all -> 0x0084, blocks: (B:3:0x000e, B:34:0x006b, B:36:0x0072, B:38:0x0076, B:43:0x0083, B:4:0x000f, B:6:0x0013, B:30:0x0061, B:32:0x0065, B:33:0x006a, B:26:0x0057, B:28:0x005b, B:29:0x0060, B:10:0x0021, B:11:0x0025, B:13:0x002b, B:15:0x0038, B:19:0x0040, B:20:0x0044, B:22:0x004a, B:24:0x0053), top: B:49:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void deleteInTxInternal(java.lang.Iterable<T> r4, java.lang.Iterable<K> r5) {
        /*
            r3 = this;
            r3.assertSinglePk()
            org.greenrobot.greendao.c.e r0 = r3.statements
            org.greenrobot.greendao.b.c r0 = r0.b()
            org.greenrobot.greendao.b.a r1 = r3.db
            r1.D()
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L84
            org.greenrobot.greendao.identityscope.a<K, T> r1 = r3.identityScope     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L1e
            org.greenrobot.greendao.identityscope.a<K, T> r1 = r3.identityScope     // Catch: java.lang.Throwable -> L81
            r1.lock()     // Catch: java.lang.Throwable -> L81
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L81
            r1.<init>()     // Catch: java.lang.Throwable -> L81
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r4 == 0) goto L3e
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L3c
        L25:
            boolean r2 = r4.hasNext()     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L3e
            java.lang.Object r2 = r4.next()     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r2 = r3.getKeyVerified(r2)     // Catch: java.lang.Throwable -> L3c
            r3.deleteByKeyInsideSynchronized(r2, r0)     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L25
            r1.add(r2)     // Catch: java.lang.Throwable -> L3c
            goto L25
        L3c:
            r4 = move-exception
            goto L57
        L3e:
            if (r5 == 0) goto L61
            java.util.Iterator r4 = r5.iterator()     // Catch: java.lang.Throwable -> L3c
        L44:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L61
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L3c
            r3.deleteByKeyInsideSynchronized(r5, r0)     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L44
            r1.add(r5)     // Catch: java.lang.Throwable -> L3c
            goto L44
        L57:
            org.greenrobot.greendao.identityscope.a<K, T> r5 = r3.identityScope     // Catch: java.lang.Throwable -> L81
            if (r5 == 0) goto L60
            org.greenrobot.greendao.identityscope.a<K, T> r5 = r3.identityScope     // Catch: java.lang.Throwable -> L81
            r5.unlock()     // Catch: java.lang.Throwable -> L81
        L60:
            throw r4     // Catch: java.lang.Throwable -> L81
        L61:
            org.greenrobot.greendao.identityscope.a<K, T> r4 = r3.identityScope     // Catch: java.lang.Throwable -> L81
            if (r4 == 0) goto L6a
            org.greenrobot.greendao.identityscope.a<K, T> r4 = r3.identityScope     // Catch: java.lang.Throwable -> L81
            r4.unlock()     // Catch: java.lang.Throwable -> L81
        L6a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L81
            org.greenrobot.greendao.b.a r4 = r3.db     // Catch: java.lang.Throwable -> L84
            r4.E()     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto L7b
            org.greenrobot.greendao.identityscope.a<K, T> r4 = r3.identityScope     // Catch: java.lang.Throwable -> L84
            if (r4 == 0) goto L7b
            org.greenrobot.greendao.identityscope.a<K, T> r4 = r3.identityScope     // Catch: java.lang.Throwable -> L84
            r4.a(r1)     // Catch: java.lang.Throwable -> L84
        L7b:
            org.greenrobot.greendao.b.a r4 = r3.db
            r4.F()
            return
        L81:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L81
            throw r4     // Catch: java.lang.Throwable -> L84
        L84:
            r4 = move-exception
            org.greenrobot.greendao.b.a r5 = r3.db
            r5.F()
            goto L8c
        L8b:
            throw r4
        L8c:
            goto L8b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.a.deleteInTxInternal(java.lang.Iterable, java.lang.Iterable):void");
    }

    private long executeInsert(T t, org.greenrobot.greendao.b.c cVar, boolean z) {
        long jInsertInsideTx;
        if (this.db.b()) {
            jInsertInsideTx = insertInsideTx(t, cVar);
        } else {
            this.db.D();
            try {
                jInsertInsideTx = insertInsideTx(t, cVar);
                this.db.E();
            } finally {
                this.db.F();
            }
        }
        if (z) {
            updateKeyAfterInsertAndAttach(t, jInsertInsideTx, true);
        }
        return jInsertInsideTx;
    }

    private void executeInsertInTx(org.greenrobot.greendao.b.c cVar, Iterable<T> iterable, boolean z) {
        this.db.D();
        try {
            synchronized (cVar) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                }
                try {
                    if (this.isStandardSQLite) {
                        SQLiteStatement sQLiteStatement = (SQLiteStatement) cVar.a();
                        for (T t : iterable) {
                            bindValues(sQLiteStatement, t);
                            if (z) {
                                updateKeyAfterInsertAndAttach(t, sQLiteStatement.executeInsert(), false);
                            } else {
                                sQLiteStatement.execute();
                            }
                        }
                    } else {
                        for (T t2 : iterable) {
                            bindValues(cVar, t2);
                            if (z) {
                                updateKeyAfterInsertAndAttach(t2, cVar.b(), false);
                            } else {
                                cVar.execute();
                            }
                        }
                    }
                } finally {
                    if (this.identityScope != null) {
                        this.identityScope.unlock();
                    }
                }
            }
            this.db.E();
        } finally {
            this.db.F();
        }
    }

    private long insertInsideTx(T t, org.greenrobot.greendao.b.c cVar) {
        synchronized (cVar) {
            if (!this.isStandardSQLite) {
                bindValues(cVar, t);
                return cVar.b();
            }
            SQLiteStatement sQLiteStatement = (SQLiteStatement) cVar.a();
            bindValues(sQLiteStatement, t);
            return sQLiteStatement.executeInsert();
        }
    }

    private void loadAllUnlockOnWindowBounds(Cursor cursor, CursorWindow cursorWindow, List<T> list) {
        int startPosition = cursorWindow.getStartPosition() + cursorWindow.getNumRows();
        int i = 0;
        while (true) {
            list.add(loadCurrent(cursor, 0, false));
            int i2 = i + 1;
            if (i2 >= startPosition) {
                CursorWindow cursorWindowMoveToNextUnlocked = moveToNextUnlocked(cursor);
                if (cursorWindowMoveToNextUnlocked == null) {
                    return;
                } else {
                    startPosition = cursorWindowMoveToNextUnlocked.getStartPosition() + cursorWindowMoveToNextUnlocked.getNumRows();
                }
            } else if (!cursor.moveToNext()) {
                return;
            }
            i = i2 + 1;
        }
    }

    private CursorWindow moveToNextUnlocked(Cursor cursor) {
        this.identityScope.unlock();
        try {
            return cursor.moveToNext() ? ((CrossProcessCursor) cursor).getWindow() : null;
        } finally {
            this.identityScope.lock();
        }
    }

    protected void assertSinglePk() {
        if (this.config.f23573e.length == 1) {
            return;
        }
        throw new DaoException(this + " (" + this.config.f23570b + ") does not have a single-column primary key");
    }

    protected void attachEntity(T t) {
    }

    protected final void attachEntity(K k, T t, boolean z) {
        attachEntity(t);
        org.greenrobot.greendao.identityscope.a<K, T> aVar = this.identityScope;
        if (aVar == null || k == null) {
            return;
        }
        if (z) {
            aVar.put(k, t);
        } else {
            aVar.a(k, t);
        }
    }

    protected abstract void bindValues(SQLiteStatement sQLiteStatement, T t);

    protected abstract void bindValues(org.greenrobot.greendao.b.c cVar, T t);

    public long count() {
        return this.statements.a().c();
    }

    public void delete(T t) {
        assertSinglePk();
        deleteByKey(getKeyVerified(t));
    }

    public void deleteAll() {
        this.db.a("DELETE FROM '" + this.config.f23570b + "'");
        org.greenrobot.greendao.identityscope.a<K, T> aVar = this.identityScope;
        if (aVar != null) {
            aVar.clear();
        }
    }

    public void deleteByKey(K k) {
        assertSinglePk();
        org.greenrobot.greendao.b.c cVarB = this.statements.b();
        if (this.db.b()) {
            synchronized (cVarB) {
                deleteByKeyInsideSynchronized(k, cVarB);
            }
        } else {
            this.db.D();
            try {
                synchronized (cVarB) {
                    deleteByKeyInsideSynchronized(k, cVarB);
                }
                this.db.E();
            } finally {
                this.db.F();
            }
        }
        org.greenrobot.greendao.identityscope.a<K, T> aVar = this.identityScope;
        if (aVar != null) {
            aVar.remove(k);
        }
    }

    public void deleteByKeyInTx(Iterable<K> iterable) {
        deleteInTxInternal(null, iterable);
    }

    public void deleteInTx(Iterable<T> iterable) {
        deleteInTxInternal(iterable, null);
    }

    public boolean detach(T t) {
        if (this.identityScope == null) {
            return false;
        }
        return this.identityScope.b(getKeyVerified(t), t);
    }

    public void detachAll() {
        org.greenrobot.greendao.identityscope.a<K, T> aVar = this.identityScope;
        if (aVar != null) {
            aVar.clear();
        }
    }

    public String[] getAllColumns() {
        return this.config.f23572d;
    }

    public org.greenrobot.greendao.b.a getDatabase() {
        return this.db;
    }

    protected abstract K getKey(T t);

    protected K getKeyVerified(T t) {
        K key = getKey(t);
        if (key != null) {
            return key;
        }
        if (t == null) {
            throw new NullPointerException("Entity may not be null");
        }
        throw new DaoException("Entity has no key");
    }

    public String[] getNonPkColumns() {
        return this.config.f23574f;
    }

    public String[] getPkColumns() {
        return this.config.f23573e;
    }

    public f getPkProperty() {
        return this.config.g;
    }

    public f[] getProperties() {
        return this.config.f23571c;
    }

    public c getSession() {
        return this.session;
    }

    org.greenrobot.greendao.c.e getStatements() {
        return this.config.i;
    }

    public String getTablename() {
        return this.config.f23570b;
    }

    protected abstract boolean hasKey(T t);

    public long insert(T t) {
        return executeInsert(t, this.statements.d(), true);
    }

    public void insertInTx(Iterable<T> iterable) {
        insertInTx(iterable, isEntityUpdateable());
    }

    public long insertOrReplace(T t) {
        return executeInsert(t, this.statements.c(), true);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.c(), iterable, z);
    }

    public long insertWithoutSettingPk(T t) {
        return executeInsert(t, this.statements.c(), false);
    }

    protected abstract boolean isEntityUpdateable();

    public T load(K k) {
        T t;
        assertSinglePk();
        if (k == null) {
            return null;
        }
        org.greenrobot.greendao.identityscope.a<K, T> aVar = this.identityScope;
        return (aVar == null || (t = aVar.get(k)) == null) ? loadUniqueAndCloseCursor(this.db.a(this.statements.f(), new String[]{k.toString()})) : t;
    }

    public List<T> loadAll() {
        return loadAllAndCloseCursor(this.db.a(this.statements.e(), (String[]) null));
    }

    protected List<T> loadAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.util.List<T> loadAllFromCursor(android.database.Cursor r7) {
        /*
            r6 = this;
            int r0 = r7.getCount()
            if (r0 != 0) goto Lc
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            return r7
        Lc:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r2 = 0
            boolean r3 = r7 instanceof android.database.CrossProcessCursor
            r4 = 0
            if (r3 == 0) goto L4d
            r2 = r7
            android.database.CrossProcessCursor r2 = (android.database.CrossProcessCursor) r2
            android.database.CursorWindow r2 = r2.getWindow()
            if (r2 == 0) goto L4d
            int r3 = r2.getNumRows()
            if (r3 != r0) goto L2d
            org.greenrobot.greendao.c.b r7 = new org.greenrobot.greendao.c.b
            r7.<init>(r2)
            r3 = 1
            goto L4e
        L2d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Window vs. result size: "
            r3.append(r5)
            int r5 = r2.getNumRows()
            r3.append(r5)
            java.lang.String r5 = "/"
            r3.append(r5)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            org.greenrobot.greendao.d.a(r3)
        L4d:
            r3 = 0
        L4e:
            boolean r5 = r7.moveToFirst()
            if (r5 == 0) goto L8a
            org.greenrobot.greendao.identityscope.a<K, T> r5 = r6.identityScope
            if (r5 == 0) goto L60
            r5.lock()
            org.greenrobot.greendao.identityscope.a<K, T> r5 = r6.identityScope
            r5.a(r0)
        L60:
            if (r3 != 0) goto L6c
            if (r2 == 0) goto L6c
            org.greenrobot.greendao.identityscope.a<K, T> r0 = r6.identityScope     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L6c
            r6.loadAllUnlockOnWindowBounds(r7, r2, r1)     // Catch: java.lang.Throwable -> L81
            goto L79
        L6c:
            java.lang.Object r0 = r6.loadCurrent(r7, r4, r4)     // Catch: java.lang.Throwable -> L81
            r1.add(r0)     // Catch: java.lang.Throwable -> L81
            boolean r0 = r7.moveToNext()     // Catch: java.lang.Throwable -> L81
            if (r0 != 0) goto L6c
        L79:
            org.greenrobot.greendao.identityscope.a<K, T> r7 = r6.identityScope
            if (r7 == 0) goto L8a
            r7.unlock()
            goto L8a
        L81:
            r7 = move-exception
            org.greenrobot.greendao.identityscope.a<K, T> r0 = r6.identityScope
            if (r0 == 0) goto L89
            r0.unlock()
        L89:
            throw r7
        L8a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.a.loadAllFromCursor(android.database.Cursor):java.util.List");
    }

    public T loadByRowId(long j) {
        return loadUniqueAndCloseCursor(this.db.a(this.statements.g(), new String[]{Long.toString(j)}));
    }

    protected final T loadCurrent(Cursor cursor, int i, boolean z) {
        if (this.identityScopeLong != null) {
            if (i != 0 && cursor.isNull(this.pkOrdinal + i)) {
                return null;
            }
            long j = cursor.getLong(this.pkOrdinal + i);
            T tA = z ? this.identityScopeLong.a(j) : this.identityScopeLong.b(j);
            if (tA != null) {
                return tA;
            }
            T entity = readEntity(cursor, i);
            attachEntity(entity);
            if (z) {
                this.identityScopeLong.a(j, entity);
            } else {
                this.identityScopeLong.b(j, entity);
            }
            return entity;
        }
        if (this.identityScope == null) {
            if (i != 0 && readKey(cursor, i) == null) {
                return null;
            }
            T entity2 = readEntity(cursor, i);
            attachEntity(entity2);
            return entity2;
        }
        K key = readKey(cursor, i);
        if (i != 0 && key == null) {
            return null;
        }
        T tA2 = z ? this.identityScope.get(key) : this.identityScope.a(key);
        if (tA2 != null) {
            return tA2;
        }
        T entity3 = readEntity(cursor, i);
        attachEntity(key, entity3, z);
        return entity3;
    }

    protected final <O> O loadCurrentOther(a<O, ?> aVar, Cursor cursor, int i) {
        return aVar.loadCurrent(cursor, i, true);
    }

    protected T loadUnique(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        if (cursor.isLast()) {
            return loadCurrent(cursor, 0, true);
        }
        throw new DaoException("Expected unique result, but count was " + cursor.getCount());
    }

    protected T loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            return loadUnique(cursor);
        } finally {
            cursor.close();
        }
    }

    public i<T> queryBuilder() {
        return i.a(this);
    }

    public List<T> queryRaw(String str, String... strArr) {
        return loadAllAndCloseCursor(this.db.a(this.statements.e() + str, strArr));
    }

    public h<T> queryRawCreate(String str, Object... objArr) {
        return queryRawCreateListArgs(str, Arrays.asList(objArr));
    }

    public h<T> queryRawCreateListArgs(String str, Collection<Object> collection) {
        return h.a(this, this.statements.e() + str, collection.toArray());
    }

    protected abstract T readEntity(Cursor cursor, int i);

    protected abstract void readEntity(Cursor cursor, T t, int i);

    protected abstract K readKey(Cursor cursor, int i);

    public void refresh(T t) {
        assertSinglePk();
        K keyVerified = getKeyVerified(t);
        Cursor cursorA = this.db.a(this.statements.f(), new String[]{keyVerified.toString()});
        try {
            if (!cursorA.moveToFirst()) {
                throw new DaoException("Entity does not exist in the database anymore: " + t.getClass() + " with key " + keyVerified);
            }
            if (cursorA.isLast()) {
                readEntity(cursorA, t, 0);
                attachEntity(keyVerified, t, true);
            } else {
                throw new DaoException("Expected unique result, but count was " + cursorA.getCount());
            }
        } finally {
            cursorA.close();
        }
    }

    public org.greenrobot.greendao.e.b<T, K> rx() {
        if (this.rxDao == null) {
            this.rxDao = new org.greenrobot.greendao.e.b<>(this, Schedulers.io());
        }
        return this.rxDao;
    }

    public org.greenrobot.greendao.e.b<T, K> rxPlain() {
        if (this.rxDaoPlain == null) {
            this.rxDaoPlain = new org.greenrobot.greendao.e.b<>(this);
        }
        return this.rxDaoPlain;
    }

    public void save(T t) {
        if (hasKey(t)) {
            update(t);
        } else {
            insert(t);
        }
    }

    public void saveInTx(T... tArr) {
        saveInTx(Arrays.asList(tArr));
    }

    public void update(T t) {
        assertSinglePk();
        org.greenrobot.greendao.b.c cVarH = this.statements.h();
        if (this.db.b()) {
            synchronized (cVarH) {
                if (this.isStandardSQLite) {
                    updateInsideSynchronized((Object) t, (SQLiteStatement) cVarH.a(), true);
                } else {
                    updateInsideSynchronized((Object) t, cVarH, true);
                }
            }
            return;
        }
        this.db.D();
        try {
            synchronized (cVarH) {
                updateInsideSynchronized((Object) t, cVarH, true);
            }
            this.db.E();
        } finally {
            this.db.F();
        }
    }

    public void updateInTx(Iterable<T> iterable) {
        org.greenrobot.greendao.b.c cVarH = this.statements.h();
        this.db.D();
        try {
            synchronized (cVarH) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                }
                try {
                    if (this.isStandardSQLite) {
                        SQLiteStatement sQLiteStatement = (SQLiteStatement) cVarH.a();
                        Iterator<T> it = iterable.iterator();
                        while (it.hasNext()) {
                            updateInsideSynchronized((Object) it.next(), sQLiteStatement, false);
                        }
                    } else {
                        Iterator<T> it2 = iterable.iterator();
                        while (it2.hasNext()) {
                            updateInsideSynchronized((Object) it2.next(), cVarH, false);
                        }
                    }
                } finally {
                    if (this.identityScope != null) {
                        this.identityScope.unlock();
                    }
                }
            }
            this.db.E();
            try {
                this.db.F();
                e = null;
            } catch (RuntimeException e2) {
                throw e2;
            }
        } catch (RuntimeException e3) {
            e = e3;
            try {
                this.db.F();
            } catch (RuntimeException e4) {
                d.c("Could not end transaction (rethrowing initial exception)", e4);
                throw e;
            }
        } catch (Throwable th) {
            try {
                this.db.F();
                throw th;
            } catch (RuntimeException e5) {
                throw e5;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void updateInsideSynchronized(T t, org.greenrobot.greendao.b.c cVar, boolean z) {
        bindValues(cVar, t);
        int length = this.config.f23572d.length + 1;
        Object key = getKey(t);
        if (key instanceof Long) {
            cVar.a(length, ((Long) key).longValue());
        } else {
            if (key == null) {
                throw new DaoException("Cannot update entity without key - was it inserted before?");
            }
            cVar.a(length, key.toString());
        }
        cVar.execute();
        attachEntity(key, t, z);
    }

    protected abstract K updateKeyAfterInsert(T t, long j);

    protected void updateKeyAfterInsertAndAttach(T t, long j, boolean z) {
        if (j != -1) {
            attachEntity(updateKeyAfterInsert(t, j), t, z);
        } else {
            d.c("Could not insert row (executeInsert returned -1)");
        }
    }

    public a(org.greenrobot.greendao.c.a aVar, c cVar) {
        this.config = aVar;
        this.session = cVar;
        this.db = aVar.f23569a;
        this.isStandardSQLite = this.db.a() instanceof SQLiteDatabase;
        this.identityScope = (org.greenrobot.greendao.identityscope.a<K, T>) aVar.c();
        org.greenrobot.greendao.identityscope.a<K, T> aVar2 = this.identityScope;
        if (aVar2 instanceof org.greenrobot.greendao.identityscope.b) {
            this.identityScopeLong = (org.greenrobot.greendao.identityscope.b) aVar2;
        } else {
            this.identityScopeLong = null;
        }
        this.statements = aVar.i;
        f fVar = aVar.g;
        this.pkOrdinal = fVar != null ? fVar.f23630a : -1;
    }

    public void deleteByKeyInTx(K... kArr) {
        deleteInTxInternal(null, Arrays.asList(kArr));
    }

    public void deleteInTx(T... tArr) {
        deleteInTxInternal(Arrays.asList(tArr), null);
    }

    public void insertInTx(T... tArr) {
        insertInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public void saveInTx(Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            if (hasKey(it.next())) {
                i++;
            } else {
                i2++;
            }
        }
        if (i <= 0 || i2 <= 0) {
            if (i2 > 0) {
                insertInTx(iterable);
                return;
            } else {
                if (i > 0) {
                    updateInTx(iterable);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList(i);
        ArrayList arrayList2 = new ArrayList(i2);
        for (T t : iterable) {
            if (hasKey(t)) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        this.db.D();
        try {
            updateInTx(arrayList);
            insertInTx(arrayList2);
            this.db.E();
        } finally {
            this.db.F();
        }
    }

    public void insertInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.d(), iterable, z);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable) {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(T... tArr) {
        insertOrReplaceInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void updateInsideSynchronized(T t, SQLiteStatement sQLiteStatement, boolean z) {
        bindValues(sQLiteStatement, t);
        int length = this.config.f23572d.length + 1;
        Object key = getKey(t);
        if (key instanceof Long) {
            sQLiteStatement.bindLong(length, ((Long) key).longValue());
        } else if (key != null) {
            sQLiteStatement.bindString(length, key.toString());
        } else {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        }
        sQLiteStatement.execute();
        attachEntity(key, t, z);
    }

    public void updateInTx(T... tArr) {
        updateInTx(Arrays.asList(tArr));
    }
}
