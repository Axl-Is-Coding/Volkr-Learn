package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.rong.imlib.model.RemoteModelWrap;

/* JADX INFO: loaded from: classes5.dex */
public interface OnGetHistoryMessagesCallback extends IInterface {

    public static class Default implements OnGetHistoryMessagesCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.OnGetHistoryMessagesCallback
        public void onComplete(RemoteModelWrap remoteModelWrap) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements OnGetHistoryMessagesCallback {
        private static final String DESCRIPTOR = "io.rong.imlib.OnGetHistoryMessagesCallback";
        static final int TRANSACTION_onComplete = 1;

        private static class Proxy implements OnGetHistoryMessagesCallback {
            public static OnGetHistoryMessagesCallback sDefaultImpl;
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

            @Override // io.rong.imlib.OnGetHistoryMessagesCallback
            public void onComplete(RemoteModelWrap remoteModelWrap) throws RemoteException {
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
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onComplete(remoteModelWrap);
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

        public static OnGetHistoryMessagesCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof OnGetHistoryMessagesCallback)) ? new Proxy(iBinder) : (OnGetHistoryMessagesCallback) iInterfaceQueryLocalInterface;
        }

        public static OnGetHistoryMessagesCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(OnGetHistoryMessagesCallback onGetHistoryMessagesCallback) {
            if (Proxy.sDefaultImpl != null || onGetHistoryMessagesCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = onGetHistoryMessagesCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onComplete(parcel.readInt() != 0 ? RemoteModelWrap.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onComplete(RemoteModelWrap remoteModelWrap) throws RemoteException;
}
