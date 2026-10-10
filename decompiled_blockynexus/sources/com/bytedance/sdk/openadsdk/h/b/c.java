package com.bytedance.sdk.openadsdk.h.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: VideoProxyDB.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f6855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f6857c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile SQLiteStatement f6859e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<Map<String, a>> f6856a = new SparseArray<>(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f6858d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingDeque());

    private c(Context context) {
        this.f6857c = new d(context.getApplicationContext());
        this.f6856a.put(0, new ConcurrentHashMap());
        this.f6856a.put(1, new ConcurrentHashMap());
    }

    private String b(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static c a(Context context) {
        if (f6855b == null) {
            synchronized (c.class) {
                if (f6855b == null) {
                    f6855b = new c(context);
                }
            }
        }
        return f6855b;
    }

    public a a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, a> map = this.f6856a.get(i);
        a aVar = map == null ? null : map.get(str);
        if (aVar != null) {
            return aVar;
        }
        try {
            Cursor cursorQuery = this.f6857c.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    aVar = new a(cursorQuery.getString(cursorQuery.getColumnIndex("key")), cursorQuery.getString(cursorQuery.getColumnIndex("mime")), cursorQuery.getInt(cursorQuery.getColumnIndex("contentLength")), i, cursorQuery.getString(cursorQuery.getColumnIndex("extra")));
                }
                cursorQuery.close();
            }
            if (aVar != null && map != null) {
                map.put(str, aVar);
            }
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(final a aVar) {
        if (aVar != null) {
            Map<String, a> map = this.f6856a.get(aVar.f6853d);
            if (map != null) {
                map.put(aVar.f6850a, aVar);
            }
            this.f6858d.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.this.f6859e == null) {
                            c.this.f6859e = c.this.f6857c.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        } else {
                            c.this.f6859e.clearBindings();
                        }
                        c.this.f6859e.bindString(1, aVar.f6850a);
                        c.this.f6859e.bindString(2, aVar.f6851b);
                        c.this.f6859e.bindLong(3, aVar.f6852c);
                        c.this.f6859e.bindLong(4, aVar.f6853d);
                        c.this.f6859e.bindString(5, aVar.f6854e);
                        c.this.f6859e.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void a(Collection<String> collection, int i) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        String[] strArr = new String[collection.size() + 1];
        int i2 = -1;
        Map<String, a> map = this.f6856a.get(i);
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i2++;
            strArr[i2] = str;
        }
        strArr[i2 + 1] = String.valueOf(i);
        try {
            this.f6857c.getWritableDatabase().delete("video_http_header_t", "key IN(" + b(strArr.length) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    public void a(final int i) {
        Map<String, a> map = this.f6856a.get(i);
        if (map != null) {
            map.clear();
        }
        this.f6858d.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.b.c.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.f6857c.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
