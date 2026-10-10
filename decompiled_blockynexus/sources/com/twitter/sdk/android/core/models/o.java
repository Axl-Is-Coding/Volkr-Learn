package com.twitter.sdk.android.core.models;

import java.util.List;

/* JADX INFO: compiled from: TweetEntities.java */
/* JADX INFO: loaded from: classes5.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final o f20250a = new o(null, null, null, null, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.a.c("urls")
    public final List<UrlEntity> f20251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.a.c("user_mentions")
    public final List<MentionEntity> f20252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.a.c("media")
    public final List<MediaEntity> f20253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.gson.a.c("hashtags")
    public final List<HashtagEntity> f20254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.gson.a.c("symbols")
    public final List<SymbolEntity> f20255f;

    public o(List<UrlEntity> list, List<MentionEntity> list2, List<MediaEntity> list3, List<HashtagEntity> list4, List<SymbolEntity> list5) {
        this.f20251b = i.a(list);
        this.f20252c = i.a(list2);
        this.f20253d = i.a(list3);
        this.f20254e = i.a(list4);
        this.f20255f = i.a(list5);
    }
}
