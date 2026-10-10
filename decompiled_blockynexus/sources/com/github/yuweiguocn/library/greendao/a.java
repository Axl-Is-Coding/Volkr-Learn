package com.github.yuweiguocn.library.greendao;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MigrationHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f12527a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f12528b = "MigrationHelper";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static WeakReference<InterfaceC0100a> f12529c;

    /* JADX INFO: renamed from: com.github.yuweiguocn.library.greendao.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MigrationHelper.java */
    public interface InterfaceC0100a {
        void a(org.greenrobot.greendao.b.a aVar, boolean z);

        void b(org.greenrobot.greendao.b.a aVar, boolean z);
    }

    /* JADX INFO: compiled from: MigrationHelper.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f12531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f12532c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f12533d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f12534e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f12535f;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static List<b> b(org.greenrobot.greendao.b.a aVar, String str) {
            String str2 = "PRAGMA table_info(`" + str + "`)";
            a.b(str2);
            Cursor cursorA = aVar.a(str2, (String[]) null);
            if (cursorA == null) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            while (cursorA.moveToNext()) {
                b bVar = new b();
                boolean z = false;
                bVar.f12530a = cursorA.getInt(0);
                bVar.f12531b = cursorA.getString(1);
                bVar.f12532c = cursorA.getString(2);
                bVar.f12533d = cursorA.getInt(3) == 1;
                bVar.f12534e = cursorA.getString(4);
                if (cursorA.getInt(5) == 1) {
                    z = true;
                }
                bVar.f12535f = z;
                arrayList.add(bVar);
            }
            cursorA.close();
            return arrayList;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj != null && b.class == obj.getClass() && this.f12531b.equals(((b) obj).f12531b));
        }

        public String toString() {
            return "TableInfo{cid=" + this.f12530a + ", name='" + this.f12531b + "', type='" + this.f12532c + "', notnull=" + this.f12533d + ", dfltValue='" + this.f12534e + "', pk=" + this.f12535f + '}';
        }
    }

    private static void b(org.greenrobot.greendao.b.a aVar, Class<? extends org.greenrobot.greendao.a<?, ?>>... clsArr) {
        for (Class<? extends org.greenrobot.greendao.a<?, ?>> cls : clsArr) {
            String strConcat = null;
            org.greenrobot.greendao.c.a aVar2 = new org.greenrobot.greendao.c.a(aVar, cls);
            String str = aVar2.f23570b;
            if (a(aVar, false, str)) {
                try {
                    strConcat = aVar2.f23570b.concat("_TEMP");
                    aVar.a("DROP TABLE IF EXISTS " + strConcat + ";");
                    aVar.a("CREATE TEMPORARY TABLE " + strConcat + " AS SELECT * FROM `" + str + "`;");
                    StringBuilder sb = new StringBuilder();
                    sb.append("【Table】");
                    sb.append(str);
                    sb.append("\n ---Columns-->");
                    sb.append(a(aVar2));
                    b(sb.toString());
                    b("【Generate temp table】" + strConcat);
                } catch (SQLException e2) {
                    Log.e(f12528b, "【Failed to generate temp table】" + strConcat, e2);
                }
            } else {
                b("【New Table】" + str);
            }
        }
    }

    private static void c(org.greenrobot.greendao.b.a aVar, Class<? extends org.greenrobot.greendao.a<?, ?>>... clsArr) {
        for (Class<? extends org.greenrobot.greendao.a<?, ?>> cls : clsArr) {
            String str = new org.greenrobot.greendao.c.a(aVar, cls).f23570b;
            String strConcat = str.concat("_TEMP");
            if (a(aVar, true, strConcat)) {
                try {
                    List<b> listB = b.b(aVar, str);
                    List<b> listB2 = b.b(aVar, strConcat);
                    ArrayList arrayList = new ArrayList(listB.size());
                    ArrayList arrayList2 = new ArrayList(listB.size());
                    for (b bVar : listB2) {
                        if (listB.contains(bVar)) {
                            String str2 = '`' + bVar.f12531b + '`';
                            arrayList2.add(str2);
                            arrayList.add(str2);
                        }
                    }
                    for (b bVar2 : listB) {
                        if (bVar2.f12533d && !listB2.contains(bVar2)) {
                            String str3 = '`' + bVar2.f12531b + '`';
                            arrayList2.add(str3);
                            arrayList.add((bVar2.f12534e != null ? "'" + bVar2.f12534e + "' AS " : "'' AS ") + str3);
                        }
                    }
                    if (arrayList2.size() != 0) {
                        aVar.a("REPLACE INTO `" + str + "` (" + TextUtils.join(",", arrayList2) + ") SELECT " + TextUtils.join(",", arrayList) + " FROM " + strConcat + ";");
                        StringBuilder sb = new StringBuilder();
                        sb.append("【Restore data】 to ");
                        sb.append(str);
                        b(sb.toString());
                    }
                    aVar.a("DROP TABLE " + strConcat);
                    b("【Drop temp table】" + strConcat);
                } catch (SQLException e2) {
                    Log.e(f12528b, "【Failed to restore data from temp table 】" + strConcat, e2);
                }
            }
        }
    }

    public static void a(org.greenrobot.greendao.b.a aVar, InterfaceC0100a interfaceC0100a, Class<? extends org.greenrobot.greendao.a<?, ?>>... clsArr) {
        f12529c = new WeakReference<>(interfaceC0100a);
        a(aVar, clsArr);
    }

    public static void a(org.greenrobot.greendao.b.a aVar, Class<? extends org.greenrobot.greendao.a<?, ?>>... clsArr) {
        b("【Generate temp table】start");
        b(aVar, clsArr);
        b("【Generate temp table】complete");
        WeakReference<InterfaceC0100a> weakReference = f12529c;
        InterfaceC0100a interfaceC0100a = weakReference != null ? weakReference.get() : null;
        if (interfaceC0100a != null) {
            interfaceC0100a.b(aVar, true);
            b("【Drop all table by listener】");
            interfaceC0100a.a(aVar, false);
            b("【Create all table by listener】");
        } else {
            b(aVar, true, clsArr);
            a(aVar, false, clsArr);
        }
        b("【Restore data】start");
        c(aVar, clsArr);
        b("【Restore data】complete");
    }

    private static void b(org.greenrobot.greendao.b.a aVar, boolean z, Class<? extends org.greenrobot.greendao.a<?, ?>>... clsArr) {
        a(aVar, "dropTable", z, clsArr);
        b("【Drop all table by reflect】");
    }

    private static boolean a(org.greenrobot.greendao.b.a aVar, boolean z, String str) {
        int i;
        if (aVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorA = null;
        try {
            try {
                cursorA = aVar.a("SELECT COUNT(*) FROM `" + (z ? "sqlite_temp_master" : "sqlite_master") + "` WHERE type = ? AND name = ?", new String[]{"table", str});
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorA != null) {
                    cursorA.close();
                }
                i = 0;
            }
            if (cursorA != null && cursorA.moveToFirst()) {
                i = cursorA.getInt(0);
                if (cursorA != null) {
                    cursorA.close();
                }
                return i > 0;
            }
            if (cursorA != null) {
                cursorA.close();
            }
            return false;
        } catch (Throwable th) {
            if (cursorA != null) {
                cursorA.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (f12527a) {
            Log.d(f12528b, str);
        }
    }

    private static String a(org.greenrobot.greendao.c.a aVar) {
        if (aVar == null) {
            return "no columns";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            String[] strArr = aVar.f23572d;
            if (i >= strArr.length) {
                break;
            }
            sb.append(strArr[i]);
            sb.append(",");
            i++;
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static void a(org.greenrobot.greendao.b.a aVar, boolean z, Class<? extends org.greenrobot.greendao.a<?, ?>>... clsArr) {
        a(aVar, "createTable", z, clsArr);
        b("【Create all table by reflect】");
    }

    private static void a(org.greenrobot.greendao.b.a aVar, String str, boolean z, Class<? extends org.greenrobot.greendao.a<?, ?>>... clsArr) {
        if (clsArr.length < 1) {
            return;
        }
        try {
            for (Class<? extends org.greenrobot.greendao.a<?, ?>> cls : clsArr) {
                cls.getDeclaredMethod(str, org.greenrobot.greendao.b.a.class, Boolean.TYPE).invoke(null, aVar, Boolean.valueOf(z));
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }
}
