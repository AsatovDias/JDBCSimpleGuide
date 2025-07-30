package JDBC.MySQLConnection.HW;

import java.sql.*;
import java.util.ArrayList;

public class Connector {
    private Connection connection;
    public Connector() {}
    public void connect(){ //connection to DataBase
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akzhol_java_se?useUnicode=true&serverTimezone_UTC","root","");
            System.out.println("Connected");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<User> getAllUsers(){
        ArrayList<User> usersList= new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("select * from users");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPin_code(resultSet.getInt("pin_code"));
                user.setUserBalance(resultSet.getInt("user_balance"));
                usersList.add(user);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return usersList;
    }
    public User getUser(int cardNumber){
        User user = new User();
        try{
            PreparedStatement st = connection.prepareStatement("select * from users " +
                    "where card_number = ?");
            st.setInt(1, cardNumber);
            ResultSet resultSet = st.executeQuery();
            if(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPin_code(resultSet.getInt("pin_code"));
                user.setUserBalance(resultSet.getInt("user_balance"));
                user.setCardNumber(cardNumber);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

}
