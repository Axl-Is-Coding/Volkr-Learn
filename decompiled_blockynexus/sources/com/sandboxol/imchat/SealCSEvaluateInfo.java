package com.sandboxol.imchat;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.imchat.model.SealCSEvaluateItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class SealCSEvaluateInfo {
    List<SealCSEvaluateItem> sealCSEvaluateInfoList = new ArrayList();

    public SealCSEvaluateInfo(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.optJSONObject("evaluation").getJSONArray("satisfaction");
            this.sealCSEvaluateInfoList.clear();
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                SealCSEvaluateItem sealCSEvaluateItem = new SealCSEvaluateItem();
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                sealCSEvaluateItem.setConfigId(jSONObjectOptJSONObject.optString("configId"));
                sealCSEvaluateItem.setCompanyId(jSONObjectOptJSONObject.optString("companyId"));
                sealCSEvaluateItem.setGroupId(jSONObjectOptJSONObject.optString("groupId"));
                sealCSEvaluateItem.setGroupName(jSONObjectOptJSONObject.optString("groupName"));
                sealCSEvaluateItem.setLabelId(jSONObjectOptJSONObject.optString("labelId"));
                sealCSEvaluateItem.setLabelNameList(Arrays.asList(jSONObjectOptJSONObject.optString("labelName").split(",")));
                boolean z = true;
                sealCSEvaluateItem.setQuestionFlag(jSONObjectOptJSONObject.optInt("isQuestionFlag", 0) == 1);
                sealCSEvaluateItem.setScore(jSONObjectOptJSONObject.optInt(FirebaseAnalytics.Param.SCORE));
                sealCSEvaluateItem.setScoreExplain(jSONObjectOptJSONObject.optString("scoreExplain"));
                sealCSEvaluateItem.setTagMust(jSONObjectOptJSONObject.optInt("isTagMust", 0) == 1);
                if (jSONObjectOptJSONObject.optInt("isInputMust", 0) != 1) {
                    z = false;
                }
                sealCSEvaluateItem.setInputMust(z);
                sealCSEvaluateItem.setInputLanguage(jSONObjectOptJSONObject.optString("inputLanguage"));
                sealCSEvaluateItem.setCreateTime(jSONObjectOptJSONObject.optLong("createTime", 0L));
                sealCSEvaluateItem.setSettingMode(jSONObjectOptJSONObject.optInt("settingMode"));
                sealCSEvaluateItem.setUpdateTime(jSONObjectOptJSONObject.optLong("updateTime", 0L));
                sealCSEvaluateItem.setOperateType(jSONObjectOptJSONObject.optInt("operateType"));
                this.sealCSEvaluateInfoList.add(sealCSEvaluateItem);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public List<SealCSEvaluateItem> getSealCSEvaluateInfoList() {
        return this.sealCSEvaluateInfoList;
    }
}
