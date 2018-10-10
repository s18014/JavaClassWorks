package jp.co.example.java15.bookstore.impl.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.example.java15.bookstore.spec.dao.OrderDetailDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;
import jp.co.example.java15.bookstore.spec.dto.OrderDetail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OrderDetailDaoImpl implements OrderDetailDao {
	private static final String SQL_FIND_BY_HEADER_ID =
			"select order_header_id, item_id, amount from order_details where order_header_id = ?";
	private static final String SQL_INSERT =
			"insert into order_details (order_header_id, item_id, amount, prc_date) values (?, ?, ?, curdate())";

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Override
	public void create(Transaction transaction,List<OrderDetail> orderDetails) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
			for (OrderDetail orderDetail : orderDetails) {
				ps.setInt(1, orderDetail.getOrderHeaderId());
				ps.setInt(2, orderDetail.getItemId());
				ps.setInt(3, orderDetail.getAmount());
				ps.addBatch();
			}

			ps.executeBatch();
		} catch (SQLException e) {
			logger.warn(e.getMessage(), e);
			throw new IOException(e);
		}
	}


	@Override
	public List<OrderDetail> findByHeaderId(Transaction transaction, int orderHeaderId) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_FIND_BY_HEADER_ID)) {
			ps.setInt(1, orderHeaderId);
			// ps.setFetchSize(10); データ件数が少ないと思われるので設定しない

			try (ResultSet rs = ps.executeQuery()) {
				List<OrderDetail> items = new ArrayList<OrderDetail>();

				while (rs.next()) {
					items.add(new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
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
