package kotlin.text;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: StringsJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public class n extends m {
    public static /* synthetic */ String a(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return a(str, str2, str3, z);
    }

    public static boolean b(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static final boolean c(String str, String str2, boolean z) {
        kotlin.jvm.internal.i.b(str, "$this$startsWith");
        kotlin.jvm.internal.i.b(str2, "prefix");
        return !z ? str.startsWith(str2) : a(str, 0, str2, 0, str2.length(), z);
    }

    public static String a(String str, String str2, String str3, boolean z) {
        kotlin.jvm.internal.i.b(str, "$this$replace");
        kotlin.jvm.internal.i.b(str2, "oldValue");
        kotlin.jvm.internal.i.b(str3, "newValue");
        return kotlin.e.h.a(o.b(str, new String[]{str2}, z, 0, 4, (Object) null), str3, null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ boolean a(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(str, str2, z);
    }

    public static /* synthetic */ boolean b(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return c(str, str2, z);
    }

    public static final boolean a(String str, String str2, boolean z) {
        kotlin.jvm.internal.i.b(str, "$this$endsWith");
        kotlin.jvm.internal.i.b(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static final boolean a(String str, int i, String str2, int i2, int i3, boolean z) {
        kotlin.jvm.internal.i.b(str, "$this$regionMatches");
        kotlin.jvm.internal.i.b(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }
}
