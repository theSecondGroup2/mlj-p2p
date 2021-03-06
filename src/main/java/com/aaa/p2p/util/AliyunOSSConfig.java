package com.aaa.p2p.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * className:AliyunOSSConfig
 * discription:
 * author:luRuiHua
 * createTime:2018-12-12 10:49
 */
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSConfig {
    private String bucketname;
    private String endpoint;
    private String keyid;
    private String keysecret;
    private String filehost;

    @Override
    public String toString() {
        return "AliyunOSSConfig{" +
                "bucketname='" + bucketname + '\'' +
                ", endpoint='" + endpoint + '\'' +
                ", keyid='" + keyid + '\'' +
                ", keysecret='" + keysecret + '\'' +
                ", filehost='" + filehost + '\'' +
                '}';
    }

    public String getBucketname() {
        return bucketname;
    }

    public void setBucketname(String bucketname) {
        this.bucketname = bucketname;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public String getKeysecret() {
        return keysecret;
    }

    public void setKeysecret(String keysecret) {
        this.keysecret = keysecret;
    }

    public String getFilehost() {
        return filehost;
    }

    public void setFilehost(String filehost) {
        this.filehost = filehost;
    }
}
