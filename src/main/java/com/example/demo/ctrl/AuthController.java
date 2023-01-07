//package com.example.demo.ctrl;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.dto.SuccessResponse;
//import com.example.demo.dto.UpdatePasswordRequest;
//import com.example.demo.exception.LBRException;
//import com.example.demo.service.AccountService;
//import com.example.demo.util.RequestUtil;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//
//@RestController
//@RequestMapping("/lbm/v1/account")
//@Tag(name = "Account Management Controller")
//public class AuthController {
//	@Autowired
//	private AccountService accountService;
//
////	@ApiOperation(value = "API đăng nhập")
////	@PostMapping("/login")
////	@ResponseBody
//////	@PermitAll
////	public SuccessResponse<?> login(@RequestHeader String Authorization, @RequestHeader String accountName)
////			throws Exception {
////		return RequestUtil.ok(accountService.generateJwtToken(Authorization, accountName));
////	}
//	
////    @ApiOperation(value = "API đổi mật khẩu")
////	@PostMapping("/changePassword")
////	@ResponseBody
//////	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
////	public SuccessResponse<?> changePassword(@Valid @RequestBody UpdatePasswordRequest changePasswordForm) throws NotFoundException, LBRException {
////		return RequestUtil.ok(accountService.updatePassword(changePasswordForm));
////	}
//    
////    @ApiOperation(value = "API xem thông tin tài khoản hiện tại")
////	@GetMapping("/me")
////	@ResponseBody
//////	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
////	public SuccessResponse<?> currentUser() {
////		CustomAccountDetails authUser = (CustomAccountDetails) SecurityContextHolder.getContext().getAuthentication()
////				.getPrincipal();
////		CurrentAccountResponse ret = new CurrentAccountResponse();
////		ret.setId(authUser.getId());
////		ret.setAccountName(authUser.getUsername());
////		ret.setDisplayName(authUser.getDisplayName());
////		return RequestUtil.ok(ret);
////	}
//    
////    @ApiOperation(value = "API đăng xuất")
////	@PostMapping("/logout")
////	@ResponseBody
//////	@PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
////	public SuccessResponse<?> logout(@RequestHeader String token)
////			throws Exception {
////		return RequestUtil.ok(accountService.revokeToken(token));
////	}
//}