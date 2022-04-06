import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Program {
    public static void main(String[] args) {
        // Реактивное программирование - парадигма
        // Ориентированное на потоки данных
        // Observable - наблюдаемый объект
        // Observer -  наблюдатель

        int a = 100;
        int b = 200;

        int c = a + b;

        a = 500; // Observable
        b = 600; // Observable
        // c - Observer

        // Observable object
        Observable<String> myObservable = Observable.create(emitter -> {
            int i = 0;
            while (i < 5) {
                emitter.onNext("Hello: " + i);
                i++;
            }
            emitter.onComplete();
        });

        // Observer
        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                // subscribed on Observable object
                System.out.println("Subscribed!!!");
            }

            @Override
            public void onNext(@NonNull String s) {
                // changed value of Observable object
                System.out.println("Get value from the Observable object: "+s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                //error

            }

            @Override
            public void onComplete() {
                // completed
                System.out.println("Completed!");
            }
        };
        myObservable.subscribe(myObserver); // !!!



    }
}
