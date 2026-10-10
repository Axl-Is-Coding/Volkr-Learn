package com.google.android.ads.mediationtestsuite.utils;

import com.google.android.ads.mediationtestsuite.dataobjects.AdFormat;
import com.google.gson.JsonParseException;
import com.google.gson.t;
import com.google.gson.u;
import com.google.gson.v;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class AdFormatSerializer implements v<AdFormat>, com.google.gson.o<AdFormat> {
    @Override // com.google.gson.v
    public com.google.gson.p a(AdFormat adFormat, Type type, u uVar) {
        return new t(adFormat.getFormatString());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.o
    public AdFormat a(com.google.gson.p pVar, Type type, com.google.gson.n nVar) {
        String strH = pVar.h();
        AdFormat adFormatFrom = AdFormat.from(strH);
        if (adFormatFrom != null) {
            return adFormatFrom;
        }
        String strValueOf = String.valueOf(strH);
        throw new JsonParseException(strValueOf.length() != 0 ? "Can't parse ad format for key: ".concat(strValueOf) : new String("Can't parse ad format for key: "));
    }
}
