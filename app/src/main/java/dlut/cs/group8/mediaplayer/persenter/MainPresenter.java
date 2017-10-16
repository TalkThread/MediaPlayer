package dlut.cs.group8.mediaplayer.persenter;

import android.content.ContentResolver;

import dlut.cs.group8.mediaplayer.activity.MainActivity;
import dlut.cs.group8.mediaplayer.contract.MainContract;
import dlut.cs.group8.mediaplayer.model.service.AudioLoader;

/**
 * Created by Administrator on 2017-10-16.
 */

public class MainPresenter extends BasePresenter implements MainContract.MainPresenter{

    @Override
    public void getAudioList(ContentResolver contentResolver) {
        AudioLoader audioLoader=new AudioLoader(contentResolver);

        //调用View的方法更新视图
        ((MainActivity)getView()).showAudioList(audioLoader.getAudioList());
    }
}
