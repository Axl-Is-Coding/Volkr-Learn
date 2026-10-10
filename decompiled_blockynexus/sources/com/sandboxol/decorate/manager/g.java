package com.sandboxol.decorate.manager;

import android.text.TextUtils;
import android.util.Log;
import androidx.databinding.ObservableMap;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.game.GameMessageToken;
import com.sandboxol.clothes.EchoesGLSurfaceView;
import com.sandboxol.common.messenger.Messenger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: ClotheHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static void a() {
        v.a().f17213b.put(2L, StringConstant.CUSTOM_HAIR_1);
        v.a().f17213b.put(12L, StringConstant.CUSTOM_GLASSES_0);
        v.a().f17213b.put(4L, StringConstant.CUSTOM_FACE_1);
        v.a().f17213b.put(5L, StringConstant.CUSTOM_IDLE_0);
        v.a().f17213b.put(6L, StringConstant.CUSTOM_SKIN_0);
        v.a().f17213b.put(7L, StringConstant.CUSTOM_BG_0);
        v.a().f17213b.put(8L, StringConstant.CLOTHES_TOPS_1);
        v.a().f17213b.put(9L, StringConstant.CLOTHES_PANTS_1);
        v.a().f17213b.put(10L, StringConstant.CUSTOM_SHOES_1);
        v.a().f17213b.put(11L, StringConstant.CUSTOM_HAT_0);
        v.a().f17213b.put(13L, StringConstant.CUSTOM_SCARF_0);
        v.a().f17213b.put(14L, StringConstant.CUSTOM_WING_0);
        v.a().f17213b.put(15L, StringConstant.CUSTOM_CROWN_0);
        v.a().f17213b.put(16L, StringConstant.CUSTOM_SUITS_0);
        v.a().f17214c.clear();
        n.b().a();
        v.a().f17216e.clear();
        v.a().g.clear();
        v.a().f17215d.clear();
    }

    public static void b() {
        v.e();
        n.g();
        l.d().a();
        Iterator<Long> it = v.b().f17213b.keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            a(v.b().f17213b.get(Long.valueOf(jLongValue)));
            Messenger.getDefault().send(v.a().c(jLongValue), MessageToken.TOKEN_DRESS_RADIO_GROUP_MODIFY_ITEM_URL);
            if (v.a().f17216e.get(Long.valueOf(jLongValue)) != null && n.a(v.a().f17216e.get(Long.valueOf(jLongValue)))) {
                Iterator<Long> it2 = v.a().f17216e.get(Long.valueOf(jLongValue)).getOccupyPosition().iterator();
                while (it2.hasNext()) {
                    Messenger.getDefault().send(new SingleDressInfo(it2.next().longValue(), v.a().c(jLongValue).getIconUrl()), MessageToken.TOKEN_DRESS_RADIO_GROUP_MODIFY_ITEM_URL);
                }
            }
        }
    }

    public static float b(String str) {
        return Float.parseFloat(str) / 255.0f;
    }

    public static void a(String str) {
        Messenger.getDefault().send(str, GameMessageToken.TOKEN_CHANGE_CLOTHES);
    }

    public static void a(ObservableMap<Long, String> observableMap) {
        Observable.from(observableMap.values()).observeOn(Schedulers.newThread()).subscribe(new Action1() { // from class: com.sandboxol.decorate.manager.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                g.a((String) obj);
            }
        });
    }

    public static void a(List<SingleDressInfo> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(16L);
        arrayList.add(8L);
        arrayList.add(9L);
        arrayList.add(10L);
        arrayList.add(2L);
        arrayList.add(4L);
        arrayList.add(11L);
        arrayList.add(12L);
        arrayList.add(13L);
        arrayList.add(14L);
        arrayList.add(15L);
        arrayList.add(5L);
        arrayList.add(6L);
        arrayList.add(7L);
        if (list != null && !list.isEmpty()) {
            for (SingleDressInfo singleDressInfo : list) {
                Messenger.getDefault().send(singleDressInfo, MessageToken.TOKEN_DRESS_RADIO_GROUP_MODIFY_ITEM_URL);
                if (n.a(singleDressInfo)) {
                    Iterator<Long> it = singleDressInfo.getOccupyPosition().iterator();
                    while (it.hasNext()) {
                        long jLongValue = it.next().longValue();
                        Messenger.getDefault().send(new SingleDressInfo(jLongValue, singleDressInfo.getIconUrl()), MessageToken.TOKEN_DRESS_RADIO_GROUP_MODIFY_ITEM_URL);
                        arrayList.remove(Long.valueOf(jLongValue));
                    }
                }
                arrayList.remove(Long.valueOf(singleDressInfo.getTypeId()));
            }
        }
        Observable.from(arrayList).subscribe(new Action1() { // from class: com.sandboxol.decorate.manager.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                Messenger.getDefault().send(new SingleDressInfo(((Long) obj).longValue()), MessageToken.TOKEN_DRESS_RADIO_GROUP_MODIFY_ITEM_URL);
            }
        }, new Action1() { // from class: com.sandboxol.decorate.manager.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    public static void a(EchoesGLSurfaceView echoesGLSurfaceView, String str) {
        if (echoesGLSurfaceView == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length == 2) {
                if (!str.contains("idle") && !str.contains("_action")) {
                    if (str.contains("_bg")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(strArrSplit[0]);
                        String str2 = ".png";
                        if (!strArrSplit[1].equals("png")) {
                            str2 = strArrSplit[1] + ".png";
                        }
                        sb.append(str2);
                        echoesGLSurfaceView.changeBackgroundImage(sb.toString());
                        return;
                    }
                    echoesGLSurfaceView.changeParts(strArrSplit[0], strArrSplit[1]);
                    return;
                }
                echoesGLSurfaceView.changeChangeDefaultIdle(Integer.valueOf(strArrSplit[1]).intValue());
                return;
            }
            if (strArrSplit.length == 1) {
                String[] strArrSplit2 = str.split("-");
                echoesGLSurfaceView.changeSkinColor(b(strArrSplit2[0]), b(strArrSplit2[1]), b(strArrSplit2[2]), b(strArrSplit2[3]));
            }
        } catch (Exception e2) {
            Log.e("clothTypes", "clothTypes: " + e2.toString());
            e2.printStackTrace();
        }
    }
}
