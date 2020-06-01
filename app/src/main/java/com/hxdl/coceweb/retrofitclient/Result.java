package com.hxdl.coceweb.retrofitclient;

public class Result {

    /**
     * errcode : 0000
     * data : https://aidata.hxlx.com/aidata/custom/getUploadRecordById.xhtml?picId=d202355d25406284ea53ed74ebb463cd
     * success : true
     */

    private String errcode;
    private Object data;
    private boolean success;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "TeacherInviteQrcodeResult{" +
                "errcode='" + errcode + '\'' +
                ", data=" + data +
                ", success=" + success +
                ", msg='" + msg + '\'' +
                '}';
    }
}
