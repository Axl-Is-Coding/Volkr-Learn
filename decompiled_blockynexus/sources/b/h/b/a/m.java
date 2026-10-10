package b.h.b.a;

import android.content.Context;
import com.alibaba.android.arouter.utils.Consts;
import com.sandboxol.blockmango.config.GameEventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.gameblocky.entity.ResVersion;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: GameResCopyUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class m {
    public static int a(Context context, String str) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str + "/res.version");
            ResVersion resVersion = (ResVersion) new com.google.gson.j().a(a(inputStreamOpen), ResVersion.class);
            inputStreamOpen.close();
            return resVersion.getFileCount();
        } catch (Exception unused) {
            try {
                int iA = 0;
                for (String str2 : context.getResources().getAssets().list(str)) {
                    iA = str2.contains(Consts.DOT) ? iA + 1 : iA + a(context, str + "/" + str2);
                }
                return iA;
            } catch (IOException unused2) {
                return 0;
            } catch (Exception unused3) {
                ReportDataAdapter.onEvent(context, GameEventConstant.LOAD_ASSETS_RES_FAILED);
                return 0;
            }
        }
    }

    private static String a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read();
            if (i != -1) {
                byteArrayOutputStream.write(i);
            } else {
                return byteArrayOutputStream.toString();
            }
        }
    }
}
