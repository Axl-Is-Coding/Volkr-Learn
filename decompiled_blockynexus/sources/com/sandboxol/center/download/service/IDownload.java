package com.sandboxol.center.download.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.sandboxol.center.download.service.IDownloadListener;
import com.sandboxol.center.download.service.IUnzipListener;
import com.sandboxol.center.download.service.IVerifyListener;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownload extends IInterface {

    public static class Default implements IDownload {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.sandboxol.center.download.service.IDownload
        public void process(int i, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) throws RemoteException {
        }

        @Override // com.sandboxol.center.download.service.IDownload
        public void processOnGame(int i, int i2, int i3, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDownload {
        private static final String DESCRIPTOR = "com.sandboxol.center.download.service.IDownload";
        static final int TRANSACTION_process = 1;
        static final int TRANSACTION_processOnGame = 2;

        private static class Proxy implements IDownload {
            public static IDownload sDefaultImpl;
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

            @Override // com.sandboxol.center.download.service.IDownload
            public void process(int i, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iDownloadListener != null ? iDownloadListener.asBinder() : null);
                    parcelObtain.writeStrongBinder(iVerifyListener != null ? iVerifyListener.asBinder() : null);
                    parcelObtain.writeStrongBinder(iUnzipListener != null ? iUnzipListener.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().process(i, str, iDownloadListener, iVerifyListener, iUnzipListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.sandboxol.center.download.service.IDownload
            public void processOnGame(int i, int i2, int i3, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iDownloadListener != null ? iDownloadListener.asBinder() : null);
                    parcelObtain.writeStrongBinder(iVerifyListener != null ? iVerifyListener.asBinder() : null);
                    parcelObtain.writeStrongBinder(iUnzipListener != null ? iUnzipListener.asBinder() : null);
                    try {
                        if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().processOnGame(i, i2, i3, str, iDownloadListener, iVerifyListener, iUnzipListener);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownload asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDownload)) ? new Proxy(iBinder) : (IDownload) iInterfaceQueryLocalInterface;
        }

        public static IDownload getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDownload iDownload) {
            if (Proxy.sDefaultImpl != null || iDownload == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDownload;
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
                process(parcel.readInt(), parcel.readString(), IDownloadListener.Stub.asInterface(parcel.readStrongBinder()), IVerifyListener.Stub.asInterface(parcel.readStrongBinder()), IUnzipListener.Stub.asInterface(parcel.readStrongBinder()));
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
            processOnGame(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), IDownloadListener.Stub.asInterface(parcel.readStrongBinder()), IVerifyListener.Stub.asInterface(parcel.readStrongBinder()), IUnzipListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    void process(int i, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) throws RemoteException;

    void processOnGame(int i, int i2, int i3, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) throws RemoteException;
}
