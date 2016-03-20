package ru.dz.labs.filters;

import ru.dz.labs.model.Categories;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class MainFilter implements Filter {

    ArrayList<Categories> categories;
    boolean firstTime;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        firstTime = true;
        categories = new ArrayList<>();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (firstTime) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            Connection connection = null;
            try {
                connection = getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from categories where parent_id = 1 and id != 1");
                while (resultSet.next()) {
                    categories.add(new Categories(resultSet.getLong("id"), resultSet.getString("name")));
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                firstTime = false;
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            request.getSession().setAttribute("categories", categories);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/shop";
        String user = "postgres";
        String pass = "264266";
        Class.forName(driver);
        return DriverManager.getConnection(url, user, pass);  // Открытие соединения к БД
    }
}
