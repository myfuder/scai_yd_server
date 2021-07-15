package com.example.scai_yd_server.model;

public class PicInfoModel {

    private String id;
    private String thumbnail;
    private String title;
    private Integer picCount;
    private Integer videoCount;
    private Float rateCount;
    private Float price;

    public String getWpno() {
        return wpno;
    }

    public void setWpno(String wpno) {
        this.wpno = wpno;
    }

    private String wpno;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBelone() {
        return belone;
    }

    public void setBelone(String belone) {
        this.belone = belone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDetailcontent() {
        return detailcontent;
    }

    public void setDetailcontent(String detailcontent) {
        this.detailcontent = detailcontent;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    private String type;
    private String belone;
    private String number;
    private String memory;
    private String detailcontent;
    private String remarks;
    private String hot;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPicCount() {
        return picCount;
    }

    public void setPicCount(Integer picCount) {
        this.picCount = picCount;
    }

    public Integer getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Integer videoCount) {
        this.videoCount = videoCount;
    }

    public Float getRateCount() {
        return rateCount;
    }

    public void setRateCount(Float rateCount) {
        this.rateCount = rateCount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
