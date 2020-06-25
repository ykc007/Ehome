package com.ehome.electpin.entity;

import java.util.List;

public  class CallIndex
{


    /**
     * code_key : success
     * code : 1
     * msg : 操作成功
     * data : [{"id":"11","user_id":"9","time":"180","phone":"18812345961","status":"4","remark":"还不错的样子","origin":"1","info_id":"54","name":"小明","company":"达达"},{"id":"10","user_id":"9","time":"0","phone":"18812345961","status":"0","remark":null,"origin":"1","info_id":"54","name":"小明","company":"达达"},{"id":"9","user_id":"9","time":"0","phone":"18812345961","status":"0","remark":null,"origin":"1","info_id":"54","name":"小明","company":"达达"}]
     */

    private String code_key;
    private int code;
    private String msg;
    private List<DataBean> data;

    public String getCode_key()
    {
        return code_key;
    }

    public void setCode_key(String code_key)
    {
        this.code_key = code_key;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public List<DataBean> getData()
    {
        return data;
    }

    public void setData(List<DataBean> data)
    {
        this.data = data;
    }

    public static class DataBean
    {
        /**
         * id : 11
         * user_id : 9
         * time : 180
         * phone : 18812345961
         * status : 4
         * remark : 还不错的样子
         * origin : 1
         * info_id : 54
         * name : 小明
         * company : 达达
         */

        private String id;
        private String user_id;
        private String time;
        private String phone;
        private String status;
        private String remark;
        private String origin;
        private String info_id;
        private String name;
        private String company;

        public String getId()
        {
            return id;
        }

        public void setId(String id)
        {
            this.id = id;
        }

        public String getUser_id()
        {
            return user_id;
        }

        public void setUser_id(String user_id)
        {
            this.user_id = user_id;
        }

        public String getTime()
        {
            return time;
        }

        public void setTime(String time)
        {
            this.time = time;
        }

        public String getPhone()
        {
            return phone;
        }

        public void setPhone(String phone)
        {
            this.phone = phone;
        }

        public String getStatus()
        {
            return status;
        }

        public void setStatus(String status)
        {
            this.status = status;
        }

        public String getRemark()
        {
            return remark;
        }

        public void setRemark(String remark)
        {
            this.remark = remark;
        }

        public String getOrigin()
        {
            return origin;
        }

        public void setOrigin(String origin)
        {
            this.origin = origin;
        }

        public String getInfo_id()
        {
            return info_id;
        }

        public void setInfo_id(String info_id)
        {
            this.info_id = info_id;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public String getCompany()
        {
            return company;
        }

        public void setCompany(String company)
        {
            this.company = company;
        }
    }
}
