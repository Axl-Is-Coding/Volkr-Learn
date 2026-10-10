package com.localapi;

import com.facebook.ads.AdError;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.just.agentweb.WebIndicator;
import com.sandboxol.blocky.config.GameSharedConstant;
import com.sandboxol.center.config.IntConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.config.VipSubscribeStatus;
import com.sandboxol.vip.entity.VipDiamond;
import com.tendcloud.tenddata.ab;
import com.umeng.analytics.pro.au;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import io.rong.imkit.plugin.LocationConst;
import io.rong.imlib.common.RongLibConst;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class Handlers {
    private static final int CAMPAIGN_DAYS = 8;
    private static final String FAIL = "failed";
    static final String LOCAL_BASE_URL = "http://127.0.0.1:18080";
    private static final String NO_AUTH = "authentication required";
    private static final String OK = "ok";
    private static final int[] SIGN_REWARDS = {200, 400, WebIndicator.DO_END_ANIMATION_DURATION, VipDiamond.MVP, 1000, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS};
    private static final long[] CAMPAIGN_REWARDS = {200, 300, 500, 800, 1200, 2000, 3000, Tribe.CREATE_FEE_GOLDS};
    private static final long[] TURNTABLE_GOLDS = {100, 200, 500, 1000, 50, 300, 800, 2000};
    private static final Object[][] VIP_PRODUCTS = {new Object[]{"local.vipgold.1m", 1, 1, 2, Long.valueOf(ab.R)}, new Object[]{"local.vipgold.3m", 3, 1, 2, 80000L}, new Object[]{"local.vipgold.12m", 12, 2, 2, 300000L}};

    interface Ctx {
        String body();

        byte[] fileBytes();

        String header(String str);

        String path();

        String pathParam(String str);

        String query(String str);

        List<String> queryValues(String str);
    }

    private static int currentVersionCode() {
        return 4003;
    }

    private Handlers() {
    }

    static String handle(String str, Ctx ctx, StateStore stateStore) {
        if (FirebaseAnalytics.Event.LOGIN.equals(str)) {
            return login(ctx, stateStore);
        }
        if ("register".equals(str)) {
            return register(ctx, stateStore);
        }
        if ("userRegister".equals(str)) {
            return userRegister(ctx, stateStore);
        }
        if ("visitor".equals(str)) {
            return visitor(ctx, stateStore);
        }
        if ("tourist".equals(str)) {
            return tourist(ctx, stateStore);
        }
        if ("authToken".equals(str)) {
            return authToken(ctx, stateStore);
        }
        if ("renew".equals(str)) {
            return renew(ctx, stateStore);
        }
        if ("logout".equals(str)) {
            return logout(ctx, stateStore);
        }
        if ("rongToken".equals(str)) {
            return rongToken(ctx, stateStore);
        }
        if ("checkVersion".equals(str)) {
            return checkVersion(ctx, stateStore);
        }
        if ("appConfig".equals(str)) {
            return appConfig(ctx, stateStore);
        }
        if ("changeNickName".equals(str)) {
            return changeNickName(ctx, stateStore);
        }
        if ("changeInfo".equals(str)) {
            return changeInfo(ctx, stateStore);
        }
        if ("joinSwitch".equals(str)) {
            return bool(true);
        }
        if (!"ackPost".equals(str) && !"ackPut".equals(str)) {
            if ("category".equals(str)) {
                return category(ctx, stateStore);
            }
            if ("gameListByCondition".equals(str)) {
                return gameListByCondition(ctx, stateStore);
            }
            if ("gameListMore".equals(str)) {
                return gameListMore(ctx, stateStore);
            }
            if ("gameListGuessYouLike".equals(str)) {
                return gameListGuessYouLike(ctx, stateStore);
            }
            if ("recentlyPlayList".equals(str)) {
                return recentlyPlayList(ctx, stateStore);
            }
            if ("friendPlayList".equals(str)) {
                return envelope("list", "[]");
            }
            if ("recommendation".equals(str)) {
                return recommendation(ctx, stateStore);
            }
            if ("getGameByType".equals(str)) {
                return getGameByType(ctx, stateStore);
            }
            if ("getUGCGameList".equals(str)) {
                return getUGCGameList(ctx, stateStore);
            }
            if ("miniGameDetail".equals(str)) {
                return miniGameDetail(ctx, stateStore);
            }
            if ("gameDetail".equals(str)) {
                return gameDetail(ctx, stateStore);
            }
            if ("gamePreheat".equals(str)) {
                return gamePreheat(ctx, stateStore);
            }
            if ("getGameTypeList".equals(str)) {
                return getGameTypeList(ctx, stateStore);
            }
            if (!"getSystemAnnouncementInfo".equals(str) && !"getStopServiceAnnouncementInfo".equals(str)) {
                if ("getAllGameIdInfo".equals(str)) {
                    return getAllGameIdInfo(ctx, stateStore);
                }
                if ("getGameRank".equals(str)) {
                    return getGameRank(ctx, stateStore);
                }
                if ("getGameMyRank".equals(str)) {
                    return getGameMyRank(ctx, stateStore);
                }
                if ("getGameDetailShop".equals(str)) {
                    return getGameDetailShop(ctx, stateStore);
                }
                if ("buyGameProp".equals(str)) {
                    return buyGameProp(ctx, stateStore);
                }
                if ("payGame".equals(str)) {
                    return payGame(ctx, stateStore);
                }
                if ("shareRewardList".equals(str)) {
                    return shareRewardList();
                }
                if ("getGameUpdateContent".equals(str)) {
                    return getGameUpdateContent(ctx, stateStore);
                }
                if ("getGameUpdateContentList".equals(str)) {
                    return getGameUpdateContentList(ctx, stateStore);
                }
                if ("getPartyCreateGameConfig".equals(str)) {
                    return getPartyCreateGameConfig(ctx, stateStore);
                }
                if ("getChatRoom".equals(str)) {
                    return getChatRoom(ctx, stateStore);
                }
                if ("deleteChatRoom".equals(str)) {
                    return deleteChatRoom(ctx, stateStore);
                }
                if ("videoPageList".equals(str)) {
                    return videoPageList(ctx, stateStore);
                }
                if ("videoTagList".equals(str)) {
                    return videoTagList(ctx, stateStore);
                }
                if ("videoDetailInfo".equals(str)) {
                    return videoDetailInfo(ctx, stateStore);
                }
                if ("videoFeedback".equals(str)) {
                    return videoFeedback(ctx, stateStore);
                }
                if ("videoPlayAck".equals(str)) {
                    return videoPlayAck(ctx, stateStore);
                }
                if (StringConstant.GAME_ORDER_TYPE_APPRECIATION.equals(str)) {
                    return appreciation(ctx, stateStore);
                }
                if (!"miniGameToken".equals(str) && !"followGameAuth".equals(str) && !"miniGameMap".equals(str)) {
                    if ("gameResInfo".equals(str)) {
                        return gameResInfo(ctx, stateStore);
                    }
                    if ("dressCheckResource".equals(str)) {
                        return dressCheckResource(ctx, stateStore);
                    }
                    if ("dressResCheck".equals(str)) {
                        return dressResCheck(ctx, stateStore);
                    }
                    if ("resCheck".equals(str)) {
                        return envelope("obj", "{\"md5\":\"\",\"update\":false,\"url\":\"\"}");
                    }
                    if ("getUpgradeInfo".equals(str)) {
                        return envelope("obj", "{\"needUpgrade\":false,\"downloadUrl\":\"\",\"hash\":\"\",\"resVersion\":1}");
                    }
                    if ("getGameResource".equals(str)) {
                        return envelope("list", "[]");
                    }
                    if ("countUploadVersion".equals(str)) {
                        return countUploadVersion(ctx, stateStore);
                    }
                    if ("dailySignIn".equals(str)) {
                        return dailySignIn(ctx, stateStore);
                    }
                    if ("clickSignIn".equals(str)) {
                        return clickSignIn(ctx, stateStore);
                    }
                    if ("getAdsReward".equals(str)) {
                        return getAdsReward(ctx, stateStore);
                    }
                    if ("getAdsRewardInfo".equals(str)) {
                        return envelope("obj", "{\"currency\":2,\"quantity\":200,\"remainTime\":0}");
                    }
                    if ("getSignAdsReward".equals(str)) {
                        return getSignAdsReward(ctx, stateStore);
                    }
                    if ("friendList".equals(str)) {
                        return friendList(ctx, stateStore);
                    }
                    if ("friendRequestsList".equals(str)) {
                        return friendRequestsList(ctx, stateStore);
                    }
                    if ("followFriendsList".equals(str)) {
                        return emptyPage(10);
                    }
                    if ("friendRecommendation".equals(str)) {
                        return friendRecommendation(ctx, stateStore);
                    }
                    if ("friendSearchList".equals(str)) {
                        return friendSearchList(ctx, stateStore);
                    }
                    if ("friendById".equals(str)) {
                        return friendById(ctx, stateStore);
                    }
                    if ("friendDetails".equals(str)) {
                        return friendDetails(ctx, stateStore);
                    }
                    if ("friendGamingInfo".equals(str)) {
                        return friendGamingInfo(ctx, stateStore);
                    }
                    if ("friendStatus".equals(str)) {
                        return friendStatus(ctx, stateStore);
                    }
                    if ("friendPublicStatus".equals(str)) {
                        return friendPublicStatus(ctx, stateStore);
                    }
                    if ("friendAdd".equals(str)) {
                        return friendAdd(ctx, stateStore);
                    }
                    if ("friendDelete".equals(str)) {
                        return friendDelete(ctx, stateStore);
                    }
                    if ("friendBlacklist".equals(str)) {
                        return friendBlacklist(ctx, stateStore);
                    }
                    if ("friendAliasSet".equals(str)) {
                        return friendAliasSet(ctx, stateStore);
                    }
                    if ("friendAliasDelete".equals(str)) {
                        return friendAliasDelete(ctx, stateStore);
                    }
                    if ("friendAgree".equals(str)) {
                        return friendAgree(ctx, stateStore);
                    }
                    if ("friendReject".equals(str)) {
                        return friendReject(ctx, stateStore);
                    }
                    if ("groupPrice".equals(str)) {
                        return envelope("obj", "{\"currency\":1,\"price\":0}");
                    }
                    if ("groupCreate".equals(str)) {
                        return groupCreate(ctx, stateStore);
                    }
                    if ("groupList".equals(str)) {
                        return groupList(ctx, stateStore);
                    }
                    if ("groupInfo".equals(str)) {
                        return groupInfo(ctx, stateStore);
                    }
                    if ("groupInviteCount".equals(str)) {
                        return groupInviteCount(ctx, stateStore);
                    }
                    if ("groupRequestList".equals(str)) {
                        return groupRequestList(ctx, stateStore);
                    }
                    if ("groupInviteDirect".equals(str)) {
                        return groupInviteDirect(ctx, stateStore);
                    }
                    if ("groupMailInvite".equals(str)) {
                        return groupInfoResp(ctx, stateStore);
                    }
                    if ("groupBanMember".equals(str)) {
                        return groupBanMember(ctx, stateStore);
                    }
                    if ("groupInvite".equals(str)) {
                        return groupInvite(ctx, stateStore);
                    }
                    if ("groupApply".equals(str)) {
                        return groupApply(ctx, stateStore);
                    }
                    if ("groupAck".equals(str)) {
                        return envelope("none", null);
                    }
                    if ("groupMuteAll".equals(str)) {
                        return groupMuteAll(ctx, stateStore);
                    }
                    if ("groupAccept".equals(str)) {
                        return groupAccept(ctx, stateStore);
                    }
                    if ("groupRejectReq".equals(str)) {
                        return groupRejectReq(ctx, stateStore);
                    }
                    if ("groupUnban".equals(str)) {
                        return groupUnban(ctx, stateStore);
                    }
                    if ("groupQuit".equals(str)) {
                        return groupQuit(ctx, stateStore);
                    }
                    if ("groupKick".equals(str)) {
                        return groupKick(ctx, stateStore);
                    }
                    if ("groupSetManager".equals(str)) {
                        return groupSetManager(ctx, stateStore);
                    }
                    if ("groupTransfer".equals(str)) {
                        return groupTransfer(ctx, stateStore);
                    }
                    if ("groupModify".equals(str)) {
                        return groupModify(ctx, stateStore);
                    }
                    if ("setPassword".equals(str)) {
                        return setPassword(ctx, stateStore);
                    }
                    if ("passwordModify".equals(str)) {
                        return passwordModify(ctx, stateStore);
                    }
                    if ("passwordCheck".equals(str)) {
                        return passwordCheck(ctx, stateStore);
                    }
                    if ("nickNameExist".equals(str)) {
                        return nickNameExist(ctx, stateStore);
                    }
                    if ("accountModify".equals(str)) {
                        return accountModify(ctx, stateStore);
                    }
                    if ("bindPhone".equals(str)) {
                        return bindPhone(ctx, stateStore);
                    }
                    if ("unbindPhone".equals(str)) {
                        return unbindPhone(ctx, stateStore);
                    }
                    if ("bindEmail".equals(str)) {
                        return bindEmail(ctx, stateStore);
                    }
                    if ("unbindEmail".equals(str)) {
                        return unbindEmail(ctx, stateStore);
                    }
                    if ("tipsEmail".equals(str)) {
                        return tipsEmail(ctx, stateStore);
                    }
                    if ("verifyAck".equals(str)) {
                        return envelope("none", null);
                    }
                    if ("verifyEmail".equals(str)) {
                        return verifyEmail(ctx, stateStore);
                    }
                    if ("questionGet".equals(str)) {
                        return questionGet(ctx, stateStore);
                    }
                    if ("questionAuth".equals(str)) {
                        return questionAuth(ctx, stateStore);
                    }
                    if ("questionSetting".equals(str)) {
                        return questionSetting(ctx, stateStore);
                    }
                    if ("questionResetPassword".equals(str)) {
                        return questionResetPassword(ctx, stateStore);
                    }
                    if ("unbindSecurity".equals(str)) {
                        return unbindSecurity(ctx, stateStore);
                    }
                    if ("loginRecord".equals(str)) {
                        return loginRecord(ctx, stateStore);
                    }
                    if ("newDailyTasks".equals(str)) {
                        return newDailyTasks(ctx, stateStore);
                    }
                    if ("weekTasks".equals(str)) {
                        return weekTasks(ctx, stateStore);
                    }
                    if ("claimTask".equals(str)) {
                        return claimTask(ctx, stateStore);
                    }
                    if ("shareReward".equals(str)) {
                        return shareReward(ctx, stateStore);
                    }
                    if ("prefectCheck".equals(str)) {
                        return prefectCheck(ctx, stateStore);
                    }
                    if ("prefectReward".equals(str)) {
                        return prefectReward(ctx, stateStore);
                    }
                    if (!"idCardStatus".equals(str) && !"idCardSubmit".equals(str)) {
                        if ("setPsdParamCheck".equals(str)) {
                            return setPsdParamCheck(ctx, stateStore);
                        }
                        if ("accountInvalidCheck".equals(str)) {
                            return accountInvalidCheck(ctx, stateStore);
                        }
                        if ("securitySettings".equals(str)) {
                            return securitySettings(ctx, stateStore);
                        }
                        if ("activityTitle".equals(str)) {
                            return activityTitle(ctx, stateStore);
                        }
                        if ("activityActionList".equals(str)) {
                            return activityActionList(ctx, stateStore);
                        }
                        if ("activityTaskReward".equals(str)) {
                            return activityTaskReward(ctx, stateStore);
                        }
                        if ("getVipInfo".equals(str)) {
                            return getVipInfo(ctx, stateStore);
                        }
                        if ("getSubscribeInfo".equals(str)) {
                            return getSubscribeInfo(ctx, stateStore);
                        }
                        if ("dressList".equals(str)) {
                            return dressList(ctx, stateStore);
                        }
                        if ("friendUsingList".equals(str)) {
                            return friendUsingList(ctx, stateStore);
                        }
                        if ("dressExpireList".equals(str)) {
                            return envelope("list", "[]");
                        }
                        if ("dressOwnedByType".equals(str)) {
                            return dressOwnedByType(ctx, stateStore);
                        }
                        if ("dressSuitList".equals(str)) {
                            return dressSuitList(ctx, stateStore);
                        }
                        if ("dressRecommend".equals(str)) {
                            return dressRecommend(ctx, stateStore);
                        }
                        if ("isUsingList".equals(str)) {
                            return isUsingList(ctx, stateStore);
                        }
                        if ("dressGuideConfig".equals(str)) {
                            return envelope("obj", "{\"dressShopGuideConfigMap\":{}}");
                        }
                        if ("multiClothe".equals(str)) {
                            return multiClothe(ctx, stateStore);
                        }
                        if ("multiUnclothe".equals(str)) {
                            return multiUnclothe(ctx, stateStore);
                        }
                        if ("removeDecoration".equals(str)) {
                            return removeDecoration(ctx, stateStore);
                        }
                        if ("removeSuitDecoration".equals(str)) {
                            return removeSuitDecoration(ctx, stateStore);
                        }
                        if ("useDecoration".equals(str)) {
                            return useDecoration(ctx, stateStore);
                        }
                        if ("useSuitDecoration".equals(str)) {
                            return useSuitDecoration(ctx, stateStore);
                        }
                        if ("vipDress".equals(str)) {
                            return envelope("list", "[]");
                        }
                        if ("dressResCheck".equals(str)) {
                            return envelope("obj", "{\"md5\":\"\",\"update\":false,\"url\":\"\"}");
                        }
                        if ("dressCheckResource".equals(str)) {
                            return envelope("obj", "{\"needUpdate\":false,\"cdns\":[],\"fileCount\":0,\"fileSize\":0,\"hash\":\"\",\"url\":\"\",\"version\":1}");
                        }
                        if ("dressBuyOne".equals(str)) {
                            return dressBuyOne(ctx, stateStore);
                        }
                        if ("dressBuyMany".equals(str)) {
                            return dressBuyMany(ctx, stateStore);
                        }
                        if ("dressBuyV2".equals(str)) {
                            return dressBuyV2(ctx, stateStore);
                        }
                        if ("dressDetails".equals(str)) {
                            return dressDetails(ctx, stateStore);
                        }
                        if ("dressRecommendList".equals(str)) {
                            return dressRecommendList(ctx, stateStore);
                        }
                        if ("shopList".equals(str)) {
                            return shopList(ctx, stateStore);
                        }
                        if ("shopRecommendV2".equals(str)) {
                            return shopRecommendV2(ctx, stateStore);
                        }
                        if ("giftSuitCanReceive".equals(str)) {
                            return giftSuitCanReceive(ctx, stateStore);
                        }
                        if ("scrapBackpack".equals(str)) {
                            return scrapBackpack(ctx, stateStore);
                        }
                        if ("scrapCombineNum".equals(str)) {
                            return envelope("num", "3");
                        }
                        if ("scrapRequestTargets".equals(str)) {
                            return scrapRequestTargets(ctx, stateStore);
                        }
                        if ("scrapRewardValue".equals(str)) {
                            return envelope("num", "3000");
                        }
                        if ("scrapBagValue".equals(str)) {
                            return scrapBagValue(ctx, stateStore);
                        }
                        if ("scrapHistory".equals(str)) {
                            return scrapHistory(ctx, stateStore);
                        }
                        if ("scrapNum".equals(str)) {
                            return scrapNum(ctx, stateStore);
                        }
                        if ("scrapCardDetails".equals(str)) {
                            return scrapCardDetails(ctx, stateStore);
                        }
                        if ("scrapCardList".equals(str)) {
                            return scrapCardList(ctx, stateStore);
                        }
                        if ("scrapRule".equals(str)) {
                            return envelope("list", "[\"Collect scraps in the local world.\",\"Combine them into cards.\",\"Exchange cards for golds.\"]");
                        }
                        if ("scrapTreasureBox".equals(str)) {
                            return envelope("obj", "{\"boxList\":[],\"date\":\"\",\"probsNum\":0,\"rewardValue\":0,\"secondsLeft\":0}");
                        }
                        if ("scrapVipConvert".equals(str)) {
                            return envelope("obj", "{\"newVip\":{},\"vip\":{}}");
                        }
                        if ("scrapCombineCard".equals(str)) {
                            return scrapCombineCard(ctx, stateStore);
                        }
                        if (!"scrapAsk".equals(str) && !"scrapReceive".equals(str)) {
                            if ("scrapSend".equals(str)) {
                                return scrapSend(ctx, stateStore);
                            }
                            if ("rankingPage".equals(str)) {
                                return rankingPage(str, ctx, stateStore);
                            }
                            if ("mailList".equals(str)) {
                                return mailList(ctx, stateStore);
                            }
                            if ("mailOp".equals(str)) {
                                return mailOp(ctx, stateStore);
                            }
                            if ("hasNewEmail".equals(str)) {
                                return hasNewEmail(ctx, stateStore);
                            }
                            if ("mailAttachment".equals(str)) {
                                return mailAttachment(ctx, stateStore);
                            }
                            if ("tribeId".equals(str)) {
                                return tribeId(ctx, stateStore);
                            }
                            if ("tribeDetail".equals(str)) {
                                return tribeDetail(ctx, stateStore);
                            }
                            if ("tribeBaseInfo".equals(str)) {
                                return tribeBaseInfo(ctx, stateStore);
                            }
                            if ("tribeMemberList".equals(str)) {
                                return tribeMemberList(ctx, stateStore);
                            }
                            if ("clanCreate".equals(str)) {
                                return clanCreate(ctx, stateStore);
                            }
                            if ("clanUpdate".equals(str)) {
                                return clanUpdate(ctx, stateStore);
                            }
                            if ("clanDissolve".equals(str)) {
                                return clanDissolve(ctx, stateStore);
                            }
                            if ("clanExit".equals(str)) {
                                return clanExit(ctx, stateStore);
                            }
                            if ("clanKick".equals(str)) {
                                return clanKick(ctx, stateStore);
                            }
                            if ("clanJoin".equals(str)) {
                                return clanJoin(ctx, stateStore);
                            }
                            if ("clanAgreeJoin".equals(str)) {
                                return clanAgreeJoin(ctx, stateStore);
                            }
                            if ("clanRejectJoin".equals(str)) {
                                return clanRejectJoin(ctx, stateStore);
                            }
                            if ("clanAgreeInvite".equals(str)) {
                                return clanAgreeInvite(ctx, stateStore);
                            }
                            if ("clanRejectInvite".equals(str)) {
                                return clanRejectInvite(ctx, stateStore);
                            }
                            if ("clanInvite".equals(str)) {
                                return clanInvite(ctx, stateStore);
                            }
                            if ("clanSetIdentity".equals(str)) {
                                return clanSetIdentity(ctx, stateStore);
                            }
                            if ("tribeMessageList".equals(str)) {
                                return tribeMessageList(ctx, stateStore);
                            }
                            if ("tribeBulletinGet".equals(str)) {
                                return tribeBulletinGet(ctx, stateStore);
                            }
                            if ("tribeBulletinPost".equals(str)) {
                                return tribeBulletinPost(ctx, stateStore);
                            }
                            if ("tribeDonationInfo".equals(str)) {
                                return tribeDonationInfo(ctx, stateStore);
                            }
                            if ("tribeDonate".equals(str)) {
                                return tribeDonate(ctx, stateStore);
                            }
                            if ("tribeDonationHistory".equals(str)) {
                                return tribeDonationHistory(ctx, stateStore);
                            }
                            if ("tribeCurrency".equals(str)) {
                                return tribeCurrency(ctx, stateStore);
                            }
                            if ("tribeRank".equals(str)) {
                                return tribeRank(ctx, stateStore);
                            }
                            if ("tribeUserRank".equals(str)) {
                                return tribeUserRank(ctx, stateStore);
                            }
                            if ("tribeRecommend".equals(str)) {
                                return tribeRecommend(ctx, stateStore);
                            }
                            if ("tribeSearch".equals(str)) {
                                return tribeSearch(ctx, stateStore);
                            }
                            if ("tribeTasks".equals(str)) {
                                return tribeTasks(ctx, stateStore, 1);
                            }
                            if ("tribePersonalTasks".equals(str)) {
                                return tribeTasks(ctx, stateStore, 2);
                            }
                            if ("tribeTaskAccept".equals(str)) {
                                return tribeTaskAction(ctx, stateStore, false);
                            }
                            if ("tribeTaskReward".equals(str)) {
                                return tribeTaskAction(ctx, stateStore, true);
                            }
                            if ("tribeShopList".equals(str)) {
                                return tribeShopList(ctx, stateStore);
                            }
                            if ("tribeShopDetail".equals(str)) {
                                return tribeShopDetail(ctx, stateStore);
                            }
                            if ("tribeShopBuy".equals(str)) {
                                return tribeShopBuy(ctx, stateStore);
                            }
                            if ("clanFreeVerify".equals(str)) {
                                return clanFreeVerify(ctx, stateStore);
                            }
                            if ("nickNameFree".equals(str)) {
                                return envelope("obj", "{\"currencyType\":1,\"free\":true,\"quantity\":0}");
                            }
                            if ("frequentlyGames".equals(str)) {
                                return frequentlyGames(ctx, stateStore);
                            }
                            if ("teamMembers".equals(str)) {
                                return teamMembers(ctx, stateStore);
                            }
                            if ("dressAdsInfo".equals(str)) {
                                return envelope("obj", "{\"adType\":1,\"currency\":1,\"nextCurrency\":1,\"qty\":0,\"nextQty\":100,\"status\":0}");
                            }
                            if ("dressAdsReward".equals(str)) {
                                return envelope("obj", "{\"picUrl\":\"\",\"quantity\":150}");
                            }
                            if ("wallet".equals(str)) {
                                return wallet(ctx, stateStore);
                            }
                            if ("payHistory".equals(str)) {
                                return payHistory(ctx, stateStore);
                            }
                            if ("products".equals(str)) {
                                return products(ctx, stateStore);
                            }
                            if ("recharge".equals(str)) {
                                return recharge(ctx, stateStore);
                            }
                            if ("rechargeVip".equals(str)) {
                                return rechargeVip(ctx, stateStore);
                            }
                            if ("firstTopReward".equals(str)) {
                                return envelope("obj", "{\"status\":1,\"rewardList\":[]}");
                            }
                            if ("thirdPayFlag".equals(str)) {
                                return envelope("bool", "false");
                            }
                            if ("payssionSignature".equals(str)) {
                                return payssionSignature(ctx, stateStore);
                            }
                            if ("vipProducts".equals(str)) {
                                return envelope("obj", "{\"expireDate\":\"\",\"vip\":0,\"products\":{}}");
                            }
                            if ("thirdPayList".equals(str)) {
                                return envelope("obj", "{\"show\":false,\"payChannel\":[],\"currency\":\"\"}");
                            }
                            if ("dispatch".equals(str)) {
                                return dispatch(ctx, stateStore, false);
                            }
                            if ("follow".equals(str)) {
                                return dispatch(ctx, stateStore, true);
                            }
                            if ("gameResInfo".equals(str)) {
                                return gameResInfo(ctx, stateStore);
                            }
                            if ("recordAdsGame".equals(str)) {
                                return recordAdsGame(ctx, stateStore);
                            }
                            if ("shopSuitList".equals(str)) {
                                return shopSuitList(ctx, stateStore);
                            }
                            if ("suitListByIds".equals(str)) {
                                return suitListByIds(ctx, stateStore);
                            }
                            if ("suitDetail".equals(str)) {
                                return suitDetail(ctx, stateStore);
                            }
                            if ("suitGiftInfo".equals(str)) {
                                return suitGiftInfo(ctx, stateStore);
                            }
                            if ("suitGiftReceive".equals(str)) {
                                return suitGiftReceive(ctx, stateStore);
                            }
                            if ("uploadFile".equals(str)) {
                                return uploadFile(ctx, stateStore);
                            }
                            if ("sensitiveWords".equals(str)) {
                                return sensitiveWords(ctx, stateStore);
                            }
                            if ("postUserGeoInfo".equals(str)) {
                                return postUserGeoInfo(ctx, stateStore);
                            }
                            if ("userGeoList".equals(str)) {
                                return userGeoList(ctx, stateStore);
                            }
                            if ("careerData".equals(str)) {
                                return careerData(ctx, stateStore);
                            }
                            if ("regionRankHome".equals(str)) {
                                return regionRankHome(ctx, stateStore);
                            }
                            if ("userRankInfo".equals(str)) {
                                return userRankInfo(ctx, stateStore);
                            }
                            if ("partyAuth".equals(str)) {
                                return partyAuth(ctx, stateStore);
                            }
                            if ("partiesExists".equals(str)) {
                                return partiesExists(ctx, stateStore);
                            }
                            if ("campaignSignInList".equals(str)) {
                                return campaignSignInList(ctx, stateStore);
                            }
                            if ("campaignSignIn".equals(str)) {
                                return campaignSignIn(ctx, stateStore);
                            }
                            if ("turntableStatus".equals(str)) {
                                return turntableStatus(ctx, stateStore);
                            }
                            if ("eventReport".equals(str)) {
                                return eventReport(ctx, stateStore, "event");
                            }
                            if ("funnelReport".equals(str)) {
                                return eventReport(ctx, stateStore, "funnel");
                            }
                            if ("pingReport".equals(str)) {
                                return eventReport(ctx, stateStore, "ping");
                            }
                            if ("turntableInfo".equals(str)) {
                                return turntableInfo(ctx, stateStore);
                            }
                            if ("turntableProps".equals(str)) {
                                return turntableProps(ctx, stateStore);
                            }
                            if ("turntableDraw".equals(str)) {
                                return turntableDraw(ctx, stateStore);
                            }
                            if ("adsCdConfig".equals(str)) {
                                return adsCdConfig(ctx, stateStore);
                            }
                            if ("starCodeConfig".equals(str)) {
                                return starCodeConfig(ctx, stateStore);
                            }
                            if ("starCodeGetByCode".equals(str)) {
                                return starCodeGetByCode(ctx, stateStore);
                            }
                            if ("starCodeBilling".equals(str)) {
                                return starCodeBilling(ctx, stateStore);
                            }
                            if ("starCodeCashApply".equals(str)) {
                                return starCodeCashApply(ctx, stateStore);
                            }
                            if ("starCodeExchange".equals(str)) {
                                return starCodeExchange(ctx, stateStore);
                            }
                            if ("vipPriceList".equals(str)) {
                                return vipPriceList(ctx, stateStore);
                            }
                            if ("vipBuy".equals(str)) {
                                return vipBuy(ctx, stateStore);
                            }
                            if ("emailPasswordReset".equals(str)) {
                                return emailPasswordReset(ctx, stateStore);
                            }
                            if ("phonePassword".equals(str)) {
                                return phonePassword(ctx, stateStore);
                            }
                            if ("ugcStatus".equals(str)) {
                                return ugcStatus(ctx, stateStore);
                            }
                            if ("halloweenInfo".equals(str)) {
                                return halloweenInfo(ctx, stateStore);
                            }
                            if ("halloweenTaskInfo".equals(str)) {
                                return halloweenTaskInfo(ctx, stateStore);
                            }
                            if ("halloweenCandyExchange".equals(str)) {
                                return halloweenCandyExchange(ctx, stateStore);
                            }
                            if ("halloweenRewardExchange".equals(str)) {
                                return halloweenRewardExchange(ctx, stateStore);
                            }
                            if ("halloweenTaskReward".equals(str)) {
                                return halloweenTaskReward(ctx, stateStore);
                            }
                            if ("bgtubeConfig".equals(str)) {
                                return bgtubeConfig(ctx, stateStore);
                            }
                            if ("bgtubeMultiLang".equals(str)) {
                                return bgtubeMultiLang(ctx, stateStore);
                            }
                            if ("bgtubeSignInfo".equals(str)) {
                                return bgtubeSignInfo(ctx, stateStore);
                            }
                            if ("bgtubeSignCheck".equals(str)) {
                                return bgtubeSignCheck(ctx, stateStore);
                            }
                            if ("bgtubeSignUp".equals(str)) {
                                return bgtubeSignUp(ctx, stateStore);
                            }
                            if ("bgtubeVideoLink".equals(str)) {
                                return bgtubeVideoLink(ctx, stateStore);
                            }
                            if ("worldCupGames".equals(str)) {
                                return worldCupGames(ctx, stateStore);
                            }
                            if ("worldCupHistory".equals(str)) {
                                return worldCupHistory(ctx, stateStore);
                            }
                            if ("worldCupIntegral".equals(str)) {
                                return worldCupIntegral(ctx, stateStore);
                            }
                            if ("worldCupNotice".equals(str)) {
                                return worldCupNotice(ctx, stateStore);
                            }
                            if ("worldCupBet".equals(str)) {
                                return worldCupBet(ctx, stateStore);
                            }
                            if ("worldCupMyRank".equals(str)) {
                                return worldCupMyRank(ctx, stateStore);
                            }
                            if ("worldCupTotalRank".equals(str)) {
                                return worldCupTotalRank(ctx, stateStore);
                            }
                            if ("worldCupRewardList".equals(str)) {
                                return worldCupRewardList(ctx, stateStore);
                            }
                            if ("worldCupRankReward".equals(str)) {
                                return worldCupRankReward(ctx, stateStore);
                            }
                            if ("worldCupTaskList".equals(str)) {
                                return worldCupTaskList(ctx, stateStore);
                            }
                            if ("worldCupTaskReward".equals(str)) {
                                return worldCupTaskReward(ctx, stateStore);
                            }
                            if ("worldCupIntegralReward".equals(str)) {
                                return worldCupIntegralReward(ctx, stateStore);
                            }
                            if ("bannerList".equals(str)) {
                                return bannerList(ctx, stateStore);
                            }
                            if ("campaignLogo".equals(str)) {
                                return campaignLogo(ctx, stateStore);
                            }
                            if ("campaignPreciousReward".equals(str)) {
                                return campaignPreciousReward(ctx, stateStore);
                            }
                            if ("editorConfig".equals(str)) {
                                return editorConfig(ctx, stateStore);
                            }
                            if ("moreGameIntro".equals(str)) {
                                return moreGameIntro(ctx, stateStore);
                            }
                            L.e("unknown handler name: " + str);
                            return envelope("none", null);
                        }
                        return envelope("none", null);
                    }
                    return envelope("str", "\"0\"");
                }
                return miniGameToken(ctx, stateStore);
            }
            return announcement();
        }
        return envelope("none", null);
    }

    private static void recordLogin(StateStore stateStore, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectUserState = stateStore.userState(jSONObject);
        JSONArray jSONArrayOptJSONArray = jSONObjectUserState.optJSONArray("loginRecords");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("appType", "android");
        jSONObject2.put("loginTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date()));
        jSONArrayOptJSONArray.put(jSONObject2);
        JSONArray jSONArray = new JSONArray();
        for (int iMax = Math.max(0, jSONArrayOptJSONArray.length() - 10); iMax < jSONArrayOptJSONArray.length(); iMax++) {
            jSONArray.put(jSONArrayOptJSONArray.optJSONObject(iMax));
        }
        jSONObjectUserState.put("loginRecords", jSONArray);
    }

    private static String login(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectBody = body(ctx);
        String strOptString = jSONObjectBody.optString(StringConstant.UID);
        String strOptString2 = jSONObjectBody.optString("password");
        String strDecryptIfEncrypted = RsaCipher.decryptIfEncrypted(strOptString2);
        String strOptString3 = jSONObjectBody.optString("imei");
        L.i("login attempt: uid=" + strOptString + " imei=" + strOptString3 + " encrypted=" + (strOptString2.length() >= 128));
        if (strOptString != null && !strOptString.isEmpty()) {
            JSONObject jSONObjectFindByKey = stateStore.findByKey(strOptString);
            if (jSONObjectFindByKey == null) {
                jSONObjectFindByKey = stateStore.findByAccount(strOptString);
            }
            if (jSONObjectFindByKey == null) {
                return failCode(102, "account not found, please register");
            }
            String strOptString4 = jSONObjectFindByKey.optString("password");
            if (strOptString4 != null && !strOptString4.isEmpty() && !strOptString4.equals(strDecryptIfEncrypted)) {
                return fail("wrong password");
            }
            stateStore.issueToken(jSONObjectFindByKey);
            jSONObjectFindByKey.put("isFirstLogin", false);
            recordLogin(stateStore, jSONObjectFindByKey);
            stateStore.save();
            return userEnvelope(jSONObjectFindByKey);
        }
        if (strOptString3 != null && !strOptString3.isEmpty()) {
            JSONObject jSONObjectFindOrCreateByKey = stateStore.findOrCreateByKey("device:" + strOptString3, true);
            stateStore.issueToken(jSONObjectFindOrCreateByKey);
            jSONObjectFindOrCreateByKey.put("isFirstLogin", false);
            recordLogin(stateStore, jSONObjectFindOrCreateByKey);
            stateStore.save();
            return userEnvelope(jSONObjectFindOrCreateByKey);
        }
        return fail("missing credentials");
    }

    private static String register(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectBody = body(ctx);
        String strOptString = jSONObjectBody.optString(StringConstant.UID);
        String strOptString2 = jSONObjectBody.optString("password");
        if (strOptString == null || strOptString.isEmpty()) {
            return fail("username required");
        }
        if (strOptString2 == null || strOptString2.isEmpty()) {
            return fail("password required");
        }
        JSONObject jSONObjectCreateAccount = stateStore.createAccount(strOptString, strOptString2, strOptString);
        if (jSONObjectCreateAccount == null) {
            return failCode(101, "username already exists");
        }
        Mail.ensureWelcomeMail(stateStore, jSONObjectCreateAccount);
        stateStore.issueToken(jSONObjectCreateAccount);
        jSONObjectCreateAccount.put("isFirstLogin", true);
        recordLogin(stateStore, jSONObjectCreateAccount);
        stateStore.save();
        L.i("registered new account: " + strOptString + " -> userId " + jSONObjectCreateAccount.optLong("userId"));
        return userEnvelope(jSONObjectCreateAccount);
    }

    private static String userRegister(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectBody = body(ctx);
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        String strOptString = jSONObjectBody.optString("nickName");
        if (strOptString != null && !strOptString.isEmpty()) {
            jSONObjectResolve.put("nickName", strOptString);
        }
        if (jSONObjectBody.has("sex")) {
            jSONObjectResolve.put("sex", jSONObjectBody.optInt("sex"));
        }
        jSONObjectResolve.put("isFirstLogin", false);
        stateStore.save();
        return userEnvelope(jSONObjectResolve);
    }

    private static String visitor(Ctx ctx, StateStore stateStore) throws JSONException {
        String strOptString = body(ctx).optString("imei");
        if (strOptString == null || strOptString.isEmpty()) {
            strOptString = ctx.header("bmg-device-id");
        }
        if (strOptString == null || strOptString.isEmpty()) {
            strOptString = "unknown-device";
        }
        JSONObject jSONObjectFindOrCreateByKey = stateStore.findOrCreateByKey("visitor:" + strOptString, true);
        Mail.ensureWelcomeMail(stateStore, jSONObjectFindOrCreateByKey);
        String strIssueToken = stateStore.issueToken(jSONObjectFindOrCreateByKey);
        recordLogin(stateStore, jSONObjectFindOrCreateByKey);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", jSONObjectFindOrCreateByKey.optLong("userId"));
        jSONObject.put("accessToken", strIssueToken);
        jSONObject.put("nickName", jSONObjectFindOrCreateByKey.optString("nickName"));
        L.i("visitor login: imei=" + strOptString + " -> userId " + jSONObjectFindOrCreateByKey.optLong("userId"));
        return envelope("obj", jSONObject.toString());
    }

    private static String tourist(Ctx ctx, StateStore stateStore) throws JSONException {
        String strHeader = ctx.header("bmg-device-id");
        if (strHeader == null || strHeader.isEmpty()) {
            strHeader = ctx.query("appType");
        }
        if (strHeader == null || strHeader.isEmpty()) {
            strHeader = "tourist";
        }
        JSONObject jSONObjectFindOrCreateByKey = stateStore.findOrCreateByKey("tourist:" + strHeader, true);
        Mail.ensureWelcomeMail(stateStore, jSONObjectFindOrCreateByKey);
        stateStore.issueToken(jSONObjectFindOrCreateByKey);
        jSONObjectFindOrCreateByKey.put("isFirstLogin", true);
        recordLogin(stateStore, jSONObjectFindOrCreateByKey);
        stateStore.save();
        L.i("tourist login: device=" + strHeader + " -> userId " + jSONObjectFindOrCreateByKey.optLong("userId"));
        return userEnvelope(jSONObjectFindOrCreateByKey);
    }

    private static String authToken(Ctx ctx, StateStore stateStore) throws JSONException {
        long j = parseLong(ctx.query("userId"), parseLong(ctx.header("userid"), 0L));
        JSONObject jSONObjectFindByUserId = j > 0 ? stateStore.findByUserId(j) : null;
        if (jSONObjectFindByUserId == null) {
            jSONObjectFindByUserId = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        }
        String strIssueToken = stateStore.issueToken(jSONObjectFindByUserId);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessToken", strIssueToken);
        jSONObject.put("hasBinding", false);
        jSONObject.put("hasPassword", jSONObjectFindByUserId.optBoolean("hasPassword"));
        jSONObject.put("userId", jSONObjectFindByUserId.optLong("userId"));
        return envelope("obj", jSONObject.toString());
    }

    private static String renew(Ctx ctx, StateStore stateStore) {
        return authToken(ctx, stateStore);
    }

    private static String logout(Ctx ctx, StateStore stateStore) {
        stateStore.dropToken(ctx.header("access-token"));
        return envelope("none", null);
    }

    private static String rongToken(Ctx ctx, StateStore stateStore) {
        return envelope("obj", JSONObject.quote("local-" + stateStore.resolve(ctx.header("access-token"), ctx.header("userid")).optLong("userId")));
    }

    private static String changeNickName(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONObject jSONObjectBody = body(ctx);
        String strQuery = ctx.query("newName");
        if (strQuery == null || strQuery.isEmpty()) {
            strQuery = ctx.query("nickName");
        }
        if (strQuery == null || strQuery.isEmpty()) {
            strQuery = jSONObjectBody.optString("newName", jSONObjectBody.optString("nickName"));
        }
        if (strQuery != null && !strQuery.isEmpty()) {
            if (isSensitiveNick(stateStore, strQuery)) {
                return failCode(7020, "nickname contains a sensitive word");
            }
            jSONObjectResolve.put("nickName", strQuery);
            stateStore.save();
            L.i("changeNickName: userId=" + jSONObjectResolve.optLong("userId") + " -> " + strQuery);
        }
        return userEnvelope(jSONObjectResolve);
    }

    private static String changeInfo(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONObject jSONObjectBody = body(ctx);
        if (jSONObjectBody.has("nickName")) {
            String strOptString = jSONObjectBody.optString("nickName");
            if (isSensitiveNick(stateStore, strOptString)) {
                return failCode(7020, "nickname contains a sensitive word");
            }
            jSONObjectResolve.put("nickName", strOptString);
        }
        if (jSONObjectBody.has("sex")) {
            jSONObjectResolve.put("sex", jSONObjectBody.optInt("sex"));
        }
        if (jSONObjectBody.has("details")) {
            jSONObjectResolve.put("details", jSONObjectBody.optString("details"));
        }
        if (jSONObjectBody.has("birthday")) {
            jSONObjectResolve.put("birthday", jSONObjectBody.optString("birthday"));
        }
        if (jSONObjectBody.has("picUrl")) {
            jSONObjectResolve.put("picUrl", jSONObjectBody.optString("picUrl"));
        }
        jSONObjectResolve.put("isFirstLogin", false);
        stateStore.save();
        return userEnvelope(jSONObjectResolve);
    }

    private static String checkVersion(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("apkMd5", "");
        jSONObject.put("apkUrl", "");
        jSONObject.put("content", "");
        jSONObject.put("url", "");
        jSONObject.put("updateInfo", "");
        jSONObject.put("newVersionCode", currentVersionCode());
        jSONObject.put("smallerThanVersion", 0);
        jSONObject.put("forceUpdateMinVersionCode", 0);
        jSONObject.put("forceUpdateMaxVersionCode", 0);
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
        jSONObject.put("picUrl", "");
        jSONObject.put("needTobeForceUpdateVersions", new JSONArray());
        jSONObject.put("downloadGames", new JSONArray());
        jSONObject.put("langMap", new JSONObject());
        jSONObject.put("downInfoMap", new JSONObject());
        return envelope("obj", jSONObject.toString());
    }

    private static String appConfig(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("WhitelistLink", new JSONArray());
        jSONObject.put("activityUrl", "");
        jSONObject.put("activityVersionCode", 0);
        jSONObject.put("adsConfig", new JSONObject());
        jSONObject.put("dailyShareVersionCode", 0);
        jSONObject.put("downloadConfig", new JSONObject());
        jSONObject.put("downloadGames", new JSONArray());
        jSONObject.put("friendRefreshTimes", 30);
        jSONObject.put("gratitudeUrl", "");
        jSONObject.put("isClearCache", false);
        jSONObject.put("isNeedStopServiceAnnouncement", false);
        jSONObject.put("isNeedSystemAnnouncement", false);
        jSONObject.put("isOpenMTP", false);
        jSONObject.put("isOpenMorePay", false);
        jSONObject.put("isOpenUpdateSO", false);
        jSONObject.put("isShowActivity", false);
        jSONObject.put("isShowAds", false);
        jSONObject.put("isShowCampaign", false);
        jSONObject.put("isShowChest", false);
        jSONObject.put("isShowDressRecommend", false);
        jSONObject.put("isShowFriendFollow", false);
        jSONObject.put("isShowFriendMatch", false);
        jSONObject.put("isShowGameGuide", false);
        jSONObject.put("isShowHallowmasChest", false);
        jSONObject.put("isShowMainGuide", false);
        jSONObject.put("isShowMoreGame", false);
        jSONObject.put("isShowPartyInvite", false);
        jSONObject.put("isShowShare", false);
        jSONObject.put("isShowThirdPart", false);
        jSONObject.put("isShowTopActivity", false);
        jSONObject.put("isShowUniversalActivity", true);
        jSONObject.put("universalActivityVersionCode", 0);
        return envelope("obj", jSONObject.toString());
    }

    private static String category(Ctx ctx, StateStore stateStore) {
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        long j = parseLong(ctx.query("typeId"), 0L);
        String strQuery = ctx.query("orderType");
        return pageEnvelope(stateStore, (strQuery == null || strQuery.isEmpty()) ? ctx.query("order") : strQuery, j, false, i, i2, false);
    }

    private static String gameListByCondition(Ctx ctx, StateStore stateStore) {
        return pageEnvelope(stateStore, ctx.query("sortType"), parseLong(ctx.query("filterTypeId"), 0L), false, (int) parseLong(ctx.query("pageNo"), 1L), (int) parseLong(ctx.query("pageSize"), 20L), true);
    }

    private static String gameListMore(Ctx ctx, StateStore stateStore) {
        return pageEnvelope(stateStore, StringConstant.GAME_ORDER_TYPE_COMPLEX, 0L, false, (int) parseLong(ctx.query("pageNo"), 1L), (int) parseLong(ctx.query("pageSize"), 20L), false);
    }

    private static String gameListGuessYouLike(Ctx ctx, StateStore stateStore) {
        return envelope("list", GameCatalog.page(stateStore, StringConstant.GAME_ORDER_TYPE_APPRECIATE, 0L, false, 1, 10).toString());
    }

    private static String recommendation(Ctx ctx, StateStore stateStore) {
        return envelope("list", GameCatalog.page(stateStore, StringConstant.GAME_ORDER_TYPE_ONLINE, 0L, false, 1, 12).toString());
    }

    private static String getGameByType(Ctx ctx, StateStore stateStore) {
        String strQuery = ctx.query("type");
        return pageEnvelope(stateStore, StringConstant.GAME_ORDER_TYPE_ONLINE, resolveTypeNameToId(stateStore, strQuery), false, (int) parseLong(ctx.query("pageNo"), 1L), (int) parseLong(ctx.query("pageSize"), 20L), false);
    }

    private static String getUGCGameList(Ctx ctx, StateStore stateStore) {
        return pageEnvelope(stateStore, "new", 0L, true, (int) parseLong(ctx.query("pageNo"), 1L), (int) parseLong(ctx.query("pageSize"), 20L), false);
    }

    private static String recentlyPlayList(Ctx ctx, StateStore stateStore) {
        JSONArray jSONArrayRecentGames = stateStore.recentGames(stateStore.resolve(ctx.header("access-token"), ctx.header("userid")), 20);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayRecentGames.length(); i++) {
            JSONObject jSONObjectById = GameCatalog.byId(stateStore, jSONArrayRecentGames.optString(i));
            if (jSONObjectById != null) {
                jSONArray.put(jSONObjectById);
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String gameDetail(Ctx ctx, StateStore stateStore) {
        return gameDetailUserView(ctx, stateStore, pathTail(stateStore, ctx));
    }

    private static String miniGameDetail(Ctx ctx, StateStore stateStore) {
        return gameDetailUserView(ctx, stateStore, pathTail(stateStore, ctx));
    }

    private static String gameDetailUserView(Ctx ctx, StateStore stateStore, String str) throws JSONException {
        JSONObject jSONObjectById = GameCatalog.byId(stateStore, str);
        if (jSONObjectById == null) {
            return failCode(2002, "game not found");
        }
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null || jSONObjectById.optInt("isPay") != 1 || !GameCatalog.isOwned(stateStore, jSONObjectRequireUser.optLong("userId"), str)) {
            return envelope("obj", jSONObjectById.toString());
        }
        JSONObject jSONObject = new JSONObject(jSONObjectById.toString());
        jSONObject.put("isPay", 0);
        return envelope("obj", jSONObject.toString());
    }

    private static String pathTail(StateStore stateStore, Ctx ctx) {
        return ctx.pathParam("gameId");
    }

    private static String gamePreheat(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectById = GameCatalog.byId(stateStore, ctx.pathParam("gameId"));
        if (jSONObjectById == null) {
            return failCode(2002, "game not found");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("gameId", jSONObjectById.optString("gameId"));
        jSONObject.put("gameTitle", jSONObjectById.optString("gameTitle"));
        jSONObject.put("gameName", jSONObjectById.optString("gameName"));
        jSONObject.put("gameCoverPic", jSONObjectById.optString("gameCoverPic"));
        jSONObject.put("gameDetail", jSONObjectById.optString("gameDetail"));
        jSONObject.put("isPublish", 1);
        return envelope("obj", jSONObject.toString());
    }

    private static String getGameTypeList(Ctx ctx, StateStore stateStore) {
        return envelope("list", GameCatalog.categories(stateStore).toString());
    }

    private static String announcement() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", 0);
        jSONObject.put("isShow", false);
        jSONObject.put("isShowInGame", false);
        jSONObject.put("title", "");
        jSONObject.put("content", "");
        jSONObject.put("updateTime", System.currentTimeMillis());
        return envelope("obj", jSONObject.toString());
    }

    private static String getAllGameIdInfo(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONArray list = GameCatalog.list(stateStore, StringConstant.GAME_ORDER_TYPE_COMPLEX, 0L, false);
        for (int i = 0; i < list.length(); i++) {
            JSONObject jSONObject = list.getJSONObject(i);
            if (jSONObject.optInt("isOpenParty") == 1) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("gameId", jSONObject.optString("gameId"));
                jSONObject2.put("gameName", jSONObject.optString("gameName"));
                jSONObject2.put("isNewEngine", jSONObject.optInt("isNewEngine"));
                jSONObject2.put("isUgc", jSONObject.optInt("isUgcGame"));
                jSONObject2.put("picUrl", jSONObject.optString("gameCoverPic"));
                jSONArray.put(jSONObject2);
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String getGameRank(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONArray jSONArrayRankBoard = GameCatalog.rankBoard(stateStore, pathTail(stateStore, ctx));
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        JSONArray jSONArraySlice = slice(jSONArrayRankBoard, i, i2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", jSONArraySlice);
        jSONObject.put("pageNo", i);
        jSONObject.put("pageSize", i2);
        jSONObject.put("totalPage", totalPages(jSONArrayRankBoard.length(), i2));
        jSONObject.put("totalSize", jSONArrayRankBoard.length());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("pageInfo", jSONObject);
        jSONObject2.put("remainTime", 0);
        return envelope("obj", jSONObject2.toString());
    }

    private static String getGameMyRank(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONArray jSONArrayRankBoard = GameCatalog.rankBoard(stateStore, pathTail(stateStore, ctx));
        for (int i = 0; i < jSONArrayRankBoard.length(); i++) {
            if (jSONArrayRankBoard.getJSONObject(i).optLong("userId") == jSONObjectResolve.optLong("userId")) {
                return envelope("obj", jSONArrayRankBoard.getJSONObject(i).toString());
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", jSONObjectResolve.optLong("userId"));
        jSONObject.put("nickName", jSONObjectResolve.optString("nickName"));
        jSONObject.put("headPic", "");
        jSONObject.put("vip", jSONObjectResolve.optInt("vip"));
        jSONObject.put(StringConstant.REWARD_TYPE_INTEGRAL, 0);
        jSONObject.put("isFirst", false);
        jSONObject.put("rank", 0);
        return envelope("obj", jSONObject.toString());
    }

    private static String getGameDetailShop(Ctx ctx, StateStore stateStore) {
        String strQuery = ctx.query("gameId");
        if (strQuery == null || strQuery.isEmpty()) {
            strQuery = pathTail(stateStore, ctx);
        }
        return envelope("list", GameCatalog.shopProps(stateStore, strQuery).toString());
    }

    private static String getPartyCreateGameConfig(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("gameId", ctx.pathParam("gameId"));
        jSONObject.put("gameCategory", "");
        jSONObject.put("partyStatus", 1);
        jSONObject.put("memberMax", 16);
        jSONObject.put("commonMem", 8);
        jSONObject.put("teamMem", 4);
        jSONObject.put("teamNum", 4);
        jSONObject.put("vipMem", 12);
        return envelope("obj", jSONObject.toString());
    }

    private static String getChatRoom(Ctx ctx, StateStore stateStore) throws JSONException {
        String strQuery = ctx.query("roomName");
        if (strQuery == null || strQuery.isEmpty()) {
            strQuery = "lobby";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("roomId", GameCatalog.chatRoom(stateStore, strQuery));
        jSONObject.put("roomName", strQuery);
        return envelope("obj", jSONObject.toString());
    }

    private static String deleteChatRoom(Ctx ctx, StateStore stateStore) {
        String strBody;
        String strQuery = ctx.query("roomId");
        if ((strQuery == null || strQuery.isEmpty()) && (strBody = ctx.body()) != null && strBody.contains("roomId")) {
            try {
                strQuery = new JSONObject(strBody).optString("roomId");
            } catch (Throwable unused) {
            }
        }
        GameCatalog.removeChatRoom(stateStore, strQuery);
        return envelope("none", null);
    }

    private static String videoPageList(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", new JSONArray());
        jSONObject.put("pageNo", (int) parseLong(ctx.query("pageNo"), 1L));
        jSONObject.put("pageSize", (int) parseLong(ctx.query("pageSize"), 20L));
        jSONObject.put("totalPage", 0);
        jSONObject.put("totalSize", 0);
        return envelope("obj", jSONObject.toString());
    }

    private static String videoTagList(Ctx ctx, StateStore stateStore) {
        return envelope("obj", new JSONObject().toString());
    }

    private static String videoDetailInfo(Ctx ctx, StateStore stateStore) {
        return envelope("obj", null);
    }

    private static String videoFeedback(Ctx ctx, StateStore stateStore) {
        return envelope("num", "0");
    }

    private static String videoPlayAck(Ctx ctx, StateStore stateStore) {
        return envelope("num", "0");
    }

    private static String appreciation(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectById = GameCatalog.byId(stateStore, pathTail(stateStore, ctx));
        if (jSONObjectById == null) {
            return failCode(2002, "game not found");
        }
        String strOptString = jSONObjectById.optString("gameId");
        JSONObject jSONObjectUserState = stateStore.userState(jSONObjectRequireUser);
        JSONArray jSONArrayOptJSONArray = jSONObjectUserState.optJSONArray("appreciated");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectUserState.put("appreciated", jSONArrayOptJSONArray);
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            if (strOptString.equals(jSONArrayOptJSONArray.optString(i))) {
                return failCode(2005, "already appreciated");
            }
        }
        jSONArrayOptJSONArray.put(strOptString);
        int iOptInt = jSONObjectById.optInt("praiseNumber") + 1;
        jSONObjectById.put("praiseNumber", iOptInt);
        jSONObjectById.put(StringConstant.GAME_ORDER_TYPE_APPRECIATE, true);
        stateStore.save();
        return envelope("num", String.valueOf(iOptInt));
    }

    private static String miniGameToken(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        String strQuery = ctx.query("mapName") == null ? "" : ctx.query("mapName");
        JSONObject jSONObjectIssueMiniToken = stateStore.issueMiniToken(jSONObjectResolve.optLong("userId"), ctx.query("typeId") == null ? "" : ctx.query("typeId"), strQuery, 0);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(RongLibConst.KEY_TOKEN, jSONObjectIssueMiniToken.optString(RongLibConst.KEY_TOKEN));
        jSONObject.put("timestamp", jSONObjectIssueMiniToken.optLong("timestamp"));
        jSONObject.put(InAppPurchaseMetaData.KEY_SIGNATURE, jSONObjectIssueMiniToken.optString(InAppPurchaseMetaData.KEY_SIGNATURE));
        jSONObject.put("dispUrl", LOCAL_BASE_URL);
        jSONObject.put("downloadUrl", "");
        jSONObject.put("mapName", strQuery);
        jSONObject.put("region", 0);
        jSONObject.put("country", "");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(String.valueOf(jSONObjectResolve.optLong("userId")), jSONObjectIssueMiniToken.optString("requestId"));
        jSONObject.put("requestId", jSONObject2);
        return envelope("obj", jSONObject.toString());
    }

    private static String dispatch(Ctx ctx, StateStore stateStore, boolean z) throws JSONException {
        String strChatRoom;
        String strValueOf;
        int iOptLong;
        String strHeader = ctx.header("x-shahe-token");
        String strHeader2 = ctx.header("x-shahe-uid");
        JSONObject jSONObjectFindMiniToken = stateStore.findMiniToken(strHeader);
        if (jSONObjectFindMiniToken == null || strHeader2 == null || parseLong(strHeader2, -1L) != jSONObjectFindMiniToken.optLong("userId")) {
            L.i("dispatch rejected: token=" + (strHeader == null ? "null" : "present") + " uid=" + strHeader2);
            return fail("invalid dispatch token");
        }
        JSONObject jSONObjectBody = body(ctx);
        long jOptLong = jSONObjectFindMiniToken.optLong("userId");
        String strOptString = jSONObjectFindMiniToken.optString("gameType");
        String strOptString2 = jSONObjectFindMiniToken.optString("mapName");
        if (strOptString2.isEmpty()) {
            strOptString2 = jSONObjectBody.optString("mapName", "");
        }
        JSONObject jSONObjectById = GameCatalog.byId(stateStore, strOptString);
        String strOptString3 = "Local Game";
        if (jSONObjectById != null) {
            strOptString3 = jSONObjectById.optString("gameTitle", "Local Game");
        } else if (z) {
            strOptString3 = "Followed Game";
        }
        String strOptString4 = jSONObjectById == null ? strOptString : jSONObjectById.optString("scriptType", strOptString);
        String strOptString5 = jSONObjectById == null ? "" : jSONObjectById.optString("mapName", "");
        if (jSONObjectById == null) {
            strChatRoom = GameCatalog.chatRoom(stateStore, "game-" + (strOptString.isEmpty() ? "lobby" : strOptString));
        } else {
            strChatRoom = GameCatalog.chatRoom(stateStore, "game-" + strOptString);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", 0);
        jSONObject.put("gaddr", "127.0.0.1:18080");
        jSONObject.put("dispUrl", LOCAL_BASE_URL);
        jSONObject.put("croomid", strChatRoom);
        jSONObject.put("gameType", strOptString4);
        if (strOptString2.isEmpty()) {
            strValueOf = strOptString5.isEmpty() ? String.valueOf((Math.abs(strOptString.hashCode()) % 9000) + 1000) : strOptString5;
        } else {
            strValueOf = strOptString2;
        }
        jSONObject.put("mid", strValueOf);
        if (strOptString2.isEmpty()) {
            strOptString2 = strOptString5;
        }
        jSONObject.put("mname", strOptString2);
        JSONObject jSONObjectEntryForGame = strOptString4.matches("g[0-9]+") ? MapAssets.entryForGame(strOptString4) : null;
        jSONObject.put("downurl", jSONObjectEntryForGame != null ? MapAssets.durlFor(jSONObjectEntryForGame) : "");
        jSONObject.put("name", strOptString3);
        jSONObject.put("region", jSONObjectFindMiniToken.optInt("region"));
        if (jSONObjectEntryForGame != null) {
            iOptLong = jSONObjectEntryForGame.optInt("version", 1);
        } else {
            iOptLong = (int) jSONObjectBody.optLong("resVersion", 1L);
        }
        jSONObject.put("resVersion", iOptLong);
        jSONObject.put(InAppPurchaseMetaData.KEY_SIGNATURE, jSONObjectFindMiniToken.optString(InAppPurchaseMetaData.KEY_SIGNATURE));
        jSONObject.put("timestamp", jSONObjectFindMiniToken.optLong("timestamp"));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(String.valueOf(jOptLong), jSONObjectFindMiniToken.optString("requestId"));
        jSONObject.put("requestIds", jSONObject2);
        return envelope("obj", jSONObject.toString());
    }

    private static String gameResInfo(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectById;
        String strQuery = ctx.query("resVersion");
        String strQuery2 = ctx.query("gameType");
        long j = 0;
        if (strQuery != null && !strQuery.isEmpty()) {
            j = parseLong(strQuery, 0L);
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("base", true);
        jSONObject2.put("cdnId", "local");
        jSONObject2.put("cdnUrl", LOCAL_BASE_URL);
        jSONObject2.put("ratio", 1);
        jSONObject2.put("url", LOCAL_BASE_URL);
        jSONArray.put(jSONObject2);
        jSONObject.put("cdns", jSONArray);
        String strTrim = strQuery2 == null ? "" : strQuery2.trim();
        if (strTrim.matches("[0-9]+")) {
            strTrim = "g" + strTrim;
        }
        if (!strTrim.matches("g[0-9]+") && (jSONObjectById = GameCatalog.byId(stateStore, strTrim)) != null) {
            strTrim = jSONObjectById.optString("scriptType", strTrim);
        }
        JSONObject jSONObjectEntryForGame = strTrim.isEmpty() ? null : MapAssets.entryForGame(strTrim);
        if (jSONObjectEntryForGame != null) {
            int iOptInt = jSONObjectEntryForGame.optInt("version", (int) j);
            jSONObject.put("durl", MapAssets.durlFor(jSONObjectEntryForGame));
            jSONObject.put("resVersion", iOptInt);
            L.i("game-res " + strTrim + " v" + j + " -> " + jSONObjectEntryForGame.optString("zipName") + " @v" + iOptInt);
        } else {
            jSONObject.put("durl", "");
            jSONObject.put("resVersion", (int) Math.max(1L, j));
        }
        return envelope("obj", jSONObject.toString());
    }

    private static String dressCheckResource(Ctx ctx, StateStore stateStore) throws JSONException {
        long j = parseLong(ctx.query("resVersion"), 0L);
        JSONObject jSONObjectCheckResponse = DressRes.checkResponse(stateStore, j);
        L.i("dress-res v" + j + " -> need=" + jSONObjectCheckResponse.optBoolean("needUpdate") + " target=" + jSONObjectCheckResponse.optInt("version"));
        return envelope("obj", jSONObjectCheckResponse.toString());
    }

    private static String dressResCheck(Ctx ctx, StateStore stateStore) {
        return envelope("obj", "{\"md5\":\"\",\"update\":false,\"url\":\"\"}");
    }

    private static String getGameUpdateContentList(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectEntryForGame;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayGames = GameCatalog.games(stateStore);
        for (int i = 0; i < jSONArrayGames.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayGames.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("scriptType", "");
                if (strOptString.matches("g[0-9]+") && (jSONObjectEntryForGame = MapAssets.entryForGame(strOptString)) != null) {
                    jSONObject.put(jSONObjectOptJSONObject.optString("gameId"), jSONObjectEntryForGame.optInt("version", 0));
                }
            }
        }
        return envelope("obj", jSONObject.toString());
    }

    private static String getGameUpdateContent(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectById = GameCatalog.byId(stateStore, pathTail(stateStore, ctx));
        String strOptString = jSONObjectById == null ? "" : jSONObjectById.optString("scriptType", "");
        JSONObject jSONObjectEntryForGame = strOptString.matches("g[0-9]+") ? MapAssets.entryForGame(strOptString) : null;
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectEntryForGame != null) {
            int iOptInt = jSONObjectEntryForGame.optInt("version", 0);
            jSONObject.put("content", String.valueOf(jSONObjectById != null ? jSONObjectById.optString("gameTitle", "Game") : "Game") + " official map updated (build " + iOptInt + ").");
            jSONObject.put("count", iOptInt);
        } else {
            jSONObject.put("content", "");
            jSONObject.put("count", 0);
        }
        return envelope("obj", jSONObject.toString());
    }

    private static String recordAdsGame(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String str = today();
        if (stateStore.adRewardCount(jSONObjectRequireUser, str) >= 5) {
            return envelope("num", "0");
        }
        stateStore.countAdReward(jSONObjectRequireUser, str);
        stateStore.award(jSONObjectRequireUser, StringConstant.CHRISTMAS_GOLDS, 100L);
        return envelope("num", "100");
    }

    private static String postUserGeoInfo(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LocationConst.LONGITUDE, parseDouble(ctx.query(LocationConst.LONGITUDE)));
        jSONObject.put(LocationConst.LATITUDE, parseDouble(ctx.query(LocationConst.LATITUDE)));
        jSONObject.put("updatedAt", System.currentTimeMillis());
        stateStore.userState(jSONObjectRequireUser).put("geo", jSONObject);
        stateStore.save();
        return envelope("none", null);
    }

    private static String userGeoList(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObjectOptJSONObject = stateStore.userState(jSONObjectResolve).optJSONObject("geo");
        if (jSONObjectOptJSONObject != null) {
            JSONObject jSONObjectMapInfo = mapInfo(jSONObjectResolve, jSONObjectOptJSONObject, jSONObjectOptJSONObject, jSONObjectResolve.optLong("userId"));
            jSONObjectMapInfo.put("distance", 0);
            jSONArray.put(jSONObjectMapInfo);
        }
        JSONArray jSONArrayCitizens = GameCatalog.citizens(stateStore);
        for (int i = 0; i < jSONArrayCitizens.length(); i++) {
            JSONObject jSONObject = jSONArrayCitizens.getJSONObject(i);
            JSONObject jSONObjectCitizenGeo = citizenGeo(stateStore, jSONObject);
            if (jSONObjectCitizenGeo != null) {
                JSONObject jSONObjectMapInfo2 = mapInfo(jSONObject, jSONObjectCitizenGeo, jSONObjectOptJSONObject, jSONObject.optLong("userId"));
                jSONObjectMapInfo2.put("distance", jSONObjectOptJSONObject == null ? 0.0d : haversineKm(jSONObjectOptJSONObject.optDouble(LocationConst.LATITUDE), jSONObjectOptJSONObject.optDouble(LocationConst.LONGITUDE), jSONObjectCitizenGeo.optDouble(LocationConst.LATITUDE), jSONObjectCitizenGeo.optDouble(LocationConst.LONGITUDE)));
                jSONArray.put(jSONObjectMapInfo2);
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static JSONObject citizenGeo(StateStore stateStore, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(LocationConst.LATITUDE)) {
            return new JSONObject().put(LocationConst.LATITUDE, jSONObject.optDouble(LocationConst.LATITUDE)).put(LocationConst.LONGITUDE, jSONObject.optDouble(LocationConst.LONGITUDE));
        }
        long jOptLong = jSONObject.optLong("userId");
        double d2 = ((37 * jOptLong) % 130) - 35;
        double d3 = ((jOptLong * 53) % 240) - 120;
        jSONObject.put(LocationConst.LATITUDE, d2);
        jSONObject.put(LocationConst.LONGITUDE, d3);
        stateStore.save();
        return new JSONObject().put(LocationConst.LATITUDE, d2).put(LocationConst.LONGITUDE, d3);
    }

    private static JSONObject mapInfo(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, long j) throws JSONException {
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("userId", j);
        jSONObject4.put("pic", jSONObject.optString("picUrl", jSONObject.optString("headPic", "")));
        jSONObject4.put(LocationConst.LATITUDE, jSONObject2.optDouble(LocationConst.LATITUDE));
        jSONObject4.put(LocationConst.LONGITUDE, jSONObject2.optDouble(LocationConst.LONGITUDE));
        double dOptDouble = jSONObject3 == null ? 0.0d : jSONObject3.optDouble(LocationConst.LATITUDE);
        jSONObject4.put("x", ((int) Math.round((jSONObject2.optDouble(LocationConst.LONGITUDE) - (jSONObject3 != null ? jSONObject3.optDouble(LocationConst.LONGITUDE) : 0.0d)) * 1.2d)) + 100);
        jSONObject4.put("y", ((int) Math.round((jSONObject2.optDouble(LocationConst.LATITUDE) - dOptDouble) * 1.2d)) + 100);
        return jSONObject4;
    }

    private static double haversineKm(double d2, double d3, double d4, double d5) {
        double radians = Math.toRadians(d4 - d2) / 2.0d;
        double radians2 = Math.toRadians(d5 - d3) / 2.0d;
        return Math.round((12742.0d * Math.asin(Math.sqrt((Math.sin(radians) * Math.sin(radians)) + (((Math.cos(Math.toRadians(d2)) * Math.cos(Math.toRadians(d4))) * Math.sin(radians2)) * Math.sin(radians2))))) * 10.0d) / 10.0d;
    }

    private static String careerData(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectFindByUserId = stateStore.findByUserId(parseLong(ctx.pathParam("userId"), 0L));
        if (jSONObjectFindByUserId == null) {
            return fail("user not found");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("averageTime", 0);
        jSONObject.put("completeRate", 0);
        jSONObject.put("killCount", 0);
        jSONObject.put("totalTime", 0);
        jSONObject.put("victoryRate", 0);
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArrayRecentGames = stateStore.recentGames(jSONObjectFindByUserId, 30);
        for (int i = 0; i < jSONArrayRecentGames.length(); i++) {
            jSONObject2.put(jSONArrayRecentGames.optString(i), 0L);
        }
        jSONObject.put("gameTimeMap", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("userGameCareerInfo", jSONObject);
        jSONObject3.put("userGameMonthInfo", new JSONObject(jSONObject.toString()));
        return envelope("obj", jSONObject3.toString());
    }

    private static long rankQuantity(JSONObject jSONObject, boolean z, String str, boolean z2) {
        long jOptLong;
        long jOptLong2;
        long j;
        long jOptLong3;
        if (!"gDiamond".equals(str)) {
            if ("clan".equals(str)) {
                if (z) {
                    jOptLong = jSONObject.optLong("userId") % 900;
                } else {
                    jOptLong = jSONObject.optLong("tribeCurrency", 0L);
                }
            } else if (AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equals(str)) {
                if (z) {
                    jOptLong = jSONObject.optLong("userId") % 300;
                } else {
                    int length = 0;
                    if (jSONObject.opt(ServerProtocol.DIALOG_PARAM_STATE) != null && jSONObject.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE).optJSONArray("playedGames") != null) {
                        length = jSONObject.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE).optJSONArray("playedGames").length();
                    }
                    jOptLong = length;
                }
            } else if (z) {
                jOptLong2 = jSONObject.optLong("userId") % ab.R;
                j = 45000;
                jOptLong3 = j - jOptLong2;
            } else {
                jOptLong = jSONObject.optLong(StringConstant.CHRISTMAS_GOLDS);
            }
            jOptLong3 = jOptLong;
        } else if (z) {
            jOptLong2 = jSONObject.optLong("userId") % 12000;
            j = 20000;
            jOptLong3 = j - jOptLong2;
        } else {
            jOptLong3 = jSONObject.optLong(StringConstant.CHRISTMAS_DIAMONDS);
        }
        return z2 ? (jOptLong3 / 7) + 3 : jOptLong3;
    }

    private static String mailList(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        return envelope("list", Mail.list(stateStore, jSONObjectRequireUser).toString());
    }

    private static String hasNewEmail(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        return envelope("bool", String.valueOf(Mail.hasNew(stateStore, jSONObjectRequireUser)));
    }

    private static String mailOp(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        int i = (int) parseLong(ctx.query(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS), 2L);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = ctx.queryValues("ids").iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(Long.parseLong(it.next().trim()));
            } catch (NumberFormatException unused) {
            }
        }
        return envelope("list", Mail.operate(stateStore, jSONObjectRequireUser, i, jSONArray).toString());
    }

    private static String mailAttachment(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        long j = parseLong(ctx.query("mailId"), 0L);
        if (j <= 0) {
            return fail("mailId required");
        }
        if (!Mail.claim(stateStore, jSONObjectRequireUser, j)) {
            return fail("attachment already claimed or mail gone");
        }
        return envelope("str", "\"ok\"");
    }

    private static String countUploadVersion(Ctx ctx, StateStore stateStore) {
        stateStore.recordEngineReport(ctx.query("engineVersion"), (int) parseLong(ctx.query("newEngineVersion"), 0L), ctx.header("cloudfront-viewer-country"));
        return envelope("none", null);
    }

    private static String buyGameProp(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strQuery = ctx.query("gameId");
        long j = parseLong(ctx.query("propsId"), 0L);
        if (strQuery == null || strQuery.isEmpty() || j <= 0) {
            return fail("gameId and propsId required");
        }
        JSONArray jSONArrayShopProps = GameCatalog.shopProps(stateStore, strQuery);
        int i = 0;
        while (true) {
            if (i >= jSONArrayShopProps.length()) {
                jSONObjectOptJSONObject = null;
                break;
            }
            jSONObjectOptJSONObject = jSONArrayShopProps.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("id") == j) {
                break;
            }
            i++;
        }
        if (jSONObjectOptJSONObject == null) {
            return fail("unknown prop for game");
        }
        JSONObject jSONObjectUserState = stateStore.userState(jSONObjectRequireUser);
        JSONObject jSONObjectOptJSONObject2 = jSONObjectUserState.optJSONObject("ownedProps");
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
            jSONObjectUserState.put("ownedProps", jSONObjectOptJSONObject2);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray(strQuery);
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectOptJSONObject2.put(strQuery, jSONArrayOptJSONArray);
        }
        JSONArray jSONArray = jSONArrayOptJSONArray;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray.optLong(i2) == j) {
                return fail("prop already owned");
            }
        }
        String str = jSONObjectOptJSONObject.optInt("currency") == 2 ? StringConstant.CHRISTMAS_GOLDS : StringConstant.CHRISTMAS_DIAMONDS;
        long jOptLong = jSONObjectOptJSONObject.optLong("price");
        if (jSONObjectRequireUser.optLong(str) < jOptLong) {
            return fail("insufficient ".concat(str));
        }
        stateStore.award(jSONObjectRequireUser, str, -jOptLong);
        jSONArray.put(j);
        stateStore.save();
        L.i("buyGameProp: userId=" + jSONObjectRequireUser.optLong("userId") + " game=" + strQuery + " prop=" + j + " -" + jOptLong + " " + str);
        return envelope("none", null);
    }

    private static String payGame(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strPathTail = pathTail(stateStore, ctx);
        if (strPathTail == null || strPathTail.isEmpty()) {
            return failCode(5002, "invalid good id");
        }
        JSONObject jSONObjectById = GameCatalog.byId(stateStore, strPathTail);
        if (jSONObjectById == null || jSONObjectById.optInt("isPay") != 1) {
            return failCode(5002, "invalid good id");
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectById.optJSONObject("gamePayInfo");
        if (jSONObjectOptJSONObject == null) {
            return failCode(5002, "invalid good id");
        }
        if (GameCatalog.isOwned(stateStore, jSONObjectRequireUser.optLong("userId"), strPathTail)) {
            return failCode(5008, "already owned");
        }
        if (jSONObjectOptJSONObject.has("stock") && jSONObjectOptJSONObject.optInt("stock") <= 0) {
            return failCode(5004, "sold out");
        }
        int iOptInt = jSONObjectOptJSONObject.optInt("currency", 1);
        long jOptLong = jSONObjectOptJSONObject.optLong("qty", 0L);
        String str = iOptInt == 2 ? StringConstant.CHRISTMAS_GOLDS : StringConstant.CHRISTMAS_DIAMONDS;
        if (jSONObjectRequireUser.optLong(str) < jOptLong) {
            return failCode(iOptInt == 2 ? 5007 : 5006, iOptInt == 2 ? "golds not enough" : "diamonds not enough");
        }
        stateStore.award(jSONObjectRequireUser, str, -jOptLong);
        String str2 = "ORD" + System.currentTimeMillis() + String.format(Locale.US, "%05d", Integer.valueOf((int) (jSONObjectRequireUser.optLong("userId") % 100000)));
        GameCatalog.recordPurchase(stateStore, jSONObjectRequireUser.optLong("userId"), strPathTail, jOptLong, iOptInt, str2);
        stateStore.save();
        L.i("payGame: userId=" + jSONObjectRequireUser.optLong("userId") + " game=" + strPathTail + " -" + jOptLong + " " + str + " order=" + str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", jSONObjectRequireUser.optLong("userId"));
        jSONObject.put(StringConstant.CHRISTMAS_DIAMONDS, jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_DIAMONDS));
        jSONObject.put("gDiamonds", jSONObjectRequireUser.optLong("gDiamonds"));
        jSONObject.put(StringConstant.CHRISTMAS_GOLDS, jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_GOLDS));
        jSONObject.put("orderId", str2);
        return envelope("obj", jSONObject.toString());
    }

    private static String shareRewardList() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", 1);
        jSONObject.put("picUrl", "");
        jSONObject.put("count", 200);
        jSONArray.put(jSONObject);
        return envelope("list", jSONArray.toString());
    }

    private static JSONArray rankRowsByType(StateStore stateStore, String str, boolean z) throws JSONException {
        int i;
        int i2;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("users");
        JSONArray jSONArrayNames = jSONObjectOptJSONObject.names();
        int i3 = 0;
        while (jSONArrayNames != null && i3 < jSONArrayNames.length()) {
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(jSONArrayNames.optString(i3));
            if (jSONObjectOptJSONObject2 == null) {
                i2 = i3;
            } else {
                JSONObject jSONObject = new JSONObject();
                i2 = i3;
                jSONObject.put("id", jSONObjectOptJSONObject2.optLong("userId"));
                jSONObject.put("name", jSONObjectOptJSONObject2.optString("nickName"));
                jSONObject.put("pic", jSONObjectOptJSONObject2.optString("picUrl"));
                jSONObject.put(FirebaseAnalytics.Param.QUANTITY, rankQuantity(jSONObjectOptJSONObject2, false, str, z));
                jSONArray.put(jSONObject);
            }
            i3 = i2 + 1;
        }
        int i4 = 0;
        JSONArray jSONArrayCitizens = GameCatalog.citizens(stateStore);
        int i5 = 0;
        while (true) {
            if (i5 >= jSONArrayCitizens.length()) {
                break;
            }
            JSONObject jSONObject2 = jSONArrayCitizens.getJSONObject(i5);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", jSONObject2.optLong("userId"));
            jSONObject3.put("name", jSONObject2.optString("nickName"));
            jSONObject3.put("pic", jSONObject2.optString("headPic"));
            jSONObject3.put(FirebaseAnalytics.Param.QUANTITY, rankQuantity(jSONObject2, true, str, z));
            jSONArray.put(jSONObject3);
            i5++;
            jSONArrayCitizens = jSONArrayCitizens;
        }
        for (i = 1; i < jSONArray.length(); i++) {
            JSONObject jSONObject4 = jSONArray.getJSONObject(i);
            int i6 = i - 1;
            while (i6 >= 0 && jSONArray.getJSONObject(i6).optLong(FirebaseAnalytics.Param.QUANTITY) < jSONObject4.optLong(FirebaseAnalytics.Param.QUANTITY)) {
                jSONArray.put(i6 + 1, jSONArray.getJSONObject(i6));
                i6--;
            }
            jSONArray.put(i6 + 1, jSONObject4);
        }
        while (i4 < jSONArray.length()) {
            JSONObject jSONObject5 = jSONArray.getJSONObject(i4);
            i4++;
            jSONObject5.put("rank", i4);
        }
        return jSONArray;
    }

    private static String regionRankHome(Ctx ctx, StateStore stateStore) throws JSONException {
        boolean zContains = (ctx.query("rankType") == null ? "week" : ctx.query("rankType")).contains("week");
        String[] strArr = {"gDiamond", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "clan"};
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            JSONArray jSONArrayRankRowsByType = rankRowsByType(stateStore, str, zContains);
            if (jSONArrayRankRowsByType.length() != 0) {
                JSONObject jSONObject = jSONArrayRankRowsByType.getJSONObject(0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("userId", jSONObject.optLong("id"));
                jSONObject2.put("topName", jSONObject.optString("name"));
                jSONObject2.put("topPic", jSONObject.optString("pic"));
                jSONObject2.put(FirebaseAnalytics.Param.QUANTITY, jSONObject.optLong(FirebaseAnalytics.Param.QUANTITY));
                jSONObject2.put("type", str);
                jSONArray.put(jSONObject2);
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("topRankInfos", jSONArray);
        jSONObject3.put("remainingTime", msUntilNextMondayUtc());
        return envelope("obj", jSONObject3.toString());
    }

    private static String userRankInfo(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        String strQuery = ctx.query("rankType") == null ? "overall" : ctx.query("rankType");
        String strQuery2 = ctx.query("type") == null ? StringConstant.MONEY_TYPE_GOLD : ctx.query("type");
        boolean zEquals = "week".equals(strQuery);
        JSONArray jSONArrayRankRowsByType = rankRowsByType(stateStore, strQuery2, zEquals);
        int i = 0;
        while (true) {
            if (i >= jSONArrayRankRowsByType.length()) {
                jSONObject = null;
                break;
            }
            JSONObject jSONObject2 = jSONArrayRankRowsByType.getJSONObject(i);
            if (jSONObject2.optLong("id") == jSONObjectResolve.optLong("userId")) {
                jSONObject = jSONObject2;
                break;
            }
            i++;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            jSONObject.put("id", jSONObjectResolve.optLong("userId"));
            jSONObject.put("name", jSONObjectResolve.optString("nickName"));
            jSONObject.put("pic", jSONObjectResolve.optString("picUrl"));
            jSONObject.put(FirebaseAnalytics.Param.QUANTITY, rankQuantity(jSONObjectResolve, false, strQuery2, zEquals));
            jSONObject.put("rank", jSONArrayRankRowsByType.length() + 1);
        }
        jSONObject.put("rankType", strQuery);
        return envelope("obj", jSONObject.toString());
    }

    private static long msUntilNextMondayUtc() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        long timeInMillis = calendar.getTimeInMillis();
        int i = (9 - calendar.get(7)) % 7;
        calendar.add(5, i != 0 ? i : 7);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - timeInMillis;
    }

    private static String partyAuth(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dispUrl", LOCAL_BASE_URL);
        jSONObject.put("partyService", "127.0.0.1:18080");
        jSONObject.put("partyQuerierService", LOCAL_BASE_URL);
        jSONObject.put("region", 0);
        jSONObject.put("country", "");
        jSONObject.put("engineType", "local");
        jSONObject.put(RongLibConst.KEY_TOKEN, "pa-" + jSONObjectResolve.optLong("userId") + "-" + Long.toHexString(System.nanoTime()));
        jSONObject.put(InAppPurchaseMetaData.KEY_SIGNATURE, Long.toHexString(Double.doubleToLongBits(Math.random())));
        jSONObject.put("timestamp", System.currentTimeMillis());
        return envelope("obj", jSONObject.toString());
    }

    private static String partiesExists(Ctx ctx, StateStore stateStore) {
        return envelope("str", "\"\"");
    }

    private static String dailySignIn(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        boolean zHasSignedIn = stateStore.hasSignedIn(jSONObjectResolve, today());
        int length = stateStore.signIns(jSONObjectResolve) == null ? 0 : stateStore.signIns(jSONObjectResolve).length();
        int[] iArr = {200, 400, WebIndicator.DO_END_ANIMATION_DURATION, VipDiamond.MVP, 1000, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS};
        String[] strArr = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh"};
        JSONObject jSONObject = new JSONObject();
        int i = length % 7;
        int i2 = 0;
        while (i2 < 7) {
            int i3 = i2 + 1;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", i3);
            jSONObject2.put("dailyId", i3);
            jSONObject2.put("name", "Day " + i3);
            jSONObject2.put(FirebaseAnalytics.Param.QUANTITY, iArr[i2]);
            int i4 = 2;
            if (i2 >= i) {
                if (i2 != i) {
                    i4 = 0;
                } else if (!zHasSignedIn) {
                    i4 = 1;
                }
            }
            jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i4);
            jSONObject2.put("type", StringConstant.CHRISTMAS_GOLDS);
            jSONObject2.put("url", "");
            jSONObject2.put("adQuantity", 0);
            jSONObject2.put("adType", "");
            jSONObject.put(strArr[i2], jSONObject2);
            i2 = i3;
        }
        return envelope("obj", jSONObject.toString());
    }

    private static String clickSignIn(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String str = today();
        if (stateStore.hasSignedIn(jSONObjectRequireUser, str)) {
            return failCode(7012, "already claimed today");
        }
        long j = new int[]{200, 400, WebIndicator.DO_END_ANIMATION_DURATION, VipDiamond.MVP, 1000, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS}[(stateStore.signIns(jSONObjectRequireUser) == null ? 0 : stateStore.signIns(jSONObjectRequireUser).length()) % 7];
        stateStore.markSignedIn(jSONObjectRequireUser, str);
        stateStore.award(jSONObjectRequireUser, StringConstant.CHRISTMAS_GOLDS, j);
        L.i("sign-in: userId=" + jSONObjectRequireUser.optLong("userId") + " +" + j + " golds");
        return envelope("none", null);
    }

    private static String getAdsReward(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String str = today();
        if (stateStore.adRewardCount(jSONObjectRequireUser, str) < 5) {
            stateStore.countAdReward(jSONObjectRequireUser, str);
            stateStore.award(jSONObjectRequireUser, StringConstant.CHRISTMAS_GOLDS, 200L);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", jSONObjectRequireUser.optLong("userId"));
        jSONObject.put("currency", 2);
        jSONObject.put(StringConstant.CHRISTMAS_GOLDS, jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_GOLDS));
        jSONObject.put(StringConstant.CHRISTMAS_DIAMONDS, jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_DIAMONDS));
        jSONObject.put("gDiamonds", jSONObjectRequireUser.optLong("gDiamonds"));
        jSONObject.put("gDiamondsProfit", 0);
        jSONObject.put("money", 0);
        jSONObject.put("rewardQuantity", 200);
        return envelope("obj", jSONObject.toString());
    }

    private static String getSignAdsReward(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String str = today();
        int iAdRewardCount = stateStore.adRewardCount(jSONObjectRequireUser, str);
        long j = iAdRewardCount < 3 ? 300 : 0;
        if (iAdRewardCount < 3) {
            stateStore.countAdReward(jSONObjectRequireUser, str);
            stateStore.award(jSONObjectRequireUser, StringConstant.CHRISTMAS_GOLDS, j);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("picUrl", "");
        jSONObject.put(FirebaseAnalytics.Param.QUANTITY, j);
        return envelope("obj", jSONObject.toString());
    }

    private static String friendRecommendation(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("users");
        JSONArray jSONArrayNames = jSONObjectOptJSONObject.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length() && jSONArray.length() < 20; i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(jSONArrayNames.optString(i));
                if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.optLong("userId") != jSONObjectResolve.optLong("userId")) {
                    jSONArray.put(recommendRow(jSONObjectOptJSONObject2.optLong("userId"), jSONObjectOptJSONObject2.optString("nickName"), jSONObjectOptJSONObject2.optInt("sex"), "", jSONObjectOptJSONObject2.optInt("vip")));
                }
            }
        }
        JSONArray jSONArrayCitizens = GameCatalog.citizens(stateStore);
        for (int i2 = 0; i2 < jSONArrayCitizens.length() && jSONArray.length() < 30; i2++) {
            JSONObject jSONObject = jSONArrayCitizens.getJSONObject(i2);
            jSONArray.put(recommendRow(jSONObject.optLong("userId"), jSONObject.optString("nickName"), jSONObject.optInt("sex"), jSONObject.optString("country"), jSONObject.optInt("vip")));
        }
        return envelope("list", jSONArray.toString());
    }

    private static JSONObject recommendRow(long j, String str, int i, String str2, int i2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", j);
        jSONObject.put("nickName", str);
        jSONObject.put("headPic", "");
        jSONObject.put("sex", i);
        jSONObject.put("country", str2);
        jSONObject.put(au.M, "en");
        jSONObject.put("vip", i2);
        jSONObject.put("gameId", new JSONArray());
        jSONObject.put("likeGames", new JSONArray());
        jSONObject.put("togetherGames", new JSONArray());
        jSONObject.put("searchById", false);
        return jSONObject;
    }

    private static String getVipInfo(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("vip", jSONObjectResolve.optInt("vip"));
        jSONObject.put("expireDate", jSONObjectResolve.optString("expireDate"));
        jSONObject.put("gDiamonds", jSONObjectResolve.optLong("gDiamonds"));
        return envelope("obj", jSONObject.toString());
    }

    private static String getSubscribeInfo(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("vip", jSONObjectResolve.optInt("vip"));
        jSONObject.put("expireDate", jSONObjectResolve.optString("expireDate"));
        String[] strArr = {"1", "2", "3", VipSubscribeStatus.SUBSCRIPTION_PURCHASED};
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            jSONObject.put("vip" + str + "ExpiredAt", "");
            jSONObject.put("vip" + str + "ExpiredAtStr", "");
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("playerInfo", jSONObject);
        jSONObject2.put("subInfo", new JSONArray());
        return envelope("obj", jSONObject2.toString());
    }

    private static String dressList(Ctx ctx, StateStore stateStore) {
        long j = parseLong(ctx.pathParam("typeId"), 0L);
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONArray jSONArrayEnsureType = DressShop.ensureType(stateStore, j);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayEnsureType.length(); i++) {
            jSONArray.put(DressShop.singleJson(stateStore, jSONObjectResolve, jSONArrayEnsureType.getJSONObject(i)));
        }
        return envelope("list", jSONArray.toString());
    }

    private static String friendUsingList(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectFindByUserId = stateStore.findByUserId(parseLong(ctx.pathParam("otherId"), 0L));
        if (jSONObjectFindByUserId == null) {
            jSONObjectFindByUserId = stateStore.findOrCreateByKey("ghost", true);
        }
        return envelope("list", DressShop.usingList(stateStore, jSONObjectFindByUserId).toString());
    }

    private static String dressSuitList(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectFindByUserId;
        long j = parseLong(ctx.pathParam("userId"), 0L);
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        if (j != 0 && j != jSONObjectResolve.optLong("userId") && (jSONObjectFindByUserId = stateStore.findByUserId(j)) != null) {
            jSONObjectResolve = jSONObjectFindByUserId;
        }
        Suits.ensureSuits(stateStore);
        JSONArray jSONArrayOwnedSuits = Suits.ownedSuits(stateStore, jSONObjectResolve);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayOwnedSuits.length(); i++) {
            JSONObject jSONObjectById = Suits.byId(stateStore, jSONArrayOwnedSuits.optLong(i));
            if (jSONObjectById != null) {
                jSONArray.put(Suits.suitJson(stateStore, jSONObjectResolve, jSONObjectById));
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String giftSuitCanReceive(Ctx ctx, StateStore stateStore) {
        return bool(!Suits.giftClaimed(stateStore, stateStore.resolve(ctx.header("access-token"), ctx.header("userid"))));
    }

    private static String shopSuitList(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        Suits.ensureSuits(stateStore);
        JSONArray jSONArrayOptJSONArray = stateStore.root().optJSONArray("suits");
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                jSONArray.put(Suits.suitJson(stateStore, jSONObjectResolve, jSONObjectOptJSONObject));
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String suitListByIds(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        Suits.ensureSuits(stateStore);
        List<String> listQueryValues = ctx.queryValues("suitIds");
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = listQueryValues.iterator();
        while (it.hasNext()) {
            JSONObject jSONObjectById = Suits.byId(stateStore, parseLong(it.next(), 0L));
            if (jSONObjectById != null) {
                jSONArray.put(Suits.suitJson(stateStore, jSONObjectResolve, jSONObjectById));
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String suitDetail(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONObject jSONObjectById = Suits.byId(stateStore, parseLong(ctx.pathParam("suitId"), 0L));
        if (jSONObjectById == null) {
            return fail("suit not found");
        }
        return envelope("obj", Suits.suitJson(stateStore, jSONObjectResolve, jSONObjectById).toString());
    }

    private static String suitGiftInfo(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        if (Suits.giftClaimed(stateStore, jSONObjectResolve)) {
            return envelope("obj", "{}");
        }
        return envelope("obj", Suits.suitJson(stateStore, jSONObjectResolve, Suits.giftSuit(stateStore)).toString());
    }

    private static String suitGiftReceive(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        if (Suits.giftClaimed(stateStore, jSONObjectRequireUser)) {
            return fail("gift suit already claimed");
        }
        JSONObject jSONObjectGiftSuit = Suits.giftSuit(stateStore);
        Suits.markGiftClaimed(stateStore, jSONObjectRequireUser);
        Suits.markOwned(stateStore, jSONObjectRequireUser, jSONObjectGiftSuit.optLong("suitId"));
        JSONArray jSONArrayOptJSONArray = jSONObjectGiftSuit.optJSONArray("dressIds");
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            DressShop.markOwned(stateStore, jSONObjectRequireUser, jSONArrayOptJSONArray.optLong(i));
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArrayOptJSONArray2 = jSONObjectGiftSuit.optJSONArray("dressIds");
        for (int i2 = 0; jSONArrayOptJSONArray2 != null && i2 < jSONArrayOptJSONArray2.length(); i2++) {
            JSONObject jSONObjectById = DressShop.byId(stateStore, jSONArrayOptJSONArray2.optLong(i2));
            if (jSONObjectById != null) {
                jSONArray.put(DressShop.singleJson(stateStore, jSONObjectRequireUser, jSONObjectById));
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String uploadFile(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        byte[] bArrFileBytes = ctx.fileBytes();
        if (bArrFileBytes == null || bArrFileBytes.length == 0) {
            return fail("multipart file part missing");
        }
        String strStoreFile = stateStore.storeFile(bArrFileBytes, ctx.query("fileName"), ctx.query("fileType"), jSONObjectResolve.optLong("userId"));
        if (strStoreFile == null) {
            return fail("file store failed");
        }
        return envelope("str", "\"http://127.0.0.1:18080/files/" + strStoreFile + "\"");
    }

    private static String sensitiveWords(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("config");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optJSONArray("sensitiveWords");
        if (jSONArrayOptJSONArray == null) {
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
                stateStore.root().put("config", jSONObjectOptJSONObject);
            }
            JSONArray jSONArray = new JSONArray();
            String[] strArr = {"admin", "moderator", "official", "system", "support", "nexus", "blockman"};
            for (int i = 0; i < 7; i++) {
                jSONArray.put(strArr[i]);
            }
            jSONObjectOptJSONObject.put("sensitiveWords", jSONArray);
            stateStore.save();
            jSONArrayOptJSONArray = jSONArray;
        }
        return envelope("list", jSONArrayOptJSONArray.toString());
    }

    private static String dressOwnedByType(Ctx ctx, StateStore stateStore) throws JSONException {
        long j = parseLong(ctx.pathParam("typeId"), 0L);
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONArray jSONArrayEnsureType = DressShop.ensureType(stateStore, j);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayEnsureType.length(); i++) {
            JSONObject jSONObject = jSONArrayEnsureType.getJSONObject(i);
            if (DressShop.owned(stateStore, jSONObjectResolve, jSONObject.optLong("id"))) {
                jSONArray.put(DressShop.singleJson(stateStore, jSONObjectResolve, jSONObject));
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String dressRecommend(Ctx ctx, StateStore stateStore) throws JSONException {
        long j = parseLong(ctx.pathParam("typeId"), 0L);
        boolean zEqualsIgnoreCase = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(ctx.query("isSuit"));
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        String str = "list";
        if (zEqualsIgnoreCase) {
            Suits.ensureSuits(stateStore);
            JSONArray jSONArrayOptJSONArray = stateStore.root().optJSONArray("suits");
            JSONArray jSONArray = new JSONArray();
            if (jSONArrayOptJSONArray != null) {
                int i = 0;
                for (int i2 = 5; i < jSONArrayOptJSONArray.length() && jSONArray.length() < i2; i2 = 5) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        String str2 = str;
                        if (Suits.owned(stateStore, jSONObjectResolve, jSONObjectOptJSONObject.optLong("suitId"))) {
                            str = str2;
                        } else {
                            JSONObject jSONObject = new JSONObject();
                            str = str2;
                            jSONObject.put("id", jSONObjectOptJSONObject.optLong("suitId"));
                            jSONObject.put("iconUrl", jSONObjectOptJSONObject.optString("iconUrl", ""));
                            jSONObject.put("hasPurchase", 0);
                            jSONObject.put("isNew", jSONObjectOptJSONObject.optInt("isNew"));
                            jSONObject.put("shopSuitDecorationInfo", Suits.suitJson(stateStore, jSONObjectResolve, jSONObjectOptJSONObject));
                            jSONArray.put(jSONObject);
                        }
                    }
                    i++;
                }
            }
            return envelope(str, jSONArray.toString());
        }
        JSONArray jSONArrayEnsureType = DressShop.ensureType(stateStore, j);
        JSONArray jSONArray2 = new JSONArray();
        for (int i3 = 0; i3 < jSONArrayEnsureType.length() && jSONArray2.length() < 5; i3++) {
            JSONObject jSONObject2 = jSONArrayEnsureType.getJSONObject(i3);
            if (!DressShop.owned(stateStore, jSONObjectResolve, jSONObject2.optLong("id"))) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", jSONObject2.optLong("id"));
                jSONObject3.put("iconUrl", "");
                jSONObject3.put("hasPurchase", 0);
                jSONObject3.put("isNew", jSONObject2.optInt("isNew"));
                jSONObject3.put("shopDecorationInfo", DressShop.singleJson(stateStore, jSONObjectResolve, jSONObject2));
                jSONArray2.put(jSONObject3);
            }
        }
        return envelope("list", jSONArray2.toString());
    }

    private static String isUsingList(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve;
        long j = parseLong(ctx.query("otherId"), 0L);
        if (j > 0) {
            jSONObjectResolve = stateStore.findByUserId(j) != null ? stateStore.findByUserId(j) : stateStore.findOrCreateByKey("ghost", true);
        } else {
            jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        }
        return envelope("list", DressShop.usingList(stateStore, jSONObjectResolve).toString());
    }

    private static JSONArray csvIds(String str) {
        JSONArray jSONArray = new JSONArray();
        if (str != null) {
            for (String str2 : str.split(",")) {
                long j = parseLong(str2.trim(), 0L);
                if (j > 0) {
                    jSONArray.put(j);
                }
            }
        }
        return jSONArray;
    }

    private static String multiClothe(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONArray jSONArrayCsvIds = csvIds(ctx.query("ids"));
        DressShop.setUsing(stateStore, jSONObjectResolve, jSONArrayCsvIds, true);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayCsvIds.length(); i++) {
            JSONObject jSONObjectById = DressShop.byId(stateStore, jSONArrayCsvIds.optLong(i));
            if (jSONObjectById != null) {
                jSONArray.put(DressShop.singleJson(stateStore, jSONObjectResolve, jSONObjectById));
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String multiUnclothe(Ctx ctx, StateStore stateStore) {
        DressShop.setUsing(stateStore, stateStore.resolve(ctx.header("access-token"), ctx.header("userid")), csvIds(ctx.query("ids")), false);
        return envelope("obj", null);
    }

    private static String removeDecoration(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        long j = parseLong(ctx.pathParam("decorationId"), 0L);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(j);
        DressShop.setUsing(stateStore, jSONObjectResolve, jSONArray, false);
        JSONObject jSONObjectById = DressShop.byId(stateStore, j);
        if (jSONObjectById == null) {
            return fail("decoration not found");
        }
        return envelope("obj", DressShop.singleJson(stateStore, jSONObjectResolve, jSONObjectById).toString());
    }

    private static String removeSuitDecoration(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONArray jSONArrayCsvIds = csvIds(ctx.query("ids"));
        DressShop.setUsing(stateStore, jSONObjectResolve, jSONArrayCsvIds, false);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayCsvIds.length(); i++) {
            JSONObject jSONObjectById = DressShop.byId(stateStore, jSONArrayCsvIds.optLong(i));
            if (jSONObjectById != null) {
                jSONArray.put(DressShop.singleJson(stateStore, jSONObjectResolve, jSONObjectById));
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String useDecoration(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        long j = parseLong(ctx.pathParam("decorationId"), 0L);
        if (!DressShop.owned(stateStore, jSONObjectRequireUser, j)) {
            return fail("decoration not owned");
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(j);
        DressShop.setUsing(stateStore, jSONObjectRequireUser, jSONArray, true);
        return envelope("obj", DressShop.singleJson(stateStore, jSONObjectRequireUser, DressShop.byId(stateStore, j)).toString());
    }

    private static String useSuitDecoration(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONArray jSONArrayCsvIds = csvIds(ctx.query("ids"));
        for (int i = 0; i < jSONArrayCsvIds.length(); i++) {
            if (!DressShop.owned(stateStore, jSONObjectRequireUser, jSONArrayCsvIds.optLong(i))) {
                return fail("decoration not owned: " + jSONArrayCsvIds.optLong(i));
            }
        }
        DressShop.setUsing(stateStore, jSONObjectRequireUser, jSONArrayCsvIds, true);
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < jSONArrayCsvIds.length(); i2++) {
            JSONObject jSONObjectById = DressShop.byId(stateStore, jSONArrayCsvIds.optLong(i2));
            if (jSONObjectById != null) {
                jSONArray.put(DressShop.singleJson(stateStore, jSONObjectRequireUser, jSONObjectById));
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String dressBuyOne(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        if (!DressShop.buy(stateStore, jSONObjectRequireUser, parseLong(ctx.pathParam("decorationId"), 0L))) {
            return fail("insufficient currency or unknown decoration");
        }
        return envelope("none", null);
    }

    private static String dressBuyMany(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONArray jSONArrayCsvIds = csvIds(ctx.query("decorationId"));
        JSONArray jSONArray = new JSONArray();
        long jOptLong = 0;
        long jOptLong2 = 0;
        for (int i = 0; i < jSONArrayCsvIds.length(); i++) {
            JSONObject jSONObjectById = DressShop.byId(stateStore, jSONArrayCsvIds.optLong(i));
            if (jSONObjectById != null) {
                if (jSONObjectById.optInt("currency") == 2) {
                    jOptLong += jSONObjectById.optLong("price");
                } else {
                    jOptLong2 += jSONObjectById.optLong("price");
                }
            }
        }
        if (jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_GOLDS) >= jOptLong && jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_DIAMONDS) >= jOptLong2) {
            for (int i2 = 0; i2 < jSONArrayCsvIds.length(); i2++) {
                if (DressShop.buy(stateStore, jSONObjectRequireUser, jSONArrayCsvIds.optLong(i2))) {
                    jSONArray.put(jSONArrayCsvIds.optLong(i2));
                }
            }
        }
        return envelope("obj", DressShop.buyResponse(jSONArrayCsvIds, jSONArray, jOptLong, jOptLong2).toString());
    }

    private static String dressBuyV2(Ctx ctx, StateStore stateStore) throws JSONException {
        boolean z;
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        JSONArray jSONArrayOptJSONArray = jSONObjectBody.optJSONArray("buyDecorationList");
        JSONArray jSONArray = new JSONArray();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                jSONArray.put(jSONArrayOptJSONArray.optJSONObject(i).optLong("decorationId"));
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObjectBody.optJSONArray("buySuitList");
        JSONArray jSONArray2 = new JSONArray();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                jSONArray2.put(jSONArrayOptJSONArray2.optJSONObject(i2).optLong("suitId"));
            }
        }
        JSONArray jSONArray3 = new JSONArray();
        long jOptLong = 0;
        long jOptLong2 = 0;
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            long j = jOptLong2;
            JSONObject jSONObjectById = DressShop.byId(stateStore, jSONArray.optLong(i3));
            if (jSONObjectById == null) {
                jOptLong2 = j;
            } else if (jSONObjectById.optInt("currency") == 2) {
                jOptLong += jSONObjectById.optLong("price");
                jOptLong2 = j;
            } else {
                jOptLong2 = j + jSONObjectById.optLong("price");
            }
        }
        int i4 = 0;
        long jOptLong3 = 0;
        long jOptLong4 = 0;
        while (i4 < jSONArray2.length()) {
            long j2 = jOptLong2;
            JSONObject jSONObjectById2 = Suits.byId(stateStore, jSONArray2.optLong(i4));
            if (jSONObjectById2 != null) {
                if (jSONObjectById2.optInt("currency") == 2) {
                    jOptLong3 += jSONObjectById2.optLong("price");
                } else {
                    jOptLong4 += jSONObjectById2.optLong("price");
                }
            }
            i4++;
            jOptLong2 = j2;
        }
        long j3 = jOptLong + jOptLong3;
        if (jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_GOLDS) >= j3 && jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_DIAMONDS) >= jOptLong2 + jOptLong4) {
            int i5 = 0;
            while (i5 < jSONArray.length()) {
                long j4 = jOptLong2;
                if (DressShop.buy(stateStore, jSONObjectRequireUser, jSONArray.optLong(i5))) {
                    jSONArray3.put(jSONArray.optLong(i5));
                }
                i5++;
                jOptLong2 = j4;
            }
            int i6 = 0;
            while (i6 < jSONArray2.length()) {
                long j5 = jOptLong2;
                if (Suits.buy(stateStore, jSONObjectRequireUser, jSONArray2.optLong(i6))) {
                    jSONArray3.put(jSONArray2.optLong(i6));
                }
                i6++;
                jOptLong2 = j5;
            }
        }
        long j6 = jOptLong2;
        JSONObject jSONObjectBuyResponse = DressShop.buyResponse(jSONArray, jSONArray3, jOptLong, j6);
        JSONObject jSONObject = new JSONObject();
        for (int i7 = 0; i7 < jSONArray2.length(); i7++) {
            int i8 = 0;
            while (true) {
                if (i8 >= jSONArray3.length()) {
                    z = false;
                    break;
                }
                if (jSONArray3.optLong(i8) == jSONArray2.optLong(i7)) {
                    z = true;
                    break;
                }
                i8++;
            }
            jSONObject.put(String.valueOf(jSONArray2.optLong(i7)), z);
        }
        jSONObjectBuyResponse.put("suitPurchaseStatus", jSONObject);
        jSONObjectBuyResponse.put("goldsNeed", j3);
        jSONObjectBuyResponse.put("diamondsNeed", j6 + jOptLong4);
        return envelope("obj", jSONObjectBuyResponse.toString());
    }

    private static String dressDetails(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONObject jSONObjectById = DressShop.byId(stateStore, parseLong(ctx.pathParam("decorationId"), 0L));
        if (jSONObjectById == null) {
            return fail("decoration not found");
        }
        return envelope("obj", DressShop.singleJson(stateStore, jSONObjectResolve, jSONObjectById).toString());
    }

    private static String dressRecommendList(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONObject jSONObjectById = DressShop.byId(stateStore, parseLong(ctx.pathParam("decorationId"), 0L));
        JSONArray jSONArrayEnsureType = DressShop.ensureType(stateStore, jSONObjectById != null ? jSONObjectById.optLong("typeId") : 0L);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayEnsureType.length() && jSONArray.length() < 6; i++) {
            JSONObject jSONObject = jSONArrayEnsureType.getJSONObject(i);
            if (jSONObject.optLong("id") != (jSONObjectById == null ? -1L : jSONObjectById.optLong("id"))) {
                jSONArray.put(DressShop.singleJson(stateStore, jSONObjectResolve, jSONObject));
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String shopList(Ctx ctx, StateStore stateStore) {
        return dressList(ctx, stateStore);
    }

    private static String shopRecommendV2(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONArray jSONArrayNames;
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("dresses");
        JSONArray jSONArray = new JSONArray();
        if (jSONObjectOptJSONObject != null && (jSONArrayNames = jSONObjectOptJSONObject.names()) != null) {
            for (int i = 0; i < jSONArrayNames.length() && jSONArray.length() < 6; i++) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(jSONArrayNames.optString(i));
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                    JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(0);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", jSONObject.optLong("id"));
                    jSONObject2.put("iconUrl", "");
                    jSONObject2.put("hasPurchase", 0);
                    jSONObject2.put("isNew", jSONObject.optInt("isNew"));
                    jSONObject2.put("shopDecorationInfo", DressShop.singleJson(stateStore, jSONObjectResolve, jSONObject));
                    jSONArray.put(jSONObject2);
                }
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String scrapBackpack(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectBackpack = ScrapBag.backpack(stateStore, stateStore.resolve(ctx.header("access-token"), ctx.header("userid")));
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArrayNames = jSONObjectBackpack.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                String strOptString = jSONArrayNames.optString(i);
                int iOptInt = jSONObjectBackpack.optInt(strOptString);
                if (iOptInt > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("scrapId", strOptString);
                    jSONObject.put("scrapName", "Scrap " + strOptString.toUpperCase());
                    jSONObject.put("scrapDesc", "A fragment used for exchange.");
                    jSONObject.put("scrapPic", "");
                    jSONObject.put("scrapLevel", 1);
                    jSONObject.put("scrapType", 1);
                    jSONObject.put("scrapValue", ScrapBag.valueOf(strOptString));
                    jSONObject.put("amount", iOptInt);
                    jSONObject.put("rewardType", 1);
                    jSONArray.put(jSONObject);
                }
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", jSONArray);
        jSONObject2.put("pageNo", 1);
        jSONObject2.put("pageSize", 20);
        jSONObject2.put("totalPage", 1);
        jSONObject2.put("totalSize", jSONArray.length());
        return envelope("obj", jSONObject2.toString());
    }

    private static String scrapRequestTargets(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONArray jSONArrayCitizens = GameCatalog.citizens(stateStore);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayCitizens.length() && jSONArray.length() < 10; i++) {
            JSONObject jSONObject = jSONArrayCitizens.getJSONObject(i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("friendId", jSONObject.optLong("userId"));
            jSONObject2.put("friendName", jSONObject.optString("nickName"));
            jSONObject2.put("friendPic", "");
            jSONObject2.put("helpStatus", 0);
            jSONObject2.put("scrapNum", (i % 3) + 1);
            jSONArray.put(jSONObject2);
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("data", jSONArray);
        jSONObject3.put("pageNo", 1);
        jSONObject3.put("pageSize", 10);
        jSONObject3.put("totalPage", 1);
        jSONObject3.put("totalSize", jSONArray.length());
        return envelope("obj", jSONObject3.toString());
    }

    private static String scrapBagValue(Ctx ctx, StateStore stateStore) {
        return envelope("num", String.valueOf(ScrapBag.bagValue(stateStore, stateStore.resolve(ctx.header("access-token"), ctx.header("userid")))));
    }

    private static String scrapHistory(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONArray jSONArrayOptJSONArray = stateStore.userState(stateStore.resolve(ctx.header("access-token"), ctx.header("userid"))).optJSONArray("combineHistory");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", jSONArrayOptJSONArray);
        jSONObject.put("pageNo", 1);
        jSONObject.put("pageSize", 20);
        jSONObject.put("totalPage", jSONArrayOptJSONArray.length() <= 0 ? 0 : 1);
        jSONObject.put("totalSize", jSONArrayOptJSONArray.length());
        return envelope("obj", jSONObject.toString());
    }

    private static String scrapNum(Ctx ctx, StateStore stateStore) {
        return envelope("num", String.valueOf(ScrapBag.scrapNum(stateStore, stateStore.resolve(ctx.header("access-token"), ctx.header("userid")), ctx.pathParam("scrapId"))));
    }

    private static String scrapCardDetails(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectCard = ScrapBag.card(ctx.query("cardId"));
        if (jSONObjectCard == null) {
            return fail("card not found");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cardName", jSONObjectCard.optString("cardName"));
        jSONObject.put("cardDesc", "Collect the listed scraps, then combine.");
        jSONObject.put("cardPic", "");
        jSONObject.put("cardValue", jSONObjectCard.optInt("cardValue"));
        jSONObject.put("scrapResponses", jSONObjectCard.optJSONArray("needs"));
        return envelope("obj", jSONObject.toString());
    }

    private static String scrapCardList(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 1; i <= 6; i++) {
            JSONObject jSONObjectCard = ScrapBag.card("c" + i);
            if (jSONObjectCard != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cardId", jSONObjectCard.optString("cardId"));
                jSONObject.put("cardName", jSONObjectCard.optString("cardName"));
                jSONObject.put("cardPic", "");
                jSONObject.put("cardProgress", "0/" + jSONObjectCard.optJSONArray("needs").optJSONObject(0).optInt("scrapNum"));
                jSONObject.put("cardQuality", jSONObjectCard.optInt("cardQuality"));
                jSONObject.put("cardRewardType", 1);
                jSONObject.put("rewardExpires", 0);
                jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
                jSONArray.put(jSONObject);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", jSONArray);
        jSONObject2.put("pageNo", 1);
        jSONObject2.put("pageSize", 20);
        jSONObject2.put("totalPage", 1);
        jSONObject2.put("totalSize", jSONArray.length());
        return envelope("obj", jSONObject2.toString());
    }

    private static String scrapCombineCard(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strQuery = ctx.query("cardId");
        int i = (int) parseLong(ctx.query("amount"), 1L);
        if (ScrapBag.card(strQuery) == null) {
            return failCode(10107, "card does not exist");
        }
        if (i < 1) {
            return failCode(10105, "invalid combine amount");
        }
        JSONObject jSONObjectCombine = ScrapBag.combine(stateStore, jSONObjectRequireUser, strQuery, i);
        if (jSONObjectCombine == null) {
            return failCode(10106, "not enough scraps");
        }
        return envelope("obj", jSONObjectCombine.toString());
    }

    private static String scrapSend(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strQuery = ctx.query("scrapId");
        if (ScrapBag.scrapNum(stateStore, jSONObjectRequireUser, strQuery) < 1) {
            return failCode(10104, "no scrap to send");
        }
        ScrapBag.addScrap(stateStore, jSONObjectRequireUser, strQuery, -1);
        return envelope("str", JSONObject.quote("send-" + Long.toHexString(System.nanoTime())));
    }

    private static String rankingPage(String str, Ctx ctx, StateStore stateStore) throws JSONException {
        int i;
        String str2;
        String str3;
        String str4;
        int i2;
        JSONObject jSONObject;
        String str5;
        JSONArray jSONArray;
        boolean z;
        int i3;
        String str6;
        int i4 = (int) parseLong(ctx.query("pageNo"), 1L);
        int i5 = (int) parseLong(ctx.query("pageSize"), 20L);
        String strPath = ctx.path() == null ? "" : ctx.path();
        String strSubstring = strPath.startsWith("/ranking/api/v1/") ? strPath.substring(16) : AppMeasurementSdk.ConditionalUserProperty.ACTIVE;
        if (strSubstring.endsWith("/rank")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 5);
        }
        boolean zContains = strSubstring.contains("weekly");
        JSONArray jSONArray2 = new JSONArray();
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("users");
        JSONArray jSONArrayNames = jSONObjectOptJSONObject.names();
        String str7 = "gold/diamond";
        String str8 = "pageNo";
        if (jSONArrayNames != null) {
            str3 = "pageSize";
            int i6 = 0;
            while (i6 < jSONArrayNames.length()) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(jSONArrayNames.optString(i6));
                if (jSONObjectOptJSONObject2 == null) {
                    i3 = i4;
                    str6 = str7;
                    z = zContains;
                    jSONObject = jSONObjectOptJSONObject;
                    jSONArray = jSONArrayNames;
                } else {
                    if (strSubstring.contains(str7)) {
                        jSONObject = jSONObjectOptJSONObject;
                        str5 = StringConstant.CHRISTMAS_DIAMONDS;
                    } else {
                        jSONObject = jSONObjectOptJSONObject;
                        str5 = StringConstant.CHRISTMAS_GOLDS;
                    }
                    long jOptLong = jSONObjectOptJSONObject2.optLong(str5);
                    if (zContains) {
                        jOptLong = (jOptLong / 7) + 10;
                    }
                    jSONArray = jSONArrayNames;
                    long j = jOptLong;
                    z = zContains;
                    JSONObject jSONObject2 = new JSONObject();
                    i3 = i4;
                    str6 = str7;
                    jSONObject2.put("id", jSONObjectOptJSONObject2.optLong("userId"));
                    jSONObject2.put("name", jSONObjectOptJSONObject2.optString("nickName"));
                    jSONObject2.put("pic", jSONObjectOptJSONObject2.optString("picUrl"));
                    jSONObject2.put(FirebaseAnalytics.Param.QUANTITY, j);
                    jSONArray2.put(jSONObject2);
                }
                i6++;
                jSONObjectOptJSONObject = jSONObject;
                zContains = z;
                i4 = i3;
                jSONArrayNames = jSONArray;
                str7 = str6;
            }
            i = i4;
            str2 = str7;
        } else {
            i = i4;
            str2 = "gold/diamond";
            str3 = "pageSize";
        }
        boolean z2 = zContains;
        JSONArray jSONArrayCitizens = GameCatalog.citizens(stateStore);
        int iAbs = Math.abs(strSubstring.hashCode());
        int i7 = 0;
        while (i7 < jSONArrayCitizens.length()) {
            String str9 = str3;
            String str10 = str8;
            int i8 = i;
            JSONObject jSONObject3 = jSONArrayCitizens.getJSONObject(i7);
            JSONArray jSONArray3 = jSONArrayCitizens;
            String str11 = str2;
            if (strSubstring.contains(str11)) {
                str4 = strSubstring;
                str2 = str11;
                i2 = 40000;
            } else {
                str4 = strSubstring;
                str2 = str11;
                i2 = 9000;
            }
            long j2 = i2;
            i = i8;
            long j3 = (j2 - (((long) ((i7 * 977) + iAbs)) % j2)) + ((long) (z2 ? 0 : i7));
            if (j3 < 1) {
                j3 = 1;
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("id", jSONObject3.optLong("userId"));
            jSONObject4.put("name", jSONObject3.optString("nickName"));
            jSONObject4.put("pic", jSONObject3.optString("headPic"));
            jSONObject4.put(FirebaseAnalytics.Param.QUANTITY, j3);
            jSONArray2.put(jSONObject4);
            i7++;
            jSONArrayCitizens = jSONArray3;
            strSubstring = str4;
            i5 = i5;
            str8 = str10;
            str3 = str9;
        }
        int i9 = 1;
        while (i9 < jSONArray2.length()) {
            String str12 = str3;
            String str13 = str8;
            int i10 = i;
            JSONObject jSONObject5 = jSONArray2.getJSONObject(i9);
            int i11 = i9 - 1;
            while (i11 >= 0 && jSONArray2.getJSONObject(i11).optLong(FirebaseAnalytics.Param.QUANTITY) < jSONObject5.optLong(FirebaseAnalytics.Param.QUANTITY)) {
                jSONArray2.put(i11 + 1, jSONArray2.getJSONObject(i11));
                i11--;
            }
            jSONArray2.put(i11 + 1, jSONObject5);
            i9++;
            i = i10;
            str8 = str13;
            str3 = str12;
        }
        int i12 = 0;
        while (i12 < jSONArray2.length()) {
            JSONObject jSONObject6 = jSONArray2.getJSONObject(i12);
            i12++;
            jSONObject6.put("rank", i12);
        }
        int i13 = i;
        JSONArray jSONArraySlice = slice(jSONArray2, i13, i5);
        JSONObject jSONObject7 = new JSONObject();
        jSONObject7.put("data", jSONArraySlice);
        jSONObject7.put(str8, i13);
        jSONObject7.put(str3, i5);
        jSONObject7.put("totalPage", totalPages(jSONArray2.length(), i5));
        jSONObject7.put("totalSize", jSONArray2.length());
        return envelope("obj", jSONObject7.toString());
    }

    private static String frequentlyGames(Ctx ctx, StateStore stateStore) {
        JSONArray jSONArrayRecentGames = stateStore.recentGames(stateStore.resolve(ctx.header("access-token"), ctx.header("userid")), 8);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayRecentGames.length(); i++) {
            JSONObject jSONObjectById = GameCatalog.byId(stateStore, jSONArrayRecentGames.optString(i));
            if (jSONObjectById != null) {
                jSONArray.put(jSONObjectById);
            }
        }
        if (jSONArray.length() == 0) {
            jSONArray = GameCatalog.page(stateStore, StringConstant.GAME_ORDER_TYPE_ONLINE, 0L, false, 1, 8);
        }
        return envelope("list", jSONArray.toString());
    }

    private static String teamMembers(Ctx ctx, StateStore stateStore) throws JSONException {
        long j = parseLong(ctx.pathParam("teamId"), 0L);
        JSONArray jSONArrayCitizens = GameCatalog.citizens(stateStore);
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (i < jSONArrayCitizens.length() && jSONArray.length() < 8) {
            JSONObject jSONObject = jSONArrayCitizens.getJSONObject(i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("userId", jSONObject.optLong("userId"));
            jSONObject2.put("nickName", jSONObject.optString("nickName"));
            jSONObject2.put("headPic", jSONObject.optString("headPic"));
            jSONObject2.put("teamId", j);
            boolean z = true;
            jSONObject2.put("isTeam", i == 0 ? 1 : 0);
            jSONObject2.put("isAddFriend", 0);
            if (i != Math.min(8, jSONArrayCitizens.length()) - 1) {
                z = false;
            }
            jSONObject2.put("isLast", z);
            jSONArray.put(jSONObject2);
            i++;
        }
        return envelope("list", jSONArray.toString());
    }

    private static String wallet(Ctx ctx, StateStore stateStore) {
        return envelope("obj", rechargeEntity(stateStore.resolve(ctx.header("access-token"), ctx.header("userid")), 0L).toString());
    }

    private static JSONObject rechargeEntity(JSONObject jSONObject, long j) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userId", jSONObject.optLong("userId"));
        jSONObject2.put("currency", 1);
        jSONObject2.put(StringConstant.CHRISTMAS_GOLDS, jSONObject.optLong(StringConstant.CHRISTMAS_GOLDS));
        jSONObject2.put(StringConstant.CHRISTMAS_DIAMONDS, jSONObject.optLong(StringConstant.CHRISTMAS_DIAMONDS));
        jSONObject2.put("gDiamonds", jSONObject.optLong("gDiamonds"));
        jSONObject2.put("gDiamondsProfit", 0);
        jSONObject2.put("money", 0);
        jSONObject2.put("rewardQuantity", j);
        return jSONObject2;
    }

    private static String payHistory(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONArray jSONArrayOptJSONArray = stateStore.userState(stateStore.resolve(ctx.header("access-token"), ctx.header("userid"))).optJSONArray("payRecords");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", jSONArrayOptJSONArray);
        jSONObject.put("pageNo", 1);
        jSONObject.put("pageSize", 20);
        jSONObject.put("totalPage", jSONArrayOptJSONArray.length() <= 0 ? 0 : 1);
        jSONObject.put("totalSize", jSONArrayOptJSONArray.length());
        return envelope("obj", jSONObject.toString());
    }

    private static synchronized JSONArray ensureProducts(StateStore stateStore) {
        JSONArray jSONArrayOptJSONArray = stateStore.root().optJSONArray("products");
        if (jSONArrayOptJSONArray != null) {
            return jSONArrayOptJSONArray;
        }
        JSONArray jSONArray = new JSONArray();
        Object[][] objArr = {new Object[]{"local.golds.1", "Pouch of Golds", 2, 1000, Double.valueOf(0.99d), 0}, new Object[]{"local.golds.2", "Bag of Golds", 2, 5500, Double.valueOf(4.99d), 0}, new Object[]{"local.golds.3", "Chest of Golds", 2, 12000, Double.valueOf(9.99d), 500}, new Object[]{"local.diamonds.1", "Handful of Diamonds", 1, 80, Double.valueOf(0.99d), 0}, new Object[]{"local.diamonds.2", "Case of Diamonds", 1, 500, Double.valueOf(4.99d), 50}, new Object[]{"local.diamonds.3", "Vault of Diamonds", 1, 1200, Double.valueOf(9.99d), 120}, new Object[]{"local.vip.1", "VIP Level 1 (30 days)", 0, 0, Double.valueOf(2.99d), 0}, new Object[]{"local.vip.2", "VIP Level 2 (30 days)", 0, 0, Double.valueOf(4.99d), 0}};
        int i = 0;
        for (int i2 = 8; i < i2; i2 = 8) {
            Object[] objArr2 = objArr[i];
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", i + IntConstant.LINE_SIGN_IN);
            jSONObject.put("productId", (String) objArr2[0]);
            jSONObject.put("name", objArr2[1]);
            jSONObject.put("desc", "Local purchase — credits your wallet instantly.");
            jSONObject.put("currency", ((Integer) objArr2[2]).intValue());
            Object[][] objArr3 = objArr;
            jSONObject.put("price", ((Double) objArr2[4]).doubleValue());
            jSONObject.put(StringConstant.CHRISTMAS_DIAMONDS, ((Integer) objArr2[2]).intValue() == 1 ? ((Integer) objArr2[3]).intValue() : 0);
            jSONObject.put(StringConstant.CHRISTMAS_GOLDS, ((Integer) objArr2[2]).intValue() == 2 ? ((Integer) objArr2[3]).intValue() : 0);
            jSONObject.put("gift", ((Integer) objArr2[5]).intValue());
            jSONObject.put("month", ((String) objArr2[0]).startsWith("local.vip") ? 1 : 0);
            jSONObject.put(FirebaseAnalytics.Param.LEVEL, ((String) objArr2[0]).equals("local.vip.2") ? 2 : 1);
            jSONObject.put("isVip", ((String) objArr2[0]).startsWith("local.vip"));
            jSONObject.put("isFree", false);
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 1);
            jSONArray.put(jSONObject);
            i++;
            objArr = objArr3;
        }
        stateStore.root().put("products", jSONArray);
        stateStore.save();
        return jSONArray;
    }

    private static String products(Ctx ctx, StateStore stateStore) {
        return envelope("list", ensureProducts(stateStore).toString());
    }

    private static JSONObject requireUser(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectFindByToken = stateStore.findByToken(ctx.header("access-token"));
        if (jSONObjectFindByToken != null) {
            stateStore.tickActivityMinute(jSONObjectFindByToken, new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).format(new Date()));
        }
        return jSONObjectFindByToken;
    }

    private static String recharge(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strOptString = body(ctx).optString("sku");
        JSONArray jSONArrayEnsureProducts = ensureProducts(stateStore);
        int i = 0;
        while (true) {
            if (i >= jSONArrayEnsureProducts.length()) {
                jSONObject = null;
                break;
            }
            if (strOptString.equals(jSONArrayEnsureProducts.getJSONObject(i).optString("productId"))) {
                jSONObject = jSONArrayEnsureProducts.getJSONObject(i);
                break;
            }
            i++;
        }
        if (jSONObject == null) {
            return fail("unknown product: " + strOptString);
        }
        String str = StringConstant.CHRISTMAS_GOLDS;
        long jOptLong = jSONObject.optLong(StringConstant.CHRISTMAS_GOLDS) + jSONObject.optLong(StringConstant.CHRISTMAS_DIAMONDS);
        if (jSONObject.optInt("currency") != 2) {
            str = StringConstant.CHRISTMAS_DIAMONDS;
        }
        stateStore.award(jSONObjectRequireUser, str, jOptLong);
        stateStore.award(jSONObjectRequireUser, "gDiamonds", jSONObject.optLong("gift"));
        recordPay(stateStore, jSONObjectRequireUser, jSONObject, jOptLong);
        L.i("recharge: userId=" + jSONObjectRequireUser.optLong("userId") + " sku=" + strOptString + " +" + jOptLong);
        return envelope("obj", rechargeEntity(jSONObjectRequireUser, jOptLong).toString());
    }

    private static String rechargeVip(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strOptString = body(ctx).optString("sku");
        JSONArray jSONArrayEnsureProducts = ensureProducts(stateStore);
        for (int i = 0; i < jSONArrayEnsureProducts.length(); i++) {
            JSONObject jSONObject = jSONArrayEnsureProducts.getJSONObject(i);
            if (strOptString.equals(jSONObject.optString("productId"))) {
                jSONObjectRequireUser.put("vip", Math.max(jSONObjectRequireUser.optInt("vip"), jSONObject.optInt(FirebaseAnalytics.Param.LEVEL)));
                String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis() + 2592000000L));
                jSONObjectRequireUser.put("expireDate", str);
                stateStore.save();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("vip", jSONObjectRequireUser.optInt("vip"));
                jSONObject2.put("expireDate", str);
                jSONObject2.put("gDiamonds", jSONObjectRequireUser.optLong("gDiamonds"));
                recordPay(stateStore, jSONObjectRequireUser, jSONObject, 0L);
                return envelope("obj", jSONObject2.toString());
            }
        }
        return fail("unknown product: " + strOptString);
    }

    private static void recordPay(StateStore stateStore, JSONObject jSONObject, JSONObject jSONObject2, long j) throws JSONException {
        JSONObject jSONObjectUserState = stateStore.userState(jSONObject);
        JSONArray jSONArrayOptJSONArray = jSONObjectUserState.optJSONArray("payRecords");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectUserState.put("payRecords", jSONArrayOptJSONArray);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("orderId", "local-" + Long.toHexString(System.nanoTime()));
        jSONObject3.put("userId", jSONObject.optLong("userId"));
        jSONObject3.put("description", jSONObject2.optString("name"));
        jSONObject3.put("currency", jSONObject2.optInt("currency"));
        if (j <= 0) {
            j = 1;
        }
        jSONObject3.put("qty", j);
        jSONObject3.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 2);
        jSONObject3.put("inoutType", 1);
        jSONObject3.put("transactionType", 1);
        jSONObject3.put("created", simpleDateFormat.format(new Date()));
        jSONArrayOptJSONArray.put(jSONObject3);
        stateStore.save();
    }

    private static String payssionSignature(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(InAppPurchaseMetaData.KEY_SIGNATURE, "");
        jSONObject.put("userId", jSONObjectResolve.optLong("userId"));
        return envelope("obj", jSONObject.toString());
    }

    private static String friendList(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArrayFriends = Friend.friends(stateStore, jSONObjectRequireUser);
        for (int i3 = 0; i3 < jSONArrayFriends.length(); i3++) {
            JSONObject jSONObjectPersonJson = Friend.personJson(stateStore, jSONObjectRequireUser, jSONArrayFriends.optLong(i3));
            if (jSONObjectPersonJson != null) {
                jSONArray.put(jSONObjectPersonJson);
            }
        }
        return envelope("obj", pageData(slice(jSONArray, i, i2), i, i2, jSONArray.length()).toString());
    }

    private static String friendRequestsList(Ctx ctx, StateStore stateStore) throws JSONException {
        String strOptString;
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArrayPendingRequests = Friend.pendingRequests(stateStore, jSONObjectRequireUser);
        for (int i3 = 0; i3 < jSONArrayPendingRequests.length(); i3++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayPendingRequests.optJSONObject(i3);
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectPerson = Friend.person(stateStore, jSONObjectOptJSONObject.optLong("userId"));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("requestId", jSONObjectOptJSONObject.optLong("userId"));
                jSONObject.put("userId", jSONObjectOptJSONObject.optLong("userId"));
                jSONObject.put("nickName", jSONObjectPerson == null ? "Player" : jSONObjectPerson.optString("nickName"));
                String strOptString2 = "";
                if (jSONObjectPerson == null) {
                    strOptString = "";
                } else {
                    strOptString = jSONObjectPerson.optString("headPic").isEmpty() ? jSONObjectPerson.optString("picUrl") : jSONObjectPerson.optString("headPic");
                }
                jSONObject.put("picUrl", strOptString);
                jSONObject.put("sex", jSONObjectPerson == null ? 0 : jSONObjectPerson.optInt("sex"));
                jSONObject.put("age", 0);
                if (jSONObjectPerson != null) {
                    strOptString2 = jSONObjectPerson.optString("country");
                }
                jSONObject.put("country", strOptString2);
                jSONObject.put(au.M, "en");
                jSONObject.put("vip", jSONObjectPerson == null ? 0 : jSONObjectPerson.optInt("vip"));
                jSONObject.put("msg", jSONObjectOptJSONObject.optString("msg"));
                jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS));
                jSONArray.put(jSONObject);
            }
        }
        return envelope("obj", pageData(slice(jSONArray, i, i2), i, i2, jSONArray.length()).toString());
    }

    private static String friendSearchList(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectPersonJson;
        JSONObject jSONObjectPersonJson2;
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        String strPathParam = ctx.pathParam("nickName");
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        JSONArray jSONArray = new JSONArray();
        if (strPathParam != null && !strPathParam.isEmpty()) {
            String lowerCase = strPathParam.toLowerCase(Locale.US);
            JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("users");
            JSONArray jSONArrayNames = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.names();
            for (int i3 = 0; jSONArrayNames != null && i3 < jSONArrayNames.length(); i3++) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(jSONArrayNames.optString(i3));
                if (jSONObjectOptJSONObject2 != null) {
                    if (jSONObjectOptJSONObject2.optLong("userId") != (jSONObjectResolve == null ? 0L : jSONObjectResolve.optLong("userId")) && jSONObjectOptJSONObject2.optString("nickName").toLowerCase(Locale.US).contains(lowerCase) && (jSONObjectPersonJson2 = Friend.personJson(stateStore, jSONObjectResolve, jSONObjectOptJSONObject2.optLong("userId"))) != null) {
                        jSONArray.put(jSONObjectPersonJson2);
                    }
                }
            }
            JSONArray jSONArrayCitizens = GameCatalog.citizens(stateStore);
            for (int i4 = 0; jSONArrayCitizens != null && i4 < jSONArrayCitizens.length(); i4++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArrayCitizens.optJSONObject(i4);
                if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.optString("nickName").toLowerCase(Locale.US).contains(lowerCase) && (jSONObjectPersonJson = Friend.personJson(stateStore, jSONObjectResolve, jSONObjectOptJSONObject3.optLong("userId"))) != null) {
                    jSONArray.put(jSONObjectPersonJson);
                }
            }
        }
        return envelope("obj", pageData(slice(jSONArray, i, i2), i, i2, jSONArray.length()).toString());
    }

    private static String friendById(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectPersonJson = Friend.personJson(stateStore, stateStore.resolve(ctx.header("access-token"), ctx.header("userid")), parseLong(ctx.pathParam("id"), 0L));
        if (jSONObjectPersonJson == null) {
            return fail("user not found");
        }
        return envelope("obj", jSONObjectPersonJson.toString());
    }

    private static String friendDetails(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectPersonJson = Friend.personJson(stateStore, stateStore.resolve(ctx.header("access-token"), ctx.header("userid")), parseLong(ctx.pathParam("friendId"), 0L));
        if (jSONObjectPersonJson == null) {
            return fail("user not found");
        }
        return envelope("obj", jSONObjectPersonJson.toString());
    }

    private static String friendGamingInfo(Ctx ctx, StateStore stateStore) {
        long j = parseLong(ctx.pathParam("friendId"), 0L);
        return Friend.person(stateStore, j) == null ? fail("user not found") : envelope("obj", Friend.statusBean(stateStore, j).toString());
    }

    private static String friendStatus(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONArray jSONArrayFriends = Friend.friends(stateStore, jSONObjectRequireUser);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("curFriendCount", jSONArrayFriends.length());
        jSONObject.put("maxFriendCount", 100);
        jSONObject.put("currentTime", System.currentTimeMillis());
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayFriends.length(); i++) {
            long jOptLong = jSONArrayFriends.optLong(i);
            if (Friend.online(stateStore, jOptLong)) {
                jSONArray.put(Friend.statusBean(stateStore, jOptLong));
            }
        }
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, jSONArray);
        return envelope("obj", jSONObject.toString());
    }

    private static String friendPublicStatus(Ctx ctx, StateStore stateStore) {
        int i;
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        long j = parseLong(ctx.pathParam("friendId"), 0L);
        if (Friend.person(stateStore, j) == null) {
            return fail("user not found");
        }
        if (jSONObjectResolve == null || j != jSONObjectResolve.optLong("userId")) {
            i = (jSONObjectResolve == null || !Friend.isFriend(stateStore, jSONObjectResolve, j)) ? 0 : 1;
        } else {
            i = 2;
        }
        return envelope("num", String.valueOf(i));
    }

    private static String friendAdd(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        String strAdd = Friend.add(stateStore, jSONObjectRequireUser, jSONObjectBody.optLong("friendId"), jSONObjectBody.optString("msg"));
        if (strAdd != null) {
            return failFriend(strAdd);
        }
        return envelope("none", null);
    }

    private static String friendDelete(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strRemove = Friend.remove(stateStore, jSONObjectRequireUser, parseLong(ctx.query("friendId"), 0L));
        if (strRemove != null) {
            return failFriend(strRemove);
        }
        return envelope("none", null);
    }

    private static String friendBlacklist(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strBlacklist = Friend.blacklist(stateStore, jSONObjectRequireUser, parseLong(ctx.query("friendId"), 0L));
        if (strBlacklist != null) {
            return failFriend(strBlacklist);
        }
        return envelope("none", null);
    }

    private static String friendAliasSet(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String alias = Friend.setAlias(stateStore, jSONObjectRequireUser, parseLong(ctx.pathParam("friendId"), 0L), ctx.query("alias"));
        if (alias != null) {
            return failFriend(alias);
        }
        return envelope("none", null);
    }

    private static String friendAliasDelete(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String alias = Friend.setAlias(stateStore, jSONObjectRequireUser, parseLong(ctx.pathParam("friendId"), 0L), "");
        if (alias != null) {
            return failFriend(alias);
        }
        return envelope("none", null);
    }

    private static String friendAgree(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strAccept = Friend.accept(stateStore, jSONObjectRequireUser, parseLong(ctx.pathParam("friendId"), 0L));
        if (strAccept != null) {
            return failFriend(strAccept);
        }
        return envelope("none", null);
    }

    private static String friendReject(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strReject = Friend.reject(stateStore, jSONObjectRequireUser, parseLong(ctx.pathParam("friendId"), 0L));
        if (strReject != null) {
            return failFriend(strReject);
        }
        return envelope("none", null);
    }

    private static String setPassword(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectBody = body(ctx);
        JSONObject jSONObjectFindByToken = stateStore.findByToken(ctx.header("access-token"));
        if (jSONObjectFindByToken == null && jSONObjectBody.has("userId")) {
            jSONObjectFindByToken = stateStore.findByUserId(jSONObjectBody.optLong("userId"));
        }
        if (jSONObjectFindByToken == null && jSONObjectBody.optString(GameSharedConstant.ACCOUNT) != null && !jSONObjectBody.optString(GameSharedConstant.ACCOUNT).isEmpty()) {
            jSONObjectFindByToken = stateStore.findByKey(jSONObjectBody.optString(GameSharedConstant.ACCOUNT));
        }
        if (jSONObjectFindByToken == null) {
            return failCode(7, NO_AUTH);
        }
        String strDecryptIfEncrypted = RsaCipher.decryptIfEncrypted(jSONObjectBody.optString("password"));
        String strDecryptIfEncrypted2 = RsaCipher.decryptIfEncrypted(jSONObjectBody.optString("confirmPassword"));
        if (strDecryptIfEncrypted.isEmpty()) {
            return fail("password required");
        }
        if (strDecryptIfEncrypted2 != null && !strDecryptIfEncrypted2.isEmpty() && !strDecryptIfEncrypted.equals(strDecryptIfEncrypted2)) {
            return fail("passwords do not match");
        }
        jSONObjectFindByToken.put("password", strDecryptIfEncrypted);
        jSONObjectFindByToken.put("hasPassword", true);
        if (jSONObjectBody.optString(GameSharedConstant.ACCOUNT) != null && !jSONObjectBody.optString(GameSharedConstant.ACCOUNT).isEmpty() && jSONObjectFindByToken.optString(GameSharedConstant.ACCOUNT).isEmpty()) {
            jSONObjectFindByToken.put(GameSharedConstant.ACCOUNT, jSONObjectBody.optString(GameSharedConstant.ACCOUNT));
        }
        stateStore.save();
        L.i("setPassword: userId=" + jSONObjectFindByToken.optLong("userId"));
        return envelope("none", null);
    }

    private static String passwordModify(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        Object objDecryptIfEncrypted = RsaCipher.decryptIfEncrypted(jSONObjectBody.optString("oldPassword"));
        String strDecryptIfEncrypted = RsaCipher.decryptIfEncrypted(jSONObjectBody.optString("newPassword"));
        String strDecryptIfEncrypted2 = RsaCipher.decryptIfEncrypted(jSONObjectBody.optString("confirmPassword"));
        if (jSONObjectRequireUser.optString("password") != null && !jSONObjectRequireUser.optString("password").isEmpty() && !jSONObjectRequireUser.optString("password").equals(objDecryptIfEncrypted)) {
            return fail("wrong old password");
        }
        if (strDecryptIfEncrypted.isEmpty()) {
            return fail("new password required");
        }
        if (strDecryptIfEncrypted2 != null && !strDecryptIfEncrypted2.isEmpty() && !strDecryptIfEncrypted.equals(strDecryptIfEncrypted2)) {
            return fail("passwords do not match");
        }
        jSONObjectRequireUser.put("password", strDecryptIfEncrypted);
        jSONObjectRequireUser.put("hasPassword", true);
        stateStore.save();
        return envelope("none", null);
    }

    private static String passwordCheck(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strQuery = ctx.query("password");
        if (strQuery == null) {
            strQuery = body(ctx).optString("password");
        }
        String strDecryptIfEncrypted = RsaCipher.decryptIfEncrypted(strQuery);
        return envelope("bool", String.valueOf((strDecryptIfEncrypted == null || strDecryptIfEncrypted.isEmpty() || !strDecryptIfEncrypted.equals(jSONObjectRequireUser.optString("password"))) ? false : true));
    }

    private static String nickNameExist(Ctx ctx, StateStore stateStore) {
        String strQuery = ctx.query("nickName");
        if (strQuery == null || strQuery.trim().isEmpty()) {
            return fail("nickName required");
        }
        String lowerCase = strQuery.trim().toLowerCase(Locale.US);
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("config");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optJSONArray("sensitiveWords");
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            String lowerCase2 = jSONArrayOptJSONArray.optString(i).toLowerCase(Locale.US);
            if (!lowerCase2.isEmpty() && lowerCase.contains(lowerCase2)) {
                return fail("nickname contains a sensitive word");
            }
        }
        JSONObject jSONObjectOptJSONObject2 = stateStore.root().optJSONObject("users");
        JSONArray jSONArrayNames = jSONObjectOptJSONObject2 == null ? null : jSONObjectOptJSONObject2.names();
        for (int i2 = 0; jSONArrayNames != null && i2 < jSONArrayNames.length(); i2++) {
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(jSONArrayNames.optString(i2));
            if (jSONObjectOptJSONObject3 != null && lowerCase.equals(jSONObjectOptJSONObject3.optString("nickName").toLowerCase(Locale.US))) {
                return fail("nickname already exists");
            }
        }
        JSONArray jSONArrayCitizens = GameCatalog.citizens(stateStore);
        for (int i3 = 0; jSONArrayCitizens != null && i3 < jSONArrayCitizens.length(); i3++) {
            JSONObject jSONObjectOptJSONObject4 = jSONArrayCitizens.optJSONObject(i3);
            if (jSONObjectOptJSONObject4 != null && lowerCase.equals(jSONObjectOptJSONObject4.optString("nickName").toLowerCase(Locale.US))) {
                return fail("nickname already exists");
            }
        }
        return envelope("none", null);
    }

    private static String accountModify(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strOptString = body(ctx).optString(GameSharedConstant.ACCOUNT);
        if (strOptString == null || strOptString.trim().isEmpty()) {
            return fail("account required");
        }
        String strTrim = strOptString.trim();
        if (strTrim.equals(jSONObjectRequireUser.optString(GameSharedConstant.ACCOUNT))) {
            return envelope("none", null);
        }
        if (stateStore.findByKey(strTrim) != null) {
            return fail("account already exists");
        }
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("users");
        String strOptString2 = jSONObjectRequireUser.optString("key");
        if (strOptString2 != null && !strOptString2.isEmpty() && jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.remove(strOptString2);
            jSONObjectOptJSONObject.put(strTrim, jSONObjectRequireUser);
        }
        jSONObjectRequireUser.put("key", strTrim);
        jSONObjectRequireUser.put(GameSharedConstant.ACCOUNT, strTrim);
        stateStore.save();
        L.i("accountModify: userId=" + jSONObjectRequireUser.optLong("userId") + " -> " + strTrim);
        return envelope("none", null);
    }

    private static String bindPhone(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strOptString = body(ctx).optString("phone");
        if (strOptString == null || strOptString.trim().isEmpty()) {
            return fail("phone required");
        }
        jSONObjectRequireUser.put("telephone", strOptString.trim());
        stateStore.save();
        return envelope("none", null);
    }

    private static String unbindPhone(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        jSONObjectRequireUser.put("telephone", "");
        stateStore.save();
        return envelope("none", null);
    }

    private static String bindEmail(Ctx ctx, StateStore stateStore) throws JSONException {
        String lowerCase;
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        List<String> listQueryValues = ctx.queryValues("answer");
        if (listQueryValues != null && !listQueryValues.isEmpty()) {
            JSONArray jSONArrayOptJSONArray = stateStore.userState(jSONObjectRequireUser).optJSONArray("secretQuestions");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                return fail("no secret questions stored for this account");
            }
            if (listQueryValues.size() < jSONArrayOptJSONArray.length()) {
                return fail("missing secret-question answers");
            }
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    lowerCase = jSONObjectOptJSONObject.optString("answer").trim().toLowerCase();
                } else {
                    lowerCase = "";
                }
                if (lowerCase.isEmpty()) {
                    return fail("stored question has no answer");
                }
                hashSet.add(lowerCase);
            }
            for (String str : listQueryValues) {
                if (str == null || !hashSet.remove(str.trim().toLowerCase())) {
                    return fail("secret-question answer mismatch");
                }
            }
        }
        String strOptString = body(ctx).optString("email");
        if (strOptString != null && strOptString.contains("@")) {
            jSONObjectRequireUser.put("email", strOptString.trim());
            stateStore.save();
            return envelope("none", null);
        }
        return fail("valid email required");
    }

    private static String unbindEmail(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        jSONObjectRequireUser.put("email", "");
        stateStore.save();
        return envelope("none", null);
    }

    private static String tipsEmail(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strOptString = jSONObjectRequireUser.optString("email");
        if (strOptString == null || !strOptString.contains("@")) {
            return envelope("str", "\"\"");
        }
        int iIndexOf = strOptString.indexOf(64);
        if (iIndexOf > 1) {
            strOptString = String.valueOf(strOptString.charAt(0)) + "***" + strOptString.substring(iIndexOf);
        }
        return envelope("str", "\"" + strOptString + "\"");
    }

    private static String questionGet(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        if (parseLong(ctx.query("type"), 1L) == 0) {
            String[] strArr = {"What was your childhood nickname?", "What is the name of your first pet?", "What was the name of your first school?", "What is your mother's maiden name?", "What was the make of your first car?", "What city were you born in?"};
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (i < 6) {
                JSONObject jSONObject = new JSONObject();
                int i2 = i + 1;
                jSONObject.put("id", i2);
                jSONObject.put("question", strArr[i]);
                jSONObject.put("answer", "");
                jSONArray.put(jSONObject);
                i = i2;
            }
            return envelope("list", jSONArray.toString());
        }
        JSONArray jSONArrayOptJSONArray = stateStore.userState(jSONObjectRequireUser).optJSONArray("secretQuestions");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        return envelope("list", jSONArrayOptJSONArray.toString());
    }

    private static String verifyEmail(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        String strOptString = jSONObjectBody.optString("email");
        if (strOptString == null || !strOptString.contains("@")) {
            return fail("valid email required");
        }
        String strOptString2 = jSONObjectBody.optString("verifyCode");
        if (strOptString2 == null || strOptString2.isEmpty()) {
            return fail("verifyCode required");
        }
        String str = "local-" + Long.toHexString(System.currentTimeMillis());
        stateStore.userState(jSONObjectRequireUser).put("securityAuthCode", str);
        stateStore.save();
        return envelope("obj", "{\"authCode\":\"" + str + "\",\"flag\":true}");
    }

    private static String questionAuth(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        JSONArray jSONArrayOptJSONArray = stateStore.userState(jSONObjectRequireUser).optJSONArray("secretQuestions");
        String strOptString = jSONObjectBody.optString("question");
        String strOptString2 = jSONObjectBody.optString("answer");
        if (jSONArrayOptJSONArray != null && !strOptString2.isEmpty()) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString3 = jSONObjectOptJSONObject.optString("question");
                    String strOptString4 = jSONObjectOptJSONObject.optString("answer");
                    if ((strOptString.isEmpty() || strOptString3.trim().equalsIgnoreCase(strOptString.trim())) && !strOptString4.isEmpty() && strOptString4.trim().equalsIgnoreCase(strOptString2.trim())) {
                        String str = "local-" + Long.toHexString(System.currentTimeMillis());
                        stateStore.userState(jSONObjectRequireUser).put("securityAuthCode", str);
                        stateStore.save();
                        return envelope("obj", "{\"authCode\":\"" + str + "\",\"count\":" + jSONArrayOptJSONArray.length() + ",\"right\":true}");
                    }
                }
            }
        }
        return envelope("obj", "{\"authCode\":\"\",\"count\":" + (jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0) + ",\"right\":false}");
    }

    private static String questionSetting(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strQuery = ctx.query(StringConstant.AUTHCODE);
        if (strQuery != null && !strQuery.isEmpty() && !strQuery.equals(stateStore.userState(jSONObjectRequireUser).optString("securityAuthCode"))) {
            return fail("invalid authCode");
        }
        try {
            jSONArrayOptJSONArray = new JSONArray(ctx.body());
        } catch (Throwable unused) {
            jSONArrayOptJSONArray = body(ctx).optJSONArray("list");
        }
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        stateStore.userState(jSONObjectRequireUser).put("secretQuestions", jSONArrayOptJSONArray);
        stateStore.save();
        return envelope("none", null);
    }

    private static String questionResetPassword(Ctx ctx, StateStore stateStore) throws JSONException {
        long j = parseLong(ctx.query("userId"), 0L);
        JSONObject jSONObjectFindByUserId = j > 0 ? stateStore.findByUserId(j) : null;
        if (jSONObjectFindByUserId == null) {
            jSONObjectFindByUserId = stateStore.findByToken(ctx.header("access-token"));
        }
        if (jSONObjectFindByUserId == null) {
            return failCode(7, NO_AUTH);
        }
        String strQuery = ctx.query(StringConstant.AUTHCODE);
        if (strQuery == null || !strQuery.equals(stateStore.userState(jSONObjectFindByUserId).optString("securityAuthCode"))) {
            return fail("invalid authCode");
        }
        String strQuery2 = ctx.query("newPwd");
        if (strQuery2 == null || strQuery2.isEmpty()) {
            return fail("newPwd required");
        }
        jSONObjectFindByUserId.put("password", strQuery2);
        jSONObjectFindByUserId.put("hasPassword", true);
        stateStore.save();
        return envelope("none", null);
    }

    private static String unbindSecurity(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        stateStore.userState(jSONObjectRequireUser).remove("secretQuestions");
        stateStore.userState(jSONObjectRequireUser).remove("securityAuthCode");
        stateStore.save();
        return envelope("none", null);
    }

    private static String loginRecord(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONArray jSONArrayOptJSONArray = stateStore.userState(jSONObjectRequireUser).optJSONArray("loginRecords");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(jSONArrayOptJSONArray.length() - 1)) == null) {
            return envelope("obj", "{\"appType\":\"android\",\"loginTime\":\"\"}");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appType", jSONObjectOptJSONObject.optString("appType", "android"));
        jSONObject.put("loginTime", jSONObjectOptJSONObject.optString("loginTime"));
        return envelope("obj", jSONObject.toString());
    }

    private static String setPsdParamCheck(Ctx ctx, StateStore stateStore) {
        return envelope("num", "0");
    }

    private static String accountInvalidCheck(Ctx ctx, StateStore stateStore) {
        String strQuery = ctx.query(GameSharedConstant.ACCOUNT);
        L.i("accountInvalidCheck: account=" + strQuery + " loginTypeId=" + ctx.query("loginTypeId") + " type=" + ctx.query("type"));
        return envelope("bool", strQuery != null && !strQuery.isEmpty() && (stateStore.findByKey(strQuery) != null || stateStore.findByAccount(strQuery) != null) ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }

    private static String newDailyTasks(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        int length = (jSONObjectResolve == null || stateStore.signIns(jSONObjectResolve) == null) ? 0 : stateStore.signIns(jSONObjectResolve).length();
        boolean z = jSONObjectResolve != null && stateStore.hasSignedIn(jSONObjectResolve, today());
        long[] jArrUntilMidnightUtc = untilMidnightUtc();
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (i < 7) {
            JSONObject jSONObject = new JSONObject();
            int i2 = i + 1;
            jSONObject.put("type", i2);
            jSONObject.put("currency", 1);
            jSONObject.put("count", SIGN_REWARDS[i]);
            int i3 = length % 7;
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, (i < i3 || (z && i == i3)) ? 1 : 0);
            jSONArray.put(jSONObject);
            i = i2;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("count", length % 7);
        jSONObject2.put(PlaceFields.HOURS, (int) jArrUntilMidnightUtc[0]);
        jSONObject2.put("minutes", (int) jArrUntilMidnightUtc[1]);
        jSONObject2.put("seconds", (int) jArrUntilMidnightUtc[2]);
        jSONObject2.put("tasks", jSONArray);
        return envelope("obj", jSONObject2.toString());
    }

    private static String weekTasks(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        int length = (jSONObjectResolve == null || stateStore.signIns(jSONObjectResolve) == null) ? 0 : stateStore.signIns(jSONObjectResolve).length();
        long[] jArrUntilMidnightUtc = untilMidnightUtc();
        JSONObject jSONObject = new JSONObject();
        for (int i = 1; i <= 7; i++) {
            jSONObject.put(String.valueOf(i), i + (-1) < length % 7 ? 1 : 0);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("count", length % 7);
        jSONObject2.put(PlaceFields.HOURS, (int) jArrUntilMidnightUtc[0]);
        jSONObject2.put("minutes", (int) jArrUntilMidnightUtc[1]);
        jSONObject2.put("seconds", (int) jArrUntilMidnightUtc[2]);
        jSONObject2.put("taskMap", jSONObject);
        return envelope("obj", jSONObject2.toString());
    }

    private static String claimTask(Ctx ctx, StateStore stateStore) throws JSONException {
        long j;
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        int i = (int) parseLong(ctx.pathParam("type"), 1L);
        String str = today();
        if (stateStore.hasSignedIn(jSONObjectRequireUser, str)) {
            j = 0;
        } else {
            if (stateStore.signIns(jSONObjectRequireUser) != null) {
                stateStore.signIns(jSONObjectRequireUser).length();
            }
            j = SIGN_REWARDS[Math.max(0, Math.min(6, (i - 1) % 7))];
            stateStore.markSignedIn(jSONObjectRequireUser, str);
            stateStore.award(jSONObjectRequireUser, StringConstant.CHRISTMAS_GOLDS, j);
            L.i("claimTask: userId=" + jSONObjectRequireUser.optLong("userId") + " day=" + i + " +" + j);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", jSONObjectRequireUser.optLong("userId"));
        jSONObject.put("currency", 2);
        jSONObject.put(StringConstant.CHRISTMAS_GOLDS, jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_GOLDS));
        jSONObject.put(StringConstant.CHRISTMAS_DIAMONDS, jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_DIAMONDS));
        jSONObject.put("gDiamonds", jSONObjectRequireUser.optLong("gDiamonds"));
        jSONObject.put("gDiamondsProfit", 0);
        jSONObject.put("money", 0);
        jSONObject.put("rewardQuantity", j);
        return envelope("obj", jSONObject.toString());
    }

    private static String shareReward(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectUserState = stateStore.userState(jSONObjectRequireUser);
        JSONObject jSONObjectOptJSONObject = jSONObjectUserState.optJSONObject("shareReward");
        String str = today();
        if (jSONObjectOptJSONObject == null || !str.equals(jSONObjectOptJSONObject.optString("date"))) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectOptJSONObject.put("date", str);
            jSONObjectOptJSONObject.put("count", 0);
        }
        if (jSONObjectOptJSONObject.optInt("count") >= 1) {
            return fail("reward already claimed today");
        }
        jSONObjectOptJSONObject.put("count", jSONObjectOptJSONObject.optInt("count") + 1);
        jSONObjectUserState.put("shareReward", jSONObjectOptJSONObject);
        stateStore.award(jSONObjectRequireUser, StringConstant.CHRISTMAS_GOLDS, 200L);
        return envelope("none", null);
    }

    private static String prefectCheck(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        return envelope("bool", String.valueOf(jSONObjectResolve != null && prefectDone(stateStore, jSONObjectResolve)));
    }

    private static boolean prefectDone(StateStore stateStore, JSONObject jSONObject) {
        return (!jSONObject.optString("nickName").isEmpty() && (!jSONObject.optString("details").isEmpty() || !jSONObject.optString("picUrl").isEmpty())) && !stateStore.userState(jSONObject).optBoolean("prefectClaimed");
    }

    private static String prefectReward(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        if (!prefectDone(stateStore, jSONObjectRequireUser)) {
            return fail("profile not complete or reward claimed");
        }
        stateStore.userState(jSONObjectRequireUser).put("prefectClaimed", true);
        stateStore.award(jSONObjectRequireUser, StringConstant.CHRISTMAS_GOLDS, 500L);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(StringConstant.CHRISTMAS_GOLDS, 500);
        jSONObject.put(StringConstant.CHRISTMAS_DIAMONDS, 0);
        jSONObject.put("gDiamonds", 0);
        jSONObject.put("orderId", "local-" + Long.toHexString(System.currentTimeMillis()));
        jSONObject.put("userId", jSONObjectRequireUser.optLong("userId"));
        L.i("prefectReward: userId=" + jSONObjectRequireUser.optLong("userId") + " +500 golds");
        return envelope("obj", jSONObject.toString());
    }

    private static String securitySettings(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strOptString = jSONObjectRequireUser.optString("email");
        JSONArray jSONArrayOptJSONArray = stateStore.userState(jSONObjectRequireUser).optJSONArray("secretQuestions");
        int i = 0;
        boolean z = jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bindEmail", (strOptString == null || strOptString.isEmpty()) ? false : true);
        if (strOptString == null) {
            strOptString = "";
        }
        jSONObject.put("email", strOptString);
        if (z) {
            JSONArray jSONArray = new JSONArray();
            while (i < jSONArrayOptJSONArray.length()) {
                i++;
                jSONArray.put(i);
            }
            jSONObject.put("ids", jSONArray);
            jSONObject.put("secretQuestionList", jSONArrayOptJSONArray);
        }
        jSONObject.put("userId", jSONObjectRequireUser.optLong("userId"));
        return envelope("obj", jSONObject.toString());
    }

    private static String activityTitle(Ctx ctx, StateStore stateStore) throws JSONException {
        long jOptInt = requireUser(ctx, stateStore) == null ? 0L : stateStore.activityProgress(r4).optInt("onlineMinutes");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(activityTitleNode("weekday", 0));
        jSONArray.put(activityTitleNode("weekend", 1));
        JSONObject jSONObjectActivityTitleNode = activityTitleNode("sign", 2);
        jSONObjectActivityTitleNode.put("titleName", "Daily Sign-in");
        jSONObjectActivityTitleNode.put("content", "activity:sign");
        jSONArray.put(jSONObjectActivityTitleNode);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("activityTitleList", jSONArray);
        jSONObject.put("cumulativeTime", jOptInt);
        jSONObject.put("serverTime", System.currentTimeMillis());
        return envelope("obj", jSONObject.toString());
    }

    private static JSONObject activityTitleNode(String str, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("titleType", str);
        jSONObject.put("titleName", "weekend".equals(str) ? "Weekend Tasks" : "Weekday Tasks");
        jSONObject.put("content", "Play to earn rewards");
        jSONObject.put("dateDesc", "");
        jSONObject.put("pic", "");
        jSONObject.put("position", i);
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 1);
        jSONObject.put("closeRedPoint", false);
        jSONObject.put("isEnable", true);
        jSONObject.put("isLast", "weekend".equals(str));
        jSONObject.put("endTime", -1L);
        jSONObject.put("countryList", new JSONArray());
        return jSONObject;
    }

    private static String activityActionList(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strQuery = ctx.query("titleType");
        if (!"weekday".equals(strQuery) && !"weekend".equals(strQuery)) {
            return fail("unknown titleType: " + strQuery);
        }
        return envelope("list", activityActionsFor(strQuery, jSONObjectRequireUser, stateStore).toString());
    }

    private static String activityTaskReward(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strQuery = ctx.query("titleType");
        long j = parseLong(ctx.query("actionId"), 0L);
        if (!"weekday".equals(strQuery) && !"weekend".equals(strQuery)) {
            return fail("unknown titleType: " + strQuery);
        }
        JSONArray jSONArrayActivityActionsFor = activityActionsFor(strQuery, jSONObjectRequireUser, stateStore);
        int i = 0;
        while (true) {
            if (i >= jSONArrayActivityActionsFor.length()) {
                jSONObject = null;
                break;
            }
            JSONObject jSONObjectOptJSONObject = jSONArrayActivityActionsFor.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("actionId") == j) {
                jSONObject = jSONObjectOptJSONObject;
                break;
            }
            i++;
        }
        if (jSONObject == null) {
            return fail("unknown actionId: " + j);
        }
        if (stateStore.activityClaimedToday(jSONObjectRequireUser, StateStore.utcDay(), j)) {
            return failCode(7012, "already claimed");
        }
        if (jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) != 1) {
            return fail("task not complete");
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("actionRewards");
        long jOptLong = 0;
        for (int i2 = 0; jSONArrayOptJSONArray != null && i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject2 != null && StringConstant.CHRISTMAS_GOLDS.equals(jSONObjectOptJSONObject2.optString("rewardType"))) {
                jOptLong += jSONObjectOptJSONObject2.optLong(FirebaseAnalytics.Param.QUANTITY);
            }
        }
        if (jOptLong > 0) {
            stateStore.award(jSONObjectRequireUser, StringConstant.CHRISTMAS_GOLDS, jOptLong);
        }
        stateStore.markActivityClaimed(jSONObjectRequireUser, StateStore.utcDay(), j);
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 2);
        jSONObject.put("completeQuantity", jSONObject.opt(FirebaseAnalytics.Param.QUANTITY));
        L.i("activityTaskReward: userId=" + jSONObjectRequireUser.optLong("userId") + " actionId=" + j + " +" + jOptLong + " golds");
        return envelope("obj", jSONObject.toString());
    }

    private static JSONArray activityActionsFor(String str, JSONObject jSONObject, StateStore stateStore) {
        JSONArray jSONArray = new JSONArray();
        StateStore.utcDay();
        int iOptInt = stateStore.activityProgress(jSONObject).optInt("onlineMinutes");
        if ("weekday".equals(str)) {
            jSONArray.put(onlineTimeAction(stateStore, jSONObject, 1L, 10, 200, iOptInt));
            jSONArray.put(onlineTimeAction(stateStore, jSONObject, 2L, 30, 400, iOptInt));
            jSONArray.put(onlineTimeAction(stateStore, jSONObject, 3L, 60, VipDiamond.MVP, iOptInt));
        } else {
            jSONArray.put(onlineTimeAction(stateStore, jSONObject, 4L, 10, 300, iOptInt));
            jSONArray.put(loginAction(stateStore, jSONObject, 5L, "saturday_login", 200));
            jSONArray.put(loginAction(stateStore, jSONObject, 6L, "sunday_login", 200));
        }
        return jSONArray;
    }

    private static JSONObject onlineTimeAction(StateStore stateStore, JSONObject jSONObject, long j, int i, int i2, int i3) {
        int i4;
        if (stateStore.activityClaimedToday(jSONObject, StateStore.utcDay(), j)) {
            i4 = 2;
        } else {
            i4 = i3 >= i ? 1 : 0;
        }
        return activityActionNode(j, "online_time", "Online " + i + " min", i, Math.min(i3, i), i4, i2);
    }

    private static JSONObject loginAction(StateStore stateStore, JSONObject jSONObject, long j, String str, int i) {
        int i2;
        String strUtcDay = StateStore.utcDay();
        boolean z = !"saturday_login".equals(str) ? dayOfWeekUtc() != 1 : dayOfWeekUtc() != 7;
        boolean zEquals = strUtcDay.equals(stateStore.activityProgress(jSONObject).optString("lastDayLogin"));
        if (stateStore.activityClaimedToday(jSONObject, strUtcDay, j)) {
            i2 = 2;
        } else {
            i2 = (z && zEquals) ? 1 : 0;
        }
        return activityActionNode(j, str, "saturday_login".equals(str) ? "Saturday Login" : "Sunday Login", 1, i2 == 0 ? 0 : 1, i2, i);
    }

    private static int dayOfWeekUtc() {
        return Calendar.getInstance(TimeZone.getTimeZone("UTC")).get(7);
    }

    private static JSONObject activityActionNode(long j, String str, String str2, int i, int i2, int i3, int i4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("actionId", (int) j);
        jSONObject.put("actionFlag", str);
        jSONObject.put("actionName", str2);
        jSONObject.put("content", "");
        jSONObject.put("dateDesc", "");
        jSONObject.put("pic", "");
        jSONObject.put(FirebaseAnalytics.Param.QUANTITY, i);
        jSONObject.put("completeQuantity", i2);
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i3);
        jSONObject.put("actionFrequency", 1);
        jSONObject.put("isSingleCumulative", 1);
        jSONObject.put("isShowComplete", 1);
        jSONObject.put("isFirst", false);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("rewardType", StringConstant.CHRISTMAS_GOLDS);
        jSONObject2.put(FirebaseAnalytics.Param.QUANTITY, i4);
        jSONObject2.put("rewardName", "Golds");
        jSONObject2.put("rewardPic", "");
        jSONObject2.put("rewardDesc", "");
        jSONObject2.put("decorationId", 0);
        jSONObject2.put("isShowDesc", 0);
        jSONObject2.put(FirebaseAnalytics.Param.LEVEL, 0);
        jSONArray.put(jSONObject2);
        jSONObject.put("actionRewards", jSONArray);
        return jSONObject;
    }

    private static long[] untilMidnightUtc() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(11, 24);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long jMax = Math.max(0L, calendar.getTimeInMillis() - timeInMillis) / 1000;
        return new long[]{jMax / 3600, (jMax % 3600) / 60, jMax % 60};
    }

    private static String campaignCycle() {
        return new SimpleDateFormat("yyyy-MM", Locale.US).format(new Date());
    }

    private static JSONObject campaignState(StateStore stateStore, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectCampaignSignIn = stateStore.campaignSignIn(jSONObject);
        String strCampaignCycle = campaignCycle();
        if (jSONObjectCampaignSignIn != null && strCampaignCycle.equals(jSONObjectCampaignSignIn.optString("cycle"))) {
            return jSONObjectCampaignSignIn;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("cycle", strCampaignCycle);
        jSONObject2.put("claimed", new JSONArray());
        jSONObject2.put("lastDate", "");
        stateStore.putCampaignSignIn(jSONObject, jSONObject2);
        return jSONObject2;
    }

    private static boolean campaignDayClaimed(JSONObject jSONObject, int i) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("claimed");
        if (jSONArrayOptJSONArray == null) {
            return false;
        }
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            if (jSONArrayOptJSONArray.optInt(i2) == i) {
                return true;
            }
        }
        return false;
    }

    private static String campaignSignInList(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        if (jSONObjectResolve == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectCampaignState = campaignState(stateStore, jSONObjectResolve);
        JSONArray jSONArrayOptJSONArray = jSONObjectCampaignState.optJSONArray("claimed");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectCampaignState.put("claimed", jSONArrayOptJSONArray);
        }
        JSONArray jSONArray = new JSONArray();
        int length = jSONArrayOptJSONArray.length();
        int i = 1;
        int i2 = 1;
        while (i2 <= 8) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("signInId", i2);
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, campaignDayClaimed(jSONObjectCampaignState, i2) ? 1 : 0);
            jSONObject.put("isSpecial", i2 >= 7 ? 1 : 0);
            jSONObject.put("isSelect", false);
            JSONArray jSONArray2 = new JSONArray();
            if (i2 == 8) {
                jSONArray2.put(reward("8000 Golds"));
                jSONArray2.put(reward("VIP Day"));
                jSONArray2.put(reward("Avatar Frame"));
                jSONArray2.put(reward("Nameplate"));
            } else {
                jSONArray2.put(reward(String.valueOf(CAMPAIGN_REWARDS[i2 - 1]) + " Golds"));
            }
            jSONObject.put("rewards", jSONArray2);
            jSONArray.put(jSONObject);
            i2++;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (length >= 8) {
            i = 2;
        } else if (!stateStore.campaignSignedOn(jSONObjectResolve, today())) {
            i = 0;
        }
        jSONObject2.put("signInStatus", i);
        jSONObject2.put("remainingTime", campaignCycleEndMs());
        jSONObject2.put("userSignInList", jSONArray);
        return envelope("obj", jSONObject2.toString());
    }

    private static JSONObject reward(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rewardName", str);
        jSONObject.put("rewardPic", "");
        return jSONObject;
    }

    private static long campaignCycleEndMs() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(5, calendar.getActualMaximum(5));
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static String campaignSignIn(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String str = today();
        if (stateStore.campaignSignedOn(jSONObjectRequireUser, str)) {
            return failCode(7012, "already signed in today");
        }
        JSONObject jSONObjectCampaignState = campaignState(stateStore, jSONObjectRequireUser);
        int i = 1;
        while (true) {
            if (i > 8) {
                i = 0;
                break;
            }
            if (!campaignDayClaimed(jSONObjectCampaignState, i)) {
                break;
            }
            i++;
        }
        if (i == 0) {
            return failCode(7012, "cycle complete");
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectCampaignState.optJSONArray("claimed");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectCampaignState.put("claimed", jSONArrayOptJSONArray);
        }
        jSONArrayOptJSONArray.put(i);
        jSONObjectCampaignState.put("lastDate", str);
        stateStore.putCampaignSignIn(jSONObjectRequireUser, jSONObjectCampaignState);
        long j = CAMPAIGN_REWARDS[i - 1];
        stateStore.award(jSONObjectRequireUser, StringConstant.CHRISTMAS_GOLDS, j);
        L.i("campaign sign-in: userId=" + jSONObjectRequireUser.optLong("userId") + " day=" + i + " +" + j + " golds");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("signInId", i);
        return envelope("obj", jSONObject.toString());
    }

    private static String turntableStatus(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        int i = 1;
        if (jSONObjectResolve != null && !stateStore.turntableFreeToday(jSONObjectResolve, today())) {
            i = 0;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isFree", i);
        return envelope("obj", jSONObject.toString());
    }

    private static String adsCdConfig(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adsCdTimeFirst", 30);
        jSONObject.put("adsCdTimeSecond", 60);
        return envelope("obj", jSONObject.toString());
    }

    private static String turntableInfo(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (i < TURNTABLE_GOLDS.length) {
            JSONObject jSONObject = new JSONObject();
            i++;
            jSONObject.put("id", i);
            jSONObject.put("picUrl", "");
            jSONArray.put(jSONObject);
        }
        return envelope("list", jSONArray.toString());
    }

    private static String turntableProps(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        return envelope("str", "\"" + ((jSONObjectResolve == null || !stateStore.turntableFreeToday(jSONObjectResolve, today())) ? "Free draw used - come back tomorrow" : "1 free draw available today") + "\"");
    }

    private static String turntableDraw(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String str = today();
        if (!stateStore.turntableFreeToday(jSONObjectRequireUser, str)) {
            return failCode(7012, "free draw already used today");
        }
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        long[] jArr = TURNTABLE_GOLDS;
        int iNextInt = threadLocalRandomCurrent.nextInt(jArr.length);
        long j = iNextInt + 1;
        long j2 = jArr[iNextInt];
        stateStore.putTurntableDraw(jSONObjectRequireUser, str, j, ctx.pathParam("gameId"));
        stateStore.award(jSONObjectRequireUser, StringConstant.CHRISTMAS_GOLDS, j2);
        L.i("turntable draw: userId=" + jSONObjectRequireUser.optLong("userId") + " gameId=" + ctx.pathParam("gameId") + " prize=" + j + " +" + j2 + " golds");
        return envelope("num", String.valueOf(j));
    }

    private static String eventReport(Ctx ctx, StateStore stateStore, String str) {
        String strBody = ctx.body();
        int iAppendReport = stateStore.appendReport(str, strBody);
        if (iAppendReport < 0) {
            return fail("report store write failed");
        }
        L.i("datareport " + str + ": line " + iAppendReport + " (" + (strBody == null ? 0 : strBody.length()) + " bytes)");
        return envelope("none", null);
    }

    private static JSONArray longArray(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            long j = parseLong(it.next(), 0L);
            if (j > 0) {
                jSONArray.put(j);
            }
        }
        return jSONArray;
    }

    private static String groupInfoResp(Ctx ctx, StateStore stateStore) {
        if (requireUser(ctx, stateStore) == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectFind = GroupChat.find(stateStore, parseLong(ctx.query("groupId"), 0L));
        if (jSONObjectFind == null) {
            return fail("group not found");
        }
        return envelope("obj", GroupChat.groupJson(jSONObjectFind).toString());
    }

    private static String groupCreate(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        JSONObject jSONObjectCreate = GroupChat.create(stateStore, jSONObjectRequireUser, jSONObjectBody.optJSONArray("memberIds"), jSONObjectBody.optString("groupName"));
        L.i("groupCreate: userId=" + jSONObjectRequireUser.optLong("userId") + " groupId=" + jSONObjectCreate.optLong("groupId"));
        return envelope("obj", GroupChat.groupJson(jSONObjectCreate).toString());
    }

    private static String groupList(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArrayMine = GroupChat.mine(stateStore, jSONObjectRequireUser.optLong("userId"));
        for (int i3 = 0; i3 < jSONArrayMine.length(); i3++) {
            jSONArray.put(GroupChat.groupJson(jSONArrayMine.optJSONObject(i3)));
        }
        return envelope("obj", pageData(slice(jSONArray, i, i2), i, i2, jSONArray.length()).toString());
    }

    private static String groupInfo(Ctx ctx, StateStore stateStore) {
        if (requireUser(ctx, stateStore) == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectFind = GroupChat.find(stateStore, parseLong(ctx.query("groupId"), 0L));
        if (jSONObjectFind == null) {
            return fail("group not found");
        }
        return envelope("obj", GroupChat.groupJson(jSONObjectFind).toString());
    }

    private static String groupInviteCount(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectFind = GroupChat.find(stateStore, parseLong(ctx.query("groupId"), 0L));
        if (jSONObjectFind == null) {
            return fail("group not found");
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectFind.optJSONArray("joinRequests");
        String strUtcDate = Tribe.utcDate();
        int i = 0;
        for (int i2 = 0; jSONArrayOptJSONArray != null && i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == jSONObjectRequireUser.optLong("userId") && Tribe.utcDateOf(jSONObjectOptJSONObject.optLong("at")).equals(strUtcDate)) {
                i++;
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dailyCount", i);
        jSONObject.put("inviteCount", Math.max(0, 20 - i));
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 1);
        return envelope("obj", jSONObject.toString());
    }

    private static String groupRequestList(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        JSONArray jSONArrayRequestFeed = GroupChat.requestFeed(stateStore, jSONObjectRequireUser.optLong("userId"));
        return envelope("obj", pageData(slice(jSONArrayRequestFeed, i, i2), i, i2, jSONArrayRequestFeed.length()).toString());
    }

    private static String groupInviteDirect(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        long jOptLong = jSONObjectBody.optLong("groupId");
        JSONObject jSONObjectFind = GroupChat.find(stateStore, jOptLong);
        if (jSONObjectFind == null) {
            return fail("group not found");
        }
        if (!GroupChat.canManage(jSONObjectFind, jSONObjectRequireUser.optLong("userId"))) {
            return fail("no permission");
        }
        GroupChat.invite(stateStore, jSONObjectRequireUser, jOptLong, jSONObjectBody.optJSONArray("memberIds"));
        return envelope("obj", GroupChat.groupJson(jSONObjectFind).toString());
    }

    private static String groupBanMember(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strBanMember = GroupChat.banMember(stateStore, jSONObjectRequireUser, parseLong(ctx.query("groupId"), 0L), parseLong(ctx.query("memberId"), 0L), (int) parseLong(ctx.query("minute"), 5L));
        if (strBanMember != null) {
            return failGroup(strBanMember);
        }
        return envelope("obj", GroupChat.groupJson(GroupChat.find(stateStore, parseLong(ctx.query("groupId"), 0L))).toString());
    }

    private static String groupInvite(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strInvite = GroupChat.invite(stateStore, jSONObjectRequireUser, parseLong(ctx.query("groupId"), 0L), longArray(ctx.queryValues("memberIds")));
        if (strInvite != null) {
            return failGroup(strInvite);
        }
        return envelope("none", null);
    }

    private static String groupApply(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strApply = GroupChat.apply(stateStore, jSONObjectRequireUser, parseLong(ctx.query("groupId"), 0L), ctx.query("msg"));
        if (strApply != null) {
            return failGroup(strApply);
        }
        return envelope("none", null);
    }

    private static String groupMuteAll(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String str = GroupChat.toggleMuteAll(stateStore, jSONObjectRequireUser, parseLong(ctx.query("groupId"), 0L));
        if (str != null) {
            return failGroup(str);
        }
        return envelope("obj", GroupChat.groupJson(GroupChat.find(stateStore, parseLong(ctx.query("groupId"), 0L))).toString());
    }

    private static String groupAccept(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        String strAcceptRequest = GroupChat.acceptRequest(stateStore, jSONObjectRequireUser, jSONObjectBody.optLong("groupId"), jSONObjectBody.optLong("requestId"), jSONObjectBody.optLong("userId"));
        if (strAcceptRequest != null) {
            return failGroup(strAcceptRequest);
        }
        return envelope("obj", GroupChat.groupJson(GroupChat.find(stateStore, jSONObjectBody.optLong("groupId"))).toString());
    }

    private static String groupRejectReq(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        String strRejectRequest = GroupChat.rejectRequest(stateStore, jSONObjectRequireUser, jSONObjectBody.optLong("groupId"), jSONObjectBody.optLong("requestId"));
        if (strRejectRequest != null) {
            return failGroup(strRejectRequest);
        }
        return envelope("none", null);
    }

    private static String groupUnban(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strUnbanMember = GroupChat.unbanMember(stateStore, jSONObjectRequireUser, parseLong(ctx.query("groupId"), 0L), parseLong(ctx.query("memberId"), 0L));
        if (strUnbanMember != null) {
            return failGroup(strUnbanMember);
        }
        return envelope("obj", GroupChat.groupJson(GroupChat.find(stateStore, parseLong(ctx.query("groupId"), 0L))).toString());
    }

    private static String groupQuit(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strQuit = GroupChat.quit(stateStore, jSONObjectRequireUser, parseLong(ctx.query("groupId"), 0L));
        if (strQuit != null) {
            return failGroup(strQuit);
        }
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArrayMine = GroupChat.mine(stateStore, jSONObjectRequireUser.optLong("userId"));
        for (int i3 = 0; i3 < jSONArrayMine.length(); i3++) {
            jSONArray.put(GroupChat.groupJson(jSONArrayMine.optJSONObject(i3)));
        }
        return envelope("obj", pageData(slice(jSONArray, i, i2), i, i2, jSONArray.length()).toString());
    }

    private static String groupKick(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        String strKick = GroupChat.kick(stateStore, jSONObjectRequireUser, jSONObjectBody.optLong("groupId"), jSONObjectBody.optJSONArray("memberIds"));
        if (strKick != null) {
            return failGroup(strKick);
        }
        return envelope("obj", GroupChat.groupJson(GroupChat.find(stateStore, jSONObjectBody.optLong("groupId"))).toString());
    }

    private static String groupSetManager(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        String managers = GroupChat.setManagers(stateStore, jSONObjectRequireUser, jSONObjectBody.optLong("groupId"), jSONObjectBody.optJSONArray("memberIds"), jSONObjectBody.optInt("operationType"));
        if (managers != null) {
            return failGroup(managers);
        }
        return envelope("obj", GroupChat.groupJson(GroupChat.find(stateStore, jSONObjectBody.optLong("groupId"))).toString());
    }

    private static String groupTransfer(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        String strTransfer = GroupChat.transfer(stateStore, jSONObjectRequireUser, jSONObjectBody.optLong("groupId"), jSONObjectBody.optLong("userId"));
        if (strTransfer != null) {
            return failGroup(strTransfer);
        }
        return envelope("obj", GroupChat.groupJson(GroupChat.find(stateStore, jSONObjectBody.optLong("groupId"))).toString());
    }

    private static String groupModify(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        JSONObject jSONObjectFind = GroupChat.find(stateStore, jSONObjectBody.optLong("groupId"));
        if (jSONObjectFind == null) {
            return fail("group not found");
        }
        if (!GroupChat.canManage(jSONObjectFind, jSONObjectRequireUser.optLong("userId"))) {
            return fail("no permission");
        }
        if (jSONObjectBody.has("groupName") && !jSONObjectBody.optString("groupName").isEmpty()) {
            jSONObjectFind.put("groupName", jSONObjectBody.optString("groupName"));
        }
        if (jSONObjectBody.has("groupNotice")) {
            jSONObjectFind.put("groupNotice", jSONObjectBody.optString("groupNotice"));
        }
        if (jSONObjectBody.has("groupPic")) {
            jSONObjectFind.put("groupPic", jSONObjectBody.optString("groupPic"));
        }
        if (jSONObjectBody.has("noticePic")) {
            jSONObjectFind.put("noticePic", jSONObjectBody.optJSONArray("noticePic"));
        }
        if (jSONObjectBody.has("inviteStatus")) {
            jSONObjectFind.put("inviteStatus", jSONObjectBody.optInt("inviteStatus"));
        }
        stateStore.save();
        return envelope("obj", GroupChat.groupJson(jSONObjectFind).toString());
    }

    private static String tribeId(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        return envelope("str", "\"" + (jSONObjectResolve == null ? 0L : jSONObjectResolve.optLong("clanId")) + "\"");
    }

    private static String tribeDetail(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectFind = Tribe.find(stateStore, parseLong(ctx.query("clanId"), 0L));
        if (jSONObjectFind == null) {
            return fail("clan not found");
        }
        return envelope("obj", tribeDetailJson(jSONObjectFind).toString());
    }

    private static String tribeBaseInfo(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectClanOf = Tribe.clanOf(stateStore, jSONObjectRequireUser);
        if (jSONObjectClanOf == null) {
            return failTribe("not in a clan");
        }
        return envelope("obj", tribeDetailJson(jSONObjectClanOf).toString());
    }

    private static String tribeMemberList(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectClanOf = Tribe.clanOf(stateStore, jSONObjectRequireUser);
        if (jSONObjectClanOf == null) {
            return failTribe("not in a clan");
        }
        return envelope("list", tribeMembersJson(jSONObjectClanOf).toString());
    }

    private static String clanCreate(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        if (isSensitiveNick(stateStore, jSONObjectBody.optString("name"))) {
            return failCode(7020, "clan name contains a sensitive word");
        }
        String strCreate = Tribe.create(stateStore, jSONObjectRequireUser, jSONObjectBody.optString("name"), jSONObjectBody.optString("details"), jSONObjectBody.optString("headPic"), jSONObjectBody.optJSONArray("tags"), jSONObjectBody.optInt("currency", 2));
        if (strCreate != null) {
            return failTribe(strCreate);
        }
        JSONObject jSONObjectClanOf = Tribe.clanOf(stateStore, jSONObjectRequireUser);
        L.i("clanCreate: userId=" + jSONObjectRequireUser.optLong("userId") + " clanId=" + jSONObjectClanOf.optLong("clanId") + " name=" + jSONObjectClanOf.optString("name"));
        return envelope("obj", clanRequestEcho(jSONObjectClanOf).toString());
    }

    private static String clanUpdate(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectClanOf = Tribe.clanOf(stateStore, jSONObjectRequireUser);
        if (jSONObjectClanOf == null) {
            return failTribe("not in a clan");
        }
        if (Tribe.roleOf(jSONObjectClanOf, jSONObjectRequireUser.optLong("userId")) != 20) {
            return failTribe("only the chief can update");
        }
        JSONObject jSONObjectBody = body(ctx);
        String strOptString = jSONObjectBody.optString("name", jSONObjectClanOf.optString("name"));
        if (strOptString != null && !strOptString.trim().isEmpty()) {
            if (isSensitiveNick(stateStore, strOptString)) {
                return failCode(7020, "clan name contains a sensitive word");
            }
            String strReplace = strOptString.trim().replace(UMCustomLogInfoBuilder.LINE_SEP, " ");
            if (Tribe.nameTaken(stateStore, strReplace, jSONObjectClanOf.optLong("clanId"))) {
                return failTribe("clan name taken");
            }
            jSONObjectClanOf.put("name", strReplace);
        }
        if (jSONObjectBody.has("details")) {
            jSONObjectClanOf.put("details", jSONObjectBody.optString("details"));
        }
        if (jSONObjectBody.has("headPic")) {
            jSONObjectClanOf.put("headPic", jSONObjectBody.optString("headPic"));
        }
        if (jSONObjectBody.has("tags")) {
            jSONObjectClanOf.put("tags", jSONObjectBody.optJSONArray("tags"));
        }
        stateStore.save();
        return envelope("obj", clanRequestEcho(jSONObjectClanOf).toString());
    }

    private static String clanDissolve(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strDissolve = Tribe.dissolve(stateStore, jSONObjectRequireUser);
        if (strDissolve != null) {
            return failTribe(strDissolve);
        }
        L.i("clanDissolve: userId=" + jSONObjectRequireUser.optLong("userId"));
        return envelope("none", null);
    }

    private static String clanExit(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strExit = Tribe.exit(stateStore, jSONObjectRequireUser);
        if (strExit != null) {
            return failTribe(strExit);
        }
        return envelope("none", null);
    }

    private static String clanKick(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strKick = Tribe.kick(stateStore, jSONObjectRequireUser, parseLong(ctx.query("otherId"), 0L));
        if (strKick != null) {
            return failTribe(strKick);
        }
        return envelope("none", null);
    }

    private static String clanJoin(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        String strRequestJoin = Tribe.requestJoin(stateStore, jSONObjectRequireUser, jSONObjectBody.optLong("clanId"), jSONObjectBody.optString("msg"));
        if (strRequestJoin != null) {
            return failTribe(strRequestJoin);
        }
        return envelope("none", null);
    }

    private static String clanAgreeJoin(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strAgreeJoin = Tribe.agreeJoin(stateStore, jSONObjectRequireUser, parseLong(ctx.query("otherId"), 0L));
        if (strAgreeJoin != null) {
            return failTribe(strAgreeJoin);
        }
        return envelope("none", null);
    }

    private static String clanRejectJoin(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strRejectJoin = Tribe.rejectJoin(stateStore, jSONObjectRequireUser, parseLong(ctx.query("otherId"), 0L));
        if (strRejectJoin != null) {
            return failTribe(strRejectJoin);
        }
        return envelope("none", null);
    }

    private static String clanAgreeInvite(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strAgreeInvitation = Tribe.agreeInvitation(stateStore, jSONObjectRequireUser, parseLong(ctx.query("id"), 0L));
        if (strAgreeInvitation != null) {
            return failTribe(strAgreeInvitation);
        }
        return envelope("none", null);
    }

    private static String clanRejectInvite(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strRejectInvitation = Tribe.rejectInvitation(stateStore, jSONObjectRequireUser, parseLong(ctx.query("id"), 0L));
        if (strRejectInvitation != null) {
            return failTribe(strRejectInvitation);
        }
        return envelope("none", null);
    }

    private static String clanInvite(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        List<String> listQueryValues = ctx.queryValues("friendIds");
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = listQueryValues.iterator();
        while (it.hasNext()) {
            long j = parseLong(it.next(), 0L);
            if (j > 0) {
                jSONArray.put(j);
            }
        }
        String strInvite = Tribe.invite(stateStore, jSONObjectRequireUser, jSONArray, ctx.query("msg"));
        if (strInvite != null) {
            return failTribe(strInvite);
        }
        return envelope("none", null);
    }

    private static String clanSetIdentity(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String identity = Tribe.setIdentity(stateStore, jSONObjectRequireUser, parseLong(ctx.query("otherId"), 0L), (int) parseLong(ctx.query("type"), 0L));
        if (identity != null) {
            return failTribe(identity);
        }
        return envelope("none", null);
    }

    private static String tribeMessageList(Ctx ctx, StateStore stateStore) throws JSONException {
        long j;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        JSONArray jSONArray3;
        int i;
        String str7;
        String strOptString;
        String str8;
        StateStore stateStore2 = stateStore;
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONArray jSONArray4 = new JSONArray();
        String str9 = "userId";
        long jOptLong = jSONObjectRequireUser.optLong("userId");
        JSONObject jSONObjectClanOf = Tribe.clanOf(stateStore2, jSONObjectRequireUser);
        String str10 = "type";
        String str11 = "Player";
        String str12 = "id";
        String str13 = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS;
        if (jSONObjectClanOf != null) {
            int iRoleOf = Tribe.roleOf(jSONObjectClanOf, jOptLong);
            j = jOptLong;
            if (iRoleOf == 20 || iRoleOf == 10) {
                JSONArray jSONArrayOptJSONArray = jSONObjectClanOf.optJSONArray("joinRequests");
                int i2 = 0;
                while (jSONArrayOptJSONArray != null && i2 < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject == null) {
                        jSONArray3 = jSONArrayOptJSONArray;
                        i = i2;
                        str7 = str12;
                        str8 = str13;
                    } else {
                        jSONArray3 = jSONArrayOptJSONArray;
                        i = i2;
                        JSONObject jSONObjectFindByUserId = stateStore2.findByUserId(jSONObjectOptJSONObject.optLong("userId"));
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(str12, 0);
                        str7 = str12;
                        String str14 = str13;
                        jSONObject.put("clanId", (int) jSONObjectClanOf.optLong("clanId"));
                        jSONObject.put("headPic", jSONObjectFindByUserId == null ? "" : jSONObjectFindByUserId.optString("picUrl"));
                        if (jSONObjectOptJSONObject.optLong("userId") == 0) {
                            strOptString = "Player";
                        } else {
                            strOptString = jSONObjectFindByUserId == null ? "Player" + jSONObjectOptJSONObject.optLong("userId") : jSONObjectFindByUserId.optString("nickName");
                        }
                        jSONObject.put("nickName", strOptString);
                        jSONObject.put("msg", jSONObjectOptJSONObject.optString("msg"));
                        str8 = str14;
                        jSONObject.put(str8, jSONObjectOptJSONObject.optInt(str8));
                        jSONObject.put("type", 1);
                        jSONObject.put("userId", jSONObjectOptJSONObject.optLong("userId"));
                        jSONArray4.put(jSONObject);
                    }
                    i2 = i + 1;
                    stateStore2 = stateStore;
                    str13 = str8;
                    str12 = str7;
                    jSONArrayOptJSONArray = jSONArray3;
                }
            }
        } else {
            j = jOptLong;
        }
        String str15 = str12;
        String str16 = str13;
        int i3 = 0;
        String str17 = "tribes";
        JSONArray jSONArrayNames = stateStore.root().optJSONObject("tribes") == null ? null : stateStore.root().optJSONObject("tribes").names();
        int i4 = 0;
        while (jSONArrayNames != null && i4 < jSONArrayNames.length()) {
            JSONObject jSONObjectOptJSONObject2 = stateStore.root().optJSONObject(str17).optJSONObject(jSONArrayNames.optString(i4));
            if (jSONObjectOptJSONObject2 == null) {
                jSONArray = jSONArrayNames;
            } else {
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("invitations");
                while (jSONArrayOptJSONArray2 != null) {
                    jSONArray = jSONArrayNames;
                    if (i3 >= jSONArrayOptJSONArray2.length()) {
                        break;
                    }
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i3);
                    if (jSONObjectOptJSONObject3 != null) {
                        str2 = str17;
                        if (jSONObjectOptJSONObject3.optLong("inviteeId") != j) {
                            jSONArray2 = jSONArray4;
                            str = str9;
                            str6 = str16;
                            str3 = str10;
                            str4 = str11;
                            str5 = str15;
                        } else {
                            str3 = str10;
                            str4 = str11;
                            JSONObject jSONObjectFindByUserId2 = stateStore.findByUserId(jSONObjectOptJSONObject3.optLong(str9));
                            JSONObject jSONObject2 = new JSONObject();
                            String str18 = str9;
                            str5 = str15;
                            JSONArray jSONArray5 = jSONArray4;
                            jSONObject2.put(str5, (int) jSONObjectOptJSONObject3.optLong(str5));
                            jSONObject2.put("clanId", (int) jSONObjectOptJSONObject2.optLong("clanId"));
                            jSONObject2.put("headPic", jSONObjectFindByUserId2 == null ? "" : jSONObjectFindByUserId2.optString("picUrl"));
                            jSONObject2.put("nickName", jSONObjectFindByUserId2 == null ? str4 : jSONObjectFindByUserId2.optString("nickName"));
                            jSONObject2.put("msg", jSONObjectOptJSONObject3.optString("msg"));
                            jSONObject2.put(str16, jSONObjectOptJSONObject3.optInt(str16));
                            jSONObject2.put(str3, 2);
                            str6 = str16;
                            str = str18;
                            jSONObject2.put(str, jSONObjectOptJSONObject3.optLong(str));
                            jSONArray2 = jSONArray5;
                            jSONArray2.put(jSONObject2);
                        }
                    } else {
                        jSONArray2 = jSONArray4;
                        str = str9;
                        str2 = str17;
                        str3 = str10;
                        str4 = str11;
                        str5 = str15;
                        str6 = str16;
                    }
                    i3++;
                    str9 = str;
                    str16 = str6;
                    str15 = str5;
                    str17 = str2;
                    str10 = str3;
                    str11 = str4;
                    jSONArray4 = jSONArray2;
                    jSONArrayNames = jSONArray;
                }
                jSONArray = jSONArrayNames;
            }
            i4++;
            str9 = str9;
            str16 = str16;
            str15 = str15;
            str17 = str17;
            str10 = str10;
            str11 = str11;
            i3 = 0;
            jSONArray4 = jSONArray4;
            jSONArrayNames = jSONArray;
        }
        return envelope("list", jSONArray4.toString());
    }

    private static String tribeBulletinGet(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectClanOf = Tribe.clanOf(stateStore, jSONObjectRequireUser);
        if (jSONObjectClanOf == null) {
            return fail("not in a clan");
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectClanOf.optJSONObject("bulletin");
        JSONObject jSONObject = new JSONObject();
        String strValueOf = "";
        jSONObject.put("content", jSONObjectOptJSONObject == null ? "" : jSONObjectOptJSONObject.optString("content"));
        if (jSONObjectOptJSONObject != null) {
            strValueOf = String.valueOf(jSONObjectOptJSONObject.optLong("updateTime"));
        }
        jSONObject.put("updateTime", strValueOf);
        return envelope("obj", jSONObject.toString());
    }

    private static String tribeBulletinPost(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String bulletin = Tribe.setBulletin(stateStore, jSONObjectRequireUser, body(ctx).optString("content"));
        if (bulletin != null) {
            return failTribe(bulletin);
        }
        return envelope("none", null);
    }

    private static String tribeDonationInfo(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        return envelope("obj", Tribe.donationInfo(stateStore, jSONObjectRequireUser).toString());
    }

    private static String tribeDonate(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        int i = (int) parseLong(ctx.query("currency"), 2L);
        int i2 = (int) parseLong(ctx.query(FirebaseAnalytics.Param.QUANTITY), 0L);
        String strDonate = Tribe.donate(stateStore, jSONObjectRequireUser, i, i2);
        if (strDonate != null) {
            return failTribe(strDonate);
        }
        long j = i2;
        if (i == 1) {
            j *= 10;
        }
        long jMax = Math.max(1L, j / 10);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("experienceGot", (int) j);
        jSONObject.put("totalExperience", (int) Math.min(Tribe.clanOf(stateStore, jSONObjectRequireUser).optLong("experience"), 2147483647L));
        jSONObject.put("tribeCurrencyGot", (int) jMax);
        jSONObject.put("totalTribeCurrency", (int) Math.min(Tribe.tribeCurrency(jSONObjectRequireUser), 2147483647L));
        jSONObject.put("userId", jSONObjectRequireUser.optLong("userId"));
        L.i("tribeDonate: userId=" + jSONObjectRequireUser.optLong("userId") + " currency=" + i + " qty=" + i2);
        return envelope("obj", jSONObject.toString());
    }

    private static String tribeDonationHistory(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        JSONArray jSONArrayDonationHistory = Tribe.donationHistory(stateStore, jSONObjectRequireUser);
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < jSONArrayDonationHistory.length(); i3++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayDonationHistory.optJSONObject(i3);
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("date", jSONObjectOptJSONObject.optLong("date"));
                jSONObject.put("experienceGot", String.valueOf(jSONObjectOptJSONObject.optInt("experienceGot")));
                jSONObject.put("nickName", jSONObjectOptJSONObject.optString("nickName"));
                jSONObject.put(FirebaseAnalytics.Param.QUANTITY, jSONObjectOptJSONObject.optInt(FirebaseAnalytics.Param.QUANTITY));
                jSONObject.put("tribeCurrencyGot", String.valueOf(jSONObjectOptJSONObject.optInt("tribeCurrencyGot")));
                jSONObject.put("type", jSONObjectOptJSONObject.optInt("type"));
                jSONObject.put("userId", jSONObjectOptJSONObject.optLong("userId"));
                jSONArray.put(jSONObject);
            }
        }
        return envelope("obj", pageData(slice(jSONArray, i, i2), i, i2, jSONArray.length()).toString());
    }

    private static String tribeCurrency(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        return envelope("num", String.valueOf(Tribe.tribeCurrency(jSONObjectRequireUser)));
    }

    private static String tribeRank(Ctx ctx, StateStore stateStore) throws JSONException {
        Tribe.ensureNpcTribes(stateStore);
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        JSONArray jSONArrayClansByExperience = clansByExperience(stateStore);
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        while (i3 < jSONArrayClansByExperience.length()) {
            JSONObject jSONObjectOptJSONObject = jSONArrayClansByExperience.optJSONObject(i3);
            i3++;
            jSONArray.put(tribeRankJson(jSONObjectOptJSONObject, i3));
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageInfo", pageData(slice(jSONArray, i, i2), i, i2, jSONArray.length()));
        jSONObject.put("remainTime", 0L);
        return envelope("obj", jSONObject.toString());
    }

    private static String tribeUserRank(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectClanOf = Tribe.clanOf(stateStore, jSONObjectRequireUser);
        if (jSONObjectClanOf == null) {
            return failTribe("not in a clan");
        }
        JSONArray jSONArrayClansByExperience = clansByExperience(stateStore);
        for (int i = 0; i < jSONArrayClansByExperience.length(); i++) {
            if (jSONArrayClansByExperience.optJSONObject(i) == jSONObjectClanOf) {
                return envelope("obj", tribeRankJson(jSONObjectClanOf, i + 1).toString());
            }
        }
        return envelope("obj", tribeRankJson(jSONObjectClanOf, jSONArrayClansByExperience.length() + 1).toString());
    }

    private static String tribeRecommend(Ctx ctx, StateStore stateStore) throws JSONException {
        Tribe.ensureNpcTribes(stateStore);
        JSONArray jSONArrayNames = stateStore.root().optJSONObject("tribes").names();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; jSONArrayNames != null && i < jSONArrayNames.length(); i++) {
            JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("tribes").optJSONObject(jSONArrayNames.optString(i));
            if (jSONObjectOptJSONObject != null) {
                jSONArray.put(tribeRecommendationJson(stateStore, jSONObjectOptJSONObject));
            }
        }
        return envelope("list", jSONArray.toString());
    }

    private static String tribeSearch(Ctx ctx, StateStore stateStore) throws JSONException {
        Tribe.ensureNpcTribes(stateStore);
        String strQuery = ctx.query("clanName");
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        JSONArray jSONArrayNames = stateStore.root().optJSONObject("tribes").names();
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; jSONArrayNames != null && i3 < jSONArrayNames.length(); i3++) {
            JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("tribes").optJSONObject(jSONArrayNames.optString(i3));
            if (jSONObjectOptJSONObject != null && (strQuery == null || strQuery.isEmpty() || jSONObjectOptJSONObject.optString("name").toLowerCase(Locale.US).contains(strQuery.toLowerCase(Locale.US)))) {
                jSONArray.put(tribeRecommendationJson(stateStore, jSONObjectOptJSONObject));
            }
        }
        return envelope("obj", pageData(slice(jSONArray, i, i2), i, i2, jSONArray.length()).toString());
    }

    private static String tribeTasks(Ctx ctx, StateStore stateStore, int i) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        return Tribe.clanOf(stateStore, jSONObjectRequireUser) == null ? fail("not in a clan") : envelope("obj", Tribe.tasks(stateStore, jSONObjectRequireUser, (int) parseLong(ctx.query("type"), i)).toString());
    }

    private static String tribeTaskAction(Ctx ctx, StateStore stateStore, boolean z) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        long j = parseLong(ctx.query("id"), 0L);
        String strTaskAction = Tribe.taskAction(stateStore, jSONObjectRequireUser, j, (int) parseLong(ctx.query("type"), 1L), z);
        if (strTaskAction != null) {
            return failTribe(strTaskAction);
        }
        if (z) {
            L.i("tribeTaskReward: userId=" + jSONObjectRequireUser.optLong("userId") + " task=" + j);
        }
        return envelope("none", null);
    }

    private static String tribeShopList(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        int i = (int) parseLong(ctx.pathParam("typeId"), 0L);
        int i2 = (int) parseLong(ctx.query("pageNo"), 1L);
        int i3 = (int) parseLong(ctx.query("pageSize"), 20L);
        JSONArray jSONArrayShop = Tribe.shop(stateStore);
        JSONArray jSONArray = new JSONArray();
        for (int i4 = 0; i4 < jSONArrayShop.length(); i4++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayShop.optJSONObject(i4);
            if (jSONObjectOptJSONObject != null && (i <= 0 || jSONObjectOptJSONObject.optInt("typeId") == i)) {
                JSONObject jSONObject = new JSONObject(jSONObjectOptJSONObject.toString());
                jSONObject.put("hasPurchase", (jSONObjectResolve == null || !Tribe.ownsDecoration(stateStore, jSONObjectResolve, jSONObjectOptJSONObject.optLong("id"))) ? 0 : 1);
                jSONArray.put(jSONObject);
            }
        }
        return envelope("obj", pageData(slice(jSONArray, i2, i3), i2, i3, jSONArray.length()).toString());
    }

    private static String tribeShopDetail(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectResolve = stateStore.resolve(ctx.header("access-token"), ctx.header("userid"));
        long j = parseLong(ctx.pathParam("decorationId"), 0L);
        JSONArray jSONArrayShop = Tribe.shop(stateStore);
        int i = 0;
        for (int i2 = 0; i2 < jSONArrayShop.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayShop.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("id") == j) {
                JSONObject jSONObject = new JSONObject(jSONObjectOptJSONObject.toString());
                if (jSONObjectResolve != null && Tribe.ownsDecoration(stateStore, jSONObjectResolve, j)) {
                    i = 1;
                }
                jSONObject.put("hasPurchase", i);
                return envelope("obj", jSONObject.toString());
            }
        }
        return fail("unknown decoration");
    }

    private static String tribeShopBuy(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        List<String> listQueryValues = ctx.queryValues("decorationId");
        long[] jArr = new long[listQueryValues.size()];
        for (int i = 0; i < listQueryValues.size(); i++) {
            jArr[i] = parseLong(listQueryValues.get(i), 0L);
        }
        String strBuyDecorations = Tribe.buyDecorations(stateStore, jSONObjectRequireUser, jArr);
        if (strBuyDecorations != null) {
            return failTribe(strBuyDecorations);
        }
        L.i("tribeShopBuy: userId=" + jSONObjectRequireUser.optLong("userId") + " items=" + listQueryValues.size());
        return envelope("none", null);
    }

    private static String clanFreeVerify(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String freeVerify = Tribe.setFreeVerify(stateStore, jSONObjectRequireUser, (int) parseLong(ctx.query("freeVerify"), 0L));
        if (freeVerify != null) {
            return failTribe(freeVerify);
        }
        JSONObject jSONObjectClanOf = Tribe.clanOf(stateStore, jSONObjectRequireUser);
        return envelope("obj", clanResponseJson(jSONObjectClanOf, Tribe.roleOf(jSONObjectClanOf, jSONObjectRequireUser.optLong("userId"))).toString());
    }

    private static JSONObject tribeDetailJson(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("clanId", (int) jSONObject.optLong("clanId"));
        JSONArray jSONArrayMembers = Tribe.members(jSONObject);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayMembers.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayMembers.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("userId", jSONObjectOptJSONObject.optLong("userId"));
                jSONObject3.put("role", jSONObjectOptJSONObject.optInt("role"));
                jSONObject3.put("headPic", jSONObjectOptJSONObject.optString("headPic"));
                jSONArray.put(jSONObject3);
            }
        }
        jSONObject2.put("clanMembers", jSONArray);
        jSONObject2.put("currentCount", jSONArrayMembers.length());
        jSONObject2.put("maxCount", Tribe.maxMembers(jSONObject));
        jSONObject2.put("details", jSONObject.optString("details"));
        jSONObject2.put("experience", jSONObject.optLong("experience"));
        jSONObject2.put("freeVerify", jSONObject.optInt("freeVerify"));
        jSONObject2.put("headPic", jSONObject.optString("headPic"));
        jSONObject2.put(FirebaseAnalytics.Param.LEVEL, Tribe.level(jSONObject));
        jSONObject2.put("name", jSONObject.optString("name"));
        jSONObject2.put("tags", jSONObject.optJSONArray("tags") == null ? new JSONArray() : jSONObject.optJSONArray("tags"));
        return jSONObject2;
    }

    private static JSONArray tribeMembersJson(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayMembers = Tribe.members(jSONObject);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayMembers.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayMembers.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ID", i + 1);
                jSONObject2.put("userId", jSONObjectOptJSONObject.optLong("userId"));
                jSONObject2.put("localUserId", 0L);
                jSONObject2.put("experience", jSONObjectOptJSONObject.optInt("experience"));
                jSONObject2.put("expireDate", jSONObjectOptJSONObject.optString("expireDate"));
                jSONObject2.put("headPic", jSONObjectOptJSONObject.optString("headPic"));
                jSONObject2.put("nickName", jSONObjectOptJSONObject.optString("nickName"));
                jSONObject2.put("role", jSONObjectOptJSONObject.optInt("role"));
                jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS));
                jSONObject2.put("vip", jSONObjectOptJSONObject.optInt("vip"));
                jSONArray.put(jSONObject2);
            }
        }
        return jSONArray;
    }

    private static JSONObject clanRequestEcho(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("clanId", jSONObject.optLong("clanId"));
        jSONObject2.put("details", jSONObject.optString("details"));
        jSONObject2.put("headPic", jSONObject.optString("headPic"));
        jSONObject2.put("name", jSONObject.optString("name"));
        jSONObject2.put("tags", jSONObject.optJSONArray("tags") == null ? new JSONArray() : jSONObject.optJSONArray("tags"));
        jSONObject2.put("currency", 2);
        return jSONObject2;
    }

    private static JSONObject clanResponseJson(JSONObject jSONObject, int i) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("clanId", jSONObject.optLong("clanId"));
        jSONObject2.put("details", jSONObject.optString("details"));
        jSONObject2.put("experience", jSONObject.optLong("experience"));
        jSONObject2.put("freeVerify", jSONObject.optInt("freeVerify"));
        jSONObject2.put("headPic", jSONObject.optString("headPic"));
        jSONObject2.put(FirebaseAnalytics.Param.LEVEL, Tribe.level(jSONObject));
        jSONObject2.put("name", jSONObject.optString("name"));
        jSONObject2.put("role", i);
        jSONObject2.put("tags", jSONObject.optJSONArray("tags") == null ? new JSONArray() : jSONObject.optJSONArray("tags"));
        return jSONObject2;
    }

    private static JSONObject tribeRecommendationJson(StateStore stateStore, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("clanId", (int) jSONObject.optLong("clanId"));
        jSONObject2.put("name", jSONObject.optString("name"));
        jSONObject2.put("details", jSONObject.optString("details"));
        jSONObject2.put("headPic", jSONObject.optString("headPic"));
        jSONObject2.put("freeVerify", jSONObject.optInt("freeVerify"));
        jSONObject2.put(FirebaseAnalytics.Param.LEVEL, Tribe.level(jSONObject));
        JSONArray jSONArrayMembers = Tribe.members(jSONObject);
        jSONObject2.put("currentCount", jSONArrayMembers.length());
        jSONObject2.put("maxCount", Tribe.maxMembers(jSONObject));
        JSONObject jSONObjectOptJSONObject = jSONArrayMembers.length() > 0 ? jSONArrayMembers.optJSONObject(0) : null;
        jSONObject2.put("chiefId", jSONObjectOptJSONObject == null ? 0L : jSONObjectOptJSONObject.optLong("userId"));
        jSONObject2.put("chiefNickName", jSONObjectOptJSONObject == null ? "" : jSONObjectOptJSONObject.optString("nickName"));
        jSONObject2.put("isFirst", false);
        return jSONObject2;
    }

    private static JSONObject tribeRankJson(JSONObject jSONObject, int i) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("clanId", (int) jSONObject.optLong("clanId"));
        jSONObject2.put("name", jSONObject.optString("name"));
        jSONObject2.put("headPic", jSONObject.optString("headPic"));
        jSONObject2.put("experience", String.valueOf(jSONObject.optLong("experience")));
        jSONObject2.put("rank", String.valueOf(i));
        return jSONObject2;
    }

    private static JSONArray clansByExperience(StateStore stateStore) throws JSONException {
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("tribes");
        JSONArray jSONArray = new JSONArray();
        if (jSONObjectOptJSONObject == null) {
            return jSONArray;
        }
        JSONArray jSONArrayNames = jSONObjectOptJSONObject.names();
        for (int i = 0; jSONArrayNames != null && i < jSONArrayNames.length(); i++) {
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(jSONArrayNames.optString(i));
            if (jSONObjectOptJSONObject2 != null) {
                jSONArray.put(jSONObjectOptJSONObject2);
            }
        }
        for (int i2 = 1; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i2);
            long jOptLong = jSONObjectOptJSONObject3.optLong("experience");
            int i3 = i2 - 1;
            while (i3 >= 0 && jSONArray.optJSONObject(i3).optLong("experience") < jOptLong) {
                jSONArray.put(i3 + 1, jSONArray.optJSONObject(i3));
                i3--;
            }
            jSONArray.put(i3 + 1, jSONObjectOptJSONObject3);
        }
        return jSONArray;
    }

    private static JSONObject pageData(JSONArray jSONArray, int i, int i2, int i3) throws JSONException {
        if (i2 <= 0) {
            i2 = 20;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", jSONArray);
        jSONObject.put("pageNo", i);
        jSONObject.put("pageSize", i2);
        jSONObject.put("totalPage", totalPages(i3, i2));
        jSONObject.put("totalSize", i3);
        return jSONObject;
    }

    private static String failCode(int i, String str) {
        return "{\"code\":" + i + ",\"message\":\"" + str + "\"}";
    }

    private static boolean isSensitiveNick(StateStore stateStore, String str) {
        if (str != null && !str.trim().isEmpty()) {
            String lowerCase = str.trim().toLowerCase(Locale.US);
            JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("config");
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optJSONArray("sensitiveWords");
            for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
                String lowerCase2 = jSONArrayOptJSONArray.optString(i).toLowerCase(Locale.US);
                if (!lowerCase2.isEmpty() && lowerCase.contains(lowerCase2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String failTribe(String str) {
        if (str == null) {
            return fail("unknown error");
        }
        return str.contains("not in a clan") ? failCode(AdError.API_NOT_SUPPORTED, str) : str.contains("already in a clan") ? failCode(AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE, str) : str.contains("clan name taken") ? failCode(AdError.LOAD_CALLED_WHILE_SHOWING_AD, str) : str.contains("only the chief") ? failCode(AdError.CLEAR_TEXT_SUPPORT_NOT_ALLOWED, str) : str.contains("no permission") ? failCode(AdError.INCORRECT_STATE_ERROR, str) : str.contains("clan is full") ? failCode(AdError.MISSING_DEPENDENCIES_ERROR, str) : str.contains("not enough golds") ? failCode(5007, str) : str.contains("not enough diamonds") ? failCode(5006, str) : str.contains("daily donation") ? failCode(7011, str) : str.contains("reward already claimed") ? failCode(7012, str) : str.contains("after 24 hours") ? failCode(7014, str) : str.contains("clan level too low") ? failCode(7008, str) : fail(str);
    }

    private static String failFriend(String str) {
        if (str == null) {
            return fail("unknown error");
        }
        return str.contains("already friends") ? failCode(3001, str) : str.contains("friend list is full") ? failCode(AuthApiStatusCodes.AUTH_API_CLIENT_ERROR, str) : str.contains("not friends (alias)") ? failCode(AuthApiStatusCodes.AUTH_API_SERVER_ERROR, str) : str.contains("user not found") ? failCode(AuthApiStatusCodes.AUTH_TOKEN_ERROR, str) : fail(str);
    }

    private static String failGroup(String str) {
        if (str == null) {
            return fail("unknown error");
        }
        if (str.contains("group not found")) {
            return failCode(8102, str);
        }
        if (str.contains("no permission") || str.contains("only the owner")) {
            return failCode(8103, str);
        }
        return str.contains("not a member") ? failCode(8104, str) : fail(str);
    }

    private static String ensureStarCode(JSONObject jSONObject, StateStore stateStore) throws JSONException {
        String strOptString = jSONObject.optString("starCode");
        if (strOptString != null && !strOptString.isEmpty()) {
            return strOptString;
        }
        String str = "BG" + jSONObject.optLong("userId");
        jSONObject.put("starCode", str);
        stateStore.save();
        return str;
    }

    private static String starCodeConfig(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        ensureStarCode(jSONObjectRequireUser, stateStore);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", "What is a star code?");
        jSONObject.put("des", "A star code identifies a creator inside BlockyNexus.");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("title", "How do I use one?");
        jSONObject2.put("des", "Enter a friend's star code to credit their channel.");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("answering", new JSONArray().put(jSONObject).put(jSONObject2));
        jSONObject3.put("introduce", new JSONArray().put(jSONObject));
        jSONObject3.put(FirebaseAnalytics.Param.QUANTITY, 0);
        jSONObject3.put("rate", 0.0d);
        return envelope("obj", jSONObject3.toString());
    }

    private static String starCodeGetByCode(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectFindByStarCode = stateStore.findByStarCode(ctx.query("starCode"));
        if (jSONObjectFindByStarCode == null) {
            return fail("star code not found");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("disable", 0);
        jSONObject.put("id", jSONObjectFindByStarCode.optLong("userId"));
        jSONObject.put("nickName", jSONObjectFindByStarCode.optString("nickName"));
        jSONObject.put("picUrl", jSONObjectFindByStarCode.optString("picUrl"));
        jSONObject.put("starCode", jSONObjectFindByStarCode.optString("starCode"));
        jSONObject.put("userId", jSONObjectFindByStarCode.optLong("userId"));
        return envelope("obj", jSONObject.toString());
    }

    private static String starCodeBilling(Ctx ctx, StateStore stateStore) throws JSONException {
        if (requireUser(ctx, stateStore) == null) {
            return failCode(7, NO_AUTH);
        }
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        if (i2 <= 0) {
            i2 = 20;
        }
        JSONObject jSONObjectEmptyPageObject = emptyPageObject(i2);
        jSONObjectEmptyPageObject.put("pageNo", i);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", jSONObjectEmptyPageObject);
        jSONObject.put("todayProfit", 0.0d);
        return envelope("obj", jSONObject.toString());
    }

    private static JSONObject walletEntity(JSONObject jSONObject, double d2) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("currency", 1);
        jSONObject2.put(StringConstant.CHRISTMAS_DIAMONDS, jSONObject.optLong(StringConstant.CHRISTMAS_DIAMONDS));
        jSONObject2.put("gDiamonds", jSONObject.optLong("gDiamonds"));
        jSONObject2.put("gDiamondsProfit", jSONObject.optLong("gDiamondsProfit", 0L));
        jSONObject2.put(StringConstant.CHRISTMAS_GOLDS, jSONObject.optLong(StringConstant.CHRISTMAS_GOLDS));
        jSONObject2.put("money", d2);
        jSONObject2.put("rewardQuantity", 0);
        jSONObject2.put("userId", jSONObject.optLong("userId"));
        return jSONObject2;
    }

    private static String starCodeCashApply(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        double dOptDouble = jSONObjectBody.optDouble("money", 0.0d);
        if (Double.isNaN(dOptDouble) || dOptDouble <= 0.0d) {
            return fail("money required");
        }
        jSONObjectRequireUser.put("cashApply", jSONObjectBody);
        stateStore.save();
        return envelope("obj", walletEntity(jSONObjectRequireUser, dOptDouble).toString());
    }

    private static String starCodeExchange(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        long jOptLong = jSONObjectRequireUser.optLong("gDiamondsProfit", 0L);
        if (jOptLong > 0) {
            jSONObjectRequireUser.put(StringConstant.CHRISTMAS_DIAMONDS, jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_DIAMONDS) + jOptLong);
            jSONObjectRequireUser.put("gDiamondsProfit", 0);
            stateStore.save();
        }
        return envelope("obj", walletEntity(jSONObjectRequireUser, 0.0d).toString());
    }

    private static String vipPriceList(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("vip", vipProductArray());
        return envelope("obj", jSONObject.toString());
    }

    private static JSONArray vipProductArray() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object[] objArr : VIP_PRODUCTS) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("productId", (String) objArr[0]);
            jSONObject.put("months", ((Integer) objArr[1]).intValue());
            jSONObject.put(FirebaseAnalytics.Param.LEVEL, ((Integer) objArr[2]).intValue());
            jSONObject.put("currency", ((Integer) objArr[3]).intValue());
            jSONObject.put("price", ((Long) objArr[4]).longValue());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private static String vipBuy(Ctx ctx, StateStore stateStore) throws JSONException {
        Object[] objArr;
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strQuery = ctx.query("productId");
        Object[][] objArr2 = VIP_PRODUCTS;
        int length = objArr2.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                objArr = null;
                break;
            }
            Object[] objArr3 = objArr2[i];
            if (((String) objArr3[0]).equals(strQuery)) {
                objArr = objArr3;
                break;
            }
            i++;
        }
        if (objArr == null) {
            return fail("unknown product: " + strQuery);
        }
        long jLongValue = ((Long) objArr[4]).longValue();
        if (jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_GOLDS) < jLongValue) {
            return fail("golds not enough");
        }
        jSONObjectRequireUser.put(StringConstant.CHRISTMAS_GOLDS, jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_GOLDS) - jLongValue);
        int iIntValue = ((Integer) objArr[1]).intValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strOptString = jSONObjectRequireUser.optString("expireDate");
        if (strOptString != null && !strOptString.isEmpty()) {
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(strOptString);
                if (date != null && date.getTime() > jCurrentTimeMillis) {
                    jCurrentTimeMillis = date.getTime();
                }
            } catch (ParseException unused) {
            }
        }
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(jCurrentTimeMillis + (((long) iIntValue) * 2592000000L)));
        jSONObjectRequireUser.put("expireDate", str);
        jSONObjectRequireUser.put("vip", Math.max(jSONObjectRequireUser.optInt("vip"), ((Integer) objArr[2]).intValue()));
        stateStore.save();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(StringConstant.CHRISTMAS_DIAMONDS, jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_DIAMONDS));
        jSONObject.put("diamondsNeed", 0);
        jSONObject.put("expireDate", str);
        jSONObject.put(StringConstant.CHRISTMAS_GOLDS, jSONObjectRequireUser.optLong(StringConstant.CHRISTMAS_GOLDS));
        jSONObject.put("goldsNeed", 0);
        jSONObject.put("userId", jSONObjectRequireUser.optLong("userId"));
        jSONObject.put("vip", jSONObjectRequireUser.optInt("vip"));
        return envelope("obj", jSONObject.toString());
    }

    private static String emailPasswordReset(Ctx ctx, StateStore stateStore) throws JSONException {
        String strQuery = ctx.query("email");
        JSONObject jSONObjectFindByAccount = stateStore.findByAccount(strQuery);
        if (jSONObjectFindByAccount == null) {
            JSONArray jSONArrayNames = stateStore.users().names();
            int i = 0;
            while (true) {
                if (jSONArrayNames != null && i < jSONArrayNames.length()) {
                    JSONObject jSONObjectOptJSONObject = stateStore.users().optJSONObject(jSONArrayNames.optString(i));
                    if (jSONObjectOptJSONObject != null && strQuery != null && strQuery.equalsIgnoreCase(jSONObjectOptJSONObject.optString("email"))) {
                        jSONObjectFindByAccount = jSONObjectOptJSONObject;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        if (jSONObjectFindByAccount != null) {
            jSONObjectFindByAccount.put("emailResetRequested", true);
            stateStore.save();
        }
        return envelope("none", null);
    }

    private static String phonePassword(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectBody = body(ctx);
        String strOptString = jSONObjectBody.optString("phone");
        JSONArray jSONArrayNames = stateStore.users().names();
        for (int i = 0; jSONArrayNames != null && i < jSONArrayNames.length(); i++) {
            jSONObjectOptJSONObject = stateStore.users().optJSONObject(jSONArrayNames.optString(i));
            if (jSONObjectOptJSONObject != null && !strOptString.isEmpty() && strOptString.equals(jSONObjectOptJSONObject.optString("telephone"))) {
                break;
            }
        }
        jSONObjectOptJSONObject = null;
        if (jSONObjectOptJSONObject == null) {
            return fail("phone not bound");
        }
        String strDecryptIfEncrypted = RsaCipher.decryptIfEncrypted(jSONObjectBody.optString("password"));
        String strDecryptIfEncrypted2 = RsaCipher.decryptIfEncrypted(jSONObjectBody.optString("confirmPassword"));
        if (strDecryptIfEncrypted.isEmpty()) {
            return fail("password required");
        }
        if (strDecryptIfEncrypted2 != null && !strDecryptIfEncrypted2.isEmpty() && !strDecryptIfEncrypted.equals(strDecryptIfEncrypted2)) {
            return fail("passwords do not match");
        }
        jSONObjectOptJSONObject.put("password", strDecryptIfEncrypted);
        jSONObjectOptJSONObject.put("hasPassword", true);
        stateStore.save();
        return envelope("none", null);
    }

    private static String ugcStatus(Ctx ctx, StateStore stateStore) {
        return envelope("list", "[]");
    }

    private static int halloweenCandy(JSONObject jSONObject) {
        return jSONObject.optInt("halloweenCandy", 0);
    }

    private static String halloweenInfo(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("activityDesc", "");
        jSONObject.put("activityTitle", "");
        jSONObject.put("candy", halloweenCandy(jSONObjectRequireUser));
        jSONObject.put("candyRate", 0);
        jSONObject.put("rewardList", new JSONArray());
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
        jSONObject.put("surplusGCube", 0);
        jSONObject.put("surplusSeconds", 0);
        jSONObject.put("surplusTime", 0);
        jSONObject.put("taskList", new JSONArray());
        jSONObject.put("taskRewardIcon", "");
        return envelope("obj", jSONObject.toString());
    }

    private static String halloweenTaskInfo(Ctx ctx, StateStore stateStore) {
        if (requireUser(ctx, stateStore) == null) {
            return failCode(7, NO_AUTH);
        }
        return envelope("list", "[]");
    }

    private static String halloweenCandyExchange(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        int i = (int) parseLong(ctx.query("candy"), 0L);
        if (i <= 0) {
            return fail("candy required");
        }
        int iHalloweenCandy = halloweenCandy(jSONObjectRequireUser);
        if (iHalloweenCandy < i) {
            return fail("not enough candy");
        }
        int i2 = iHalloweenCandy - i;
        jSONObjectRequireUser.put("halloweenCandy", i2);
        stateStore.save();
        return envelope("num", String.valueOf(i2));
    }

    private static String halloweenRewardExchange(Ctx ctx, StateStore stateStore) {
        if (requireUser(ctx, stateStore) == null) {
            return failCode(7, NO_AUTH);
        }
        return fail("reward not found");
    }

    private static String halloweenTaskReward(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("acquireCandy", 0);
        jSONObject.put("userCandy", halloweenCandy(jSONObjectRequireUser));
        return envelope("obj", jSONObject.toString());
    }

    private static String bgtubeConfig(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("activityEndTime", "");
        jSONObject.put(AdUnitActivity.EXTRA_ACTIVITY_ID, "");
        jSONObject.put("activityStartTime", "");
        jSONObject.put("awardDate", "");
        jSONObject.put("bestEditingAward", 0);
        jSONObject.put("eventRulesHeadUrl", "");
        jSONObject.put("games", new JSONArray());
        jSONObject.put("excellentPotentialAward", 0);
        jSONObject.put("mostCreativeAward", 0);
        jSONObject.put("mostPopularAward", 0);
        jSONObject.put("optionalSubmissionGameUrls", new JSONArray());
        return envelope("obj", jSONObject.toString());
    }

    private static String bgtubeMultiLang(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("eventRules", new JSONArray());
        jSONObject.put("profitRules", "");
        jSONObject.put("tips", new JSONArray());
        return envelope("obj", jSONObject.toString());
    }

    private static String bgtubeSignInfo(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectRequireUser.optJSONArray("bgtubeLinks");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("countryCode", "");
        jSONObject.put("countryName", "");
        jSONObject.put(au.M, "");
        jSONObject.put("languageName", "");
        jSONObject.put("linkCount", jSONArrayOptJSONArray == null ? 0 : jSONArrayOptJSONArray.length());
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        jSONObject.put("linkList", jSONArrayOptJSONArray);
        jSONObject.put("youtubeName", jSONObjectRequireUser.optString("bgtubeYoutubeName"));
        return envelope("obj", jSONObject.toString());
    }

    private static String bgtubeSignCheck(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("picURl", "");
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, !jSONObjectRequireUser.optString("bgtubeYoutubeName").isEmpty() ? 1 : 0);
        return envelope("obj", jSONObject.toString());
    }

    private static String bgtubeSignUp(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        String strQuery = ctx.query("youTubeName");
        if (strQuery == null || strQuery.isEmpty()) {
            return fail("youTubeName required");
        }
        jSONObjectRequireUser.put("bgtubeYoutubeName", strQuery);
        stateStore.save();
        return envelope("none", null);
    }

    private static String bgtubeVideoLink(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObjectBody = body(ctx);
        if (jSONObjectBody.optString("link").isEmpty()) {
            return fail("link required");
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectRequireUser.optJSONArray("bgtubeLinks");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        jSONArrayOptJSONArray.put(jSONObjectBody.optString("link"));
        jSONObjectRequireUser.put("bgtubeLinks", jSONArrayOptJSONArray);
        stateStore.save();
        return envelope("none", null);
    }

    private static String worldCupGames(Ctx ctx, StateStore stateStore) {
        return envelope("list", "[]");
    }

    private static String worldCupHistory(Ctx ctx, StateStore stateStore) {
        return envelope("list", "[]");
    }

    private static String worldCupIntegral(Ctx ctx, StateStore stateStore) {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        return envelope("num", String.valueOf(jSONObjectRequireUser.optInt("worldCupIntegral", 0)));
    }

    private static String worldCupNotice(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("betUpdateResult", 0);
        jSONObject.put("integralReward", 0);
        jSONObject.put("taskFinished", 0);
        return envelope("obj", jSONObject.toString());
    }

    private static String worldCupBet(Ctx ctx, StateStore stateStore) {
        if (requireUser(ctx, stateStore) == null) {
            return failCode(7, NO_AUTH);
        }
        return fail("campaign not open");
    }

    private static String worldCupMyRank(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRequireUser = requireUser(ctx, stateStore);
        if (jSONObjectRequireUser == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("headPic", jSONObjectRequireUser.optString("picUrl"));
        jSONObject.put(StringConstant.REWARD_TYPE_INTEGRAL, jSONObjectRequireUser.optInt("worldCupIntegral", 0));
        jSONObject.put("isFirst", false);
        jSONObject.put("nickName", jSONObjectRequireUser.optString("nickName"));
        jSONObject.put("rank", 0);
        jSONObject.put("userId", jSONObjectRequireUser.optLong("userId"));
        jSONObject.put("vip", jSONObjectRequireUser.optInt("vip"));
        return envelope("obj", jSONObject.toString());
    }

    private static String worldCupTotalRank(Ctx ctx, StateStore stateStore) throws JSONException {
        int i = (int) parseLong(ctx.query("pageNo"), 1L);
        int i2 = (int) parseLong(ctx.query("pageSize"), 20L);
        if (i2 <= 0) {
            i2 = 20;
        }
        JSONObject jSONObjectEmptyPageObject = emptyPageObject(i2);
        jSONObjectEmptyPageObject.put("pageNo", i);
        return envelope("obj", jSONObjectEmptyPageObject.toString());
    }

    private static String worldCupRewardList(Ctx ctx, StateStore stateStore) throws JSONException {
        if (requireUser(ctx, stateStore) == null) {
            return failCode(7, NO_AUTH);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("decorationList", new JSONArray());
        jSONObject.put("goldReward", 0);
        jSONObject.put("integralNeed", 0);
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
        return envelope("obj", jSONObject.toString());
    }

    private static String worldCupRankReward(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rewardList", new JSONArray());
        jSONObject.put("timeLeft", 0);
        return envelope("obj", jSONObject.toString());
    }

    private static String worldCupTaskList(Ctx ctx, StateStore stateStore) {
        return envelope("list", "[]");
    }

    private static String worldCupTaskReward(Ctx ctx, StateStore stateStore) {
        if (requireUser(ctx, stateStore) == null) {
            return failCode(7, NO_AUTH);
        }
        return fail("task not found");
    }

    private static String worldCupIntegralReward(Ctx ctx, StateStore stateStore) {
        if (requireUser(ctx, stateStore) == null) {
            return failCode(7, NO_AUTH);
        }
        return fail("reward not available");
    }

    private static String bannerList(Ctx ctx, StateStore stateStore) {
        return envelope("list", "[]");
    }

    private static String campaignLogo(Ctx ctx, StateStore stateStore) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("normalLogo", "");
        jSONObject.put("redPointLogo", "");
        return envelope("obj", jSONObject.toString());
    }

    private static String campaignPreciousReward(Ctx ctx, StateStore stateStore) {
        return envelope("list", "[]");
    }

    private static String editorConfig(Ctx ctx, StateStore stateStore) {
        return envelope("obj", "{}");
    }

    private static String moreGameIntro(Ctx ctx, StateStore stateStore) {
        return envelope("list", "[]");
    }

    private static String pageEnvelope(StateStore stateStore, String str, long j, boolean z, int i, int i2, boolean z2) throws JSONException {
        if (i2 <= 0) {
            i2 = 20;
        }
        JSONArray jSONArrayPage = GameCatalog.page(stateStore, str, j, z, i, i2);
        int iCount = GameCatalog.count(stateStore, str, j, z);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", jSONArrayPage);
        jSONObject.put("pageNo", i);
        jSONObject.put("pageSize", i2);
        jSONObject.put("totalPage", totalPages(iCount, i2));
        jSONObject.put("totalSize", iCount);
        if (!z2) {
            return envelope("obj", jSONObject.toString());
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("pageInfo", jSONObject);
        jSONObject2.put("typeId", j);
        return envelope("obj", jSONObject2.toString());
    }

    private static String emptyPage(int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", new JSONArray());
        jSONObject.put("pageNo", 1);
        jSONObject.put("pageSize", i);
        jSONObject.put("totalPage", 0);
        jSONObject.put("totalSize", 0);
        return envelope("obj", jSONObject.toString());
    }

    private static JSONObject emptyPageObject(int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", new JSONArray());
        jSONObject.put("pageNo", 1);
        jSONObject.put("pageSize", i);
        jSONObject.put("totalPage", 0);
        jSONObject.put("totalSize", 0);
        return jSONObject;
    }

    private static int totalPages(int i, int i2) {
        if (i2 <= 0) {
            return 0;
        }
        return ((i + i2) - 1) / i2;
    }

    private static JSONArray slice(JSONArray jSONArray, int i, int i2) {
        JSONArray jSONArray2 = new JSONArray();
        if (i2 <= 0) {
            i2 = 20;
        }
        int iMax = Math.max(0, (i - 1) * i2);
        for (int i3 = iMax; i3 < jSONArray.length() && i3 < iMax + i2; i3++) {
            jSONArray2.put(jSONArray.get(i3));
        }
        return jSONArray2;
    }

    private static long resolveTypeNameToId(StateStore stateStore, String str) throws JSONException {
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        JSONArray jSONArrayCategories = GameCatalog.categories(stateStore);
        for (int i = 0; i < jSONArrayCategories.length(); i++) {
            JSONObject jSONObject = jSONArrayCategories.getJSONObject(i);
            if (str.equals(jSONObject.optString("typeName")) || str.equals(jSONObject.optString("sortType"))) {
                return jSONObject.optLong("typeId");
            }
        }
        return 0L;
    }

    private static String today() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    static String envelope(String str, String str2) {
        StringBuilder sb = new StringBuilder(64);
        sb.append("{\"code\":1,\"message\":\"ok\"");
        if (str2 != null) {
            sb.append(",\"data\":").append(str2);
        } else if ("list".equals(str)) {
            sb.append(",\"data\":[]");
        } else if ("str".equals(str)) {
            sb.append(",\"data\":\"\"");
        } else if ("num".equals(str)) {
            sb.append(",\"data\":0");
        } else if ("bool".equals(str)) {
            sb.append(",\"data\":false");
        } else if ("obj".equals(str)) {
            sb.append(",\"data\":{}");
        }
        sb.append("}");
        return sb.toString();
    }

    private static String userEnvelope(JSONObject jSONObject) {
        return envelope("obj", storelessUserJson(jSONObject));
    }

    private static String storelessUserJson(JSONObject jSONObject) {
        return userJsonLocal(jSONObject);
    }

    private static String userJsonLocal(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userId", jSONObject.optLong("userId"));
        jSONObject2.put(GameSharedConstant.ACCOUNT, jSONObject.optString(GameSharedConstant.ACCOUNT));
        jSONObject2.put("nickName", jSONObject.optString("nickName"));
        jSONObject2.put("sex", jSONObject.optInt("sex"));
        jSONObject2.put("picUrl", jSONObject.optString("picUrl"));
        jSONObject2.put("accessToken", jSONObject.optString("accessToken"));
        jSONObject2.put("details", jSONObject.optString("details"));
        jSONObject2.put("telephone", jSONObject.optString("telephone"));
        jSONObject2.put("email", jSONObject.optString("email"));
        jSONObject2.put("birthday", jSONObject.optString("birthday"));
        jSONObject2.put(StringConstant.CHRISTMAS_GOLDS, jSONObject.optLong(StringConstant.CHRISTMAS_GOLDS));
        jSONObject2.put(StringConstant.CHRISTMAS_DIAMONDS, jSONObject.optLong(StringConstant.CHRISTMAS_DIAMONDS));
        jSONObject2.put("gDiamonds", jSONObject.optLong("gDiamonds"));
        jSONObject2.put("password", jSONObject.optString("password"));
        jSONObject2.put("isFirstLogin", jSONObject.optBoolean("isFirstLogin"));
        jSONObject2.put("expireDate", jSONObject.optString("expireDate"));
        jSONObject2.put("vip", jSONObject.optInt("vip"));
        jSONObject2.put("hasPassword", jSONObject.optBoolean("hasPassword"));
        jSONObject2.put("platform", jSONObject.optString("platform"));
        jSONObject2.put("starCode", jSONObject.optString("starCode"));
        return jSONObject2.toString();
    }

    private static String bool(boolean z) {
        return envelope("bool", z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
    }

    private static String fail(String str) {
        return "{\"code\":0,\"message\":\"" + str + "\"}";
    }

    private static JSONObject body(Ctx ctx) {
        String strBody = ctx.body();
        if (strBody == null) {
            strBody = "";
        }
        String strTrim = strBody.trim();
        if (strTrim.isEmpty()) {
            return new JSONObject();
        }
        try {
            return new JSONObject(strTrim);
        } catch (Throwable th) {
            L.e("body is not JSON (" + abbrev(strTrim) + "): " + th);
            return new JSONObject();
        }
    }

    private static long parseLong(String str, long j) {
        try {
            return Long.parseLong(str.trim());
        } catch (Throwable unused) {
            return j;
        }
    }

    private static double parseDouble(String str) {
        try {
            return Double.parseDouble(str.trim());
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    static String abbrev(String str) {
        if (str == null) {
            return "";
        }
        return str.length() <= 120 ? str : String.valueOf(str.substring(0, 120)) + "...(" + str.length() + "b)";
    }
}
