package study.thinkingduck.gitclient.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.BindView;
import study.thinkingduck.gitclient.R;
import study.thinkingduck.gitclient.common.BaseActivity;
import study.thinkingduck.gitclient.presenter.IssueListPresenter;
import study.thinkingduck.gitclient.presenter.IssueListPresenterImp;
import study.thinkingduck.gitclient.view.adapter.IssueListAdapter;

/**
 * 이슈 목록 화면
 * Created by thinkingduck on 2017. 3. 3..
 */
public class IssueListActivity extends BaseActivity implements IssueListPresenter.View {

    private IssueListPresenter mPresenter;

    private LinearLayoutManager mLayoutManager;

    @BindView(R.id.view_progress)
    private ProgressBar mViewProgress;

    @BindView(R.id.view_list)
    private RecyclerView mRecyclerView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_issue_list;
    }

    @Override
    public void loadContents() {

        // init presenter
        this.mPresenter = new IssueListPresenterImp();
        this.mPresenter.setView(this);
        this.mPresenter.init(this);

        // init Ui (set vertical)
        this.mLayoutManager = new LinearLayoutManager(this);
        this.mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);

        // start load content
        this.mPresenter.loadContent();

    }

    @Override
    public void setShowLoading(boolean isShow) {
        this.mViewProgress.setVisibility(isShow? View.VISIBLE:View.GONE);
    }

    @Override
    public void setAdapter(IssueListAdapter adapter) {
        this.mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.issue_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_refresh:
                this.mPresenter.reload();
                return true;

            case R.id.menu_write:
                this.mPresenter.moveWrite();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }


    }
}
