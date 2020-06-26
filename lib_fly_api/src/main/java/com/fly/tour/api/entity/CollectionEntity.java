package com.fly.tour.api.entity;

import java.util.List;

public class CollectionEntity extends BaseEntity {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 3
         * category : 2
         * money : 38888.00
         * refund_reason : 发过去的货有问题 客户拒签，要求退款
         * time : 1622608200
         * type : 1
         * crdate : 1591152344
         * remark : 仓库把残次品当优质品发过去了
         * phone : 18812345961
         * name : 小明
         * company : 达达
         * number : HD20200644101344
         */

        private String id;
        private String category;
        private String money;
        private String refund_reason;
        private String time;
        private String type;
        private String crdate;
        private String remark;
        private String phone;
        private String name;
        private String company;
        private String number;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getRefund_reason() {
            return refund_reason;
        }

        public void setRefund_reason(String refund_reason) {
            this.refund_reason = refund_reason;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCrdate() {
            return crdate;
        }

        public void setCrdate(String crdate) {
            this.crdate = crdate;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
