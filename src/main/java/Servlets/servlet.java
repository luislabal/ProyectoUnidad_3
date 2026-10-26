package Servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import models.libros;
import java.sql.*;

@WebServlet(name = "servlet", urlPatterns = {"/libro"})
public class servlet extends HttpServlet {

    private final String user = "Aldeano";
    private final String password = "password123";
    private final String conexion = "jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;databaseName=tiendamine;encrypt=true;trustServerCertificate=true";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("Driver JDBC no encontrado", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<libros> lista = new ArrayList<>();
        String sql = "SELECT * FROM Encantamientos";

        try (Connection con = DriverManager.getConnection(conexion, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
               lista.add(new libros(rs.getString("nombre"), rs.getInt("id"), rs.getInt("precio"), rs.getString("foto")));
            }

        } catch (SQLException e) {
            throw new ServletException("Error al leer la base de datos", e);
        }

        request.setAttribute("lista", lista);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
       String nombre = request.getParameter("nombre");
        String foto = request.getParameter("foto");
        int precio = Integer.parseInt(request.getParameter("precio"));

        String sql = "INSERT INTO Encantamientos (nombre, precio, foto) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(conexion, user, password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setInt(2, precio);
            ps.setString(3, foto);
            ps.executeUpdate();
        }catch (SQLException e) {
            throw new ServletException("Error al guardar el encantamiento", e);
        }

        response.sendRedirect("libro");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
