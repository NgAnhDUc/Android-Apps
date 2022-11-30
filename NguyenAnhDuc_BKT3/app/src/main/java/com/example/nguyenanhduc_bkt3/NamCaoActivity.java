package com.example.nguyenanhduc_bkt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class NamCaoActivity extends MainActivity {

    ListView lvtacpham;
    ArrayList<Tacpham> arrayTacPham;
    TacPhamAdapter tacPhamAdapter;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huy_can);

        back = findViewById(R.id.btnBackTacgia);
        lvtacpham = findViewById(R.id.lview);
        arrayTacPham = new ArrayList<>();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Dulieu();

        tacPhamAdapter = new TacPhamAdapter(this,R.layout.dongitem2,arrayTacPham);
        lvtacpham.setAdapter(tacPhamAdapter);

        lvtacpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(NamCaoActivity.this,Detail.class);
                String Ten = arrayTacPham.get(i).getTen();
                String Mota = arrayTacPham.get(i).getMota();
                intent.putExtra("ten",""+Ten);
                intent.putExtra("mota",""+Mota);
                startActivity(intent);
            }
        });
    }

    private void Dulieu() {
        arrayTacPham.add(new Tacpham("Tiểu thuyết Sống mòn", "Tiểu thuyết Sống mòn được sáng tác năm 1944, đây là tác phẩm tiêu biểu của nhà văn Nam Cao, đề cập đến một vấn đề nhức nhối của người tri thức trong xã hội cũ, những văn nghệ sĩ giàu khao khát, giàu lí tưởng nhưng cuộc sống vẫn cứ lụi dần, tàn dần vì cuộc sống túng bấn của mình. Nhưng kiếp “sống mòn” của giáo Thứ không chỉ là bi kịch của trí thức cách đây hơn nửa thế kỉ mà nó còn là sự day dứt của những con người không chấp nhận một cuộc đời bé mọn, vô nghĩa, phải sống “với đầy đủ giá trị của sự sống”.\n" +
                "\n" +
                "Bởi vốn dĩ họ cũng là những người nông dân hiền lành, chất phác đi theo con đường nghệ thuật chân chính nhưng do xã hội áp đặt nên họ mới rơi vào hoàn cảnh này. Đó cũng là sự day dứt của những con người hết lòng vì nghệ thuật, không chấp nhận cuộc đời nhỏ bé, phải sống đúng với giá trị của chính mình. Tiểu thuyết “Sống mòn” ban đầu có tên là “Chết mòn”, tác giả viết xong năm 1944, nhưng mãi đến năm 1956 mới được in.", R.drawable.huycan,5));
        arrayTacPham.add(new Tacpham("Truyện ngắn Đôi mắt", "Truyện ngắn Đôi mắt là truyện ngắn thành công nhất của Nam Cao sau Cách mạng Tháng 8. Trong truyện, thông qua việc xây dựng hình tượng hai nhà văn: Hoàng và Độ với hai lối sống, hai sự nhìn nhận về người nông dân, về kháng chiến trái ngược nhau, Nam Cao đã khái quát lên một vấn đề có ý nghĩa sâu sắc, không chỉ có ý nghĩa với tình hình thực tế lúc đó mà còn có ý nghĩa trong thời điểm hiện tại – vấn đề “cách nhìn cuộc sống”.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Có thể nói, trong Đôi mắt, thông qua nghệ thuật miêu tả chi tiết ngoại hình, cử chỉ, lời nói của nhân vật, Hoàng và Độ đã hiện ra khá sinh động. Hoàng với cái nhìn phiến diện, một chiều, chỉ nhìn thấy những xấu xa của người nông dân và thấy cuộc sống “chua chát”. Độ thì khác! Độ có cái nhìn đa diện, Độ nhìn ra hai mặt của vấn đề. Độ thấy được cái xấu của người nông dân nhưng anh cũng thấy cái vẻ đẹp ẩn sâu bên trong con người họ. Chính cách nhìn của Hoàng và Độ đã dẫn đến việc mỗi người tự chọn cho mình một lối sống, một chỗ đứng riêng trước thời cuộc.", R.drawable.namcao,4));
        arrayTacPham.add(new Tacpham("Truyện ngắn Chí Phèo", "Đây là truyện ngắn nổi tiếng của Nam Cao sáng tác năm 1941, là tác phẩm xuất sắc nhất viết về người nông dân trước Cách mạng. Chí Phèo là một tác phẩm xuất sắc, thể hiện nghệ thuật viết truyện độc đáo của Nam Cao, đồng thời là một tấn bi kịch của một người nông dân nghèo bị tha hóa trong xã hội. Chí Phèo cũng là tên nhân vật chính của truyện.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Toàn bộ truyện đã vẽ lên một bức tranh xã hội u ám, với những xung đột giai cấp quyết liệt, gay gắt. Hình tượng nhân vật Chí Phèo là hình tượng tiêu biểu của người nông dân Việt Nam trước Cách mạng. Đồng thời cho thấy những người nông dân lương thiện bị đẩy vào con đường bần cùng, lưu manh hóa, bị hủy hoại cả thể xác lẫn tâm hồn, bị cự tuyệt quyền làm người. Qua đó thấy được ngòi bút đầy chất nhân văn và nhân đạo của Nam Cao. Bên cạnh đó, nhà văn Nam Cao đã đề cao và khẳng định những phẩm chất tốt đẹp, cao quý của Chí Phèo – Thị Nở. Câu chuyện này đã nói lên sự xung đột vô cùng quyết liệt của các tầng lớp khác nhau trong xã hội phong kiến.", R.drawable.tohuu,3));
        arrayTacPham.add(new Tacpham("Truyện ngắn Lão Hạc", "Lão Hạc là một truyện ngắn của nhà văn Nam Cao được viết năm 1943. Tác phẩm được đánh giá là một trong những truyện ngắn tiêu biểu của dòng văn học hiện thực, nội dung truyện đã phần nào phản ánh được hiện trạng xã hội Việt Nam trong giai đoạn trước Cách mạng tháng Tám. Nhân vật chính trong truyện là Lão Hạc.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Lão Hạc là một người nông dân nghèo nhưng hiền lành, chất phác và lương thiện. Vợ lão mất sớm, lão còn có một người con trai nhưng vì quá nghèo nên không thể lấy vợ cho con. Sau này, người con gái mà con trai lão yêu thương hết mực ấy lại lấy con trai một ông phó lí, nhà có của. Hắn vì phẫn chí đã rời bỏ quê hương để đến đồn điền cao su làm ăn kiếm tiền theo công-ta. Lão có một con chó tên là Vàng – con chó do con trai lão trước khi đi đồn điền cao su đã để lại. Lão coi nó như một người thân trong gia đình. Tuy nhiên, vì gia cảnh nghèo khó lại còn trải qua một trận ốm nặng, lão đã kiệt quệ, không còn sức để nuôi nổi bản thân, huống chi là còn có thêm một con chó. Vì muốn giữ mảnh vườn cho con nên ông lão đành cắn răng bán \"cậu Vàng\" đi. Lão đã rất dằn vặt bản thân khi mang một \"tội lỗi\" là đã nỡ tâm \"lừa một con chó\".... Qua tác phẩm, người đọc hiểu được tình cảnh nghèo khổ, bế tắc của người nông dân trong xã hội thực dân nửa phong kiến.", R.drawable.macngon,2));
        arrayTacPham.add(new Tacpham("Truyện ngắn Đời thừa", "Đời thừa được xem như một đường may tinh tế trên dải lụa của nền văn học nước nhà trong những năm trước Cách mạng Tháng Tám, tác phẩm là một khúc bi ca đẫm lệ về số phận bất hạnh của người tri thức trong xã hội cũ. Tác phẩm được nhà văn sáng tác năm 1943. Truyện kể về một nhà văn nghèo tên Hộ. Qua việc kể về cuộc đời nhân vật Hộ, nhà văn đã thể hiện tấn bi kịch tinh thần của người trí thức tiểu tư sản, nguyên nhân của tấn bi kịch ấy là gánh nặng cơm áo.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Bằng giọng văn sắc sảo mà chua chát, Nam Cao đã khắc họa thành công hình ảnh nhân vật Hộ dù bị nghèo đói dồn ép đến cùng đường nhưng không bao giờ đánh mất đi lương tri và lý tưởng của mình. Hộ đồng thời rơi vào hai tấn bi kịch đó là bi kịch của người nghệ sĩ phải đang tâm chà đạp lên nguyên tắc sáng tạo của nghệ thuật chân chính, bi kịch của người cha người chồng phải chà đạp lên nguyên tắc tình thương do chính mình đề ra. Qua bi kịch của nhân vật Hộ, Nam Cao thể hiện một tư tưởng nhân văn đẹp đẽ: tố cáo hiện thực, lên án sự tha hoá, cảm thông với những con người bất hạnh và khẳng định những những quan điểm nghệ thuật chân chính.", R.drawable.hermingway,3));
    }
}