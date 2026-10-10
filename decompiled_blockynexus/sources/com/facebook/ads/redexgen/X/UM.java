package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import javax.inject.Singleton;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@Singleton
public final class UM extends C6P {
    public static byte[] A01;
    public static String[] A02;
    public final BatteryManager A00;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 124);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-7, 19, 18, 37, 37, 22, 35, 42, 30, 18, 31, 18, 24, 22, 35, 42, -11, -18, -1, -18, -11, 60, 81, 0, -16, -18, -7, -14};
    }

    public static void A03() {
        A02 = new String[]{"bPMdIRdGv", "GS1RiQ0Fe2OXcQcIkCuEDku7WILZ5IDY", "TsFhxeN3ooiOzKyGYimy4dCB8t9rX6Qk", "tDBwPFCmRryD0Q4apJFJlrgk6DNKamUD", "oUUA5cBoIxHqACzkd5Y2T9kUvSWODdEm", "FnX3lwsUZnwMMkDv8sp6DIbywwAIHXWj", "YZLb9o623eUfyZOuivTCDkgv5wbAGsEp", "CfH0aVj4RQl6Eoew8HOriE9Hjjy"};
    }

    public UM(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A00 = (BatteryManager) context.getSystemService(A01(1, 14, 53));
    }

    public final C6Y A0H() {
        return new UE(this);
    }

    public final C6Y A0I() {
        return new UK(this);
    }

    public final C6Y A0J() {
        HashMap map = new HashMap();
        map.put(A01(21, 1, 82), 2);
        map.put(A01(0, 1, 28), 3);
        return new UJ(this, map);
    }

    public final C6Y A0K() {
        HashMap map = new HashMap();
        map.put(A01(15, 1, 66), A01(16, 5, 13));
        map.put(A01(22, 1, 98), A01(23, 5, 17));
        return new U9(this, map);
    }

    public final C6Y A0L() {
        return new UH(this);
    }

    public final C6Y A0M() {
        return new UC(this);
    }

    public final C6Y A0N() {
        return new UF(this);
    }

    public final C6Y A0O() {
        return new UL(this);
    }

    public final C6Y A0P() {
        return new UD(this);
    }

    public final C6Y A0Q() {
        return new UA(this);
    }

    public final C6Y A0R() {
        return new UG(this);
    }

    public final C6Y A0S() {
        return new UB(this);
    }

    public final C6Y A0T() {
        return new UI(this);
    }

    public final AbstractC14046n A0U(int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return A08(EnumC14006j.A05);
        }
        BatteryManager batteryManager = this.A00;
        if (A02[4].charAt(5) != 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[3] = "Z0BpikLZimvh7GQ0e0YfQZg6u7WmYRcx";
        strArr[6] = "N2CtCcOuXuTLuGr2kU7dW0gd7w3dfDGl";
        if (batteryManager != null) {
            return A05(batteryManager.getIntProperty(i));
        }
        return A08(EnumC14006j.A07);
    }

    @SuppressLint({"Nullable Dereference"})
    public final AbstractC14046n A0V(HashMap<String, Integer> resultMap) {
        if (Build.VERSION.SDK_INT < 21) {
            return A08(EnumC14006j.A05);
        }
        BatteryManager batteryManager = this.A00;
        if (A02[4].charAt(5) != 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[3] = "VX9OpHMsf9E36khSHc5jiQggPTjCMNcl";
        strArr[6] = "9ZxqnrvyvCCPPfnmtmMIQlgDqEWsMyB8";
        if (batteryManager != null) {
            Set<String> setKeySet = resultMap.keySet();
            HashMap<String, Integer> map = new HashMap<>();
            for (String str : setKeySet) {
                map.put(str, Integer.valueOf(this.A00.getIntProperty(resultMap.get(str).intValue())));
            }
            return A0D(map);
        }
        return A08(EnumC14006j.A07);
    }
}
