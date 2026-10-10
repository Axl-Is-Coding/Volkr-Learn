package com.twitter.sdk.android.core.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class VideoInfo implements Serializable {

    @com.google.gson.a.c("aspect_ratio")
    public final List<Integer> aspectRatio;

    @com.google.gson.a.c("duration_millis")
    public final long durationMillis;

    @com.google.gson.a.c("variants")
    public final List<Variant> variants;

    public static class Variant implements Serializable {

        @com.google.gson.a.c("bitrate")
        public final long bitrate;

        @com.google.gson.a.c(FirebaseAnalytics.Param.CONTENT_TYPE)
        public final String contentType;

        @com.google.gson.a.c("url")
        public final String url;

        public Variant(long j, String str, String str2) {
            this.bitrate = j;
            this.contentType = str;
            this.url = str2;
        }
    }

    private VideoInfo() {
        this(null, 0L, null);
    }

    public VideoInfo(List<Integer> list, long j, List<Variant> list2) {
        this.aspectRatio = i.a(list);
        this.durationMillis = j;
        this.variants = i.a(list2);
    }
}
