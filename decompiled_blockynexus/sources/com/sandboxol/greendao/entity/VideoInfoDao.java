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
public class VideoInfoDao extends a<VideoInfo, Long> {
    public static final String TABLENAME = "VIDEO_INFO";
    private final k tagConverter;

    public static class Properties {
        public static final f ID = new f(0, Long.class, "ID", true, ay.f20688d);
        public static final f AuthorId = new f(1, Long.TYPE, "authorId", false, "AUTHOR_ID");
        public static final f AuthorName = new f(2, String.class, "authorName", false, "AUTHOR_NAME");
        public static final f DislikeNumber = new f(3, Integer.TYPE, "dislikeNumber", false, "DISLIKE_NUMBER");
        public static final f IsPublish = new f(4, Integer.TYPE, "isPublish", false, "IS_PUBLISH");
        public static final f LikeNumber = new f(5, Integer.TYPE, "likeNumber", false, "LIKE_NUMBER");
        public static final f PlayAmount = new f(6, Long.TYPE, "playAmount", false, "PLAY_AMOUNT");
        public static final f Title = new f(7, String.class, "title", false, ShareConstants.TITLE);
        public static final f VideoId = new f(8, Long.TYPE, "videoId", false, "VIDEO_ID");
        public static final f VideoPic = new f(9, String.class, "videoPic", false, "VIDEO_PIC");
        public static final f VideoTime = new f(10, Long.TYPE, "videoTime", false, "VIDEO_TIME");
        public static final f VideoUrl = new f(11, String.class, "videoUrl", false, "VIDEO_URL");
        public static final f YoutubeUrl = new f(12, String.class, "youtubeUrl", false, "YOUTUBE_URL");
        public static final f Tag = new f(13, String.class, "tag", false, "TAG");
        public static final f IsFirst = new f(14, Boolean.TYPE, "isFirst", false, "IS_FIRST");
    }

