package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.rong.imlib.model.Conversation;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IGetConversationListWithProcessCallback extends IInterface {

    public static class Default implements IGetConversationListWithProcessCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.IGetConversationListWithProcessCallback
        public void onComplete() throws RemoteException {
        }

        @Override // io.rong.imlib.IGetConversationListWithProcessCallback
        public void onProcess(List<Conversation> list) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IGetConversationListWithProcessCallback {
        private static final String DESCRIPTOR = "io.rong.imlib.IGetConversationListWithProcessCallback";
        static final int TRANSACTION_onComplete = 2;
        static final int TRANSACTION_onProcess = 1;

        private static class Proxy implements IGetConversationListWithProcessCallback {
            public static IGetConversationListWithProcessCallback sDefaultImpl;
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

            @Override // io.rong.imlib.IGetConversationListWithProcessCallback
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

            @Override // io.rong.imlib.IGetConversationListWithProcessCallback
            public void onProcess(List<Conversation> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeTypedList(list);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onProcess(list);
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

        public static IGetConversationListWithProcessCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGetConversationListWithProcessCallback)) ? new Proxy(iBinder) : (IGetConversationListWithProcessCallback) iInterfaceQueryLocalInterface;
        }

        public static IGetConversationListWithProcessCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) {
            if (Proxy.sDefaultImpl != null || iGetConversationListWithProcessCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iGetConversationListWithProcessCallback;
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
                onProcess(parcel.createTypedArrayList(Conversation.CREATOR));
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
            onComplete();
            parcel2.writeNoException();
            return true;
        }
    }

    void onComplete() throws RemoteException;

    void onProcess(List<Conversation> list) throws RemoteException;
}
