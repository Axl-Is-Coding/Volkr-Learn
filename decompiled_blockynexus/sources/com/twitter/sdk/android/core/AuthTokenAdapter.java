package com.twitter.sdk.android.core;

import com.facebook.internal.ServerProtocol;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class AuthTokenAdapter implements com.google.gson.v<b>, com.google.gson.o<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Map<String, Class<? extends b>> f20115a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.j f20116b = new com.google.gson.j();

    static {
        f20115a.put("oauth1a", s.class);
        f20115a.put("oauth2", com.twitter.sdk.android.core.internal.oauth.j.class);
        f20115a.put("guest", com.twitter.sdk.android.core.internal.oauth.b.class);
    }

    @Override // com.google.gson.v
    public com.google.gson.p a(b bVar, Type type, com.google.gson.u uVar) {
        com.google.gson.r rVar = new com.google.gson.r();
        rVar.a(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, a(bVar.getClass()));
        rVar.a("auth_token", this.f20116b.b(bVar));
        return rVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.o
    public b a(com.google.gson.p pVar, Type type, com.google.gson.n nVar) throws JsonParseException {
        com.google.gson.r rVarE = pVar.e();
        String strH = rVarE.c(ServerProtocol.DIALOG_PARAM_AUTH_TYPE).h();
        return (b) this.f20116b.a(rVarE.a("auth_token"), (Class) f20115a.get(strH));
    }

    static String a(Class<? extends b> cls) {
        for (Map.Entry<String, Class<? extends b>> entry : f20115a.entrySet()) {
            if (entry.getValue().equals(cls)) {
                return entry.getKey();
            }
        }
        return "";
    }
}
