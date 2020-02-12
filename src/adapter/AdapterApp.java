package adapter;

public class AdapterApp {
    public static void main(String[] args) {
        AnalogVideoTransferInterface transferInterface = new SVGAtoDVIAdapter();
        transferInterface.transferSignal();
    }

}

interface AnalogVideoTransferInterface{
    void transferSignal();
}

class SVGA implements AnalogVideoTransferInterface{

    @Override
    public void transferSignal(){
        System.out.println("Analog signal is transferring");
    }
}

class DVI{
    public void transferDigitalSignal() {
        System.out.println("Digital signal is transferring");
    }
}

class SVGAtoDVIAdapter extends SVGA{
    DVI dvi = new DVI();

    @Override
    public void transferSignal() {
        dvi.transferDigitalSignal();
    }
}
