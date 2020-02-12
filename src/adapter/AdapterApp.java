package adapter;

public class AdapterApp {
    public static void main(String[] args) {
        AnalogSignalInterface adapter = new SVGAtoDVIAdapter();
        adapter.transferAnalogSignal();
    }
}

interface AnalogSignalInterface{
    void transferAnalogSignal();
}

class SVGA implements AnalogSignalInterface{
    @Override
    public void transferAnalogSignal(){
        System.out.println("Analog signal is transferring");
    }
}

class DVI{
    public void transferDigitalSignal() {
        System.out.println("Digital signal is transferring");
    }
}

class SVGAtoDVIAdapter extends SVGA {
    DVI dvi = new DVI();

    @Override
    public void transferAnalogSignal() {
        dvi.transferDigitalSignal();
    }
}
