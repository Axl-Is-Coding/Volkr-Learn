package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface UserProfileSettingListener extends IInterface {

    public static class Default implements UserProfileSettingListener {
        @Override // io.rong.imlib.UserProfileSettingListener
        public void OnPushNotificationChanged(long j) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements UserProfileSettingListener {
        private static final String DESCRIPTOR = "io.rong.imlib.UserProfileSettingListener";
        static final int TRANSACTION_OnPushNotificationChanged = 1;

        private static class Proxy implements UserProfileSettingListener {
            public static UserProfileSettingListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // io.rong.imlib.UserProfileSettingListener
            public void OnPushNotificationChanged(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().OnPushNotificationChanged(j);
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

        public static UserProfileSettingListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof UserProfileSettingListener)) ? new Proxy(iBinder) : (UserProfileSettingListener) iInterfaceQueryLocalInterface;
        }

        public static UserProfileSettingListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(UserProfileSettingListener userProfileSettingListener) {
            if (Proxy.sDefaultImpl != null || userProfileSettingListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = userProfileSettingListener;
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
            OnPushNotificationChanged(parcel.readLong());
            parcel2.writeNoException();
            return true;
        }
    }

    void OnPushNotificationChanged(long j) throws RemoteException;
}
