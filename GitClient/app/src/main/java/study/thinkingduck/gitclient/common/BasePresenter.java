package study.thinkingduck.gitclient.common;

/**
 * Created by thinkingduck on 2017. 3. 3..
 */

public interface BasePresenter<T> {

    void setView(T view);

    void loadContent();

}
