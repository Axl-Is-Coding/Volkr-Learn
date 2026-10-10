package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.IAccountAccessor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class AccountAccessor extends IAccountAccessor.Stub {
    @KeepForSdk
    public static Account getAccountBinderSafe(IAccountAccessor iAccountAccessor) {
        Account accountZza;
        if (iAccountAccessor != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                accountZza = iAccountAccessor.zza();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
                accountZza = null;
                Preconditions.checkNotNull(accountZza);
                return accountZza;
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } else {
            accountZza = null;
        }
        Preconditions.checkNotNull(accountZza);
        return accountZza;
    }

    public boolean equals(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zza() {
        throw new NoSuchMethodError();
    }
}
