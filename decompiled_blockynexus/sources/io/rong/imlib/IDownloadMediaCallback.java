package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadMediaCallback extends IInterface {

    public static class Default implements IDownloadMediaCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.IDownloadMediaCallback
        public void onComplete(String str) throws RemoteException {
        }

        @Override // io.rong.imlib.IDownloadMediaCallback
        public void onFailure(int i) throws RemoteException {
        }

        @Override // io.rong.imlib.IDownloadMediaCallback
        public void onProgress(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDownloadMediaCallback {
        private static final String DESCRIPTOR = "io.rong.imlib.IDownloadMediaCallback";
        static final int TRANSACTION_onComplete = 1;
        static final int TRANSACTION_onFailure = 2;
        static final int TRANSACTION_onProgress = 3;

        private static class Proxy implements IDownloadMediaCallback {
            public static IDownloadMediaCallback sDefaultImpl;
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

            @Override // io.rong.imlib.IDownloadMediaCallback
            public void onComplete(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onComplete(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IDownloadMediaCallback
            public void onFailure(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onFailure(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IDownloadMediaCallback
            public void onProgress(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onProgress(i);
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

        public static IDownloadMediaCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDownloadMediaCallback)) ? new Proxy(iBinder) : (IDownloadMediaCallback) iInterfaceQueryLocalInterface;
        }

        public static IDownloadMediaCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDownloadMediaCallback iDownloadMediaCallback) {
            if (Proxy.sDefaultImpl != null || iDownloadMediaCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDownloadMediaCallback;
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
                onComplete(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onFailure(parcel.readInt());
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
            onProgress(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onComplete(String str) throws RemoteException;

    void onFailure(int i) throws RemoteException;

    void onProgress(int i) throws RemoteException;
}
