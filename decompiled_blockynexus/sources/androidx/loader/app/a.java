package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.s;
import androidx.loader.content.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: LoaderManager.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: androidx.loader.app.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoaderManager.java */
    public interface InterfaceC0024a<D> {
        c<D> onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(c<D> cVar, D d2);

        void onLoaderReset(c<D> cVar);
    }

    public static <T extends g & s> a a(T t) {
        return new LoaderManagerImpl(t, t.getViewModelStore());
    }

    public abstract <D> c<D> a(int i, Bundle bundle, InterfaceC0024a<D> interfaceC0024a);

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
