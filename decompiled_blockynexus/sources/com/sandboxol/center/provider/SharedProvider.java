package com.sandboxol.center.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SharedProvider extends ContentProvider {
    private static Uri AUTHORITY_URI;
    private static Uri CONTENT_URI;

    public static boolean getBoolean(Context context, String str) {
        return getBoolean(context, str, false);
    }

    private static Uri getContentUri(Context context) {
        if (CONTENT_URI == null) {
            synchronized (SharedProvider.class) {
                AUTHORITY_URI = Uri.parse("content://" + context.getPackageName() + ".sp");
                CONTENT_URI = AUTHORITY_URI;
            }
        }
        return CONTENT_URI;
    }

    public static int getInt(Context context, String str) {
        return getInt(context, str, 0);
    }

    public static long getLong(Context context, String str) {
        return getInt(context, str, 0);
    }

    public static String getString(Context context, String str) {
        return getString(context, str, "");
    }

    private String getValue(String str, String str2) {
        return SharedUtils.getString(getContext(), str, str2);
    }

    private static void onSave(Context context, ContentValues contentValues) {
        try {
            context.getContentResolver().insert(getContentUri(context), contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void putBoolean(Context context, String str, boolean z) {
        putInt(context, str, z ? 1 : 0);
    }

    public static void putInt(Context context, String str, int i) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(str, Integer.valueOf(i));
        onSave(context, contentValues);
    }

    public static void putLong(Context context, String str, long j) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(str, Long.valueOf(j));
        onSave(context, contentValues);
    }

    public static void putString(Context context, String str, String str2) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(str, str2);
        onSave(context, contentValues);
    }

    private static Cursor query(Context context, String... strArr) {
        return context.getContentResolver().query(getContentUri(context), strArr, null, null, null);
    }

    protected Cursor createCursor(String[] strArr, String[] strArr2) {
        MatrixCursor matrixCursor = new MatrixCursor(strArr, 1);
        matrixCursor.addRow(strArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "content";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues == null || contentValues.size() <= 0) {
            return null;
        }
        onSave(contentValues);
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (getContext() == null || getContext().getPackageName() == null) {
            return true;
        }
        getContentUri(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return getInt(context, str, z ? 1 : 0) != 0;
    }

    public static int getInt(Context context, String str, int i) {
        Cursor cursorQuery = query(context, str);
        if (cursorQuery != null) {
            if (cursorQuery.moveToNext()) {
                try {
                    i = cursorQuery.getInt(0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            cursorQuery.close();
        }
        return i;
    }

    public static long getLong(Context context, String str, long j) {
        Cursor cursorQuery = query(context, str);
        if (cursorQuery != null) {
            if (cursorQuery.moveToNext()) {
                try {
                    j = cursorQuery.getLong(0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            cursorQuery.close();
        }
        return j;
    }

    public static String getString(Context context, String str, String str2) {
        String string;
        Cursor cursorQuery = query(context, str);
        if (cursorQuery != null) {
            if (cursorQuery.moveToNext()) {
                try {
                    string = cursorQuery.getString(0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    string = str2;
                }
                if (!TextUtils.isEmpty(string)) {
                    str2 = string;
                }
            }
            cursorQuery.close();
        }
        return str2;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int length = strArr == null ? 0 : strArr.length;
        if (length <= 0) {
            return null;
        }
        String[] strArr3 = new String[length];
        for (int i = 0; i < length; i++) {
            strArr3[i] = getValue(strArr[i], "");
        }
        return createCursor(strArr, strArr3);
    }

    private void onSave(ContentValues contentValues) {
        String asString;
        for (String str : contentValues.keySet()) {
            if (!TextUtils.isEmpty(str) && (asString = contentValues.getAsString(str)) != null) {
                SharedUtils.putString(getContext(), str, asString);
            }
        }
    }
}
