package jp.co.example.java15.bookstore.impl.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.example.java15.bookstore.spec.dao.ItemDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;
import jp.co.example.java15.bookstore.spec.dto.Item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ItemDaoImpl implements ItemDao {
	private static final String SQL_FIND = "select item_id, item_name, price, picture, release_date from items where item_id = ?";
	private static final String SQL_FIND_ALL = "select item_id, item_name, price, picture, release_date from items order by item_id";

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Override
	public Item find(Transaction transaction, int id) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_FIND)) {
			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDate(5));
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
	public List<Item> getAllOrderdById(Transaction transaction) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_FIND_ALL)) {
			ps.setFetchSize(100);

			try (ResultSet rs = ps.executeQuery()) {
				List<Item> items = new ArrayList<Item>();

				while (rs.next()) {
					items.add(new Item(rs.getInt(1), rs.getString(2), rs.getInt(3),
							rs.getString(4), rs.getDate(5)));
				}

				return items;
			} catch (SQLException e) {
				logger.warn(e.getMessage(), e);
				throw new IOException(e);
			}
		} catch (SQLException e) {
			logger.warn(e.getMessage(), e);
			throw new IOException(e);
		}
	}
}
