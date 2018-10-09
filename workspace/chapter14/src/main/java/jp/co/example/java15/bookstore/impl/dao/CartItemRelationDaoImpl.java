package jp.co.example.java15.bookstore.impl.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.example.java15.bookstore.spec.dao.CartItemRelationDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;
import jp.co.example.java15.bookstore.spec.dto.CartItemRelation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CartItemRelationDaoImpl implements CartItemRelationDao {
	private static final String SQL_FIND_BY_USER_ID = "select user_id, item_id, amount from cart_items where user_id = ?";
	private static final String SQL_FIND_BY_USER_ID_AND_ITEM_ID =
			"select user_id, item_id, amount from cart_items where item_id = ? and user_id = ?";
	private static final String SQL_INSERT = "insert into cart_items (user_id, item_id, amount, prc_date) values (?, ?, ?, curdate())";
	private static final String SQL_UPDATE = "update cart_items set amount = ?, prc_date = curdate() where user_id = ? and item_id = ?";
	private static final String SQL_REMOVE_ALL = "delete from cart_items where user_id = ?";
	private static final String SQL_REMOVE_ITEM = "delete from cart_items where user_id = ? and item_id = ?";

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Override
	public void create(Transaction transaction, CartItemRelation item) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
			ps.setString(1, item.getUserId());
			ps.setInt(2, item.getItemId());
			ps.setInt(3, item.getAmount());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.warn(e.getMessage(), e);
			throw new IOException(e);
		}
	}


	@Override
	public List<CartItemRelation> findByUserId(Transaction transaction, String userId) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_FIND_BY_USER_ID)) {
			ps.setString(1, userId);

			try (ResultSet rs = ps.executeQuery()) {
				List<CartItemRelation> cartItems = new ArrayList<CartItemRelation>();

				while(rs.next()) {
					cartItems.add(new CartItemRelation(rs.getString(1), rs.getInt(2), rs.getInt(3)));
				}

				return cartItems;
			} catch (SQLException e) {
				logger.warn(e.getMessage(), e);
				throw new IOException(e);
			}
		} catch (SQLException e) {
			logger.warn(e.getMessage(), e);
			throw new IOException(e);
		}
	}


	@Override
	public CartItemRelation findByUserIdAndItemId(Transaction transaction, String userId, int itemId) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_FIND_BY_USER_ID_AND_ITEM_ID)) {
			ps.setInt(1, itemId);
			ps.setString(2, userId);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new CartItemRelation(rs.getString(1), rs.getInt(2), rs.getInt(3));
				}

				return null;
			} catch (SQLException e) {
				logger.warn(e.getMessage(), e);
				throw new IOException(e);
			}
		} catch (SQLException e) {
			logger.warn(e.getMessage(), e);
			throw new IOException(e);
		}
	}


	@Override
	public void updateAmount(Transaction transaction, String userId, int itemId, int newAmount) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
			ps.setInt(1, newAmount);
			ps.setString(2, userId);
			ps.setInt(3, itemId);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.warn(e.getMessage(), e);
			throw new IOException(e);
		}
	}


	@Override
	public void remove(Transaction transaction, String userId, int itemId) throws IOException{
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_REMOVE_ITEM)) {
			ps.setString(1, userId);
			ps.setInt(2, itemId);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.warn(e.getMessage(), e);
			throw new IOException(e);
		}
	}


	@Override
	public void removeByUserId(Transaction transaction, String userId) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_REMOVE_ALL)) {
			ps.setString(1, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.warn(e.getMessage(), e);
			throw new IOException(e);
		}
	}
}
