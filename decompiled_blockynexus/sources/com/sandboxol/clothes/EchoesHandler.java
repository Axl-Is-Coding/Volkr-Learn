package com.sandboxol.clothes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.messenger.Messenger;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"DefaultLocale"})
public class EchoesHandler extends Handler {
    public static final String ASSETS_NAME = "resources";
    public static final int HANDLER_GL_INIT_OK = 4;
    public static final int HANDLER_INIT_OK = 3;
    private Context mContext;
    private EchoesGLSurfaceView mGLSurfaceView;
    private int sex;

    public EchoesHandler(Context context, EchoesGLSurfaceView echoesGLSurfaceView, int i) {
        this.sex = 1;
        this.mContext = context.getApplicationContext();
        this.mGLSurfaceView = echoesGLSurfaceView;
        this.sex = i;
    }

    private String getConfigPath() {
        return getSDCardPath() + "/clothes/config/";
    }

    private String getResPath() {
        return this.mContext.getDir(ASSETS_NAME, 0).getPath() + "/";
    }

    private String getSDCardPath() {
        File dir;
        if (Environment.getExternalStorageState().equals("mounted")) {
            dir = new File(Environment.getExternalStorageDirectory(), BaseApplication.getApp().getMetaDataRootPath() + "/BlockMan");
        } else {
            dir = this.mContext.getDir("BlockMan", 0);
        }
        return dir.getPath();
    }

    private void onGLInitDone() {
        File file = new File(getConfigPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        EchoesGLSurfaceView echoesGLSurfaceView = this.mGLSurfaceView;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.initGame(getResPath(), getConfigPath(), this.mGLSurfaceView.getRenderer().getScreenWidth(), this.mGLSurfaceView.getRenderer().getScreenHeight(), this.sex);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 3) {
            Messenger.getDefault().sendNoMsg(CommonMessageToken.TOKEN_DECORATION_INIT_FINISH);
        } else {
            if (i != 4) {
                return;
            }
            onGLInitDone();
        }
    }

    public void onDestroy() {
        this.mGLSurfaceView = null;
    }
}
