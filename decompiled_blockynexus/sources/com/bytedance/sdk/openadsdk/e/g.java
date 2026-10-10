package com.bytedance.sdk.openadsdk.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.bytedance.sdk.openadsdk.utils.o;
import io.rong.common.LibStorageUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: VolumeChangeObserver.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f6727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f6728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f6729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AudioManager f6730e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6726a = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6731f = false;
    private boolean g = false;
    private int h = -1;

    /* JADX INFO: compiled from: VolumeChangeObserver.java */
    private static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<g> f6732a;

        public a(g gVar) {
            this.f6732a = new WeakReference<>(gVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f fVarH;
            int iG;
            try {
                if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    o.b("VolumeChangeObserver", "媒体音量改变通.......");
                    g gVar = this.f6732a.get();
                    if (gVar == null || (fVarH = gVar.h()) == null || (iG = gVar.g()) == gVar.a()) {
                        return;
                    }
                    gVar.a(iG);
                    if (iG >= 0) {
                        fVarH.b(iG);
                    }
                }
            } catch (Throwable th) {
                o.a("VolumeChangeObserver", "onVolumeChangedError: ", th);
            }
        }
    }

    public g(Context context) {
        this.f6729d = context;
        this.f6730e = (AudioManager) context.getApplicationContext().getSystemService(LibStorageUtils.AUDIO);
    }

    public int a() {
        return this.h;
    }

    public int b() {
        return this.f6726a;
    }

    public boolean c() {
        if (!this.g) {
            return false;
        }
        this.g = false;
        return true;
    }

    public int d() {
        try {
            if (this.f6730e != null) {
                return this.f6730e.getStreamMaxVolume(3);
            }
            return 15;
        } catch (Throwable th) {
            o.a("VolumeChangeObserver", "getMaxMusicVolumeError: ", th);
            return 15;
        }
    }

    public void e() {
        try {
            this.f6728c = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f6729d.registerReceiver(this.f6728c, intentFilter);
            this.f6731f = true;
        } catch (Throwable th) {
            o.a("VolumeChangeObserver", "registerReceiverError: ", th);
        }
    }

    public void f() {
        if (this.f6731f) {
            try {
                this.f6729d.unregisterReceiver(this.f6728c);
                this.f6727b = null;
                this.f6731f = false;
            } catch (Throwable th) {
                o.a("VolumeChangeObserver", "unregisterReceiverError: ", th);
            }
        }
    }

    public int g() {
        try {
            if (this.f6730e != null) {
                return this.f6730e.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable th) {
            o.a("VolumeChangeObserver", "getCurrentMusicVolumeError: ", th);
            return -1;
        }
    }

    public f h() {
        return this.f6727b;
    }

    public void a(int i) {
        this.h = i;
    }

    public void b(int i) {
        this.f6726a = i;
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void a(boolean z, boolean z2) {
        if (this.f6730e == null) {
            return;
        }
        int i = 0;
        if (z) {
            int iG = g();
            if (iG != 0) {
                this.f6726a = iG;
            }
            o.b("VolumeChangeObserver", "mute set volume to 0");
            this.f6730e.setStreamVolume(3, 0, 0);
            this.g = true;
            return;
        }
        int iD = this.f6726a;
        if (iD == 0) {
            iD = d() / 15;
        } else {
            if (iD == -1) {
                if (!z2) {
                    return;
                } else {
                    iD = d() / 15;
                }
            }
            o.b("VolumeChangeObserver", "not mute set volume to " + iD + " mLastVolume=" + this.f6726a);
            this.f6726a = -1;
            this.f6730e.setStreamVolume(3, iD, i);
            this.g = true;
        }
        i = 1;
        o.b("VolumeChangeObserver", "not mute set volume to " + iD + " mLastVolume=" + this.f6726a);
        this.f6726a = -1;
        this.f6730e.setStreamVolume(3, iD, i);
        this.g = true;
    }

    public void a(f fVar) {
        this.f6727b = fVar;
    }
}
