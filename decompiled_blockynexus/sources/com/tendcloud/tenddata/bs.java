package com.tendcloud.tenddata;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
final class bs extends PhoneStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final long f19882a = 180000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f19885d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f19883b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f19884c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f19886e = 0;

    bs() {
    }

    private void a() {
        try {
            bm.f19863a.post(new Runnable() { // from class: com.tendcloud.tenddata.bs.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        bs.this.f19883b = System.currentTimeMillis();
                        if (bs.this.f19885d == bs.this.f19886e || bs.this.f19885d <= 1 || bs.this.f19883b - bs.this.f19884c <= bs.f19882a) {
                            return;
                        }
                        bx bxVar = new bx();
                        bxVar.f19906b = "env";
                        bxVar.f19907c = "cellUpdate";
                        bxVar.f19905a = a.ENV;
                        ag.a().post(bxVar);
                        bs.this.f19884c = bs.this.f19883b;
                        bs.this.f19886e = bs.this.f19885d;
                    } catch (Throwable th) {
                        bp.postSDKError(th);
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onCellLocationChanged(CellLocation cellLocation) {
        try {
            if (cellLocation.getClass().equals(GsmCellLocation.class)) {
                this.f19885d = ((GsmCellLocation) cellLocation).getLac();
                a();
            } else if (cellLocation.getClass().equals(CdmaCellLocation.class)) {
                this.f19885d = ((CdmaCellLocation) cellLocation).getNetworkId();
                a();
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }
}
