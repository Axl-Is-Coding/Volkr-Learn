package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.rong.imlib.model.RemoteModelWrap;

/* JADX INFO: loaded from: classes5.dex */
public interface IChatRoomHistoryMessageCallback extends IInterface {

    public static class Default implements IChatRoomHistoryMessageCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.IChatRoomHistoryMessageCallback
        public void onComplete(RemoteModelWrap remoteModelWrap, long j) throws RemoteException {
        }

        @Override // io.rong.imlib.IChatRoomHistoryMessageCallback
        public void onFailure(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IChatRoomHistoryMessageCallback {
        private static final String DESCRIPTOR = "io.rong.imlib.IChatRoomHistoryMessageCallback";
        static final int TRANSACTION_onComplete = 1;
        static final int TRANSACTION_onFailure = 2;

        private static class Proxy implements IChatRoomHistoryMessageCallback {
            public static IChatRoomHistoryMessageCallback sDefaultImpl;
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

            @Override // io.rong.imlib.IChatRoomHistoryMessageCallback
            public void onComplete(RemoteModelWrap remoteModelWrap, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (remoteModelWrap != null) {
                        parcelObtain.writeInt(1);
                        remoteModelWrap.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeLong(j);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onComplete(remoteModelWrap, j);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IChatRoomHistoryMessageCallback
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IChatRoomHistoryMessageCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IChatRoomHistoryMessageCallback)) ? new Proxy(iBinder) : (IChatRoomHistoryMessageCallback) iInterfaceQueryLocalInterface;
        }

        public static IChatRoomHistoryMessageCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IChatRoomHistoryMessageCallback iChatRoomHistoryMessageCallback) {
            if (Proxy.sDefaultImpl != null || iChatRoomHistoryMessageCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iChatRoomHistoryMessageCallback;
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
                onComplete(parcel.readInt() != 0 ? RemoteModelWrap.CREATOR.createFromParcel(parcel) : null, parcel.readLong());
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
            onFailure(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onComplete(RemoteModelWrap remoteModelWrap, long j) throws RemoteException;

    void onFailure(int i) throws RemoteException;
}
