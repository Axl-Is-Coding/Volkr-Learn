package com.bytedance.sdk.openadsdk.j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: TrackRetryRepertoryImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7017a;

    public h(Context context) {
        this.f7017a = context;
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.bytedance.sdk.openadsdk.j.g
    public synchronized List<f> a() {
        LinkedList linkedList;
        linkedList = new LinkedList();
        Cursor cursorA = com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f7017a, "trackurl", null, null, null, null, null, null);
        if (cursorA != null) {
            while (cursorA.moveToNext()) {
                try {
                    linkedList.add(new f(cursorA.getString(cursorA.getColumnIndex("id")), cursorA.getString(cursorA.getColumnIndex("url")), cursorA.getInt(cursorA.getColumnIndex("retry"))));
                } catch (Throwable th) {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    throw th;
                }
            }
            if (cursorA != null) {
                cursorA.close();
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.j.g
    public synchronized void b(f fVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", fVar.a());
        contentValues.put("url", fVar.b());
        contentValues.put("replaceholder", (Integer) 1);
        contentValues.put("retry", Integer.valueOf(fVar.c()));
        com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f7017a, "trackurl", contentValues, "id=?", new String[]{fVar.a()});
    }

    @Override // com.bytedance.sdk.openadsdk.j.g
    public synchronized void c(f fVar) {
        com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f7017a, "trackurl", "id=?", new String[]{fVar.a()});
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, retry INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.openadsdk.j.g
    public synchronized void a(f fVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", fVar.a());
        contentValues.put("url", fVar.b());
        contentValues.put("replaceholder", (Integer) 1);
        contentValues.put("retry", Integer.valueOf(fVar.c()));
        com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f7017a, "trackurl", contentValues);
    }
}
