/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRO1041.FORM;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import PRO1041.DAO.KhachHangDAO;
/**
 *
 * @author phamt
 */
public class DatVe extends javax.swing.JFrame {
    private String header[]={"Mã Vé","Tên Khách Hàng","Mã Khách Hàng","Số Điện Thoại","Giờ Khởi Hành","Giá","Mã Chuyến"};
    private String header1[]={"Mã Khách Hàng","Tên Khách Hàng","Số Điện Thoại","Ngày Đi","Điểm Đón","Điểm Đến","Thanh Toán"};
    private DefaultTableModel tblDatVeModel = new DefaultTableModel(header,0);
    private DefaultTableModel tblKhachHangModel = new DefaultTableModel(header1,0);
    private ArrayList<KhachHangDAO> list = new ArrayList<KhachHangDAO>();
    private int curredIndex=-1;
      
    String DB_url="jdbc:sqlserver://localhost:1433;databaseName=QL_NhaXe;user=sa;password=123";
    /**
     * Creates new form DatVe
     */
    public DatVe() {
        initComponents();
        loadDataToTableDV();
        loadDataToTableKH();
        LoadData();
        cbb_gia.disable();
    }
    
     public void loadDataToTableDV(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = DriverManager.getConnection(DB_url);
            String sql = " select MaVe, TenKH,MaKH, SDT, GioKhoiHanh, Gia, MaChuyen from DatVe \n" +
                         " inner join KhachHang \n" +
                         " on KhachHang.MaKH=DatVe.MaKhachHang";
            st  = conn.createStatement();
            rs=st.executeQuery(sql);
            Vector sv = null;
            tblDatVeModel.setRowCount(0);           
                while(rs.next()){
                   sv = new Vector();
                   sv.add(rs.getInt("MaVe"));
                   sv.add(rs.getString("TenKH"));
                   sv.add(rs.getString("MaKH"));
                   sv.add(rs.getString("SDT"));
                   sv.add(rs.getString("GioKhoiHanh"));
                   sv.add(rs.getString("Gia"));  
                   sv.add(rs.getString("MaChuyen"));              
                
                   tblDatVeModel.addRow(sv);
                }
                tbl_datve.setModel(tblDatVeModel);
                conn.close();
                st.close();
                rs.close();


        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
     public void loadDataToTableKH(){
        Connection conn1 = null;
        Statement st1 = null;
        ResultSet rs1 = null;
        try{
            conn1 = DriverManager.getConnection(DB_url);
            String sql = "select * from KhachHang";
            st1  = conn1.createStatement();
            rs1=st1.executeQuery(sql);
            Vector sv = null;
            tblKhachHangModel.setRowCount(0);           
                while(rs1.next()){
                   sv = new Vector();
                   sv.add(rs1.getInt("MaKH"));
                   sv.add(rs1.getString("TenKH"));                 
                   sv.add(rs1.getString("SDT"));
                   sv.add(rs1.getString("NgayDi"));
                   sv.add(rs1.getString("DiemDon"));  
                   sv.add(rs1.getString("DiemDen"));  
                   sv.add(rs1.getString("ThanhToan"));
                
                   tblKhachHangModel.addRow(sv);
                }
                tbl_khachhang.setModel(tblKhachHangModel);
                conn1.close();
                st1.close();
                rs1.close();


        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
      public void LoadData(){
         Connection conn = null;
         Statement stm = null;
        try {                      
            conn = DriverManager.getConnection(DB_url);
            stm = conn.createStatement();
            String sql = "";
            sql = "select  * from KhachHang";
            ResultSet rs = stm.executeQuery(sql);
            list.clear();
            
            while(rs.next()){
            String MaKH = rs.getString("MaKH");         
            String TenKH = rs.getString("TenKH");
            String SDT = rs.getString("SDT");
            String NgayDi = rs.getString("NgayDi");
            String DiemDon = rs.getString("DiemDon");
            String DiemDen = rs.getString("DiemDen");
            String ThanhToan = rs.getString("ThanhToan");
            
            
            KhachHangDAO khd = new KhachHangDAO(MaKH, TenKH, SDT, NgayDi, DiemDon, DiemDen, ThanhToan);
            list.add(khd);
          }
            curredIndex=0;
            DislayNV();
            
            rs.close();
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
      
         public void DislayNV(){
        KhachHangDAO nvs = list.get(curredIndex);
        txt_ma.setText(nvs.MaKH);
        txt_ten.setText(nvs.TenKH);
        txt_sdt.setText(nvs.SDT);     
        cbb_thanhtoan.setSelectedItem(nvs.ThanhToan);
        txt_diemdon.setText(nvs.DiemDon);
        txt_diemden.setText(nvs.DiemDen);
        txt_ngaydi.setText(nvs.NgayDi);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbb_gio = new javax.swing.JComboBox<>();
        cbb_gia = new javax.swing.JComboBox<>();
        cbb_tuyen = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_diemdon = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_diemden = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_ngaydi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        cbb_thanhtoan = new javax.swing.JComboBox<>();
        txt_tim = new javax.swing.JTextField();
        btn_tim = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_datve = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_datve = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_khachhang = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        btn_huy = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(325, 150));

        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin vé", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel14.setText("Giờ khởi hành:");

        jLabel15.setText("Giá");

        jLabel16.setText("Tuyến:");

        cbb_gio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12:00 AM", "05:00 PM", "08:00 PM", "10:00 PM", " " }));

        cbb_gia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "300.000 VND", "400.000 VND", "500.000 VND" }));

        cbb_tuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cbb_tuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbb_tuyenMouseClicked(evt);
            }
        });
        cbb_tuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_tuyenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbb_gio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbb_gia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(cbb_tuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(cbb_gio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_tuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbb_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(90, 240, 420, 120);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setText("Họ và tên:");

        jLabel8.setText("SĐT:");

        jLabel9.setText("Điểm đón:");

        jLabel10.setText("Điểm đến:");

        jLabel11.setText("Ngày đi:");

        jLabel12.setText("Thanh toán:");

        jLabel13.setText("Mã khách hàng:");

        cbb_thanhtoan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", " " }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ngaydi, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_ten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                        .addComponent(txt_ma, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel12)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbb_thanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_diemdon, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(txt_diemden)
                    .addComponent(txt_sdt))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ngaydi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_diemdon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_diemden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbb_thanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 53, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(90, 50, 630, 190);

        txt_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timActionPerformed(evt);
            }
        });
        jPanel1.add(txt_tim);
        txt_tim.setBounds(140, 370, 350, 30);

        btn_tim.setBackground(new java.awt.Color(153, 153, 255));
        btn_tim.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/timve.png"))); // NOI18N
        btn_tim.setText("Tìm");
        btn_tim.setAlignmentY(0.0F);
        btn_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tim);
        btn_tim.setBounds(520, 370, 150, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Reset");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 260, 40, 15);

        btn_datve.setBackground(new java.awt.Color(204, 204, 255));
        btn_datve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_datve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/themve.png"))); // NOI18N
        btn_datve.setText("Đặt Vé");
        btn_datve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_datveActionPerformed(evt);
            }
        });
        jPanel1.add(btn_datve);
        btn_datve.setBounds(520, 260, 190, 80);

        btn_reset.setBackground(new java.awt.Color(99, 114, 252));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reset.png"))); // NOI18N
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reset);
        btn_reset.setBounds(30, 190, 50, 90);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(7, 22, 108));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Đặt Vé");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 0, 710, 50);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Back");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 150, 40, 20);

        btn_back.setBackground(new java.awt.Color(244, 143, 143));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ql.png"))); // NOI18N
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back);
        btn_back.setBounds(30, 90, 50, 90);

        tbl_datve.setBackground(new java.awt.Color(204, 204, 255));
        tbl_datve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_datve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_datveMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_datve);

        jTabbedPane1.addTab("Đặt Vé", jScrollPane1);

        tbl_khachhang.setBackground(new java.awt.Color(255, 102, 102));
        tbl_khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khachhangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_khachhang);

        jTabbedPane1.addTab("Khách Hàng", jScrollPane2);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 410, 710, 120);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/nen2.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(90, 10, 630, 350);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/nen3.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, -70, 720, 670);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/nenve.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 0, 630, 480);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/nen1.png"))); // NOI18N
        background.setText("back");
        jPanel1.add(background);
        background.setBounds(0, 0, 760, 620);

        btn_huy.setBackground(new java.awt.Color(255, 255, 255));
        btn_huy.setForeground(new java.awt.Color(255, 0, 0));
        btn_huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/huyve.png"))); // NOI18N
        btn_huy.setText("Hủy Vé");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(255, 255, 255));
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/suave.png"))); // NOI18N
        btn_sua.setText("Sửa Vé");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        txt_ma.setText("");
        txt_ten.setText("");
        txt_sdt.setText("");     
        cbb_thanhtoan.setSelectedItem("");
        txt_diemdon.setText("");
        txt_diemden.setText("");
        txt_ngaydi.setText(""); 
        cbb_gia.setSelectedItem("");
        cbb_gio.setSelectedItem("");
        cbb_tuyen.setSelectedItem("");
    }//GEN-LAST:event_btn_resetActionPerformed

    private void txt_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(DB_url);
            String sql = "Update KhachHang set TenKH=?, SDT=?, NgayDi=?, DiemDon=?, DiemDen=?, ThanhToan=? where MaKH=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, txt_ten.getText());
            st.setString(2, txt_sdt.getText());
            st.setString(3, txt_ngaydi.getText());
            st.setString(4, txt_diemdon.getText());
            st.setString(5, txt_diemden.getText());
            st.setString(6, cbb_thanhtoan.getSelectedItem().toString());
            st.setString(7, txt_ma.getText());
            st.executeUpdate();
            
            String sql1 = "Update DatVe set Gia=?, GioKhoiHanh=?, MaChuyen=? where MaKhachHang=? ";
            PreparedStatement st1 = con.prepareStatement(sql1);
            st1.setString(1, cbb_gia.getSelectedItem().toString());
            st1.setString(2, cbb_gio.getSelectedItem().toString());
            st1.setString(4, txt_ma.getText());
            st1.setString(3, cbb_tuyen.getSelectedItem().toString());
            st1.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
            con.close();
            loadDataToTableKH();
            loadDataToTableDV();
            LoadData();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void tbl_datveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_datveMouseClicked
       int row = tbl_datve.getSelectedRow();
           if(row<0){
            return;          
        }
        try{        
          cbb_gio.setSelectedItem(tbl_datve.getValueAt(row, 4).toString());
          cbb_gia.setSelectedItem(tbl_datve.getValueAt(row, 5).toString());
          cbb_tuyen.setSelectedItem(tbl_datve.getValueAt(row, 6).toString());
       
        
        }catch (Exception e) {
                e.printStackTrace();
 }
       
            int row1 = tbl_datve.getSelectedRow();
           if(row1<0){
            return;          
        }
        try{     
          txt_ma.setText(tbl_khachhang.getValueAt(row1, 0).toString());
          txt_ten.setText(tbl_khachhang.getValueAt(row1, 1).toString());
          txt_sdt.setText(tbl_khachhang.getValueAt(row1, 2).toString());   
          txt_ngaydi.setText(tbl_khachhang.getValueAt(row1, 3).toString());
          txt_diemdon.setText(tbl_khachhang.getValueAt(row1, 4).toString());
          txt_diemden.setText(tbl_khachhang.getValueAt(row1, 5).toString());         
          cbb_thanhtoan.setSelectedItem(tbl_khachhang.getValueAt(row1, 6).toString());
       
        
        }catch (Exception e) {
                e.printStackTrace();
        }
    }//GEN-LAST:event_tbl_datveMouseClicked

    private void tbl_khachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khachhangMouseClicked
        int row = tbl_khachhang.getSelectedRow();
           if(row<0){
            return;          
        }
        try{        
          cbb_gio.setSelectedItem(tbl_datve.getValueAt(row, 4).toString());
          cbb_gia.setSelectedItem(tbl_datve.getValueAt(row, 5).toString());
          cbb_tuyen.setSelectedItem(tbl_datve.getValueAt(row, 6).toString());
       
        
        }catch (Exception e) {
                e.printStackTrace();
 }
       
            int row1 = tbl_khachhang.getSelectedRow();
           if(row1<0){
            return;          
        }
        try{     
          txt_ma.setText(tbl_khachhang.getValueAt(row1, 0).toString());
          txt_ten.setText(tbl_khachhang.getValueAt(row1, 1).toString());
          txt_sdt.setText(tbl_khachhang.getValueAt(row1, 2).toString());   
          txt_ngaydi.setText(tbl_khachhang.getValueAt(row1, 3).toString());
          txt_diemdon.setText(tbl_khachhang.getValueAt(row1, 4).toString());
          txt_diemden.setText(tbl_khachhang.getValueAt(row1, 5).toString());         
          cbb_thanhtoan.setSelectedItem(tbl_khachhang.getValueAt(row1, 6).toString());
       
        
        }catch (Exception e) {
                e.printStackTrace();
        }
    }//GEN-LAST:event_tbl_khachhangMouseClicked

    private void btn_datveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datveActionPerformed
       try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(DB_url);
            String sql = "insert into KhachHang values(?,?,?,?,?,?)\n";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, txt_ten.getText());
            st.setString(2, txt_sdt.getText());
            st.setString(3, txt_ngaydi.getText());
            st.setString(4, txt_diemdon.getText());
            st.setString(5, txt_diemden.getText());
            st.setString(6, cbb_thanhtoan.getSelectedItem().toString());
            st.executeUpdate();
           
            
            String sql1 = "insert into DatVe values(?,?,?,?)\n";
            PreparedStatement st1 = con.prepareStatement(sql1);
            st1.setString(1, cbb_gia.getSelectedItem().toString());
            st1.setString(2, cbb_gio.getSelectedItem().toString());
            st1.setString(3, txt_ma.getText());
            st1.setString(4, cbb_tuyen.getSelectedItem().toString());
            st1.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Đặt vé thành công");
            con.close();
            loadDataToTableKH();
            loadDataToTableDV();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_datveActionPerformed

    private void btn_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timActionPerformed
        int i;
        String makh = txt_tim.getText();
        for (i = 0; i < list.size(); i++) {
            KhachHangDAO nv = list.get(i);
            if (nv.MaKH.equals(makh) == true) {
                curredIndex = i;
            tbl_khachhang.setRowSelectionInterval(curredIndex, curredIndex);   
            tbl_datve.setRowSelectionInterval(curredIndex, curredIndex);   
                DislayNV();
                break;
            }
        }
        if (i == list.size()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng");
        }
        
    }//GEN-LAST:event_btn_timActionPerformed

    private void cbb_tuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbb_tuyenMouseClicked
        if(cbb_tuyen.getSelectedItem()=="1"){
           cbb_gia.setSelectedItem("300.000 VND");
       }if(cbb_tuyen.getSelectedItem()=="2"){
           cbb_gia.setSelectedItem("400.000 VND");
       }if(cbb_tuyen.getSelectedItem()=="3"){
           cbb_gia.setSelectedItem("400.000 VND");
       }if(cbb_tuyen.getSelectedItem()=="4"){
           cbb_gia.setSelectedItem("500.000 VND");
       }
    }//GEN-LAST:event_cbb_tuyenMouseClicked

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
       TrangChu tc = new TrangChu();
       tc.setVisible(true);
       dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Có",
                JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }
        Connection c = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection(DB_url);
            ps = c.prepareStatement("delete from DatVe where MaKhachHang=? \n" +
                                    " delete from KhachHang where MaKH=?");           
            ps.setString(1, txt_ma.getText());
            ps.setString(2, txt_ma.getText());
            String ten = txt_ten.getText();
            ret = ps.executeUpdate();
            if (ret != -1) {
                JOptionPane.showMessageDialog(this, "Đã xóa khách hàng " + ten);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                    loadDataToTableDV();
                    loadDataToTableKH();
                    LoadData();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_huyActionPerformed

    private void cbb_tuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_tuyenActionPerformed
        if(cbb_tuyen.getSelectedItem()=="1"){
           cbb_gia.setSelectedItem("300.000 VND");
       }if(cbb_tuyen.getSelectedItem()=="2"){
           cbb_gia.setSelectedItem("400.000 VND");
       }if(cbb_tuyen.getSelectedItem()=="3"){
           cbb_gia.setSelectedItem("400.000 VND");
       }if(cbb_tuyen.getSelectedItem()=="4"){
           cbb_gia.setSelectedItem("500.000 VND");
       }
    }//GEN-LAST:event_cbb_tuyenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatVe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_datve;
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_tim;
    private javax.swing.JComboBox<String> cbb_gia;
    private javax.swing.JComboBox<String> cbb_gio;
    private javax.swing.JComboBox<String> cbb_thanhtoan;
    private javax.swing.JComboBox<String> cbb_tuyen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_datve;
    private javax.swing.JTable tbl_khachhang;
    private javax.swing.JTextField txt_diemden;
    private javax.swing.JTextField txt_diemdon;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ngaydi;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_tim;
    // End of variables declaration//GEN-END:variables
}
