package com.google.android.gms.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public class MessengerCompat implements ReflectedParcelable {
    public static final Parcelable.Creator<MessengerCompat> CREATOR = new zzq();
    private Messenger zzab;
    private zzl zzby;

    public MessengerCompat(IBinder iBinder) {
        zzl zzmVar;
        if (Build.VERSION.SDK_INT >= 21) {
            this.zzab = new Messenger(iBinder);
            return;
        }
        if (iBinder == null) {
            zzmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            zzmVar = iInterfaceQueryLocalInterface instanceof zzl ? (zzl) iInterfaceQueryLocalInterface : new zzm(iBinder);
        }
        this.zzby = zzmVar;
    }

    private final IBinder getBinder() {
        Messenger messenger = this.zzab;
        return messenger != null ? messenger.getBinder() : this.zzby.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return getBinder().equals(((MessengerCompat) obj).getBinder());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public final void send(Message message) throws RemoteException {
        Messenger messenger = this.zzab;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.zzby.send(message);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.zzab;
        parcel.writeStrongBinder(messenger != null ? messenger.getBinder() : this.zzby.asBinder());
    }
}
