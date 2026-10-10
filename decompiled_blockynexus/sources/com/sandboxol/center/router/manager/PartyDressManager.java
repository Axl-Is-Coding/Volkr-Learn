package com.sandboxol.center.router.manager;

import android.content.Context;
import android.view.ViewGroup;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IPartyDressService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.greendao.entity.TeamMember;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class PartyDressManager {
    private static IPartyDressService iPartyDressService = (IPartyDressService) RouteServiceManager.provide(RouterServicePath.EventPartyDress.PARTY_DRESS_SERVICE);

    public static void addMember(TeamMember teamMember) {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.addMember(teamMember);
        }
    }

    public static void changeBackground(String str) {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.changeBackground(str);
        }
    }

    public static void changeMode(int i, int i2) {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.changeMode(i, i2);
        }
    }

    public static void changeOnGameState(String str, boolean z) {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.changeOnGameState(str, z);
        }
    }

    public static void changePartyOwner(String str) {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.changePartyOwner(str);
        }
    }

    public static void changeSex(int i) {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.changeSex(i);
        }
    }

    public static void changeSexOtherPlayer(int i, String str) {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.changeSexOtherPlayer(i, str);
        }
    }

    public static boolean isPartyDress() {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            return iPartyDressService2.getPartyDress();
        }
        return false;
    }

    public static void onCreate(Context context) {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.onCreate(context);
        }
    }

    public static void onDestroy() {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.onDestroy();
        }
    }

    public static void onPauseByGroupView(ViewGroup viewGroup) {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.onPauseByGroupView(viewGroup);
        }
    }

    public static void onResumeByViewGroup(Context context, ViewGroup viewGroup, Action0 action0) {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.onResumeByViewGroup(context, viewGroup, action0);
        }
    }

    public static void removeMember(long j, String str) {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.removeMember(j, str);
        }
    }

    public static void sendChat(String str, String str2) {
        IPartyDressService iPartyDressService2 = iPartyDressService;
        if (iPartyDressService2 != null) {
            iPartyDressService2.sendChat(str, str2);
        }
    }
}
