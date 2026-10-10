package io.rong.imkit.userInfoCache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.rong.common.RLog;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.UserInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class RongDatabaseDao {
    private static final String TAG = "RongDatabaseDao";
    private SQLiteDatabase db;
    private final String usersTable = "users";
    private final String groupUsersTable = "group_users";
    private final String groupsTable = "groups";
    private final String discussionsTable = "discussions";

    RongDatabaseDao() {
    }

    void close() {
        SQLiteDatabase sQLiteDatabase = this.db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.db = null;
        }
    }

    protected void finalize() throws Throwable {
        SQLiteDatabase sQLiteDatabase = this.db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        super.finalize();
    }

    List<UserInfo> getAllUserInfo() {
        Cursor cursorQuery = null;
        if (this.db == null) {
            RLog.w(TAG, "getUserInfo db is invalid");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursorQuery = this.db.query("users", null, null, null, null, null, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("portrait"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                        UserInfo userInfo = new UserInfo(string, string2, Uri.parse(string3));
                        userInfo.setExtra(string4);
                        arrayList.add(userInfo);
                    }
                }
            } catch (Exception e2) {
                RLog.e(TAG, "getAllUserInfo e:" + e2);
                if (cursorQuery != null) {
                }
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    Discussion getDiscussionInfo(String str) throws Throwable {
        Cursor cursorQuery;
        Discussion discussion = null;
        if (str == null) {
            RLog.w(TAG, "getDiscussionInfo parameter is invalid");
            return null;
        }
        SQLiteDatabase sQLiteDatabase = this.db;
        if (sQLiteDatabase == null) {
            RLog.w(TAG, "getDiscussionInfo db is invalid");
            return null;
        }
        try {
            cursorQuery = sQLiteDatabase.query("discussions", null, "id = ?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        discussion = new Discussion(cursorQuery.getString(cursorQuery.getColumnIndex("id")), cursorQuery.getString(cursorQuery.getColumnIndex("name")));
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return discussion;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    Group getGroupInfo(String str) throws Throwable {
        Cursor cursorQuery;
        Group group = null;
        if (str == null) {
            RLog.w(TAG, "getGroupInfo parameter is invalid");
            return null;
        }
        SQLiteDatabase sQLiteDatabase = this.db;
        if (sQLiteDatabase == null) {
            RLog.w(TAG, "getGroupInfo db is invalid");
            return null;
        }
        try {
            cursorQuery = sQLiteDatabase.query("groups", null, "id = ?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        group = new Group(cursorQuery.getString(cursorQuery.getColumnIndex("id")), cursorQuery.getString(cursorQuery.getColumnIndex("name")), Uri.parse(cursorQuery.getString(cursorQuery.getColumnIndex("portrait"))));
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return group;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    GroupUserInfo getGroupUserInfo(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        GroupUserInfo groupUserInfo = null;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            RLog.w(TAG, "getGroupUserInfo parameter is invalid");
            return null;
        }
        SQLiteDatabase sQLiteDatabase = this.db;
        if (sQLiteDatabase == null) {
            RLog.w(TAG, "getGroupUserInfo db is invalid");
            return null;
        }
        try {
            cursorQuery = sQLiteDatabase.query("group_users", null, "group_id = ? and user_id = ?", new String[]{str, str2}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        groupUserInfo = new GroupUserInfo(cursorQuery.getString(cursorQuery.getColumnIndex(FirebaseAnalytics.Param.GROUP_ID)), cursorQuery.getString(cursorQuery.getColumnIndex("user_id")), cursorQuery.getString(cursorQuery.getColumnIndex("nickname")));
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return groupUserInfo;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    UserInfo getUserInfo(String str) throws Throwable {
        Cursor cursorQuery;
        UserInfo userInfo;
        Cursor cursor = null;
        userInfo = null;
        UserInfo userInfo2 = null;
        cursor = null;
        if (TextUtils.isEmpty(str)) {
            RLog.w(TAG, "getUserInfo userId is invalid");
            return null;
        }
        SQLiteDatabase sQLiteDatabase = this.db;
        if (sQLiteDatabase == null) {
            RLog.w(TAG, "getUserInfo db is invalid");
            return null;
        }
        try {
            try {
                cursorQuery = sQLiteDatabase.query("users", null, "id = ?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
                                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("portrait"));
                                String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                                userInfo = new UserInfo(string, string2, Uri.parse(string3));
                                try {
                                    userInfo.setExtra(string4);
                                    userInfo2 = userInfo;
                                } catch (Exception e2) {
                                    e = e2;
                                    cursor = cursorQuery;
                                    RLog.e(TAG, "getUserInfo : ", e);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return userInfo;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            userInfo = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery == null) {
                    return userInfo2;
                }
                cursorQuery.close();
                return userInfo2;
            } catch (Exception e4) {
                e = e4;
                userInfo = null;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = cursor;
        }
    }

    synchronized void insertDiscussionInfo(Discussion discussion) {
        if (discussion != null) {
            if (discussion.getId() != null) {
                if (this.db == null) {
                    RLog.w(TAG, "insertDiscussionInfo db is invalid");
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", discussion.getId());
                contentValues.put("name", discussion.getName());
                contentValues.put("portrait", "");
                this.db.insert("discussions", null, contentValues);
                return;
            }
        }
        RLog.w(TAG, "insertDiscussionInfo parameter is invalid");
    }

    synchronized void insertGroupInfo(Group group) {
        if (group != null) {
            if (group.getId() != null) {
                if (this.db == null) {
                    RLog.w(TAG, "insertGroupInfo db is invalid");
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", group.getId());
                contentValues.put("name", group.getName());
                contentValues.put("portrait", group.getPortraitUri() + "");
                this.db.insert("groups", null, contentValues);
                return;
            }
        }
        RLog.w(TAG, "insertGroupInfo parameter is invalid");
    }

    synchronized void insertGroupUserInfo(GroupUserInfo groupUserInfo) {
        if (groupUserInfo != null) {
            if (groupUserInfo.getGroupId() != null && groupUserInfo.getUserId() != null) {
                if (this.db == null) {
                    RLog.w(TAG, "insertGroupUserInfo db is invalid");
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(FirebaseAnalytics.Param.GROUP_ID, groupUserInfo.getGroupId());
                contentValues.put("user_id", groupUserInfo.getUserId());
                contentValues.put("nickname", groupUserInfo.getNickname());
                this.db.insert("group_users", null, contentValues);
                return;
            }
        }
        RLog.w(TAG, "insertGroupUserInfo parameter is invalid");
    }

    synchronized void insertUserInfo(UserInfo userInfo) {
        if (userInfo != null) {
            if (!TextUtils.isEmpty(userInfo.getUserId())) {
                if (this.db == null) {
                    RLog.w(TAG, "insertUserInfo db is invalid");
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", userInfo.getUserId());
                contentValues.put("name", userInfo.getName());
                contentValues.put("portrait", userInfo.getPortraitUri() + "");
                contentValues.put("extra", userInfo.getExtra());
                this.db.insert("users", null, contentValues);
                return;
            }
        }
        RLog.w(TAG, "insertUserInfo userId is invalid");
    }

    void open(Context context, String str, String str2) {
        RongUserCacheDatabaseHelper.setDbPath(context, str, str2);
        try {
            this.db = new RongUserCacheDatabaseHelper(context).getWritableDatabase();
        } catch (SQLiteException e2) {
            RLog.e(TAG, "SQLiteException occur");
            e2.printStackTrace();
        }
    }

    synchronized void putDiscussionInfo(Discussion discussion) {
        if (discussion != null) {
            if (discussion.getId() != null) {
                if (this.db == null) {
                    RLog.w(TAG, "putDiscussionInfo db is invalid");
                    return;
                } else {
                    this.db.execSQL("replace into discussions (id, name, portrait) values (?, ?, ?)", new String[]{discussion.getId(), discussion.getName(), ""});
                    return;
                }
            }
        }
        RLog.w(TAG, "putDiscussionInfo parameter is invalid");
    }

    synchronized void putGroupInfo(Group group) {
        if (group != null) {
            if (group.getId() != null) {
                if (this.db == null) {
                    RLog.w(TAG, "putGroupInfo db is invalid");
                    return;
                }
                SQLiteDatabase sQLiteDatabase = this.db;
                String[] strArr = new String[3];
                strArr[0] = group.getId();
                strArr[1] = group.getName();
                strArr[2] = group.getPortraitUri() == null ? "" : group.getPortraitUri().toString();
                sQLiteDatabase.execSQL("replace into groups (id, name, portrait) values (?, ?, ?)", strArr);
                return;
            }
        }
        RLog.w(TAG, "putGroupInfo parameter is invalid");
    }

    synchronized void putGroupUserInfo(GroupUserInfo groupUserInfo) {
        if (groupUserInfo != null) {
            if (groupUserInfo.getGroupId() != null && groupUserInfo.getUserId() != null) {
                if (this.db == null) {
                    RLog.w(TAG, "putGroupUserInfo db is invalid");
                    return;
                } else {
                    this.db.execSQL("delete from group_users where group_id=? and user_id=?", new String[]{groupUserInfo.getGroupId(), groupUserInfo.getUserId()});
                    this.db.execSQL("insert into group_users (group_id, user_id, nickname) values (?, ?, ?)", new String[]{groupUserInfo.getGroupId(), groupUserInfo.getUserId(), groupUserInfo.getNickname()});
                    return;
                }
            }
        }
        RLog.w(TAG, "putGroupUserInfo parameter is invalid");
    }

    synchronized void putUserInfo(UserInfo userInfo) {
        if (userInfo != null) {
            if (!TextUtils.isEmpty(userInfo.getUserId())) {
                if (this.db == null) {
                    RLog.w(TAG, "putUserInfo db is invalid");
                    return;
                }
                try {
                    this.db.execSQL("replace into users (id, name, portrait, extra) values (?, ?, ?, ?)", new String[]{userInfo.getUserId(), userInfo.getName(), userInfo.getPortraitUri() + "", userInfo.getExtra()});
                } catch (SQLException unused) {
                    RLog.e(TAG, "putUserInfo DB if full");
                }
                return;
            }
        }
        RLog.w(TAG, "putUserInfo userId is invalid");
    }

    synchronized void updateDiscussionInfo(Discussion discussion) {
        if (discussion != null) {
            if (discussion.getId() != null) {
                if (this.db == null) {
                    RLog.w(TAG, "updateDiscussionInfo db is invalid");
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", discussion.getId());
                contentValues.put("name", discussion.getName());
                contentValues.put("portrait", "");
                this.db.update("discussions", contentValues, "id = ?", new String[]{discussion.getId()});
                return;
            }
        }
        RLog.w(TAG, "updateDiscussionInfo parameter is invalid");
    }

    synchronized void updateGroupInfo(Group group) {
        if (group != null) {
            if (group.getId() != null) {
                if (this.db == null) {
                    RLog.w(TAG, "updateGroupInfo db is invalid");
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", group.getId());
                contentValues.put("name", group.getName());
                contentValues.put("portrait", group.getPortraitUri() + "");
                this.db.update("groups", contentValues, "id = ?", new String[]{group.getId()});
                return;
            }
        }
        RLog.w(TAG, "updateGroupInfo parameter is invalid");
    }

    synchronized void updateGroupUserInfo(GroupUserInfo groupUserInfo) {
        if (groupUserInfo != null) {
            if (groupUserInfo.getGroupId() != null && groupUserInfo.getUserId() != null) {
                if (this.db == null) {
                    RLog.w(TAG, "updateGroupUserInfo db is invalid");
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(FirebaseAnalytics.Param.GROUP_ID, groupUserInfo.getGroupId());
                contentValues.put("user_id", groupUserInfo.getUserId());
                contentValues.put("nickname", groupUserInfo.getNickname());
                this.db.update("group_users", contentValues, "group_id=? and user_id=?", new String[]{groupUserInfo.getGroupId(), groupUserInfo.getUserId()});
                return;
            }
        }
        RLog.w(TAG, "updateGroupUserInfo parameter is invalid");
    }

    synchronized void updateUserInfo(UserInfo userInfo) {
        if (userInfo != null) {
            if (!TextUtils.isEmpty(userInfo.getUserId())) {
                if (this.db == null) {
                    RLog.w(TAG, "updateUserInfo db is invalid");
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", userInfo.getUserId());
                contentValues.put("name", userInfo.getName());
                contentValues.put("portrait", userInfo.getPortraitUri() + "");
                contentValues.put("extra", userInfo.getExtra());
                this.db.update("users", contentValues, "id = ?", new String[]{userInfo.getUserId()});
                return;
            }
        }
        RLog.w(TAG, "updateUserInfo userId is invalid");
    }
}
