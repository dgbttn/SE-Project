package BasicComponents.UI;

import javax.swing.*;

public class TestUI {
    public static void main(String[] args) {
        String[] columnHeaders = {"STT", "Số gói thầu", "Tên gói thầu", "Hình thức", "Chi phí theo kế hoạch năm được duyệt", "Giá trị gói thầu", "Số Tờ trình", "Ngày tờ trình", "Số hợp đồng", "Tên đối tác", "Ngày hợp đồng", "Loại hợp đồng", "Giá trị hợp đồng", "Ghi chú"};
        UI ui = new UI("Phòng Hành Chính");
        ui.setForm(columnHeaders);
        ui.setTable(columnHeaders, "Bảng Tổng hợp danh sách gói thầu, hợp đồng phòng hành chính năm 2018");
        ui.setSearchBox();
        ui.addComponents();
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}
