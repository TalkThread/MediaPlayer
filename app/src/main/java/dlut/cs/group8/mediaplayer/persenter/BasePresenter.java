package dlut.cs.group8.mediaplayer.persenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017-10-15.
 * 包括一些通用功能。
 */

public abstract class BasePresenter <V>{

    protected Reference<V> mViewRref;

    //与View建立关联
    public void attachView(V view){
        this.mViewRref=new WeakReference<V>(view);
    };

    //获取View
    public V getView(){
        return mViewRref.get();
    }

    //与View解除关联
    public void detachView(){
        if(mViewRref!=null){
            mViewRref.clear();
        }
        mViewRref=null;
    }


}
