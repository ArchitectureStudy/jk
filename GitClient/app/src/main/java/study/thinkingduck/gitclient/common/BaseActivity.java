package study.thinkingduck.gitclient.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Base Activity
 * Created by thinkingduck on 2017. 3. 3..
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        // 버터나이프 설정
        ButterKnife.bind(this);

        // 데이터 로드
        loadContents();
    }

    public abstract int getLayoutId();

    public abstract void loadContents();

}
