package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface ISolveServerHostsCallBack extends IInterface {

    public static class Default implements ISolveServerHostsCallBack {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.ISolveServerHostsCallBack
        public void onFailed(int i) throws RemoteException {
        }

        @Override // io.rong.imlib.ISolveServerHostsCallBack
        public void onSuccess(List<String> list) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISolveServerHostsCallBack {
        private static final String DESCRIPTOR = "io.rong.imlib.ISolveServerHostsCallBack";
        static final int TRANSACTION_onFailed = 2;
        static final int TRANSACTION_onSuccess = 1;

        private static class Proxy implements ISolveServerHostsCallBack {
            public static ISolveServerHostsCallBack sDefaultImpl;
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

            @Override // io.rong.imlib.ISolveServerHostsCallBack
            public void onFailed(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onFailed(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.ISolveServerHostsCallBack
            public void onSuccess(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSuccess(list);
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

        public static ISolveServerHostsCallBack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISolveServerHostsCallBack)) ? new Proxy(iBinder) : (ISolveServerHostsCallBack) iInterfaceQueryLocalInterface;
        }

        public static ISolveServerHostsCallBack getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISolveServerHostsCallBack iSolveServerHostsCallBack) {
            if (Proxy.sDefaultImpl != null || iSolveServerHostsCallBack == null) {
                return false;
            }
            Proxy.sDefaultImpl = iSolveServerHostsCallBack;
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
                onSuccess(parcel.createStringArrayList());
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
            onFailed(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onFailed(int i) throws RemoteException;

    void onSuccess(List<String> list) throws RemoteException;
}
