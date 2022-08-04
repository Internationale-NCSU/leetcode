package strategyPattern;

//The Context Class maintain a reference to a Strategy Object
// Strategy represent an interface or an abstract class.

public class ImageStorage_ {
    private Compressor compressor;
    public Filter filter;

    public ImageStorage_(Compressor compressor, Filter filter) {
        this.compressor = compressor;
        this.filter = filter;
    }

    public void store(String fileNmae){
        compressor.compress(fileNmae);
        filter.apply(fileNmae);
    }
}
