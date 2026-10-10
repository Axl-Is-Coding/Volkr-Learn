package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.util.BillingHelper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class PurchaseApiResponseChecker {
    PurchaseApiResponseChecker() {
    }

    static BillingResult checkPurchasesBundleValidity(Bundle bundle, String str, String str2) {
        BillingResult billingResult = BillingResults.INTERNAL_ERROR;
        if (bundle == null) {
            BillingHelper.logWarn(str, String.format("%s got null owned items list", str2));
            return billingResult;
        }
        int responseCodeFromBundle = BillingHelper.getResponseCodeFromBundle(bundle, str);
        BillingResult billingResultBuild = BillingResult.newBuilder().setResponseCode(responseCodeFromBundle).setDebugMessage(BillingHelper.getDebugMessageFromBundle(bundle, str)).build();
        if (responseCodeFromBundle != 0) {
            BillingHelper.logWarn(str, String.format("%s failed. Response code: %s", str2, Integer.valueOf(responseCodeFromBundle)));
            return billingResultBuild;
        }
        if (!bundle.containsKey(BillingHelper.RESPONSE_INAPP_ITEM_LIST) || !bundle.containsKey(BillingHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST) || !bundle.containsKey(BillingHelper.RESPONSE_INAPP_SIGNATURE_LIST)) {
            BillingHelper.logWarn(str, String.format("Bundle returned from %s doesn't contain required fields.", str2));
            return billingResult;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList(BillingHelper.RESPONSE_INAPP_ITEM_LIST);
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList(BillingHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST);
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList(BillingHelper.RESPONSE_INAPP_SIGNATURE_LIST);
        if (stringArrayList == null) {
            BillingHelper.logWarn(str, String.format("Bundle returned from %s contains null SKUs list.", str2));
            return billingResult;
        }
        if (stringArrayList2 == null) {
            BillingHelper.logWarn(str, String.format("Bundle returned from %s contains null purchases list.", str2));
            return billingResult;
        }
        if (stringArrayList3 != null) {
            return BillingResults.OK;
        }
        BillingHelper.logWarn(str, String.format("Bundle returned from %s contains null signatures list.", str2));
        return billingResult;
    }
}
