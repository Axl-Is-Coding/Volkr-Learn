package io.rong.push.core;

import io.rong.push.common.RLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class PushProtocalStack {

    /* JADX INFO: renamed from: io.rong.push.core.PushProtocalStack$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$rong$push$core$PushProtocalStack$ConnAckMessage$ConnectionStatus;
        static final /* synthetic */ int[] $SwitchMap$io$rong$push$core$PushProtocalStack$DisconnectMessage$DisconnectionStatus;
        static final /* synthetic */ int[] $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type = new int[Message.Type.values().length];

        static {
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[Message.Type.CONNACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[Message.Type.PUBLISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[Message.Type.PINGRESP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[Message.Type.CONNECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[Message.Type.PINGREQ.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[Message.Type.DISCONNECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[Message.Type.QUERY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[Message.Type.QUERYACK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $SwitchMap$io$rong$push$core$PushProtocalStack$DisconnectMessage$DisconnectionStatus = new int[DisconnectMessage.DisconnectionStatus.values().length];
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$DisconnectMessage$DisconnectionStatus[DisconnectMessage.DisconnectionStatus.RECONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$DisconnectMessage$DisconnectionStatus[DisconnectMessage.DisconnectionStatus.OTHER_DEVICE_LOGIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$DisconnectMessage$DisconnectionStatus[DisconnectMessage.DisconnectionStatus.CLOSURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            $SwitchMap$io$rong$push$core$PushProtocalStack$ConnAckMessage$ConnectionStatus = new int[ConnAckMessage.ConnectionStatus.values().length];
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$ConnAckMessage$ConnectionStatus[ConnAckMessage.ConnectionStatus.ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$ConnAckMessage$ConnectionStatus[ConnAckMessage.ConnectionStatus.UNACCEPTABLE_PROTOCOL_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$ConnAckMessage$ConnectionStatus[ConnAckMessage.ConnectionStatus.IDENTIFIER_REJECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$ConnAckMessage$ConnectionStatus[ConnAckMessage.ConnectionStatus.SERVER_UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$ConnAckMessage$ConnectionStatus[ConnAckMessage.ConnectionStatus.BAD_USERNAME_OR_PASSWORD.ordinal()] = 5;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$ConnAckMessage$ConnectionStatus[ConnAckMessage.ConnectionStatus.NOT_AUTHORIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$ConnAckMessage$ConnectionStatus[ConnAckMessage.ConnectionStatus.REDIRECT.ordinal()] = 7;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public static class ConnAckMessage extends Message {
        public static final int MESSAGE_LENGTH = 2;
        private ConnectionStatus status;
        private String userId;

        public enum ConnectionStatus {
            ACCEPTED,
            UNACCEPTABLE_PROTOCOL_VERSION,
            IDENTIFIER_REJECTED,
            SERVER_UNAVAILABLE,
            BAD_USERNAME_OR_PASSWORD,
            NOT_AUTHORIZED,
            REDIRECT
        }

        public ConnAckMessage() {
            super(Message.Type.CONNACK);
        }

        public ConnectionStatus getStatus() {
            return this.status;
        }

        public String getUserId() {
            return this.userId;
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        protected int messageLength() {
            String str = this.userId;
            if (str == null || str.isEmpty()) {
                return 2;
            }
            return 2 + FormatUtil.toWMtpString(this.userId).length;
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        protected void readMessage(InputStream inputStream, int i) throws IOException {
            inputStream.read();
            switch (inputStream.read()) {
                case 0:
                    this.status = ConnectionStatus.ACCEPTED;
                    break;
                case 1:
                    this.status = ConnectionStatus.UNACCEPTABLE_PROTOCOL_VERSION;
                    break;
                case 2:
                    this.status = ConnectionStatus.IDENTIFIER_REJECTED;
                    break;
                case 3:
                    this.status = ConnectionStatus.SERVER_UNAVAILABLE;
                    break;
                case 4:
                    this.status = ConnectionStatus.BAD_USERNAME_OR_PASSWORD;
                    break;
                case 5:
                    this.status = ConnectionStatus.NOT_AUTHORIZED;
                    break;
                case 6:
                    this.status = ConnectionStatus.REDIRECT;
                    break;
                default:
                    RLog.e("PushProtocol", "Unsupported CONNACK code");
                    this.status = ConnectionStatus.REDIRECT;
                    break;
            }
            if (i > 2) {
                this.userId = new DataInputStream(inputStream).readUTF();
            }
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setDup(boolean z) {
            throw new UnsupportedOperationException("CONNACK messages don't use the DUP flag.");
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setQos(QoS qoS) {
            throw new UnsupportedOperationException("CONNACK messages don't use the QoS flags.");
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setRetained(boolean z) {
            throw new UnsupportedOperationException("CONNACK messages don't use the RETAIN flag.");
        }

        public void setUserId(String str) {
            this.userId = str;
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        protected void writeMessage(OutputStream outputStream) throws IOException {
            outputStream.write(0);
            switch (AnonymousClass1.$SwitchMap$io$rong$push$core$PushProtocalStack$ConnAckMessage$ConnectionStatus[this.status.ordinal()]) {
                case 1:
                    outputStream.write(0);
                    break;
                case 2:
                    outputStream.write(1);
                    break;
                case 3:
                    outputStream.write(2);
                    break;
                case 4:
                    outputStream.write(3);
                    break;
                case 5:
                    outputStream.write(4);
                    break;
                case 6:
                    outputStream.write(5);
                    break;
                case 7:
                    outputStream.write(6);
                    break;
                default:
                    RLog.e("PushProtocol", "Unsupported CONNACK message status: " + this.status);
                    break;
            }
            String str = this.userId;
            if (str == null || str.isEmpty()) {
                return;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(this.userId);
            dataOutputStream.flush();
        }

        public ConnAckMessage(Message.Header header) throws IOException {
            super(header);
        }

        public ConnAckMessage(ConnectionStatus connectionStatus) {
            super(Message.Type.CONNACK);
            if (connectionStatus != null) {
                this.status = connectionStatus;
                return;
            }
            throw new IllegalArgumentException("The status of ConnAskMessage can't be null");
        }
    }

    public static class ConnectMessage extends Message {
        private static int CONNECT_HEADER_SIZE = 12;
        private boolean cleanSession;
        private String clientId;
        private boolean hasPassword;
        private boolean hasUsername;
        private boolean hasWill;
        private int keepAlive;
        private String password;
        private String protocolId;
        private byte protocolVersion;
        private boolean retainWill;
        private String username;
        private String will;
        private QoS willQoS;
        private String willTopic;

        public ConnectMessage() {
            super(Message.Type.CONNECT);
            this.protocolId = "MQIsdp";
            this.protocolVersion = (byte) 3;
        }

        public String getClientId() {
            return this.clientId;
        }

        public int getKeepAlive() {
            return this.keepAlive;
        }

        public String getPassword() {
            return this.password;
        }

        public String getProtocolId() {
            return this.protocolId;
        }

        public byte getProtocolVersion() {
            return this.protocolVersion;
        }

        public String getUsername() {
            return this.username;
        }

        public String getWill() {
            return this.will;
        }

        public QoS getWillQoS() {
            return this.willQoS;
        }

        public String getWillTopic() {
            return this.willTopic;
        }

        public boolean hasPassword() {
            return this.hasPassword;
        }

        public boolean hasUsername() {
            return this.hasUsername;
        }

        public boolean hasWill() {
            return this.hasWill;
        }

        public boolean isCleanSession() {
            return this.cleanSession;
        }

        public boolean isWillRetained() {
            return this.retainWill;
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        protected int messageLength() {
            return FormatUtil.toWMtpString(this.clientId).length + FormatUtil.toWMtpString(this.willTopic).length + FormatUtil.toWMtpString(this.will).length + FormatUtil.toWMtpString(this.username).length + FormatUtil.toWMtpString(this.password).length + CONNECT_HEADER_SIZE;
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        protected void readMessage(InputStream inputStream, int i) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.protocolId = dataInputStream.readUTF();
            this.protocolVersion = dataInputStream.readByte();
            byte b2 = dataInputStream.readByte();
            this.hasUsername = (b2 & 128) > 0;
            this.hasPassword = (b2 & 64) > 0;
            int i2 = b2 & 32;
            this.retainWill = i2 > 0;
            this.willQoS = QoS.valueOf((b2 >> 3) & 3);
            this.hasWill = (b2 & 4) > 0;
            this.cleanSession = i2 > 0;
            this.keepAlive = (dataInputStream.read() * 256) + dataInputStream.read();
            this.clientId = dataInputStream.readUTF();
            if (this.hasWill) {
                this.willTopic = dataInputStream.readUTF();
                this.will = dataInputStream.readUTF();
            }
            if (this.hasUsername) {
                try {
                    this.username = dataInputStream.readUTF();
                } catch (EOFException unused) {
                }
            }
            if (this.hasPassword) {
                try {
                    this.password = dataInputStream.readUTF();
                } catch (EOFException unused2) {
                }
            }
        }

        public void setCredentials(String str) {
            setCredentials(str, null);
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setDup(boolean z) {
            throw new UnsupportedOperationException("CONNECT messages don't use the DUP flag.");
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setQos(QoS qoS) {
            throw new UnsupportedOperationException("CONNECT messages don't use the QoS flags.");
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setRetained(boolean z) {
            throw new UnsupportedOperationException("CONNECT messages don't use the RETAIN flag.");
        }

        public void setWill(String str, String str2) {
            setWill(str, str2, QoS.AT_MOST_ONCE, false);
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        protected void writeMessage(OutputStream outputStream) throws IOException {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(this.protocolId);
            dataOutputStream.write(this.protocolVersion);
            int i = (this.cleanSession ? 2 : 0) | (this.hasWill ? 4 : 0);
            QoS qoS = this.willQoS;
            dataOutputStream.write((byte) (i | (qoS == null ? 0 : qoS.val << 3) | (this.retainWill ? 32 : 0) | (this.hasPassword ? 64 : 0) | (this.hasUsername ? 128 : 0)));
            dataOutputStream.writeChar(this.keepAlive);
            dataOutputStream.writeUTF(this.clientId);
            if (this.hasWill) {
                dataOutputStream.writeUTF(this.willTopic);
                dataOutputStream.writeUTF(this.will);
            }
            if (this.hasUsername) {
                dataOutputStream.writeUTF(this.username);
            }
            if (this.hasPassword) {
                dataOutputStream.writeUTF(this.password);
            }
            dataOutputStream.flush();
        }

        public void setCredentials(String str, String str2) {
            if ((str == null || str.isEmpty()) && str2 != null && !str2.isEmpty()) {
                throw new IllegalArgumentException("It is not valid to supply a password without supplying a username.");
            }
            this.username = str;
            this.password = str2;
            this.hasUsername = this.username != null;
            this.hasPassword = this.password != null;
        }

        public void setWill(String str, String str2, QoS qoS, boolean z) {
            if (!((str == null) ^ (str2 == null))) {
                if (!((str2 == null) ^ (qoS == null))) {
                    this.willTopic = str;
                    this.will = str2;
                    this.willQoS = qoS;
                    this.retainWill = z;
                    this.hasWill = str != null;
                    return;
                }
            }
            throw new IllegalArgumentException("Can't set willTopic, will or willQoS value independently");
        }

        public ConnectMessage(Message.Header header) throws IOException {
            super(header);
            this.protocolId = "MQIsdp";
            this.protocolVersion = (byte) 3;
        }

        public ConnectMessage(String str, boolean z, int i) {
            super(Message.Type.CONNECT);
            this.protocolId = "MQIsdp";
            this.protocolVersion = (byte) 3;
            if (str != null && str.length() <= 64) {
                this.clientId = str;
                this.cleanSession = z;
                this.keepAlive = i;
            } else {
                throw new IllegalArgumentException("Client id cannot be null and must be at most 64 characters long: " + str);
            }
        }
    }

    public static class DisconnectMessage extends Message {
        public static final int MESSAGE_LENGTH = 2;
        private DisconnectionStatus status;

        public enum DisconnectionStatus {
            RECONNECT,
            OTHER_DEVICE_LOGIN,
            CLOSURE
        }

        public DisconnectMessage(Message.Header header) throws IOException {
            super(header);
        }

        public DisconnectionStatus getStatus() {
            return this.status;
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        protected int messageLength() {
            return 2;
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        protected void readMessage(InputStream inputStream, int i) throws IOException {
            inputStream.read();
            int i2 = inputStream.read();
            if (i2 == 0) {
                this.status = DisconnectionStatus.RECONNECT;
                return;
            }
            if (i2 == 1) {
                this.status = DisconnectionStatus.OTHER_DEVICE_LOGIN;
                return;
            }
            if (i2 == 2) {
                this.status = DisconnectionStatus.CLOSURE;
                return;
            }
            RLog.e("PushProtocol", "Unsupported DisconnectMessage status: " + i2);
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setDup(boolean z) {
            throw new UnsupportedOperationException("DISCONNECT message does not support the DUP flag");
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setQos(QoS qoS) {
            throw new UnsupportedOperationException("DISCONNECT message does not support the QoS flag");
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setRetained(boolean z) {
            throw new UnsupportedOperationException("DISCONNECT message does not support the RETAIN flag");
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        protected void writeMessage(OutputStream outputStream) throws IOException {
            outputStream.write(0);
            int i = AnonymousClass1.$SwitchMap$io$rong$push$core$PushProtocalStack$DisconnectMessage$DisconnectionStatus[this.status.ordinal()];
            if (i == 1) {
                outputStream.write(0);
                return;
            }
            if (i == 2) {
                outputStream.write(1);
            } else if (i != 3) {
                RLog.e("PushProtocol", "Unsupported DisconnectMessage code.");
            } else {
                outputStream.write(2);
            }
        }

        public DisconnectMessage(DisconnectionStatus disconnectionStatus) {
            super(Message.Type.DISCONNECT);
            if (disconnectionStatus == null) {
                throw new IllegalArgumentException("The status of ConnAskMessage can't be null");
            }
            this.status = disconnectionStatus;
        }

        public DisconnectMessage() {
            super(Message.Type.DISCONNECT);
        }
    }

    public static class FormatUtil {
        public static String dumpByteArray(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bArr.length; i++) {
                int i2 = bArr[i] & 255;
                sb.append(String.format("%1$02d: %2$08d %3$1c %3$d\n", Integer.valueOf(i), Integer.valueOf(Integer.parseInt(Integer.toBinaryString(i2))), Integer.valueOf(i2)));
            }
            return sb.toString();
        }

        public static String toString(byte[] bArr) {
            try {
                return new DataInputStream(new ByteArrayInputStream(bArr)).readUTF();
            } catch (IOException unused) {
                return null;
            }
        }

        public static byte[] toWMtpString(String str) {
            if (str == null) {
                return new byte[0];
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeUTF(str);
                dataOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                return new byte[0];
            }
        }
    }

    public static class MessageInputStream implements Closeable {
        private InputStream in;

        public MessageInputStream(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.in.close();
        }

        public Message readMessage() throws IOException {
            Message connAckMessage;
            Message.Header header = new Message.Header((byte) this.in.read());
            if (header.getType() == null) {
                return null;
            }
            RLog.i("PushProtocalStack", "receive message type:" + header.getType());
            switch (AnonymousClass1.$SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[header.getType().ordinal()]) {
                case 1:
                    connAckMessage = new ConnAckMessage(header);
                    break;
                case 2:
                    connAckMessage = new PublishMessage(header);
                    break;
                case 3:
                    connAckMessage = new PingRespMessage(header);
                    break;
                case 4:
                    connAckMessage = new ConnectMessage(header);
                    break;
                case 5:
                    connAckMessage = new PingReqMessage(header);
                    break;
                case 6:
                    connAckMessage = new DisconnectMessage(header);
                    break;
                case 7:
                    connAckMessage = new QueryMessage(header);
                    break;
                case 8:
                    connAckMessage = new QueryAckMessage(header);
                    break;
                default:
                    RLog.e("PushProtocalStack", "No support for deserializing" + header.getType() + "messages");
                    return null;
            }
            this.in.read();
            connAckMessage.read(this.in);
            return connAckMessage;
        }
    }

    public static class MessageOutputStream {
        private final OutputStream out;

        public MessageOutputStream(OutputStream outputStream) {
            this.out = outputStream;
        }

        public void close() throws IOException {
            this.out.close();
        }

        public void writeMessage(Message message) throws IOException {
            message.write(this.out);
            this.out.flush();
        }
    }

    public static class PingReqMessage extends Message {
        public PingReqMessage() {
            super(Message.Type.PINGREQ);
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setDup(boolean z) {
            throw new UnsupportedOperationException("PINGREQ message does not support the DUP flag");
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setQos(QoS qoS) {
            throw new UnsupportedOperationException("PINGREQ message does not support the QoS flag");
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setRetained(boolean z) {
            throw new UnsupportedOperationException("PINGREQ message does not support the RETAIN flag");
        }

        public PingReqMessage(Message.Header header) throws IOException {
            super(header);
        }
    }

    public static class PingRespMessage extends Message {
        public PingRespMessage(Message.Header header) throws IOException {
            super(header);
        }

        public PingRespMessage() {
            super(Message.Type.PINGRESP);
        }
    }

    public static class PublishMessage extends RetryableMessage {
        private byte[] data;
        private int date;
        private String targetId;
        private String topic;

        public PublishMessage(Message.Header header) throws IOException {
            super(header);
        }

        public byte[] getData() {
            return this.data;
        }

        public String getDataAsString() {
            byte[] bArr = this.data;
            if (bArr == null) {
                return null;
            }
            return FormatUtil.toString(bArr);
        }

        public int getServerTime() {
            return this.date;
        }

        public String getTargetId() {
            return this.targetId;
        }

        public String getTopic() {
            return this.topic;
        }

        @Override // io.rong.push.core.PushProtocalStack.RetryableMessage, io.rong.push.core.PushProtocalStack.Message
        protected int messageLength() {
            return 0;
        }

        @Override // io.rong.push.core.PushProtocalStack.RetryableMessage, io.rong.push.core.PushProtocalStack.Message
        protected void readMessage(InputStream inputStream, int i) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            dataInputStream.readLong();
            this.date = dataInputStream.readInt();
            this.topic = dataInputStream.readUTF();
            this.targetId = dataInputStream.readUTF();
            int length = FormatUtil.toWMtpString(this.topic).length + 14 + FormatUtil.toWMtpString(this.targetId).length;
            super.readMessage(inputStream, i);
            if (i >= length) {
                this.data = new byte[i - length];
                dataInputStream.read(this.data);
                return;
            }
            RLog.e("PushProtocal", "error msgLength. msgLength:" + i + "pos:" + length);
        }

        @Override // io.rong.push.core.PushProtocalStack.RetryableMessage, io.rong.push.core.PushProtocalStack.Message
        protected void writeMessage(OutputStream outputStream) throws IOException {
            super.writeMessage(outputStream);
        }
    }

    public enum QoS {
        AT_MOST_ONCE(0),
        AT_LEAST_ONCE(1),
        EXACTLY_ONCE(2),
        DEFAULT(3);

        public final int val;

        QoS(int i) {
            this.val = i;
        }

        static QoS valueOf(int i) {
            for (QoS qoS : values()) {
                if (qoS.val == i) {
                    return qoS;
                }
            }
            throw new IllegalArgumentException("Not a valid QoS number: " + i);
        }
    }

    public static class QueryMessage extends RetryableMessage {
        private byte[] data;
        private long signature;
        private String targetId;
        private String topic;

        public QueryMessage(String str, String str2, String str3) {
            this(str, FormatUtil.toWMtpString(str2), str3);
        }

        public byte[] getData() {
            return this.data;
        }

        public String getDataAsString() {
            return new String(this.data);
        }

        public String getTargetId() {
            return this.targetId;
        }

        public String getTopic() {
            return this.topic;
        }

        @Override // io.rong.push.core.PushProtocalStack.RetryableMessage, io.rong.push.core.PushProtocalStack.Message
        protected int messageLength() {
            return FormatUtil.toWMtpString(this.topic).length + 8 + FormatUtil.toWMtpString(this.targetId).length + 2 + this.data.length;
        }

        @Override // io.rong.push.core.PushProtocalStack.RetryableMessage, io.rong.push.core.PushProtocalStack.Message
        protected void readMessage(InputStream inputStream, int i) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.signature = dataInputStream.readLong();
            this.topic = dataInputStream.readUTF();
            this.targetId = dataInputStream.readUTF();
            int length = 8 + FormatUtil.toWMtpString(this.topic).length + FormatUtil.toWMtpString(this.targetId).length;
            super.readMessage(inputStream, i);
            this.data = new byte[i - (length + 2)];
            dataInputStream.read(this.data);
        }

        @Override // io.rong.push.core.PushProtocalStack.RetryableMessage, io.rong.push.core.PushProtocalStack.Message
        protected void writeMessage(OutputStream outputStream) throws IOException {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeLong(this.signature);
            dataOutputStream.writeUTF(this.topic);
            dataOutputStream.writeUTF(this.targetId);
            dataOutputStream.flush();
            super.writeMessage(outputStream);
            dataOutputStream.write(this.data);
            dataOutputStream.flush();
        }

        public QueryMessage(String str, byte[] bArr, String str2) {
            super(Message.Type.QUERY);
            this.topic = str;
            this.targetId = str2;
            this.data = bArr;
            this.signature = 255L;
        }

        public QueryMessage(Message.Header header) throws IOException {
            super(header);
        }
    }

    public static abstract class RetryableMessage extends Message {
        private int messageId;

        public RetryableMessage(Message.Header header) throws IOException {
            super(header);
        }

        public int getMessageId() {
            return this.messageId;
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        protected int messageLength() {
            return 2;
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        protected void readMessage(InputStream inputStream, int i) throws IOException {
            setMessageId((inputStream.read() * 255) + inputStream.read());
        }

        public void setMessageId(int i) {
            this.messageId = i;
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        protected void writeMessage(OutputStream outputStream) throws IOException {
            int messageId = getMessageId();
            outputStream.write((messageId & 65280) >> 8);
            outputStream.write(messageId & 255);
        }

        public RetryableMessage(Message.Type type) {
            super(type);
        }
    }

    public static abstract class Message {
        private final Header header;
        private byte headerCode;

        public static class Header {
            private boolean dup;
            private QoS qos;
            private boolean retain;
            private Type type;

            /* synthetic */ Header(Type type, boolean z, QoS qoS, boolean z2, AnonymousClass1 anonymousClass1) {
                this(type, z, qoS, z2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public byte encode() {
                return (byte) (((byte) (((byte) (((byte) (this.type.val << 4)) | (this.retain ? 1 : 0))) | (this.qos.val << 1))) | (this.dup ? (byte) 8 : (byte) 0));
            }

            public Type getType() {
                return this.type;
            }

            public String toString() {
                return "Header [type=" + this.type + ", retain=" + this.retain + ", qos=" + this.qos + ", dup=" + this.dup + "]";
            }

            private Header(Type type, boolean z, QoS qoS, boolean z2) {
                this.qos = QoS.AT_MOST_ONCE;
                this.type = type;
                this.retain = z;
                this.qos = qoS;
                this.dup = z2;
            }

            public Header(byte b2) {
                this.qos = QoS.AT_MOST_ONCE;
                this.retain = (b2 & 1) > 0;
                this.qos = QoS.valueOf((b2 & 6) >> 1);
                this.dup = (b2 & 8) > 0;
                this.type = Type.valueOf((b2 >> 4) & 15);
            }
        }

        public enum Type {
            CONNECT(1),
            CONNACK(2),
            PUBLISH(3),
            PUBACK(4),
            QUERY(5),
            QUERYACK(6),
            QUERYCON(7),
            SUBSCRIBE(8),
            SUBACK(9),
            UNSUBSCRIBE(10),
            UNSUBACK(11),
            PINGREQ(12),
            PINGRESP(13),
            DISCONNECT(14);

            private final int val;

            Type(int i) {
                this.val = i;
            }

            static Type valueOf(int i) {
                for (Type type : values()) {
                    if (type.val == i) {
                        return type;
                    }
                }
                return null;
            }
        }

        public Message(Type type) {
            this.header = new Header(type, false, QoS.AT_MOST_ONCE, false, null);
        }

        private int readMsgLength(InputStream inputStream) throws IOException {
            int i;
            int i2 = 0;
            int i3 = 1;
            do {
                i = inputStream.read();
                i2 += (i & 127) * i3;
                i3 *= 128;
            } while ((i & 128) > 0);
            return i2;
        }

        private void writeMsgCode(OutputStream outputStream) throws IOException {
            int iMessageLength = messageLength();
            int i = this.headerCode;
            do {
                byte b2 = (byte) (iMessageLength & 127);
                iMessageLength >>= 7;
                if (iMessageLength > 0) {
                    b2 = (byte) (b2 | 128);
                }
                i ^= b2;
            } while (iMessageLength > 0);
            outputStream.write(i);
        }

        private void writeMsgLength(OutputStream outputStream) throws IOException {
            int iMessageLength = messageLength();
            do {
                byte b2 = (byte) (iMessageLength & 127);
                iMessageLength >>= 7;
                if (iMessageLength > 0) {
                    b2 = (byte) (b2 | 128);
                }
                outputStream.write(b2);
            } while (iMessageLength > 0);
        }

        public QoS getQos() {
            return this.header.qos;
        }

        public Type getType() {
            return this.header.type;
        }

        public boolean isDup() {
            return this.header.dup;
        }

        public boolean isRetained() {
            return this.header.retain;
        }

        protected int messageLength() {
            return 0;
        }

        final void read(InputStream inputStream) throws IOException {
            readMessage(inputStream, readMsgLength(inputStream));
        }

        protected void readMessage(InputStream inputStream, int i) throws IOException {
        }

        public void setDup(boolean z) {
            this.header.dup = z;
        }

        public void setQos(QoS qoS) {
            this.header.qos = qoS;
        }

        public void setRetained(boolean z) {
            this.header.retain = z;
        }

        public final byte[] toBytes() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                write(byteArrayOutputStream);
            } catch (IOException unused) {
            }
            return byteArrayOutputStream.toByteArray();
        }

        public final void write(OutputStream outputStream) throws IOException {
            this.headerCode = this.header.encode();
            outputStream.write(this.headerCode);
            writeMsgCode(outputStream);
            writeMsgLength(outputStream);
            writeMessage(outputStream);
        }

        protected void writeMessage(OutputStream outputStream) throws IOException {
        }

        public Message(Header header) throws IOException {
            this.header = header;
        }
    }

    public static class QueryAckMessage extends RetryableMessage {
        private static final int msgLen = 8;
        private byte[] data;
        private int date;
        private int status;

        public enum QueryStatus {
            STATUS_ERROR(0),
            STATUS_OK(1),
            STATUS_NODBCONF(2),
            STATUS_PARAMERROR(3);

            private int value;

            QueryStatus(int i) {
                this.value = i;
            }

            public int get() {
                return this.value;
            }
        }

        public QueryAckMessage(int i, int i2, byte[] bArr) {
            this(i);
            this.data = bArr;
            this.date = (int) (System.currentTimeMillis() / 1000);
            this.status = i2;
        }

        public String getDataAsString() {
            byte[] bArr = this.data;
            if (bArr != null) {
                return FormatUtil.toString(bArr);
            }
            return null;
        }

        public int getStatus() {
            return this.status;
        }

        @Override // io.rong.push.core.PushProtocalStack.RetryableMessage, io.rong.push.core.PushProtocalStack.Message
        protected int messageLength() {
            byte[] bArr = this.data;
            if (bArr == null || bArr.length <= 0) {
                return 8;
            }
            return 8 + bArr.length;
        }

        @Override // io.rong.push.core.PushProtocalStack.RetryableMessage, io.rong.push.core.PushProtocalStack.Message
        protected void readMessage(InputStream inputStream, int i) throws IOException {
            super.readMessage(inputStream, i);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.date = dataInputStream.readInt();
            this.status = dataInputStream.readInt();
            if (i > 1024) {
                throw new IOException("[PushProtocalStack] Length of message is too large :  " + i);
            }
            if (i > 8) {
                this.data = new byte[i - 8];
                dataInputStream.read(this.data);
            }
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setDup(boolean z) {
            throw new UnsupportedOperationException("PubAck messages don't use the DUP flag.");
        }

        @Override // io.rong.push.core.PushProtocalStack.Message
        public void setQos(QoS qoS) {
            throw new UnsupportedOperationException("PubAck messages don't use the QoS flags.");
        }

        @Override // io.rong.push.core.PushProtocalStack.RetryableMessage, io.rong.push.core.PushProtocalStack.Message
        protected void writeMessage(OutputStream outputStream) throws IOException {
            super.writeMessage(outputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeInt(this.date);
            dataOutputStream.writeInt(this.status);
            byte[] bArr = this.data;
            if (bArr != null && bArr.length > 0) {
                dataOutputStream.write(bArr);
            }
            dataOutputStream.flush();
        }

        public QueryAckMessage(int i) {
            super(Message.Type.QUERYACK);
            setMessageId(i);
        }

        public QueryAckMessage(Message.Header header) throws IOException {
            super(header);
        }
    }
}
