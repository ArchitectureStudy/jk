package study.thinkingduck.gitclient.presenter;

import android.app.Activity;

import study.thinkingduck.gitclient.common.BasePresenter;
import study.thinkingduck.gitclient.view.adapter.IssueListAdapter;
import study.thinkingduck.gitclient.view.model.IssueViewModel;

/**
 * 이슈 목록 화면 프레젠터
 * Created by thinkingduck on 2017. 3. 3..
 */
public interface IssueListPresenter extends BasePresenter<IssueListPresenter.View> {

    void init(Activity activity);

    void reload();

    void moveWrite();

    void moveDetail(IssueViewModel data);

    interface View {

        void setShowLoading(boolean isShow);

        void setAdapter(IssueListAdapter adapter);

    }
}
