package io.rong.imlib.filetransfer;

import fi.iki.elonen.NanoHTTPD;

/* JADX INFO: loaded from: classes5.dex */
public class FtConst {
    public static final String TEMP_TRANSFER_FILE_DIR = "TempFile";

    public enum MimeType {
        NONE(0, "none"),
        FILE_IMAGE(1, "image/jpeg"),
        FILE_AUDIO(2, "audio/amr"),
        FILE_VIDEO(3, "video/mpeg4"),
        FILE_TEXT_PLAIN(4, "application/octet-stream"),
        FILE_SIGHT(5, "video/mpeg4"),
        FILE_HTML(6, NanoHTTPD.MIME_HTML);

        private String name;
        private int value;

        MimeType(int i, String str) {
            this.value = i;
            this.name = str;
        }

        public static MimeType setValue(int i) {
            for (MimeType mimeType : values()) {
                if (i == mimeType.getValue()) {
                    return mimeType;
                }
            }
            return NONE;
        }

        public String getName() {
            return this.name;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum ServiceType {
        PRIVATE_CLOUD(null, "private"),
        QI_NIU("1", "qiniu"),
        BAI_DU("2", "baidu"),
        ALI_OSS("3", "aliyun");

        private String name;
        private String priority;

        ServiceType(String str, String str2) {
            this.priority = str;
            this.name = str2;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static io.rong.imlib.filetransfer.FtConst.ServiceType reverse(java.lang.String r4) {
            /*
                int r0 = r4.hashCode()
                r1 = 3
                r2 = 2
                r3 = 1
                switch(r0) {
                    case -1414951308: goto L29;
                    case -314497661: goto L1f;
                    case 93498907: goto L15;
                    case 107595010: goto Lb;
                    default: goto La;
                }
            La:
                goto L33
            Lb:
                java.lang.String r0 = "qiniu"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L33
                r4 = 0
                goto L34
            L15:
                java.lang.String r0 = "baidu"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L33
                r4 = 2
                goto L34
            L1f:
                java.lang.String r0 = "private"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L33
                r4 = 1
                goto L34
            L29:
                java.lang.String r0 = "aliyun"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L33
                r4 = 3
                goto L34
            L33:
                r4 = -1
            L34:
                if (r4 == 0) goto L47
                if (r4 == r3) goto L44
                if (r4 == r2) goto L41
                if (r4 == r1) goto L3e
                r4 = 0
                return r4
            L3e:
                io.rong.imlib.filetransfer.FtConst$ServiceType r4 = io.rong.imlib.filetransfer.FtConst.ServiceType.ALI_OSS
                return r4
            L41:
                io.rong.imlib.filetransfer.FtConst$ServiceType r4 = io.rong.imlib.filetransfer.FtConst.ServiceType.BAI_DU
                return r4
            L44:
                io.rong.imlib.filetransfer.FtConst$ServiceType r4 = io.rong.imlib.filetransfer.FtConst.ServiceType.PRIVATE_CLOUD
                return r4
            L47:
                io.rong.imlib.filetransfer.FtConst$ServiceType r4 = io.rong.imlib.filetransfer.FtConst.ServiceType.QI_NIU
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.rong.imlib.filetransfer.FtConst.ServiceType.reverse(java.lang.String):io.rong.imlib.filetransfer.FtConst$ServiceType");
        }

        public String getName() {
            return this.name;
        }

        public String getPriority() {
            return this.priority;
        }
    }
}
