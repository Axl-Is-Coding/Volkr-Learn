package com.facebook.ads.redexgen.X;

import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class VI implements C6Y {
    public final /* synthetic */ VK A00;

    public VI(VK vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() throws Exception {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        HashMap map = new HashMap();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
            map.put(networkInterfaceNextElement.getDisplayName(), new VJ(networkInterfaceNextElement.getInetAddresses(), null));
        }
        return this.A00.A02(map);
    }
}
