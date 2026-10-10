package c.t.m.g;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import c.t.m.g.Ya;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f3047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f3048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BufferedOutputStream f3049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Ya.a f3050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3052f;
    private boolean g;
    private long h;
    private String i;
    private int j;
    private int k;

    public Xa(File file) throws IOException {
        this(file, (byte) 0);
    }

    public static void a(HandlerThread handlerThread, Handler handler, long j) {
        if (j <= 0) {
            a(handlerThread);
            return;
        }
        if (handler == null && Looper.myLooper() != null) {
            handler = new Handler(Looper.myLooper());
        }
        Timer timer = handler == null ? new Timer("th_quit_delay") : null;
        Wa wa = new Wa(handlerThread, handler, timer);
        if (handler != null) {
            handler.postDelayed(wa, j);
        } else {
            timer.schedule(wa, j);
        }
    }

    public final File b() {
        File file;
        synchronized (this.f3047a) {
            file = this.f3048b;
        }
        return file;
    }

    private Xa(File file, byte b2) throws IOException {
        this.f3047a = new byte[0];
        this.f3051e = "";
        this.f3052f = 0;
        this.g = false;
        this.h = 0L;
        this.i = "";
        this.j = 1;
        this.k = 0;
        this.f3048b = file;
        File parentFile = file == null ? null : file.getParentFile();
        if ((parentFile == null || !parentFile.exists()) && !parentFile.mkdirs()) {
            return;
        }
        this.f3051e = file.getAbsolutePath();
        this.f3052f = 5120;
        StringBuilder sb = new StringBuilder("create file:");
        sb.append(file.getAbsolutePath());
        sb.append(",bufSize:5120");
        this.f3049c = new BufferedOutputStream(new FileOutputStream(file, true), 5120);
    }

    static void a(HandlerThread handlerThread) {
        if (handlerThread != null) {
            try {
                if (Build.VERSION.SDK_INT >= 18) {
                    handlerThread.quitSafely();
                } else {
                    handlerThread.quit();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void a() throws IOException {
        synchronized (this.f3047a) {
            if (this.f3049c == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3048b.getAbsolutePath());
            sb.append(" close().");
            this.f3049c.flush();
            this.f3049c.close();
            this.j = 1;
            this.f3049c = null;
        }
    }

    public final void a(Ya.a aVar) {
        synchronized (this.f3047a) {
            this.f3050d = aVar;
        }
    }
}
