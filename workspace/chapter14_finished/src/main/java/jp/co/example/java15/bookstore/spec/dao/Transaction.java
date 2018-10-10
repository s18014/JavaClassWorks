package jp.co.example.java15.bookstore.spec.dao;


public interface Transaction {
	public void begin() throws TransactionException;
	public void commit() throws TransactionException;
	public boolean isActive() throws TransactionException; 
	public void rollback() throws TransactionException;
	public <T> T getResource(Class<T> klass);


	public static final class TransactionException extends RuntimeException{
		private static final long serialVersionUID = 1L;


		public TransactionException(Exception e) {
			super(e);
		}
	}
}
