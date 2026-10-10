package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.imchat.server.network.async.AsyncTaskManager;
import com.umeng.analytics.pro.au;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdInfoFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static com.bytedance.sdk.openadsdk.core.d.a a(JSONObject jSONObject, AdSlot adSlot) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.d.a aVar = new com.bytedance.sdk.openadsdk.core.d.a();
            aVar.a(jSONObject.optString("request_id"));
            aVar.a(jSONObject.optInt("ret"));
            aVar.b(jSONObject.optString("message"));
            String strOptString = jSONObject.optString("auction_price");
            if (aVar.b() != 0) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    com.bytedance.sdk.openadsdk.core.d.h hVarB = b(jSONArrayOptJSONArray.optJSONObject(i), adSlot);
                    if (hVarB != null && a(hVarB)) {
                        hVarB.b(strOptString);
                        aVar.a(hVarB);
                    }
                }
            }
            return aVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static com.bytedance.sdk.openadsdk.core.d.h b(JSONObject jSONObject, AdSlot adSlot) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.h hVar = new com.bytedance.sdk.openadsdk.core.d.h();
        hVar.l(jSONObject.optInt("interaction_type"));
        hVar.d(jSONObject.optString("target_url"));
        hVar.i(jSONObject.optString("ad_id"));
        hVar.c(jSONObject.optString("source"));
        hVar.o(jSONObject.optInt("dislike_control", 0));
        hVar.h(jSONObject.optInt("play_bar_show_time", AsyncTaskManager.HTTP_ERROR_CODE));
        hVar.a(jSONObject.optBoolean("is_playable"));
        hVar.b(jSONObject.optInt("playable_type", 0));
        hVar.a(jSONObject.optString("playable_style"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("icon");
        hVar.b(jSONObject.optBoolean("screenshot", false));
        hVar.f(jSONObject.optInt("play_bar_style", 0));
        hVar.k(jSONObject.optString("market_url", ""));
        hVar.d(jSONObject.optInt("video_adaptation", 0));
        hVar.c(jSONObject.optInt("feed_video_opentype", 0));
        hVar.a(jSONObject.optJSONObject("session_params"));
        hVar.b(jSONObject.optString("auction_price", ""));
        if (jSONObjectOptJSONObject != null) {
            com.bytedance.sdk.openadsdk.core.d.g gVar = new com.bytedance.sdk.openadsdk.core.d.g();
            gVar.a(jSONObjectOptJSONObject.optString("url"));
            gVar.b(jSONObjectOptJSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
            gVar.a(jSONObjectOptJSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
            hVar.a(gVar);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("cover_image");
        if (jSONObjectOptJSONObject2 != null) {
            com.bytedance.sdk.openadsdk.core.d.g gVar2 = new com.bytedance.sdk.openadsdk.core.d.g();
            gVar2.a(jSONObjectOptJSONObject2.optString("url"));
            gVar2.b(jSONObjectOptJSONObject2.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
            gVar2.a(jSONObjectOptJSONObject2.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
            hVar.b(gVar2);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("image");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                com.bytedance.sdk.openadsdk.core.d.g gVar3 = new com.bytedance.sdk.openadsdk.core.d.g();
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                gVar3.a(jSONObjectOptJSONObject3.optString("url"));
                gVar3.b(jSONObjectOptJSONObject3.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                gVar3.a(jSONObjectOptJSONObject3.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                hVar.c(gVar3);
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("show_url");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                hVar.D().add(jSONArrayOptJSONArray2.optString(i2));
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("click_url");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                hVar.E().add(jSONArrayOptJSONArray3.optString(i3));
            }
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("play_start");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                hVar.F().add(jSONArrayOptJSONArray4.optString(i4));
            }
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("click_area");
        if (jSONObjectOptJSONObject4 != null) {
            com.bytedance.sdk.openadsdk.core.d.c cVar = new com.bytedance.sdk.openadsdk.core.d.c();
            cVar.f6067a = jSONObjectOptJSONObject4.optBoolean("click_upper_content_area", true);
            cVar.f6068b = jSONObjectOptJSONObject4.optBoolean("click_upper_non_content_area", true);
            cVar.f6069c = jSONObjectOptJSONObject4.optBoolean("click_lower_content_area", true);
            cVar.f6070d = jSONObjectOptJSONObject4.optBoolean("click_lower_non_content_area", true);
            cVar.f6071e = jSONObjectOptJSONObject4.optBoolean("click_button_area", true);
            cVar.f6072f = jSONObjectOptJSONObject4.optBoolean("click_video_area", true);
            hVar.a(cVar);
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("adslot");
        if (jSONObjectOptJSONObject5 != null) {
            hVar.a(b(jSONObjectOptJSONObject5));
        } else {
            hVar.a(adSlot);
        }
        hVar.g(jSONObject.optInt("intercept_flag", 0));
        hVar.e(jSONObject.optString("phone_num"));
        hVar.f(jSONObject.optString("title"));
        hVar.g(jSONObject.optString("description"));
        hVar.h(jSONObject.optString("button_text"));
        hVar.e(jSONObject.optInt("ad_logo", 1));
        hVar.j(jSONObject.optString("ext"));
        hVar.m(jSONObject.optInt("image_mode"));
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("app");
        JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("deep_link");
        hVar.a(d(jSONObjectOptJSONObject6));
        hVar.a(e(jSONObjectOptJSONObject7));
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("filter_words");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                FilterWord filterWordC = c(jSONArrayOptJSONArray5.optJSONObject(i5));
                if (filterWordC != null && filterWordC.isValid()) {
                    hVar.a(filterWordC);
                }
            }
        }
        hVar.n(jSONObject.optInt("count_down"));
        hVar.a(jSONObject.optLong("expiration_time"));
        JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject8 != null) {
            hVar.a(f(jSONObjectOptJSONObject8));
        }
        hVar.a(g(jSONObject.optJSONObject("media_ext")));
        JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("tpl_info");
        if (jSONObjectOptJSONObject9 != null) {
            h.a aVar = new h.a();
            aVar.b(jSONObjectOptJSONObject9.optString("id"));
            aVar.c(jSONObjectOptJSONObject9.optString("md5"));
            aVar.d(jSONObjectOptJSONObject9.optString("url"));
            aVar.e(jSONObjectOptJSONObject9.optString("data"));
            aVar.f(jSONObjectOptJSONObject9.optString("diff_data"));
            aVar.g(jSONObjectOptJSONObject9.optString("dynamic_creative"));
            aVar.a(jSONObjectOptJSONObject9.optString("version"));
            hVar.a(aVar);
        }
        hVar.a(jSONObject.optInt("if_block_lp", 0));
        hVar.i(jSONObject.optInt("cache_sort", 1));
        hVar.j(jSONObject.optInt("if_sp_cache", 0));
        hVar.k(jSONObject.optInt("ua_policy", 2));
        return hVar;
    }

    private static FilterWord c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString("id"));
            filterWord.setName(jSONObject.optString("name"));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("options");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    FilterWord filterWordC = c(jSONArrayOptJSONArray.optJSONObject(i));
                    if (filterWordC != null && filterWordC.isValid()) {
                        filterWord.addOption(filterWordC);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static com.bytedance.sdk.openadsdk.core.d.b d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.b bVar = new com.bytedance.sdk.openadsdk.core.d.b();
        bVar.b(jSONObject.optString(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING));
        bVar.c(jSONObject.optString(au.n));
        bVar.a(jSONObject.optString("download_url"));
        bVar.a(jSONObject.optInt(FirebaseAnalytics.Param.SCORE, 4));
        bVar.b(jSONObject.optInt("comment_num", 6870));
        bVar.c(jSONObject.optInt("app_size", 0));
        return bVar;
    }

    private static com.bytedance.sdk.openadsdk.core.d.e e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.e eVar = new com.bytedance.sdk.openadsdk.core.d.e();
        eVar.a(jSONObject.optString("deeplink_url"));
        eVar.b(jSONObject.optString(MessengerShareContentUtility.FALLBACK_URL));
        eVar.a(jSONObject.optInt("fallback_type"));
        return eVar;
    }

    private static com.bytedance.sdk.openadsdk.core.d.n f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.n nVar = new com.bytedance.sdk.openadsdk.core.d.n();
        nVar.b(jSONObject.optInt("cover_height"));
        nVar.c(jSONObject.optInt("cover_width"));
        nVar.a(jSONObject.optString(au.y));
        nVar.a(jSONObject.optLong("size"));
        nVar.a(jSONObject.optDouble("video_duration"));
        nVar.b(jSONObject.optString("cover_url"));
        nVar.c(jSONObject.optString("video_url"));
        nVar.d(jSONObject.optString("endcard"));
        nVar.e(jSONObject.optString("playable_download_url"));
        nVar.f(jSONObject.optString("file_hash"));
        nVar.d(jSONObject.optInt("if_playable_loading_show", 0));
        nVar.e(jSONObject.optInt("remove_loading_page_type", 0));
        nVar.a(jSONObject.optInt("fallback_endcard_judge", 0));
        return nVar;
    }

    private static Map<String, Object> g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    public static com.bytedance.sdk.openadsdk.core.d.h a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return b(jSONObject, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.bytedance.sdk.openadsdk.core.d.h r7) {
        /*
            r0 = 1
            r1 = 0
            if (r7 != 0) goto L6
            r2 = 0
            goto L7
        L6:
            r2 = 1
        L7:
            if (r7 == 0) goto L8b
            java.lang.String r3 = r7.J()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L8a
            java.lang.String r3 = r7.J()
            int r3 = r3.length()
            if (r3 > r0) goto L1f
            goto L8a
        L1f:
            com.bytedance.sdk.openadsdk.core.d.e r0 = r7.L()
            boolean r0 = a(r0)
            if (r0 != 0) goto L2a
            return r1
        L2a:
            int r0 = r7.x()
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L51
            if (r0 == r5) goto L51
            if (r0 == r4) goto L46
            if (r0 == r3) goto L3b
            goto L5c
        L3b:
            java.lang.String r0 = r7.C()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L5c
            goto L5b
        L46:
            com.bytedance.sdk.openadsdk.core.d.b r0 = r7.K()
            boolean r0 = a(r0)
            if (r0 != 0) goto L5c
            goto L5b
        L51:
            java.lang.String r0 = r7.A()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L5c
        L5b:
            r2 = 0
        L5c:
            if (r2 != 0) goto L5f
            return r2
        L5f:
            int r0 = r7.N()
            if (r0 == r6) goto L7f
            if (r0 == r5) goto L7f
            if (r0 == r4) goto L7f
            if (r0 == r3) goto L74
            r3 = 15
            if (r0 == r3) goto L74
            r3 = 16
            if (r0 == r3) goto L7f
            goto L8b
        L74:
            com.bytedance.sdk.openadsdk.core.d.n r7 = r7.v()
            boolean r7 = a(r7)
            if (r7 != 0) goto L8b
            goto L8c
        L7f:
            java.util.List r7 = r7.B()
            boolean r7 = a(r7)
            if (r7 != 0) goto L8b
            goto L8c
        L8a:
            return r1
        L8b:
            r1 = r2
        L8c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.c.a(com.bytedance.sdk.openadsdk.core.d.h):boolean");
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.e eVar) {
        if (eVar == null) {
            return true;
        }
        if (TextUtils.isEmpty(eVar.a()) || TextUtils.isEmpty(eVar.b())) {
            return false;
        }
        return eVar.c() == 1 || eVar.c() == 2;
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.n nVar) {
        return (nVar == null || TextUtils.isEmpty(nVar.h()) || TextUtils.isEmpty(nVar.g())) ? false : true;
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.b bVar) {
        return (bVar == null || TextUtils.isEmpty(bVar.a())) ? false : true;
    }

    private static boolean a(List<com.bytedance.sdk.openadsdk.core.d.g> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (com.bytedance.sdk.openadsdk.core.d.g gVar : list) {
            if (gVar == null || TextUtils.isEmpty(gVar.a())) {
                return false;
            }
        }
        return true;
    }

    private static AdSlot b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("mCodeId", "");
        int iOptInt = jSONObject.optInt("mImgAcceptedWidth", 0);
        int iOptInt2 = jSONObject.optInt("mImgAcceptedHeight", 0);
        float fOptDouble = (float) jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
        float fOptDouble2 = (float) jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
        int iOptInt3 = jSONObject.optInt("mAdCount", 6);
        boolean zOptBoolean = jSONObject.optBoolean("mSupportDeepLink", true);
        String strOptString2 = jSONObject.optString("mRewardName", "");
        int iOptInt4 = jSONObject.optInt("mRewardAmount", 0);
        String strOptString3 = jSONObject.optString("mMediaExtra", "");
        String strOptString4 = jSONObject.optString("mUserID", "");
        int iOptInt5 = jSONObject.optInt("mOrientation", 2);
        int iOptInt6 = jSONObject.optInt("mNativeAdType", 0);
        boolean zOptBoolean2 = jSONObject.optBoolean("mIsAutoPlay", false);
        boolean zOptBoolean3 = jSONObject.optBoolean("mIsExpressAd", false);
        return new AdSlot.Builder().setCodeId(strOptString).setImageAcceptedSize(iOptInt, iOptInt2).setExpressViewAcceptedSize(fOptDouble, fOptDouble2).setAdCount(iOptInt3).setSupportDeepLink(zOptBoolean).setRewardName(strOptString2).setRewardAmount(iOptInt4).setMediaExtra(strOptString3).setUserID(strOptString4).setOrientation(iOptInt5).setNativeAdType(iOptInt6).setIsAutoPlay(zOptBoolean2).isExpressAd(zOptBoolean3).withBid(jSONObject.optString("mBidAdm", "")).build();
    }
}
