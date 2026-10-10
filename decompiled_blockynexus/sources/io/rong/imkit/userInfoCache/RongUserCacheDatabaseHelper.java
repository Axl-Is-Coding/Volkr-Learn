package io.rong.imkit.userInfoCache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import io.rong.imlib.common.SavePathUtils;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
class RongUserCacheDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "IMKitUserInfoCache";
    private static final int DB_VERSION = 2;
    private static String dbPath;

    public RongUserCacheDatabaseHelper(Context context) {
        this(context, DB_NAME, null, 2);
    }

    public static void setDbPath(Context context, String str, String str2) {
        dbPath = SavePathUtils.getSavePath(context.getFilesDir().getAbsolutePath());
        dbPath += File.separator + str + File.separator + str2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE users (id TEXT PRIMARY KEY NOT NULL UNIQUE, name TEXT, portrait TEXT, extra TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS id_idx_users ON users(id)");
        sQLiteDatabase.execSQL("CREATE TABLE group_users (group_id TEXT NOT NULL, user_id TEXT NOT NULL, nickname TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE groups (id TEXT PRIMARY KEY NOT NULL UNIQUE, name TEXT, portrait TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE discussions (id TEXT PRIMARY KEY NOT NULL UNIQUE, name TEXT, portrait TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE users ADD COLUMN extra TEXT");
        }
    }

    private RongUserCacheDatabaseHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(new RongDatabaseContext(context, dbPath), str, cursorFactory, i);
    }
}
