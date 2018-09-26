
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CellRenderer implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object o, int i, boolean isSelected, boolean hasFocus) {
        JLabel label = new JLabel(o.toString());
        label.setOpaque(true);
        if (o instanceof Data) {
            Data d = (Data) o;
            if (d.isDirectory()) {
                label.setForeground(Color.red);
                label.setBackground(new Color(200,200,200));
                label.setFont(new Font("Courier New",Font.ITALIC+Font.BOLD,12));
                label.setBackground(isSelected ? new Color(150,150,150) : new Color(200,200,200));
            } else {
                label.setForeground(Color.blue);
                label.setBackground(new Color(230,230,230));
                label.setFont(new Font("Courier New",Font.PLAIN,12));
                label.setBackground(isSelected ? new Color(150,150,150): new Color(230,230,230));
            }
        }
        return label;
    }

}
