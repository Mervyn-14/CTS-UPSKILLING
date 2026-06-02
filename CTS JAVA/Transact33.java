import java.sql.*;

public class Transact33 {

    public static void main(String[] args) {

        try {

            Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/college",
                            "root",
                            ""
                    );

            con.setAutoCommit(false);

            PreparedStatement debit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance=balance-? WHERE id=?"
                    );

            debit.setDouble(1,1000);
            debit.setInt(2,1);

            debit.executeUpdate();

            PreparedStatement credit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance=balance+? WHERE id=?"
                    );

            credit.setDouble(1,1000);
            credit.setInt(2,2);

            credit.executeUpdate();

            con.commit();

            System.out.println(
                    "Transfer Successful"
            );

        } catch(Exception e) {

            System.out.println(
                    "Transfer Failed"
            );
        }
    }
}