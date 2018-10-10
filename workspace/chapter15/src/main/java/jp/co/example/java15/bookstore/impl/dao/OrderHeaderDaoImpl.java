package jp.co.example.java15.bookstore.impl.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.example.java15.bookstore.spec.dao.OrderHeaderDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;
import jp.co.example.java15.bookstore.spec.dto.OrderHeader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OrderHeaderDaoImpl implements OrderHeaderDao {
	private static final String SQL_FIND =
			"select order_header_id, total_amount, customer_name, customer_address, order_date from order_headers "
			+ "where order_header_id = ?";
	private static final String SQL_FIND_ALL =
			"select order_header_id, total_amount, customer_name, customer_address, order_date from order_headers "
			+ "order by order_header_id";
	private static final String SQL_UPDATE_ID = "update sequence set id = LAST_INSERT_ID(id + 1)";
	private static final String SQL_GET_ID = "select last_insert_id()";
	private static final String SQL_INSERT =
			"insert into order_headers (order_header_id, total_amount, customer_name, customer_address, order_date, prc_date) "
			+ "values (?, ?, ?, ?, curdate(), curdate())";

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Override
	public void create(Transaction transaction, OrderHeader orderHeader) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
			ps.setInt(1, orderHeader.getId());
			ps.setInt(2, orderHeader.getTotal());
			ps.setString(3, orderHeader.getName());
			ps.setString(4, orderHeader.getAddress());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.warn(e.getMessage(), e);
			throw new IOException(e);
		}
	}


	@Override
	public int getSequence(Transaction transaction) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement update_ps = con.prepareStatement(SQL_UPDATE_ID)) {
			update_ps.executeUpdate();

			try (PreparedStatement select_ps = con.prepareStatement(SQL_GET_ID);
					ResultSet rs = select_ps.executeQuery()) {
			if (rs.next()) {
				return rs.getInt(1);
			}

			throw new IllegalStateException();
			}
		} catch (SQLException e) {
			logger.warn(e.getMessage(), e);
			throw new IOException(e);
		}
	}


	@Override
	public OrderHeader find(Transaction transaction, int orderHeaderId) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_FIND)) {
			ps.setInt(1, orderHeaderId);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new OrderHeader(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
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
	public List<OrderHeader> findAll(Transaction transaction) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		/*
		 * 今回は解説しきれなかったため全件表示のサンプルとしていますが、
		 * 50件ずつ表示する、などのページング機能を付けましょう。
		 */
		try (PreparedStatement ps = con.prepareStatement(SQL_FIND_ALL)) {
			ps.setFetchSize(1000);

			try (ResultSet rs = ps.executeQuery()) {
				List<OrderHeader> items = new ArrayList<OrderHeader>();

				while (rs.next()) {
					items.add(new OrderHeader(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
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
