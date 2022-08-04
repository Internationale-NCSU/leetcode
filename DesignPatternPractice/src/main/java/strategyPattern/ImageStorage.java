package strategyPattern;

public class ImageStorage {
    private String compressor;
    public String filter;

    // violating single responsible principle. Store and Compress in a same class.
    // can't support new compressor and filter. Maintenance will be harder and harder.

    public ImageStorage(String compressor, String filter) {
        this.compressor = compressor;
        this.filter = filter;
    }

    public void store(String fileNmae){
        if(compressor.equals("jpeg")){
            System.out.println("Compressing using JPEG");
        }else if(compressor.equals("png")){
            System.out.println("Compressing using PNG");
        }

        if(filter.equals("b&w")){
            System.out.println("Applying b&w filter");
        }else if(filter.equals("high-contrast")){
            System.out.println("Applying high-contrast filter");
        }
    }
}
