package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.MentionEntity;
import com.twitter.sdk.android.core.models.SymbolEntity;
import com.twitter.sdk.android.core.models.UrlEntity;

/* JADX INFO: compiled from: FormattedUrlEntity.java */
/* JADX INFO: loaded from: classes5.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f20443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f20444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f20445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f20446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final String f20447e;

    o(int i, int i2, String str, String str2, String str3) {
        this.f20443a = i;
        this.f20444b = i2;
        this.f20445c = str;
        this.f20446d = str2;
        this.f20447e = str3;
    }

    static o a(UrlEntity urlEntity) {
        return new o(urlEntity.getStart(), urlEntity.getEnd(), urlEntity.displayUrl, urlEntity.url, urlEntity.expandedUrl);
    }

    static o a(HashtagEntity hashtagEntity) {
        String strA = M.a(hashtagEntity.text);
        return new o(hashtagEntity.getStart(), hashtagEntity.getEnd(), "#" + hashtagEntity.text, strA, strA);
    }

    static o a(MentionEntity mentionEntity) {
        String strB = M.b(mentionEntity.screenName);
        return new o(mentionEntity.getStart(), mentionEntity.getEnd(), "@" + mentionEntity.screenName, strB, strB);
    }

    static o a(SymbolEntity symbolEntity) {
        String strC = M.c(symbolEntity.text);
        return new o(symbolEntity.getStart(), symbolEntity.getEnd(), "$" + symbolEntity.text, strC, strC);
    }
}
