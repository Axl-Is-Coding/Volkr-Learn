package com.sandboxol.greendao.entity;

import java.util.Map;
import org.greenrobot.greendao.c;
import org.greenrobot.greendao.c.a;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* JADX INFO: loaded from: classes3.dex */
public class DaoSession extends c {
    private final FloatViewInfoDao floatViewInfoDao;
    private final a floatViewInfoDaoConfig;
    private final FriendDao friendDao;
    private final a friendDaoConfig;
    private final FriendPartyStatusDao friendPartyStatusDao;
    private final a friendPartyStatusDaoConfig;
    private final GameDao gameDao;
    private final a gameDaoConfig;
    private final GameDiskCacheInfoDao gameDiskCacheInfoDao;
    private final a gameDiskCacheInfoDaoConfig;
    private final PartyMemberInfoDao partyMemberInfoDao;
    private final a partyMemberInfoDaoConfig;
    private final ScrapTreasureRewardInfoDao scrapTreasureRewardInfoDao;
    private final a scrapTreasureRewardInfoDaoConfig;
    private final TeamUIMessageDao teamUIMessageDao;
    private final a teamUIMessageDaoConfig;
    private final TribeMemberDao tribeMemberDao;
    private final a tribeMemberDaoConfig;
    private final UserCacheDao userCacheDao;
    private final a userCacheDaoConfig;
    private final UserDao userDao;
    private final a userDaoConfig;
    private final UserGameRecordInfoDao userGameRecordInfoDao;
    private final a userGameRecordInfoDaoConfig;
    private final UserInfoDao userInfoDao;
    private final a userInfoDaoConfig;
    private final VideoDetailInfoDao videoDetailInfoDao;
    private final a videoDetailInfoDaoConfig;
    private final VideoInfoDao videoInfoDao;
    private final a videoInfoDaoConfig;

    public DaoSession(org.greenrobot.greendao.b.a aVar, IdentityScopeType identityScopeType, Map<Class<? extends org.greenrobot.greendao.a<?, ?>>, a> map) {
        super(aVar);
        this.floatViewInfoDaoConfig = map.get(FloatViewInfoDao.class).clone();
        this.floatViewInfoDaoConfig.a(identityScopeType);
        this.partyMemberInfoDaoConfig = map.get(PartyMemberInfoDao.class).clone();
        this.partyMemberInfoDaoConfig.a(identityScopeType);
        this.userCacheDaoConfig = map.get(UserCacheDao.class).clone();
        this.userCacheDaoConfig.a(identityScopeType);
        this.videoDetailInfoDaoConfig = map.get(VideoDetailInfoDao.class).clone();
        this.videoDetailInfoDaoConfig.a(identityScopeType);
        this.tribeMemberDaoConfig = map.get(TribeMemberDao.class).clone();
        this.tribeMemberDaoConfig.a(identityScopeType);
        this.friendDaoConfig = map.get(FriendDao.class).clone();
        this.friendDaoConfig.a(identityScopeType);
        this.userDaoConfig = map.get(UserDao.class).clone();
        this.userDaoConfig.a(identityScopeType);
        this.userGameRecordInfoDaoConfig = map.get(UserGameRecordInfoDao.class).clone();
        this.userGameRecordInfoDaoConfig.a(identityScopeType);
        this.scrapTreasureRewardInfoDaoConfig = map.get(ScrapTreasureRewardInfoDao.class).clone();
        this.scrapTreasureRewardInfoDaoConfig.a(identityScopeType);
        this.gameDiskCacheInfoDaoConfig = map.get(GameDiskCacheInfoDao.class).clone();
        this.gameDiskCacheInfoDaoConfig.a(identityScopeType);
        this.videoInfoDaoConfig = map.get(VideoInfoDao.class).clone();
        this.videoInfoDaoConfig.a(identityScopeType);
        this.friendPartyStatusDaoConfig = map.get(FriendPartyStatusDao.class).clone();
        this.friendPartyStatusDaoConfig.a(identityScopeType);
        this.teamUIMessageDaoConfig = map.get(TeamUIMessageDao.class).clone();
        this.teamUIMessageDaoConfig.a(identityScopeType);
        this.userInfoDaoConfig = map.get(UserInfoDao.class).clone();
        this.userInfoDaoConfig.a(identityScopeType);
        this.gameDaoConfig = map.get(GameDao.class).clone();
        this.gameDaoConfig.a(identityScopeType);
        this.floatViewInfoDao = new FloatViewInfoDao(this.floatViewInfoDaoConfig, this);
        this.partyMemberInfoDao = new PartyMemberInfoDao(this.partyMemberInfoDaoConfig, this);
        this.userCacheDao = new UserCacheDao(this.userCacheDaoConfig, this);
        this.videoDetailInfoDao = new VideoDetailInfoDao(this.videoDetailInfoDaoConfig, this);
        this.tribeMemberDao = new TribeMemberDao(this.tribeMemberDaoConfig, this);
        this.friendDao = new FriendDao(this.friendDaoConfig, this);
        this.userDao = new UserDao(this.userDaoConfig, this);
        this.userGameRecordInfoDao = new UserGameRecordInfoDao(this.userGameRecordInfoDaoConfig, this);
        this.scrapTreasureRewardInfoDao = new ScrapTreasureRewardInfoDao(this.scrapTreasureRewardInfoDaoConfig, this);
        this.gameDiskCacheInfoDao = new GameDiskCacheInfoDao(this.gameDiskCacheInfoDaoConfig, this);
        this.videoInfoDao = new VideoInfoDao(this.videoInfoDaoConfig, this);
        this.friendPartyStatusDao = new FriendPartyStatusDao(this.friendPartyStatusDaoConfig, this);
        this.teamUIMessageDao = new TeamUIMessageDao(this.teamUIMessageDaoConfig, this);
        this.userInfoDao = new UserInfoDao(this.userInfoDaoConfig, this);
        this.gameDao = new GameDao(this.gameDaoConfig, this);
        registerDao(FloatViewInfo.class, this.floatViewInfoDao);
        registerDao(PartyMemberInfo.class, this.partyMemberInfoDao);
        registerDao(UserCache.class, this.userCacheDao);
        registerDao(VideoDetailInfo.class, this.videoDetailInfoDao);
        registerDao(TribeMember.class, this.tribeMemberDao);
        registerDao(Friend.class, this.friendDao);
        registerDao(User.class, this.userDao);
        registerDao(UserGameRecordInfo.class, this.userGameRecordInfoDao);
        registerDao(ScrapTreasureRewardInfo.class, this.scrapTreasureRewardInfoDao);
        registerDao(GameDiskCacheInfo.class, this.gameDiskCacheInfoDao);
        registerDao(VideoInfo.class, this.videoInfoDao);
        registerDao(FriendPartyStatus.class, this.friendPartyStatusDao);
        registerDao(TeamUIMessage.class, this.teamUIMessageDao);
        registerDao(UserInfo.class, this.userInfoDao);
        registerDao(Game.class, this.gameDao);
    }

