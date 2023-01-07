//package com.example.demo.service;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import javax.validation.Valid;
//
//import org.apache.commons.beanutils.PropertyUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.constant.AccountTypeEnum;
//import com.example.demo.constant.ErrorEnum;
//import com.example.demo.dto.AccountDto;
//import com.example.demo.dto.CreateAccountRequest;
//import com.example.demo.dto.PatchRequest;
//import com.example.demo.dto.ResetPasswordRequest;
//import com.example.demo.dto.SearchAccountRequest;
//import com.example.demo.dto.UpdateAccountRequest;
//import com.example.demo.entity.Account;
//import com.example.demo.exception.LBRException;
//import com.example.demo.repository.AccountRepository;
//import com.example.demo.util.SearchUtil;
//
//@Service
//@Transactional
//public class AccountServiceImpl implements AccountService {
////	private static final String PRINCIPAL = "principal";
//////	@Autowired
////	private AuthenticationManager authenticationManager;
//	@Autowired
//	private AccountRepository accountRepository;
////	@Autowired
////	private PasswordEncoder passwordEncoder;
//////	@Autowired
//////	private SecurityConfigParam securityParam;
////	@Autowired
////	private TokenService tokenService;
////	@Autowired
////	private JwtTokenService jwtService;
//////	@Autowired
////	private JwtParser jwtParser;
////	@Autowired
////	private ObjectMapper objectMapper;
////	@Value("${app.api.first-user}")
////	private String accN;
////	@Value("${app.api.first-password")
////	private String pwd;
////	@Override
////	public void newAcc() {
////	long count = accountRepository.count();
////	if(count == 0) {
////		Account u = new Account();
////		  u.setAccountName(accN);
////		  u.setPassword(passwordEncoder.encode(pwd));
////		  u.setAccountType(AccountTypeEnum.ADMIN);
////		  accountRepository.save(u);
////		  System.out.print("Create first User");
////		  return;
////	}
////	return;
////	}
//	
//	// AUTHEN
////	@Override
////	public JwtResponse generateJwtToken(String Authorization, String accountName) throws Exception {
////		if (Authorization != null && Authorization.startsWith("Basic ")) {
////			Authorization.replace("Basic ", "");
////		}
////		String auth = new String(Base64.getDecoder().decode(Authorization));
////		String aN = "";
////		String pwd = "";
////		if (Authorization == null || accountName == null || !auth.startsWith(accountName)) {
////			throw new LBRException(ErrorEnum.VALUE_NOT_CORRECT, null);
////		} else {
////			aN = accountName;
////			pwd = auth.substring(accountName.length() + 1);
////			// abc:xyz
////		}
////		Authentication authentication = authenticationManager
////				.authenticate(new UsernamePasswordAuthenticationToken(aN, pwd));
////		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
////		SecurityContextHolder.getContext().setAuthentication(authentication);
////		CustomAccountDetails currentAccount = (CustomAccountDetails) loadUserByUsername(userDetails.getUsername());
////		String jwt = jwtService.generateToken(currentAccount, null, null);
////		return new JwtResponse(jwt, currentAccount.getId(), userDetails.getUsername(),
////				userDetails.getAuthorities().toString());
////	}
////
////	@Override
////	public String updatePassword(@Valid UpdatePasswordRequest request) throws NotFoundException {
////		Optional<Account> oAccount = accountRepository.findByAccountName(request.getUsername());
////		if (!oAccount.isPresent()) {
////			throw new NotFoundException("common.error.not-found");
////		} else {
////			String oldPwd = oAccount.get().getPassword();
////			if (!passwordEncoder.matches(request.getCurrentPassword(), oldPwd)) {
////				throw new NotFoundException("common.error.not-found");
////			}
////			String pwd = passwordEncoder.encode(request.getPasswordForm().getPassword());
////			accountRepository.updatePassword(pwd, oAccount.get().getId());
////			return "Change password account for " + oAccount.get().getDisplayName() + " is success";
////		}
////	}
////	
////	@Override
////	public String revokeToken(String token) throws NotFoundException {
////		String accountId = jwtService.getAccountId(token);
////		tokenService.revokeToken(accountId);
////		return "Logout Success!";
////	}
////	end authen
//	
////	 MAnage
////	@Override
////	public CustomAccountDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
////		// Kiểm tra xem user có tồn tại trong database không?
////		Optional<Account> account = accountRepository.findByAccountName(accountName);
////		if (!account.isPresent()) {
////			throw new UsernameNotFoundException("Account not found with name: " + accountName);
////		}
////		return new CustomAccountDetails(account.get().getId(), accountName, account.get().getDisplayName(),
////				account.get().getPassword(), !account.get().getIsDisable(), account.get().getIsDisable());
////	}
////
////	@Transactional
////	public CustomAccountDetails loadUserById(String id) {
////		Account account = accountRepository.findById(id)
////				.orElseThrow(() -> new UsernameNotFoundException("Account not found with id : " + id));
////		return new CustomAccountDetails(account.getId(), account.getAccountName(), account.getDisplayName(),
////				account.getPassword(), !account.getIsDisable(), account.getIsDisable());
////	}
//	
//	@Override
//	public Account findById(String id) throws LBRException {
//		Optional<Account> oAcc = accountRepository.findById(id);
//		if (!oAcc.isPresent()) {
//	        throw new LBRException(ErrorEnum.NOT_FOUND,"Account with id: "+id+" is unavailable!");
//	    }
//		return oAcc.get();
//	}
//	
//
//	@Override
//	public Account findByAccountName(String accountName) throws NotFoundException {
//		return accountRepository.findByAccountName(accountName).get();
//	}
//
//
//	@Override
//	public AccountDto findAccountByAccountName(String accountName) throws LBRException {
//		Optional<Account> account = accountRepository.findByAccountName(accountName);
//		if (!account.isPresent()) {
//			throw new LBRException(ErrorEnum.NOT_FOUND, null);
//		}
//		Account a = account.get();
//		AccountDto dto = new AccountDto();
//		dto.setAccountName(a.getAccountName());
//		dto.setId(a.getId());
//		dto.setIsDeleted(a.getIsDisable());
//		dto.setAccountType(a.getAccountType());
//		dto.setCreateDate(a.getCreateDate());
//		dto.setModifyDate(a.getModifyDate());
//		dto.setModifyAction(a.getModifyAction());
//		return dto;
//	}
//
//	@Override
//	public Account create(@Valid CreateAccountRequest accountRequest)
//			throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
//		Account u = new Account();
//		u.setDisplayName(accountRequest.getDisplayName());
//		u.setAccountName(accountRequest.getAccountName());
//		u.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
//		u.setAccountType(
//				accountRequest.getAccountType() == null || accountRequest.getAccountType() == AccountTypeEnum.ADMIN
//						? AccountTypeEnum.LIBRARIAN
//						: accountRequest.getAccountType());
//		u.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
//		return accountRepository.save(u);
//	}
//
//	@Override
//	public String deleteById(String id) throws LBRException {
//		Optional<Account> oUser = accountRepository.findById(id);
//		if (!oUser.isPresent()) {
//			throw new LBRException(ErrorEnum.NOT_FOUND, id);
//		} else {
//			accountRepository.deleteById(id);
//		}
//		return id;
//	}
//
//	@Override
//	public void setActive(String id, boolean isActive) throws LBRException {
//		int count = accountRepository.updateIsActive(!isActive, id);
//		if (count == 0) {
//			throw new LBRException(ErrorEnum.NOT_FOUND, id );
//		}
//	}
//
//	@Override
//	public Page<AccountDto> advanceSearch(@Valid SearchAccountRequest searchRequest, Pageable pageable) {
//		if (searchRequest != null) {
//			List<Specification<Account>> specList = getAdvanceSearchSpecList(searchRequest);
//			if (specList.size() > 0) {
//				Specification<Account> spec = specList.get(0);
//				for (int i = 1; i < specList.size(); i++) {
//					spec = spec.and(specList.get(i));
//				}
//				Page<Account> pBI = accountRepository.findAll(spec, pageable);
//				List<Account> ls = pBI.getContent();
//				List<AccountDto> dtos = new ArrayList<>();
//				for (Account bi : ls) {
//					AccountDto bookInfoDto = new AccountDto();
//					try {
//						PropertyUtils.copyProperties(bookInfoDto, bi);
//					} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//						e.printStackTrace();
//					}
//					dtos.add(bookInfoDto);
//				}
//				return new PageImpl<AccountDto>(dtos, pageable, pBI.getTotalElements());
//			}
//			return new PageImpl<>(null);
//		}
//		return findAllAccount(pageable);
//	}
//
//	private List<Specification<Account>> getAdvanceSearchSpecList(@Valid SearchAccountRequest s) {
//		List<Specification<Account>> specList = new ArrayList<>();
//		if (s.getAccountName() != null && !s.getAccountName().isEmpty()) {
//			specList.add(SearchUtil.like("name", "%" + s.getAccountName() + "%"));
//		}
//		if (s.getIsActive() != null) {
//			specList.add(SearchUtil.eq("isActive", s.getIsActive()));
//		}
//		if (s.getIds() != null && s.getIds().size() > 0) {
//			if (s.getIds().size() == 1) {
//				specList.add(SearchUtil.eq("Ids", s.getIds().get(0)));
//			} else {
//				specList.add(SearchUtil.in("Ids", s.getIds()));
//			}
//		}
//		if (s.getAccountType() != null) {
//			specList.add(SearchUtil.eq("accountType", s.getAccountType()));
//		}
//		return specList;
//	}
//
//
//
//	@Override
//	public void resetPassword(@Valid ResetPasswordRequest request) throws NotFoundException {
//		Optional<Account> oUser = accountRepository.findById(request.getAccountId());
//		if (!oUser.isPresent()) {
//			throw new NotFoundException("common.error.not-found");
//		} else {
//			// Update password
//			String pwd = passwordEncoder.encode(request.getNewPassword());
//			accountRepository.updatePassword(pwd, oUser.get().getId());
//		}
//	}
//
//
//
//	@Override
//	public Page<AccountDto> findAllAccount(Pageable pageable) {
//		 Page<Account> pB = accountRepository.findAll(pageable);
//		 List<Account> ls = pB.getContent();
//		 List<AccountDto> dtos = new ArrayList<>();
//			for (Account bi : ls) {
//				AccountDto bookDto = new AccountDto();
//				try {
//					PropertyUtils.copyProperties(bookDto, bi);
//				} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//					e.printStackTrace();
//				}
//				dtos.add(bookDto);
//			}
//			return new PageImpl<AccountDto>(dtos, pageable, pB.getTotalElements());
//	}
//
//	@Override
//	public AccountDto update(String id, @Valid PatchRequest<UpdateAccountRequest> request) throws LBRException {
//		Optional<Account> oBook = accountRepository.findById(id);
//		if (!oBook.isPresent()) {
//			throw new LBRException(ErrorEnum.NOT_FOUND, null);
//		} else {
//			try {
//				Account u = oBook.get();
//				for (String fieldName : request.getUpdateFields()) {
//					Object newValue = PropertyUtils.getProperty(request.getData(), fieldName);
//					// set value of the bean
//					PropertyUtils.setProperty(u, fieldName, newValue);
//				}
//				Account b = accountRepository.save(u);
//				AccountDto dto = new AccountDto();
//				PropertyUtils.copyProperties(dto, b);
//				return dto;
//			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//				throw new RuntimeException(e);
//			}
//		}
//	}
//
//}
