package study.thinkingduck.gitclient.interactor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import study.thinkingduck.gitclient.common.BaseLoader;
import study.thinkingduck.gitclient.interactor.common.NetConfig;
import study.thinkingduck.gitclient.interactor.data.Issue;
import study.thinkingduck.gitclient.view.model.IssueViewModel;

/**
 * Github 이슈 목록 불러오기
 * Created by thinkingduck on 2017. 3. 5..
 */
public class IssueListLoader extends BaseLoader<List<Issue>, List<IssueViewModel>> {

    private String mOwner;
    private String mRepo;
    private int mPage;

    public IssueListLoader(String owner, String repo, int page, BaseLoader.FinishLoadListener<List<IssueViewModel>> listener) {
        super(listener);
        this.mOwner = owner;
        this.mRepo = repo;
        this.mPage = page;
    }

    @Override
    public Call<List<Issue>> getService(NetConfig.GitHubService service) {
        return service.getIssueList(this.mOwner, this.mRepo, this.mPage);
    }

    @Override
    public List<IssueViewModel> parseData(List<Issue> data) {

        ArrayList<IssueViewModel> viewModels = new ArrayList<>();
        for (Issue issue : data) {
            viewModels.add(new IssueViewModel(issue));
        }

        return viewModels;
    }


}
