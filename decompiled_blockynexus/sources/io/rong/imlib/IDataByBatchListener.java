package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface IDataByBatchListener extends IInterface {

    public static class Default implements IDataByBatchListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.IDataByBatchListener
        public void onComplete() throws RemoteException {
        }

        @Override // io.rong.imlib.IDataByBatchListener
        public void onError(int i) throws RemoteException {
        }

        @Override // io.rong.imlib.IDataByBatchListener
        public void onProgress(Map map) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDataByBatchListener {
        private static final String DESCRIPTOR = "io.rong.imlib.IDataByBatchListener";
        static final int TRANSACTION_onComplete = 2;
        static final int TRANSACTION_onError = 3;
        static final int TRANSACTION_onProgress = 1;

        private static class Proxy implements IDataByBatchListener {
            public static IDataByBatchListener sDefaultImpl;
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

            @Override // io.rong.imlib.IDataByBatchListener
            public void onComplete() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onComplete();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IDataByBatchListener
            public void onError(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onError(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IDataByBatchListener
            public void onProgress(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onProgress(map);
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

        public static IDataByBatchListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDataByBatchListener)) ? new Proxy(iBinder) : (IDataByBatchListener) iInterfaceQueryLocalInterface;
        }

        public static IDataByBatchListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDataByBatchListener iDataByBatchListener) {
            if (Proxy.sDefaultImpl != null || iDataByBatchListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDataByBatchListener;
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
                onProgress(parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onComplete();
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
            onError(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onComplete() throws RemoteException;

    void onError(int i) throws RemoteException;

    void onProgress(Map map) throws RemoteException;
}
