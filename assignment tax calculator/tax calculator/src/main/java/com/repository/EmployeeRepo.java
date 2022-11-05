package com.repository;

import com.domain.Employee;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class EmployeeRepo {

    private DataSource dataSource;

    private static final String CREATE = "insert into taxlist (NAME,Monthlysalary, Monthlytax,Yearlysalary,Yearlytax ) values (?, ?,?,?,?)";

    public EmployeeRepo(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public boolean create(Employee employee) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
        preparedStatement.setString(1, employee.getEmpname());
        preparedStatement.setDouble(5,employee.getTaxs());
        preparedStatement.setDouble(2,employee.getMonthlyNetsal());
        preparedStatement.setDouble(3,employee.getMonthlytaxs());
        preparedStatement.setDouble(4,employee.getNetsal());


        return preparedStatement.execute();
    }
}
