package com.disabngo.blockynexus.view.dialog;

import android.text.TextUtils;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.dialog.ua, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EnterMiniGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class C1120ua implements com.sandboxol.greendao.a.c<GameDiskCacheInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f11688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DialogC1122va f11689b;

    C1120ua(DialogC1122va dialogC1122va, String str) {
        this.f11689b = dialogC1122va;
        this.f11688a = str;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GameDiskCacheInfo gameDiskCacheInfo) {
        GameDiskCacheInfo gameDiskCacheInfoA = com.sandboxol.greendao.c.fa.newInstance().a(this.f11689b.f11694d, gameDiskCacheInfo);
        gameDiskCacheInfoA.setLastOpenedTime(System.currentTimeMillis());
        gameDiskCacheInfoA.setIsDataChange(true);
        if (!TextUtils.isEmpty(this.f11688a)) {
            Map<String, String> mapPathName = gameDiskCacheInfoA.getMapPathName();
            if (mapPathName == null) {
                mapPathName = new HashMap<>();
                gameDiskCacheInfoA.setMapPathName(mapPathName);
            }
            String str = this.f11688a;
            mapPathName.put(str, str);
        }
        com.sandboxol.greendao.c.fa.newInstance().a(gameDiskCacheInfoA);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        GameDiskCacheInfo gameDiskCacheInfoA = com.sandboxol.greendao.c.fa.newInstance().a(this.f11689b.f11694d, (GameDiskCacheInfo) null);
        gameDiskCacheInfoA.setLastOpenedTime(System.currentTimeMillis());
        gameDiskCacheInfoA.setIsDataChange(true);
        if (!TextUtils.isEmpty(this.f11688a)) {
            Map<String, String> mapPathName = gameDiskCacheInfoA.getMapPathName();
            if (mapPathName == null) {
                mapPathName = new HashMap<>();
                gameDiskCacheInfoA.setMapPathName(mapPathName);
            }
            String str2 = this.f11688a;
            mapPathName.put(str2, str2);
        }
        com.sandboxol.greendao.c.fa.newInstance().a(gameDiskCacheInfoA);
    }
}
