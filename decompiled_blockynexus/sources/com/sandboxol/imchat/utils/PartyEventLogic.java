package com.sandboxol.imchat.utils;

import android.content.Context;
import com.apkfuns.logutils.c;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.tendcloud.tenddata.ab;

/* JADX INFO: loaded from: classes4.dex */
public class PartyEventLogic {
    public static void clickStartParty(Context context, GameMassage gameMassage) {
        int enterType = gameMassage.getEnterType();
        if (enterType == 1) {
            ReportDataAdapter.onEvent(context, EventConstant.CLICK_PARTY_STAR, gameMassage.getGameId());
            c.a(ab.u).b("onEvent being called! eventEvent: 游戏详情页进入派对-点击开始游戏");
        } else {
            if (enterType != 3) {
                return;
            }
            ReportDataAdapter.onEvent(context, EventConstant.LIST_BUILD_PARTY_CLICK_START, gameMassage.getGameId());
            c.a(ab.u).b("onEvent being called! eventEvent: 创建完派对-点击开始游戏");
        }
    }

    public static void enterGameSuccess(Context context, GameMassage gameMassage) {
        switch (gameMassage.getEnterType()) {
            case 1:
                ReportDataAdapter.onEvent(context, EventConstant.PARTY_START_TIME);
                c.a(ab.u).b("onEvent being called! eventEvent: 游戏详情-成功启动游戏");
                break;
            case 2:
                ReportDataAdapter.onEvent(context, EventConstant.LIST_PARTY_START_SUC, "Hall");
                c.a(ab.u).b("onEvent being called! eventEvent: 派对大厅-成功启动游戏");
                break;
            case 3:
                ReportDataAdapter.onEvent(context, EventConstant.LIST_BUILD_PARTY_START_SUC);
                c.a(ab.u).b("onEvent being called! eventEvent: 创建派对页面-成功启动游戏");
                break;
            case 4:
                ReportDataAdapter.onEvent(context, EventConstant.LIST_PARTY_START_SUC, "QuickIn");
                c.a(ab.u).b("onEvent being called! eventEvent: 快速进入派对-成功启动游戏");
                break;
        }
        ReportDataAdapter.onEvent(context, EventConstant.ALL_PARTY_START_SUC, String.valueOf(gameMassage.getEnterType()));
    }

    public static void enterPartySuccess(Context context, GameMassage gameMassage) {
        switch (gameMassage.getEnterType()) {
            case 1:
                ReportDataAdapter.onEvent(context, EventConstant.GAME_PARTY_ENTER_SUC);
                c.a(ab.u).b("onEvent being called! eventEvent: 游戏详情页-成功进入派对");
                break;
            case 2:
                ReportDataAdapter.onEvent(context, EventConstant.LIST_PARTY_ENTER_SUC, "Hall");
                c.a(ab.u).b("onEvent being called! eventEvent: 派对大厅-成功进入派对");
                break;
            case 3:
                ReportDataAdapter.onEvent(context, EventConstant.LIST_BUILD_PARTY_ENTER_SUC);
                c.a(ab.u).b("onEvent being called! eventEvent: 创建派对页面-成功进入派对");
                break;
            case 4:
                ReportDataAdapter.onEvent(context, EventConstant.LIST_PARTY_ENTER_SUC, "QuickIn");
                c.a(ab.u).b("onEvent being called! eventEvent: 快速进入派对-成功进入派对");
                break;
        }
        ReportDataAdapter.onEvent(context, EventConstant.ENTER_ALL_PARTY, String.valueOf(gameMassage.getEnterType()));
    }

    public static void reportEnterGameLogic(Context context, GameMassage gameMassage, int i) {
        int teamType = gameMassage.getTeamType();
        if (teamType == 1) {
            if (i == 0) {
                ReportDataAdapter.onEvent(context, EventConstant.PUBLIC_PARTY_START_TIME);
                c.a(ab.u).b("onEvent being called! eventEvent: 公有派对-成功启动游戏第一次");
                return;
            } else {
                if (i == 1) {
                    int i2 = i + 1;
                    ReportDataAdapter.onEvent(context, EventConstant.PUBLIC_PARTY_RESTART, String.valueOf(i2));
                    c.a(ab.u).b("onEvent being called! 公有派对-成功启动游戏第" + i2 + "次");
                    return;
                }
                return;
            }
        }
        if (teamType != 2) {
            return;
        }
        if (i == 0) {
            ReportDataAdapter.onEvent(context, EventConstant.PRIVACY_PARTY_START_TIME);
            c.a(ab.u).b("onEvent being called! eventEvent: 私有派对-成功启动游戏第一次");
        } else if (i == 1) {
            int i3 = i + 1;
            ReportDataAdapter.onEvent(context, EventConstant.PRIVACY_PARTY_RESTART, String.valueOf(i3));
            c.a(ab.u).b("onEvent being called! eventEvent: 私有派对-成功启动游戏第" + i3 + "次");
        }
    }

    public static void reportRetryPartyLogic(Context context, GameMassage gameMassage, int i) {
        int teamType = gameMassage.getTeamType();
        if (teamType == 1) {
            int i2 = i + 1;
            ReportDataAdapter.onEvent(context, EventConstant.PUBLIC_PARTY_BACK, String.valueOf(i2));
            c.a(ab.u).b("onEvent being called! eventEvent: 第" + i2 + "次回到公有派对");
            return;
        }
        if (teamType != 2) {
            return;
        }
        int i3 = i + 1;
        ReportDataAdapter.onEvent(context, EventConstant.PRIVACY_PARTY_BACK, String.valueOf(i3));
        c.a(ab.u).b("onEvent being called! eventEvent:  第" + i3 + "次回到私有派对");
    }
}
