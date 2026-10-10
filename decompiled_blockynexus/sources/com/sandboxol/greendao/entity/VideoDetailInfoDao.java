package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import com.sandboxol.greendao.b.k;
import com.umeng.analytics.pro.ay;
import java.util.Map;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class VideoDetailInfoDao extends a<VideoDetailInfo, Long> {
    public static final String TABLENAME = "VIDEO_DETAIL_INFO";
    private final k tagConverter;

    public static class Properties {
        public static final f AuthorId = new f(0, Long.TYPE, "authorId", false, "AUTHOR_ID");
        public static final f AuthorName = new f(1, String.class, "authorName", false, "AUTHOR_NAME");
        public static final f DislikeNumber = new f(2, Integer.TYPE, "dislikeNumber", false, "DISLIKE_NUMBER");
        public static final f IsPublish = new f(3, Integer.TYPE, "isPublish", false, "IS_PUBLISH");
        public static final f LikeNumber = new f(4, Integer.TYPE, "likeNumber", false, "LIKE_NUMBER");
        public static final f PlayAmount = new f(5, Long.TYPE, "playAmount", false, "PLAY_AMOUNT");
        public static final f EvaluateStatus = new f(6, Integer.TYPE, "evaluateStatus", false, "EVALUATE_STATUS");
        public static final f Title = new f(7, String.class, "title", false, ShareConstants.TITLE);
        public static final f AuthorPicUrl = new f(8, String.class, "authorPicUrl", false, "AUTHOR_PIC_URL");
        public static final f YoutubeUrl = new f(9, String.class, "youtubeUrl", false, "YOUTUBE_URL");
        public static final f VideoId = new f(10, Long.TYPE, "videoId", true, ay.f20688d);
        public static final f VideoPic = new f(11, String.class, "videoPic", false, "VIDEO_PIC");
        public static final f VideoTime = new f(12, Long.TYPE, "videoTime", false, "VIDEO_TIME");
        public static final f VideoUrl = new f(13, String.class, "videoUrl", false, "VIDEO_URL");
        public static final f Tag = new f(14, String.class, "tag", false, "TAG");
    }

    public VideoDetailInfoDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
        this.tagConverter = new k();
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"VIDEO_DETAIL_INFO\" (\"AUTHOR_ID\" INTEGER NOT NULL ,\"AUTHOR_NAME\" TEXT,\"DISLIKE_NUMBER\" INTEGER NOT NULL ,\"IS_PUBLISH\" INTEGER NOT NULL ,\"LIKE_NUMBER\" INTEGER NOT NULL ,\"PLAY_AMOUNT\" INTEGER NOT NULL ,\"EVALUATE_STATUS\" INTEGER NOT NULL ,\"TITLE\" TEXT,\"AUTHOR_PIC_URL\" TEXT,\"YOUTUBE_URL\" TEXT,\"_id\" INTEGER PRIMARY KEY NOT NULL ,\"VIDEO_PIC\" TEXT,\"VIDEO_TIME\" INTEGER NOT NULL ,\"VIDEO_URL\" TEXT,\"TAG\" TEXT);");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"VIDEO_DETAIL_INFO\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(VideoDetailInfo videoDetailInfo) {
        if (videoDetailInfo != null) {
            return Long.valueOf(videoDetailInfo.getVideoId());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(VideoDetailInfo videoDetailInfo) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final Long updateKeyAfterInsert(VideoDetailInfo videoDetailInfo, long j) {
        videoDetailInfo.setVideoId(j);
        return Long.valueOf(j);
    }

    public VideoDetailInfoDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
        this.tagConverter = new k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, VideoDetailInfo videoDetailInfo) {
        cVar.d();
        cVar.a(1, videoDetailInfo.getAuthorId());
        String authorName = videoDetailInfo.getAuthorName();
        if (authorName != null) {
            cVar.a(2, authorName);
        }
        cVar.a(3, videoDetailInfo.getDislikeNumber());
        cVar.a(4, videoDetailInfo.getIsPublish());
        cVar.a(5, videoDetailInfo.getLikeNumber());
        cVar.a(6, videoDetailInfo.getPlayAmount());
        cVar.a(7, videoDetailInfo.getEvaluateStatus());
        String title = videoDetailInfo.getTitle();
        if (title != null) {
            cVar.a(8, title);
        }
        String authorPicUrl = videoDetailInfo.getAuthorPicUrl();
        if (authorPicUrl != null) {
            cVar.a(9, authorPicUrl);
        }
        String youtubeUrl = videoDetailInfo.getYoutubeUrl();
        if (youtubeUrl != null) {
            cVar.a(10, youtubeUrl);
        }
        cVar.a(11, videoDetailInfo.getVideoId());
        String videoPic = videoDetailInfo.getVideoPic();
        if (videoPic != null) {
            cVar.a(12, videoPic);
        }
        cVar.a(13, videoDetailInfo.getVideoTime());
        String videoUrl = videoDetailInfo.getVideoUrl();
        if (videoUrl != null) {
            cVar.a(14, videoUrl);
        }
        Map<String, String> tag = videoDetailInfo.getTag();
        if (tag != null) {
            cVar.a(15, this.tagConverter.a(tag));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public VideoDetailInfo readEntity(Cursor cursor, int i) {
        long j;
        Map<String, String> mapA;
        long j2 = cursor.getLong(i + 0);
        int i2 = i + 1;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = cursor.getInt(i + 2);
        int i4 = cursor.getInt(i + 3);
        int i5 = cursor.getInt(i + 4);
        long j3 = cursor.getLong(i + 5);
        int i6 = cursor.getInt(i + 6);
        int i7 = i + 7;
        String string2 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 8;
        String string3 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 9;
        String string4 = cursor.isNull(i9) ? null : cursor.getString(i9);
        long j4 = cursor.getLong(i + 10);
        int i10 = i + 11;
        String string5 = cursor.isNull(i10) ? null : cursor.getString(i10);
        long j5 = cursor.getLong(i + 12);
        int i11 = i + 13;
        String string6 = cursor.isNull(i11) ? null : cursor.getString(i11);
        int i12 = i + 14;
        if (cursor.isNull(i12)) {
            mapA = null;
            j = j4;
        } else {
            j = j4;
            mapA = this.tagConverter.a(cursor.getString(i12));
        }
        return new VideoDetailInfo(j2, string, i3, i4, i5, j3, i6, string2, string3, string4, j, string5, j5, string6, mapA);
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, VideoDetailInfo videoDetailInfo, int i) {
        videoDetailInfo.setAuthorId(cursor.getLong(i + 0));
        int i2 = i + 1;
        videoDetailInfo.setAuthorName(cursor.isNull(i2) ? null : cursor.getString(i2));
        videoDetailInfo.setDislikeNumber(cursor.getInt(i + 2));
        videoDetailInfo.setIsPublish(cursor.getInt(i + 3));
        videoDetailInfo.setLikeNumber(cursor.getInt(i + 4));
        videoDetailInfo.setPlayAmount(cursor.getLong(i + 5));
        videoDetailInfo.setEvaluateStatus(cursor.getInt(i + 6));
        int i3 = i + 7;
        videoDetailInfo.setTitle(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 8;
        videoDetailInfo.setAuthorPicUrl(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 9;
        videoDetailInfo.setYoutubeUrl(cursor.isNull(i5) ? null : cursor.getString(i5));
        videoDetailInfo.setVideoId(cursor.getLong(i + 10));
        int i6 = i + 11;
        videoDetailInfo.setVideoPic(cursor.isNull(i6) ? null : cursor.getString(i6));
        videoDetailInfo.setVideoTime(cursor.getLong(i + 12));
        int i7 = i + 13;
        videoDetailInfo.setVideoUrl(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 14;
        videoDetailInfo.setTag(cursor.isNull(i8) ? null : this.tagConverter.a(cursor.getString(i8)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, VideoDetailInfo videoDetailInfo) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, videoDetailInfo.getAuthorId());
        String authorName = videoDetailInfo.getAuthorName();
        if (authorName != null) {
            sQLiteStatement.bindString(2, authorName);
        }
        sQLiteStatement.bindLong(3, videoDetailInfo.getDislikeNumber());
        sQLiteStatement.bindLong(4, videoDetailInfo.getIsPublish());
        sQLiteStatement.bindLong(5, videoDetailInfo.getLikeNumber());
        sQLiteStatement.bindLong(6, videoDetailInfo.getPlayAmount());
        sQLiteStatement.bindLong(7, videoDetailInfo.getEvaluateStatus());
        String title = videoDetailInfo.getTitle();
        if (title != null) {
            sQLiteStatement.bindString(8, title);
        }
        String authorPicUrl = videoDetailInfo.getAuthorPicUrl();
        if (authorPicUrl != null) {
            sQLiteStatement.bindString(9, authorPicUrl);
        }
        String youtubeUrl = videoDetailInfo.getYoutubeUrl();
        if (youtubeUrl != null) {
            sQLiteStatement.bindString(10, youtubeUrl);
        }
        sQLiteStatement.bindLong(11, videoDetailInfo.getVideoId());
        String videoPic = videoDetailInfo.getVideoPic();
        if (videoPic != null) {
            sQLiteStatement.bindString(12, videoPic);
        }
        sQLiteStatement.bindLong(13, videoDetailInfo.getVideoTime());
        String videoUrl = videoDetailInfo.getVideoUrl();
        if (videoUrl != null) {
            sQLiteStatement.bindString(14, videoUrl);
        }
        Map<String, String> tag = videoDetailInfo.getTag();
        if (tag != null) {
            sQLiteStatement.bindString(15, this.tagConverter.a(tag));
        }
    }
}
