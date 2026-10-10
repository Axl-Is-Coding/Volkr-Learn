package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.rong.imlib.model.ConversationStatus;

/* JADX INFO: loaded from: classes5.dex */
public interface ConversationStatusListener extends IInterface {

    public static class Default implements ConversationStatusListener {
        @Override // io.rong.imlib.ConversationStatusListener
        public void OnStatusChanged(ConversationStatus[] conversationStatusArr) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ConversationStatusListener {
        private static final String DESCRIPTOR = "io.rong.imlib.ConversationStatusListener";
        static final int TRANSACTION_OnStatusChanged = 1;

        private static class Proxy implements ConversationStatusListener {
            public static ConversationStatusListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // io.rong.imlib.ConversationStatusListener
            public void OnStatusChanged(ConversationStatus[] conversationStatusArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeTypedArray(conversationStatusArr, 0);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().OnStatusChanged(conversationStatusArr);
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

        public static ConversationStatusListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ConversationStatusListener)) ? new Proxy(iBinder) : (ConversationStatusListener) iInterfaceQueryLocalInterface;
        }

        public static ConversationStatusListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ConversationStatusListener conversationStatusListener) {
            if (Proxy.sDefaultImpl != null || conversationStatusListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = conversationStatusListener;
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
            OnStatusChanged((ConversationStatus[]) parcel.createTypedArray(ConversationStatus.CREATOR));
            parcel2.writeNoException();
            return true;
        }
    }

    void OnStatusChanged(ConversationStatus[] conversationStatusArr) throws RemoteException;
}
