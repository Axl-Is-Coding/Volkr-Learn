package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IRealTimeLocationListener extends IInterface {

    public static class Default implements IRealTimeLocationListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.IRealTimeLocationListener
        public void onError(int i) throws RemoteException {
        }

        @Override // io.rong.imlib.IRealTimeLocationListener
        public void onParticipantsJoin(String str) throws RemoteException {
        }

        @Override // io.rong.imlib.IRealTimeLocationListener
        public void onParticipantsQuit(String str) throws RemoteException {
        }

        @Override // io.rong.imlib.IRealTimeLocationListener
        public void onReceiveLocation(double d2, double d3, String str) throws RemoteException {
        }

        @Override // io.rong.imlib.IRealTimeLocationListener
        public void onStatusChange(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRealTimeLocationListener {
        private static final String DESCRIPTOR = "io.rong.imlib.IRealTimeLocationListener";
        static final int TRANSACTION_onError = 5;
        static final int TRANSACTION_onParticipantsJoin = 3;
        static final int TRANSACTION_onParticipantsQuit = 4;
        static final int TRANSACTION_onReceiveLocation = 2;
        static final int TRANSACTION_onStatusChange = 1;

        private static class Proxy implements IRealTimeLocationListener {
            public static IRealTimeLocationListener sDefaultImpl;
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

            @Override // io.rong.imlib.IRealTimeLocationListener
            public void onError(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onError(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IRealTimeLocationListener
            public void onParticipantsJoin(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onParticipantsJoin(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IRealTimeLocationListener
            public void onParticipantsQuit(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onParticipantsQuit(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IRealTimeLocationListener
            public void onReceiveLocation(double d2, double d3, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeDouble(d2);
                    parcelObtain.writeDouble(d3);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onReceiveLocation(d2, d3, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IRealTimeLocationListener
            public void onStatusChange(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onStatusChange(i);
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

        public static IRealTimeLocationListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRealTimeLocationListener)) ? new Proxy(iBinder) : (IRealTimeLocationListener) iInterfaceQueryLocalInterface;
        }

        public static IRealTimeLocationListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRealTimeLocationListener iRealTimeLocationListener) {
            if (Proxy.sDefaultImpl != null || iRealTimeLocationListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRealTimeLocationListener;
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
                onStatusChange(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onReceiveLocation(parcel.readDouble(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onParticipantsJoin(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                onParticipantsQuit(parcel.readString());
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
            onError(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onError(int i) throws RemoteException;

    void onParticipantsJoin(String str) throws RemoteException;

    void onParticipantsQuit(String str) throws RemoteException;

    void onReceiveLocation(double d2, double d3, String str) throws RemoteException;

    void onStatusChange(int i) throws RemoteException;
}
