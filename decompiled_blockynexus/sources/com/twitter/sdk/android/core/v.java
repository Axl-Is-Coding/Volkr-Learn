package com.twitter.sdk.android.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* JADX INFO: compiled from: TwitterContext.java */
/* JADX INFO: loaded from: classes5.dex */
class v extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20280b;

    v(Context context, String str, String str2) {
        super(context);
        this.f20280b = str;
        this.f20279a = str2;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        return new File(super.getCacheDir(), this.f20279a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        File file = new File(super.getDatabasePath(str).getParentFile(), this.f20279a);
        file.mkdirs();
        return new File(file, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        return new File(super.getExternalCacheDir(), this.f20279a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        return new File(super.getExternalFilesDir(str), this.f20279a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        return new File(super.getFilesDir(), this.f20279a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return super.getSharedPreferences(this.f20280b + ":" + str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getPath(), cursorFactory, databaseErrorHandler);
    }
}
