package com.sandboxol.greendao.b;

import android.text.TextUtils;
import com.sandboxol.greendao.entity.GameWarmUpResponse;

/* JADX INFO: compiled from: GameWarmUpResponseConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class f implements org.greenrobot.greendao.a.a<GameWarmUpResponse, String> {
    public GameWarmUpResponse a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (GameWarmUpResponse) new com.google.gson.j().a(str, GameWarmUpResponse.class);
    }

    public String a(GameWarmUpResponse gameWarmUpResponse) {
        if (gameWarmUpResponse == null) {
            return null;
        }
        return new com.google.gson.j().a(gameWarmUpResponse);
    }
}
