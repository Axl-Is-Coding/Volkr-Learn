package c.t.m.g;

import android.annotation.SuppressLint;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class ek extends Cb {
    private List<NeighboringCellInfo> k;
    private List<ek> l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f3176a = a.f3182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3177b = 460;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3178c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3179d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3180e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3181f = 0;
    public int g = Integer.MAX_VALUE;
    public int h = Integer.MAX_VALUE;
    public boolean j = false;
    public final long i = System.currentTimeMillis();
    public List<String> m = new ArrayList();

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: TL */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3182a = new a("NONE", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f3183b = new a("GSM", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f3184c = new a("CDMA", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f3185d = new a("WCDMA", 3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f3186e = new a("LTE", 4);

        static {
            a[] aVarArr = {f3182a, f3183b, f3184c, f3185d, f3186e};
        }

        private a(String str, int i) {
        }
    }

    private ek() {
    }

    public static ek a(C0423eb c0423eb, CellLocation cellLocation, SignalStrength signalStrength) {
        if (!c0423eb.b() || cellLocation == null) {
            return null;
        }
        TelephonyManager telephonyManager = c0423eb.h;
        ek ekVar = new ek();
        try {
            if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                ekVar.f3176a = a.f3184c;
                ekVar.a(telephonyManager, a.f3184c);
                ekVar.f3178c = cdmaCellLocation.getSystemId();
                ekVar.f3179d = cdmaCellLocation.getNetworkId();
                ekVar.f3180e = cdmaCellLocation.getBaseStationId();
                ekVar.g = cdmaCellLocation.getBaseStationLatitude();
                ekVar.h = cdmaCellLocation.getBaseStationLongitude();
                if (signalStrength == null) {
                    ekVar.f3181f = -1;
                } else {
                    ekVar.f3181f = signalStrength.getCdmaDbm();
                }
            } else {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                ekVar.f3176a = a.f3183b;
                ekVar.a(telephonyManager, a.f3183b);
                ekVar.f3179d = gsmCellLocation.getLac();
                ekVar.f3180e = gsmCellLocation.getCid();
                if (signalStrength == null) {
                    ekVar.f3181f = -1;
                } else {
                    ekVar.f3181f = (signalStrength.getGsmSignalStrength() * 2) - 113;
                }
            }
        } catch (Throwable unused) {
        }
        if (ekVar.c()) {
            ekVar.j = true;
        }
        ekVar.m.add(ekVar.b());
        return ekVar;
    }

    private boolean c() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.f3176a != a.f3184c) {
            int i7 = this.f3177b;
            return (i7 < 0 || (i4 = this.f3178c) < 0 || i7 == 535 || i4 == 535 || (i5 = this.f3179d) < 0 || i5 == 65535 || i5 == 25840 || (i6 = this.f3180e) == 65535 || i6 == 268435455 || i6 == Integer.MAX_VALUE || i6 == 50594049 || i6 == 8 || i6 == 10 || i6 == 33 || i6 <= 0) ? false : true;
        }
        int i8 = this.f3177b;
        return i8 >= 0 && (i = this.f3178c) >= 0 && i8 != 535 && i != 535 && (i2 = this.f3179d) >= 0 && i2 != 65535 && (i3 = this.f3180e) != 65535 && i3 > 0;
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3177b);
        sb.append(this.f3178c);
        sb.append(this.f3179d);
        sb.append(this.f3180e);
        return sb.toString();
    }

    public final String toString() {
        return "TxCellInfo [PhoneType=" + this.f3176a + ", MCC=" + this.f3177b + ", MNC=" + this.f3178c + ", LAC=" + this.f3179d + ", CID=" + this.f3180e + ", RSSI=" + this.f3181f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
    }

    @SuppressLint({"NewApi"})
    public static ek a(C0423eb c0423eb, List<CellInfo> list) {
        if (list != null && c0423eb != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            ek ekVar = new ek();
            boolean z = true;
            for (CellInfo cellInfo : list) {
                if (cellInfo.isRegistered()) {
                    ek ekVarA = a(c0423eb, cellInfo);
                    if (ekVarA.c()) {
                        ekVar.m.add(ekVarA.b());
                        if (z) {
                            z = false;
                            ekVarA.j = true;
                            ekVar = ekVarA;
                        } else {
                            arrayList.add(ekVarA);
                        }
                    }
                }
            }
            ekVar.l = arrayList;
            return ekVar;
        }
        return new ek();
    }

    private void a(TelephonyManager telephonyManager, a aVar) {
        String networkOperator = telephonyManager.getNetworkOperator();
        int i = 0;
        int i2 = 460;
        if (networkOperator != null && networkOperator.length() >= 5) {
            try {
                int i3 = Integer.parseInt(networkOperator.substring(0, 3));
                try {
                    i = Integer.parseInt(networkOperator.substring(3, 5));
                    if (i3 == 460 && i == 3 && aVar != a.f3184c && networkOperator.length() == 11) {
                        i = Integer.parseInt(networkOperator.substring(9, 11));
                    }
                } catch (Throwable unused) {
                }
                i2 = i3;
            } catch (Throwable unused2) {
            }
        }
        if (i2 <= 0 || i < 0) {
            return;
        }
        this.f3177b = i2;
        this.f3178c = i;
    }

    public final synchronized List<NeighboringCellInfo> a() {
        if (this.k == null) {
            this.k = Collections.emptyList();
        }
        return this.k;
    }

    public final synchronized void a(List<NeighboringCellInfo> list) {
        if (list != null) {
            this.k = Collections.unmodifiableList(list);
        } else {
            this.k = Collections.emptyList();
        }
    }

    @SuppressLint({"NewApi"})
    private static ek a(C0423eb c0423eb, CellInfo cellInfo) {
        if (cellInfo == null) {
            return null;
        }
        TelephonyManager telephonyManager = c0423eb.h;
        ek ekVar = new ek();
        try {
            if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                ekVar.f3176a = a.f3184c;
                ekVar.a(telephonyManager, a.f3184c);
                ekVar.f3178c = cellIdentity.getSystemId();
                ekVar.f3179d = cellIdentity.getNetworkId();
                ekVar.f3180e = cellIdentity.getBasestationId();
                ekVar.g = cellIdentity.getLatitude();
                ekVar.h = cellIdentity.getLongitude();
                int dbm = cellInfoCdma.getCellSignalStrength().getDbm();
                if (dbm <= -110 || dbm >= -40) {
                    dbm = -88;
                }
                ekVar.f3181f = dbm;
            } else if (cellInfo instanceof CellInfoGsm) {
                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                ekVar.f3176a = a.f3183b;
                CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                ekVar.f3179d = cellIdentity2.getLac();
                ekVar.f3180e = cellIdentity2.getCid();
                ekVar.f3177b = cellIdentity2.getMcc();
                ekVar.f3178c = cellIdentity2.getMnc();
                int dbm2 = cellInfoGsm.getCellSignalStrength().getDbm();
                if (dbm2 <= -110 || dbm2 >= -40) {
                    dbm2 = -88;
                }
                ekVar.f3181f = dbm2;
            } else if (cellInfo instanceof CellInfoWcdma) {
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                ekVar.f3176a = a.f3185d;
                CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                ekVar.f3179d = cellIdentity3.getLac();
                ekVar.f3180e = cellIdentity3.getCid();
                ekVar.f3177b = cellIdentity3.getMcc();
                ekVar.f3178c = cellIdentity3.getMnc();
                int dbm3 = cellInfoWcdma.getCellSignalStrength().getDbm();
                if (dbm3 <= -110 || dbm3 >= -40) {
                    dbm3 = -88;
                }
                ekVar.f3181f = dbm3;
            } else if (cellInfo instanceof CellInfoLte) {
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                ekVar.f3176a = a.f3186e;
                CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                ekVar.f3179d = cellIdentity4.getTac();
                ekVar.f3180e = cellIdentity4.getCi();
                ekVar.f3177b = cellIdentity4.getMcc();
                ekVar.f3178c = cellIdentity4.getMnc();
                int dbm4 = cellInfoLte.getCellSignalStrength().getDbm();
                if (dbm4 <= -110 || dbm4 >= -40) {
                    dbm4 = -88;
                }
                ekVar.f3181f = dbm4;
            }
        } catch (Throwable unused) {
        }
        if (ekVar.c()) {
            ekVar.j = true;
        }
        ekVar.m.add(ekVar.b());
        return ekVar;
    }
}
