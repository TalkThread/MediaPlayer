package dlut.cs.group8.mediaplayer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dlut.cs.group8.mediaplayer.contract.BaseView;
import dlut.cs.group8.mediaplayer.persenter.BasePresenter;

/**
 * Created by Administrator on 2017-10-15.
 * 通用Activity,实现BaseView接口
 */

public abstract class BaseActivity <T extends BasePresenter> extends AppCompatActivity {
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //实例化Presenter
        mPresenter=createPresenter();
        mPresenter.attachView((BaseView) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    public abstract T createPresenter();
}
