package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IGetNotificationQuietHoursCallback extends IInterface {

    public static class Default implements IGetNotificationQuietHoursCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.IGetNotificationQuietHoursCallback
        public void onError(int i) throws RemoteException {
        }

        @Override // io.rong.imlib.IGetNotificationQuietHoursCallback
        public void onSuccess(String str, int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IGetNotificationQuietHoursCallback {
        private static final String DESCRIPTOR = "io.rong.imlib.IGetNotificationQuietHoursCallback";
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onSuccess = 1;

        private static class Proxy implements IGetNotificationQuietHoursCallback {
            public static IGetNotificationQuietHoursCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // io.rong.imlib.IGetNotificationQuietHoursCallback
            public void onError(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onError(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IGetNotificationQuietHoursCallback
            public void onSuccess(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSuccess(str, i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGetNotificationQuietHoursCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGetNotificationQuietHoursCallback)) ? new Proxy(iBinder) : (IGetNotificationQuietHoursCallback) iInterfaceQueryLocalInterface;
        }

        public static IGetNotificationQuietHoursCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IGetNotificationQuietHoursCallback iGetNotificationQuietHoursCallback) {
            if (Proxy.sDefaultImpl != null || iGetNotificationQuietHoursCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iGetNotificationQuietHoursCallback;
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
                onSuccess(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onError(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onError(int i) throws RemoteException;

    void onSuccess(String str, int i) throws RemoteException;
}
