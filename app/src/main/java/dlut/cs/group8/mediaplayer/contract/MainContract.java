package dlut.cs.group8.mediaplayer.contract;

import android.content.ContentResolver;

import java.util.List;

/**
 * Created by Administrator on 2017-10-16.
 */

public interface MainContract {
    interface MainPresenter extends BasePresenter{
        public void getAudioList(ContentResolver contentResolver);
    }
    interface MainView extends BaseView{
        public void showAudioList(List list);
    }
}
