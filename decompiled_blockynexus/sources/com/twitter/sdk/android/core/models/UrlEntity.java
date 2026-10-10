package com.twitter.sdk.android.core.models;

/* JADX INFO: loaded from: classes5.dex */
public class UrlEntity extends Entity {

    @com.google.gson.a.c("display_url")
    public final String displayUrl;

    @com.google.gson.a.c("expanded_url")
    public final String expandedUrl;

    @com.google.gson.a.c("url")
    public final String url;

    public UrlEntity(String str, String str2, String str3, int i, int i2) {
        super(i, i2);
        this.url = str;
        this.expandedUrl = str2;
        this.displayUrl = str3;
    }

    @Override // com.twitter.sdk.android.core.models.Entity
    public /* bridge */ /* synthetic */ int getEnd() {
        return super.getEnd();
    }

    @Override // com.twitter.sdk.android.core.models.Entity
    public /* bridge */ /* synthetic */ int getStart() {
        return super.getStart();
    }
}
