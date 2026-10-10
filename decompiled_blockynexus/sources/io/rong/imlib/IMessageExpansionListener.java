package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.rong.imlib.model.Message;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface IMessageExpansionListener extends IInterface {

    public static class Default implements IMessageExpansionListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.IMessageExpansionListener
        public void onMessageExpansionRemove(List<String> list, Message message) throws RemoteException {
        }

        @Override // io.rong.imlib.IMessageExpansionListener
        public void onMessageExpansionUpdate(Map map, Message message) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMessageExpansionListener {
        private static final String DESCRIPTOR = "io.rong.imlib.IMessageExpansionListener";
        static final int TRANSACTION_onMessageExpansionRemove = 2;
        static final int TRANSACTION_onMessageExpansionUpdate = 1;

        private static class Proxy implements IMessageExpansionListener {
            public static IMessageExpansionListener sDefaultImpl;
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

            @Override // io.rong.imlib.IMessageExpansionListener
            public void onMessageExpansionRemove(List<String> list, Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onMessageExpansionRemove(list, message);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IMessageExpansionListener
            public void onMessageExpansionUpdate(Map map, Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onMessageExpansionUpdate(map, message);
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

        public static IMessageExpansionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMessageExpansionListener)) ? new Proxy(iBinder) : (IMessageExpansionListener) iInterfaceQueryLocalInterface;
        }

        public static IMessageExpansionListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMessageExpansionListener iMessageExpansionListener) {
            if (Proxy.sDefaultImpl != null || iMessageExpansionListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMessageExpansionListener;
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
                onMessageExpansionUpdate(parcel.readHashMap(getClass().getClassLoader()), parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null);
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
            onMessageExpansionRemove(parcel.createStringArrayList(), parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onMessageExpansionRemove(List<String> list, Message message) throws RemoteException;

    void onMessageExpansionUpdate(Map map, Message message) throws RemoteException;
}
