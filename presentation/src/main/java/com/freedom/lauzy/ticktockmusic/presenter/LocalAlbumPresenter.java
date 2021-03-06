package com.freedom.lauzy.ticktockmusic.presenter;

import com.freedom.lauzy.interactor.GetLocalAlbumUseCase;
import com.freedom.lauzy.model.LocalAlbumBean;
import com.freedom.lauzy.ticktockmusic.base.BaseRxPresenter;
import com.freedom.lauzy.ticktockmusic.contract.LocalAlbumContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Desc : Local Album Presenter
 * Author : Lauzy
 * Date : 2017/8/2
 * Blog : http://www.jianshu.com/u/e76853f863a9
 * Email : freedompaladin@gmail.com
 */
public class LocalAlbumPresenter extends BaseRxPresenter<LocalAlbumContract.View>
        implements LocalAlbumContract.Presenter {

    private GetLocalAlbumUseCase mGetLocalAlbumUseCase;
    private long mId;

    @Inject
    LocalAlbumPresenter(GetLocalAlbumUseCase getLocalAlbumUseCase) {
        mGetLocalAlbumUseCase = getLocalAlbumUseCase;
    }

    public void setId(long id) {
        mId = id;
    }

    @Override
    public void loadLocalAlbum() {
        mGetLocalAlbumUseCase.execute(new DisposableObserver<List<LocalAlbumBean>>() {
            @Override
            public void onNext(@NonNull List<LocalAlbumBean> localAlbumBeen) {
                if (getView()==null) {
                    return;
                }
                if (localAlbumBeen != null && localAlbumBeen.size() != 0) {
                    getView().loadLocalAlbum(localAlbumBeen);
                } else {
                    getView().setEmptyView();
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                if (getView()==null) {
                    return;
                }
                getView().loadFailed(e);
            }

            @Override
            public void onComplete() {

            }
        }, mId);
    }
}
