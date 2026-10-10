package com.disabngo.blockynexus.view.dialog.a;

import android.content.Context;
import com.disabngo.blockynexus.web.CampaignApi;
import com.sandboxol.center.entity.SignInReward;
import com.sandboxol.center.entity.UserSignInList;
import com.sandboxol.center.entity.UserSignInResponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ActivitySignUpModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    public void a(Context context, d dVar, UserSignInResponse userSignInResponse) {
        CampaignApi.signIn(context, new g(this, context, userSignInResponse, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<UserSignInList> list, int i, List<String> list2, List<String> list3) {
        ArrayList<SignInReward> arrayList = new ArrayList();
        for (UserSignInList userSignInList : list) {
            if (userSignInList.getSignInId() == i && userSignInList.getRewards() != null && userSignInList.getRewards().size() > 0) {
                arrayList.addAll(userSignInList.getRewards());
            }
        }
        if (arrayList.size() != 0) {
            for (SignInReward signInReward : arrayList) {
                list2.add(signInReward.getRewardPic());
                list3.add(signInReward.getRewardName());
            }
        }
    }
}
