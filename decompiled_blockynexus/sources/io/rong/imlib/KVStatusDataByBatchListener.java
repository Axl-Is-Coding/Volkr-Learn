package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface KVStatusDataByBatchListener extends IInterface {

    public static class Default implements KVStatusDataByBatchListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.KVStatusDataByBatchListener
        public void onCompleteDataChange(String str) throws RemoteException {
        }

        @Override // io.rong.imlib.KVStatusDataByBatchListener
        public void onCompleteDataRemove(String str) throws RemoteException {
        }

        @Override // io.rong.imlib.KVStatusDataByBatchListener
        public void onDataSync(String str) throws RemoteException {
        }

        @Override // io.rong.imlib.KVStatusDataByBatchListener
        public void onProgressDataChange(Map map) throws RemoteException {
        }

        @Override // io.rong.imlib.KVStatusDataByBatchListener
        public void onProgressDataRemove(Map map) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements KVStatusDataByBatchListener {
        private static final String DESCRIPTOR = "io.rong.imlib.KVStatusDataByBatchListener";
        static final int TRANSACTION_onCompleteDataChange = 3;
        static final int TRANSACTION_onCompleteDataRemove = 5;
        static final int TRANSACTION_onDataSync = 1;
        static final int TRANSACTION_onProgressDataChange = 2;
        static final int TRANSACTION_onProgressDataRemove = 4;

        private static class Proxy implements KVStatusDataByBatchListener {
            public static KVStatusDataByBatchListener sDefaultImpl;
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

            @Override // io.rong.imlib.KVStatusDataByBatchListener
            public void onCompleteDataChange(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onCompleteDataChange(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.KVStatusDataByBatchListener
            public void onCompleteDataRemove(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onCompleteDataRemove(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.KVStatusDataByBatchListener
            public void onDataSync(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDataSync(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.KVStatusDataByBatchListener
            public void onProgressDataChange(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onProgressDataChange(map);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.KVStatusDataByBatchListener
            public void onProgressDataRemove(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onProgressDataRemove(map);
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

        public static KVStatusDataByBatchListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof KVStatusDataByBatchListener)) ? new Proxy(iBinder) : (KVStatusDataByBatchListener) iInterfaceQueryLocalInterface;
        }

        public static KVStatusDataByBatchListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(KVStatusDataByBatchListener kVStatusDataByBatchListener) {
            if (Proxy.sDefaultImpl != null || kVStatusDataByBatchListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = kVStatusDataByBatchListener;
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
                onDataSync(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onProgressDataChange(parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onCompleteDataChange(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                onProgressDataRemove(parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onCompleteDataRemove(parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void onCompleteDataChange(String str) throws RemoteException;

    void onCompleteDataRemove(String str) throws RemoteException;

    void onDataSync(String str) throws RemoteException;

    void onProgressDataChange(Map map) throws RemoteException;

    void onProgressDataRemove(Map map) throws RemoteException;
}
