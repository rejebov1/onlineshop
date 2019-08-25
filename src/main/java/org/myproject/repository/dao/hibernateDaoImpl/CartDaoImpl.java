package org.myproject.repository.dao.hibernateDaoImpl;

import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.myproject.repository.dao.hibernateDao.CartDao;
import org.myproject.repository.entity.Cart;
import org.myproject.repository.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Repository
public class CartDaoImpl extends GenericDaoImpl<Cart, Long> implements CartDao {

    @Override
    public Cart validate(Long cartId) throws IOException {
        Cart cart = getById(cartId);
        if (cart == null || cart.getGoodInOrders().size() == 0) {
            throw new IOException(cartId + "");
        }
        update(cart);
        return cart;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("delete product where id = :id");
        query.setParameter("id", id);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Product> showCartUser(String login) {
        String hql ="SELECT p.name, p.product_characteristic, p.price, p.date_of_issue, p.id FROM product AS p WHERE p.id IN "
                + "(SELECT c.product_id FROM cart AS c WHERE c.user_id IN "
                + "(SELECT u.id FROM d_user As u WHERE u.email =:email))";
        List <Product> results =  (List<Product>) getCurrentSession().createSQLQuery(hql)
                .addScalar("name", StringType.INSTANCE)
                .addScalar("description", StringType.INSTANCE)
                .addScalar("productID", LongType.INSTANCE)
                .addScalar("price", DoubleType.INSTANCE)
                .setParameter("userlogin", login)
                .setResultTransformer(Transformers.aliasToBean(Product.class)).list();
        return results;
    }

    @Override
    @Transactional
    public Cart getCartByUserIdAndProductId (Long userId, Long productId){
        String hql = "FROM Cart c WHERE c.user.id=:userId AND c.product.id=:productId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("userId", userId);
        query.setParameter("productId", productId);
        Cart result = (Cart) query.uniqueResult();
        return result;
    }
}


