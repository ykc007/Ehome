package com.fly.tour.api.entity;

public class LoginEntity extends BaseEntity {

    /**
     * data : {"id":"7","tstamp":"1590045956","crdate":"1590045659","cruser_id":"0","deleted":"0","hidden":"0","parent_id":"0","username":"18812345678","password":"1636f982d309351b7f6e937e7886f6ef","usergroup":"3","name":"伊川夏","mobile":"18812345678","email":"","remark":"","lastlogin":"1590045968","lastloginip":"127.0.0.1","category":"2","company_id":"7","is_admin":"1","extension_code":null,"token":"eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI3IiwiaWF0IjoxNTkwMDUxMzExLCJuYmYiOjE1OTAwNTEzMTEsImV4cCI6MTU5MDA1MTMxMSwiaXAiOiIyMTMwNzA2NDMzIiwidWEiOmZhbHNlfQ.L3H1Fw74XJiYLddnf3Xdul8CPEkcJzqy_8NzlBmJbow"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 7
         * tstamp : 1590045956
         * crdate : 1590045659
         * cruser_id : 0
         * deleted : 0
         * hidden : 0
         * parent_id : 0
         * username : 18812345678
         * password : 1636f982d309351b7f6e937e7886f6ef
         * usergroup : 3
         * name : 伊川夏
         * mobile : 18812345678
         * email :
         * remark :
         * lastlogin : 1590045968
         * lastloginip : 127.0.0.1
         * category : 2
         * company_id : 7
         * is_admin : 1
         * extension_code : null
         * token : eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI3IiwiaWF0IjoxNTkwMDUxMzExLCJuYmYiOjE1OTAwNTEzMTEsImV4cCI6MTU5MDA1MTMxMSwiaXAiOiIyMTMwNzA2NDMzIiwidWEiOmZhbHNlfQ.L3H1Fw74XJiYLddnf3Xdul8CPEkcJzqy_8NzlBmJbow
         */

        private String id;
        private String tstamp;
        private String crdate;
        private String cruser_id;
        private String deleted;
        private String hidden;
        private String parent_id;
        private String username;
        private String password;
        private String usergroup;
        private String name;
        private String mobile;
        private String email;
        private String remark;
        private String lastlogin;
        private String lastloginip;
        private String category;
        private String company_id;
        private String is_admin;
        private Object extension_code;
        private String token;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTstamp() {
            return tstamp;
        }

        public void setTstamp(String tstamp) {
            this.tstamp = tstamp;
        }

        public String getCrdate() {
            return crdate;
        }

        public void setCrdate(String crdate) {
            this.crdate = crdate;
        }

        public String getCruser_id() {
            return cruser_id;
        }

        public void setCruser_id(String cruser_id) {
            this.cruser_id = cruser_id;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getHidden() {
            return hidden;
        }

        public void setHidden(String hidden) {
            this.hidden = hidden;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsergroup() {
            return usergroup;
        }

        public void setUsergroup(String usergroup) {
            this.usergroup = usergroup;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getLastlogin() {
            return lastlogin;
        }

        public void setLastlogin(String lastlogin) {
            this.lastlogin = lastlogin;
        }

        public String getLastloginip() {
            return lastloginip;
        }

        public void setLastloginip(String lastloginip) {
            this.lastloginip = lastloginip;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getIs_admin() {
            return is_admin;
        }

        public void setIs_admin(String is_admin) {
            this.is_admin = is_admin;
        }

        public Object getExtension_code() {
            return extension_code;
        }

        public void setExtension_code(Object extension_code) {
            this.extension_code = extension_code;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
