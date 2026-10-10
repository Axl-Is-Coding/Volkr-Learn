package com.tendcloud.tenddata;

import android.content.Context;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class bj {

    /* JADX INFO: compiled from: td */
    static class a {
        private static bj instance = new bj();

        private a() {
        }
    }

    private void a(final Context context) {
        if (context == null) {
            return;
        }
        try {
            ad.f19754a.execute(new Runnable() { // from class: com.tendcloud.tenddata.bj.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (cd.a()) {
                            cd.reflectMSA(context);
                        } else if (cj.a()) {
                            cj.reflectMiUi(context);
                        } else if (ca.a(context)) {
                            ca.bindHWServiceGetOAID(context);
                        } else if (ch.a(context)) {
                            ch.bindSECServiceGetOAID(context);
                        } else if (cg.a(context)) {
                            cg.bindOPPOServiceGetOAID(context);
                        } else if (cf.a(context)) {
                            cf.bindONEPLUSServiceGetOAID(context);
                        } else if (ci.a()) {
                            ci.reflectVIVO(context);
                        } else if (bz.a(context)) {
                            bz.bindASUSServiceGetOAID(context);
                        } else if (cc.a(context)) {
                            cc.reflectMEiZU(context);
                        } else if (ck.a(context)) {
                            ck.bindZTEServiceGetOAID(context);
                        } else if (cb.a(context)) {
                            cb.bindLENOVOServiceGetOAID(context);
                        } else if (ce.a(context)) {
                            ce.reflectNUBIA(context);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private bj() {
        a(ab.g);
    }

    public static bj a() {
        return a.instance;
    }
}
