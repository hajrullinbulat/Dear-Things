import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Gataullin Kamil
 *         12.10.2014 0:16
 */
public class TestConnection {

    public static void main(String[] args) {
        try {
            testConnection();
//            testCreate();
//            testInsert("tatar");
            testSelect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testConnection() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = null;        // Класс для работы с БД
        try {
            connection = getConnection();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties props = new Properties();                  // Доп класс для считывание данных с файла
        props.load(new FileInputStream("etc/properties/tutor-db-connection.properties"));     // Считывание (загрузка) из файла
        String driver = props.getProperty("driver");
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String pass = props.getProperty("pass");
        Class.forName(driver);                                // Проверка правильности подключения драйвера
        return DriverManager.getConnection(url, user, pass);  // Открытие соединения к БД
    }

    private static void testCreate() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();    // Тип SQL запроса
            statement.executeUpdate("create table Subject (id bigint GENERATED BY DEFAULT AS IDENTITY(START WITH 1) " +
                    "NOT NULL PRIMARY KEY, name varchar)");
            // ^ для SQL запросов, которые не возвращают никаких значений, т.е. не SELECT
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void testInsert(String name) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into Subject (name) values (?)");
            // ^ гарантирует отсутствие SQL-инъекций
            statement.setString(1, name);
            statement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void testSelect() throws ClassNotFoundException, IOException, SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Subject");
            // ^ для запросов которые что то возвращают, они получают тип ResultSet
            while (resultSet.next()) {  // начальный указатель стоит на -1, сразу происходит переход на новую строку и возврат bool значения
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                System.out.println("id=" + id + " name=" + name);
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
