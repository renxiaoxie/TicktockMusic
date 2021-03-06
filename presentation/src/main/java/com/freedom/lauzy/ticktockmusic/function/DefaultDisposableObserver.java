package com.freedom.lauzy.ticktockmusic.function;

import com.freedom.lauzy.ticktockmusic.function.exception.ArtistAvatarException;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Desc : 默认，可设置一些Dialog等
 * Author : Lauzy
 * Date : 2017/8/4
 * Blog : http://www.jianshu.com/u/e76853f863a9
 * Email : freedompaladin@gmail.com
 */
public class DefaultDisposableObserver<T> extends DisposableObserver<T> {

    @Override
    public void onNext(@NonNull T t) {

    }

    @Override
    public void onError(@NonNull Throwable e) {
        if (!(e instanceof ArtistAvatarException)) {
            e.printStackTrace();
        }
    }

    @Override
    public void onComplete() {

    }
}
