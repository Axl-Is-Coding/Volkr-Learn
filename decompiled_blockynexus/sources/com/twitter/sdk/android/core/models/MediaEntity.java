package com.twitter.sdk.android.core.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class MediaEntity extends UrlEntity {

    @com.google.gson.a.c("ext_alt_text")
    public final String altText;

    @com.google.gson.a.c("id")
    public final long id;

    @com.google.gson.a.c("id_str")
    public final String idStr;

    @com.google.gson.a.c("media_url")
    public final String mediaUrl;

    @com.google.gson.a.c("media_url_https")
    public final String mediaUrlHttps;

    @com.google.gson.a.c("sizes")
    public final Sizes sizes;

    @com.google.gson.a.c("source_status_id")
    public final long sourceStatusId;

    @com.google.gson.a.c("source_status_id_str")
    public final String sourceStatusIdStr;

    @com.google.gson.a.c("type")
    public final String type;

    @com.google.gson.a.c("video_info")
    public final VideoInfo videoInfo;

    public static class Size implements Serializable {

        @com.google.gson.a.c("h")
        public final int h;

        @com.google.gson.a.c("resize")
        public final String resize;

        @com.google.gson.a.c("w")
        public final int w;

        public Size(int i, int i2, String str) {
            this.w = i;
            this.h = i2;
            this.resize = str;
        }
    }

    public static class Sizes implements Serializable {

        @com.google.gson.a.c("large")
        public final Size large;

        @com.google.gson.a.c(FirebaseAnalytics.Param.MEDIUM)
        public final Size medium;

        @com.google.gson.a.c("small")
        public final Size small;

        @com.google.gson.a.c("thumb")
        public final Size thumb;

        public Sizes(Size size, Size size2, Size size3, Size size4) {
            this.thumb = size;
            this.small = size2;
            this.medium = size3;
            this.large = size4;
        }
    }

    public MediaEntity(String str, String str2, String str3, int i, int i2, long j, String str4, String str5, String str6, Sizes sizes, long j2, String str7, String str8, VideoInfo videoInfo, String str9) {
        super(str, str2, str3, i, i2);
        this.id = j;
        this.idStr = str4;
        this.mediaUrl = str5;
        this.mediaUrlHttps = str6;
        this.sizes = sizes;
        this.sourceStatusId = j2;
        this.sourceStatusIdStr = str7;
        this.type = str8;
        this.videoInfo = videoInfo;
        this.altText = str9;
    }
}
