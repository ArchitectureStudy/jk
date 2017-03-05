package study.thinkingduck.gitclient.interactor.data;

import com.google.gson.annotations.SerializedName;

/**
 * 유저 정보
 * Created by thinkingduck on 2017. 3. 5..
 */
public class User {

    @SerializedName("login")
    public String login;

    @SerializedName("avatar_url")
    public String avatarUrl;

    @SerializedName("repos_url")
    public String resposUrl;

}
