package com.bytedance.sdk.openadsdk.core.video.e;

import com.bytedance.sdk.openadsdk.core.video.e.c;
import com.bytedance.sdk.openadsdk.utils.o;

/* JADX INFO: compiled from: AbstractMediaPlayer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c.e f6458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c.b f6459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c.a f6460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c.f f6461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c.g f6462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c.InterfaceC0082c f6463f;
    private c.d g;

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.e eVar) {
        this.f6458a = eVar;
    }

    protected final void b() {
        try {
            if (this.f6458a != null) {
                this.f6458a.b(this);
            }
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    protected final void c() {
        try {
            if (this.f6459b != null) {
                this.f6459b.a(this);
            }
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    protected final void d() {
        try {
            if (this.f6461d != null) {
                this.f6461d.c(this);
            }
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.b bVar) {
        this.f6459b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.a aVar) {
        this.f6460c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.f fVar) {
        this.f6461d = fVar;
    }

    protected final boolean b(int i, int i2) {
        try {
            if (this.g != null) {
                return this.g.b(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.InterfaceC0082c interfaceC0082c) {
        this.f6463f = interfaceC0082c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.d dVar) {
        this.g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.g gVar) {
        this.f6462e = gVar;
    }

    public void a() {
        this.f6458a = null;
        this.f6460c = null;
        this.f6459b = null;
        this.f6461d = null;
        this.f6462e = null;
        this.f6463f = null;
        this.g = null;
    }

    protected final void a(int i) {
        try {
            if (this.f6460c != null) {
                this.f6460c.a(this, i);
            }
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    protected final void a(int i, int i2, int i3, int i4) {
        try {
            if (this.f6462e != null) {
                this.f6462e.a(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    protected final boolean a(int i, int i2) {
        try {
            if (this.f6463f != null) {
                return this.f6463f.a(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }
}
