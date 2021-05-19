# QuanLyCuaHangSach
	X Y DỰNG ỨNG DỤNG QUẢN LÝ CỬA HÀNG SÁCH

THÀNH VIÊN:
1.NGUYỄN ĐỨC MINH TRUNG _  MSSV:3119410467
2.TRẦN THANH TÙNG _  MSSV:3119410479
3.PHẠM TRẦN KHÔI _  MSSV:3119410198
4.NGUYỄN TRẦN VĂN VŨ _  MSSV:3119410494

THƯ VIỆN :
Tất cả thư viện đều nằm trong thư mục libs



CẤU TRÚC GIAO DIỆN ĐỒ ÁN

Khi bắt đầu ta sẽ đăng nhập vào hệ thống





User: admin
Password:admin




















Sau khi đăng nhập thành công ta sẽ vào giao diện chính

Cấu trúc với một thanh tiêu đề ở trên cùng với các thông tin cơ bản về hệ thống.
Bên trái là menu Chức năng với các ô chức năng xếp liền nhau từ trên xuống.
Khi ta muốn chuyển sang chức năng khác ta sẽ click vào ô tên Chức năng đó
 





1.FORM QUÀN LÝ SÁCH

Gồm các thành phần sau:




Đây là nơi để nhập dữ  liệu vào .










Nút Thêm có chức năng thêm một sản phẩm Sách vào Database. 
Nút Sửa có chức năng sửa thông một cuốn sách nào đó. Dữ liệu được nạp lên các ô khi click chọn vào từng dòng trong table. 
Nút Xóa có chức năng Xóa một cuốn sách khỏi database , ở đây là vô hiệu hóa một cuốn sách.
Nút HIển Thị Tất Cả giúp chúng ta có thể xem lại được toàn bộ nội dung của bảng Sách.
Hiển Thi Ảnh sản phẩm
Đây là 2 nút Xuất dữ liệu trong Bảng Sách ra thành một file Excel và Có thể nhập dự liệu nhanh chóng bằng 1 file excel có cấu trúc giống với Bảng Sách


Đây là nơi chúng ta có thể tìm kiếm các sản phẩm theo nhiều tiêu chí khác nhau . Chỉ cần nhập dữ liệu vào và ấn Tìm . Các dữ liệu phù hợp sẽ xuất hiện trên Bảng Sách

Cuối cùng, đầy là Bảng Thông Tin Sách , chứa toàn bộ thông tin về các cuốn sách khác nhau.

2.FORM NHẬP HÀNG

Chúng ta sẽ có thông tin về Phiếu Nhập và Chi Tiết Phiếu Nhập ứng với từng Phiếu Nhập



Đây là nơi ta nhập, sửa dữ liệu của phiếu nhập












nút Thêm Phiếu Nhập mới vào database
nút sửa thông tin Phiếu Nhập
nút Xóa Thông Tin Phiếu Nhập
Nút hiện thi tất cả thông tin trong bảng Phiếu Nhập
nút in dữ liệu của một phiếu mật khi click vào 1 dòng trong bảng Phiếu Nhập, file xuất ra là bill**.pdf

Đây bảng thông tin của tất cả các Phiếu Nhập

Đây là khung tìm kiếm nâng cao, nơi chúng ta có thể tìm kiếm các sản phẩm theo nhiều tiêu chí khác nhau . Chỉ cần nhập dữ liệu vào và ấn Tìm . Các dữ liệu phù hợp sẽ xuất hiện trên bảng Phiếu Nhập


Đây là khu vực làm việc với Chi Tiết Phiếu Nhập

Khung nhập dữ liệu và hiển thị dữ liệu khi click vào ô tương ứng trong bảng Chi tiết Phiếu Nhập






Các nút thêm xóa sửa .




Khi thêm 1 chi tiết phiếu nhập thì ta sẽ tăng số lượng sách trong bảng Sách tương ứng với lượng nhập về
Khi Sửa chi tiết phiếu nhập nếu có sửa số lượng thì ta sẽ cập nhật là số lượng trong bảng Sách tương ứng
Khi xóa thì chi tiết phiếu nhập tương ứng sẽ mất
Nút Tất Cả hiển thị toàn bộ dữ liệu trên Bảng Chi Tiết Phiếu Nhập

Khi click vào ô Phiếu Nhập tương ứng thì trên bảng Chi Tiết Phiếu Nhập sẽ hiển thị các chi tiết phiếu nhập của Phiếu Nhập đó.

Đây là khung tìm kiếm hoạt động tương tự trên Phiếu Nhập



3.Form Quản lý nhân viên






-Chức năng thêm nhân viên: nhập đầy đủ dữ liệu rồi nhấn nút thêm.

-Chức năng xóa nhân viên: chọn nhân viên muốn xóa rồi ấn nút xóa.

-Chức năng sửa nhân viên: nhập đầy đủ dữ liệu muốn sửa(trường nào không sửa thì giữ nguyên) rồi ấn nút sửa.

-Chức năng tìm kiếm nhân viên: chọn tìm kiếm theo thuộc tính nào trong combobox rồi nhập dữ liệu tìm kiếm.

-Chức năng import file excel(xlsx): chọn file excel rồi loadDataBase (chỉ import nhân viên không bị trùng MaNV).

--Chức năng export file excel(xlsx): chọn đường dẫn lưu file rồi export (chỉ cần đặt tên file không cần thêm .xlsx).





4.Form Quản lý tài khoản






-Chức năng thêm tài khoản: nhập đầy đủ dữ liệu rồi nhấn nút thêm.

