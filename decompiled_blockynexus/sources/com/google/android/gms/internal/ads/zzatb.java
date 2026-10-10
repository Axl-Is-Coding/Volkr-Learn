package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "LargeParcelTeleporterCreator")
@SafeParcelable.Reserved({1})
public final class zzatb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatb> CREATOR = new zzatd();

    @SafeParcelable.Field(id = 2)
    private ParcelFileDescriptor zzdtv;
    private Parcelable zzdtw = null;
    private boolean zzdtx = true;

    @SafeParcelable.Constructor
    public zzatb(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.zzdtv = parcelFileDescriptor;
    }

    private static <T> ParcelFileDescriptor zzh(final byte[] bArr) {
        final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe;
        try {
            parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
        }
        try {
            zzbbz.zzeep.execute(new Runnable(autoCloseOutputStream, bArr) { // from class: com.google.android.gms.internal.ads.zzata
                private final OutputStream zzdtt;
                private final byte[] zzdtu;

                {
                    this.zzdtt = autoCloseOutputStream;
                    this.zzdtu = bArr;
                }

                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    zzatb.zza(this.zzdtt, this.zzdtu);
                }
            });
            return parcelFileDescriptorArrCreatePipe[0];
        } catch (IOException e3) {
            e = e3;
            zzbbq.zzc("Error transporting the ad response", e);
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e, "LargeParcelTeleporter.pipeData.2");
            IOUtils.closeQuietly(autoCloseOutputStream);
            return null;
        }
    }

    private final ParcelFileDescriptor zzvf() {
        if (this.zzdtv == null) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                this.zzdtw.writeToParcel(parcelObtain, 0);
                byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                this.zzdtv = zzh(bArrMarshall);
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        return this.zzdtv;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzvf();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdtv, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        if (this.zzdtx) {
            ParcelFileDescriptor parcelFileDescriptor = this.zzdtv;
            if (parcelFileDescriptor == null) {
                zzbbq.zzfc("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr, 0, bArr.length);
                    IOUtils.closeQuietly(dataInputStream);
                    Parcel parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain.unmarshall(bArr, 0, bArr.length);
                        parcelObtain.setDataPosition(0);
                        this.zzdtw = creator.createFromParcel(parcelObtain);
                        parcelObtain.recycle();
                        this.zzdtx = false;
                    } catch (Throwable th) {
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (IOException e2) {
                    zzbbq.zzc("Could not read from parcel file descriptor", e2);
                    IOUtils.closeQuietly(dataInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                IOUtils.closeQuietly(dataInputStream);
                throw th2;
            }
        }
        return (T) this.zzdtw;
    }

    static final /* synthetic */ void zza(OutputStream outputStream, byte[] bArr) throws Throwable {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                dataOutputStream = new DataOutputStream(outputStream);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
            IOUtils.closeQuietly(dataOutputStream);
        } catch (IOException e3) {
            e = e3;
            dataOutputStream2 = dataOutputStream;
            zzbbq.zzc("Error transporting the ad response", e);
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e, "LargeParcelTeleporter.pipeData.1");
            if (dataOutputStream2 == null) {
                IOUtils.closeQuietly(outputStream);
            } else {
                IOUtils.closeQuietly(dataOutputStream2);
            }
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            if (dataOutputStream2 == null) {
                IOUtils.closeQuietly(outputStream);
            } else {
                IOUtils.closeQuietly(dataOutputStream2);
            }
            throw th;
        }
    }
}
