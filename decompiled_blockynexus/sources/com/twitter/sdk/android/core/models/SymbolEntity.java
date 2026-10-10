package com.twitter.sdk.android.core.models;

import com.facebook.appevents.internal.ViewHierarchyConstants;

/* JADX INFO: loaded from: classes5.dex */
public class SymbolEntity extends Entity {

    @com.google.gson.a.c(ViewHierarchyConstants.TEXT_KEY)
    public final String text;

    public SymbolEntity(String str, int i, int i2) {
        super(i, i2);
        this.text = str;
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
