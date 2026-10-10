package com.google.protobuf;

/* JADX INFO: compiled from: TextFormatEscaper.java */
/* JADX INFO: loaded from: classes2.dex */
final class J {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TextFormatEscaper.java */
    interface a {
        byte a(int i);

        int size();
    }

    static String a(a aVar) {
        StringBuilder sb = new StringBuilder(aVar.size());
        for (int i = 0; i < aVar.size(); i++) {
            byte bA = aVar.a(i);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    static String a(ByteString byteString) {
        return a(new I(byteString));
    }

    static String a(String str) {
        return a(ByteString.copyFromUtf8(str));
    }
}
