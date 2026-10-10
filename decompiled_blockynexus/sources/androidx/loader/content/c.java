package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: Loader.java */
/* JADX INFO: loaded from: classes.dex */
public class c<D> {
    Context mContext;
    int mId;
    InterfaceC0026c<D> mListener;
    b<D> mOnLoadCanceledListener;
    boolean mStarted = false;
    boolean mAbandoned = false;
    boolean mReset = true;
    boolean mContentChanged = false;
    boolean mProcessingChange = false;

    /* JADX INFO: compiled from: Loader.java */
    public final class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            c.this.onContentChanged();
        }
    }

    /* JADX INFO: compiled from: Loader.java */
    public interface b<D> {
        void a(c<D> cVar);
    }

    /* JADX INFO: renamed from: androidx.loader.content.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Loader.java */
    public interface InterfaceC0026c<D> {
        void a(c<D> cVar, D d2);
    }

    public c(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(D d2) {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.f.a.a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    public void deliverCancellation() {
        b<D> bVar = this.mOnLoadCanceledListener;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void deliverResult(D d2) {
        InterfaceC0026c<D> interfaceC0026c = this.mListener;
        if (interfaceC0026c != null) {
            interfaceC0026c.a(this, d2);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }

    public void forceLoad() {
        onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    protected void onAbandon() {
    }

    protected boolean onCancelLoad() {
        throw null;
    }

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    protected void onForceLoad() {
    }

    protected void onReset() {
    }

    protected void onStartLoading() {
        throw null;
    }

    protected void onStopLoading() {
    }

    public void registerListener(int i, InterfaceC0026c<D> interfaceC0026c) {
        if (this.mListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mListener = interfaceC0026c;
        this.mId = i;
    }

    public void registerOnLoadCanceledListener(b<D> bVar) {
        if (this.mOnLoadCanceledListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mOnLoadCanceledListener = bVar;
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.f.a.a(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append("}");
        return sb.toString();
    }

    public void unregisterListener(InterfaceC0026c<D> interfaceC0026c) {
        InterfaceC0026c<D> interfaceC0026c2 = this.mListener;
        if (interfaceC0026c2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0026c2 != interfaceC0026c) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.mListener = null;
    }

    public void unregisterOnLoadCanceledListener(b<D> bVar) {
        b<D> bVar2 = this.mOnLoadCanceledListener;
        if (bVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (bVar2 != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.mOnLoadCanceledListener = null;
    }
}
