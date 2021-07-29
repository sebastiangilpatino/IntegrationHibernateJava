package cs544.exercise16_1.bank.dao;

import org.hibernate.SessionFactory;

import cs544.exercise16_1.bank.domain.Account;

import org.hibernate.Query;
import java.util.Collection;

public class AccountDAOHibernate implements IAccountDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public void saveAccount(Account account) {
		sessionFactory.getCurrentSession().persist(account);
	}

	@Override
	public void updateAccount(Account account) {
		sessionFactory.getCurrentSession().saveOrUpdate(account);
	}

	@Override
	public Account loadAccount(long accountnumber) {
		return (Account) sessionFactory.getCurrentSession().get(Account.class, accountnumber);
	}

	@Override
	public Collection<Account> getAccounts() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Account");
		Collection<Account> accounts = query.list();
		return accounts;
	}

}
