package com.unity3d.services.purchasing;

import com.unity3d.services.purchasing.core.IPurchasingAdapter;
import com.unity3d.services.purchasing.core.properties.ClientProperties;

/* JADX INFO: loaded from: classes5.dex */
public class UnityPurchasing {
    public static IPurchasingAdapter getAdapter() {
        return ClientProperties.getAdapter();
    }

    public static void setAdapter(IPurchasingAdapter iPurchasingAdapter) {
        ClientProperties.setAdapter(iPurchasingAdapter);
    }
}
