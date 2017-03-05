package study.thinkingduck.gitclient.presenter;

import android.app.Activity;

import java.util.List;

import study.thinkingduck.gitclient.common.BaseLoader;
import study.thinkingduck.gitclient.interactor.IssueListLoader;
import study.thinkingduck.gitclient.router.IssueListRouter;
import study.thinkingduck.gitclient.view.adapter.IssueListAdapter;
import study.thinkingduck.gitclient.view.model.IssueViewModel;

/**
 * 이슈 목록 화면 프레젠터
 * Created by thinkingduck on 2017. 3. 3..
 */
public class IssueListPresenterImp implements IssueListPresenter {

    private View mView;
    private Activity mActivity;
    private IssueListRouter mRouter;


    private IssueListAdapter mAdapter;

    private int mPage = 1;

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void init(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void loadContent() {

        // Set Router
        this.mRouter = new IssueListRouter();

        // Set Adapter
        this.mAdapter = new IssueListAdapter();
        mView.setAdapter(this.mAdapter);

        // Start load issue list
        loadIssueList(this.mPage);
    }

    @Override
    public void reload() {

        this.mPage = 1;

        // Start load issue list
        loadIssueList(this.mPage);
    }

    @Override
    public void moveWrite() {
        this.mRouter.moveWrite(this.mActivity);
    }

    @Override
    public void moveDetail(IssueViewModel data) {
        this.mRouter.moveDetail(this.mActivity, data);
    }

    private void loadIssueList(int page) {
        mView.setShowLoading(true);

        IssueListLoader loader = new IssueListLoader("ArchitectureStudy", "jk", page, mOnFinishListener);
        loader.start();

    }

    private BaseLoader.FinishLoadListener<List<IssueViewModel>> mOnFinishListener = new BaseLoader.FinishLoadListener<List<IssueViewModel>>() {

        @Override
        public void onFinishLoad(boolean isSuccess, List<IssueViewModel> data) {
            mView.setShowLoading(false);
            mAdapter.addDatas(data);
        }
    };

}
