package com.sandboxol.center.download.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.sandboxol.file.entity.Progress;

/* JADX INFO: loaded from: classes3.dex */
public interface IUnzipListener extends IInterface {

    public static class Default implements IUnzipListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.sandboxol.center.download.service.IUnzipListener
        public void onComplete(Progress progress) throws RemoteException {
        }

        @Override // com.sandboxol.center.download.service.IUnzipListener
        public void onError(String str) throws RemoteException {
        }

        @Override // com.sandboxol.center.download.service.IUnzipListener
        public void onNext(Progress progress) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IUnzipListener {
        private static final String DESCRIPTOR = "com.sandboxol.center.download.service.IUnzipListener";
        static final int TRANSACTION_onComplete = 3;
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onNext = 1;

        private static class Proxy implements IUnzipListener {
            public static IUnzipListener sDefaultImpl;
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

            @Override // com.sandboxol.center.download.service.IUnzipListener
            public void onComplete(Progress progress) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (progress != null) {
                        parcelObtain.writeInt(1);
                        progress.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onComplete(progress);
                        return;
                    }
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        progress.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.sandboxol.center.download.service.IUnzipListener
            public void onError(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onError(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.sandboxol.center.download.service.IUnzipListener
            public void onNext(Progress progress) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (progress != null) {
                        parcelObtain.writeInt(1);
                        progress.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onNext(progress);
                        return;
                    }
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        progress.readFromParcel(parcelObtain2);
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

        public static IUnzipListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IUnzipListener)) ? new Proxy(iBinder) : (IUnzipListener) iInterfaceQueryLocalInterface;
        }

        public static IUnzipListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IUnzipListener iUnzipListener) {
            if (Proxy.sDefaultImpl != null || iUnzipListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iUnzipListener;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Progress progressCreateFromParcel;
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                progressCreateFromParcel = parcel.readInt() != 0 ? Progress.CREATOR.createFromParcel(parcel) : null;
                onNext(progressCreateFromParcel);
                parcel2.writeNoException();
                if (progressCreateFromParcel != null) {
                    parcel2.writeInt(1);
                    progressCreateFromParcel.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onError(parcel.readString());
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
            progressCreateFromParcel = parcel.readInt() != 0 ? Progress.CREATOR.createFromParcel(parcel) : null;
            onComplete(progressCreateFromParcel);
            parcel2.writeNoException();
            if (progressCreateFromParcel != null) {
                parcel2.writeInt(1);
                progressCreateFromParcel.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    void onComplete(Progress progress) throws RemoteException;

    void onError(String str) throws RemoteException;

    void onNext(Progress progress) throws RemoteException;
}
