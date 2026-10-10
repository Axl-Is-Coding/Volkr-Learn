package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;

    @Deprecated
    public static final int ORIENTATION_ANY = 0;

    @Deprecated
    public static final int ORIENTATION_LANDSCAPE = 2;

    @Deprecated
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzbnm;
    private final int zzbnn;
    private final int zzbno;
    private final boolean zzbnp;
    private final int zzbnq;
    private final VideoOptions zzbnr;
    private final boolean zzbns;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public @interface AdChoicesPlacement {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static final class Builder {
        private VideoOptions zzbnr;
        private boolean zzbnm = false;
        private int zzbnn = -1;
        private int zzbno = 0;
        private boolean zzbnp = false;
        private int zzbnq = 1;
        private boolean zzbns = false;

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public final Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.zzbnq = i;
            return this;
        }

        @Deprecated
        public final Builder setImageOrientation(int i) {
            this.zzbnn = i;
            return this;
        }

        public final Builder setMediaAspectRatio(@NativeMediaAspectRatio int i) {
            this.zzbno = i;
            return this;
        }

        public final Builder setRequestCustomMuteThisAd(boolean z) {
            this.zzbns = z;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.zzbnp = z;
            return this;
        }

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzbnm = z;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzbnr = videoOptions;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public @interface NativeMediaAspectRatio {
    }

    private NativeAdOptions(Builder builder) {
        this.zzbnm = builder.zzbnm;
        this.zzbnn = builder.zzbnn;
        this.zzbno = builder.zzbno;
        this.zzbnp = builder.zzbnp;
        this.zzbnq = builder.zzbnq;
        this.zzbnr = builder.zzbnr;
        this.zzbns = builder.zzbns;
    }

    public final int getAdChoicesPlacement() {
        return this.zzbnq;
    }

    @Deprecated
    public final int getImageOrientation() {
        return this.zzbnn;
    }

    public final int getMediaAspectRatio() {
        return this.zzbno;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbnr;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.zzbnp;
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.zzbnm;
    }

    public final boolean zzjt() {
        return this.zzbns;
    }
}
