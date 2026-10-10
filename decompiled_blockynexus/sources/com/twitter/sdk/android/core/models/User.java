package com.twitter.sdk.android.core.models;

import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class User implements f, Serializable {
    public static final long INVALID_ID = -1;
    private static final long serialVersionUID = 4663450696842173958L;

    @com.google.gson.a.c("contributors_enabled")
    public final boolean contributorsEnabled;

    @com.google.gson.a.c("created_at")
    public final String createdAt;

    @com.google.gson.a.c("default_profile")
    public final boolean defaultProfile;

    @com.google.gson.a.c("default_profile_image")
    public final boolean defaultProfileImage;

    @com.google.gson.a.c("description")
    public final String description;

    @com.google.gson.a.c("email")
    public final String email;

    @com.google.gson.a.c("entities")
    public final p entities;

    @com.google.gson.a.c("favourites_count")
    public final int favouritesCount;

    @com.google.gson.a.c("follow_request_sent")
    public final boolean followRequestSent;

    @com.google.gson.a.c("followers_count")
    public final int followersCount;

    @com.google.gson.a.c("friends_count")
    public final int friendsCount;

    @com.google.gson.a.c("geo_enabled")
    public final boolean geoEnabled;

    @com.google.gson.a.c("id")
    public final long id;

    @com.google.gson.a.c("id_str")
    public final String idStr;

    @com.google.gson.a.c("is_translator")
    public final boolean isTranslator;

    @com.google.gson.a.c("lang")
    public final String lang;

    @com.google.gson.a.c("listed_count")
    public final int listedCount;

    @com.google.gson.a.c("location")
    public final String location;

    @com.google.gson.a.c("name")
    public final String name;

    @com.google.gson.a.c("profile_background_color")
    public final String profileBackgroundColor;

    @com.google.gson.a.c("profile_background_image_url")
    public final String profileBackgroundImageUrl;

    @com.google.gson.a.c("profile_background_image_url_https")
    public final String profileBackgroundImageUrlHttps;

    @com.google.gson.a.c("profile_background_tile")
    public final boolean profileBackgroundTile;

    @com.google.gson.a.c("profile_banner_url")
    public final String profileBannerUrl;

    @com.google.gson.a.c("profile_image_url")
    public final String profileImageUrl;

    @com.google.gson.a.c("profile_image_url_https")
    public final String profileImageUrlHttps;

    @com.google.gson.a.c("profile_link_color")
    public final String profileLinkColor;

    @com.google.gson.a.c("profile_sidebar_border_color")
    public final String profileSidebarBorderColor;

    @com.google.gson.a.c("profile_sidebar_fill_color")
    public final String profileSidebarFillColor;

    @com.google.gson.a.c("profile_text_color")
    public final String profileTextColor;

    @com.google.gson.a.c("profile_use_background_image")
    public final boolean profileUseBackgroundImage;

    @com.google.gson.a.c("protected")
    public final boolean protectedUser;

    @com.google.gson.a.c(FirebaseAnalytics.Param.SCREEN_NAME)
    public final String screenName;

    @com.google.gson.a.c("show_all_inline_media")
    public final boolean showAllInlineMedia;

    @com.google.gson.a.c(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)
    public final m status;

    @com.google.gson.a.c("statuses_count")
    public final int statusesCount;

    @com.google.gson.a.c("time_zone")
    public final String timeZone;

    @com.google.gson.a.c("url")
    public final String url;

    @com.google.gson.a.c("utc_offset")
    public final int utcOffset;

    @com.google.gson.a.c("verified")
    public final boolean verified;

    @com.google.gson.a.c("withheld_in_countries")
    public final List<String> withheldInCountries;

    @com.google.gson.a.c("withheld_scope")
    public final String withheldScope;

    public User(boolean z, String str, boolean z2, boolean z3, String str2, String str3, p pVar, int i, boolean z4, int i2, int i3, boolean z5, long j, String str4, boolean z6, String str5, int i4, String str6, String str7, String str8, String str9, String str10, boolean z7, String str11, String str12, String str13, String str14, String str15, String str16, String str17, boolean z8, boolean z9, String str18, boolean z10, m mVar, int i5, String str19, String str20, int i6, boolean z11, List<String> list, String str21) {
        this.contributorsEnabled = z;
        this.createdAt = str;
        this.defaultProfile = z2;
        this.defaultProfileImage = z3;
        this.description = str2;
        this.email = str3;
        this.entities = pVar;
        this.favouritesCount = i;
        this.followRequestSent = z4;
        this.followersCount = i2;
        this.friendsCount = i3;
        this.geoEnabled = z5;
        this.id = j;
        this.idStr = str4;
        this.isTranslator = z6;
        this.lang = str5;
        this.listedCount = i4;
        this.location = str6;
        this.name = str7;
        this.profileBackgroundColor = str8;
        this.profileBackgroundImageUrl = str9;
        this.profileBackgroundImageUrlHttps = str10;
        this.profileBackgroundTile = z7;
        this.profileBannerUrl = str11;
        this.profileImageUrl = str12;
        this.profileImageUrlHttps = str13;
        this.profileLinkColor = str14;
        this.profileSidebarBorderColor = str15;
        this.profileSidebarFillColor = str16;
        this.profileTextColor = str17;
        this.profileUseBackgroundImage = z8;
        this.protectedUser = z9;
        this.screenName = str18;
        this.showAllInlineMedia = z10;
        this.status = mVar;
        this.statusesCount = i5;
        this.timeZone = str19;
        this.url = str20;
        this.utcOffset = i6;
        this.verified = z11;
        this.withheldInCountries = list;
        this.withheldScope = str21;
    }

    @Override // com.twitter.sdk.android.core.models.f
    public long getId() {
        return this.id;
    }
}
