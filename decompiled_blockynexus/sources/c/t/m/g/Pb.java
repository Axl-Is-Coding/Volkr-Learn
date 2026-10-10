package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import c.t.m.g.ek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Pb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2988a;

    @SuppressLint({"NewApi"})
    public static boolean a(Context context) {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT < 17 ? Settings.System.getInt(context.getContentResolver(), "airplane_mode_on") == 1 : Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on") == 1) {
                z = true;
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    private static boolean b(CellLocation cellLocation) {
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation.getCid() == 0) {
                return gsmCellLocation.getLac() == 0;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static List<CellInfo> c(C0423eb c0423eb) {
        try {
            List<CellInfo> allCellInfo = c0423eb.h.getAllCellInfo();
            if (allCellInfo != null) {
                return allCellInfo;
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    private static int b(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        try {
            if (a(i)) {
                return signalStrength.getGsmSignalStrength() - signalStrength2.getGsmSignalStrength();
            }
            if (b(i)) {
                return signalStrength.getCdmaDbm() - signalStrength2.getCdmaDbm();
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int a(CellLocation cellLocation) {
        if (cellLocation instanceof CdmaCellLocation) {
            return ((CdmaCellLocation) cellLocation).getBaseStationId();
        }
        try {
            return ((GsmCellLocation) cellLocation).getCid();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static boolean b(int i) {
        return i == ek.a.f3184c.ordinal();
    }

    public static List<NeighboringCellInfo> b(C0423eb c0423eb) {
        TelephonyManager telephonyManager = c0423eb.h;
        if (telephonyManager != null) {
            try {
                return telephonyManager.getNeighboringCellInfo();
            } catch (Exception unused) {
            }
        }
        return Collections.emptyList();
    }

    public static boolean a(CellLocation cellLocation, CellLocation cellLocation2) {
        if (!(cellLocation == null || cellLocation2 == null) && cellLocation.getClass() == cellLocation2.getClass()) {
            return cellLocation instanceof GsmCellLocation ? ((GsmCellLocation) cellLocation).getCid() == ((GsmCellLocation) cellLocation2).getCid() : (cellLocation instanceof CdmaCellLocation) && ((CdmaCellLocation) cellLocation).getBaseStationId() == ((CdmaCellLocation) cellLocation2).getBaseStationId();
        }
        return false;
    }

    public static boolean a(ek ekVar) {
        if (ekVar == null) {
            return false;
        }
        return a(ekVar.f3176a.ordinal(), ekVar.f3177b, ekVar.f3178c, ekVar.f3179d, ekVar.f3180e);
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5) {
        return b(i) ? i2 >= 0 && i3 >= 0 && i4 >= 0 && i4 <= 65535 && i5 > 0 && i5 <= 65535 && !(i3 == 0 && i4 == 0 && i5 == 0) : i2 >= 0 && i3 >= 0 && i4 > 0 && i4 < 65535 && i5 != 268435455 && i5 != Integer.MAX_VALUE && i5 != 50594049 && i5 != 65535 && i5 > 0 && i5 != 65535 && i5 > 0;
    }

    public static boolean a(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        if (signalStrength == null || signalStrength2 == null) {
            return true;
        }
        int iAbs = Math.abs(b(i, signalStrength, signalStrength2));
        return a(i) ? iAbs > 3 : b(i) && iAbs > 6;
    }

    private static boolean a(int i) {
        return i != ek.a.f3184c.ordinal();
    }

    public static CellLocation a(C0423eb c0423eb) {
        boolean z;
        TelephonyManager telephonyManager = c0423eb.h;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                boolean z2 = false;
                boolean z3 = telephonyManager.getSimState() == 5;
                try {
                    z = !TextUtils.isEmpty(telephonyManager.getSubscriberId());
                } catch (Exception unused) {
                    z = true;
                }
                if (z3 && z) {
                    if ((cellLocation == null || b(cellLocation) || a(cellLocation) < 0) && !a(c0423eb.f3147c)) {
                        z2 = true;
                    }
                    f2988a = z2;
                }
                return cellLocation;
            } catch (Exception unused2) {
                f2988a = true;
            }
        }
        return CellLocation.getEmpty();
    }
}
