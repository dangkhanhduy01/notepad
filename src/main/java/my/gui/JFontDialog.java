package my.gui;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class JFontDialog extends JDialog {
    private JList<String> lstFontName, lstStyle;
    private JList<Integer> lstSize;
    private JLabel lbPreview;
    private JButton btOk, btCancel;

    private Font selectedFont;
    private static final int[] FONT_STYLES = {Font.PLAIN, Font.ITALIC, Font.BOLD, Font.ITALIC + Font.BOLD};
    private static final String[] STYLE_NAMES = {"Plain", "Italic", "Bold", "Italic Bold"};

    private NotePad parent;

    public JFontDialog(Frame owner, boolean modal) {
        super(owner, modal);
        
        if (owner instanceof NotePad) {
            parent = (NotePad) owner;
        } else {
            throw new IllegalArgumentException("Owner must be an instance of NotePad");
        }

        createGUI();
        setFontPreview();
        processEvent();
        setSize(600, 450);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(owner);
    }

    private void createGUI() {
        JPanel p = new JPanel(null);

        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        lstFontName = new JList<>(fontNames);
        JScrollPane scrollFontName = new JScrollPane(lstFontName);
        lstFontName.setSelectedIndex(0);
        p.add(scrollFontName);
        scrollFontName.setBounds(5, 50, 200, 200);
        
        lstStyle = new JList<>(STYLE_NAMES);
        JScrollPane scrollStyle = new JScrollPane(lstStyle);
        lstStyle.setSelectedIndex(0);
        p.add(scrollStyle);
        scrollStyle.setBounds(210, 50, 200, 200);
        
        Integer[] sizes = {8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72};
        lstSize = new JList<>(sizes);
        lstSize.setSelectedIndex(4); // Select 12 by default
        JScrollPane scrollSize = new JScrollPane(lstSize);
        p.add(scrollSize);
        scrollSize.setBounds(420, 50, 100, 200);
        
        lbPreview = new JLabel("AaBbYyZz");
        lbPreview.setBounds(200, 270, 300, 80);
        lbPreview.setHorizontalAlignment(SwingConstants.CENTER);
        p.add(lbPreview);
        
        btOk = new JButton("OK");
        btCancel = new JButton("Cancel");
        btOk.setBounds(250, 350, 100, 30);
        btCancel.setBounds(380, 350, 100, 30);
        
        p.add(btOk);
        p.add(btCancel);
        
        add(p);
    }
    
    private void setFontPreview() {
        String name = lstFontName.getSelectedValue();
        if (name == null) {
            name = Font.SANS_SERIF; // Default font if none selected
        }
        
        int style = FONT_STYLES[lstStyle.getSelectedIndex()];
        
        Integer size = lstSize.getSelectedValue();
        if (size == null) {
            size = 12; // Default size if none selected
        }
        
        selectedFont = new Font(name, style, size);
        lbPreview.setFont(selectedFont);
    }

    private void processEvent() {
        ListSelectionListener updatePreview = e -> setFontPreview();
        lstFontName.addListSelectionListener(updatePreview);
        lstStyle.addListSelectionListener(updatePreview);
        lstSize.addListSelectionListener(updatePreview);
        
        btOk.addActionListener(e -> {
            dispose();
        });
        
        btCancel.addActionListener(e -> dispose());
    }

    public Font getSelectedFont() {
        return selectedFont;
    }
}
