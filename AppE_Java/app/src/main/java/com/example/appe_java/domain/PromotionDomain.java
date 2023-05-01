package com.example.appe_java.domain;

public class PromotionDomain {
    private String Topic;
    private String Content;
    private String Img;
    private String Time;

    public PromotionDomain(String topic, String content, String img, String time) {
        Topic = topic;
        Content = content;
        Img = img;
        Time = time;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
