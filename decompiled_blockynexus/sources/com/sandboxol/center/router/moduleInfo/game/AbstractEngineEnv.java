package com.sandboxol.center.router.moduleInfo.game;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.getkeepsafe.relinker.b;
import com.sandboxol.clothes.EchoesHandler;
import com.sandboxol.common.base.app.BaseApplication;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractEngineEnv {
    private long engineVersion;

    public AbstractEngineEnv() {
        initCurrentEngineVersion();
    }

    private void initCurrentEngineVersion() {
        this.engineVersion = 0L;
        try {
            InputStream inputStreamOpen = BaseApplication.getApp().getAssets().open(getResAssertName() + "/Media/engineVersion.json");
            inputStreamOpen.read(new byte[inputStreamOpen.available()]);
            inputStreamOpen.close();
            this.engineVersion = Integer.parseInt(((JSONObject) new JSONTokener(new String(r1, "UTF-8")).nextValue()).getString("engineVersion"));
        } catch (Exception e2) {
            Log.w("blockman", "getEngineVersion failed  " + e2.getMessage());
        }
    }

    public String getConfigPath() {
        return getSDCardPath() + "/config/";
    }

    public long getEngineVersion() {
        return this.engineVersion;
    }

    public String getMapRootPath() {
        return getSDCardPath() + "/map/";
    }

    public String getMapTempRootPath() {
        return getSDCardPath() + "/map_temp/";
    }

    abstract String getNameSuffix();

    public String getResAssertName() {
        return EchoesHandler.ASSETS_NAME + getNameSuffix();
    }

    public String getResRootPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(BaseApplication.getApp().getDir(EchoesHandler.ASSETS_NAME + getNameSuffix(), 0).getPath());
        sb.append("/");
        return sb.toString();
    }

    public String getRescachePath() {
        return BaseApplication.getApp().getDir("resourcesv2", 0).getPath() + "/";
    }

    public String getSDCardPath() {
        File dir;
        if (Environment.getExternalStorageState().equals("mounted")) {
            dir = new File(Environment.getExternalStorageDirectory(), BaseApplication.getApp().getMetaDataRootPath() + "/BlockMan" + getNameSuffix());
        } else {
            dir = BaseApplication.getApp().getDir("BlockMan" + getNameSuffix(), 0);
        }
        return dir.getPath();
    }

    public abstract int getType();

    public String getVoicePath() {
        return getSDCardPath() + "/voice/";
    }

    public void loadSO(Context context) {
        b.a(context, "c++_shared");
        b.a(context, "fmod");
        b.a(context, "tersafe2");
        b.a(context, "BlockMan" + getNameSuffix());
    }
}
