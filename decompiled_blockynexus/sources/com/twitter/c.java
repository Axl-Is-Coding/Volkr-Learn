package com.twitter;

import com.just.agentweb.DefaultWebClient;
import com.twitter.Extractor;
import java.text.Normalizer;

/* JADX INFO: compiled from: Validator.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f20112a = 23;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f20113b = 23;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Extractor f20114c = new Extractor();

    public int a(String str) {
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFC);
        int iCodePointCount = strNormalize.codePointCount(0, strNormalize.length());
        for (Extractor.Entity entity : this.f20114c.a(strNormalize)) {
            iCodePointCount = iCodePointCount + (entity.f20098a - entity.f20099b) + (entity.f20100c.toLowerCase().startsWith(DefaultWebClient.HTTPS_SCHEME) ? this.f20113b : this.f20112a);
        }
        return iCodePointCount;
    }
}
