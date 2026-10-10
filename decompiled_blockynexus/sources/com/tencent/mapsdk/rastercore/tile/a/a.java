package com.tencent.mapsdk.rastercore.tile.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.mapsdk.rastercore.c;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.d.h;
import com.tencent.mapsdk.rastercore.tile.MapTile;
import java.io.File;
import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    private static final String g = "Qmap" + File.separator;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Context f19635b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile b f19637d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile AtomicBoolean f19634a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile AtomicInteger f19636c = new AtomicInteger(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ReentrantReadWriteLock f19638e = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ReentrantReadWriteLock f19639f = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: com.tencent.mapsdk.rastercore.tile.a.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19640a = new int[MapTile.MapSource.values().length];

        static {
            try {
                f19640a[MapTile.MapSource.WORLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19640a[MapTile.MapSource.TENCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19640a[MapTile.MapSource.SATELLITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.mapsdk.rastercore.tile.a.a$a, reason: collision with other inner class name */
    static class C0174a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19641a = new a();
    }

    class b extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SQLiteDatabase f19642a;

        public b(a aVar, Context context) {
            super(context, aVar.b() + "Cache.db", (SQLiteDatabase.CursorFactory) null, 1);
            this.f19642a = null;
            this.f19642a = getReadableDatabase();
            if (Build.VERSION.SDK_INT > 10) {
                this.f19642a.enableWriteAheadLogging();
            } else {
                this.f19642a.setLockingEnabled(true);
            }
        }

        private static void a(String str, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (tile TEXT PRIMARY KEY UNIQUE,version TEXT,style TEXT,md5 TEXT,data BLOB )");
        }

        private static String b(MapTile.MapSource mapSource) {
            int i = AnonymousClass1.f19640a[mapSource.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? "" : "stt" : "tct" : "wmt";
        }

        private static String b(com.tencent.mapsdk.rastercore.tile.a aVar) {
            StringBuilder sb;
            int iN;
            int i = AnonymousClass1.f19640a[aVar.m().ordinal()];
            if (i == 1) {
                sb = new StringBuilder();
                sb.append(aVar.d());
                sb.append("-");
                sb.append(aVar.b());
                sb.append("-");
                sb.append(aVar.c());
                sb.append("-");
                sb.append(f.q());
                sb.append("-");
            } else {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    sb = new StringBuilder();
                    sb.append(aVar.d());
                    sb.append("-");
                    sb.append(aVar.b());
                    sb.append("-");
                    iN = aVar.c();
                    sb.append(iN);
                    return sb.toString();
                }
                sb = new StringBuilder();
                sb.append(aVar.d());
                sb.append("-");
                sb.append(aVar.b());
                sb.append("-");
                sb.append(aVar.c());
                sb.append("-zh-");
            }
            iN = aVar.n();
            sb.append(iN);
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c(com.tencent.mapsdk.rastercore.tile.a aVar) {
            Cursor cursorRawQuery = null;
            try {
                try {
                    cursorRawQuery = this.f19642a.rawQuery("select count(*) as ct from " + b(aVar.m()) + " where tile = '" + b(aVar) + "'", null);
                } catch (Throwable th) {
                    new StringBuilder("tileExist error:").append(th.toString());
                    if (cursorRawQuery != null) {
                    }
                }
                if (cursorRawQuery == null || cursorRawQuery.getCount() <= 0) {
                    if (cursorRawQuery != null) {
                    }
                    return true;
                }
                cursorRawQuery.moveToFirst();
                return cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(UserDataStore.CITY)) > 0;
                cursorRawQuery.close();
                return true;
            } finally {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a4  */
        /* JADX WARN: Type inference failed for: r7v0, types: [com.tencent.mapsdk.rastercore.tile.a] */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v3, types: [android.database.Cursor] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.tencent.mapsdk.rastercore.tile.a.b a(com.tencent.mapsdk.rastercore.tile.a r7) throws java.lang.Throwable {
            /*
                r6 = this;
                com.tencent.mapsdk.rastercore.tile.a.b r0 = new com.tencent.mapsdk.rastercore.tile.a.b
                int r1 = com.tencent.mapsdk.rastercore.d.h.b()
                java.lang.String r2 = ""
                r3 = 0
                r0.<init>(r3, r1, r2)
                android.database.sqlite.SQLiteDatabase r1 = r6.f19642a
                if (r1 != 0) goto L11
                return r0
            L11:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "select * from "
                r0.<init>(r1)
                com.tencent.mapsdk.rastercore.tile.MapTile$MapSource r1 = r7.m()
                java.lang.String r1 = b(r1)
                r0.append(r1)
                java.lang.String r1 = " where tile"
                r0.append(r1)
                java.lang.String r1 = " = ?"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                android.database.sqlite.SQLiteDatabase r1 = r6.f19642a     // Catch: java.lang.Throwable -> L81 java.lang.Throwable -> L84
                r4 = 1
                java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L81 java.lang.Throwable -> L84
                r5 = 0
                java.lang.String r7 = b(r7)     // Catch: java.lang.Throwable -> L81 java.lang.Throwable -> L84
                r4[r5] = r7     // Catch: java.lang.Throwable -> L81 java.lang.Throwable -> L84
                android.database.Cursor r7 = r1.rawQuery(r0, r4)     // Catch: java.lang.Throwable -> L81 java.lang.Throwable -> L84
                if (r7 == 0) goto L7b
                int r0 = r7.getCount()     // Catch: java.lang.Throwable -> L79 java.lang.Throwable -> La1
                if (r0 <= 0) goto L7b
                r7.moveToFirst()     // Catch: java.lang.Throwable -> L79 java.lang.Throwable -> La1
                java.lang.String r0 = "data"
                int r0 = r7.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L79 java.lang.Throwable -> La1
                byte[] r0 = r7.getBlob(r0)     // Catch: java.lang.Throwable -> L79 java.lang.Throwable -> La1
                java.lang.String r1 = "md5"
                int r1 = r7.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L79 java.lang.Throwable -> La1
                java.lang.String r1 = r7.getString(r1)     // Catch: java.lang.Throwable -> L79 java.lang.Throwable -> La1
                byte[] r0 = com.tencent.mapsdk.rastercore.tile.a.a.a(r0, r1)     // Catch: java.lang.Throwable -> L79 java.lang.Throwable -> La1
                java.lang.String r4 = "version"
                int r4 = r7.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L79 java.lang.Throwable -> La1
                int r4 = r7.getInt(r4)     // Catch: java.lang.Throwable -> L79 java.lang.Throwable -> La1
                com.tencent.mapsdk.rastercore.tile.a.b r5 = new com.tencent.mapsdk.rastercore.tile.a.b     // Catch: java.lang.Throwable -> L79 java.lang.Throwable -> La1
                r5.<init>(r0, r4, r1)     // Catch: java.lang.Throwable -> L79 java.lang.Throwable -> La1
                if (r7 == 0) goto L78
                r7.close()
            L78:
                return r5
            L79:
                r0 = move-exception
                goto L86
            L7b:
                if (r7 == 0) goto L97
            L7d:
                r7.close()
                goto L97
            L81:
                r0 = move-exception
                r7 = r3
                goto La2
            L84:
                r0 = move-exception
                r7 = r3
            L86:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La1
                java.lang.String r4 = "getBitmap error:"
                r1.<init>(r4)     // Catch: java.lang.Throwable -> La1
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La1
                r1.append(r0)     // Catch: java.lang.Throwable -> La1
                if (r7 == 0) goto L97
                goto L7d
            L97:
                com.tencent.mapsdk.rastercore.tile.a.b r7 = new com.tencent.mapsdk.rastercore.tile.a.b
                int r0 = com.tencent.mapsdk.rastercore.d.h.b()
                r7.<init>(r3, r0, r2)
                return r7
            La1:
                r0 = move-exception
            La2:
                if (r7 == 0) goto La7
                r7.close()
            La7:
                goto La9
            La8:
                throw r0
            La9:
                goto La8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.rastercore.tile.a.a.b.a(com.tencent.mapsdk.rastercore.tile.a):com.tencent.mapsdk.rastercore.tile.a.b");
        }

        public final boolean a(MapTile.MapSource mapSource) {
            if (this.f19642a == null) {
                return false;
            }
            try {
                this.f19642a.execSQL("delete  from " + b(mapSource));
                return true;
            } catch (Throwable th) {
                new StringBuilder("cleanCache Error:").append(th.toString());
                return false;
            }
        }

        public final boolean a(com.tencent.mapsdk.rastercore.tile.a aVar, byte[] bArr) {
            if (this.f19642a != null && bArr != null && bArr.length != 0) {
                try {
                    String strA = a.a(bArr);
                    byte[] bArrC = a.c(bArr, strA);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("tile", b(aVar));
                    contentValues.put("data", bArrC);
                    contentValues.put("md5", strA);
                    MapTile.MapSource mapSourceM = aVar.m();
                    if (mapSourceM == MapTile.MapSource.WORLD) {
                        contentValues.put(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, Integer.valueOf(h.e()));
                    }
                    if (mapSourceM == MapTile.MapSource.TENCENT) {
                        contentValues.put(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, Integer.valueOf(h.a()));
                    }
                    contentValues.put("version", Integer.valueOf(aVar.l()));
                    return this.f19642a.insert(b(aVar.m()), null, contentValues) != -1;
                } catch (Throwable th) {
                    new StringBuilder("putBitmap Error:").append(th.toString());
                }
            }
            return false;
        }

        public final boolean a(com.tencent.mapsdk.rastercore.tile.a aVar, byte[] bArr, boolean z) {
            if (this.f19642a == null) {
                return false;
            }
            try {
                ContentValues contentValues = new ContentValues();
                String[] strArr = {b(aVar)};
                contentValues.put("version", Integer.valueOf(aVar.l()));
                if (!z && bArr != null) {
                    String strA = a.a(bArr);
                    byte[] bArrC = a.c(bArr, strA);
                    contentValues.put("md5", strA);
                    contentValues.put("data", bArrC);
                }
                return this.f19642a.update(b(aVar.m()), contentValues, "tile = ? ", strArr) > 0;
            } catch (Throwable th) {
                new StringBuilder("updateBitmap Error:").append(th.toString());
                return false;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            a("tct", sQLiteDatabase);
            a("wmt", sQLiteDatabase);
            a("stt", sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  tct");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  wmt");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  stt");
            onCreate(sQLiteDatabase);
        }
    }

    public static a a() {
        return C0174a.f19641a;
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "md5";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception e2) {
            new StringBuilder("CacheManager getMd5 failed:").append(e2.toString());
            return "md5";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] c(byte[] bArr, String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length + bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i = 0; i < bytes.length; i++) {
                bArr2[i] = bytes[i];
            }
            for (int length2 = bytes.length; length2 < length; length2++) {
                bArr2[length2] = bArr[length2 - bytes.length];
            }
            return bArr2;
        } catch (Exception e2) {
            new StringBuilder("CacheManager encode:").append(e2.toString());
            return bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] d(byte[] bArr, String str) {
        try {
            int length = str.getBytes("UTF-8").length;
            byte[] bArr2 = new byte[bArr.length - length];
            for (int i = length; i < bArr.length; i++) {
                bArr2[i - length] = bArr[i];
            }
            return bArr2;
        } catch (Exception unused) {
            return bArr;
        }
    }

    public final com.tencent.mapsdk.rastercore.tile.a.b a(com.tencent.mapsdk.rastercore.tile.a aVar) {
        com.tencent.mapsdk.rastercore.tile.a.b bVar = new com.tencent.mapsdk.rastercore.tile.a.b(null, h.b(), "");
        this.f19639f.readLock().lock();
        try {
            if (this.f19637d != null && aVar.m() != MapTile.MapSource.CUSTOMER && aVar.m() != MapTile.MapSource.TRAFFIC && (aVar.m() != MapTile.MapSource.TENCENT || aVar.n() != 7)) {
                this.f19638e.readLock().lock();
                try {
                    com.tencent.mapsdk.rastercore.tile.a.b bVarA = this.f19637d.a(aVar);
                    this.f19639f.readLock().unlock();
                    return bVarA;
                } catch (Throwable unused) {
                    this.f19639f.readLock().unlock();
                    return bVar;
                } finally {
                    this.f19638e.readLock().unlock();
                }
            }
            this.f19639f.readLock().unlock();
            return bVar;
        } catch (Throwable th) {
            this.f19639f.readLock().unlock();
            throw th;
        }
    }

    public final void a(Context context) {
        this.f19639f.writeLock().lock();
        try {
            if (!this.f19634a.get()) {
                this.f19635b = context;
                this.f19637d = new b(this, this.f19635b);
                this.f19634a.set(true);
            }
        } catch (Throwable th) {
            this.f19639f.writeLock().unlock();
            throw th;
        }
        this.f19639f.writeLock().unlock();
    }

    public final boolean a(MapTile.MapSource mapSource) {
        this.f19639f.readLock().lock();
        try {
            if (this.f19637d == null) {
                this.f19639f.readLock().unlock();
                return false;
            }
            this.f19638e.writeLock().lock();
            try {
                try {
                    boolean zA = this.f19637d.a(mapSource);
                    this.f19639f.readLock().unlock();
                    return zA;
                } catch (Throwable th) {
                    new StringBuilder("clearCache error:").append(th.toString());
                    this.f19638e.writeLock().unlock();
                    this.f19639f.readLock().unlock();
                    return false;
                }
            } finally {
                this.f19638e.writeLock().unlock();
            }
        } catch (Throwable th2) {
            this.f19639f.readLock().unlock();
            throw th2;
        }
    }

    public final boolean a(com.tencent.mapsdk.rastercore.tile.a.b bVar, com.tencent.mapsdk.rastercore.tile.a aVar) {
        boolean zA;
        ReentrantReadWriteLock.WriteLock writeLock;
        this.f19639f.readLock().lock();
        try {
            if (this.f19637d != null && aVar.m() != MapTile.MapSource.CUSTOMER && aVar.m() != MapTile.MapSource.TRAFFIC && (aVar.m() != MapTile.MapSource.TENCENT || aVar.n() != 7)) {
                int i = AnonymousClass1.f19640a[aVar.m().ordinal()];
                int iD = i != 1 ? i != 2 ? i != 3 ? -1 : h.d() : h.b() : h.g();
                this.f19638e.writeLock().lock();
                try {
                    try {
                        if (aVar.g() && aVar.l() == iD && this.f19637d != null) {
                            if (this.f19637d.c(aVar)) {
                                zA = this.f19637d.a(aVar, bVar.c(), false);
                                writeLock = this.f19638e.writeLock();
                            } else {
                                zA = this.f19637d.a(aVar, bVar.c());
                                writeLock = this.f19638e.writeLock();
                            }
                            writeLock.unlock();
                            this.f19639f.readLock().unlock();
                            return zA;
                        }
                    } catch (Throwable th) {
                        new StringBuilder("put error:").append(th.toString());
                        this.f19638e.writeLock().unlock();
                        this.f19639f.readLock().unlock();
                        return false;
                    }
                } finally {
                    this.f19638e.writeLock().unlock();
                }
            }
            this.f19639f.readLock().unlock();
            return false;
        } catch (Throwable th2) {
            this.f19639f.readLock().unlock();
            throw th2;
        }
    }

    public final boolean a(com.tencent.mapsdk.rastercore.tile.a aVar, byte[] bArr, boolean z) {
        this.f19639f.readLock().lock();
        try {
            if (this.f19637d != null && !this.f19634a.get() && aVar.m() != MapTile.MapSource.CUSTOMER && aVar.m() != MapTile.MapSource.TRAFFIC && (aVar.m() != MapTile.MapSource.TENCENT || aVar.n() != 7)) {
                this.f19638e.writeLock().lock();
                try {
                    try {
                        boolean zA = this.f19637d.a(aVar, null, true);
                        this.f19639f.readLock().unlock();
                        return zA;
                    } catch (Throwable th) {
                        new StringBuilder("updateTile error:").append(th.toString());
                        this.f19638e.writeLock().unlock();
                        this.f19639f.readLock().unlock();
                        return false;
                    }
                } finally {
                    this.f19638e.writeLock().unlock();
                }
            }
            this.f19639f.readLock().unlock();
            return false;
        } catch (Throwable unused) {
            this.f19639f.readLock().unlock();
            return false;
        }
    }

    public final String b() {
        StringBuilder sb;
        boolean zEquals = Environment.getExternalStorageState().equals("mounted");
        if (this.f19635b == null) {
            return null;
        }
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 23) {
            int iCheckSelfPermission = this.f19635b.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
            int iCheckSelfPermission2 = this.f19635b.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
            if (iCheckSelfPermission != 0 || iCheckSelfPermission2 != 0) {
                z = false;
            }
        }
        try {
            if (zEquals && z) {
                sb = new StringBuilder();
                sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                sb.append(File.separator);
                sb.append(g);
            } else {
                sb = new StringBuilder();
                sb.append(this.f19635b.getFileStreamPath(""));
                sb.append(File.separator);
                sb.append(g);
            }
            String string = sb.toString();
            c.b(string);
            return string;
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println(e2.toString());
            return null;
        }
    }

    public final void c() {
        this.f19639f.writeLock().lock();
        try {
            if (this.f19636c.decrementAndGet() == 0) {
                if (this.f19637d != null) {
                    this.f19637d.close();
                    this.f19637d = null;
                }
                this.f19634a.set(false);
            }
        } catch (Throwable th) {
            this.f19639f.writeLock().unlock();
            throw th;
        }
        this.f19639f.writeLock().unlock();
    }
}
