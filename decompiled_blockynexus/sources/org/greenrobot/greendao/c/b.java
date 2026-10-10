package org.greenrobot.greendao.c;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: compiled from: FastCursor.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Cursor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CursorWindow f23575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23577c;

    public b(CursorWindow cursorWindow) {
        this.f23575a = cursorWindow;
        this.f23577c = cursorWindow.getNumRows();
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void deactivate() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i) {
        return this.f23575a.getBlob(this.f23576b, i);
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public String getColumnName(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public int getCount() {
        return this.f23575a.getNumRows();
    }

    @Override // android.database.Cursor
    public double getDouble(int i) {
        return this.f23575a.getDouble(this.f23576b, i);
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public float getFloat(int i) {
        return this.f23575a.getFloat(this.f23576b, i);
    }

    @Override // android.database.Cursor
    public int getInt(int i) {
        return this.f23575a.getInt(this.f23576b, i);
    }

    @Override // android.database.Cursor
    public long getLong(int i) {
        return this.f23575a.getLong(this.f23576b, i);
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return null;
    }

    @Override // android.database.Cursor
    public int getPosition() {
        return this.f23576b;
    }

    @Override // android.database.Cursor
    public short getShort(int i) {
        return this.f23575a.getShort(this.f23576b, i);
    }

    @Override // android.database.Cursor
    public String getString(int i) {
        return this.f23575a.getString(this.f23576b, i);
    }

    @Override // android.database.Cursor
    public int getType(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        return this.f23576b == 0;
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        return this.f23576b == this.f23577c - 1;
    }

    @Override // android.database.Cursor
    public boolean isNull(int i) {
        return this.f23575a.isNull(this.f23576b, i);
    }

    @Override // android.database.Cursor
    public boolean move(int i) {
        return moveToPosition(this.f23576b + i);
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        this.f23576b = 0;
        return this.f23577c > 0;
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        int i = this.f23577c;
        if (i <= 0) {
            return false;
        }
        this.f23576b = i - 1;
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        int i = this.f23576b;
        if (i >= this.f23577c - 1) {
            return false;
        }
        this.f23576b = i + 1;
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i) {
        if (i < 0 || i >= this.f23577c) {
            return false;
        }
        this.f23576b = i;
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        int i = this.f23576b;
        if (i <= 0) {
            return false;
        }
        this.f23576b = i - 1;
        return true;
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean requery() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }
}
