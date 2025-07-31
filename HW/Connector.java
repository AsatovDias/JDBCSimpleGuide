package JDBC.MySQLConnection.HW;

import java.awt.desktop.SystemSleepEvent;
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
                user.setPin_code(resultSet.getInt("pincode"));
                user.setUserBalance(resultSet.getInt("userBalance"));
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
                    "where cardNumber = ?");
            st.setInt(1, cardNumber);
            ResultSet resultSet = st.executeQuery();
            if(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPin_code(resultSet.getInt("pincode"));
                user.setUserBalance(resultSet.getInt("userBalance"));
                user.setCardNumber(cardNumber);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public boolean auth(int cardNumber, int pinCode){
        boolean isAuth = false;
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM users WHERE pincode = ? AND cardNumber = ?");
            st.setInt(1, pinCode);
            st.setInt(2, cardNumber);
            ResultSet resultSet = st.executeQuery();
            if(resultSet.next()){ // обязательно!
                isAuth = true;
                System.out.println("Auth success");
            }
        }catch(Exception e){
            e.printStackTrace();
            isAuth = false;
        }
        return isAuth;
    }

    public int getTotalBalance(int cardNumber,int pincode){
        int totalBalance = 0;
        try{

                PreparedStatement st = connection.prepareStatement("select userBalance from users where cardNumber = ? and pincode = ?");
                st.setInt(1, cardNumber);
                st.setInt(2, pincode);
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    totalBalance = rs.getInt("userBalance");
                }


        }catch (Exception e){
            e.printStackTrace();
        }
        return totalBalance;
    }

}

