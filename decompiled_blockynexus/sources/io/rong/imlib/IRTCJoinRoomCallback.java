package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IRTCJoinRoomCallback extends IInterface {

    public static class Default implements IRTCJoinRoomCallback {
        @Override // io.rong.imlib.IRTCJoinRoomCallback
        public void OnError(int i) throws RemoteException {
        }

        @Override // io.rong.imlib.IRTCJoinRoomCallback
        public void OnSuccess(List list, String str, String str2) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IRTCJoinRoomCallback {
        private static final String DESCRIPTOR = "io.rong.imlib.IRTCJoinRoomCallback";
        static final int TRANSACTION_OnError = 2;
        static final int TRANSACTION_OnSuccess = 1;

        private static class Proxy implements IRTCJoinRoomCallback {
            public static IRTCJoinRoomCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // io.rong.imlib.IRTCJoinRoomCallback
            public void OnError(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().OnError(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IRTCJoinRoomCallback
            public void OnSuccess(List list, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeList(list);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().OnSuccess(list, str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRTCJoinRoomCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRTCJoinRoomCallback)) ? new Proxy(iBinder) : (IRTCJoinRoomCallback) iInterfaceQueryLocalInterface;
        }

        public static IRTCJoinRoomCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRTCJoinRoomCallback iRTCJoinRoomCallback) {
            if (Proxy.sDefaultImpl != null || iRTCJoinRoomCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRTCJoinRoomCallback;
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
                OnSuccess(parcel.readArrayList(getClass().getClassLoader()), parcel.readString(), parcel.readString());
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
            OnError(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void OnError(int i) throws RemoteException;

    void OnSuccess(List list, String str, String str2) throws RemoteException;
}
