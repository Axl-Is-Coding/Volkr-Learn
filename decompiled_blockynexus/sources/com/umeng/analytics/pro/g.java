package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.c;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfigEx;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMStoreManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f20859a = 2049;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f20860b = 2050;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f20861c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f20862d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f20863e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f20864f = "umeng+";
    private static final String g = "ek__id";
    private static final String h = "ek_key";
    private List<String> i;
    private List<Integer> j;
    private String k;
    private List<String> l;

    /* JADX INFO: compiled from: UMStoreManager.java */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* JADX INFO: compiled from: UMStoreManager.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f20871a = new g();

        private b() {
        }
    }

    public static g a(Context context) {
        g gVar = b.f20871a;
        if (f20862d == null && context != null) {
            f20862d = context.getApplicationContext();
            gVar.k();
        }
        return gVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.i.clear();
            this.l.clear();
            this.j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(f20863e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(f20862d, g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(f20862d).getString(g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = DeviceConfigEx.getDBencryptID(f20862d);
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(f20862d, g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String strSubstring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < strSubstring.length(); i++) {
                        char cCharAt = strSubstring.charAt(i);
                        if (!Character.isDigit(cCharAt)) {
                            sb.append(cCharAt);
                        } else if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                        }
                    }
                    f20863e = sb.toString();
                }
                if (TextUtils.isEmpty(f20863e)) {
                    return;
                }
                f20863e += new StringBuilder(f20863e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(f20862d, h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(f20862d, h, c(f20864f));
                } else {
                    if (f20864f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.l.clear();
    }

    public boolean c() {
        return this.l.isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0075 A[EXC_TOP_SPLITTER, PHI: r0
      0x0075: PHI (r0v6 android.database.sqlite.SQLiteDatabase) = 
      (r0v1 android.database.sqlite.SQLiteDatabase)
      (r0v2 android.database.sqlite.SQLiteDatabase)
      (r0v9 android.database.sqlite.SQLiteDatabase)
     binds: [B:19:0x0073, B:23:0x0087, B:15:0x006e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            r6 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            com.umeng.analytics.pro.s r1 = com.umeng.analytics.pro.s.a()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            if (r2 == 0) goto L2b
            if (r0 == 0) goto L21
            r0.endTransaction()     // Catch: java.lang.Throwable -> L21
        L21:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            return
        L2b:
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r3 = ""
            r4 = 0
            r2[r4] = r3     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r3 = "-1"
            r5 = 1
            r2[r5] = r3     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
        L38:
            int r3 = r2.length     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            if (r4 >= r3) goto L6b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            r3.<init>()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r5 = "update __et set __i=\""
            r3.append(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            r3.append(r1)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r5 = "\" where "
            r3.append(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r5 = "__i"
            r3.append(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r5 = "=\""
            r3.append(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            r3.append(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r5 = "\""
            r3.append(r5)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            r0.execSQL(r3)     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            int r4 = r4 + 1
            goto L38
        L6b:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L82
            if (r0 == 0) goto L78
            goto L75
        L71:
            r1 = move-exception
            goto L8b
        L73:
            if (r0 == 0) goto L78
        L75:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L78
        L78:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L8a
        L82:
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L71
            com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L78
            goto L75
        L8a:
            return
        L8b:
            if (r0 == 0) goto L90
            r0.endTransaction()     // Catch: java.lang.Throwable -> L90
        L90:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L9b
        L9a:
            throw r1
        L9b:
            goto L9a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.d():void");
    }

    public boolean e() {
        return this.i.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0084 A[EXC_TOP_SPLITTER, PHI: r2 r5
      0x0084: PHI (r2v8 ??) = (r2v7 ??), (r2v9 ??) binds: [B:32:0x0082, B:39:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x0084: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:32:0x0082, B:39:0x009d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject f() throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r8.l
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            com.umeng.analytics.pro.e r2 = com.umeng.analytics.pro.e.a(r2)     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            java.util.List<java.lang.String> r4 = r8.l     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            java.lang.String r6 = "select *  from __is where __ii=?"
            r7 = 1
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            r7[r5] = r4     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            android.database.Cursor r4 = r2.rawQuery(r6, r7)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            if (r4 == 0) goto L53
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L71
            if (r5 == 0) goto L53
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L71
            r5.<init>()     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L71
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6f android.database.sqlite.SQLiteDatabaseCorruptException -> L72
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6f android.database.sqlite.SQLiteDatabaseCorruptException -> L72
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6f android.database.sqlite.SQLiteDatabaseCorruptException -> L72
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6f android.database.sqlite.SQLiteDatabaseCorruptException -> L72
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6f android.database.sqlite.SQLiteDatabaseCorruptException -> L72
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6f android.database.sqlite.SQLiteDatabaseCorruptException -> L72
            r3 = r5
        L53:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L71
            if (r4 == 0) goto L5b
            r4.close()
        L5b:
            if (r2 == 0) goto L60
            r2.endTransaction()     // Catch: java.lang.Throwable -> L60
        L60:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            r5 = r3
            goto La0
        L6b:
            r0 = move-exception
            r3 = r4
            goto La2
        L6e:
            r5 = r3
        L6f:
            r3 = r4
            goto L7d
        L71:
            r5 = r3
        L72:
            r3 = r4
            goto L93
        L74:
            r5 = r3
            goto L7d
        L76:
            r5 = r3
            goto L93
        L78:
            r0 = move-exception
            r2 = r3
            goto La2
        L7b:
            r2 = r3
            r5 = r2
        L7d:
            if (r3 == 0) goto L82
            r3.close()
        L82:
            if (r2 == 0) goto L87
        L84:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L87
        L87:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto La0
        L91:
            r2 = r3
            r5 = r2
        L93:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> La1
            com.umeng.analytics.pro.f.a(r0)     // Catch: java.lang.Throwable -> La1
            if (r3 == 0) goto L9d
            r3.close()
        L9d:
            if (r2 == 0) goto L87
            goto L84
        La0:
            return r5
        La1:
            r0 = move-exception
        La2:
            if (r3 == 0) goto La7
            r3.close()
        La7:
            if (r2 == 0) goto Lac
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lac
        Lac:
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)
            r1.b()
            goto Lb7
        Lb6:
            throw r0
        Lb7:
            goto Lb6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.f():org.json.JSONObject");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0084 A[EXC_TOP_SPLITTER, PHI: r2 r5
      0x0084: PHI (r2v8 ??) = (r2v7 ??), (r2v9 ??) binds: [B:32:0x0082, B:39:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x0084: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:32:0x0082, B:39:0x009d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject g() throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r8.i
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            com.umeng.analytics.pro.e r2 = com.umeng.analytics.pro.e.a(r2)     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            java.util.List<java.lang.String> r4 = r8.i     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            java.lang.String r6 = "select *  from __sd where __ii=?"
            r7 = 1
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            r7[r5] = r4     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            android.database.Cursor r4 = r2.rawQuery(r6, r7)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> La1
            if (r4 == 0) goto L53
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L71
            if (r5 == 0) goto L53
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L71
            r5.<init>()     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L71
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6f android.database.sqlite.SQLiteDatabaseCorruptException -> L72
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6f android.database.sqlite.SQLiteDatabaseCorruptException -> L72
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6f android.database.sqlite.SQLiteDatabaseCorruptException -> L72
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6f android.database.sqlite.SQLiteDatabaseCorruptException -> L72
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6f android.database.sqlite.SQLiteDatabaseCorruptException -> L72
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6f android.database.sqlite.SQLiteDatabaseCorruptException -> L72
            r3 = r5
        L53:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L6b java.lang.Throwable -> L6e android.database.sqlite.SQLiteDatabaseCorruptException -> L71
            if (r4 == 0) goto L5b
            r4.close()
        L5b:
            if (r2 == 0) goto L60
            r2.endTransaction()     // Catch: java.lang.Throwable -> L60
        L60:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            r5 = r3
            goto La0
        L6b:
            r0 = move-exception
            r3 = r4
            goto La2
        L6e:
            r5 = r3
        L6f:
            r3 = r4
            goto L7d
        L71:
            r5 = r3
        L72:
            r3 = r4
            goto L93
        L74:
            r5 = r3
            goto L7d
        L76:
            r5 = r3
            goto L93
        L78:
            r0 = move-exception
            r2 = r3
            goto La2
        L7b:
            r2 = r3
            r5 = r2
        L7d:
            if (r3 == 0) goto L82
            r3.close()
        L82:
            if (r2 == 0) goto L87
        L84:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L87
        L87:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto La0
        L91:
            r2 = r3
            r5 = r2
        L93:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> La1
            com.umeng.analytics.pro.f.a(r0)     // Catch: java.lang.Throwable -> La1
            if (r3 == 0) goto L9d
            r3.close()
        L9d:
            if (r2 == 0) goto L87
            goto L84
        La0:
            return r5
        La1:
            r0 = move-exception
        La2:
            if (r3 == 0) goto La7
            r3.close()
        La7:
            if (r2 == 0) goto Lac
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lac
        Lac:
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)
            r1.b()
            goto Lb7
        Lb6:
            throw r0
        Lb7:
            goto Lb6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.g():org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004b A[EXC_TOP_SPLITTER, PHI: r0
      0x004b: PHI (r0v6 android.database.sqlite.SQLiteDatabase) = 
      (r0v1 android.database.sqlite.SQLiteDatabase)
      (r0v2 android.database.sqlite.SQLiteDatabase)
      (r0v9 android.database.sqlite.SQLiteDatabase)
     binds: [B:14:0x0049, B:18:0x005d, B:10:0x0044] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            java.util.List<java.lang.Integer> r1 = r4.j     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            if (r1 <= 0) goto L3c
            r1 = 0
        L17:
            java.util.List<java.lang.Integer> r2 = r4.j     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            if (r1 >= r2) goto L3c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            r2.<init>()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            java.lang.String r3 = "delete from __et where rowid="
            r2.append(r3)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            java.util.List<java.lang.Integer> r3 = r4.j     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            r2.append(r3)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            int r1 = r1 + 1
            goto L17
        L3c:
            java.util.List<java.lang.Integer> r1 = r4.j     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            r1.clear()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49 android.database.sqlite.SQLiteDatabaseCorruptException -> L58
            if (r0 == 0) goto L4e
            goto L4b
        L47:
            r1 = move-exception
            goto L61
        L49:
            if (r0 == 0) goto L4e
        L4b:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L4e
        L4e:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L60
        L58:
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L47
            com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L4e
            goto L4b
        L60:
            return
        L61:
            if (r0 == 0) goto L66
            r0.endTransaction()     // Catch: java.lang.Throwable -> L66
        L66:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L71
        L70:
            throw r1
        L71:
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.h():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0020 A[PHI: r0
      0x0020: PHI (r0v6 android.database.sqlite.SQLiteDatabase) = 
      (r0v2 android.database.sqlite.SQLiteDatabase)
      (r0v9 android.database.sqlite.SQLiteDatabase)
      (r0v10 android.database.sqlite.SQLiteDatabase)
     binds: [B:12:0x002f, B:9:0x001d, B:4:0x0016] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i() {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L1b android.database.sqlite.SQLiteDatabaseCorruptException -> L2a
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L1b android.database.sqlite.SQLiteDatabaseCorruptException -> L2a
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L1b android.database.sqlite.SQLiteDatabaseCorruptException -> L2a
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L1b android.database.sqlite.SQLiteDatabaseCorruptException -> L2a
            java.lang.String r1 = "delete from __er"
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L1b android.database.sqlite.SQLiteDatabaseCorruptException -> L2a
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> L1b android.database.sqlite.SQLiteDatabaseCorruptException -> L2a
            if (r0 == 0) goto L20
            goto L1d
        L19:
            r1 = move-exception
            goto L33
        L1b:
            if (r0 == 0) goto L20
        L1d:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L20
        L20:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L32
        L2a:
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L19
            com.umeng.analytics.pro.f.a(r1)     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L20
            goto L1d
        L32:
            return
        L33:
            if (r0 == 0) goto L38
            r0.endTransaction()     // Catch: java.lang.Throwable -> L38
        L38:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L43
        L42:
            throw r1
        L43:
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.i():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0056 A[EXC_TOP_SPLITTER, PHI: r1
      0x0056: PHI (r1v11 android.database.sqlite.SQLiteDatabase) = (r1v9 android.database.sqlite.SQLiteDatabase), (r1v10 android.database.sqlite.SQLiteDatabase), (r1v15 ??) binds: [B:11:0x0054, B:16:0x0069, B:6:0x004d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15, types: [android.database.sqlite.SQLiteDatabase] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j() throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.String r0 = "\""
            java.lang.String r1 = r5.k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L7c
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r3.<init>()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.String r4 = "delete from __er where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.String r4 = r5.k     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r3.append(r4)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r3.append(r0)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r1.execSQL(r3)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r3.<init>()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.String r4 = "delete from __et where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.String r4 = r5.k     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r3.append(r4)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r3.append(r0)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r1.execSQL(r0)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6c
            if (r1 == 0) goto L59
            goto L56
        L50:
            r0 = move-exception
            r1 = r2
            goto L6d
        L53:
            r1 = r2
        L54:
            if (r1 == 0) goto L59
        L56:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L59
        L59:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L7c
        L63:
            r1 = r2
        L64:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L6c
            com.umeng.analytics.pro.f.a(r0)     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L59
            goto L56
        L6c:
            r0 = move-exception
        L6d:
            if (r1 == 0) goto L72
            r1.endTransaction()     // Catch: java.lang.Throwable -> L72
        L72:
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)
            r1.b()
            throw r0
        L7c:
            r5.k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.j():void");
    }

    private g() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = null;
        this.l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(jLongValue));
            contentValues.put("__sp", strC2);
            contentValues.put("__pp", strC);
            contentValues.put("__av", UMGlobalContext.getInstance(f20862d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(f20862d));
            sQLiteDatabase.insert(c.C0178c.f20794a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorRawQuery;
        String strD = null;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(c.d.a.f20812e);
            if (jSONObjectOptJSONObject != null) {
                cursorRawQuery = sQLiteDatabase.rawQuery("select __d from __sd where __ii=?", new String[]{str});
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            strD = d(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(c.d.a.f20812e)));
                        } catch (Throwable unused) {
                            if (cursorRawQuery == null) {
                                return;
                            }
                        }
                    }
                }
            } else {
                cursorRawQuery = null;
            }
            if (jSONObjectOptJSONObject != null) {
                JSONArray jSONArray = new JSONArray();
                if (!TextUtils.isEmpty(strD)) {
                    jSONArray = new JSONArray(strD);
                }
                jSONArray.put(jSONObjectOptJSONObject);
                String strC = c(jSONArray.toString());
                if (!TextUtils.isEmpty(strC)) {
                    sQLiteDatabase.execSQL("update  __sd set __d=\"" + strC + "\" where __ii=\"" + str + "\"");
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__c");
            if (jSONObjectOptJSONObject2 != null) {
                String strC2 = c(jSONObjectOptJSONObject2.toString());
                if (!TextUtils.isEmpty(strC2)) {
                    sQLiteDatabase.execSQL("update  __sd set __c=\"" + strC2 + "\" where __ii=\"" + str + "\"");
                }
            }
            sQLiteDatabase.execSQL("update  __sd set __f=\"" + String.valueOf(jSONObject.optLong(c.d.a.g)) + "\" where __ii=\"" + str + "\"");
            if (cursorRawQuery == null) {
                return;
            }
        } catch (Throwable unused2) {
            cursorRawQuery = null;
        }
        cursorRawQuery.close();
    }

    public void a() {
        this.i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0090, code lost:
    
        if (r3 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009b, code lost:
    
        if (r3 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009d, code lost:
    
        r3.endTransaction();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(org.json.JSONArray r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r0 = "__t"
            java.lang.String r1 = "__i"
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L97 java.lang.Throwable -> L9a android.database.sqlite.SQLiteDatabaseCorruptException -> Laa
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)     // Catch: java.lang.Throwable -> L97 java.lang.Throwable -> L9a android.database.sqlite.SQLiteDatabaseCorruptException -> Laa
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L97 java.lang.Throwable -> L9a android.database.sqlite.SQLiteDatabaseCorruptException -> Laa
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteDatabaseCorruptException -> L95 java.lang.Throwable -> L9b
            r4 = 0
        L13:
            int r5 = r11.length()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteDatabaseCorruptException -> L95 java.lang.Throwable -> L9b
            if (r4 >= r5) goto L8d
            org.json.JSONObject r5 = r11.getJSONObject(r4)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r6.<init>()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r7 = r5.optString(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r9 = "-1"
            if (r8 != 0) goto L34
            boolean r8 = r9.equals(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            if (r8 == 0) goto L43
        L34:
            com.umeng.analytics.pro.s r7 = com.umeng.analytics.pro.s.a()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r7 = r7.b()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            if (r8 == 0) goto L43
            r7 = r9
        L43:
            r6.put(r1, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r7 = "__e"
            java.lang.String r8 = "id"
            java.lang.String r8 = r5.optString(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            int r7 = r5.optInt(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r6.put(r0, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r5.remove(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r5.remove(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r7 = "__s"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r5 = r10.c(r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            r6.put(r7, r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
            java.lang.String r5 = "__et"
            r3.insert(r5, r2, r6)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93 java.lang.Throwable -> L9b
        L8a:
            int r4 = r4 + 1
            goto L13
        L8d:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteDatabaseCorruptException -> L95 java.lang.Throwable -> L9b
            if (r3 == 0) goto La0
            goto L9d
        L93:
            r11 = move-exception
            goto Lb6
        L95:
            r2 = r3
            goto Laa
        L97:
            r11 = move-exception
            r3 = r2
            goto Lb6
        L9a:
            r3 = r2
        L9b:
            if (r3 == 0) goto La0
        L9d:
            r3.endTransaction()     // Catch: java.lang.Throwable -> La0
        La0:
            android.content.Context r11 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r11 = com.umeng.analytics.pro.e.a(r11)
            r11.b()
            goto Lb5
        Laa:
            android.content.Context r11 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L97
            com.umeng.analytics.pro.f.a(r11)     // Catch: java.lang.Throwable -> L97
            if (r2 == 0) goto La0
            r2.endTransaction()     // Catch: java.lang.Throwable -> La0
            goto La0
        Lb5:
            return
        Lb6:
            if (r3 == 0) goto Lbb
            r3.endTransaction()     // Catch: java.lang.Throwable -> Lbb
        Lbb:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto Lc6
        Lc5:
            throw r11
        Lc6:
            goto Lc5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(org.json.JSONArray):void");
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(f20863e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f20863e.getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b(boolean z) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0086 A[EXC_TOP_SPLITTER, PHI: r1
      0x0086: PHI (r1v6 android.database.sqlite.SQLiteDatabase) = 
      (r1v4 android.database.sqlite.SQLiteDatabase)
      (r1v5 android.database.sqlite.SQLiteDatabase)
      (r1v9 android.database.sqlite.SQLiteDatabase)
     binds: [B:30:0x0076, B:36:0x0084, B:22:0x0065] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.Cursor, android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(org.json.JSONObject r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6b android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6b android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6b android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            java.lang.String r2 = "select *  from __er"
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            if (r3 != 0) goto L23
            java.lang.String r2 = "select *  from __er where __i=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            r4 = 0
            r3[r4] = r7     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            android.database.Cursor r7 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            goto L27
        L23:
            android.database.Cursor r7 = r1.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
        L27:
            r0 = r7
            if (r0 == 0) goto L5d
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            r7.<init>()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
        L2f:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            if (r2 == 0) goto L52
            java.lang.String r2 = "__a"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            if (r3 != 0) goto L2f
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            java.lang.String r2 = r5.d(r2)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            r7.put(r3)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            goto L2f
        L52:
            int r2 = r7.length()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            if (r2 <= 0) goto L5d
            java.lang.String r2 = "error"
            r6.put(r2, r7)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
        L5d:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7a java.lang.Throwable -> L93
            if (r0 == 0) goto L65
            r0.close()
        L65:
            if (r1 == 0) goto L89
            goto L86
        L68:
            r6 = move-exception
            r1 = r0
            goto L94
        L6b:
            r1 = r0
        L6c:
            android.content.Context r6 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L93
            com.umeng.analytics.pro.f.a(r6)     // Catch: java.lang.Throwable -> L93
            if (r0 == 0) goto L76
            r0.close()
        L76:
            if (r1 == 0) goto L89
            goto L86
        L79:
            r1 = r0
        L7a:
            android.content.Context r6 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L93
            com.umeng.analytics.pro.f.a(r6)     // Catch: java.lang.Throwable -> L93
            if (r0 == 0) goto L84
            r0.close()
        L84:
            if (r1 == 0) goto L89
        L86:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L89
        L89:
            android.content.Context r6 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r6 = com.umeng.analytics.pro.e.a(r6)
            r6.b()
            return
        L93:
            r6 = move-exception
        L94:
            if (r0 == 0) goto L99
            r0.close()
        L99:
            if (r1 == 0) goto L9e
            r1.endTransaction()     // Catch: java.lang.Throwable -> L9e
        L9e:
            android.content.Context r7 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r7 = com.umeng.analytics.pro.e.a(r7)
            r7.b()
            goto La9
        La8:
            throw r6
        La9:
            goto La8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.b(org.json.JSONObject, java.lang.String):void");
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(f20863e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f20863e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004e, code lost:
    
        if (r1 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L58 android.database.sqlite.SQLiteDatabaseCorruptException -> L68
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L58 android.database.sqlite.SQLiteDatabaseCorruptException -> L68
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L58 android.database.sqlite.SQLiteDatabaseCorruptException -> L68
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            r2.<init>()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r5 = r4.c(r6)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            if (r6 != 0) goto L4b
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r5 = "__av"
            android.content.Context r6 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r5 = "__vc"
            android.content.Context r6 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
        L4b:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L53 java.lang.Throwable -> L59
            if (r1 == 0) goto L5e
            goto L5b
        L51:
            r5 = move-exception
            goto L75
        L53:
            r0 = r1
            goto L68
        L55:
            r5 = move-exception
            r1 = r0
            goto L75
        L58:
            r1 = r0
        L59:
            if (r1 == 0) goto L5e
        L5b:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L5e
        L5e:
            android.content.Context r5 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r5 = com.umeng.analytics.pro.e.a(r5)
            r5.b()
            goto L73
        L68:
            android.content.Context r5 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L55
            com.umeng.analytics.pro.f.a(r5)     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L5e
            r0.endTransaction()     // Catch: java.lang.Throwable -> L5e
            goto L5e
        L73:
            r5 = 0
            return r5
        L75:
            if (r1 == 0) goto L7a
            r1.endTransaction()     // Catch: java.lang.Throwable -> L7a
        L7a:
            android.content.Context r6 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r6 = com.umeng.analytics.pro.e.a(r6)
            r6.b()
            goto L85
        L84:
            throw r5
        L85:
            goto L84
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(java.lang.String, java.lang.String, int):boolean");
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("duration") > 0) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007d, code lost:
    
        if (r3 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
    
        if (r3 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
    
        r3.endTransaction();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.g.a r9) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "__e"
            r1 = 0
            if (r8 != 0) goto L6
            return r1
        L6:
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L84 java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L97
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)     // Catch: java.lang.Throwable -> L84 java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L97
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L84 java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L97
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            com.umeng.analytics.pro.g$a r4 = com.umeng.analytics.pro.g.a.BEGIN     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r9 != r4) goto L4f
            java.lang.Object r8 = r8.opt(r0)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            long r8 = r8.longValue()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            r4.<init>()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r5 = "__ii"
            r4.put(r5, r7)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            r4.put(r0, r7)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            java.lang.String r7 = "__sd"
            r3.insert(r7, r2, r4)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            goto L7a
        L4f:
            com.umeng.analytics.pro.g$a r0 = com.umeng.analytics.pro.g.a.INSTANTSESSIONBEGIN     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r9 != r0) goto L57
            r6.b(r7, r8, r3)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            goto L7a
        L57:
            com.umeng.analytics.pro.g$a r0 = com.umeng.analytics.pro.g.a.END     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r9 != r0) goto L5f
            r6.a(r7, r8, r3)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            goto L7a
        L5f:
            com.umeng.analytics.pro.g$a r0 = com.umeng.analytics.pro.g.a.PAGE     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r9 != r0) goto L69
            java.lang.String r9 = "__a"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            goto L7a
        L69:
            com.umeng.analytics.pro.g$a r0 = com.umeng.analytics.pro.g.a.AUTOPAGE     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r9 != r0) goto L73
            java.lang.String r9 = "__b"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            goto L7a
        L73:
            com.umeng.analytics.pro.g$a r0 = com.umeng.analytics.pro.g.a.NEWSESSION     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r9 != r0) goto L7a
            r6.c(r7, r8, r3)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
        L7a:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L82 java.lang.Throwable -> L88
            if (r3 == 0) goto L8d
            goto L8a
        L80:
            r7 = move-exception
            goto La3
        L82:
            r2 = r3
            goto L97
        L84:
            r7 = move-exception
            r3 = r2
            goto La3
        L87:
            r3 = r2
        L88:
            if (r3 == 0) goto L8d
        L8a:
            r3.endTransaction()     // Catch: java.lang.Throwable -> L8d
        L8d:
            android.content.Context r7 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r7 = com.umeng.analytics.pro.e.a(r7)
            r7.b()
            goto La2
        L97:
            android.content.Context r7 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L84
            com.umeng.analytics.pro.f.a(r7)     // Catch: java.lang.Throwable -> L84
            if (r2 == 0) goto L8d
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8d
            goto L8d
        La2:
            return r1
        La3:
            if (r3 == 0) goto La8
            r3.endTransaction()     // Catch: java.lang.Throwable -> La8
        La8:
            android.content.Context r8 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r8 = com.umeng.analytics.pro.e.a(r8)
            r8.b()
            goto Lb3
        Lb2:
            throw r7
        Lb3:
            goto Lb2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.g$a):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00e6 A[EXC_TOP_SPLITTER, PHI: r1 r11
      0x00e6: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = (r1v4 android.database.sqlite.SQLiteDatabase), (r1v6 android.database.sqlite.SQLiteDatabase) binds: [B:42:0x00d5, B:48:0x00e4] A[DONT_GENERATE, DONT_INLINE]
      0x00e6: PHI (r11v7 java.lang.String) = (r11v6 java.lang.String), (r11v9 java.lang.String) binds: [B:42:0x00d5, B:48:0x00e4] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(org.json.JSONObject r11, boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.b(org.json.JSONObject, boolean):java.lang.String");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.opt(c.d.a.g)).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + jLongValue + "\", __sp=\"" + strC2 + "\", __pp=\"" + strC + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0053 A[Catch: Exception -> 0x0056, PHI: r2 r4
      0x0053: PHI (r2v3 long) = (r2v0 long), (r2v6 long) binds: [B:24:0x0051, B:9:0x0030] A[DONT_GENERATE, DONT_INLINE]
      0x0053: PHI (r4v4 android.database.sqlite.SQLiteDatabase) = (r4v3 android.database.sqlite.SQLiteDatabase), (r4v7 android.database.sqlite.SQLiteDatabase) binds: [B:24:0x0051, B:9:0x0030] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {Exception -> 0x0056, blocks: (B:8:0x002d, B:25:0x0053, B:23:0x004e), top: B:31:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = "select __f from __sd where __ii=?"
            r1 = 0
            r2 = 0
            android.content.Context r4 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L4b
            com.umeng.analytics.pro.e r4 = com.umeng.analytics.pro.e.a(r4)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L4b
            android.database.sqlite.SQLiteDatabase r4 = r4.a()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L4b
            r4.beginTransaction()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L4c
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L4c
            r6 = 0
            r5[r6] = r8     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L4c
            android.database.Cursor r1 = r4.rawQuery(r0, r5)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L4c
            if (r1 == 0) goto L2b
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L4c
            java.lang.String r8 = "__f"
            int r8 = r1.getColumnIndex(r8)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L4c
            long r2 = r1.getLong(r8)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L4c
        L2b:
            if (r1 == 0) goto L30
            r1.close()     // Catch: java.lang.Exception -> L56
        L30:
            if (r4 == 0) goto L56
            goto L53
        L33:
            r8 = move-exception
            goto L37
        L35:
            r8 = move-exception
            r4 = r1
        L37:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.lang.Exception -> L41
        L3c:
            if (r4 == 0) goto L41
            r4.endTransaction()     // Catch: java.lang.Exception -> L41
        L41:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            throw r8
        L4b:
            r4 = r1
        L4c:
            if (r1 == 0) goto L51
            r1.close()     // Catch: java.lang.Exception -> L56
        L51:
            if (r4 == 0) goto L56
        L53:
            r4.endTransaction()     // Catch: java.lang.Exception -> L56
        L56:
            android.content.Context r8 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r8 = com.umeng.analytics.pro.e.a(r8)
            r8.b()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(java.lang.String):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0057 A[EXC_TOP_SPLITTER, PHI: r0
      0x0057: PHI (r0v4 android.database.sqlite.SQLiteDatabase) = 
      (r0v1 android.database.sqlite.SQLiteDatabase)
      (r0v2 android.database.sqlite.SQLiteDatabase)
      (r0v5 android.database.sqlite.SQLiteDatabase)
     binds: [B:18:0x0055, B:22:0x0069, B:14:0x0050] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(boolean r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            if (r4 == 0) goto L18
            if (r3 == 0) goto L4d
            java.lang.String r3 = "delete from __sd"
            r0.execSQL(r3)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            goto L4d
        L18:
            java.util.List<java.lang.String> r3 = r2.i     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            if (r3 <= 0) goto L4d
            r3 = 0
        L21:
            java.util.List<java.lang.String> r4 = r2.i     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            if (r3 >= r4) goto L4d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r4.<init>()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r1 = "delete from __sd where __ii=\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.util.List<java.lang.String> r1 = r2.i     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r4.append(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r1 = "\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            int r3 = r3 + 1
            goto L21
        L4d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            if (r0 == 0) goto L5a
            goto L57
        L53:
            r3 = move-exception
            goto L6d
        L55:
            if (r0 == 0) goto L5a
        L57:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L5a
        L5a:
            android.content.Context r3 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)
            r3.b()
            goto L6c
        L64:
            android.content.Context r3 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L53
            com.umeng.analytics.pro.f.a(r3)     // Catch: java.lang.Throwable -> L53
            if (r0 == 0) goto L5a
            goto L57
        L6c:
            return
        L6d:
            if (r0 == 0) goto L72
            r0.endTransaction()     // Catch: java.lang.Throwable -> L72
        L72:
            android.content.Context r4 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r4 = com.umeng.analytics.pro.e.a(r4)
            r4.b()
            goto L7d
        L7c:
            throw r3
        L7d:
            goto L7c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.b(boolean, boolean):void");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) throws Throwable {
        Cursor cursorRawQuery;
        JSONArray jSONArrayOptJSONArray;
        int i;
        JSONArray jSONArray;
        String strD = null;
        try {
            if ("__a".equals(str2)) {
                jSONArrayOptJSONArray = jSONObject.optJSONArray("__a");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    return;
                }
            } else if (c.d.a.f20810c.equals(str2)) {
                jSONArrayOptJSONArray = jSONObject.optJSONArray(c.d.a.f20810c);
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    return;
                }
            } else {
                jSONArrayOptJSONArray = null;
            }
            cursorRawQuery = sQLiteDatabase.rawQuery("select " + str2 + " from " + c.d.f20807a + " where __ii=?", new String[]{str});
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    try {
                        strD = d(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str2)));
                    } catch (Throwable th) {
                        th = th;
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        throw th;
                    }
                }
            }
            jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(strD)) {
                jSONArray = new JSONArray(strD);
            }
        } catch (Throwable th2) {
            th = th2;
            cursorRawQuery = null;
        }
        if (jSONArray.length() > 1000) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
                return;
            }
            return;
        }
        for (i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    jSONArray.put(jSONObject2);
                }
            } catch (JSONException unused) {
            }
        }
        String strC = c(jSONArray.toString());
        if (!TextUtils.isEmpty(strC)) {
            sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + strC + "\" where __ii=\"" + str + "\"");
        }
        if (cursorRawQuery == null) {
            return;
        }
        cursorRawQuery.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0037 A[EXC_TOP_SPLITTER, PHI: r0
      0x0037: PHI (r0v6 android.database.sqlite.SQLiteDatabase) = 
      (r0v1 android.database.sqlite.SQLiteDatabase)
      (r0v2 android.database.sqlite.SQLiteDatabase)
      (r0v7 android.database.sqlite.SQLiteDatabase)
     binds: [B:11:0x0035, B:15:0x0049, B:7:0x0030] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            if (r1 != 0) goto L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            r1.<init>()     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            java.lang.String r2 = "delete from __is where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            r1.append(r4)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            java.lang.String r4 = "\""
            r1.append(r4)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
        L2d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> L44
            if (r0 == 0) goto L3a
            goto L37
        L33:
            r4 = move-exception
            goto L4d
        L35:
            if (r0 == 0) goto L3a
        L37:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L3a
        L3a:
            android.content.Context r4 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r4 = com.umeng.analytics.pro.e.a(r4)
            r4.b()
            goto L4c
        L44:
            android.content.Context r4 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L33
            com.umeng.analytics.pro.f.a(r4)     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L3a
            goto L37
        L4c:
            return
        L4d:
            if (r0 == 0) goto L52
            r0.endTransaction()     // Catch: java.lang.Throwable -> L52
        L52:
            android.content.Context r0 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L5d
        L5c:
            throw r4
        L5d:
            goto L5c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.b(java.lang.String):void");
    }

    public JSONObject a(boolean z) throws Throwable {
        a();
        this.j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String strA = a(jSONObject, z);
            if (!TextUtils.isEmpty(strA)) {
                b(jSONObject, strA);
                a(jSONObject, strA);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0198 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0183 A[EXC_TOP_SPLITTER, PHI: r1
      0x0183: PHI (r1v6 android.database.sqlite.SQLiteDatabase) = 
      (r1v4 android.database.sqlite.SQLiteDatabase)
      (r1v5 android.database.sqlite.SQLiteDatabase)
      (r1v9 android.database.sqlite.SQLiteDatabase)
     binds: [B:72:0x0173, B:78:0x0181, B:64:0x0162] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.Cursor, android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r11v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v5, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, org.json.JSONArray] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.json.JSONObject r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x01c7 A[EXC_TOP_SPLITTER, PHI: r0 r3
      0x01c7: PHI (r0v6 java.lang.String) = (r0v4 java.lang.String), (r0v8 java.lang.String) binds: [B:72:0x01b6, B:78:0x01c5] A[DONT_GENERATE, DONT_INLINE]
      0x01c7: PHI (r3v5 android.database.sqlite.SQLiteDatabase) = (r3v3 android.database.sqlite.SQLiteDatabase), (r3v6 android.database.sqlite.SQLiteDatabase) binds: [B:72:0x01b6, B:78:0x01c5] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(org.json.JSONObject r18, boolean r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006a A[EXC_TOP_SPLITTER, PHI: r0
      0x006a: PHI (r0v4 android.database.sqlite.SQLiteDatabase) = 
      (r0v1 android.database.sqlite.SQLiteDatabase)
      (r0v2 android.database.sqlite.SQLiteDatabase)
      (r0v5 android.database.sqlite.SQLiteDatabase)
     binds: [B:25:0x0062, B:27:0x0068, B:19:0x0056] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r6, boolean r7) {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            if (r7 == 0) goto L18
            if (r6 == 0) goto L53
            java.lang.String r6 = "delete from __is"
            r0.execSQL(r6)     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            goto L53
        L18:
            java.util.List<java.lang.String> r6 = r5.l     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            r7 = 0
            if (r6 <= 0) goto L4c
            r1 = 0
        L22:
            if (r7 >= r6) goto L4b
            java.util.List<java.lang.String> r2 = r5.l     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            java.lang.Object r2 = r2.get(r7)     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            if (r2 != 0) goto L2f
            r1 = 1
        L2f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            r3.<init>()     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            java.lang.String r4 = "delete from __is where __ii=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            r3.append(r2)     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            java.lang.String r2 = "\""
            r3.append(r2)     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            int r7 = r7 + 1
            goto L22
        L4b:
            r7 = r1
        L4c:
            if (r7 == 0) goto L53
            java.lang.String r6 = "delete from __is where __ii is null"
            r0.execSQL(r6)     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
        L53:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L59 java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L63
            if (r0 == 0) goto L6d
            goto L6a
        L59:
            r6 = move-exception
            goto L77
        L5b:
            android.content.Context r6 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L59
            com.umeng.analytics.pro.f.a(r6)     // Catch: java.lang.Throwable -> L59
            if (r0 == 0) goto L6d
            goto L6a
        L63:
            android.content.Context r6 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L59
            com.umeng.analytics.pro.f.a(r6)     // Catch: java.lang.Throwable -> L59
            if (r0 == 0) goto L6d
        L6a:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6d
        L6d:
            android.content.Context r6 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r6 = com.umeng.analytics.pro.e.a(r6)
            r6.b()
            return
        L77:
            if (r0 == 0) goto L7c
            r0.endTransaction()     // Catch: java.lang.Throwable -> L7c
        L7c:
            android.content.Context r7 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r7 = com.umeng.analytics.pro.e.a(r7)
            r7.b()
            goto L87
        L86:
            throw r6
        L87:
            goto L86
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(boolean, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a A[EXC_TOP_SPLITTER, PHI: r0
      0x006a: PHI (r0v4 android.database.sqlite.SQLiteDatabase) = 
      (r0v1 android.database.sqlite.SQLiteDatabase)
      (r0v2 android.database.sqlite.SQLiteDatabase)
      (r0v5 android.database.sqlite.SQLiteDatabase)
     binds: [B:11:0x0068, B:15:0x007c, B:7:0x0063] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = "\""
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            if (r1 != 0) goto L60
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.<init>()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.String r2 = "delete from __er where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.append(r5)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.append(r4)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.<init>()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.String r2 = "delete from __et where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.append(r5)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.append(r4)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.util.List<java.lang.Integer> r1 = r3.j     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.clear()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.<init>()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.String r2 = "delete from __sd where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.append(r5)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r1.append(r4)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
        L60:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L68 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            if (r0 == 0) goto L6d
            goto L6a
        L66:
            r4 = move-exception
            goto L80
        L68:
            if (r0 == 0) goto L6d
        L6a:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6d
        L6d:
            android.content.Context r4 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r4 = com.umeng.analytics.pro.e.a(r4)
            r4.b()
            goto L7f
        L77:
            android.content.Context r4 = com.umeng.analytics.pro.g.f20862d     // Catch: java.lang.Throwable -> L66
            com.umeng.analytics.pro.f.a(r4)     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L6d
            goto L6a
        L7f:
            return
        L80:
            if (r0 == 0) goto L85
            r0.endTransaction()     // Catch: java.lang.Throwable -> L85
        L85:
            android.content.Context r5 = com.umeng.analytics.pro.g.f20862d
            com.umeng.analytics.pro.e r5 = com.umeng.analytics.pro.e.a(r5)
            r5.b()
            goto L90
        L8f:
            throw r4
        L90:
            goto L8f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(boolean, java.lang.String):void");
    }
}
