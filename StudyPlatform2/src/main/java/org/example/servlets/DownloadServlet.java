//package org.example.servlets;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.example.util.DBUtil;
//
//@WebServlet("/downloadMaterial")
//public class DownloadServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String materialId = request.getParameter("materialId");
//
//        if (materialId != null) {
//            try (Connection connection = DBUtil.getConnection()) {
//                String query = "SELECT file_name FROM Material WHERE material_id = ?";
//                try (PreparedStatement statement = connection.prepareStatement(query)) {
//                    statement.setObject(1, materialId);
//                    try (ResultSet resultSet = statement.executeQuery()) {
//                        if (resultSet.next()) {
//                            byte[] fileBytes = resultSet.getBytes("file_name");
//                            String fileName = "downloaded_file"; // Укажите имя файла
//
//                            response.setContentType("application/octet-stream");
//                            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//
//                            try (InputStream in = new java.io.ByteArrayInputStream(fileBytes);
//                                 OutputStream out = response.getOutputStream()) {
//                                byte[] buffer = new byte[1024];
//                                int length;
//                                while ((length = in.read(buffer)) > 0) {
//                                    out.write(buffer, 0, length);
//                                }
//                            }
//                        } else {
//                            response.getWriter().println("Файл не найден.");
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            response.getWriter().println("Неверный запрос.");
//        }
//    }
//}
//
