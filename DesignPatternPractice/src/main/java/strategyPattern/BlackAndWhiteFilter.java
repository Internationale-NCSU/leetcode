package strategyPattern;

public class BlackAndWhiteFilter implements Filter{
    @Override
    public void apply(String filename) {
        System.out.println("Applying b&w filter");
    }
}
