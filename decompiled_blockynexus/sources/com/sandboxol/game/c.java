package com.sandboxol.game;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IMcProcessChangeDataInterface.java */
/* JADX INFO: loaded from: classes3.dex */
public interface c extends IInterface {

    /* JADX INFO: compiled from: IMcProcessChangeDataInterface.java */
    public static abstract class a extends Binder implements c {
        private static final String DESCRIPTOR = "com.sandboxol.game.IMcProcessChangeDataInterface";
        static final int TRANSACTION_doHeartBeat = 3;
        static final int TRANSACTION_onDataReport = 1;
        static final int TRANSACTION_onErrorReport = 2;

        /* JADX INFO: renamed from: com.sandboxol.game.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IMcProcessChangeDataInterface.java */
        private static class C0149a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static c f17741a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f17742b;

            C0149a(IBinder iBinder) {
                this.f17742b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f17742b;
            }

            @Override // com.sandboxol.game.c
            public void doHeartBeat() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (this.f17742b.transact(3, parcelObtain, parcelObtain2, 0) || a.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.getDefaultImpl().doHeartBeat();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static c asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0149a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        public static c getDefaultImpl() {
            return C0149a.f17741a;
        }

        public static boolean setDefaultImpl(c cVar) {
            if (C0149a.f17741a != null || cVar == null) {
                return false;
            }
            C0149a.f17741a = cVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onDataReport(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onErrorReport(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            doHeartBeat();
            parcel2.writeNoException();
            return true;
        }
    }

    void doHeartBeat() throws RemoteException;

    void onDataReport(String str, String str2) throws RemoteException;

    void onErrorReport(String str) throws RemoteException;
}
