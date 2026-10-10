package com.bytedance.sdk.openadsdk.core.video.e;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;

/* JADX INFO: compiled from: IMediaPlayer.java */
/* JADX INFO: loaded from: classes.dex */
public interface c {

    /* JADX INFO: compiled from: IMediaPlayer.java */
    public interface a {
        void a(c cVar, int i);
    }

    /* JADX INFO: compiled from: IMediaPlayer.java */
    public interface b {
        void a(c cVar);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.e.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IMediaPlayer.java */
    public interface InterfaceC0082c {
        boolean a(c cVar, int i, int i2);
    }

    /* JADX INFO: compiled from: IMediaPlayer.java */
    public interface d {
        boolean b(c cVar, int i, int i2);
    }

    /* JADX INFO: compiled from: IMediaPlayer.java */
    public interface e {
        void b(c cVar);
    }

    /* JADX INFO: compiled from: IMediaPlayer.java */
    public interface f {
        void c(c cVar);
    }

    /* JADX INFO: compiled from: IMediaPlayer.java */
    public interface g {
        void a(c cVar, int i, int i2, int i3, int i4);
    }

    void a(float f2, float f3) throws Throwable;

    void a(long j) throws Throwable;

    @Deprecated
    void a(Context context, int i) throws Throwable;

    void a(Surface surface) throws Throwable;

    void a(SurfaceHolder surfaceHolder) throws Throwable;

    void a(a aVar);

    void a(b bVar);

    void a(InterfaceC0082c interfaceC0082c);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void a(g gVar);

    void a(FileDescriptor fileDescriptor) throws Throwable;

    void a(String str) throws Throwable;

    void a(String str, String str2);

    void a(boolean z) throws Throwable;

    void b(boolean z) throws Throwable;

    void f() throws Throwable;

    void g() throws Throwable;

    void h() throws Throwable;

    long i() throws Throwable;

    long j() throws Throwable;

    void k() throws Throwable;

    void l() throws Throwable;
}
