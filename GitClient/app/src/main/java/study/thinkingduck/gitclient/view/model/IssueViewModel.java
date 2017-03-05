package study.thinkingduck.gitclient.view.model;

import android.os.Parcel;
import android.os.Parcelable;

import study.thinkingduck.gitclient.interactor.data.Issue;

/**
 * 이슈 뷰모델
 * Created by thinkingduck on 2017. 3. 5..
 */
public class IssueViewModel implements Parcelable {

    public String title;

    public String state;

    public int comments;

    public String date;

    public String userId;

    public String userProfileUrl;

    public int number;

    public IssueViewModel() {
    }

    public IssueViewModel(Issue issue) {
        this.title = issue.title;
        this.state = issue.state;
        this.comments = issue.comments;
        this.date = issue.createdAt;
        this.userId = issue.user.login;
        this.userProfileUrl = issue.assignee.avatarUrl;
        this.number = issue.number;
    }

    protected IssueViewModel(Parcel in) {
        title = in.readString();
        state = in.readString();
        comments = in.readInt();
        date = in.readString();
        userId = in.readString();
        userProfileUrl = in.readString();
        number = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(state);
        dest.writeInt(comments);
        dest.writeString(date);
        dest.writeString(userId);
        dest.writeString(userProfileUrl);
        dest.writeInt(number);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<IssueViewModel> CREATOR = new Creator<IssueViewModel>() {
        @Override
        public IssueViewModel createFromParcel(Parcel in) {
            return new IssueViewModel(in);
        }

        @Override
        public IssueViewModel[] newArray(int size) {
            return new IssueViewModel[size];
        }
    };
}
