package com.sandboxol.blocky.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.google.gson.j;
import com.sandboxol.blocky.activity.StartMcActivity;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.game.EnterRealmsResult;
import com.sandboxol.center.utils.GameSharedUtils;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.CommonHelper;

/* JADX INFO: loaded from: classes.dex */
public class StartMc {
    private static StartMc instance;
    private boolean isInGame = false;

    public static StartMc newInstance() {
        if (instance == null) {
            instance = new StartMc();
        }
        return instance;
    }

    private void setInGame(boolean z) {
        this.isInGame = z;
    }

    public boolean isInGame() {
        return this.isInGame;
    }

    public void leaveGame() {
        setInGame(false);
        instance = null;
    }

    public void startGame(Context context, EnterRealmsResult enterRealmsResult, String str, String str2) {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        String strA = new j().a(enterRealmsResult);
        Intent intent = new Intent(context, (Class<?>) StartMcActivity.class);
        intent.putExtra("controllerType", ControllerType.BLOCK_MAN);
        intent.putExtra("flavor", str);
        intent.putExtra("baseUrl", str2);
        GameSharedUtils.newInstance().putStartGameInfo(strA);
        int iCheckProcessIsRunning = CommonHelper.checkProcessIsRunning(context, context.getPackageName() + ":BlockmanGo");
        if (iCheckProcessIsRunning != 0) {
            try {
                Log.e("StartMcActivity", "startGame killProcess----------------------------------------");
                ReportDataAdapter.onEvent(context, EventConstant.ENTER_GAME_KILLED);
                Process.killProcess(iCheckProcessIsRunning);
            } catch (Exception unused) {
            }
        }
        Log.e("StartMcActivity", "startGame :" + System.currentTimeMillis());
        ((Activity) context).startActivityForResult(intent, 10001);
        setInGame(true);
        Log.e("Main", "start game : end");
    }
}
