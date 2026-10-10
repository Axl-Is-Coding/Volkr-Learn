package com.google.android.gms.ads;

import android.os.RemoteException;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaah;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzyo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoController {

    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;

    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;

    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object lock = new Object();
    private zzyo zzadr;
    private VideoLifecycleCallbacks zzads;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    @Deprecated
    public final float getAspectRatio() {
        synchronized (this.lock) {
            if (this.zzadr == null) {
                return WheelView.DividerConfig.FILL;
            }
            try {
                return this.zzadr.getAspectRatio();
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call getAspectRatio on video controller.", e2);
                return WheelView.DividerConfig.FILL;
            }
        }
    }

    @KeepForSdk
    public final int getPlaybackState() {
        synchronized (this.lock) {
            if (this.zzadr == null) {
                return 0;
            }
            try {
                return this.zzadr.getPlaybackState();
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call getPlaybackState on video controller.", e2);
                return 0;
            }
        }
    }

    public final float getVideoCurrentTime() {
        synchronized (this.lock) {
            if (this.zzadr == null) {
                return WheelView.DividerConfig.FILL;
            }
            try {
                return this.zzadr.getCurrentTime();
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call getCurrentTime on video controller.", e2);
                return WheelView.DividerConfig.FILL;
            }
        }
    }

    public final float getVideoDuration() {
        synchronized (this.lock) {
            if (this.zzadr == null) {
                return WheelView.DividerConfig.FILL;
            }
            try {
                return this.zzadr.getDuration();
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call getDuration on video controller.", e2);
                return WheelView.DividerConfig.FILL;
            }
        }
    }

    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.lock) {
            videoLifecycleCallbacks = this.zzads;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzadr != null;
        }
        return z;
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.lock) {
            if (this.zzadr == null) {
                return false;
            }
            try {
                return this.zzadr.isClickToExpandEnabled();
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call isClickToExpandEnabled.", e2);
                return false;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.lock) {
            if (this.zzadr == null) {
                return false;
            }
            try {
                return this.zzadr.isCustomControlsEnabled();
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call isUsingCustomPlayerControls.", e2);
                return false;
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.lock) {
            if (this.zzadr == null) {
                return true;
            }
            try {
                return this.zzadr.isMuted();
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call isMuted on video controller.", e2);
                return true;
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.lock) {
            if (this.zzadr == null) {
                return;
            }
            try {
                this.zzadr.mute(z);
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call mute on video controller.", e2);
            }
        }
    }

    public final void pause() {
        synchronized (this.lock) {
            if (this.zzadr == null) {
                return;
            }
            try {
                this.zzadr.pause();
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call pause on video controller.", e2);
            }
        }
    }

    public final void play() {
        synchronized (this.lock) {
            if (this.zzadr == null) {
                return;
            }
            try {
                this.zzadr.play();
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call play on video controller.", e2);
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.lock) {
            this.zzads = videoLifecycleCallbacks;
            if (this.zzadr == null) {
                return;
            }
            try {
                this.zzadr.zza(new zzaah(videoLifecycleCallbacks));
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", e2);
            }
        }
    }

    public final void stop() {
        synchronized (this.lock) {
            if (this.zzadr == null) {
                return;
            }
            try {
                this.zzadr.stop();
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call stop on video controller.", e2);
            }
        }
    }

    public final void zza(zzyo zzyoVar) {
        synchronized (this.lock) {
            this.zzadr = zzyoVar;
            if (this.zzads != null) {
                setVideoLifecycleCallbacks(this.zzads);
            }
        }
    }

    public final zzyo zzdv() {
        zzyo zzyoVar;
        synchronized (this.lock) {
            zzyoVar = this.zzadr;
        }
        return zzyoVar;
    }
}
