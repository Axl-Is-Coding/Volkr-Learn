package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-base@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzgu implements IInterface {
    private final IBinder zzacj;
    private final String zzack;

    protected zzgu(IBinder iBinder, String str) {
        this.zzacj = iBinder;
        this.zzack = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zzacj;
    }

    protected final Parcel obtainAndWriteInterfaceToken() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.zzack);
        return parcelObtain;
    }

    protected final Parcel transactAndReadException(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.zzacj.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e2) {
                parcelObtain.recycle();
                throw e2;
            }
        } finally {
            parcel.recycle();
        }
    }

    protected final void zza(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.zzacj.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    protected final void zzb(int i, Parcel parcel) throws RemoteException {
        try {
            this.zzacj.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
