package com.example.nguyenanhduc_bkt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MacNgonActivity extends MainActivity {
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
                Intent intent = new Intent(MacNgonActivity.this,Detail.class);
                String Ten = arrayTacPham.get(i).getTen();
                String Mota = arrayTacPham.get(i).getMota();
                intent.putExtra("ten",""+Ten);
                intent.putExtra("mota",""+Mota);
                startActivity(intent);
            }
        });
    }

    private void Dulieu() {
        arrayTacPham.add(new Tacpham("Đoàn Thuyền Đánh Cá", "Mặt trời xuống biển như hòn lửa\n" +
                "Sóng đã cài then, đêm sập cửa.\n" +
                "Đoàn thuyền đánh cá lại ra khơi,\n" +
                "Câu hát căng buồm cùng gió khơi.\n" +
                "Hát rằng: cá bạc biển Đông lặng,\n" +
                "Cá thu biển Đông như đoàn thoi\n" +
                "Đêm ngày dệt biển muôn luồng sáng.\n" +
                "Đến dệt lưới ta, đoàn cá ơi!\n" +
                "Thuyền ta lái gió với buồm trăng\n" +
                "Lướt giữa mây cao với biển bằng,\n" +
                "Ra đậu dặm xa dò bụng biển,\n" +
                "Dàn đan thế trận lưới vây giăng.\n" +
                "Cá nhụ cá chim cùng cá đé,\n" +
                "Cá song lấp lánh đuốc đen hồng,\n" +
                "Cái đuôi em quẫy trăng vàng choé,\n" +
                "Đêm thở: sao lùa nước Hạ Long.\n" +
                "Ta hát bài ca gọi cá vào,\n" +
                "Gõ thuyền đã có nhịp trăng cao,\n" +
                "Biển cho ta cá như lòng mẹ,\n" +
                "Nuôi lớn đời ta tự buổi nào.\n" +
                "Sao mờ, kéo lưới kịp trời sáng,\n" +
                "Ta kéo xoăn tay chùm cá nặng,\n" +
                "Vảy bạc đuôi vàng loé rạng đông,\n" +
                "Lưới xếp buồm lên đón nắng hồng.\n" +
                "Câu hát căng buồm với gió khơi,\n" +
                "Đoàn thuyền chạy đua cùng mặt trời.\n" +
                "Mặt trời đội biển nhô màu mới\n" +
                "Mắt cá huy hoàng muôn dặm phơi.)", R.drawable.huycan,5));
        arrayTacPham.add(new Tacpham("Tràng Giang", "Sóng gợn tràng giang buồn điệp điệp,\n" +
                "Con thuyền xuôi mái nước song song.\n" +
                "Thuyền về nước lại, sầu trăm ngả;\n" +
                "Củi một cành khô lạc mấy dòng.\n" +
                "Lơ thơ cồn nhỏ gió đìu hiu,\n" +
                "Đâu tiếng làng xa vãn chợ chiều\n" +
                "Nắng xuống, trời lên sâu chót vót;\n" +
                "Sông dài, trời rộng, bến cô liêu.\n" +
                "Bèo giạt về đâu, hàng nối hàng;\n" +
                "Mênh mông không một chuyến đò ngang.\n" +
                "Không cầu gợi chút niềm thân mật,\n" +
                "Lặng lẽ bờ xanh tiếp bãi vàng.\n" +
                "Lớp lớp mây cao đùn núi bạc,\n" +
                "Chim nghiêng cánh nhỏ: bóng chiều sa.\n" +
                "Lòng quê dợn dợn vời con nước,\n" +
                "Không khói hoàng hôn cũng nhớ nhà.", R.drawable.namcao,4));
        arrayTacPham.add(new Tacpham("Ngậm Ngùi", "Nắng chia nửa bãi, chiều rồi…\n" +
                "Vườn hoang trinh nữ xếp đôi lá rầu.\n" +
                "Sợi buồn con nhện giăng mau,\n" +
                "Em ơi! Hãy ngủ… anh hầu quạt đây.\n" +
                "Lòng anh mở với quạt này,\n" +
                "Trăm con chim mộng về bay đầu giường.\n" +
                "Ngủ đi em, mộng bình thường!\n" +
                "Ru em sẵn tiếng thuỳ dương mấy bờ…\n" +
                "Cây dài bóng xế ngẩn ngơ…\n" +
                "– Hồn em đã chín mấy mùa thương đau?\n" +
                "Tay anh em hãy tựa đầu,\n" +
                "Cho anh nghe nặng trái sầu rụng rơi…", R.drawable.tohuu,3));
        arrayTacPham.add(new Tacpham("Áo Trắng", "Áo trắng đơn sơ, mộng trắng trong,\n" +
                "Hôm xưa em đến, mắt như lòng\n" +
                "Nở bừng ánh sáng. Em đi đến,\n" +
                "Gót ngọc dồn hương, bước toả hồng.\n" +
                "Em đẹp bàn tay ngón ngón thon;\n" +
                "Em duyên đôi má nắng hoe tròn.\n" +
                "Em lùa gió biếc vào trong tóc\n" +
                "Thổi lại phòng anh cả núi non.\n" +
                "Em nói, anh nghe tiếng lẫn lời;\n" +
                "Hồn em anh thở ở trong hơi.\n" +
                "Nắng thơ dệt sáng trên tà áo,\n" +
                "Lá nhỏ mừng vui phất cửa ngoài.\n" +
                "Đôi lứa thần tiên suốt một ngày.\n" +
                "Em ban hạnh phúc chứa đầy tay.\n" +
                "Dịu dàng áo trắng trong như suối\n" +
                "Toả phất đôi hồn cánh mộng bay.", R.drawable.macngon,2));
        arrayTacPham.add(new Tacpham("Trăng Sao Cũng Hoa Xứ Người", "Anh em ơi! Ta tới trăng rồi!\n" +
                "Trăng sao cũng hoá xứ người từ đây.\n" +
                "Trạm đầu vũ trụ xinh thay\n" +
                "Nửa quen nửa lạ đặt ngay cờ hồng.\n" +
                "Mẹ ơi! Mua cốm, mua hồng\n" +
                "Mua con cá chép lượn vòng con chơi.\n" +
                "Trăng cao, trăng đẹp, trăng ngời\n" +
                "Mua tàu vũ trụ con ngồi lên trăng.", R.drawable.hermingway,3));
    }
}