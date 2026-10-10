package com.tendcloud.tenddata;

import android.content.Context;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class cd {
    public static boolean a() {
        try {
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void reflectMSA(Context context) {
        try {
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper").getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, IIdentifierListener.class).invoke(null, context, true, new IIdentifierListener() { // from class: com.tendcloud.tenddata.cd.1
                public void OnSupport(boolean z, IdSupplier idSupplier) {
                    try {
                        if (idSupplier != null) {
                            try {
                                de.b().setOAID(idSupplier.getOAID());
                            } catch (Throwable unused) {
                            }
                            try {
                                String vaid = idSupplier.getVAID();
                                de deVarB = de.b();
                                if (af.b(vaid)) {
                                    vaid = null;
                                }
                                deVarB.setVAID(vaid);
                            } catch (Throwable unused2) {
                            }
                            String aaid = idSupplier.getAAID();
                            de.b().setAAID(af.b(aaid) ? null : aaid);
                        } else {
                            m.eForInternal("requestMsaIds idSupplier: is " + idSupplier);
                        }
                    } catch (Throwable unused3) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
