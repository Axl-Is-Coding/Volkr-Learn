package com.bytedance.sdk.openadsdk.multipro.d;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SPMultiHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f7072a;

    public static boolean a() {
        if (f7072a != null && o.a() != null) {
            return true;
        }
        com.bytedance.sdk.openadsdk.utils.o.b("The context of SPHelper is null, please initialize sdk in main process");
        return false;
    }

    private static ContentResolver b() {
        try {
            if (a()) {
                return c().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Context c() {
        Context context = f7072a;
        return context == null ? o.a() : context;
    }

    private static String d() {
        return e.f7076b + "/t_sp/";
    }

    public static void a(Context context) {
        f7072a = context == null ? o.a() : context.getApplicationContext();
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=" + str;
    }

    public static synchronized void a(String str, String str2, Boolean bool) {
        if (a()) {
            try {
                ContentResolver contentResolverB = b();
                if (contentResolverB != null) {
                    Uri uri = Uri.parse(d() + "boolean/" + str2 + b(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", bool);
                    contentResolverB.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String b(String str, String str2, String str3) {
        if (!a()) {
            return str3;
        }
        try {
            ContentResolver contentResolverB = b();
            if (contentResolverB != null) {
                String type = contentResolverB.getType(Uri.parse(d() + "string/" + str2 + b(str)));
                if (type != null) {
                    if (!type.equals("null")) {
                        return type;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return str3;
    }

    @TargetApi(11)
    public static Set<String> b(String str, String str2, Set<String> set) {
        if (!a()) {
            return set;
        }
        try {
            ContentResolver contentResolverB = b();
            if (contentResolverB != null) {
                String type = contentResolverB.getType(Uri.parse(d() + "string_set/" + str2 + b(str)));
                if (type == null || type.equals("null") || !type.matches("\\[.*\\]")) {
                    return set;
                }
                String[] strArrSplit = type.substring(1, type.length() - 1).split(", ");
                HashSet hashSet = new HashSet();
                for (String str3 : strArrSplit) {
                    hashSet.add(str3.replace("__COMMA__", ", "));
                }
                return hashSet;
            }
        } catch (Throwable unused) {
        }
        return set;
    }

    public static synchronized void a(String str, String str2, String str3) {
        if (a()) {
            try {
                ContentResolver contentResolverB = b();
                if (contentResolverB != null) {
                    Uri uri = Uri.parse(d() + "string/" + str2 + b(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", str3);
                    contentResolverB.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void a(String str, String str2, Integer num) {
        if (a()) {
            try {
                ContentResolver contentResolverB = b();
                if (contentResolverB != null) {
                    Uri uri = Uri.parse(d() + "int/" + str2 + b(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", num);
                    contentResolverB.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void a(String str, String str2, Long l) {
        if (a()) {
            try {
                ContentResolver contentResolverB = b();
                if (contentResolverB != null) {
                    Uri uri = Uri.parse(d() + "long/" + str2 + b(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", l);
                    contentResolverB.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void a(String str, String str2, Float f2) {
        if (a()) {
            try {
                ContentResolver contentResolverB = b();
                if (contentResolverB != null) {
                    Uri uri = Uri.parse(d() + "float/" + str2 + b(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", f2);
                    contentResolverB.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void a(String str, String str2, Set<String> set) {
        if (a()) {
            try {
                ContentResolver contentResolverB = b();
                if (contentResolverB != null) {
                    Uri uri = Uri.parse(d() + "string_set/" + str2 + b(str));
                    ContentValues contentValues = new ContentValues();
                    HashSet hashSet = new HashSet();
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().replace(",", "__COMMA__"));
                    }
                    contentValues.put("value", hashSet.toString());
                    contentResolverB.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static int a(String str, String str2, int i) {
        if (!a()) {
            return i;
        }
        try {
            ContentResolver contentResolverB = b();
            if (contentResolverB != null) {
                String type = contentResolverB.getType(Uri.parse(d() + "int/" + str2 + b(str)));
                if (type != null && !type.equals("null")) {
                    return Integer.parseInt(type);
                }
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static boolean a(String str, String str2, boolean z) {
        if (!a()) {
            return z;
        }
        try {
            ContentResolver contentResolverB = b();
            if (contentResolverB != null) {
                String type = contentResolverB.getType(Uri.parse(d() + "boolean/" + str2 + b(str)));
                if (type != null && !type.equals("null")) {
                    return Boolean.parseBoolean(type);
                }
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static long a(String str, String str2, long j) {
        if (!a()) {
            return j;
        }
        try {
            ContentResolver contentResolverB = b();
            if (contentResolverB != null) {
                String type = contentResolverB.getType(Uri.parse(d() + "long/" + str2 + b(str)));
                if (type != null && !type.equals("null")) {
                    return Long.parseLong(type);
                }
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    public static void a(String str, String str2) {
        if (a()) {
            try {
                ContentResolver contentResolverB = b();
                if (contentResolverB != null) {
                    contentResolverB.delete(Uri.parse(d() + "long/" + str2 + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        if (a()) {
            try {
                ContentResolver contentResolverB = b();
                if (contentResolverB != null) {
                    contentResolverB.delete(Uri.parse(d() + "clean" + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
