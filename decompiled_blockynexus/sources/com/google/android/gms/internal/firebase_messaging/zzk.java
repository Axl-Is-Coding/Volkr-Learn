package com.google.android.gms.internal.firebase_messaging;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class zzk {
    private static final Logger logger = Logger.getLogger(zzk.class.getName());

    private zzk() {
    }

    public static void zza(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                try {
                    logger.logp(Level.WARNING, "com.google.common.io.Closeables", "close", "IOException thrown while closing Closeable.", (Throwable) e2);
                } catch (IOException e3) {
                    throw new AssertionError(e3);
                }
            }
        }
    }
}
