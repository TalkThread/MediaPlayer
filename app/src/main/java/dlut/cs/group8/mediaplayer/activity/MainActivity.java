package dlut.cs.group8.mediaplayer.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import dlut.cs.group8.mediaplayer.R;
import dlut.cs.group8.mediaplayer.contract.MainContract;
import dlut.cs.group8.mediaplayer.persenter.BasePresenter;
import dlut.cs.group8.mediaplayer.persenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainContract.MainView{

    Button mAudioButton;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    int code_permission=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //请求授权
        int isPermissionuthoritied=checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
        if(isPermissionuthoritied!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},code_permission);
        }

        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerview_audio_list);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAudioButton=(Button)findViewById(R.id.button_select_audio);
        mAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //调用Presenter的方法进行业务处理
                ((MainPresenter)mPresenter).getAudioList(getContentResolver());
            }
        });

    }

    @Override
    public BasePresenter createPresenter() {
        return new MainPresenter();
    }

    //请求权限的回调处理
    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
        }
    }*/

    @Override
    public void showAudioList(List list) {
        //进行页面更新
        Log.i("--------------->","页面更新");
    }


}
