package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: TmplDbHelper.java */
/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f6644a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LruCache<String, l> f6646c = new LruCache<String, l>(524288) { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.c.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, l lVar) {
            int length = 0;
            if (lVar != null) {
                if (!TextUtils.isEmpty(lVar.b())) {
                    try {
                        length = 0 + lVar.b().getBytes().length;
                    } catch (Throwable unused) {
                    }
                }
                if (!TextUtils.isEmpty(lVar.c())) {
                    try {
                        length += lVar.c().getBytes().length;
                    } catch (Throwable unused2) {
                    }
                }
                if (!TextUtils.isEmpty(lVar.a())) {
                    try {
                        length += lVar.a().getBytes().length;
                    } catch (Throwable unused3) {
                    }
                }
                if (!TextUtils.isEmpty(lVar.d())) {
                    try {
                        length += lVar.d().getBytes().length;
                    } catch (Throwable unused4) {
                    }
                }
                if (!TextUtils.isEmpty(lVar.f())) {
                    try {
                        length += lVar.f().getBytes().length;
                    } catch (Throwable unused5) {
                    }
                }
                if (!TextUtils.isEmpty(lVar.e())) {
                    try {
                        length += lVar.e().getBytes().length;
                    } catch (Throwable unused6) {
                    }
                }
            }
            return length > 0 ? length : super.sizeOf(str, lVar);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f6645b = Collections.synchronizedSet(new HashSet());

    private c() {
    }

    public static c a() {
        if (f6644a == null) {
            synchronized (c.class) {
                if (f6644a == null) {
                    f6644a = new c();
                }
            }
        }
        return f6644a;
    }

    public static String c() {
        return "CREATE TABLE IF NOT EXISTS template_diff (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT)";
    }

    private boolean d() {
        Long lValueOf = com.bytedance.sdk.openadsdk.multipro.b.b() ? Long.valueOf(com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_template_delete", "delete_time", 0L)) : Long.valueOf(e().getLong("delete_time", 0L));
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - lValueOf.longValue() < 604800000) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_template_delete", "delete_time", Long.valueOf(jCurrentTimeMillis));
            return true;
        }
        e().edit().putLong("delete_time", jCurrentTimeMillis);
        return true;
    }

    private SharedPreferences e() {
        return o.a().getSharedPreferences("sp_template_delete", 0);
    }

    List<l> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorA = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff", null, null, null, null, null, null);
        if (cursorA != null) {
            while (cursorA.moveToNext()) {
                try {
                    String string = cursorA.getString(cursorA.getColumnIndex("rit"));
                    String string2 = cursorA.getString(cursorA.getColumnIndex("id"));
                    String string3 = cursorA.getString(cursorA.getColumnIndex("md5"));
                    String string4 = cursorA.getString(cursorA.getColumnIndex("url"));
                    arrayList.add(new l().a(string).b(string2).c(string3).d(string4).e(cursorA.getString(cursorA.getColumnIndex("data"))).f(cursorA.getString(cursorA.getColumnIndex("version"))));
                    this.f6646c.put(string2, (l) arrayList.get(arrayList.size() - 1));
                    this.f6645b.add(string2);
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        }
        return arrayList;
    }

    l a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        l lVar = this.f6646c.get(String.valueOf(str));
        if (lVar != null) {
            return lVar;
        }
        Cursor cursorA = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff", null, "id=?", new String[]{str}, null, null, null);
        if (cursorA != null) {
            try {
                if (cursorA.moveToNext()) {
                    String string = cursorA.getString(cursorA.getColumnIndex("rit"));
                    String string2 = cursorA.getString(cursorA.getColumnIndex("id"));
                    String string3 = cursorA.getString(cursorA.getColumnIndex("md5"));
                    String string4 = cursorA.getString(cursorA.getColumnIndex("url"));
                    l lVarF = new l().a(string).b(string2).c(string3).d(string4).e(cursorA.getString(cursorA.getColumnIndex("data"))).f(cursorA.getString(cursorA.getColumnIndex("version")));
                    this.f6646c.put(string2, lVarF);
                    this.f6645b.add(string2);
                    return lVarF;
                }
                if (cursorA != null) {
                    cursorA.close();
                }
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
        return null;
    }

    void a(l lVar) {
        if (TextUtils.isEmpty(lVar.b())) {
            return;
        }
        Cursor cursorA = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff", null, "id=?", new String[]{lVar.b()}, null, null, null);
        boolean z = cursorA != null && cursorA.getCount() > 0;
        if (cursorA != null) {
            try {
                cursorA.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", lVar.a());
        contentValues.put("id", lVar.b());
        contentValues.put("md5", lVar.c());
        contentValues.put("url", lVar.d());
        contentValues.put("data", lVar.e());
        contentValues.put("version", lVar.f());
        if (z) {
            com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff", contentValues, "id=?", new String[]{lVar.b()});
        } else {
            com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff", contentValues);
        }
        this.f6646c.put(lVar.b(), lVar);
        this.f6645b.add(lVar.b());
    }

    void a(Set<String> set) {
        if (set == null || set.isEmpty() || !d()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.f6645b) {
            if (!set.contains(str)) {
                arrayList.add(str);
            }
        }
        String[] strArr = new String[0];
        if (arrayList.size() > 0) {
            com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff", "id=?", (String[]) arrayList.toArray(strArr));
        }
    }
}
