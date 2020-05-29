package com.hxdl.coceweb.retrofit;

public class GithubUserInfo {
    String login,url,name,company;
    int id,public_repos,followers;

    @Override
    public String toString() {
        return "GithubUserInfo{" +
                "login='" + login + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", id=" + id +
                ", public_repos=" + public_repos +
                ", followers=" + followers +
                '}';
    }
}