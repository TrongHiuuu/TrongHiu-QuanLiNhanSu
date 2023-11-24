import java.io.File;

public class mainQuanLiNhanSu {
	public static void main(String[] args) {
		File inputFile = new File("C:/Users/ACER/eclipse-workspace/InputFile.txt");
		File outputFile = new File("C:/Users/ACER/eclipse-workspace/OutputFile.txt");
		DanhSachNhanVien ds = new DanhSachNhanVien();
		ds.docFile(inputFile);
		ds.xuat();
		ds.ghiFile(outputFile);
	}
}
