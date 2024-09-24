package my.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DemoJTable extends JFrame {

    private JTable tblAccounts;
    private JButton btnAdd, btnDelete;
    private JTextField txtAccountName, txtBalance;
    private DefaultTableModel model;

    public DemoJTable(String title) {
        super(title);
        createGUI();
        processEvents();
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        DemoJTable frame = new DemoJTable("Customer Account Management");
        frame.setVisible(true);
    }

    private void createGUI() {
        // Dữ liệu ban đầu cho bảng
        Object[][] data = {
            {"Lê Thành Công", "15000000"},
            {"Trần Minh Khôi", "10000000"}
        };
        String[] columnNames = {"Tên tài khoản", "Số tiền"};
        
        // Khởi tạo DefaultTableModel
        model = new DefaultTableModel(data, columnNames);
        
        // Tạo JTable với model
        tblAccounts = new JTable(model);
        
        // Tạo JScrollPane để chứa JTable
        JScrollPane scrollTable = new JScrollPane(tblAccounts);

        // Tạo panel cho các trường nhập liệu và nút bấm
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Tên tài khoản:"));
        inputPanel.add(txtAccountName = new JTextField(15));
        inputPanel.add(new JLabel("Số tiền:"));
        inputPanel.add(txtBalance = new JTextField(10));
        inputPanel.add(btnAdd = new JButton("Thêm"));
        inputPanel.add(btnDelete = new JButton("Xóa"));

        // Thêm bảng và panel nhập liệu vào JFrame
        add(scrollTable, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
    }

    private void processEvents() {
        // Xử lý sự kiện khi nhấn nút "Thêm"
        btnAdd.addActionListener((e) -> {
            String error = "";
            try {
                String accountName = txtAccountName.getText();
                String balanceText = txtBalance.getText();

                if (accountName.isEmpty()) {
                    error = "Bạn chưa nhập tên tài khoản!";
                }
                if (balanceText.isEmpty()) {
                    error = "Bạn chưa nhập số tiền!";
                }

                double balance = Double.parseDouble(balanceText);

                if (!error.isEmpty()) {
                    JOptionPane.showMessageDialog(this, error, "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Thêm thông tin tài khoản mới vào bảng
                model.addRow(new Object[]{accountName, balanceText});

                // Xóa nội dung trong các trường sau khi thêm
                txtAccountName.setText("");
                txtBalance.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Số tiền phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Xử lý sự kiện khi nhấn nút "Xóa"
        btnDelete.addActionListener((e) -> {
            int selectedIndex = tblAccounts.getSelectedRow();

            if (selectedIndex >= 0) {
                // Xác nhận trước khi xóa
                if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa tài khoản này?", "Xác nhận", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    // Xóa dòng được chọn
                    model.removeRow(selectedIndex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
