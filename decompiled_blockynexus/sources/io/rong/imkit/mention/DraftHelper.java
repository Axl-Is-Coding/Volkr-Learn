package io.rong.imkit.mention;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class DraftHelper {
    private static final String CONTENT = "content";
    private static final String MENTION = "mention";
    private String content;
    private List<MentionBlock> mentionBlocks;

    public DraftHelper(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.content = jSONObject.getString("content");
            this.mentionBlocks = getMentionBlocks(jSONObject.optString(MENTION));
        } catch (JSONException unused) {
            this.content = str;
        }
    }

    public static String encode(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            return new JSONObject().putOpt("content", str).putOpt(MENTION, str2).toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    public static String getDraftContent(String str) {
        try {
            return new JSONObject(str).getString("content");
        } catch (Exception unused) {
            return str;
        }
    }

    private List<MentionBlock> getMentionBlocks(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(new MentionBlock(jSONArray.getString(i)));
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public String decode() {
        return this.content;
    }

    public void restoreMentionInfo() {
        List<MentionBlock> list = this.mentionBlocks;
        if (list != null) {
            Iterator<MentionBlock> it = list.iterator();
            while (it.hasNext()) {
                RongMentionManager.getInstance().addMentionBlock(it.next());
            }
        }
    }
}
