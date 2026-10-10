package com.bumptech.glide.load.a;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.bumptech.glide.load.a.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ByteBufferEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class C0490e implements com.bumptech.glide.load.a<ByteBuffer> {
    @Override // com.bumptech.glide.load.a
    public boolean a(ByteBuffer byteBuffer, File file, com.bumptech.glide.load.l lVar) throws Throwable {
        try {
            com.bumptech.glide.e.a.a(byteBuffer, file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e2);
            }
            return false;
        }
    }
}
