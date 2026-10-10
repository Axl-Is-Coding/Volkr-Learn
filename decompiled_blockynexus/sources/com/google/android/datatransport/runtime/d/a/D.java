package com.google.android.datatransport.runtime.d.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.q;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.a;
import com.umeng.analytics.pro.ay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
public class D implements InterfaceC2220d, com.google.android.datatransport.runtime.synchronization.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.datatransport.b f12854a = com.google.android.datatransport.b.a("proto");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final J f12855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.e.a f12856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.e.a f12857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AbstractC2221e f12858e;

    /* JADX INFO: compiled from: SQLiteEventStore.java */
    interface a<T, U> {
        U apply(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SQLiteEventStore.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f12859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f12860b;

        private b(String str, String str2) {
            this.f12859a = str;
            this.f12860b = str2;
        }
    }

    /* JADX INFO: compiled from: SQLiteEventStore.java */
    interface c<T> {
        T a();
    }

    D(com.google.android.datatransport.runtime.e.a aVar, com.google.android.datatransport.runtime.e.a aVar2, AbstractC2221e abstractC2221e, J j) {
        this.f12855b = j;
        this.f12856c = aVar;
        this.f12857d = aVar2;
        this.f12858e = abstractC2221e;
    }

    static /* synthetic */ SQLiteDatabase b(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    private static String c(Iterable<AbstractC2226j> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<AbstractC2226j> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    static /* synthetic */ byte[] d(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            byte[] bArr2 = (byte[]) arrayList.get(i);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    @Override // com.google.android.datatransport.runtime.d.a.InterfaceC2220d
    public int G() {
        return ((Integer) a(n.a(this.f12856c.getTime() - this.f12858e.c()))).intValue();
    }

    @Override // com.google.android.datatransport.runtime.d.a.InterfaceC2220d
    public Iterable<com.google.android.datatransport.runtime.q> I() {
        return (Iterable) a(m.a());
    }

    SQLiteDatabase a() {
        J j = this.f12855b;
        j.getClass();
        return (SQLiteDatabase) a(t.a(j), w.a());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12855b.close();
    }

    private Long b(SQLiteDatabase sQLiteDatabase, com.google.android.datatransport.runtime.q qVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(qVar.b(), String.valueOf(com.google.android.datatransport.runtime.f.a.a(qVar.d()))));
        if (qVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(qVar.c(), 0));
        }
        return (Long) a(sQLiteDatabase.query("transport_contexts", new String[]{ay.f20688d}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), y.a());
    }

    @Override // com.google.android.datatransport.runtime.d.a.InterfaceC2220d
    public AbstractC2226j a(com.google.android.datatransport.runtime.q qVar, com.google.android.datatransport.runtime.l lVar) {
        com.google.android.datatransport.runtime.b.a.a("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", qVar.d(), lVar.g(), qVar.b());
        long jLongValue = ((Long) a(x.a(this, qVar, lVar))).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return AbstractC2226j.a(jLongValue, qVar, lVar);
    }

    @Override // com.google.android.datatransport.runtime.d.a.InterfaceC2220d
    public Iterable<AbstractC2226j> c(com.google.android.datatransport.runtime.q qVar) {
        return (Iterable) a(l.a(this, qVar));
    }

    static /* synthetic */ List c(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            q.a aVarA = com.google.android.datatransport.runtime.q.a();
            aVarA.a(cursor.getString(1));
            aVarA.a(com.google.android.datatransport.runtime.f.a.a(cursor.getInt(2)));
            aVarA.a(a(cursor.getString(3)));
            arrayList.add(aVarA.a());
        }
        return arrayList;
    }

    private boolean d() {
        return b() * c() >= this.f12858e.f();
    }

    static /* synthetic */ Long a(D d2, com.google.android.datatransport.runtime.q qVar, com.google.android.datatransport.runtime.l lVar, SQLiteDatabase sQLiteDatabase) {
        if (d2.d()) {
            return -1L;
        }
        long jA = d2.a(sQLiteDatabase, qVar);
        int iE = d2.f12858e.e();
        byte[] bArrA = lVar.d().a();
        boolean z = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jA));
        contentValues.put("transport_name", lVar.g());
        contentValues.put("timestamp_ms", Long.valueOf(lVar.e()));
        contentValues.put("uptime_ms", Long.valueOf(lVar.h()));
        contentValues.put("payload_encoding", lVar.d().b().a());
        contentValues.put("code", lVar.c());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z));
        contentValues.put(MessengerShareContentUtility.ATTACHMENT_PAYLOAD, z ? bArrA : new byte[0]);
        long jInsert = sQLiteDatabase.insert(com.umeng.analytics.pro.b.ao, null, contentValues);
        if (!z) {
            double length = bArrA.length;
            double d3 = iE;
            Double.isNaN(length);
            Double.isNaN(d3);
            int iCeil = (int) Math.ceil(length / d3);
            for (int i = 1; i <= iCeil; i++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i - 1) * iE, Math.min(i * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i));
                contentValues2.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : lVar.f().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", entry.getKey());
            contentValues3.put("value", entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    static /* synthetic */ Long b(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    @Override // com.google.android.datatransport.runtime.d.a.InterfaceC2220d
    public void b(Iterable<AbstractC2226j> iterable) {
        if (iterable.iterator().hasNext()) {
            a(z.a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + c(iterable)));
        }
    }

    private List<AbstractC2226j> c(SQLiteDatabase sQLiteDatabase, com.google.android.datatransport.runtime.q qVar) {
        ArrayList arrayList = new ArrayList();
        Long lB = b(sQLiteDatabase, qVar);
        if (lB == null) {
            return arrayList;
        }
        a(sQLiteDatabase.query(com.umeng.analytics.pro.b.ao, new String[]{ay.f20688d, "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "code", "inline"}, "context_id = ?", new String[]{lB.toString()}, null, null, null, String.valueOf(this.f12858e.d())), o.a(this, arrayList, qVar));
        return arrayList;
    }

    @Override // com.google.android.datatransport.runtime.d.a.InterfaceC2220d
    public boolean b(com.google.android.datatransport.runtime.q qVar) {
        return ((Boolean) a(B.a(this, qVar))).booleanValue();
    }

    static /* synthetic */ List b(D d2, com.google.android.datatransport.runtime.q qVar, SQLiteDatabase sQLiteDatabase) {
        List<AbstractC2226j> listC = d2.c(sQLiteDatabase, qVar);
        d2.a(listC, d2.a(sQLiteDatabase, listC));
        return listC;
    }

    static /* synthetic */ List b(SQLiteDatabase sQLiteDatabase) {
        return (List) a(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), u.a());
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        a(r.a(sQLiteDatabase), s.a());
    }

    private long c() {
        return a().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private static com.google.android.datatransport.b b(String str) {
        if (str == null) {
            return f12854a;
        }
        return com.google.android.datatransport.b.a(str);
    }

    private long b() {
        return a().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private long a(SQLiteDatabase sQLiteDatabase, com.google.android.datatransport.runtime.q qVar) {
        Long lB = b(sQLiteDatabase, qVar);
        if (lB != null) {
            return lB.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", qVar.b());
        contentValues.put("priority", Integer.valueOf(com.google.android.datatransport.runtime.f.a.a(qVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (qVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(qVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    static /* synthetic */ Object a(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    @Override // com.google.android.datatransport.runtime.d.a.InterfaceC2220d
    public void a(Iterable<AbstractC2226j> iterable) {
        if (iterable.iterator().hasNext()) {
            a().compileStatement("DELETE FROM events WHERE _id in " + c(iterable)).execute();
        }
    }

    @Override // com.google.android.datatransport.runtime.d.a.InterfaceC2220d
    public long a(com.google.android.datatransport.runtime.q qVar) {
        return ((Long) a(a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{qVar.b(), String.valueOf(com.google.android.datatransport.runtime.f.a.a(qVar.d()))}), A.a())).longValue();
    }

    static /* synthetic */ Long a(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    static /* synthetic */ Boolean a(D d2, com.google.android.datatransport.runtime.q qVar, SQLiteDatabase sQLiteDatabase) {
        Long lB = d2.b(sQLiteDatabase, qVar);
        if (lB == null) {
            return false;
        }
        return (Boolean) a(d2.a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lB.toString()}), v.a());
    }

    @Override // com.google.android.datatransport.runtime.d.a.InterfaceC2220d
    public void a(com.google.android.datatransport.runtime.q qVar, long j) {
        a(C2227k.a(j, qVar));
    }

    static /* synthetic */ Object a(long j, com.google.android.datatransport.runtime.q qVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{qVar.b(), String.valueOf(com.google.android.datatransport.runtime.f.a.a(qVar.d()))}) < 1) {
            contentValues.put("backend_name", qVar.b());
            contentValues.put("priority", Integer.valueOf(com.google.android.datatransport.runtime.f.a.a(qVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    private static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    static /* synthetic */ Object a(D d2, List list, com.google.android.datatransport.runtime.q qVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            boolean z = cursor.getInt(7) != 0;
            l.a aVarA = com.google.android.datatransport.runtime.l.a();
            aVarA.a(cursor.getString(1));
            aVarA.a(cursor.getLong(2));
            aVarA.b(cursor.getLong(3));
            if (z) {
                aVarA.a(new com.google.android.datatransport.runtime.k(b(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                aVarA.a(new com.google.android.datatransport.runtime.k(b(cursor.getString(4)), d2.a(j)));
            }
            if (!cursor.isNull(6)) {
                aVarA.a(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(AbstractC2226j.a(j, qVar, aVarA.a()));
        }
        return null;
    }

    private byte[] a(long j) {
        return (byte[]) a(a().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num"), p.a());
    }

    private Map<Long, Set<b>> a(SQLiteDatabase sQLiteDatabase, List<AbstractC2226j> list) {
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).b());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        a(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), q.a(map));
        return map;
    }

    static /* synthetic */ Object a(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j), hashSet);
            }
            hashSet.add(new b(cursor.getString(1), cursor.getString(2)));
        }
    }

    private List<AbstractC2226j> a(List<AbstractC2226j> list, Map<Long, Set<b>> map) {
        ListIterator<AbstractC2226j> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            AbstractC2226j next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.b()))) {
                l.a aVarI = next.a().i();
                for (b bVar : map.get(Long.valueOf(next.b()))) {
                    aVarI.a(bVar.f12859a, bVar.f12860b);
                }
                listIterator.set(AbstractC2226j.a(next.b(), next.c(), aVarI.a()));
            }
        }
        return list;
    }

    private <T> T a(c<T> cVar, a<Throwable, T> aVar) {
        long time = this.f12857d.getTime();
        while (true) {
            try {
                return cVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.f12857d.getTime() >= ((long) this.f12858e.b()) + time) {
                    return aVar.apply(e2);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    static /* synthetic */ Object a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    static /* synthetic */ Object a(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a
    public <T> T a(a.InterfaceC0103a<T> interfaceC0103a) {
        SQLiteDatabase sQLiteDatabaseA = a();
        c(sQLiteDatabaseA);
        try {
            T tExecute = interfaceC0103a.execute();
            sQLiteDatabaseA.setTransactionSuccessful();
            return tExecute;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    private <T> T a(a<SQLiteDatabase, T> aVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            T tApply = aVar.apply(sQLiteDatabaseA);
            sQLiteDatabaseA.setTransactionSuccessful();
            return tApply;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    private static <T> T a(Cursor cursor, a<Cursor, T> aVar) {
        try {
            return aVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }
}
