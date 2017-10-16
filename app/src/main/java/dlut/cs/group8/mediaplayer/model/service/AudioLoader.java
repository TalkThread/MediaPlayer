package dlut.cs.group8.mediaplayer.model.service;

import android.Manifest;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;


import java.util.ArrayList;
import java.util.List;

import dlut.cs.group8.mediaplayer.model.bean.AudioBean;


/**
 * Created by Administrator on 2017-10-16.
 */

public class AudioLoader {

    ContentResolver contentResolver;
    List<AudioBean> audioList;
    public AudioLoader(ContentResolver contentResolver){
        this.contentResolver=contentResolver;
    }

    public List getAudioList(){

        audioList=new ArrayList<>();
        Uri uri= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection=new String[]{
                //音频名称
                MediaStore.Audio.Media.TITLE,
                //音频时长
                MediaStore.Audio.Media.DURATION,
                //音频所属专辑
                MediaStore.Audio.Media.ALBUM,
                //音频艺术家
                MediaStore.Audio.Media.ARTIST,
                //音频ID
                MediaStore.Audio.Media._ID,
                //音频路径
                MediaStore.Audio.Media.DATA,
                //音频大小
                MediaStore.Audio.Media.SIZE
        };
        String where=null;
        String[] whereargs=null;
        String sortorder= MediaStore.Audio.Media.SIZE;

        Cursor cursor=contentResolver.query(uri,projection,where,whereargs,sortorder);
        if(cursor!=null&&cursor.moveToFirst()){
            do {
                AudioBean bean=new AudioBean();
                String mTitle=cursor.getString(0);
                bean.setTitle(mTitle);
                long mDuration=cursor.getLong(1);
                bean.setDuration(mDuration);
                String mAlbum=cursor.getString(2);
                bean.setAlbums(mAlbum);
                String mArtist=cursor.getString(3);
                bean.setArtist(mArtist);
                int mID=cursor.getInt(4);
                bean.setId(mID);
                String mData=cursor.getString(5);
                bean.setPath(mData);
                long mSize=cursor.getLong(6);
                bean.setSize(mSize);

                audioList.add(bean);
            }while(cursor.moveToNext());
        }
        return audioList;
    }


}
