package com.twitter.sdk.android.core.models;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes5.dex */
public class MentionEntity extends Entity {

    @com.google.gson.a.c("id")
    public final long id;

    @com.google.gson.a.c("id_str")
    public final String idStr;

    @com.google.gson.a.c("name")
    public final String name;

    @com.google.gson.a.c(FirebaseAnalytics.Param.SCREEN_NAME)
    public final String screenName;

    public MentionEntity(long j, String str, String str2, String str3, int i, int i2) {
        super(i, i2);
        this.id = j;
        this.idStr = str;
        this.name = str2;
        this.screenName = str3;
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
