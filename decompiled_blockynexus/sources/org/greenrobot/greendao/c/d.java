package org.greenrobot.greendao.c;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.f;

/* JADX INFO: compiled from: SqlUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f23585a = "0123456789ABCDEF".toCharArray();

    public static StringBuilder a(StringBuilder sb, String str, f fVar) {
        if (str != null) {
            sb.append(str);
            sb.append('.');
        }
        sb.append('\"');
        sb.append(fVar.f23634e);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder b(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            a(sb, strArr[i]);
            sb.append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder a(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder a(StringBuilder sb, String str, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            a(sb, str, strArr[i]);
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder b(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            a(sb, str, strArr[i]);
            sb.append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder a(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append('\"');
            sb.append(strArr[i]);
            sb.append('\"');
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static String a(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(" (");
        a(sb, strArr);
        sb.append(") VALUES (");
        a(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String a(String str, String str2, String[] strArr, boolean z) {
        if (str2 != null && str2.length() >= 0) {
            StringBuilder sb = new StringBuilder(z ? "SELECT DISTINCT " : "SELECT ");
            a(sb, str2, strArr);
            sb.append(" FROM ");
            sb.append('\"');
            sb.append(str);
            sb.append('\"');
            sb.append(' ');
            sb.append(str2);
            sb.append(' ');
            return sb.toString();
        }
        throw new DaoException("Table alias required");
    }

    public static String a(String str, String[] strArr) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            b(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String a(String str, String[] strArr, String[] strArr2) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        b(sb, strArr);
        sb.append(" WHERE ");
        b(sb, str2, strArr2);
        return sb.toString();
    }

    public static String a(String str) {
        return "SELECT COUNT(*) FROM \"" + str + '\"';
    }
}
