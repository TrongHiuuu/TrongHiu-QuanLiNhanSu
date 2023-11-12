
public class NhanVienThoiVu extends NhanVien {
	//Các thuộc tính mới
	private int soGio;
	private int luongCanBanTheoGio;
	
	//Các hàm get và set mới
		//*** Các hàm get ***
	public int getSoGio() {
		return soGio;
	}
	public long getluongCanBanTheoGio() {
		return luongCanBanTheoGio;
	}
	
		//*** Các hàm set ***
	public void setSoGio(int newSoGio) {
		soGio = newSoGio;
		tinhLuong();
	}
	public void setluongCanBanTheoGio(int newluongCanBanTheoGio) {
		luongCanBanTheoGio = newluongCanBanTheoGio;
		tinhLuong();
	}
	
	//Các hàm điều kiện
	private boolean soGioKhongHopLe(int newSoGio) {
		if(newSoGio < 0) return true;
		return false;
	}
	private boolean luongCanBanTheoGioKhongHopLe(int newluongCanBanTheoGio) {
		if(newluongCanBanTheoGio < 0) return true;
		return false;
	}
	
	//Các constructor
		//*** Constructor không tham số ***
	public NhanVienThoiVu() {
		super();
		soGio = 0;
		luongCanBanTheoGio = 0;
	}
	
		//*** Constructor có tham số ***
	public NhanVienThoiVu(String newHo, String newTen, String newNgaySinh, String newGioiTinh, 
			String newId, String newMaPhongBan, int newSoGio, int newluongCanBanTheoGio) {
		super(newHo, newTen, newNgaySinh, newGioiTinh, newId, newMaPhongBan);
		soGio = newSoGio;
		if(soGioKhongHopLe(soGio)) soGio = 0;
		luongCanBanTheoGio = newluongCanBanTheoGio;
		if(luongCanBanTheoGioKhongHopLe(luongCanBanTheoGio)) luongCanBanTheoGio = 0;
	}
	//Hàm tính lương
	@Override public void tinhLuong() {
		setluongCanBanTheoGio(soGio * luongCanBanTheoGio);
	}
	//Các hàm nhập và xuất
		//*** Hàm nhập ***
	
			//***** Các hàm nhập thành phần mới *****
	public void nhapSoGio() {
		int newSoGio;
		do {
			System.out.print("Nhap so gio lam: ");
			newSoGio = Integer.parseInt(scan.nextLine());
		} while(soGioKhongHopLe(newSoGio));
		soGio = newSoGio;
	}
	public void nhapluongCanBanTheoGio() {
		int newluongCanBanTheoGio;
		do {
			System.out.print("Nhap muc luong theo gio: ");
			newluongCanBanTheoGio = Integer.parseInt(scan.nextLine());
		} while(luongCanBanTheoGioKhongHopLe(newluongCanBanTheoGio));
		luongCanBanTheoGio = newluongCanBanTheoGio;
	}
	
			//***** Hàm nhập tổng hợp *****
	@Override public void nhap() {
		super.nhap();
		nhapSoGio();
		nhapluongCanBanTheoGio();
		tinhLuong();
	}
	
		//*** Hàm xuất ***
	
			//***** Các hàm xuất thành phần mới *****
	private void xuatSoGio() {
		System.out.println("So gio lam: "+soGio);
	}
	private void xuatluongCanBanTheoGio() {
		System.out.println("Muc luong theo gio: "+luongCanBanTheoGio);
	}
	
			//*** Hàm xuất tổng hợp ***
	@Override public void xuat() {
		super.xuat();
		xuatSoGio();
		xuatluongCanBanTheoGio();
	}
}
