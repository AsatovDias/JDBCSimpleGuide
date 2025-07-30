package JDBC.MySQLConnection.HW;

public class User {
    private int id;
    private String name;
    private String surname;
    private int pin_code;
    private int userBalance;
    private int cardNumber;
    public User(){}
    public User(int id, String name, String surname, int pin_code, int userBalance,int cardNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pin_code = pin_code;
        this.userBalance = userBalance;
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPin_code() {
        return pin_code;
    }

    public void setPin_code(int pin_code) {
        this.pin_code = pin_code;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String toString(){
        return "id " + id + " name " + name + " surname " + surname + " pin_code " + pin_code + " userBalance " + userBalance + " cardNumber " + cardNumber;
    }
}
