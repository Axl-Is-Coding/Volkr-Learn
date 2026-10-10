package com.google.android.ads.mediationtestsuite.utils;

import com.google.android.ads.mediationtestsuite.dataobjects.AdUnitResponse;
import com.google.android.ads.mediationtestsuite.dataobjects.CLDResponse;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CLDResponseDeserializer implements com.google.gson.o<CLDResponse> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.o
    public CLDResponse a(com.google.gson.p pVar, Type type, com.google.gson.n nVar) {
        List<AdUnitResponse> list = (List) nVar.a(pVar.e().b("ad_unit_settings"), new f(this).getType());
        ArrayList arrayList = new ArrayList();
        for (AdUnitResponse adUnitResponse : list) {
            if (g.f12673a[adUnitResponse.getFormat().ordinal()] != 1) {
                arrayList.add(adUnitResponse);
            }
        }
        CLDResponse cLDResponse = new CLDResponse();
        cLDResponse.setAdUnitSettings(arrayList);
        return cLDResponse;
    }
}
