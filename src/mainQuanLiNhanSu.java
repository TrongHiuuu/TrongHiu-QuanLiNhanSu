
public class MainQuanLiNhanSu {

	public static void main(String[] args) {
		DanhSachPhongBan dspb = new DanhSachPhongBan();
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        DanhSachBangLuong dsbl = new DanhSachBangLuong();
        DanhSachDuAn dsda = new DanhSachDuAn();
        dspb.docFile();
        dsbl.docFile();
        dsnv.docFile();
        dsda.docFile();
        dsnv.sua(dspb,dsbl,dsda);
        dspb.xuat();
        dsbl.xuat();
        dsnv.xuat();
        dsda.xuat();
        dspb.ghiFile();
        dsbl.ghiFile();
        dsnv.ghiFile();
        dsda.ghiFile();
	}

}
