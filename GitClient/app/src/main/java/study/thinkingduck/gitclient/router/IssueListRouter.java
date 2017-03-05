package study.thinkingduck.gitclient.router;

import android.app.Activity;
import android.content.Intent;

import study.thinkingduck.gitclient.common.BaseRouter;
import study.thinkingduck.gitclient.view.IssueDetailActivity;
import study.thinkingduck.gitclient.view.IssueWriteActivity;
import study.thinkingduck.gitclient.view.model.IssueViewModel;

/**
 * Created by thinkingduck on 2017. 3. 6..
 */

public class IssueListRouter extends BaseRouter {

    private final int REQUEST_CODE_DETAIL   = 10001;
    private final int REQUEST_CODE_WRITE    = 10002;

    public IssueListRouter() {}

    public void moveDetail(Activity target, IssueViewModel model) {
        Intent intent = new Intent(target, IssueDetailActivity.class);
        intent.putExtra(IssueDetailActivity.INTENT_EXTRA_ISSUE, model);
        target.startActivityForResult(intent, REQUEST_CODE_DETAIL);
    }

    public void moveWrite(Activity target) {
        Intent intent = new Intent(target, IssueWriteActivity.class);
        target.startActivityForResult(intent, REQUEST_CODE_WRITE);
    }

}
