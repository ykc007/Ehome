package com.fly.tour.api.entity;

import java.util.List;

public class ContractEntity extends BaseEntity {
    public List<ContractBean> data;


    public List<ContractBean> getData() {
        return data;
    }

    public void setData(List<ContractBean> data) {
        this.data = data;
    }

    public class ContractBean {
        public String id;
        public String number;
        public String title;
        public String remark;
        public String start_time;
        public String end_time;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
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
            return "ContractBean{" +
                    "id='" + id + '\'' +
                    ", number='" + number + '\'' +
                    ", title='" + title + '\'' +
                    ", remark='" + remark + '\'' +
                    ", start_time='" + start_time + '\'' +
                    ", end_time='" + end_time + '\'' +
                    ", crdate='" + crdate + '\'' +
                    ", phone='" + phone + '\'' +
                    ", name='" + name + '\'' +
                    ", company='" + company + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ContractEntity{" +
                "data=" + data +
                ", code_key='" + code_key + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
