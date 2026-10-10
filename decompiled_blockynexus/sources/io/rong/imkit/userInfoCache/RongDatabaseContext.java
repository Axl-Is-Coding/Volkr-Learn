package io.rong.imkit.userInfoCache;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import io.rong.common.rlog.RLog;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class RongDatabaseContext extends ContextWrapper {
    private static final String TAG = "RongDatabaseContext";
    private String mDirPath;

    public RongDatabaseContext(Context context, String str) {
        super(context);
        this.mDirPath = str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        File file = new File(this.mDirPath + File.separator + str);
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            RLog.e(TAG, "Created folders UnSuccessfully");
        }
        return file;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory, databaseErrorHandler);
    }
}
