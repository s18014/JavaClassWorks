package jp.co.example.java15.bookstore.impl.services;

import java.io.IOException;
import java.util.List;

import jp.co.example.java15.bookstore.spec.dao.OrderDetailDao;
import jp.co.example.java15.bookstore.spec.dao.OrderHeaderDao;
import jp.co.example.java15.bookstore.spec.dao.Transaction;
import jp.co.example.java15.bookstore.spec.dto.Order;
import jp.co.example.java15.bookstore.spec.dto.OrderDetail;
import jp.co.example.java15.bookstore.spec.dto.OrderHeader;
import jp.co.example.java15.bookstore.spec.services.ManageOrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ManageOrderServiceImpl implements ManageOrderService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final Transaction transaction;
	private final OrderHeaderDao orderHeaderDao;
	private final OrderDetailDao orderDetailDao;


	public ManageOrderServiceImpl(Transaction transaction,
			OrderHeaderDao orderHeaderDao, OrderDetailDao orderDetailDao) {
		this.transaction = transaction;
		this.orderHeaderDao = orderHeaderDao;
		this.orderDetailDao = orderDetailDao;
	}


	@Override
	public List<OrderHeader> getOrderHeaders() {
		try {
			transaction.begin();

			List<OrderHeader> result = orderHeaderDao.findAll(transaction);

			transaction.commit();

			return result;
		} catch (IOException e) {
			throw new IllegalStateException(e);
		} finally {
			if (transaction.isActive()) {
				try {
					transaction.rollback();
				} catch (RuntimeException e) {
					logger.warn(e.getMessage(),e);
				}
			}
		}
	}


	@Override
	public Order getOrder(int orderHeaderId) {
		try {
			transaction.begin();

			OrderHeader header = orderHeaderDao.find(transaction, orderHeaderId);
			List<OrderDetail> details = orderDetailDao.findByHeaderId(transaction, orderHeaderId);

			transaction.commit();

			return new Order(header, details);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		} finally {
			if (transaction.isActive()) {
				try {
					transaction.rollback();
				} catch (RuntimeException e) {
					logger.warn(e.getMessage(),e);
				}
			}
		}
	}
}
