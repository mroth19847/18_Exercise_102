
import java.io.File;

public class Data extends File{
    
    public Data(String pathname) {
        super(pathname);
    }

    @Override
    public String toString() {
        if(this.isDirectory()){
            return this.getName();
        } else {
            return String.format("test.txt");
        }
    }
    
    
    
}