-Chức năng xóa tài khoản: chọn tài khoản muốn xóa rồi ấn nút xóa.

-Chức năng sửa tài khoản: nhập đầy đủ dữ liệu muốn sửa(trường nào không sửa thì giữ nguyên) rồi ấn nút sửa.


5.Form nhà xuất bản



-Chức năng thêm nhà xuất bản: nhập đầy đủ dữ liệu rồi nhấn nút thêm.

-Chức năng xóa nhà xuất bản: chọn nhà xuất bản muốn xóa rồi ấn nút xóa.

-Chức năng sửa nhà xuất bản: nhập đầy đủ dữ liệu muốn sửa(trường nào không sửa thì giữ nguyên) rồi ấn nút sửa.

Form nhà cung cấp

-Chức năng thêm nhà cung cấp: nhập đầy đủ dữ liệu rồi nhấn nút thêm.

-Chức năng xóa nhà cung cấp: chọn nhà cung cấp muốn xóa rồi ấn nút xóa.

-Chức năng sửa nhà cung cấp: nhập đầy đủ dữ liệu muốn sửa(trường nào không sửa thì giữ nguyên) rồi ấn nút sửa.

6.Form nhà cung cấp
 
-Chức năng thêm nhà cung cấp: nhập đầy đủ dữ liệu rồi nhấn nút thêm.
 
-Chức năng xóa nhà cung cấp: chọn nhà cung cấp muốn xóa rồi ấn nút xóa.
 
-Chức năng sửa nhà cung cấp: nhập đầy đủ dữ liệu muốn sửa(trường nào không sửa thì giữ nguyên) rồi ấn nút sửa.
 7. Form bán hàng.
 

-     Sau khi đã nhập Mã Nhân Viên và Mã Khách Hàng, Mã Giảm Giá có thể có hoặc không, sau đó bấm TẠO HÓA ĐƠN để bắt đầu nhập hóa đơn vào.
-     Kế bên các textfield của Mã NV, Mã KH và Mã GG có các nút  sẽ hiện lên các danh sách dữ liệu phòng khi chúng ta không nhớ được những thông tin đó và giúp chúng ta tìm kiếm thuận tiện hơn,
  

-       Chọn sản phẩm ở khung bên trái, sau đó nhập số lượng và sau đó bấm nút Thêm .
-       Sản phẩm được thêm sẽ được nhập vào bảng bên phải. Tổng tiền, giảm giá và thành tiền sẽ tự động được cập nhật. Có thể sửa hoặc xóa sản phẩm đã chọn bằng cách nhấp vào sản phẩm muốn sửa hoặc xóa và ấn nút tương đương bên dướ i . Muốn hủy lại hóa đơn đã tạo thì chọn .
-      Sau khi hoàn tất quá trình nhập , bấm  để hoàn tất bán hàng và lập ra hóa đơn.
 
 
 
 
 
 
 
 
8.Form quản lý hóa đơn.

-   Nửa trên là quản lý tất cả hóa đơn và nửa dưới là quản lý chi tiết hóa đơn, cần xem chi tiết hóa đơn của hóa đơn nào chỉ cần chọn hóa đơn mình muốn xem thì chi tiết hóa đơn sẽ lọc ra theo mã hóa đơn đó.
-   Muốn xóa hoặc sửa hóa đơn nào thì chỉ cần chọn hóa đơn muốn sửa và chọn các nút tương ứng kế bên .
-       Nút Xuất sẽ xuất hóa đơn cùng với chi tiết của hóa đơn đó ra 1 file pdf.
 
-  Khung tìm kiếm nâng cao giúp lọc và chỉ hiện ra các hóa đơn phù hợp với điều kiện tìm kiếm.
-     Số lượng hóa đơn và tổng tiền các hóa đơn sẽ tự động được cập nhật.
-    Dưới phần chi tiết hóa đơn cũng có chức năng sửa xóa, chỉ cần chọn chi tiết hóa đơn muốn sửa hoặc xóa rồi bấm các nút tương ứng thì chi tiết sẽ được sửa và tự động cập nhật lên trên hóa đơn hiện tại.

9.  Form khách hàng




Có giao diện gồm 4 phần chính:

- Các nút chức năng như thêm, sửa, xóa, các nút chức năng phụ nhập bằng file .xls và xuất pdf để hỗ trợ in ấn
- Khung hiển thị thông tin khách hàng
- Khung tìm kiếm theo thuộc tính, kết quả thuộc tính sẽ được hiện thị trên bảng chính của form
- Các Text Field nhập dữ liệu, đồng thời hiển thị thông tin của dòng đang được chọn

10. Form chương trình giảm giá




- Form Giảm giá được chia làm hai phần gồm:

+ Chương trình giảm giá:
→ Các nút chức năng thêm, xóa, sửa
→ Các Text Field nhập dữ liệu, đồng thời hiển thị thông tin của dòng đang được chọn
→ Khung hiện thị các chương trình đã được lưu lại
→ Tìm kiếm các chương trình giảm giá trong một khoảng thời gian nhất định

+ Chi tiết chương trình giảm giá:
→ Các nút chương năng
→ Text Field hiển thị tên sách đã được chọn để giảm giá
→ Khung hiển thị tên sách đã được chọn
→ Nút hiển thị menu tìm kiếm


Tìm kiếm sẽ dựa theo ngày bắt đầu và ngày kết thúc, kết quả sẽ được hiển thị trên table chính của chương trình giảm giá

