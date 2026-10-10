package com.sandboxol.greendao.b;

import android.text.TextUtils;
import com.sandboxol.greendao.entity.GamePayInfo;

/* JADX INFO: compiled from: GamePayInfoConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements org.greenrobot.greendao.a.a<GamePayInfo, String> {
    public GamePayInfo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (GamePayInfo) new com.google.gson.j().a(str, GamePayInfo.class);
    }

    public String a(GamePayInfo gamePayInfo) {
        if (gamePayInfo == null) {
            return null;
        }
        return new com.google.gson.j().a(gamePayInfo);
    }
}
