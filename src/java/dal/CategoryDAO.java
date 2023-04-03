package dal;

import model.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class CategoryDAO extends MyDAO {
    
    public List<Category> getAll() {
        
        List<Category> list = new ArrayList<>();
        xSql = "select * from Category";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            Category c = null;
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                c = new Category(id, name);
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        CategoryDAO c = new CategoryDAO();
        List<Category> list = c.getAll();
        for (int i = 0; i < list.size(); i++) {         
            System.out.println(list.get(i).getName()); 
        }
    }
}
