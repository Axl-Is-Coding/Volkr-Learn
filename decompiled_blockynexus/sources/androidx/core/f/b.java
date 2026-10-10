package androidx.core.f;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: compiled from: LogWriter.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuilder f1152b = new StringBuilder(128);

    public b(String str) {
        this.f1151a = str;
    }

    private void b() {
        if (this.f1152b.length() > 0) {
            Log.d(this.f1151a, this.f1152b.toString());
            StringBuilder sb = this.f1152b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        b();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == '\n') {
                b();
            } else {
                this.f1152b.append(c2);
            }
        }
    }
}
