package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.rong.imlib.model.Message;

/* JADX INFO: loaded from: classes5.dex */
public interface OnReceiveMessageListener extends IInterface {

    public static class Default implements OnReceiveMessageListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.OnReceiveMessageListener
        public boolean onReceived(Message message, int i, boolean z, boolean z2, int i2) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements OnReceiveMessageListener {
        private static final String DESCRIPTOR = "io.rong.imlib.OnReceiveMessageListener";
        static final int TRANSACTION_onReceived = 1;

        private static class Proxy implements OnReceiveMessageListener {
            public static OnReceiveMessageListener sDefaultImpl;
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

            @Override // io.rong.imlib.OnReceiveMessageListener
            public boolean onReceived(Message message, int i, boolean z, boolean z2, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onReceived(message, i, z, z2, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static OnReceiveMessageListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof OnReceiveMessageListener)) ? new Proxy(iBinder) : (OnReceiveMessageListener) iInterfaceQueryLocalInterface;
        }

        public static OnReceiveMessageListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(OnReceiveMessageListener onReceiveMessageListener) {
            if (Proxy.sDefaultImpl != null || onReceiveMessageListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = onReceiveMessageListener;
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
            boolean zOnReceived = onReceived(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeInt(zOnReceived ? 1 : 0);
            return true;
        }
    }

    boolean onReceived(Message message, int i, boolean z, boolean z2, int i2) throws RemoteException;
}
