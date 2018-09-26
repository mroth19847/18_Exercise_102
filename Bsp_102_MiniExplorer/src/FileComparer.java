
import java.util.Comparator;

public class FileComparer implements Comparator<Data>{

    @Override
    public int compare(Data o1, Data o2) {
        if(o1.getName().equals(".."))return -1;
        if(o2.getName().equals(".."))return 1;
        if(o1.isDirectory()&&!o2.isDirectory()) return -1;
        if(!o2.isDirectory()&&o2.isDirectory()) return 1;
        return o1.getName().compareTo(o2.getName());
    }
    
}
