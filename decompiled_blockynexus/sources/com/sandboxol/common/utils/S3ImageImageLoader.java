package com.sandboxol.common.utils;

import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.a.v;
import com.bumptech.glide.load.a.y;
import com.bumptech.glide.load.l;
import com.sandboxol.common.entity.S3Image;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class S3ImageImageLoader implements u<S3Image, InputStream> {

    public static class Factory implements v<S3Image, InputStream> {
        @Override // com.bumptech.glide.load.a.v
        public u<S3Image, InputStream> build(y yVar) {
            return new S3ImageImageLoader();
        }

        public void teardown() {
        }
    }

    @Override // com.bumptech.glide.load.a.u
    public u.a<InputStream> buildLoadData(S3Image s3Image, int i, int i2, l lVar) {
        return null;
    }

    @Override // com.bumptech.glide.load.a.u
    public boolean handles(S3Image s3Image) {
        return true;
    }
}
