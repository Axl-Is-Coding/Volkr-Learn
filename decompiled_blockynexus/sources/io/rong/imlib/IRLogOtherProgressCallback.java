package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IRLogOtherProgressCallback extends IInterface {

    public static class Default implements IRLogOtherProgressCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.IRLogOtherProgressCallback
        public void setLogLevel(int i) throws RemoteException {
        }

        @Override // io.rong.imlib.IRLogOtherProgressCallback
        public void uploadRLog() throws RemoteException {
        }

        @Override // io.rong.imlib.IRLogOtherProgressCallback
        public void write(String str, int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRLogOtherProgressCallback {
        private static final String DESCRIPTOR = "io.rong.imlib.IRLogOtherProgressCallback";
        static final int TRANSACTION_setLogLevel = 2;
        static final int TRANSACTION_uploadRLog = 3;
        static final int TRANSACTION_write = 1;

        private static class Proxy implements IRLogOtherProgressCallback {
            public static IRLogOtherProgressCallback sDefaultImpl;
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

            @Override // io.rong.imlib.IRLogOtherProgressCallback
            public void setLogLevel(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setLogLevel(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IRLogOtherProgressCallback
            public void uploadRLog() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().uploadRLog();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IRLogOtherProgressCallback
            public void write(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().write(str, i);
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

        public static IRLogOtherProgressCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRLogOtherProgressCallback)) ? new Proxy(iBinder) : (IRLogOtherProgressCallback) iInterfaceQueryLocalInterface;
        }

        public static IRLogOtherProgressCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRLogOtherProgressCallback iRLogOtherProgressCallback) {
            if (Proxy.sDefaultImpl != null || iRLogOtherProgressCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRLogOtherProgressCallback;
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
                write(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                setLogLevel(parcel.readInt());
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
            uploadRLog();
            parcel2.writeNoException();
            return true;
        }
    }

    void setLogLevel(int i) throws RemoteException;

    void uploadRLog() throws RemoteException;

    void write(String str, int i) throws RemoteException;
}
