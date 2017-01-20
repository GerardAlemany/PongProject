package Patron;

import java.util.Observable;
import java.util.Observer;

public abstract class ModelAbstracte extends Observable {

    public void afegirObservador(Observer obsr) {
        addObserver(obsr);
    }

    public void avisarObservadors() {
        setChanged();
        notifyObservers();
    }

    

}
