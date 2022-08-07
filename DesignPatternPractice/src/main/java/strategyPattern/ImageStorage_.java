package strategyPattern;

//The Context Class maintain a reference to a Strategy Object
// Strategy represent an interface or an abstract class.
// After modified, we could implement new interface to add new function rather than modified at the
// original class. to follow the open close principle.

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
