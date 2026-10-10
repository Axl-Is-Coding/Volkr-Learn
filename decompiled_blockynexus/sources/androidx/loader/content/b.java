package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: CursorLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends a<Cursor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final c<Cursor>.a f1631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Uri f1632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String[] f1633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f1634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String[] f1635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f1636f;
    Cursor g;
    androidx.core.os.a h;

    public b(Context context) {
        super(context);
        this.f1631a = new c.a();
    }

    @Override // androidx.loader.content.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deliverResult(Cursor cursor) {
        if (isReset()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.g;
        this.g = cursor;
        if (isStarted()) {
            super.deliverResult(cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @Override // androidx.loader.content.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onCanceled(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    @Override // androidx.loader.content.a
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            if (this.h != null) {
                this.h.a();
            }
        }
    }

    @Override // androidx.loader.content.a, androidx.loader.content.c
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f1632b);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f1633c));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f1634d);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f1635e));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f1636f);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.g);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.mContentChanged);
    }

    @Override // androidx.loader.content.c
    protected void onReset() {
        super.onReset();
        onStopLoading();
        Cursor cursor = this.g;
        if (cursor != null && !cursor.isClosed()) {
            this.g.close();
        }
        this.g = null;
    }

    @Override // androidx.loader.content.c
    protected void onStartLoading() {
        Cursor cursor = this.g;
        if (cursor != null) {
            deliverResult(cursor);
        }
        if (takeContentChanged() || this.g == null) {
            forceLoad();
        }
    }

    @Override // androidx.loader.content.c
    protected void onStopLoading() {
        cancelLoad();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.a
    public Cursor loadInBackground() {
        synchronized (this) {
            if (isLoadInBackgroundCanceled()) {
                throw new OperationCanceledException();
            }
            this.h = new androidx.core.os.a();
        }
        try {
            Cursor cursorA = androidx.core.content.a.a(getContext().getContentResolver(), this.f1632b, this.f1633c, this.f1634d, this.f1635e, this.f1636f, this.h);
            if (cursorA != null) {
                try {
                    cursorA.getCount();
                    cursorA.registerContentObserver(this.f1631a);
                } catch (RuntimeException e2) {
                    cursorA.close();
                    throw e2;
                }
            }
            synchronized (this) {
                this.h = null;
            }
            return cursorA;
        } catch (Throwable th) {
            synchronized (this) {
                this.h = null;
                throw th;
            }
        }
    }

    public b(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f1631a = new c.a();
        this.f1632b = uri;
        this.f1633c = strArr;
        this.f1634d = str;
        this.f1635e = strArr2;
        this.f1636f = str2;
    }

    public void b(String[] strArr) {
        this.f1635e = strArr;
    }

    public void b(String str) {
        this.f1636f = str;
    }

    public void a(Uri uri) {
        this.f1632b = uri;
    }

    public void a(String[] strArr) {
        this.f1633c = strArr;
    }

    public void a(String str) {
        this.f1634d = str;
    }
}
