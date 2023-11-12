
public class NhanVienChinhThuc extends NhanVien{
	//Các thuộc tính mới
	private int soNgay;
	private int luongCanBanTheoNgay;
	
	//Các hàm get và set mới
		//*** Các hàm get ***
	public int getSoNgay() {
		return soNgay;
	}
	public int getluongCanBanTheoNgay() {
		return luongCanBanTheoNgay;
	}
	
		//*** Các hàm set ***
	public void setSoNgay(int newSoNgay) {
		soNgay = newSoNgay;
		tinhLuong();
	}
	public void setluongCanBanTheoNgay(int newluongCanBanTheoNgay) {
		luongCanBanTheoNgay = newluongCanBanTheoNgay;
		tinhLuong();
	}
	
	//Các hàm điều kiện
	private boolean soNgayKhongHopLe(int newSoNgay) {
		if(newSoNgay < 0) return true;
		return false;
	}
	private boolean luongCanBanTheoNgayKhongHopLe(int newluongCanBanTheoNgay) {
		if(newluongCanBanTheoNgay < 0) return true;
		return false;
	}
	
	//Các constructor
		//*** Constructor không tham số ***
	public NhanVienChinhThuc() {
		super();
		soNgay = 0;
		luongCanBanTheoNgay = 0;
	}
	
		//*** Constructor có tham số ***
	public NhanVienChinhThuc(String newHo, String newTen, String newNgaySinh, String newGioiTinh, String newId, String newMaPhongBan, int newSoNgay, int newluongCanBanTheoNgay) {
		super(newHo, newTen, newNgaySinh, newGioiTinh, newId, newMaPhongBan);
		soNgay = newSoNgay;
		if(soNgayKhongHopLe(soNgay)) soNgay = 0;
		luongCanBanTheoNgay = newluongCanBanTheoNgay;
		if(luongCanBanTheoNgayKhongHopLe(luongCanBanTheoNgay)) luongCanBanTheoNgay = 0;
	}
	
	//Hàm tính lương
	@Override public void tinhLuong() {
		setluongCanBanTheoNgay(soNgay * luongCanBanTheoNgay);
	}
	
	//Các hàm nhập và xuất
			//*** Hàm nhập ***
		
				//***** Các hàm nhập thành phần mới *****
	public void nhapSoNgay() {
		int newSoNgay;
		do {
			System.out.print("Nhap so ngay lam: ");
			newSoNgay = Integer.parseInt(scan.nextLine());
		} while(soNgayKhongHopLe(newSoNgay));
		soNgay = newSoNgay;
	}
	public void nhapluongCanBanTheoNgay() {
		int newluongCanBanTheoNgay;
		do {
			System.out.print("Nhap muc luong theo ngay: ");
			newluongCanBanTheoNgay = Integer.parseInt(scan.nextLine());
		} while(luongCanBanTheoNgayKhongHopLe(luongCanBanTheoNgay));
		luongCanBanTheoNgay = newluongCanBanTheoNgay;
	}
	
				//***** Hàm nhập tổng hợp *****
	@Override public void nhap() {
		super.nhap();
		nhapSoNgay();
		nhapluongCanBanTheoNgay();
		tinhLuong();
	}
			//*** Hàm xuất ***
	
				//***** Các hàm xuất thành phần mới *****
	public void xuatSoNgay() {
		System.out.println("So ngay lam: "+soNgay);
	}
	public void xuatluongCanBanTheoNgay() {
		System.out.println("Muc luong theo ngay: "+luongCanBanTheoNgay);
	}
	
				//*** Hàm xuất tổng hợp ***
	@Override public void xuat() {
		super.xuat();
		xuatSoNgay();
		xuatluongCanBanTheoNgay();
	}
}
