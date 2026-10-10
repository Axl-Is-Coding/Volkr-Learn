package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.models.MediaEntity;

/* JADX INFO: renamed from: com.twitter.sdk.android.tweetui.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FormattedMediaEntity.java */
/* JADX INFO: loaded from: classes5.dex */
class C2775m extends o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f20436f;
    final String g;

    C2775m(MediaEntity mediaEntity) {
        super(mediaEntity.getStart(), mediaEntity.getEnd(), mediaEntity.displayUrl, mediaEntity.url, mediaEntity.expandedUrl);
        this.f20436f = mediaEntity.type;
        this.g = mediaEntity.mediaUrlHttps;
    }
}
