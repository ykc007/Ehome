package com.fly.tour.api.entity;

import java.util.List;

public class SalesOrderEntity extends BaseEntity {

    public List<SalesOrderBean> data;

    public List<SalesOrderBean> getData() {
        return data;
    }

    public void setData(List<SalesOrderBean> data) {
        this.data = data;
    }

    public class SalesOrderBean {
        public String id;
        public String number;
        public String money;
        public String remark;
        public String deal_time;
        public String crdate;
        public String phone;
        public String name;
        public String company;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getDeal_time() {
            return deal_time;
        }

        public void setDeal_time(String deal_time) {
            this.deal_time = deal_time;
        }

        public String getCrdate() {
            return crdate;
        }

        public void setCrdate(String crdate) {
            this.crdate = crdate;
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

        @Override
        public String toString() {
            return "SalesOrderBean{" +
                    "id='" + id + '\'' +
                    ", number='" + number + '\'' +
                    ", money='" + money + '\'' +
                    ", remark='" + remark + '\'' +
                    ", deal_time='" + deal_time + '\'' +
                    ", crdate='" + crdate + '\'' +
                    ", phone='" + phone + '\'' +
                    ", name='" + name + '\'' +
                    ", company='" + company + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SalesOrderEntity{" +
                "data=" + data +
                '}';
    }
}
