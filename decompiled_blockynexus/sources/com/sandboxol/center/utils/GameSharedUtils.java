package com.sandboxol.center.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: loaded from: classes3.dex */
public class GameSharedUtils {
    private static final String START_GAME_INFO = "start.game.info";
    private static GameSharedUtils instance;
    private Context context;

    private GameSharedUtils(Context context) {
        this.context = context;
    }

    public static GameSharedUtils newInstance() {
        if (instance == null) {
            instance = new GameSharedUtils(BaseApplication.getContext());
        }
        return instance;
    }

    public String getStartGameInfo() {
        return this.context.getSharedPreferences(START_GAME_INFO, 0).getString(START_GAME_INFO, null);
    }

    public boolean putStartGameInfo(String str) {
        SharedPreferences.Editor editorEdit = this.context.getSharedPreferences(START_GAME_INFO, 0).edit();
        editorEdit.putString(START_GAME_INFO, str);
        return editorEdit.commit();
    }
}
