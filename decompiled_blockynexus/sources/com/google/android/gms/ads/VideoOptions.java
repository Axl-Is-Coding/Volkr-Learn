package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzaak;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoOptions {
    private final boolean zzadv;
    private final boolean zzadw;
    private final boolean zzadx;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static final class Builder {
        private boolean zzadv = true;
        private boolean zzadw = false;
        private boolean zzadx = false;

        public final VideoOptions build() {
            return new VideoOptions(this);
        }

        public final Builder setClickToExpandRequested(boolean z) {
            this.zzadx = z;
            return this;
        }

        public final Builder setCustomControlsRequested(boolean z) {
            this.zzadw = z;
            return this;
        }

        public final Builder setStartMuted(boolean z) {
            this.zzadv = z;
            return this;
        }
    }

    public VideoOptions(zzaak zzaakVar) {
        this.zzadv = zzaakVar.zzadv;
        this.zzadw = zzaakVar.zzadw;
        this.zzadx = zzaakVar.zzadx;
    }

    public final boolean getClickToExpandRequested() {
        return this.zzadx;
    }

    public final boolean getCustomControlsRequested() {
        return this.zzadw;
    }

    public final boolean getStartMuted() {
        return this.zzadv;
    }

    private VideoOptions(Builder builder) {
        this.zzadv = builder.zzadv;
        this.zzadw = builder.zzadw;
        this.zzadx = builder.zzadx;
    }
}
