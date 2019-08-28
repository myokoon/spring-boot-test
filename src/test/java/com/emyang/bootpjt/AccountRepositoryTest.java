package com.emyang.bootpjt;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emyang.bootpjt.entity.Account;
import com.emyang.bootpjt.repository.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Test
	public void optional() throws Exception {
		Optional<Account> optional = accountRepository.findByUsername("spring");
		
		if (optional.isPresent()) {
			Account account = optional.get();
			assertThat(account).isNotNull();
		}
		
		optional.ifPresent(acct -> System.out.println(acct));
		
		optional.ifPresent(System.out::println); // method reference
		
		Optional<Account> notOpt = accountRepository.findByUsername("test");
		
		System.out.println("==========");
		notOpt.ifPresent(System.out::println);
		notOpt.orElseThrow(() -> new Exception("Username not found."));
		System.out.println("==========");
	}
	
	@Test
	@Ignore
	public void account() {
		// INSERT
		Account account = new Account();
		account.setUsername("spring");
		account.setPassword("1234");
		
		Account newAccount = accountRepository.save(account);
		assertThat(newAccount).isNotNull();
		
		// SELECT
//		Account existAccount = accountRepository.findByUsername(newAccount.getUsername());
//		assertThat(existAccount).isNotNull();
//		
//		Account notExistAccount = accountRepository.findByUsername("test");
//		assertThat(notExistAccount).isNull();
	}
	
}
