package com.facebook.ads.redexgen.X;

import android.bluetooth.BluetoothDevice;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class UP implements C6Y {
    public final /* synthetic */ UR A00;

    public UP(UR ur) {
        this.A00 = ur;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() throws Exception {
        if (this.A00.A00 == null) {
            return this.A00.A08(EnumC14006j.A06);
        }
        ArrayList arrayList = new ArrayList();
        for (BluetoothDevice bluetoothDevice : this.A00.A00.getBondedDevices()) {
            arrayList.add(new UQ(bluetoothDevice));
        }
        return this.A00.A0E(arrayList);
    }
}
