package MybatisXML.Entitymodel;

import java.time.LocalDateTime;

public class SystemMsg {

    private String id;
    private String msgContent;
    private LocalDateTime createTime;
    private Short sendToAll;

    public SystemMsg() {
    }

    public SystemMsg(String id, String msgContent, LocalDateTime createTime, Short sendToAll) {
        this.id = id;
        this.msgContent = msgContent;
        this.createTime = createTime;
        this.sendToAll = sendToAll;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Short getSendToAll() {
        return sendToAll;
    }

    public void setSendToAll(Short sendToAll) {
        this.sendToAll = sendToAll;
    }

    @Override
    public String toString() {
        return "SystemMsg{" +
                "id='" + id + '\'' +
                ", msgContent='" + msgContent + '\'' +
                ", createTime=" + createTime +
                ", sendToAll=" + sendToAll +
                '}';
    }
}
