package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bumptech.glide.load.data.e;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelFileDescriptorRewinder implements e<ParcelFileDescriptor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InternalRewinder f4356a;

    private static final class InternalRewinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ParcelFileDescriptor f4357a;

        InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.f4357a = parcelFileDescriptor;
        }

        ParcelFileDescriptor rewind() throws IOException {
            try {
                Os.lseek(this.f4357a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.f4357a;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        }
    }

    public static final class a implements e.a<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.data.e.a
        public e<ParcelFileDescriptor> a(ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.data.e.a
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.f4356a = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.e
    public ParcelFileDescriptor a() throws IOException {
        return this.f4356a.rewind();
    }
}
