package com.sandboxol.center.router.moduleApi;

import android.content.Context;
import android.view.ViewGroup;
import com.sandboxol.greendao.entity.TeamMember;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public interface IPartyDressService extends IBaseService {
    void addMember(TeamMember teamMember);

    void changeBackground(String str);

    void changeMode(int i, int i2);

    void changeOnGameState(String str, boolean z);

    void changePartyOwner(String str);

    void changeSex(int i);

    void changeSexOtherPlayer(int i, String str);

    boolean getPartyDress();

    void onCreate(Context context);

    void onDestroy();

    void onPauseByGroupView(ViewGroup viewGroup);

    void onResumeByViewGroup(Context context, ViewGroup viewGroup, Action0 action0);

    void removeMember(long j, String str);

    void sendChat(String str, String str2);
}
