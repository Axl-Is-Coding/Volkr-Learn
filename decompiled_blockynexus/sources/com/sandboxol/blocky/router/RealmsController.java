package com.sandboxol.blocky.router;

import android.content.Context;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.sandboxol.blockmango.EchoesActivity;
import com.sandboxol.blockmango.EchoesRenderer;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.messager.MessagerClient;
import com.sandboxol.messager.a.f;
import com.tendcloud.tenddata.ab;

/* JADX INFO: loaded from: classes.dex */
public class RealmsController extends Controller {
    private static RealmsController mMe;

    private RealmsController(Context context) {
        super(context);
    }

    public static RealmsController getMe() {
        return mMe;
    }

    public static RealmsController newInstance(Context context) {
        RealmsController realmsController = mMe;
        if (realmsController == null) {
            mMe = new RealmsController(context);
        } else {
            realmsController.setContext(context);
        }
        return mMe;
    }

    private void reportFps() {
        try {
            if (this.mContext != null) {
                int fps = getFps();
                if (fps > -1) {
                    f fVar = new f();
                    fVar.b(GameConstant.GAME_PING_ID, getEnterRealmsResult().getGame().getGameId());
                    fVar.b(GameConstant.GAME_FPS, fps);
                    MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_GAME_FPS, fVar);
                }
                Log.d("reportPing", "game fps = " + fps);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void reportPing() {
        try {
            if (this.mContext != null) {
                int ping = getPing();
                if (ping > -1) {
                    f fVar = new f();
                    fVar.b(GameConstant.GAME_PING_ID, getEnterRealmsResult().getGame().getGameId());
                    fVar.b(GameConstant.GAME_PING, ping);
                    MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_GAME_PING, fVar);
                }
                Log.d("reportPing", "game ping = " + ping);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void reportRaknetPing() {
        try {
            if (this.mContext != null) {
                int raknetPing = getRaknetPing();
                if (raknetPing > -1) {
                    f fVar = new f();
                    fVar.b(GameConstant.GAME_PING_ID, getEnterRealmsResult().getGame().getGameId());
                    fVar.b(GameConstant.GAME_PING, raknetPing);
                    MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_GAME_RAKNET_PING, fVar);
                }
                Log.d("reportPing", "game ping = " + raknetPing);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setMe(RealmsController realmsController) {
        mMe = realmsController;
    }

    @Override // com.sandboxol.blocky.router.Controller
    public int getFps() {
        if (this.mContext instanceof EchoesActivity) {
            return EchoesRenderer.nativeGetFps();
        }
        return -1;
    }

    @Override // com.sandboxol.blocky.router.Controller
    public int getPing() {
        if (this.mContext instanceof EchoesActivity) {
            return EchoesRenderer.getPing();
        }
        return -1;
    }

    @Override // com.sandboxol.blocky.router.Controller
    public int getRaknetPing() {
        if (EngineEnv.getCurUseEngineTypeInGame() == 1 && (this.mContext instanceof EchoesActivity)) {
            return EchoesRenderer.nativeGetRaknetPing();
        }
        return -1;
    }

    @Override // com.sandboxol.blocky.router.Controller, android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 10089) {
            return;
        }
        reportPing();
        reportRaknetPing();
        reportFps();
        sendEmptyMessageDelayed(10089, ab.R);
    }

    @Override // com.sandboxol.blocky.router.Controller
    protected void initClient() {
        if (this.isInit) {
            return;
        }
        this.isInit = true;
        Log.d("RealmsController", "---------- initClient ----------" + Process.myPid() + " :  " + System.currentTimeMillis());
        sendEmptyMessageDelayed(10088, 0L);
        sendEmptyMessageDelayed(10089, 10000L);
    }

    @Override // com.sandboxol.blocky.router.Controller
    protected void stopClient() {
        mMe = null;
    }
}
