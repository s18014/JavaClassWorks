package jp.co.example.java15.bookstore.impl.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jp.co.example.java15.bookstore.spec.dao.StockDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;
import jp.co.example.java15.bookstore.spec.dto.Stock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StockDaoImpl implements StockDao {
	private static final String SQL_FIND = "select item_id, stock from stocks where item_id = ?";
	private static final String SQL_FIND_ALL = "select item_id, stock from stocks order by item_id";
	private static final String SQL_UPDATE = "update stocks set stock = ?, prc_date = curdate() where item_id = ?";

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Override
	public Stock find(Transaction transaction, int itemId) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_FIND)) {
			ps.setInt(1, itemId);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Stock(rs.getInt(1), rs.getInt(2));
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
	public List<Stock> findByItemIdWithLock(Transaction transaction, Set<Integer> idList) throws IOException {
		Connection con = transaction.getResource(Connection.class);
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT item_id, stock FROM STOCKS where item_id in (");

		for (int i = 0 ; i < idList.size(); i++) {
			if (i == 0) {
				sb.append("?");
				continue;
			}

			sb.append(", ?");
		}

		sb.append(") FOR UPDATE");

		try (PreparedStatement ps = con.prepareStatement(sb.toString())) {
			int index = 1;

			for (Integer id : idList) {
				ps.setInt(index, id);
				index++;
			}

			try (ResultSet rs = ps.executeQuery()) {
				List<Stock> result = new ArrayList<Stock>();

				while (rs.next()) {
					result.add(new Stock(rs.getInt(1), rs.getInt(2)));
				}

				return result;
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
	public List<Stock> getAllOrderedByItemId(Transaction transaction) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		/*
		 * 今回は解説しきれなかったため全件表示のサンプルとしていますが、
		 * 50件ずつ表示する、などのページング機能を付けましょう。
		 */
		try (PreparedStatement ps = con.prepareStatement(SQL_FIND_ALL)) {
			ps.setFetchSize(1000);

			try (ResultSet rs = ps.executeQuery()) {
				List<Stock> items = new ArrayList<Stock>();

				while (rs.next()) {
					items.add(new Stock(rs.getInt(1), rs.getInt(2)));
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


	@Override
	public void updateStock(Transaction transaction, int itemId, int newStock) throws IOException {
		Connection con = transaction.getResource(Connection.class);

		try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
			ps.setFetchSize(1000);
			ps.setInt(1, newStock);
			ps.setInt(2, itemId);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.warn(e.getMessage(), e);
			throw new IOException(e);
		}
	}
}
