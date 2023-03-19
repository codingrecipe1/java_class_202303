package day17_20230316_Bank;

import java.util.*;

public class ClientRepository {
	private static ClientRepository repository = new ClientRepository();
	private ClientRepository() {}
	public static ClientRepository getInstance() {
		return repository;
	}
	
	Map<String, ClientDTO> clientMap = new HashMap<String, ClientDTO>();
	List<BreakdownDTO> bList = new ArrayList<>();

	public boolean save(ClientDTO clientDTO) {
		if(clientMap.put(clientDTO.getAccount(), clientDTO) == null)
			return true;
		else
			return false;
	}
	
	public boolean loginCheck(String id, String password) {
		if(clientCheck(id, password) != null) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public Map<String, ClientDTO> findAll() {	
		return clientMap;
	}
	
	public ClientDTO findById(String loginId, String loginPassword) {
		String key = clientCheck(loginId, loginPassword); 
		if(key != null) {
			return clientMap.get(key);
		} else {
			return null;
		}
	}
	
	public List<BreakdownDTO> breakList(String account) {
		List<BreakdownDTO> list = new ArrayList<>();
		for(BreakdownDTO b: bList) {
			if(b.getAccount().equals(account)) {
				list.add(b);
			}
		}
		return list;
	}
	
	public String getAccount(String loginId, String loginPassword) {		
		String key = clientCheck(loginId, loginPassword); 
		if(key != null) {
			return clientMap.get(key).getAccount();
		} else {
			return null;
		}
	}
	
	public boolean deposit(String account, long money) {
		for(String key: clientMap.keySet()) {
			if(clientMap.get(key).getAccount().equals(account)) {
				clientMap.get(key).setBalance(clientMap.get(key).getBalance() + money);
				BreakdownDTO breakdownDTO = new BreakdownDTO();
				breakdownDTO.setAccount(account);
				breakdownDTO.setDivision("입금");
				breakdownDTO.setDealMoney(money);
				breakdownDTO.setTotalMoney(clientMap.get(key).getBalance());
				bList.add(breakdownDTO);
				return true;
			}
		}
		return false;
	}
	
	public boolean withdraw(String account, long money) {
		for(String key: clientMap.keySet()) {
			if(clientMap.get(key).getAccount().equals(account)) {
				if(clientMap.get(key).getBalance() >= money) {
					clientMap.get(key).setBalance(clientMap.get(key).getBalance() - money);
					BreakdownDTO breakdownDTO = new BreakdownDTO();
					breakdownDTO.setAccount(account);
					breakdownDTO.setDivision("출금");
					breakdownDTO.setDealMoney(money);
					breakdownDTO.setTotalMoney(clientMap.get(key).getBalance());
					bList.add(breakdownDTO);
					return true;					
				}
			}
		}
		return false;
	}
	
	public boolean transferCheck(String transferAccount) {
		for(String key: clientMap.keySet()) {
			if(clientMap.get(key).getAccount().equals(transferAccount)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean update(String loginId, String loginPassword, String updatePassword) {
//		for(String key: clientMap.keySet()) {
//			if(loginId.equals(clientMap.get(key).getId()) && 
//					loginPassword.equals(clientMap.get(key).getPassword())) {
//				clientMap.get(key).setPassword(updatePassword);
//				return true;
//			}
//		}
//		return false;
		String key = clientCheck(loginId, loginPassword); 
		if(key != null) {
			clientMap.get(key).setPassword(updatePassword);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean delete(String loginId, String loginPassword) {
//		for(String key: clientMap.keySet()) {
//			if(loginId.equals(clientMap.get(key).getId()) && 
//					loginPassword.equals(clientMap.get(key).getPassword())) {
//				clientMap.remove(key);
//				return true;
//			}
//		}
//		return false;
		String key = clientCheck(loginId, loginPassword); 
		if(key != null) {
			clientMap.remove(key);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkId(String id) {
		for(String key: clientMap.keySet()) {
			if(id.equals(clientMap.get(key).getId())) {
				return false; 
			}
		}
		return true;
	}
	
	private String clientCheck(String id, String password) {
		for(String key: clientMap.keySet()) {
			if(id.equals(clientMap.get(key).getId()) && 
					password.equals(clientMap.get(key).getPassword())) {
				return key;
			}
		}
		return null;
	}

}














