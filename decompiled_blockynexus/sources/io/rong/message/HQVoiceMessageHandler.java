package io.rong.message;

import android.content.Context;
import android.net.Uri;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.imlib.NativeClient;
import io.rong.imlib.model.Message;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class HQVoiceMessageHandler extends MessageHandler<HQVoiceMessage> {
    private static final String TAG = "HQVoiceMessageHandler";
    private static final String VOICE_PATH = "/hq_voice/";

    public HQVoiceMessageHandler(Context context) {
        super(context);
    }

    private static File saveFile(byte[] bArr, String str, String str2) throws IOException {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            RLog.e(TAG, "Created folders unSuccessfully");
        }
        File file2 = new File(str + str2);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        return file2;
    }

    @Override // io.rong.message.MessageHandler
    public void decodeMessage(Message message, HQVoiceMessage hQVoiceMessage) {
    }

    @Override // io.rong.message.MessageHandler
    public void encodeMessage(Message message) {
        File fileSaveFile;
        HQVoiceMessage hQVoiceMessage = (HQVoiceMessage) message.getContent();
        Uri uriObtainMediaFileSavedUri = NativeClient.getInstance().obtainMediaFileSavedUri();
        byte[] bArrFile2byte = FileUtils.file2byte(getContext(), hQVoiceMessage.getLocalPath());
        try {
            fileSaveFile = saveFile(bArrFile2byte, uriObtainMediaFileSavedUri.toString() + VOICE_PATH, message.getMessageId() + ".aac");
        } catch (IOException e2) {
            RLog.e(TAG, "IOException ", e2);
            fileSaveFile = null;
        }
        if (fileSaveFile == null || !fileSaveFile.exists()) {
            return;
        }
        hQVoiceMessage.setLocalPath(Uri.fromFile(fileSaveFile));
        hQVoiceMessage.setName(fileSaveFile.getName());
    }
}
