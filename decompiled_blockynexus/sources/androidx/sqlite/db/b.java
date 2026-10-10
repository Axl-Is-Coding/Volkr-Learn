package androidx.sqlite.db;

import android.database.Cursor;
import java.io.Closeable;

/* JADX INFO: compiled from: SupportSQLiteDatabase.java */
/* JADX INFO: loaded from: classes.dex */
public interface b extends Closeable {
    void D();

    void E();

    void F();

    boolean J();

    Cursor a(e eVar);

    boolean isOpen();
}
