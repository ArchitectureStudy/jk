package study.thinkingduck.gitclient.interactor.data;

import com.google.gson.annotations.SerializedName;

/**
 * 이슈
 * Created by thinkingduck on 2017. 3. 5..
 */
public class Issue {

    public String id;

    public int number;

    public String title;

    public String state;

    public User user;

    public User assignee;

    public User[] assignees;

    public int comments;

    @SerializedName("created_at")
    public String createdAt;

    @SerializedName("updated_at")
    public String updatedAt;

}
