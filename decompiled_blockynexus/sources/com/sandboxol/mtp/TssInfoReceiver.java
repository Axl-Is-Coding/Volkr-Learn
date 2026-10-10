package com.sandboxol.mtp;

import android.util.Log;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.MTPManager;
import com.sandboxol.center.router.moduleInfo.mtp.MTPMessageType;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.messager.MessagerClient;
import com.sandboxol.mtp.config.EventConstant;
import com.tencent.tersafe2.TP2Sdk;
import com.tencent.tp.TssInfoPublisher;

/* JADX INFO: loaded from: classes4.dex */
public class TssInfoReceiver implements TssInfoPublisher.TssInfoReceiver {
    @Override // com.tencent.tp.TssInfoPublisher.TssInfoReceiver
    public void onReceive(int i, String str) {
        if (i == 1) {
            String strDecTssInfo = TP2Sdk.decTssInfo(str);
            if (strDecTssInfo.equals("-1")) {
                return;
            }
            if (strDecTssInfo.contains("cert_md5") && !BaseApplication.getApp().isHasReportMd5()) {
                BaseApplication.getApp().setHasReportMd5(true);
                ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.MTP_INFO_CERT_MD_5, MTPManager.getMtpMd5(strDecTssInfo));
                ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.MTP_INFO_APK_MD_5, MTPManager.getApkSignMd5Str());
            }
            if ((strDecTssInfo.contains("id=9") || strDecTssInfo.contains("id=10") || strDecTssInfo.contains("id=13")) ? false : true) {
                if (MTPManager.isInBlackList(strDecTssInfo).booleanValue()) {
                    ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.MTP_INFO_CERT_MD_5, "Crash ***** " + MTPManager.getMtpMd5(strDecTssInfo));
                    ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.MTP_INFO_APK_MD_5, "Crash ***** " + MTPManager.getApkSignMd5Str());
                    MessagerClient.getIns().sendMsg0(MTPMessageType.TOKEN_MTP_KILL_PROCESS);
                    Log.e(MTPManager.TAG, "TssInfoReceiver onReceive: isInBlackList." + strDecTssInfo);
                    return;
                }
                ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.MTP_INFO_COLLECTION, MTPManager.getDescriptionById(strDecTssInfo) + "|" + strDecTssInfo);
                ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.MTP_INFO_COLLECTION_WITH_USER_ID, AccountCenter.newInstance().userId.get() + "|" + MTPManager.getDescriptionById(strDecTssInfo) + "|" + strDecTssInfo);
                if ((strDecTssInfo.contains("id=8") || strDecTssInfo.contains("id=6") || strDecTssInfo.contains("id=5") || strDecTssInfo.contains("id=1") || strDecTssInfo.contains("id=12")) && !SharedUtils.getBoolean(BaseApplication.getContext(), StringConstant.KEY_IS_OPEN_EMULATOR, false)) {
                    SharedUtils.putBoolean(BaseApplication.getContext(), StringConstant.KEY_IS_OPEN_EMULATOR, true);
                    Log.e(MTPManager.TAG, "Illegal environment detected!");
                }
            }
            Log.e(MTPManager.TAG, "TssInfoReceiver onReceive.");
            Log.e("MTP Info", "[Java TSS INFO]:" + i + "|" + strDecTssInfo);
        }
    }
}
