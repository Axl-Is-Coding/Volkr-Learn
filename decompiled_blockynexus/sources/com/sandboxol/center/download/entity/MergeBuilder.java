package com.sandboxol.center.download.entity;

import com.sandboxol.file.b.a;
import com.sandboxol.file.b.b;
import com.sandboxol.file.b.c;

/* JADX INFO: loaded from: classes3.dex */
public class MergeBuilder {
    private a downloadBuilder;
    private boolean isSilent;
    private GameReqParam reqParam;
    private b unzipBuilder;
    private c verifyBuilder;

    public a getDownloadBuilder() {
        return this.downloadBuilder;
    }

    public GameReqParam getReqParam() {
        return this.reqParam;
    }

    public b getUnzipBuilder() {
        return this.unzipBuilder;
    }

    public c getVerifyBuilder() {
        return this.verifyBuilder;
    }

    public boolean isSilent() {
        return this.isSilent;
    }

    public MergeBuilder setDownloadBuilder(a aVar) {
        this.downloadBuilder = aVar;
        return this;
    }

    public MergeBuilder setReqParam(GameReqParam gameReqParam) {
        this.reqParam = gameReqParam;
        return this;
    }

    public MergeBuilder setSilent(boolean z) {
        this.isSilent = z;
        return this;
    }

    public MergeBuilder setUnzipBuilder(b bVar) {
        this.unzipBuilder = bVar;
        return this;
    }

    public MergeBuilder setVerifyBuilder(c cVar) {
        this.verifyBuilder = cVar;
        return this;
    }
}
