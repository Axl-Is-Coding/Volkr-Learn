package com.ta.utdid2.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.utdid2.b.a.i;
import com.ta.utdid2.c.a.b;
import com.umeng.analytics.pro.au;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: PersistentConfiguration.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private b f111a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private d f112a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f19361f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private Context mContext;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences.Editor f19359a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private b.a f110a = null;

    /* JADX WARN: Removed duplicated region for block: B:67:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(android.content.Context r10, java.lang.String r11, java.lang.String r12, boolean r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.c.a.c.<init>(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    private d a(String str) {
        File fileM97a = m97a(str);
        if (fileM97a == null) {
            return null;
        }
        this.f112a = new d(fileM97a.getAbsolutePath());
        return this.f112a;
    }

    private boolean b() {
        b bVar = this.f111a;
        if (bVar == null) {
            return false;
        }
        boolean zMo96a = bVar.mo96a();
        if (!zMo96a) {
            commit();
        }
        return zMo96a;
    }

    private void c() {
        b bVar;
        SharedPreferences sharedPreferences;
        if (this.f19359a == null && (sharedPreferences = this.f109a) != null) {
            this.f19359a = sharedPreferences.edit();
        }
        if (this.i && this.f110a == null && (bVar = this.f111a) != null) {
            this.f110a = bVar.a();
        }
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean commit() {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.content.SharedPreferences$Editor r2 = r6.f19359a
            r3 = 0
            if (r2 == 0) goto L20
            boolean r4 = r6.j
            if (r4 != 0) goto L16
            android.content.SharedPreferences r4 = r6.f109a
            if (r4 == 0) goto L16
            java.lang.String r4 = "t"
            r2.putLong(r4, r0)
        L16:
            android.content.SharedPreferences$Editor r0 = r6.f19359a
            boolean r0 = r0.commit()
            if (r0 != 0) goto L20
            r0 = 0
            goto L21
        L20:
            r0 = 1
        L21:
            android.content.SharedPreferences r1 = r6.f109a
            if (r1 == 0) goto L31
            android.content.Context r1 = r6.mContext
            if (r1 == 0) goto L31
            java.lang.String r2 = r6.f19360e
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r6.f109a = r1
        L31:
            r1 = 0
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Exception -> L37
            goto L3b
        L37:
            r2 = move-exception
            r2.printStackTrace()
        L3b:
            boolean r2 = com.ta.utdid2.b.a.i.m95a(r1)
            if (r2 != 0) goto La4
            java.lang.String r2 = "mounted"
            boolean r4 = r1.equals(r2)
            if (r4 == 0) goto L84
            com.ta.utdid2.c.a.b r4 = r6.f111a
            if (r4 != 0) goto L79
            java.lang.String r4 = r6.f19361f
            com.ta.utdid2.c.a.d r4 = r6.a(r4)
            if (r4 == 0) goto L84
            java.lang.String r5 = r6.f19360e
            com.ta.utdid2.c.a.b r4 = r4.a(r5, r3)
            r6.f111a = r4
            boolean r4 = r6.j
            if (r4 != 0) goto L69
            android.content.SharedPreferences r4 = r6.f109a
            com.ta.utdid2.c.a.b r5 = r6.f111a
            r6.a(r4, r5)
            goto L70
        L69:
            com.ta.utdid2.c.a.b r4 = r6.f111a
            android.content.SharedPreferences r5 = r6.f109a
            r6.a(r4, r5)
        L70:
            com.ta.utdid2.c.a.b r4 = r6.f111a
            com.ta.utdid2.c.a.b$a r4 = r4.a()
            r6.f110a = r4
            goto L84
        L79:
            com.ta.utdid2.c.a.b$a r4 = r6.f110a
            if (r4 == 0) goto L84
            boolean r4 = r4.commit()
            if (r4 != 0) goto L84
            r0 = 0
        L84:
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L96
            java.lang.String r2 = "mounted_ro"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto La4
            com.ta.utdid2.c.a.b r1 = r6.f111a
            if (r1 == 0) goto La4
        L96:
            com.ta.utdid2.c.a.d r1 = r6.f112a     // Catch: java.lang.Exception -> La4
            if (r1 == 0) goto La4
            com.ta.utdid2.c.a.d r1 = r6.f112a     // Catch: java.lang.Exception -> La4
            java.lang.String r2 = r6.f19360e     // Catch: java.lang.Exception -> La4
            com.ta.utdid2.c.a.b r1 = r1.a(r2, r3)     // Catch: java.lang.Exception -> La4
            r6.f111a = r1     // Catch: java.lang.Exception -> La4
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.c.a.c.commit():boolean");
    }

    public String getString(String str) {
        b();
        SharedPreferences sharedPreferences = this.f109a;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!i.m95a(string)) {
                return string;
            }
        }
        b bVar = this.f111a;
        return bVar != null ? bVar.getString(str, "") : "";
    }

    public void putString(String str, String str2) {
        if (i.m95a(str) || str.equals(au.az)) {
            return;
        }
        c();
        SharedPreferences.Editor editor = this.f19359a;
        if (editor != null) {
            editor.putString(str, str2);
        }
        b.a aVar = this.f110a;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public void remove(String str) {
        if (i.m95a(str) || str.equals(au.az)) {
            return;
        }
        c();
        SharedPreferences.Editor editor = this.f19359a;
        if (editor != null) {
            editor.remove(str);
        }
        b.a aVar = this.f110a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private File m97a(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private void a(SharedPreferences sharedPreferences, b bVar) {
        b.a aVarA;
        if (sharedPreferences == null || bVar == null || (aVarA = bVar.a()) == null) {
            return;
        }
        aVarA.b();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                aVarA.a(key, (String) value);
            } else if (value instanceof Integer) {
                aVarA.a(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                aVarA.a(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                aVarA.a(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                aVarA.a(key, ((Boolean) value).booleanValue());
            }
        }
        aVarA.commit();
    }

    private void a(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit;
        if (bVar == null || sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.clear();
        for (Map.Entry<String, ?> entry : bVar.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                editorEdit.putString(key, (String) value);
            } else if (value instanceof Integer) {
                editorEdit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                editorEdit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                editorEdit.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        editorEdit.commit();
    }
}