    public void clear() {
        this.floatViewInfoDaoConfig.b();
        this.partyMemberInfoDaoConfig.b();
        this.userCacheDaoConfig.b();
        this.videoDetailInfoDaoConfig.b();
        this.tribeMemberDaoConfig.b();
        this.friendDaoConfig.b();
        this.userDaoConfig.b();
        this.userGameRecordInfoDaoConfig.b();
        this.scrapTreasureRewardInfoDaoConfig.b();
        this.gameDiskCacheInfoDaoConfig.b();
        this.videoInfoDaoConfig.b();
        this.friendPartyStatusDaoConfig.b();
        this.teamUIMessageDaoConfig.b();
        this.userInfoDaoConfig.b();
        this.gameDaoConfig.b();
    }

    public FloatViewInfoDao getFloatViewInfoDao() {
        return this.floatViewInfoDao;
    }

    public FriendDao getFriendDao() {
        return this.friendDao;
    }

    public FriendPartyStatusDao getFriendPartyStatusDao() {
        return this.friendPartyStatusDao;
    }

    public GameDao getGameDao() {
        return this.gameDao;
    }

    public GameDiskCacheInfoDao getGameDiskCacheInfoDao() {
        return this.gameDiskCacheInfoDao;
    }

    public PartyMemberInfoDao getPartyMemberInfoDao() {
        return this.partyMemberInfoDao;
    }

    public ScrapTreasureRewardInfoDao getScrapTreasureRewardInfoDao() {
        return this.scrapTreasureRewardInfoDao;
    }

    public TeamUIMessageDao getTeamUIMessageDao() {
        return this.teamUIMessageDao;
    }

    public TribeMemberDao getTribeMemberDao() {
        return this.tribeMemberDao;
    }

    public UserCacheDao getUserCacheDao() {
        return this.userCacheDao;
    }

    public UserDao getUserDao() {
        return this.userDao;
    }

    public UserGameRecordInfoDao getUserGameRecordInfoDao() {
        return this.userGameRecordInfoDao;
    }

    public UserInfoDao getUserInfoDao() {
        return this.userInfoDao;
    }

    public VideoDetailInfoDao getVideoDetailInfoDao() {
        return this.videoDetailInfoDao;
    }

    public VideoInfoDao getVideoInfoDao() {
        return this.videoInfoDao;
    }
}
