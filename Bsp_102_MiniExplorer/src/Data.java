
import java.io.File;
import java.text.SimpleDateFormat;

public class Data extends File{

    private String name;
    public Data(String pathname, String name) {
        super(pathname);
        this.name = name;
    }

    @Override
    public String toString() {
        if(this.isDirectory()){
            return name;
        } else {
            String attr = "";
            if(this.canRead())attr+="R";
            if(this.canWrite())attr+="W";
            if(this.canExecute())attr+="X";
            SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy HH:mm");
            return String.format("%-30s%-25s%d KB%8s",name,sdf.format(this.lastModified()),this.length()/1024,attr);
        }
    }
    
    
    
}
