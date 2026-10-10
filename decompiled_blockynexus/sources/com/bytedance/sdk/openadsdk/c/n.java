package com.bytedance.sdk.openadsdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.f.b.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: StatsEventRepertoryImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class n implements e<c.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.bytedance.sdk.openadsdk.core.d f5791a = com.bytedance.sdk.openadsdk.core.d.a(e());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f5792b;

    public n(Context context) {
        this.f5792b = context;
    }

    private synchronized void b(int i, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), c(), "gen_time <? AND retry >?", new String[]{jCurrentTimeMillis + "", i + ""});
    }

    public static String f() {
        return "CREATE TABLE IF NOT EXISTS logstats (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0)";
    }

    public String c() {
        return "logstats";
    }

    public Context e() {
        Context context = this.f5792b;
        return context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public List<c.a> a(int i, String str) {
        String str2;
        if (i <= 0 || TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = str + " DESC limit " + i;
        }
        String str3 = str2;
        LinkedList linkedList = new LinkedList();
        Cursor cursorA = com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), c(), new String[]{"id", "value"}, null, null, null, null, str3);
        if (cursorA != null) {
            while (cursorA.moveToNext()) {
                try {
                    try {
                        linkedList.add(new c.a(cursorA.getString(cursorA.getColumnIndex("id")), new JSONObject(cursorA.getString(cursorA.getColumnIndex("value")))));
                    } catch (JSONException unused) {
                    }
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        }
        return linkedList;
    }

    private synchronized void b(List<c.a> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<c.a> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().f6754a);
        }
        com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), "UPDATE " + c() + " SET retry = retry+1 WHERE " + a("id", linkedList, 1000, true));
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(c.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.f6754a);
        contentValues.put("value", aVar.f6755b.toString());
        contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry", (Integer) 0);
        com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), c(), contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<c.a> list) {
        if (com.bytedance.sdk.openadsdk.utils.m.a(list)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<c.a> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().f6754a);
        }
        com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), "DELETE FROM " + c() + " WHERE " + a("id", linkedList, 1000, true));
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public int b() {
        return this.f5791a.b("stats_serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(int i, long j) {
        b(i, j);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<c.a> list, int i, long j) {
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
        this.f5791a.a("stats_serverbusy_flag", z);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public boolean a() {
        return this.f5791a.b("stats_serverbusy_flag", false);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(int i) {
        this.f5791a.a("stats_serverbusy_retrycount", i);
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
