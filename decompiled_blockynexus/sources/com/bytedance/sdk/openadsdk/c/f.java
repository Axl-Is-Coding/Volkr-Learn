package com.bytedance.sdk.openadsdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: AdEventRepertoryImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements e<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.d f5750b = com.bytedance.sdk.openadsdk.core.d.a(c());

    public f(Context context) {
        this.f5749a = context;
    }

    private synchronized void b(int i, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        com.bytedance.sdk.openadsdk.multipro.a.a.a(c(), "adevent", "gen_time <? AND retry >?", new String[]{jCurrentTimeMillis + "", i + ""});
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0)";
    }

    public Context c() {
        Context context = this.f5749a;
        return context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0041 A[EXC_TOP_SPLITTER, LOOP:0: B:32:0x0041->B:35:0x0041, LOOP_START, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.c.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.bytedance.sdk.openadsdk.c.a> a(int r9, java.lang.String r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            if (r9 <= 0) goto L1e
            boolean r1 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L78
            if (r1 != 0) goto L1e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L78
            r0.<init>()     // Catch: java.lang.Throwable -> L78
            r0.append(r10)     // Catch: java.lang.Throwable -> L78
            java.lang.String r10 = " DESC limit "
            r0.append(r10)     // Catch: java.lang.Throwable -> L78
            r0.append(r9)     // Catch: java.lang.Throwable -> L78
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L78
        L1e:
            r7 = r0
            java.util.LinkedList r9 = new java.util.LinkedList     // Catch: java.lang.Throwable -> L78
            r9.<init>()     // Catch: java.lang.Throwable -> L78
            android.content.Context r0 = r8.c()     // Catch: java.lang.Throwable -> L78
            java.lang.String r1 = "adevent"
            r10 = 2
            java.lang.String[] r2 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L78
            r10 = 0
            java.lang.String r3 = "id"
            r2[r10] = r3     // Catch: java.lang.Throwable -> L78
            r10 = 1
            java.lang.String r3 = "value"
            r2[r10] = r3     // Catch: java.lang.Throwable -> L78
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r10 = com.bytedance.sdk.openadsdk.multipro.a.a.a(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L78
            if (r10 == 0) goto L76
        L41:
            boolean r0 = r10.moveToNext()     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L69
            java.lang.String r0 = "id"
            int r0 = r10.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = "value"
            int r1 = r10.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = r10.getString(r1)     // Catch: java.lang.Throwable -> L6f
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L41 java.lang.Throwable -> L6f
            r2.<init>(r1)     // Catch: org.json.JSONException -> L41 java.lang.Throwable -> L6f
            com.bytedance.sdk.openadsdk.c.a r1 = new com.bytedance.sdk.openadsdk.c.a     // Catch: org.json.JSONException -> L41 java.lang.Throwable -> L6f
            r1.<init>(r0, r2)     // Catch: org.json.JSONException -> L41 java.lang.Throwable -> L6f
            r9.add(r1)     // Catch: org.json.JSONException -> L41 java.lang.Throwable -> L6f
            goto L41
        L69:
            if (r10 == 0) goto L76
            r10.close()     // Catch: java.lang.Throwable -> L78
            goto L76
        L6f:
            r9 = move-exception
            if (r10 == 0) goto L75
            r10.close()     // Catch: java.lang.Throwable -> L78
        L75:
            throw r9     // Catch: java.lang.Throwable -> L78
        L76:
            monitor-exit(r8)
            return r9
        L78:
            r9 = move-exception
            monitor-exit(r8)
            goto L7c
        L7b:
            throw r9
        L7c:
            goto L7b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.f.a(int, java.lang.String):java.util.List");
    }

    private synchronized void b(List<a> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().f5741a);
        }
        com.bytedance.sdk.openadsdk.multipro.a.a.a(c(), "UPDATE adevent SET retry = retry+1 WHERE " + a("id", linkedList, 1000, true));
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.f5741a);
        contentValues.put("value", aVar.f5742b.toString());
        contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry", (Integer) 0);
        com.bytedance.sdk.openadsdk.multipro.a.a.a(c(), "adevent", contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public int b() {
        return this.f5750b.b("serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<a> list) {
        if (com.bytedance.sdk.openadsdk.utils.m.a(list)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().f5741a);
        }
        com.bytedance.sdk.openadsdk.multipro.a.a.a(c(), "DELETE FROM adevent WHERE " + a("id", linkedList, 1000, true));
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(int i, long j) {
        b(i, j);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<a> list, int i, long j) {
        if (com.bytedance.sdk.openadsdk.utils.m.a(list)) {
            return;
        }
        try {
            b(list);
            b(i, j);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(boolean z) {
        this.f5750b.a("serverbusy_flag", z);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public boolean a() {
        return this.f5750b.b("serverbusy_flag", false);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(int i) {
        this.f5750b.a("serverbusy_retrycount", i);
    }

    private static String a(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int iMin = Math.min(i, 1000);
        int size = list.size();
        if (size % iMin == 0) {
            i2 = size / iMin;
        } else {
            i2 = (size / iMin) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * iMin;
            String strA = a(TextUtils.join("','", list.subList(i4, Math.min(i4 + iMin, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(strA);
            sb.append("')");
        }
        return a(sb.toString(), str + str2 + "('')");
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
