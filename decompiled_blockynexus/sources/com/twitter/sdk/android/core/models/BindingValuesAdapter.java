package com.twitter.sdk.android.core.models;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonParseException;
import com.google.gson.r;
import com.google.gson.u;
import com.google.gson.v;
import com.sandboxol.greendao.entity.UserDao;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class BindingValuesAdapter implements v<c>, com.google.gson.o<c> {
    @Override // com.google.gson.v
    public com.google.gson.p a(c cVar, Type type, u uVar) {
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.o
    public c a(com.google.gson.p pVar, Type type, com.google.gson.n nVar) throws JsonParseException {
        if (!pVar.k()) {
            return new c();
        }
        Set<Map.Entry<String, com.google.gson.p>> setEntrySet = pVar.e().entrySet();
        HashMap map = new HashMap(32);
        for (Map.Entry<String, com.google.gson.p> entry : setEntrySet) {
            map.put(entry.getKey(), a(entry.getValue().e(), nVar));
        }
        return new c(map);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    Object a(r rVar, com.google.gson.n nVar) {
        com.google.gson.p pVarA = rVar.a("type");
        if (pVarA == null || !pVarA.l()) {
            return null;
        }
        String strH = pVarA.h();
        byte b2 = -1;
        switch (strH.hashCode()) {
            case -1838656495:
                if (strH.equals(com.tendcloud.tenddata.a.MF_STRING)) {
                    b2 = 0;
                }
                break;
            case 2614219:
                if (strH.equals(UserDao.TABLENAME)) {
                    b2 = 2;
                }
                break;
            case 69775675:
                if (strH.equals(ShareConstants.IMAGE_URL)) {
                    b2 = 1;
                }
                break;
            case 782694408:
                if (strH.equals("BOOLEAN")) {
                    b2 = 3;
                }
                break;
        }
        if (b2 == 0) {
            return nVar.a(rVar.a("string_value"), String.class);
        }
        if (b2 == 1) {
            return nVar.a(rVar.a("image_value"), g.class);
        }
        if (b2 == 2) {
            return nVar.a(rVar.a("user_value"), q.class);
        }
        if (b2 != 3) {
            return null;
        }
        return nVar.a(rVar.a("boolean_value"), Boolean.class);
    }
}
