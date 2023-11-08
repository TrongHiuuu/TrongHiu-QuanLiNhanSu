import java.util.Scanner; 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class NhanVien {
	public Scanner scan = new Scanner(System.in);
	
	//Các thuộc tính
	private String ho, ten;
	private LocalDate ngaySinh;
	private String gioiTinh; 
	private String maSo;
	private String maPhongBan;
	private long mucLuong;
	
	//Các hàm get và set của class
		//*** Các hàm get ***
	public String getHo() {
		return ho;
	}
	public String getTen() {
		return ten;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public String getMaSo() {
		return maSo;
	}
	public String getMaPhongBan() {
		return maPhongBan;
	}
	public long getMucLuong() {
		return mucLuong;
	}
	
		//*** Các hàm set ***
	public void setHo(String newHo) {
		ho = newHo;
	}
	public void setTen(String newTen) {
		ten = newTen;
	}
	public void setHoTen(String newHoTen) {
		newHoTen = newHoTen.trim();
		String[] temp = newHoTen.split(" ");
		ten = temp[temp.length-1];
		for(int i=0;i<temp.length - 1;i++) {
			ho = ho + temp[i] + " ";
		}
		ho = ho.trim();
	}
	public void setNgaySinh(String newNgaySinh) {
		if(newNgaySinh.contains("-")) {
			ngaySinh = LocalDate.parse(newNgaySinh);
		}
		else {
			ngaySinh = LocalDate.parse(newNgaySinh, DateTimeFormatter.BASIC_ISO_DATE);
		}
	}
	public void setGioiTinh(String newGioiTinh) {
		gioiTinh = newGioiTinh;
	}
	public void setMaSo(String newMaSo) {
		maSo = newMaSo;
	}
	public void setMaPhongBan(String newMaPhongBan) {
		maPhongBan = newMaPhongBan;
	}
	public void setMucLuong(long newmucLuong) {
		mucLuong = newmucLuong;
	}
	
	//Các hàm kiểm tra điều kiện
	
		//*** Kiểm tra điều kiện của ngày sinh ***
	private boolean ngaySinhKhongHopLe(String newNgaySinh) {
		try {
			if (newNgaySinh.contains("-")) {
				LocalDate newDate = LocalDate.parse(newNgaySinh);
			} else {
				LocalDate newDate = LocalDate.parse(newNgaySinh, DateTimeFormatter.BASIC_ISO_DATE);
			}
		}
		catch(DateTimeParseException e) { return true; }
		return false;
	}
		//*** Kiểm tra điều kiện của giới tính ***
	private boolean gioiTinhKhongHopLe(String newGioiTinh) {
		String gioiTinhDuocKiemTra = newGioiTinh.toLowerCase().intern();
		if(gioiTinhDuocKiemTra == NhanVien_CONST.GIOITINH_NAM) return false;
		if(gioiTinhDuocKiemTra == NhanVien_CONST.GIOITINH_NU) return false;
		return true;
	}
	
		//*** Kiểm tra điều kiện của maSo ***
	private boolean maSoKhongHopLe(String newMaSo) {
		if(newMaSo.length() != NhanVien_CONST.NUMBEROFCHAR_MASO) return true;
		return false;
	}
	
		//*** Kiểm tra điều kiện của maPhongBan ***
	private boolean maPhongBanKhongHopLe(String newMaPhongBan) {
		if(newMaPhongBan.length() != NhanVien_CONST.NUMBEROFCHAR_MAPHONGBAN) return true;
		return false;
	}
	
	
	//Các constructor của class
	
		//*** Constructor không tham số ***
	public NhanVien() {
		ho = "";
		ten = "";
		ngaySinh = LocalDate.parse("0000-00-00");
		gioiTinh = "";
		maSo = "";
		maPhongBan = "";
	}
	
		//*** Constructor có tham số ***
	public NhanVien(String newHo, String newTen, String newNgaySinh, String newGioiTinh, String newMaSo, 
			String newMaPhongBan) {
		ho = newHo;
		ten = newTen;
		setNgaySinh(newNgaySinh);
		gioiTinh = newGioiTinh.toLowerCase();
		if(gioiTinhKhongHopLe(gioiTinh)) gioiTinh = "";
		maSo = newMaSo;
		maPhongBan = newMaPhongBan;
		if(maSoKhongHopLe(maSo)) maSo = "";
		if(maPhongBanKhongHopLe(maPhongBan)) maPhongBan = "";
	}
	
	//Các hàm trừu tượng
	abstract public void tinhLuong();
	
	//Các hàm nhập xuất của class
	
		//*** Hàm nhập
	
			//***** Các hàm nhập thành phần *****
	public void nhapHoTen() {
		String newHoTen;
		System.out.print("Nhap ho va ten: ");
		newHoTen = scan.nextLine();
		setHoTen(newHoTen);
	}
	public void nhapNgaySinh() {
		String newNgaySinh;
		System.out.print("Nhap ngay sinh (YYYY-MM-DD): ");
		newNgaySinh = scan.nextLine();
		do {
			System.out.print("Ngay sinh khong hop le, vui long nhap lai!!!");
			System.out.print("Nhap ngay sinh (YYYY-MM-DD): ");
			newNgaySinh = scan.nextLine();
		} while(ngaySinhKhongHopLe(newNgaySinh));
		setNgaySinh(newNgaySinh);
	}
	public void nhapGioiTinh() {
		String newGioiTinh;
		System.out.print("Gioi tinh (Nam hay nu?): ");
		newGioiTinh = (scan.nextLine()).toLowerCase().intern();
		while(gioiTinhKhongHopLe(newGioiTinh)) {
			System.out.print("Gioi tinh khong hop le, vui long nhap lai!!!");
			System.out.print("Gioi tinh (Nam hay nu?): ");
			newGioiTinh = (scan.nextLine()).toLowerCase().intern();
		}
		gioiTinh = newGioiTinh;
	}
	public void nhapMaSo() {
		String newMaSo;
		System.out.print("Nhap ma so (8 ki tu): ");
		newMaSo = scan.nextLine();
		while(maSoKhongHopLe(newMaSo)) {
			System.out.print("Ma so khong hop le, vui long nhap lai!!!");
			System.out.print("Nhap ma so (8 ki tu): ");
			newMaSo = scan.nextLine();
		}
		maSo = newMaSo;
	}
	public void nhapMaPhongBan() {
		String newMaPhongBan;
		System.out.print("Nhap ma phong ban (5 ki tu): ");
		newMaPhongBan = scan.nextLine();
		while(maPhongBanKhongHopLe(newMaPhongBan)) {
			System.out.print("Ma phong ban khong hop le, vui long nhap lai!!!");
			System.out.print("Nhap ma phong ban (5 ki tu): ");
			newMaPhongBan = scan.nextLine();
		}
		maPhongBan = newMaPhongBan;
	}
	
			//***** Hàm nhập tổng hợp *****
	public void nhap() {
		nhapHoTen();
		nhapNgaySinh();
		nhapGioiTinh();
		nhapMaSo();
		nhapMaPhongBan();
	}
	
		//*** Hàm xuất
	
			//***** Các hàm xuất thành phần *****
	private void xuatHoTen() {
		System.out.println("Ho va ten: "+ho+" "+ten);
	}
	private void xuatNgaySinh() {
		System.out.println("Ngay thang nam sinh: "+ngaySinh);
	}
	private void xuatGioiTinh() {
		System.out.println("Gioi tinh: "+gioiTinh);
	}
	private void xuatMaSo() {
		System.out.println("Ma so: "+maSo);
	}
	private void xuatMaPhongBan() {
		System.out.println("Ma phong ban: "+maPhongBan);
	}
	private void xuatMucLuong() {
		System.out.println("Muc Luong: "+mucLuong);
	}
	
			//***** Hàm xuất tổng hợp *****
	public void xuat() {
		xuatHoTen();
		xuatNgaySinh();
		xuatGioiTinh();
		xuatMaSo();
		xuatMaPhongBan();
		xuatMucLuong();
	}
}
