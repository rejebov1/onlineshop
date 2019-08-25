package org.myproject.repository.dao.JdbcDao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.myproject.repository.entity.Brand;
import org.myproject.repository.entity.Product;
import org.myproject.repository.exception.DaoException;
import org.myproject.repository.dao.hibernateConfig.DataBaseUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@SuppressWarnings("Duplicates")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductJdbcDao {
    private static final ProductJdbcDao INSTANCE = new ProductJdbcDao();
    private static final String ADD = "insert into product " +
            "(name, date_of_issue, product_characteristic, price/*,brand_id*/) values (?,?,?,?/*,?*/)";

    private static final String DELETE_PRODUCT_ID = "DELETE FROM good_in_order WHERE product_id = ?";
    private static final String DELETE = "DELETE FROM product WHERE id = ?";

    private static final String GET_BY_ID = "select " +
            "p.id,p.name, p.date_of_issue, p.product_characteristic, p.price, b.name, b.country " +
            "from product as p " +
            "left join brand as b " +
            "on p.brand_id = b.id where p.id = ?";

    //  private static final String UPDATE = "UPDATE product SET phone_model = ? WHERE id = ?";

    private static final String GET_ALL = "SELECT id,name,date_of_issue,product_characteristic,price,brand_id from product";

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DataBaseUtil.getDataSource().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(Product.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .dateOfIssue(resultSet.getObject("date_of_issue", LocalDate.class))
                        .productCharacteristic(resultSet.getString("product_characteristic"))
                        .price(BigDecimal.valueOf(resultSet.getDouble("price")))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    public static ProductJdbcDao getInstance() {
        return INSTANCE;
    }


//    public Long update(Long id,String phone_model){
//        long result = 0;
//        try (Connection connection = ConnectionManager.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
//            preparedStatement.setString(1,phone_model);
//            preparedStatement.setLong(2,id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }


    public Optional<Product> getById(Long id) {
        Product product = null;
        try (Connection connection = DataBaseUtil.getDataSource().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (product == null) {
                    Brand brand = Brand.builder()
                            .name(resultSet.getString("name"))
                            .country(resultSet.getString("country"))
                            .build();
                    product = Product.builder()
                            .id(resultSet.getLong("id"))
                            .name(resultSet.getString("name"))
                            .brand(brand)
                            .dateOfIssue(resultSet.getObject("date_of_issue", LocalDate.class))
                            .productCharacteristic(resultSet.getString("product_characteristic"))
                            .price(BigDecimal.valueOf(resultSet.getDouble("price")))
                            .build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(product);
    }


    public Product add(Product product) {
        Long id = null;
        try (Connection connection = DataBaseUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD,
                     RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDate(2, Date.valueOf(product.getDateOfIssue()));
            preparedStatement.setString(3, product.getProductCharacteristic());
            preparedStatement.setBigDecimal(4, product.getPrice());
            //preparedStatement.setLong(5, product.getBrand().getId());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
                product.setId(id);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return product;
    }


    public boolean delete(Product product) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement deleteProductIdPs = null;
        PreparedStatement deletePs = null;
        try {
            connection = DataBaseUtil.getDataSource().getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            deleteProductIdPs = connection.prepareStatement(DELETE_PRODUCT_ID);
            deleteProductIdPs.setLong(1, product.getId());
            deleteProductIdPs.executeUpdate();

            deletePs = connection.prepareStatement(DELETE);
            deletePs.setLong(1, product.getId());
            deletePs.executeUpdate();
            connection.commit();

            result = true;
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new DaoException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();

                }
                if (deleteProductIdPs != null) {
                    deleteProductIdPs.close();

                }
                if (deletePs != null) {
                    deletePs.close();

                }
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
        return result;
    }
}
