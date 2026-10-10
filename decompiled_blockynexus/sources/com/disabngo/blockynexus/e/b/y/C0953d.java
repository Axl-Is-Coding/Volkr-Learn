package com.disabngo.blockynexus.e.b.y;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.facebook.internal.ServerProtocol;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import io.rong.imlib.model.Conversation;
import java.util.Locale;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.y.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CheckGameAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0953d implements InterfaceC0961l {
    public void a(Context context, GameMassage gameMassage) {
        String str;
        String str2;
        DressManager.onPauseByGroupView();
        if (gameMassage.getMemberCount() > 4 || Build.VERSION.SDK_INT < 21) {
            str = "conversation";
            str2 = "false";
        } else {
            str = "party";
            str2 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        }
        if (AppInfoCenter.newInstance().isNowParty()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + context.getApplicationInfo().packageName).buildUpon().appendPath(str).appendPath(Conversation.ConversationType.CHATROOM.getName().toLowerCase(Locale.US)).appendQueryParameter("isTeam", String.valueOf(true)).appendQueryParameter("isPartyPage", str2).appendQueryParameter("targetId", gameMassage.getChatRoomId()).appendQueryParameter("title", gameMassage.getRoomName()).appendQueryParameter("gameMessage", new com.google.gson.j().a(gameMassage)).build());
        intent.putExtra("createIfNotExist", false);
        context.startActivity(intent);
    }
}