    public VideoInfoDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
        this.tagConverter = new k();
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"VIDEO_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"AUTHOR_ID\" INTEGER NOT NULL ,\"AUTHOR_NAME\" TEXT,\"DISLIKE_NUMBER\" INTEGER NOT NULL ,\"IS_PUBLISH\" INTEGER NOT NULL ,\"LIKE_NUMBER\" INTEGER NOT NULL ,\"PLAY_AMOUNT\" INTEGER NOT NULL ,\"TITLE\" TEXT,\"VIDEO_ID\" INTEGER NOT NULL ,\"VIDEO_PIC\" TEXT,\"VIDEO_TIME\" INTEGER NOT NULL ,\"VIDEO_URL\" TEXT,\"YOUTUBE_URL\" TEXT,\"TAG\" TEXT,\"IS_FIRST\" INTEGER NOT NULL );");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"VIDEO_INFO\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(VideoInfo videoInfo) {
        if (videoInfo != null) {
            return videoInfo.getID();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(VideoInfo videoInfo) {
        return videoInfo.getID() != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final Long updateKeyAfterInsert(VideoInfo videoInfo, long j) {
        videoInfo.setID(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public VideoInfoDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
        this.tagConverter = new k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, VideoInfo videoInfo) {
        cVar.d();
        Long id = videoInfo.getID();
        if (id != null) {
            cVar.a(1, id.longValue());
        }
        cVar.a(2, videoInfo.getAuthorId());
        String authorName = videoInfo.getAuthorName();
        if (authorName != null) {
            cVar.a(3, authorName);
        }
        cVar.a(4, videoInfo.getDislikeNumber());
        cVar.a(5, videoInfo.getIsPublish());
        cVar.a(6, videoInfo.getLikeNumber());
        cVar.a(7, videoInfo.getPlayAmount());
        String title = videoInfo.getTitle();
        if (title != null) {
            cVar.a(8, title);
        }
        cVar.a(9, videoInfo.getVideoId());
        String videoPic = videoInfo.getVideoPic();
        if (videoPic != null) {
            cVar.a(10, videoPic);
        }
        cVar.a(11, videoInfo.getVideoTime());
        String videoUrl = videoInfo.getVideoUrl();
        if (videoUrl != null) {
            cVar.a(12, videoUrl);
        }
        String youtubeUrl = videoInfo.getYoutubeUrl();
        if (youtubeUrl != null) {
            cVar.a(13, youtubeUrl);
        }
        Map<String, String> tag = videoInfo.getTag();
        if (tag != null) {
            cVar.a(14, this.tagConverter.a(tag));
        }
        cVar.a(15, videoInfo.getIsFirst() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public VideoInfo readEntity(Cursor cursor, int i) {
        String str;
        Map<String, String> mapA;
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        long j = cursor.getLong(i + 1);
        int i3 = i + 2;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = cursor.getInt(i + 3);
        int i5 = cursor.getInt(i + 4);
        int i6 = cursor.getInt(i + 5);
        long j2 = cursor.getLong(i + 6);
        int i7 = i + 7;
        String string2 = cursor.isNull(i7) ? null : cursor.getString(i7);
        long j3 = cursor.getLong(i + 8);
        int i8 = i + 9;
        String string3 = cursor.isNull(i8) ? null : cursor.getString(i8);
        long j4 = cursor.getLong(i + 10);
        int i9 = i + 11;
        String string4 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 12;
        String string5 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = i + 13;
        if (cursor.isNull(i11)) {
            mapA = null;
            str = string3;
        } else {
            str = string3;
            mapA = this.tagConverter.a(cursor.getString(i11));
        }
        return new VideoInfo(lValueOf, j, string, i4, i5, i6, j2, string2, j3, str, j4, string4, string5, mapA, cursor.getShort(i + 14) != 0);
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, VideoInfo videoInfo, int i) {
        int i2 = i + 0;
        videoInfo.setID(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        videoInfo.setAuthorId(cursor.getLong(i + 1));
        int i3 = i + 2;
        videoInfo.setAuthorName(cursor.isNull(i3) ? null : cursor.getString(i3));
        videoInfo.setDislikeNumber(cursor.getInt(i + 3));
        videoInfo.setIsPublish(cursor.getInt(i + 4));
        videoInfo.setLikeNumber(cursor.getInt(i + 5));
        videoInfo.setPlayAmount(cursor.getLong(i + 6));
        int i4 = i + 7;
        videoInfo.setTitle(cursor.isNull(i4) ? null : cursor.getString(i4));
        videoInfo.setVideoId(cursor.getLong(i + 8));
        int i5 = i + 9;
        videoInfo.setVideoPic(cursor.isNull(i5) ? null : cursor.getString(i5));
        videoInfo.setVideoTime(cursor.getLong(i + 10));
        int i6 = i + 11;
        videoInfo.setVideoUrl(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 12;
        videoInfo.setYoutubeUrl(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 13;
        videoInfo.setTag(cursor.isNull(i8) ? null : this.tagConverter.a(cursor.getString(i8)));
        videoInfo.setIsFirst(cursor.getShort(i + 14) != 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, VideoInfo videoInfo) {
        sQLiteStatement.clearBindings();
        Long id = videoInfo.getID();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindLong(2, videoInfo.getAuthorId());
        String authorName = videoInfo.getAuthorName();
        if (authorName != null) {
            sQLiteStatement.bindString(3, authorName);
        }
        sQLiteStatement.bindLong(4, videoInfo.getDislikeNumber());
        sQLiteStatement.bindLong(5, videoInfo.getIsPublish());
        sQLiteStatement.bindLong(6, videoInfo.getLikeNumber());
        sQLiteStatement.bindLong(7, videoInfo.getPlayAmount());
        String title = videoInfo.getTitle();
        if (title != null) {
            sQLiteStatement.bindString(8, title);
        }
        sQLiteStatement.bindLong(9, videoInfo.getVideoId());
        String videoPic = videoInfo.getVideoPic();
        if (videoPic != null) {
            sQLiteStatement.bindString(10, videoPic);
        }
        sQLiteStatement.bindLong(11, videoInfo.getVideoTime());
        String videoUrl = videoInfo.getVideoUrl();
        if (videoUrl != null) {
            sQLiteStatement.bindString(12, videoUrl);
        }
        String youtubeUrl = videoInfo.getYoutubeUrl();
        if (youtubeUrl != null) {
            sQLiteStatement.bindString(13, youtubeUrl);
        }
        Map<String, String> tag = videoInfo.getTag();
        if (tag != null) {
            sQLiteStatement.bindString(14, this.tagConverter.a(tag));
        }
        sQLiteStatement.bindLong(15, videoInfo.getIsFirst() ? 1L : 0L);
    }
}
