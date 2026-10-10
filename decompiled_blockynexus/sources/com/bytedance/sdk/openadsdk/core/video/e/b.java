package com.bytedance.sdk.openadsdk.core.video.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.openadsdk.utils.o;
import io.rong.common.LibStorageUtils;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: AndroidMediaPlayer.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.sdk.openadsdk.core.video.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaPlayer f6464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f6465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.a.b f6466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Surface f6467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f6468e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6469f;

    /* JADX INFO: compiled from: AndroidMediaPlayer.java */
    private class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakReference<b> f6471b;

        public a(b bVar) {
            this.f6471b = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (this.f6471b.get() != null) {
                    b.this.a(i);
                }
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                if (this.f6471b.get() != null) {
                    b.this.c();
                }
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                if (this.f6471b.get() != null) {
                    return b.this.a(i, i2);
                }
                return false;
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                if (this.f6471b.get() != null) {
                    return b.this.b(i, i2);
                }
                return false;
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                if (this.f6471b.get() != null) {
                    b.this.b();
                }
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                if (this.f6471b.get() != null) {
                    b.this.d();
                }
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                if (this.f6471b.get() != null) {
                    b.this.a(i, i2, 1, 1);
                }
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }
    }

    public b() {
        synchronized (this.f6468e) {
            this.f6464a = new MediaPlayer();
        }
        a(this.f6464a);
        try {
            this.f6464a.setAudioStreamType(3);
        } catch (Throwable th) {
            o.c("AndroidMediaPlayer", "setAudioStreamType error: ", th);
        }
        this.f6465b = new a(this);
        n();
    }

    private void a(MediaPlayer mediaPlayer) {
        int i = Build.VERSION.SDK_INT;
        if (i < 19 || i >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.bytedance.sdk.openadsdk.core.o.a(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                try {
                    declaredField.set(objNewInstance, new Handler());
                    declaredField.setAccessible(false);
                    mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
                } catch (Throwable th) {
                    declaredField.setAccessible(false);
                    throw th;
                }
            } catch (Throwable th2) {
                o.c("AndroidMediaPlayer", "subtitleInstance error: ", th2);
                declaredField.setAccessible(false);
            }
        } catch (Throwable th3) {
            o.c("AndroidMediaPlayer", "setSubtitleController error: ", th3);
        }
    }

    private void m() {
        com.bytedance.sdk.openadsdk.core.video.a.b bVar;
        if (Build.VERSION.SDK_INT < 23 || (bVar = this.f6466c) == null) {
            return;
        }
        try {
            bVar.close();
        } catch (Throwable th) {
            o.c("AndroidMediaPlayer", "releaseMediaDataSource error: ", th);
        }
        this.f6466c = null;
    }

    private void n() {
        this.f6464a.setOnPreparedListener(this.f6465b);
        this.f6464a.setOnBufferingUpdateListener(this.f6465b);
        this.f6464a.setOnCompletionListener(this.f6465b);
        this.f6464a.setOnSeekCompleteListener(this.f6465b);
        this.f6464a.setOnVideoSizeChangedListener(this.f6465b);
        this.f6464a.setOnErrorListener(this.f6465b);
        this.f6464a.setOnInfoListener(this.f6465b);
    }

    private void o() {
        try {
            if (this.f6467d != null) {
                this.f6467d.release();
                this.f6467d = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void b(boolean z) throws Throwable {
        this.f6464a.setLooping(z);
    }

    public MediaPlayer e() {
        return this.f6464a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void f() throws Throwable {
        this.f6464a.start();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        o();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void g() throws Throwable {
        this.f6464a.stop();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void h() throws Throwable {
        this.f6464a.pause();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public long i() {
        try {
            return this.f6464a.getCurrentPosition();
        } catch (Throwable th) {
            o.c("AndroidMediaPlayer", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public long j() {
        try {
            return this.f6464a.getDuration();
        } catch (Throwable th) {
            o.c("AndroidMediaPlayer", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void k() throws Throwable {
        this.f6469f = true;
        this.f6464a.release();
        o();
        m();
        a();
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void l() throws Throwable {
        try {
            this.f6464a.reset();
        } catch (Throwable th) {
            o.c("AndroidMediaPlayer", "reset error: ", th);
        }
        m();
        a();
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.f6468e) {
            if (!this.f6469f) {
                this.f6464a.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    @TargetApi(14)
    public void a(Surface surface) {
        o();
        this.f6467d = surface;
        this.f6464a.setSurface(surface);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(String str) throws Throwable {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(LibStorageUtils.FILE)) {
            this.f6464a.setDataSource(uri.getPath());
        } else {
            this.f6464a.setDataSource(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(FileDescriptor fileDescriptor) throws Throwable {
        this.f6464a.setDataSource(fileDescriptor);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(String str, String str2) {
        this.f6466c = com.bytedance.sdk.openadsdk.core.video.a.a.a(str2);
        if (this.f6466c == null) {
            this.f6466c = new com.bytedance.sdk.openadsdk.core.video.a.b(com.bytedance.sdk.openadsdk.core.o.a(), str, str2);
            if (this.f6466c.a()) {
                com.bytedance.sdk.openadsdk.core.video.a.a.a(str2, this.f6466c);
            }
        }
        this.f6464a.setDataSource(this.f6466c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(boolean z) throws Throwable {
        this.f6464a.setScreenOnWhilePlaying(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(long j) throws Throwable {
        this.f6464a.seekTo((int) j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(float f2, float f3) throws Throwable {
        this.f6464a.setVolume(f2, f3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(Context context, int i) throws Throwable {
        this.f6464a.setWakeMode(context, i);
    }
}
