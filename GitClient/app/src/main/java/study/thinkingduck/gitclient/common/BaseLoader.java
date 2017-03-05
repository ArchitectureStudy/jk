package study.thinkingduck.gitclient.common;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import study.thinkingduck.gitclient.interactor.common.NetConfig;

/**
 * Base Loader
 * Created by thinkingduck on 2017. 3. 5..
 */
public abstract class BaseLoader<T, A> {

    private FinishLoadListener<A> mListener;

    public BaseLoader(FinishLoadListener<A> listener) {
        this.mListener = listener;
    }

    public abstract Call<T> getService(NetConfig.GitHubService service);

    public abstract A parseData(T data);

    public void start() {

        NetConfig.GitHubService service = NetConfig.getHttpLoader().create(NetConfig.GitHubService.class);
        Call<T> call = getService(service);
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {

                if (mListener != null) {
                    mListener.onFinishLoad(true, parseData(response.body()));
                }

            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {

                if (mListener != null) {
                    mListener.onFinishLoad(false, null);
                }

            }
        });
        call.request();
    }

    public interface FinishLoadListener<T> {
        void onFinishLoad (boolean isSuccess, T data);
    }

}
