package com.sandboxol.blockmango;

import android.content.Context;
import android.os.RecoverySystem;
import com.sandboxol.center.router.moduleInfo.game.AbstractEngineEnv;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class GameResManager {
    private static String TAG = "GameResManager";
    private Context context;
    private AbstractEngineEnv engineEnv;
    private RecoverySystem.ProgressListener listener;

    public GameResManager(Context context, AbstractEngineEnv abstractEngineEnv) {
        this.context = context;
        this.engineEnv = abstractEngineEnv;
    }

    private Map<String, String> getGameResFilesMd5Reg(String str) throws Exception {
        HashMap map = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(str);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();
                return map;
            }
            String[] strArrSplit = line.split("\\*");
            map.put(strArrSplit[1], strArrSplit[0].replace(" ", ""));
        }
    }

    private String getStringFromFile(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public /* synthetic */ void a(String str, Subscriber subscriber) {
        subscriber.onNext(Boolean.valueOf(prepareAndCheckGameRes(str)));
        subscriber.onCompleted();
    }

    public void deleteLocalRes(String str) {
        String str2 = this.engineEnv.getMapTempRootPath() + str + "/" + str + ".zip";
        String str3 = this.engineEnv.getMapTempRootPath() + str + "/version";
        new File(str2).delete();
        new File(str3).delete();
    }

    public int getResVersion(String str) {
        if (new File(this.engineEnv.getMapTempRootPath() + str, str + ".zip").exists()) {
            String stringFromFile = getStringFromFile(this.engineEnv.getMapTempRootPath() + "/" + str + "/version");
            if ("".equals(stringFromFile)) {
                return 0;
            }
            try {
                return Integer.parseInt(stringFromFile);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public void prepareAndCheckGameRes(final String str, final Action1<Boolean> action1) {
        Observable.create(new Observable.OnSubscribe() { // from class: com.sandboxol.blockmango.cb
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f16171a.a(str, (Subscriber) obj);
            }
        }).compose(com.sandboxol.greendao.a.b.a()).subscribe(new Observer<Boolean>() { // from class: com.sandboxol.blockmango.GameResManager.1
            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
            }

            @Override // rx.Observer
            public void onNext(Boolean bool) {
                action1.call(bool);
            }
        });
    }

    public void setListener(RecoverySystem.ProgressListener progressListener) {
        this.listener = progressListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x014f, code lost:
    
        android.util.Log.e("checkRes", "md5 check failure 1. path = " + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0163, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean prepareAndCheckGameRes(java.lang.String r18) {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.blockmango.GameResManager.prepareAndCheckGameRes(java.lang.String):boolean");
    }
}
