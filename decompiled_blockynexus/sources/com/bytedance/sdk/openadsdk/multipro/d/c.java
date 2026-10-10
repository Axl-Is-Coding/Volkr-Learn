package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.Map;

/* JADX INFO: compiled from: SPMultiProviderImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.sdk.openadsdk.multipro.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7074a;

    private Context c() {
        Context context = this.f7074a;
        return context == null ? o.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a() {
        return "t_sp";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.f7074a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> mapB;
        if (!uri.getPath().split("/")[2].equals("get_all") || (mapB = b.b(c(), uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : mapB.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            objArr[2] = mapB.get(str3);
            if (objArr[2] instanceof Boolean) {
                objArr[1] = "boolean";
            } else if (objArr[2] instanceof String) {
                objArr[1] = "string";
            } else if (objArr[2] instanceof Integer) {
                objArr[1] = "int";
            } else if (objArr[2] instanceof Long) {
                objArr[1] = "long";
            } else if (objArr[2] instanceof Float) {
                objArr[1] = "float";
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(Uri uri) {
        String[] strArrSplit = uri.getPath().split("/");
        String str = strArrSplit[2];
        String str2 = strArrSplit[3];
        if (str.equals("contain")) {
            return b.a(o.a(), uri.getQueryParameter("sp_file_name"), str2) + "";
        }
        return "" + b.a(c(), uri.getQueryParameter("sp_file_name"), str2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        String str = strArrSplit[2];
        String str2 = strArrSplit[3];
        Object obj = contentValues.get("value");
        if (obj != null) {
            b.a(c(), uri.getQueryParameter("sp_file_name"), str2, obj);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, String str, String[] strArr) {
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit[2].equals("clean")) {
            b.a(c(), uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = strArrSplit[2];
        if (b.a(c(), uri.getQueryParameter("sp_file_name"), str2)) {
            b.b(c(), uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        a(uri, contentValues);
        return 0;
    }
}
