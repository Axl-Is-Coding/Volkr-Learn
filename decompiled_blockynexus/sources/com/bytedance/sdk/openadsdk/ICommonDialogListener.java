package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface ICommonDialogListener extends IInterface {

    public static abstract class Stub extends Binder implements ICommonDialogListener {

        private static class a implements ICommonDialogListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f5589a;

            a(IBinder iBinder) {
                this.f5589a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5589a;
            }

            @Override // com.bytedance.sdk.openadsdk.ICommonDialogListener
            public void onDialogBtnNo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ICommonDialogListener");
                    this.f5589a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ICommonDialogListener
            public void onDialogBtnYes() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ICommonDialogListener");
                    this.f5589a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ICommonDialogListener
            public void onDialogCancel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ICommonDialogListener");
                    this.f5589a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.ICommonDialogListener");
        }

        public static ICommonDialogListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.ICommonDialogListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICommonDialogListener)) ? new a(iBinder) : (ICommonDialogListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.ICommonDialogListener");
                onDialogBtnYes();
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.ICommonDialogListener");
                onDialogBtnNo();
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.ICommonDialogListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.ICommonDialogListener");
            onDialogCancel();
            parcel2.writeNoException();
            return true;
        }
    }

    void onDialogBtnNo() throws RemoteException;

    void onDialogBtnYes() throws RemoteException;

    void onDialogCancel() throws RemoteException;
}
